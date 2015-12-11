// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.Intent;
import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseEventuallyQueue, Parse, ConnectivityNotifier, ParseObject, 
//            ParseRESTCommand, ParseFileUtils, ParseException, ParseTaskUtils, 
//            LocalIdManager

class ParseCommandCache extends ParseEventuallyQueue
{

    private static final String TAG = "com.parse.ParseCommandCache";
    private static int filenameCounter = 0;
    private static final Object lock = new Object();
    private File cachePath;
    ConnectivityNotifier.ConnectivityListener listener;
    private Logger log;
    private int maxCacheSizeBytes;
    ConnectivityNotifier notifier;
    private HashMap pendingTasks;
    private boolean running;
    private final Object runningLock = new Object();
    private boolean shouldStop;
    private int timeoutMaxRetries;
    private double timeoutRetryWaitSeconds;
    private boolean unprocessedCommandsExist;

    public ParseCommandCache(Context context)
    {
        timeoutMaxRetries = 5;
        timeoutRetryWaitSeconds = 600D;
        maxCacheSizeBytes = 0xa00000;
        pendingTasks = new HashMap();
        listener = new ConnectivityNotifier.ConnectivityListener() {

            final ParseCommandCache this$0;

            public void networkConnectivityStatusChanged(Context context1, Intent intent)
            {
                if (intent.getBooleanExtra("noConnectivity", false))
                {
                    setConnected(false);
                    return;
                } else
                {
                    setConnected(ConnectivityNotifier.isConnected(context1));
                    return;
                }
            }

            
            {
                this$0 = ParseCommandCache.this;
                super();
            }
        };
        setConnected(false);
        shouldStop = false;
        running = false;
        log = Logger.getLogger("com.parse.ParseCommandCache");
        cachePath = getCacheDir();
        if (!Parse.hasPermission("android.permission.ACCESS_NETWORK_STATE"))
        {
            return;
        } else
        {
            setConnected(ConnectivityNotifier.isConnected(context));
            notifier = ConnectivityNotifier.getNotifier(context);
            notifier.addListener(listener);
            resume();
            return;
        }
    }

    private cu enqueueEventuallyAsync(ParseRESTCommand parserestcommand, boolean flag, ParseObject parseobject)
    {
        android.support.v7.cu.a a;
        Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
        a = cu.a();
        if (parseobject == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        if (parseobject.getObjectId() == null)
        {
            parserestcommand.setLocalId(parseobject.getOrCreateLocalId());
        }
        parseobject = parserestcommand.toJSONObject();
        if (parseobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        parseobject = parseobject.toString();
_L1:
        byte abyte0[] = parseobject.getBytes("UTF-8");
        if (abyte0.length > maxCacheSizeBytes)
        {
            if (5 >= Parse.getLogLevel())
            {
                log.warning("Unable to save command for later because it's too big.");
            }
            notifyTestHelper(4);
            return cu.a(null);
        }
        break MISSING_BLOCK_LABEL_132;
        try
        {
            parseobject = JSONObjectInstrumentation.toString((JSONObject)parseobject);
        }
        // Misplaced declaration of an exception variable
        catch (ParseRESTCommand parserestcommand)
        {
            if (5 >= Parse.getLogLevel())
            {
                log.log(Level.WARNING, "UTF-8 isn't supported.  This shouldn't happen.", parserestcommand);
            }
            notifyTestHelper(4);
            return cu.a(null);
        }
          goto _L1
        Object obj1 = lock;
        obj1;
        JVM INSTR monitorenter ;
        parseobject = cachePath.list();
        if (parseobject == null) goto _L3; else goto _L2
_L2:
        int k;
        Arrays.sort(parseobject);
        k = parseobject.length;
        int i;
        int j;
        i = 0;
        j = 0;
_L5:
        Object obj;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = parseobject[i];
        j += (int)(new File(cachePath, ((String) (obj)))).length();
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        j = abyte0.length + j;
        if (j <= maxCacheSizeBytes) goto _L3; else goto _L6
_L6:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        if (5 >= Parse.getLogLevel())
        {
            log.warning("Unable to save command for later because storage is full.");
        }
        parserestcommand = cu.a(null);
        lock.notifyAll();
        obj1;
        JVM INSTR monitorexit ;
        return parserestcommand;
        parserestcommand;
        obj1;
        JVM INSTR monitorexit ;
        throw parserestcommand;
        if (5 >= Parse.getLogLevel())
        {
            log.warning("Deleting old commands to make room in command cache.");
        }
          goto _L7
_L11:
        if (j <= maxCacheSizeBytes || i >= parseobject.length) goto _L3; else goto _L8
_L8:
        obj = new File(cachePath, parseobject[i]);
        k = (int)((File) (obj)).length();
        removeFile(((File) (obj)));
        j -= k;
        i++;
        continue; /* Loop/switch isn't completed */
_L3:
        String s;
        parseobject = Long.toHexString(System.currentTimeMillis());
        if (parseobject.length() < 16)
        {
            char ac[] = new char[16 - parseobject.length()];
            Arrays.fill(ac, '0');
            parseobject = (new StringBuilder()).append(new String(ac)).append(parseobject).toString();
        }
        i = filenameCounter;
        filenameCounter = i + 1;
        s = Integer.toHexString(i);
        ac = s;
        if (s.length() < 8)
        {
            ac = new char[8 - s.length()];
            Arrays.fill(ac, '0');
            ac = (new StringBuilder()).append(new String(ac)).append(s).toString();
        }
        parseobject = File.createTempFile((new StringBuilder()).append("CachedCommand_").append(parseobject).append("_").append(ac).append("_").toString(), "", cachePath);
        pendingTasks.put(parseobject, a);
        parserestcommand.retainLocalIds();
        ParseFileUtils.writeByteArrayToFile(parseobject, abyte0);
        notifyTestHelper(3);
        unprocessedCommandsExist = true;
        lock.notifyAll();
_L9:
        obj1;
        JVM INSTR monitorexit ;
        return a.a();
        parserestcommand;
        if (5 >= Parse.getLogLevel())
        {
            log.log(Level.WARNING, "Unable to save command for later.", parserestcommand);
        }
        lock.notifyAll();
          goto _L9
        parserestcommand;
        lock.notifyAll();
        throw parserestcommand;
_L7:
        i = 0;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private static File getCacheDir()
    {
        File file = new File(Parse.getParseDir(), "CommandCache");
        file.mkdirs();
        return file;
    }

    public static int getPendingCount()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        String as[] = getCacheDir().list();
        if (as != null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        obj;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = as.length;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void maybeRunAllCommandsNow(int i)
    {
label0:
        {
            synchronized (lock)
            {
                unprocessedCommandsExist = false;
                if (isConnected())
                {
                    break label0;
                }
            }
            return;
        }
        String as[] = cachePath.list();
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        if (as.length != 0)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        int k;
        Arrays.sort(as);
        k = as.length;
        int j = 0;
_L5:
        if (j >= k) goto _L2; else goto _L1
_L1:
        final Object tcs = as[j];
        File file = new File(cachePath, ((String) (tcs)));
        final Object command = ParseFileUtils.readFileToJSONObject(file);
        if (!pendingTasks.containsKey(file))
        {
            break MISSING_BLOCK_LABEL_595;
        }
        tcs = (android.support.v7.cu.a)pendingTasks.get(file);
_L12:
        command = commandFromJSON(((JSONObject) (command)));
        if (command != null) goto _L4; else goto _L3
_L3:
        command = cu.a(null);
        if (tcs == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        ((android.support.v7.cu.a) (tcs)).b(null);
        notifyTestHelper(8);
_L8:
        waitForTaskWithoutLock(((cu) (command)));
        if (tcs == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        waitForTaskWithoutLock(((android.support.v7.cu.a) (tcs)).a());
        removeFile(file);
        notifyTestHelper(1);
_L7:
        j++;
          goto _L5
        tcs;
        if (6 < Parse.getLogLevel()) goto _L7; else goto _L6
_L6:
        log.log(Level.SEVERE, "File disappeared from cache while being read.", ((Throwable) (tcs)));
          goto _L7
        tcs;
        if (6 >= Parse.getLogLevel())
        {
            log.log(Level.SEVERE, "Unable to read contents of file in cache.", ((Throwable) (tcs)));
        }
        removeFile(file);
          goto _L7
        tcs;
        if (6 >= Parse.getLogLevel())
        {
            log.log(Level.SEVERE, "Error parsing JSON found in cache.", ((Throwable) (tcs)));
        }
        removeFile(file);
          goto _L7
        tcs;
        if (6 >= Parse.getLogLevel())
        {
            log.log(Level.SEVERE, "Unable to create ParseCommand from JSON.", ((Throwable) (tcs)));
        }
        removeFile(file);
          goto _L7
_L4:
        command = ((ParseRESTCommand) (command)).executeAsync().b(new ct() {

            final ParseCommandCache this$0;
            final ParseRESTCommand val$command;
            final android.support.v7.cu.a val$tcs;

            public cu then(cu cu1)
                throws Exception
            {
_L2:
                do
                {
                    return cu1;
                } while ((obj1 instanceof ParseException) && ((ParseException)obj1).getCode() == 100 || tcs == null);
                tcs.b(((Exception) (obj1)));
                return cu1;
                String s = command.getLocalId();
                Object obj1 = cu1.f();
                if (obj1 != null)
                {
                    break MISSING_BLOCK_LABEL_17;
                }
                obj1 = (JSONObject)cu1.e();
                if (tcs != null)
                {
                    tcs.b(obj1);
                    return cu1;
                }
                if (s != null)
                {
                    obj1 = ((JSONObject) (obj1)).optString("objectId", null);
                    if (obj1 != null)
                    {
                        LocalIdManager.getDefaultInstance().setObjectId(s, ((String) (obj1)));
                        return cu1;
                    }
                }
                if (true) goto _L2; else goto _L1
_L1:
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseCommandCache.this;
                command = parserestcommand;
                tcs = a;
                super();
            }
        });
          goto _L8
        tcs;
        if (((ParseException) (tcs)).getCode() != 100)
        {
            break MISSING_BLOCK_LABEL_554;
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_540;
        }
        long l;
        long l2;
        if (4 >= Parse.getLogLevel())
        {
            log.info((new StringBuilder()).append("Network timeout in command cache. Waiting for ").append(timeoutRetryWaitSeconds).append(" seconds and then retrying ").append(i).append(" times.").toString());
        }
        l = System.currentTimeMillis();
        l2 = (long)(timeoutRetryWaitSeconds * 1000D) + l;
_L10:
        if (l >= l2)
        {
            break MISSING_BLOCK_LABEL_530;
        }
        if (isConnected() && !shouldStop)
        {
            break MISSING_BLOCK_LABEL_466;
        }
        if (4 >= Parse.getLogLevel())
        {
            log.info("Aborting wait because runEventually thread should stop.");
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        lock.wait(l2 - l);
_L11:
        long l1 = System.currentTimeMillis();
        l = l1;
        if (l1 >= l2 - (long)(timeoutRetryWaitSeconds * 1000D)) goto _L10; else goto _L9
_L9:
        l = l2 - (long)(timeoutRetryWaitSeconds * 1000D);
          goto _L10
        tcs;
        shouldStop = true;
          goto _L11
        maybeRunAllCommandsNow(i - 1);
          goto _L7
        setConnected(false);
        notifyTestHelper(7);
          goto _L7
        if (6 >= Parse.getLogLevel())
        {
            log.log(Level.SEVERE, "Failed to run command.", ((Throwable) (tcs)));
        }
        removeFile(file);
        notifyTestHelper(2, ((Throwable) (tcs)));
          goto _L7
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        tcs = null;
          goto _L12
    }

    private void removeFile(File file)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        pendingTasks.remove(file);
        try
        {
            commandFromJSON(ParseFileUtils.readFileToJSONObject(file)).releaseLocalIds();
        }
        catch (Exception exception) { }
        ParseFileUtils.deleteQuietly(file);
        return;
        file;
        obj;
        JVM INSTR monitorexit ;
        throw file;
    }

    private void runLoop()
    {
label0:
        {
            if (4 >= Parse.getLogLevel())
            {
                log.info("Parse command cache has started processing queued commands.");
            }
            synchronized (runningLock)
            {
                if (!running)
                {
                    break label0;
                }
            }
            return;
        }
        running = true;
        runningLock.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        obj = lock;
        obj;
        JVM INSTR monitorenter ;
        Object obj2;
        boolean flag;
        boolean flag1;
        if (!shouldStop && !Thread.interrupted())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        obj = lock;
        obj;
        JVM INSTR monitorenter ;
        maybeRunAllCommandsNow(timeoutMaxRetries);
        flag1 = shouldStop;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        if (!unprocessedCommandsExist)
        {
            lock.wait();
        }
_L1:
        if (!shouldStop)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L2:
        obj;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        shouldStop = true;
          goto _L1
        exception;
        if (6 >= Parse.getLogLevel())
        {
            log.log(Level.SEVERE, "saveEventually thread had an error.", exception);
        }
        if (!shouldStop)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L2
        exception;
        if (shouldStop);
        throw exception;
        synchronized (runningLock)
        {
            running = false;
            runningLock.notifyAll();
        }
        if (4 >= Parse.getLogLevel())
        {
            log.info("saveEventually thread has stopped processing commands.");
            return;
        }
        break MISSING_BLOCK_LABEL_245;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Object waitForTaskWithoutLock(cu cu1)
        throws ParseException
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        final cs finished;
        finished = new cs(Boolean.valueOf(false));
        cu1.a(new ct() {

            final ParseCommandCache this$0;
            final cs val$finished;

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            public Void then(cu cu2)
                throws Exception
            {
                finished.a(Boolean.valueOf(true));
                synchronized (ParseCommandCache.lock)
                {
                    ParseCommandCache.lock.notifyAll();
                }
                return null;
                exception;
                cu2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = ParseCommandCache.this;
                finished = cs1;
                super();
            }
        }, cu.a);
_L1:
        boolean flag = ((Boolean)finished.a()).booleanValue();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        lock.wait();
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        shouldStop = true;
          goto _L1
        cu1;
        obj;
        JVM INSTR monitorexit ;
        throw cu1;
        cu1 = ((cu) (ParseTaskUtils.wait(cu1)));
        obj;
        JVM INSTR monitorexit ;
        return cu1;
    }

    public void clear()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        File afile[] = cachePath.listFiles();
        if (afile != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        int j = afile.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        removeFile(afile[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        pendingTasks.clear();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public cu enqueueEventuallyAsync(ParseRESTCommand parserestcommand, ParseObject parseobject)
    {
        return enqueueEventuallyAsync(parserestcommand, false, parseobject);
    }

    void fakeObjectUpdate()
    {
        notifyTestHelper(3);
        notifyTestHelper(1);
        notifyTestHelper(5);
    }

    public void onDestroy()
    {
        notifier.removeListener(listener);
    }

    public void pause()
    {
        Object obj = runningLock;
        obj;
        JVM INSTR monitorenter ;
        if (running)
        {
            synchronized (lock)
            {
                shouldStop = true;
                lock.notifyAll();
            }
        }
_L2:
        boolean flag = running;
        Exception exception;
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            runningLock.wait();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        finally { }
        if (true) goto _L2; else goto _L1
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        obj;
        JVM INSTR monitorexit ;
    }

    public int pendingCount()
    {
        return getPendingCount();
    }

    public void resume()
    {
        Object obj = runningLock;
        obj;
        JVM INSTR monitorenter ;
        if (running)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        (new Thread("ParseCommandCache.runLoop()") {

            final ParseCommandCache this$0;

            public void run()
            {
                runLoop();
            }

            
            {
                this$0 = ParseCommandCache.this;
                super(s);
            }
        }).start();
        runningLock.wait();
_L1:
        return;
        Object obj1;
        obj1;
        synchronized (lock)
        {
            shouldStop = true;
            lock.notifyAll();
        }
          goto _L1
        exception;
        obj2;
        JVM INSTR monitorexit ;
        throw exception;
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
    }

    public void setConnected(boolean flag)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (isConnected() == flag || !flag)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        lock.notifyAll();
        super.setConnected(flag);
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setMaxCacheSizeBytes(int i)
    {
        synchronized (lock)
        {
            maxCacheSizeBytes = i;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setTimeoutMaxRetries(int i)
    {
        synchronized (lock)
        {
            timeoutMaxRetries = i;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setTimeoutRetryWaitSeconds(double d)
    {
        synchronized (lock)
        {
            timeoutRetryWaitSeconds = d;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void simulateReboot()
    {
        synchronized (lock)
        {
            pendingTasks.clear();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }



}
