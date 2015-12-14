// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import bolts.Task;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            Synchronizer, ParseException, ParseCommand, Parse, 
//            ParseInstallation, ParseEventuallyQueue, ParseObject, PushRouter, 
//            ParseUser, PushService, PushConnection, PushType, 
//            ManifestInfo, ParseNotificationManager

class ParseTestUtils
{
    public static interface PushRoutedListener
    {

        public abstract void onPushRouted(JSONObject jsonobject);
    }

    static class StateTransition
    {

        public final PushConnection connection;
        public final PushConnection.State fromState;
        public final long timestamp;
        public final PushConnection.State toState;

        public String toString()
        {
            return (new StringBuilder()).append(timestamp).append(" ms: ").append(fromState).append(" to ").append(toState).toString();
        }

        StateTransition(long l, PushConnection pushconnection, PushConnection.State state, PushConnection.State state1)
        {
            timestamp = l;
            connection = pushconnection;
            fromState = state;
            toState = state1;
        }
    }

    static class StateTransitionListener
        implements PushConnection.StateTransitionListener
    {

        private ArrayList transitions;

        public List getTransitions()
        {
            this;
            JVM INSTR monitorenter ;
            List list = Collections.unmodifiableList(transitions);
            this;
            JVM INSTR monitorexit ;
            return list;
            Exception exception;
            exception;
            throw exception;
        }

        public void onStateChange(PushConnection pushconnection, PushConnection.State state, PushConnection.State state1)
        {
            this;
            JVM INSTR monitorenter ;
            transitions.add(new StateTransition(SystemClock.elapsedRealtime(), pushconnection, state, state1));
            if (state1 == null) goto _L2; else goto _L1
_L1:
            if (ParseTestUtils.awaitStartSemaphore == null || !(state1 instanceof PushConnection.ConnectState)) goto _L2; else goto _L3
_L3:
            ParseTestUtils.awaitStartSemaphore.release();
_L5:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            if (state1 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (ParseTestUtils.awaitStopSemaphore != null && (state1 instanceof PushConnection.StoppedState))
            {
                ParseTestUtils.awaitStopSemaphore.release();
            }
            if (true) goto _L5; else goto _L4
_L4:
            pushconnection;
            throw pushconnection;
        }

        StateTransitionListener()
        {
            transitions = new ArrayList();
        }
    }


    private static final String TAG = "com.parse.ParseTestUtils";
    private static final Object TEST_SERVER_LOCK = new Object();
    private static volatile Semaphore awaitStartSemaphore;
    private static volatile Semaphore awaitStopSemaphore;
    private static PushRoutedListener globalListener;
    private static StateTransitionListener listener;
    static final AtomicBoolean strictModeEnabled = new AtomicBoolean(false);
    private static Synchronizer synchronizer;
    private static String testServer;
    private static int totalBroadcastReceiverInvocations = 0;

    ParseTestUtils()
    {
    }

    public static void assertFinishes()
    {
        synchronizer.assertFinishes();
    }

    public static boolean awaitConnectionStarted()
        throws Exception
    {
        return awaitStartSemaphore.tryAcquire(5L, TimeUnit.SECONDS);
    }

    public static boolean awaitConnectionStopped()
        throws Exception
    {
        if (awaitStopSemaphore == null)
        {
            awaitStopSemaphore = new Semaphore(0);
        }
        return awaitStopSemaphore.tryAcquire(5L, TimeUnit.SECONDS);
    }

    public static void clearApp()
    {
        ParseCommand parsecommand = new ParseCommand("clear_app", null);
        try
        {
            Parse.waitForTask(parsecommand.executeAsync());
            return;
        }
        catch (ParseException parseexception)
        {
            throw new RuntimeException(parseexception.getMessage());
        }
    }

    public static void clearCurrentInstallationFromMemory()
    {
        ParseInstallation.currentInstallation = null;
    }

    public static void clearFiles()
    {
        recursiveDelete(Parse.getParseDir());
        recursiveDelete(Parse.getKeyValueCacheDir());
        if (Parse.eventuallyQueue != null)
        {
            Parse.eventuallyQueue.pause();
            Parse.eventuallyQueue = null;
        }
    }

    public static int commandCacheUnexpectedEvents()
    {
        return Parse.getEventuallyQueue().getTestHelper().unexpectedEvents();
    }

    public static void deleteCurrentInstallation()
    {
        try
        {
            ParseInstallation.getCurrentInstallation().delete();
            return;
        }
        catch (ParseException parseexception)
        {
            return;
        }
    }

    public static void disconnectCommandCache()
    {
        Parse.getEventuallyQueue().setConnected(false);
    }

    public static void finish()
    {
        synchronizer.finish();
    }

    public static String getInstallationId(Context context)
    {
        return ParseInstallation.getCurrentInstallation().getInstallationId();
    }

    public static ParseObject getObjectFromDisk(Context context, String s)
    {
        return ParseObject.getFromDisk(context, s);
    }

    static File getParseDir(Context context)
    {
        return context.getDir("Parse", 0);
    }

    public static List getPushConnectionRetryDelays()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = getPushConnectionStateTransitions().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            StateTransition statetransition = (StateTransition)iterator.next();
            if (statetransition.fromState instanceof PushConnection.WaitRetryState)
            {
                arraylist.add(Long.valueOf(((PushConnection.WaitRetryState)statetransition.fromState).getDelay()));
            }
        } while (true);
        return arraylist;
    }

    public static List getPushConnectionStateTransitions()
    {
        return listener.getTransitions();
    }

    public static JSONObject getPushRequestJSON()
    {
        Task task = PushRouter.getPushRequestJSONAsync();
        try
        {
            task.waitForCompletion();
        }
        catch (InterruptedException interruptedexception)
        {
            return null;
        }
        return (JSONObject)task.getResult();
    }

    public static JSONObject getSerializedPushStateJSON()
    {
        return Parse.getDiskObject(Parse.applicationContext, "pushState");
    }

    public static String getTestServer(Context context)
    {
        if (testServer != null) goto _L2; else goto _L1
_L1:
        Object obj = TEST_SERVER_LOCK;
        obj;
        JVM INSTR monitorenter ;
        String s = testServer;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        testServer = (new BufferedReader(new InputStreamReader(context.getAssets().open("server.config")))).readLine();
_L3:
        obj;
        JVM INSTR monitorexit ;
_L2:
        return testServer;
        context;
        if (!Build.PRODUCT.contains("vbox"))
        {
            break MISSING_BLOCK_LABEL_83;
        }
        testServer = "http://192.168.56.1:3000";
          goto _L3
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
label0:
        {
            if (!Build.PRODUCT.contains("sdk") && !Build.PRODUCT.contains("full_x86"))
            {
                break label0;
            }
            testServer = "http://10.0.2.2:3000";
        }
          goto _L3
        testServer = "http://localhost:3000";
          goto _L3
    }

    public static ParseUser getUserObjectFromDisk(Context context, String s)
    {
        return (ParseUser)ParseObject.getFromDisk(context, s);
    }

    public static void initSynchronizer()
    {
        synchronizer = new Synchronizer();
    }

    public static Set keySet(ParseObject parseobject)
    {
        return parseobject.keySet();
    }

    public static ServerSocket mockPushServer()
    {
        ServerSocket serversocket;
        InetSocketAddress inetsocketaddress;
        try
        {
            serversocket = new ServerSocket(0);
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception.getMessage());
        }
        inetsocketaddress = (InetSocketAddress)serversocket.getLocalSocketAddress();
        PushService.useServer(inetsocketaddress.getHostName(), inetsocketaddress.getPort());
        Parse.logI("com.parse.ParseTestUtils", (new StringBuilder()).append("running mockPushServer on port ").append(inetsocketaddress).toString());
        return serversocket;
    }

    public static void mockV8Client()
    {
        ParseCommand parsecommand = new ParseCommand("mock_v8_client", null);
        try
        {
            Parse.waitForTask(parsecommand.executeAsync());
            return;
        }
        catch (ParseException parseexception)
        {
            throw new RuntimeException(parseexception);
        }
    }

    public static int numKeyValueCacheFiles()
    {
        return Parse.getKeyValueCacheDir().listFiles().length;
    }

    public static Set pushRoutes(Context context)
    {
        context = PushRouter.getSubscriptionsAsync(false);
        try
        {
            context.waitForCompletion();
        }
        catch (InterruptedException interruptedexception) { }
        return (Set)context.getResult();
    }

    public static void reconnectCommandCache()
    {
        Parse.getEventuallyQueue().setConnected(true);
    }

    public static void recursiveDelete(File file)
    {
        if (!file.exists())
        {
            return;
        }
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                recursiveDelete(afile[i]);
            }

        }
        file.delete();
    }

    public static void reloadPushRouter()
    {
        PushRouter.reloadFromDiskAsync(false);
    }

    public static void resetAwaitConnectionStarted()
    {
        awaitStartSemaphore = new Semaphore(0);
    }

    public static void resetAwaitConnectionStopped()
    {
        awaitStopSemaphore = new Semaphore(0);
    }

    public static void resetCommandCache()
    {
        ParseEventuallyQueue parseeventuallyqueue = Parse.getEventuallyQueue();
        ParseEventuallyQueue.TestHelper testhelper = parseeventuallyqueue.getTestHelper();
        parseeventuallyqueue.clear();
        testhelper.clear();
    }

    public static void saveObjectToDisk(ParseObject parseobject, Context context, String s)
    {
        parseobject.saveToDisk(context, s);
    }

    public static void saveStringToDisk(String s, Context context, String s1)
    {
        context = new File(getParseDir(context), s1);
        try
        {
            context = new FileOutputStream(context);
            context.write(s.getBytes("UTF-8"));
            context.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public static void setCommandInitialDelay(long l)
    {
        ParseCommand.setDefaultInitialRetryDelay(l);
    }

    public static void setMaxKeyValueCacheBytes(int i)
    {
        Parse.maxKeyValueCacheBytes = i;
    }

    public static void setMaxKeyValueCacheFiles(int i)
    {
        Parse.maxKeyValueCacheFiles = i;
    }

    public static int setPushHistoryLength(int i)
    {
        int j = PushRouter.MAX_HISTORY_LENGTH;
        PushRouter.MAX_HISTORY_LENGTH = i;
        return j;
    }

    public static void setPushRoutedListener(PushRoutedListener pushroutedlistener)
    {
        com/parse/ParseTestUtils;
        JVM INSTR monitorenter ;
        globalListener = pushroutedlistener;
        com/parse/ParseTestUtils;
        JVM INSTR monitorexit ;
        return;
        pushroutedlistener;
        throw pushroutedlistener;
    }

    public static void setRetryDelayEnabled(boolean flag)
    {
        PushConnection.ENABLE_RETRY_DELAY = flag;
    }

    public static void setStrictModeEnabledForMainThread(boolean flag)
    {
        AtomicBoolean atomicboolean = strictModeEnabled;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (atomicboolean.compareAndSet(flag1, flag))
        {
            Semaphore semaphore = new Semaphore(0);
            (new Handler(Looper.getMainLooper())).post(new Runnable(flag, semaphore) {

                final Semaphore val$done;
                final boolean val$enabled;

                public void run()
                {
                    ParseTestUtils.setStrictModeEnabledForThisThread(enabled);
                    done.release();
                }

            
            {
                enabled = flag;
                done = semaphore;
                super();
            }
            });
            semaphore.acquireUninterruptibly();
        }
    }

    public static void setStrictModeEnabledForThisThread(boolean flag)
    {
        Class class1;
        Class class2;
        Object obj;
        Object obj1;
        try
        {
            obj = Thread.currentThread().getContextClassLoader();
            class1 = Class.forName("android.os.StrictMode", true, ((ClassLoader) (obj)));
        }
        catch (Exception exception)
        {
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        class2 = Class.forName("android.os.StrictMode$ThreadPolicy", true, ((ClassLoader) (obj)));
        obj = Class.forName("android.os.StrictMode$ThreadPolicy$Builder", true, ((ClassLoader) (obj)));
        obj1 = ((Class) (obj)).getConstructor(new Class[0]).newInstance(new Object[0]);
        obj1 = ((Class) (obj)).getMethod("detectNetwork", new Class[0]).invoke(obj1, new Object[0]);
        obj1 = ((Class) (obj)).getMethod("penaltyDeath", new Class[0]).invoke(obj1, new Object[0]);
        obj = ((Class) (obj)).getMethod("build", new Class[0]).invoke(obj1, new Object[0]);
        class1.getMethod("setThreadPolicy", new Class[] {
            class2
        }).invoke(class1, new Object[] {
            obj
        });
        return;
        class1.getMethod("enableDefaults", new Class[0]).invoke(class1, new Object[0]);
        return;
    }

    public static void setTestServer(String s)
    {
        synchronized (TEST_SERVER_LOCK)
        {
            testServer = s;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void setUpPushTest(Context context)
    {
        ManifestInfo.setPushType(PushType.PPNS);
        awaitStartSemaphore = null;
        awaitStopSemaphore = null;
        listener = new StateTransitionListener();
        PushConnection.setStateTransitionListener(listener);
        ParseNotificationManager.getInstance().setShouldShowNotifications(false);
        useTestServer(context);
        ParseInstallation.clearCurrentInstallationFromDisk(context);
        PushRouter.reloadFromDiskAsync(true);
        initSynchronizer();
        totalBroadcastReceiverInvocations = 0;
        PushRouter.setGlobalPushListener(new PushRouter.PushListener() {

            public void onPushHandled(JSONObject jsonobject, PushRouter.HandlePushResult handlepushresult)
            {
                if (handlepushresult != PushRouter.HandlePushResult.INVOKED_PARSE_PUSH_BROADCAST_RECEIVER && handlepushresult != PushRouter.HandlePushResult.SHOW_NOTIFICATION && handlepushresult != PushRouter.HandlePushResult.SHOW_NOTIFICATION_AND_BROADCAST_INTENT)
                {
                    break MISSING_BLOCK_LABEL_46;
                }
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        });
    }

    public static void start(int i)
    {
        synchronizer.start(i);
    }

    public static void startServiceIfRequired(Context context)
    {
        PushService.startServiceIfRequired(context);
    }

    public static void tearDownPushTest(Context context)
    {
        PushConnection.setStateTransitionListener(null);
        PushConnection.KEEP_ALIVE_INTERVAL = 0xdbba0L;
        PushConnection.ENABLE_RETRY_DELAY = true;
        ParseNotificationManager.getInstance().setShouldShowNotifications(true);
        clearFiles();
        ParseInstallation.clearCurrentInstallationFromDisk(context);
        PushRouter.reloadFromDiskAsync(true);
        setPushRoutedListener(null);
        awaitStartSemaphore = null;
        awaitStopSemaphore = null;
    }

    public static int totalBroadcastReceiverInvocations()
    {
        return totalBroadcastReceiverInvocations;
    }

    public static void unmockV8Client()
    {
        ParseCommand parsecommand = new ParseCommand("unmock_v8_client", null);
        try
        {
            Parse.waitForTask(parsecommand.executeAsync());
            return;
        }
        catch (ParseException parseexception)
        {
            throw new RuntimeException(parseexception);
        }
    }

    public static String useBadServerPort()
    {
        return useBadServerPort(ParseObject.server);
    }

    public static String useBadServerPort(String s)
    {
        String s1 = "http://10.0.2.2:6000";
        try
        {
            s = new URL(s);
            s = (new StringBuilder()).append(s.getProtocol()).append("://").append(s.getHost()).append(":").append(s.getPort() + 999).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s1;
        }
        return useServer(s);
    }

    public static void useDevPushServer()
    {
        PushService.useServer("10.0.2.2", 8253);
    }

    public static String useInvalidServer()
    {
        return useServer("http://invalid.server:3000");
    }

    public static String useServer(String s)
    {
        String s1 = ParseObject.server;
        ParseObject.server = s;
        return s1;
    }

    public static String useTestServer(Context context)
    {
        return useServer(getTestServer(context));
    }

    public static boolean waitForCommandCacheEnqueue()
    {
        return Parse.getEventuallyQueue().getTestHelper().waitFor(3);
    }

    public static boolean waitForCommandCacheFailure()
    {
        return Parse.getEventuallyQueue().getTestHelper().waitFor(2);
    }

    public static boolean waitForCommandCacheSuccess()
    {
        return Parse.getEventuallyQueue().getTestHelper().waitFor(1) && Parse.getEventuallyQueue().getTestHelper().waitFor(5);
    }





/*
    static int access$208()
    {
        int i = totalBroadcastReceiverInvocations;
        totalBroadcastReceiverInvocations = i + 1;
        return i;
    }

*/

}
