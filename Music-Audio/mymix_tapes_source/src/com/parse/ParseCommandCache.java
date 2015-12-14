// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.Intent;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
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
//            ParseCommand, ParseFileUtils, ParseException, LocalIdManager

class ParseCommandCache extends ParseEventuallyQueue
{

    private static final String TAG = "com.parse.ParseCommandCache";
    private static int filenameCounter = 0;
    private static final Object lock = new Object();
    private File cachePath;
    private Logger log;
    private int maxCacheSizeBytes;
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
            setConnected(ConnectivityNotifier.getNotifier().isConnected());
            ConnectivityNotifier.getNotifier().addListener(new ConnectivityNotifier.ConnectivityListener() {

                final ParseCommandCache this$0;

                public void networkConnectivityStatusChanged(Intent intent)
                {
                    if (intent.getBooleanExtra("noConnectivity", false))
                    {
                        setConnected(false);
                        return;
                    } else
                    {
                        setConnected(ConnectivityNotifier.getNotifier().isConnected());
                        return;
                    }
                }

            
            {
                this$0 = ParseCommandCache.this;
                super();
            }
            }, context);
            resume();
            return;
        }
    }

    private Task enqueueEventuallyAsync(ParseCommand parsecommand, boolean flag, ParseObject parseobject)
    {
        bolts.Task.TaskCompletionSource taskcompletionsource;
        Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
        taskcompletionsource = Task.create();
        if (parseobject == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        if (parseobject.getObjectId() == null)
        {
            parsecommand.setLocalId(parseobject.getOrCreateLocalId());
        }
        byte abyte0[] = parsecommand.toJSONObject().toString().getBytes("UTF-8");
        if (abyte0.length > maxCacheSizeBytes)
        {
            if (5 >= Parse.getLogLevel())
            {
                log.warning("Unable to save command for later because it's too big.");
            }
            notifyTestHelper(4);
            return Task.forResult(null);
        }
        break MISSING_BLOCK_LABEL_110;
        parsecommand;
        if (5 >= Parse.getLogLevel())
        {
            log.log(Level.WARNING, "UTF-8 isn't supported.  This shouldn't happen.", parsecommand);
        }
        notifyTestHelper(4);
        return Task.forResult(null);
        Object obj1 = lock;
        obj1;
        JVM INSTR monitorenter ;
        parseobject = cachePath.list();
        if (parseobject == null) goto _L2; else goto _L1
_L1:
        Arrays.sort(parseobject);
        int j = 0;
        int k = parseobject.length;
        int i = 0;
_L4:
        Object obj;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = parseobject[i];
        j += (int)(new File(cachePath, ((String) (obj)))).length();
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        j += abyte0.length;
        if (j <= maxCacheSizeBytes) goto _L2; else goto _L5
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        if (5 >= Parse.getLogLevel())
        {
            log.warning("Unable to save command for later because storage is full.");
        }
        parsecommand = Task.forResult(null);
        lock.notifyAll();
        obj1;
        JVM INSTR monitorexit ;
        return parsecommand;
        parsecommand;
        obj1;
        JVM INSTR monitorexit ;
        throw parsecommand;
        if (5 >= Parse.getLogLevel())
        {
            log.warning("Deleting old commands to make room in command cache.");
        }
          goto _L6
_L10:
        if (j <= maxCacheSizeBytes || i >= parseobject.length) goto _L2; else goto _L7
_L7:
        obj = new File(cachePath, parseobject[i]);
        j -= (int)((File) (obj)).length();
        removeFile(((File) (obj)));
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        obj = Long.toHexString(System.currentTimeMillis());
        parseobject = ((ParseObject) (obj));
        String s;
        if (((String) (obj)).length() < 16)
        {
            parseobject = new char[16 - ((String) (obj)).length()];
            Arrays.fill(parseobject, '0');
            parseobject = (new StringBuilder()).append(new String(parseobject)).append(((String) (obj))).toString();
        }
        i = filenameCounter;
        filenameCounter = i + 1;
        s = Integer.toHexString(i);
        obj = s;
        if (s.length() < 8)
        {
            obj = new char[8 - s.length()];
            Arrays.fill(((char []) (obj)), '0');
            obj = (new StringBuilder()).append(new String(((char []) (obj)))).append(s).toString();
        }
        parseobject = File.createTempFile((new StringBuilder()).append("CachedCommand_").append(parseobject).append("_").append(((String) (obj))).append("_").toString(), "", cachePath);
        pendingTasks.put(parseobject, taskcompletionsource);
        parsecommand.retainLocalIds();
        ParseFileUtils.writeByteArrayToFile(parseobject, abyte0);
        notifyTestHelper(3);
        unprocessedCommandsExist = true;
        lock.notifyAll();
_L8:
        obj1;
        JVM INSTR monitorexit ;
        return taskcompletionsource.getTask();
        parsecommand;
        if (5 >= Parse.getLogLevel())
        {
            log.log(Level.WARNING, "Unable to save command for later.", parsecommand);
        }
        lock.notifyAll();
          goto _L8
        parsecommand;
        lock.notifyAll();
        throw parsecommand;
_L6:
        i = 0;
        if (true) goto _L10; else goto _L9
_L9:
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
            break MISSING_BLOCK_LABEL_41;
        }
        if (as.length != 0)
        {
            break MISSING_BLOCK_LABEL_49;
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
_L3:
        if (j >= k) goto _L2; else goto _L1
_L1:
        final Object tcs = as[j];
        File file = new File(cachePath, ((String) (tcs)));
        Object obj1 = new JSONObject(new String(ParseFileUtils.readFileToByteArray(file), "UTF-8"));
        if (!pendingTasks.containsKey(file))
        {
            break MISSING_BLOCK_LABEL_589;
        }
        tcs = (bolts.Task.TaskCompletionSource)pendingTasks.get(file);
_L9:
        obj1 = new ParseCommand(((JSONObject) (obj1)));
        final String localId = ((ParseCommand) (obj1)).getLocalId();
        waitForTaskWithoutLock(((ParseCommand) (obj1)).executeAsync().continueWithTask(new Continuation() {

            final ParseCommandCache this$0;
            final String val$localId;
            final bolts.Task.TaskCompletionSource val$tcs;

            public Task then(Task task)
                throws Exception
            {
_L2:
                do
                {
                    return task;
                } while ((obj2 instanceof ParseException) && ((ParseException)obj2).getCode() == 100 || tcs == null);
                tcs.setError(((Exception) (obj2)));
                return task;
                Object obj2 = task.getError();
                if (obj2 != null)
                {
                    break MISSING_BLOCK_LABEL_9;
                }
                obj2 = task.getResult();
                if (tcs != null)
                {
                    tcs.setResult(obj2);
                    return task;
                }
                if (localId != null && (obj2 instanceof JSONObject) && ((JSONObject)obj2).has("data") && ((JSONObject)obj2).getJSONObject("data").has("objectId"))
                {
                    obj2 = ((JSONObject)obj2).getJSONObject("data").getString("objectId");
                    LocalIdManager.getDefaultInstance().setObjectId(localId, ((String) (obj2)));
                    return task;
                }
                if (true) goto _L2; else goto _L1
_L1:
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseCommandCache.this;
                tcs = taskcompletionsource;
                localId = s;
                super();
            }
        }));
        if (tcs == null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        waitForTaskWithoutLock(((bolts.Task.TaskCompletionSource) (tcs)).getTask());
        removeFile(file);
        notifyTestHelper(1);
_L5:
        j++;
          goto _L3
        tcs;
        if (6 < Parse.getLogLevel()) goto _L5; else goto _L4
_L4:
        log.log(Level.SEVERE, "File disappeared from cache while being read.", ((Throwable) (tcs)));
          goto _L5
        tcs;
        if (6 >= Parse.getLogLevel())
        {
            log.log(Level.SEVERE, "Unable to read contents of file in cache.", ((Throwable) (tcs)));
        }
        removeFile(file);
          goto _L5
        tcs;
        if (6 >= Parse.getLogLevel())
        {
            log.log(Level.SEVERE, "Error parsing JSON found in cache.", ((Throwable) (tcs)));
        }
        removeFile(file);
          goto _L5
        tcs;
        if (6 >= Parse.getLogLevel())
        {
            log.log(Level.SEVERE, "Unable to create ParseCommand from JSON.", ((Throwable) (tcs)));
        }
        removeFile(file);
          goto _L5
        tcs;
        if (((ParseException) (tcs)).getCode() != 100)
        {
            break MISSING_BLOCK_LABEL_550;
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_536;
        }
        long l;
        long l2;
        if (4 >= Parse.getLogLevel())
        {
            log.info((new StringBuilder()).append("Network timeout in command cache. Waiting for ").append(timeoutRetryWaitSeconds).append(" seconds and then retrying ").append(i).append(" times.").toString());
        }
        l = System.currentTimeMillis();
        l2 = l + (long)(timeoutRetryWaitSeconds * 1000D);
_L7:
        if (l >= l2)
        {
            break MISSING_BLOCK_LABEL_526;
        }
        if (isConnected() && !shouldStop)
        {
            break MISSING_BLOCK_LABEL_462;
        }
        if (4 >= Parse.getLogLevel())
        {
            log.info("Aborting wait because runEventually thread should stop.");
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        lock.wait(l2 - l);
_L8:
        long l1 = System.currentTimeMillis();
        l = l1;
        if (l1 >= l2 - (long)(timeoutRetryWaitSeconds * 1000D)) goto _L7; else goto _L6
_L6:
        l = l2 - (long)(timeoutRetryWaitSeconds * 1000D);
          goto _L7
        tcs;
        shouldStop = true;
          goto _L8
        maybeRunAllCommandsNow(i - 1);
          goto _L5
        setConnected(false);
        notifyTestHelper(7);
          goto _L5
        if (6 >= Parse.getLogLevel())
        {
            log.log(Level.SEVERE, "Failed to run command.", ((Throwable) (tcs)));
        }
        removeFile(file);
        notifyTestHelper(2);
          goto _L5
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        tcs = null;
          goto _L9
    }

    private void removeFile(File file)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        pendingTasks.remove(file);
        try
        {
            (new ParseCommand(new JSONObject(new String(ParseFileUtils.readFileToByteArray(file), "UTF-8")))).releaseLocalIds();
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
            break MISSING_BLOCK_LABEL_204;
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
        break MISSING_BLOCK_LABEL_248;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Object waitForTaskWithoutLock(Task task)
        throws ParseException
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        final Capture finished;
        finished = new Capture(Boolean.valueOf(false));
        task.continueWith(new Continuation() {

            final ParseCommandCache this$0;
            final Capture val$finished;

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public Void then(Task task1)
                throws Exception
            {
                finished.set(Boolean.valueOf(true));
                synchronized (ParseCommandCache.lock)
                {
                    ParseCommandCache.lock.notifyAll();
                }
                return null;
                exception;
                task1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = ParseCommandCache.this;
                finished = capture;
                super();
            }
        }, Task.BACKGROUND_EXECUTOR);
_L1:
        boolean flag = ((Boolean)finished.get()).booleanValue();
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
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
        task = ((Task) (Parse.waitForTask(task)));
        obj;
        JVM INSTR monitorexit ;
        return task;
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

    public Task enqueueEventuallyAsync(ParseCommand parsecommand, ParseObject parseobject)
    {
        return enqueueEventuallyAsync(parsecommand, false, parseobject);
    }

    void fakeObjectUpdate()
    {
        notifyTestHelper(3);
        notifyTestHelper(1);
        notifyTestHelper(5);
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
