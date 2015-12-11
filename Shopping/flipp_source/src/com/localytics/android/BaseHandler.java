// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.localytics.android:
//            BaseUploadThread, LocalyticsDao, BaseProvider

abstract class BaseHandler extends Handler
{

    private static final String CANCEL_UPLOAD = "cancel";
    private static final int MESSAGE_GET_VALUE = 2;
    static final int MESSAGE_INIT = 1;
    private static final int MESSAGE_UPLOAD = 3;
    static final int MESSAGE_UPLOAD_CALLBACK = 4;
    private static final String UPLOAD_WAKE_LOCK = "UPLOAD_WAKE_LOCK";
    protected boolean doesRetry;
    ListenersSet listeners;
    LocalyticsDao mLocalyticsDao;
    BaseProvider mProvider;
    private android.os.PowerManager.WakeLock mWakeLock;
    private int maxRowToUpload;
    private int numberOfRetries;
    private Message pendingUploadMessage;
    private boolean queuePriorityMessages;
    String siloName;
    private BaseUploadThread uploadThread;

    BaseHandler(LocalyticsDao localyticsdao, Looper looper)
    {
        super(looper);
        maxRowToUpload = 0;
        numberOfRetries = 0;
        queuePriorityMessages = false;
        uploadThread = null;
        pendingUploadMessage = null;
        doesRetry = true;
        mLocalyticsDao = localyticsdao;
    }

    private void _uploadCallback(int i, String s)
    {
        String s1 = uploadThread.customerID;
        uploadThread = null;
        if (i > 0)
        {
            _deleteUploadedData(i);
            numberOfRetries = 0;
        } else
        {
            numberOfRetries = numberOfRetries + 1;
        }
        if (!doesRetry || i == maxRowToUpload || numberOfRetries > 3)
        {
            if (i == maxRowToUpload)
            {
                _onUploadCompleted(s);
            }
            cancelPendingUpload();
            numberOfRetries = 0;
            maxRowToUpload = 0;
            exitWakeLock();
            return;
        } else
        {
            upload(false, 10000L, s1);
            return;
        }
    }

    private void cancelPendingUpload()
    {
        if (pendingUploadMessage != null)
        {
            Bundle bundle = new Bundle();
            bundle.putBoolean("cancel", true);
            pendingUploadMessage.setData(bundle);
            pendingUploadMessage = null;
            numberOfRetries = 0;
            maxRowToUpload = 0;
        }
    }

    private void enterWakeLock()
    {
label0:
        {
label1:
            {
                Context context = mLocalyticsDao.getAppContext();
                if (context.getPackageManager().checkPermission("android.permission.WAKE_LOCK", context.getPackageName()) != 0)
                {
                    break label0;
                }
                if (mWakeLock == null)
                {
                    mWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "UPLOAD_WAKE_LOCK");
                    if (mWakeLock.isHeld())
                    {
                        Localytics.Log.w("Wake lock will be acquired but is held when shouldn't be.");
                    }
                    mWakeLock.acquire();
                    if (!mWakeLock.isHeld())
                    {
                        break label1;
                    }
                    Localytics.Log.v("Wake lock acquired.");
                }
                return;
            }
            Localytics.Log.w("Localytics library failed to get wake lock");
            return;
        }
        Localytics.Log.v("android.permission.WAKE_LOCK is missing from the Manifest file.");
    }

    private void exitWakeLock()
    {
        Context context = mLocalyticsDao.getAppContext();
        if (context.getPackageManager().checkPermission("android.permission.WAKE_LOCK", context.getPackageName()) == 0)
        {
            if (mWakeLock != null)
            {
                if (!mWakeLock.isHeld())
                {
                    Localytics.Log.w("Wake lock will be released but not held when should be.");
                }
                mWakeLock.release();
                if (mWakeLock.isHeld())
                {
                    Localytics.Log.w("Wake lock was not released when it should have been.");
                } else
                {
                    Localytics.Log.v("Wake lock released.");
                }
                mWakeLock = null;
            }
            return;
        } else
        {
            Localytics.Log.v("android.permission.WAKE_LOCK is missing from the Manifest file.");
            return;
        }
    }

    private FutureTask getFuture(Callable callable)
    {
        callable = new FutureTask(callable);
        queueMessage(obtainMessage(2, callable));
        return callable;
    }

    private Object getType(Callable callable, Object obj)
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new RuntimeException("Cannot be called on the main thread.");
        } else
        {
            return getFutureTaskValue(getFuture(callable), obj);
        }
    }

    protected abstract void _deleteUploadedData(int i);

    protected abstract TreeMap _getDataToUpload();

    protected abstract int _getMaxRowToUpload();

    abstract void _init();

    protected abstract void _onUploadCompleted(String s);

    void _upload(boolean flag, String s)
    {
        TreeMap treemap;
        int i;
        if (maxRowToUpload != 0 && uploadThread != null && !uploadThread.isAlive())
        {
            maxRowToUpload = 0;
            uploadThread = null;
        }
        i = _getMaxRowToUpload();
        if (flag && maxRowToUpload != 0)
        {
            maxRowToUpload = i;
            Localytics.Log.d(String.format("Already uploading %s", new Object[] {
                siloName.toLowerCase()
            }));
            return;
        }
        try
        {
            treemap = _getDataToUpload();
            if (treemap.size() == 0)
            {
                maxRowToUpload = 0;
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Localytics.Log.w("Error occurred during upload", s);
            maxRowToUpload = 0;
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        maxRowToUpload = i;
        enterWakeLock();
        s = getUploadThread(treemap, s);
        uploadThread = s;
        s.start();
        return;
    }

    void addListener(BaseListener baselistener)
    {
        synchronized (listeners)
        {
            listeners.add(baselistener);
        }
        return;
        baselistener;
        listenersset;
        JVM INSTR monitorexit ;
        throw baselistener;
    }

    boolean getBool(Callable callable)
    {
        return ((Boolean)getType(callable, Boolean.valueOf(false))).booleanValue();
    }

    Object getFutureTaskValue(FutureTask futuretask, Object obj)
    {
        try
        {
            futuretask = ((FutureTask) (futuretask.get()));
        }
        // Misplaced declaration of an exception variable
        catch (FutureTask futuretask)
        {
            return obj;
        }
        finally
        {
            return obj;
        }
        return futuretask;
    }

    List getList(Callable callable)
    {
        return (List)getType(callable, null);
    }

    Map getMap(Callable callable)
    {
        return (Map)getType(callable, null);
    }

    String getString(Callable callable)
    {
        return (String)getType(callable, null);
    }

    protected abstract BaseUploadThread getUploadThread(TreeMap treemap, String s);

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        Localytics.Log.v(String.format("%s handler received %s", new Object[] {
            siloName, message
        }));
        message.what;
        JVM INSTR tableswitch 1 4: default 279
    //                   1 70
    //                   2 109
    //                   3 134
    //                   4 210;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        handleMessageExtended(message);
        return;
_L2:
        try
        {
            _init();
            return;
        }
        catch (Exception exception)
        {
            Localytics.Log.e(String.format("%s handler can't handle message %s", new Object[] {
                siloName, String.valueOf(message.what)
            }), exception);
        }
        return;
_L3:
        final FutureTask fTask = (FutureTask)message.obj;
        mProvider.runBatchTransaction(new _cls1());
        return;
_L4:
        Localytics.Log.d(String.format("%s handler received MESSAGE_UPLOAD", new Object[] {
            siloName
        }));
        Object aobj1[] = (Object[])(Object[])message.obj;
        final Boolean adjustMaxRowToUpload = (Boolean)aobj1[0];
        final String customerId = (String)aobj1[1];
        if (!message.getData().getBoolean("cancel"))
        {
            mProvider.runBatchTransaction(new _cls2());
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        Localytics.Log.d(String.format("%s handler received MESSAGE_UPLOAD_CALLBACK", new Object[] {
            siloName
        }));
        Object aobj[] = (Object[])(Object[])message.obj;
        final int rowsToDelete = ((Integer)aobj[0]).intValue();
        final String responseString = (String)aobj[1];
        mProvider.runBatchTransaction(new _cls3());
        return;
    }

    void handleMessageExtended(Message message)
    {
        throw new Exception("Fell through switch statement");
    }

    boolean queueMessage(Message message)
    {
        if (queuePriorityMessages && getLooper().getThread() == Thread.currentThread())
        {
            handleMessage(message);
            return true;
        } else
        {
            return sendMessage(message);
        }
    }

    final boolean queueMessageDelayed(Message message, long l)
    {
        if (l == 0L)
        {
            return queueMessage(message);
        } else
        {
            return sendMessageDelayed(message, l);
        }
    }

    void removeListener(BaseListener baselistener)
    {
        synchronized (listeners)
        {
            listeners.remove(baselistener);
        }
        return;
        baselistener;
        listenersset;
        JVM INSTR monitorexit ;
        throw baselistener;
    }

    void upload(String s)
    {
        upload(true, 0L, s);
    }

    void upload(boolean flag, long l, String s)
    {
        s = obtainMessage(3, ((Object) (new Object[] {
            Boolean.valueOf(flag), s
        })));
        if (l == 0L)
        {
            cancelPendingUpload();
            queueMessage(s);
            return;
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putBoolean("cancel", false);
            pendingUploadMessage = s;
            pendingUploadMessage.setData(bundle);
            queueMessageDelayed(pendingUploadMessage, l);
            return;
        }
    }



/*
    static boolean access$102(BaseHandler basehandler, boolean flag)
    {
        basehandler.queuePriorityMessages = flag;
        return flag;
    }

*/

    private class ListenersSet extends HashSet
    {

        final BaseHandler this$0;

        void callListeners(String s, Class aclass[], Object aobj[])
        {
            this;
            JVM INSTR monitorenter ;
            BaseHandler basehandler = BaseHandler.this;
            basehandler;
            JVM INSTR monitorenter ;
            Iterator iterator;
            queuePriorityMessages = true;
            iterator = iterator();
_L1:
            Object obj;
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_62;
            }
            obj = iterator.next();
            try
            {
                ReflectionUtils.tryInvokeInstance(obj, s, aclass, aobj);
            }
            catch (Exception exception) { }
              goto _L1
            queuePriorityMessages = false;
            basehandler;
            JVM INSTR monitorexit ;
            this;
            JVM INSTR monitorexit ;
            return;
            s;
            basehandler;
            JVM INSTR monitorexit ;
            throw s;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        ListenersSet()
        {
            this$0 = BaseHandler.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final BaseHandler this$0;
        final FutureTask val$fTask;

        public void run()
        {
            fTask.run();
        }

        _cls1()
        {
            this$0 = BaseHandler.this;
            fTask = futuretask;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final BaseHandler this$0;
        final Boolean val$adjustMaxRowToUpload;
        final String val$customerId;

        public void run()
        {
            _upload(adjustMaxRowToUpload.booleanValue(), customerId);
        }

        _cls2()
        {
            this$0 = BaseHandler.this;
            adjustMaxRowToUpload = boolean1;
            customerId = s;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final BaseHandler this$0;
        final String val$responseString;
        final int val$rowsToDelete;

        public void run()
        {
            _uploadCallback(rowsToDelete, responseString);
        }

        _cls3()
        {
            this$0 = BaseHandler.this;
            rowsToDelete = i;
            responseString = s;
            super();
        }
    }

}
