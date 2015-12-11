// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.parse:
//            ManifestInfo, ParsePlugins, ParseFileUtils, ParseEventuallyQueue, 
//            ParseCorePlugins, ParseCommandCache, ParsePinningEventuallyQueue, PLog, 
//            ParseHttpClient, ParseRequest, ParseObject, OfflineStore, 
//            ParseFieldOperations, ParseKeyValueCache, GcmRegistrar, PushType, 
//            PushService, ParseFileController, ParseNetworkInterceptor, ParseConfig, 
//            ParseUser

public class Parse
{
    static interface ParseCallbacks
    {

        public abstract void onParseInitialized();
    }


    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_NONE = 0x7fffffff;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_WARNING = 5;
    private static final Object MUTEX = new Object();
    private static final Object MUTEX_CALLBACKS = new Object();
    private static final String PARSE_APPLICATION_ID = "com.parse.APPLICATION_ID";
    private static final String PARSE_CLIENT_KEY = "com.parse.CLIENT_KEY";
    private static Set callbacks = new HashSet();
    static ParseEventuallyQueue eventuallyQueue = null;
    private static List interceptors;
    private static boolean isLocalDatastoreEnabled;
    private static OfflineStore offlineStore;

    private Parse()
    {
        throw new AssertionError();
    }

    static void addParseNetworkInterceptor(ParseNetworkInterceptor parsenetworkinterceptor)
    {
        if (isInitialized())
        {
            throw new IllegalStateException("`Parse#addParseNetworkInterceptor(ParseNetworkInterceptor)` must be invoked before `Parse#initialize(Context)`");
        }
        if (interceptors == null)
        {
            interceptors = new ArrayList();
        }
        interceptors.add(parsenetworkinterceptor);
    }

    private static boolean allParsePushIntentReceiversInternal()
    {
        for (Iterator iterator = ManifestInfo.getIntentReceivers(new String[] {
    "com.parse.push.intent.RECEIVE", "com.parse.push.intent.DELETE", "com.parse.push.intent.OPEN"
}).iterator(); iterator.hasNext();)
        {
            if (((ResolveInfo)iterator.next()).activityInfo.exported)
            {
                return false;
            }
        }

        return true;
    }

    static void checkCacheApplicationId()
    {
        Object obj = MUTEX;
        obj;
        JVM INSTR monitorenter ;
        String s = ParsePlugins.get().applicationId();
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        boolean flag;
        obj1 = getParseCacheDir();
        obj2 = new File(((File) (obj1)), "applicationId");
        flag = ((File) (obj2)).exists();
        if (!flag) goto _L4; else goto _L3
_L3:
        flag = false;
        boolean flag1;
        obj2 = new RandomAccessFile(((File) (obj2)), "r");
        byte abyte0[] = new byte[(int)((RandomAccessFile) (obj2)).length()];
        ((RandomAccessFile) (obj2)).readFully(abyte0);
        ((RandomAccessFile) (obj2)).close();
        flag1 = (new String(abyte0, "UTF-8")).equals(s);
        flag = flag1;
_L7:
        if (flag) goto _L4; else goto _L5
_L5:
        Exception exception;
        try
        {
            ParseFileUtils.deleteDirectory(((File) (obj1)));
        }
        catch (IOException ioexception1) { }
_L4:
        obj1 = new File(((File) (obj1)), "applicationId");
        try
        {
            obj1 = new FileOutputStream(((File) (obj1)));
            ((FileOutputStream) (obj1)).write(s.getBytes("UTF-8"));
            ((FileOutputStream) (obj1)).close();
        }
        catch (FileNotFoundException filenotfoundexception) { }
        catch (UnsupportedEncodingException unsupportedencodingexception) { }
        catch (IOException ioexception) { }
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj3;
        obj3;
        continue; /* Loop/switch isn't completed */
        obj3;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static void checkContext()
    {
        if (ParsePlugins.Android.get().applicationContext() == null)
        {
            throw new RuntimeException("applicationContext is null. You must call Parse.initialize(Context) before using the Parse library.");
        } else
        {
            return;
        }
    }

    static void checkInit()
    {
        if (ParsePlugins.get() == null)
        {
            throw new RuntimeException("You must call Parse.initialize(Context) before using the Parse library.");
        }
        if (ParsePlugins.get().applicationId() == null)
        {
            throw new RuntimeException("applicationId is null. You must call Parse.initialize(Context) before using the Parse library.");
        }
        if (ParsePlugins.get().clientKey() == null)
        {
            throw new RuntimeException("clientKey is null. You must call Parse.initialize(Context) before using the Parse library.");
        } else
        {
            return;
        }
    }

    private static ParseCallbacks[] collectParseCallbacks()
    {
label0:
        {
            synchronized (MUTEX_CALLBACKS)
            {
                if (callbacks != null)
                {
                    break label0;
                }
            }
            return null;
        }
        ParseCallbacks aparsecallbacks1[] = new ParseCallbacks[callbacks.size()];
        ParseCallbacks aparsecallbacks[] = aparsecallbacks1;
        if (callbacks.size() > 0)
        {
            aparsecallbacks = (ParseCallbacks[])callbacks.toArray(aparsecallbacks1);
        }
        obj;
        JVM INSTR monitorexit ;
        return aparsecallbacks;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void destroy()
    {
        ParseEventuallyQueue parseeventuallyqueue;
        synchronized (MUTEX)
        {
            parseeventuallyqueue = eventuallyQueue;
            eventuallyQueue = null;
        }
        if (parseeventuallyqueue != null)
        {
            parseeventuallyqueue.onDestroy();
        }
        ParseCorePlugins.getInstance().reset();
        ParsePlugins.reset();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void disableLocalDatastore()
    {
        setLocalDatastore(null);
    }

    private static void dispatchOnParseInitialized()
    {
        ParseCallbacks aparsecallbacks[] = collectParseCallbacks();
        if (aparsecallbacks != null)
        {
            int j = aparsecallbacks.length;
            for (int i = 0; i < j; i++)
            {
                aparsecallbacks[i].onParseInitialized();
            }

        }
    }

    public static void enableLocalDatastore(Context context)
    {
        if (isInitialized())
        {
            throw new IllegalStateException("`Parse#enableLocalDatastore(Context)` must be invoked before `Parse#initialize(Context)`");
        } else
        {
            isLocalDatastoreEnabled = true;
            return;
        }
    }

    static Context getApplicationContext()
    {
        checkContext();
        return ParsePlugins.Android.get().applicationContext();
    }

    static ParseEventuallyQueue getEventuallyQueue()
    {
        Context context = ParsePlugins.Android.get().applicationContext();
        Object obj1 = MUTEX;
        obj1;
        JVM INSTR monitorenter ;
        boolean flag = isLocalDatastoreEnabled();
        if (eventuallyQueue == null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        if (eventuallyQueue instanceof ParseCommandCache) goto _L2; else goto _L4
_L4:
        if (flag) goto _L6; else goto _L5
_L5:
        if (!(eventuallyQueue instanceof ParsePinningEventuallyQueue)) goto _L6; else goto _L2
_L2:
        checkContext();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        Object obj = new ParsePinningEventuallyQueue(context);
_L8:
        eventuallyQueue = ((ParseEventuallyQueue) (obj));
        if (!flag) goto _L6; else goto _L7
_L7:
        if (ParseCommandCache.getPendingCount() > 0)
        {
            new ParseCommandCache(context);
        }
_L6:
        obj = eventuallyQueue;
        obj1;
        JVM INSTR monitorexit ;
        return ((ParseEventuallyQueue) (obj));
        obj = new ParseCommandCache(context);
          goto _L8
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static OfflineStore getLocalDatastore()
    {
        return offlineStore;
    }

    public static int getLogLevel()
    {
        return PLog.getLogLevel();
    }

    static File getParseCacheDir()
    {
        return ParsePlugins.get().getCacheDir();
    }

    static File getParseCacheDir(String s)
    {
        synchronized (MUTEX)
        {
            s = new File(getParseCacheDir(), s);
            if (!s.exists())
            {
                s.mkdirs();
            }
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static File getParseDir()
    {
        return ParsePlugins.get().getParseDir();
    }

    static File getParseFilesDir()
    {
        return ParsePlugins.get().getFilesDir();
    }

    static File getParseFilesDir(String s)
    {
        synchronized (MUTEX)
        {
            s = new File(getParseFilesDir(), s);
            if (!s.exists())
            {
                s.mkdirs();
            }
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static boolean hasPermission(String s)
    {
        return getApplicationContext().checkCallingOrSelfPermission(s) == 0;
    }

    public static void initialize(Context context)
    {
        Object obj = ManifestInfo.getApplicationMetadata(context.getApplicationContext());
        if (obj != null)
        {
            String s = ((Bundle) (obj)).getString("com.parse.APPLICATION_ID");
            obj = ((Bundle) (obj)).getString("com.parse.CLIENT_KEY");
            if (s == null)
            {
                throw new RuntimeException("ApplicationId not defined. You must provide ApplicationId in AndroidManifest.xml.\n<meta-data\n    android:name=\"com.parse.APPLICATION_ID\"\n    android:value=\"<Your Application Id>\" />");
            }
            if (obj == null)
            {
                throw new RuntimeException("ClientKey not defined. You must provide ClientKey in AndroidManifest.xml.\n<meta-data\n    android:name=\"com.parse.CLIENT_KEY\"\n    android:value=\"<Your Client Key>\" />");
            } else
            {
                initialize(context, s, ((String) (obj)));
                return;
            }
        } else
        {
            throw new RuntimeException("Can't get Application Metadata");
        }
    }

    public static void initialize(Context context, String s, String s1)
    {
        ParsePlugins.Android.initialize(context, s, s1);
        s = context.getApplicationContext();
        ParseHttpClient.setKeepAlive(true);
        ParseHttpClient.setMaxConnections(20);
        ParseRequest.setDefaultClient(ParsePlugins.get().restClient());
        if (interceptors != null)
        {
            initializeParseHttpClientsWithParseNetworkInterceptors();
        }
        ParseObject.registerParseSubclasses();
        if (isLocalDatastoreEnabled())
        {
            offlineStore = new OfflineStore(context);
        } else
        {
            ParseKeyValueCache.initialize(context);
        }
        checkCacheApplicationId();
        (new Thread("Parse.initialize Disk Check & Starting Command Cache") {

            public void run()
            {
                Parse.getEventuallyQueue();
            }

        }).start();
        ParseFieldOperations.registerDefaultDecoders();
        if (!allParsePushIntentReceiversInternal())
        {
            throw new SecurityException("To prevent external tampering to your app's notifications, all receivers registered to handle the following actions must have their exported attributes set to false: com.parse.push.intent.RECEIVE, com.parse.push.intent.OPEN, com.parse.push.intent.DELETE");
        }
        GcmRegistrar.getInstance().registerAsync().b(new ct() {

            public cu then(cu cu1)
                throws Exception
            {
                return ParseUser.getCurrentUserAsync().j();
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

        }).a(new ct() {

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
                throws Exception
            {
                ParseConfig.getCurrentConfig();
                return null;
            }

        }, cu.a);
        if (ManifestInfo.getPushUsesBroadcastReceivers() && ManifestInfo.getPushType() == PushType.PPNS)
        {
            PushService.startServiceIfRequired(s);
        }
        dispatchOnParseInitialized();
        synchronized (MUTEX_CALLBACKS)
        {
            callbacks = null;
        }
        return;
        s;
        context;
        JVM INSTR monitorexit ;
        throw s;
    }

    private static void initializeParseHttpClientsWithParseNetworkInterceptors()
    {
        if (interceptors == null)
        {
            return;
        }
        Object obj = new ArrayList();
        ((List) (obj)).add(ParsePlugins.get().restClient());
        ((List) (obj)).add(ParseCorePlugins.getInstance().getFileController().awsClient());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            ParseHttpClient parsehttpclient = (ParseHttpClient)((Iterator) (obj)).next();
            Iterator iterator = interceptors.iterator();
            while (iterator.hasNext()) 
            {
                parsehttpclient.addExternalInterceptor((ParseNetworkInterceptor)iterator.next());
            }
        }

        interceptors = null;
    }

    static boolean isInitialized()
    {
        return ParsePlugins.get() != null;
    }

    static boolean isLocalDatastoreEnabled()
    {
        return isLocalDatastoreEnabled;
    }

    static void registerParseCallbacks(ParseCallbacks parsecallbacks)
    {
label0:
        {
            if (isInitialized())
            {
                throw new IllegalStateException("You must register callbacks before Parse.initialize(Context)");
            }
            synchronized (MUTEX_CALLBACKS)
            {
                if (callbacks != null)
                {
                    break label0;
                }
            }
            return;
        }
        callbacks.add(parsecallbacks);
        obj;
        JVM INSTR monitorexit ;
        return;
        parsecallbacks;
        obj;
        JVM INSTR monitorexit ;
        throw parsecallbacks;
    }

    static void removeParseNetworkInterceptor(ParseNetworkInterceptor parsenetworkinterceptor)
    {
        if (isInitialized())
        {
            throw new IllegalStateException("`Parse#addParseNetworkInterceptor(ParseNetworkInterceptor)` must be invoked before `Parse#initialize(Context)`");
        }
        if (interceptors == null)
        {
            return;
        } else
        {
            interceptors.remove(parsenetworkinterceptor);
            return;
        }
    }

    static void requirePermission(String s)
    {
        if (!hasPermission(s))
        {
            throw new IllegalStateException((new StringBuilder()).append("To use this functionality, add this to your AndroidManifest.xml:\n<uses-permission android:name=\"").append(s).append("\" />").toString());
        } else
        {
            return;
        }
    }

    static void setLocalDatastore(OfflineStore offlinestore)
    {
        boolean flag;
        if (offlinestore != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isLocalDatastoreEnabled = flag;
        offlineStore = offlinestore;
    }

    public static void setLogLevel(int i)
    {
        PLog.setLogLevel(i);
    }

    static void unregisterParseCallbacks(ParseCallbacks parsecallbacks)
    {
label0:
        {
            synchronized (MUTEX_CALLBACKS)
            {
                if (callbacks != null)
                {
                    break label0;
                }
            }
            return;
        }
        callbacks.remove(parsecallbacks);
        obj;
        JVM INSTR monitorexit ;
        return;
        parsecallbacks;
        obj;
        JVM INSTR monitorexit ;
        throw parsecallbacks;
    }

}
