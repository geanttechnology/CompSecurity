// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android.service:
//            PendingAction

public class VineServiceConnection
    implements ServiceConnection
{
    public static interface ServiceResponseHandler
    {

        public abstract void handleServiceResponse(int i, int j, String s, Bundle bundle);
    }


    private Context mContext;
    private final int mLock[] = new int[0];
    private final HashMap mPendingQueue = new HashMap();
    private final HashMap mRequestQueue = new HashMap();
    private ServiceResponseHandler mResponseHandler;
    private Messenger mService;
    private Messenger mServiceResponder;

    public VineServiceConnection(Context context, ServiceResponseHandler serviceresponsehandler)
    {
        mServiceResponder = new Messenger(new Handler() {

            final VineServiceConnection this$0;

            public void handleMessage(Message message)
            {
                Bundle bundle = message.getData();
                bundle.setClassLoader(mContext.getClassLoader());
                mResponseHandler.handleServiceResponse(message.what, message.arg1, bundle.getString("reason_phrase"), bundle);
            }

            
            {
                this$0 = VineServiceConnection.this;
                super();
            }
        });
        mContext = context;
        mResponseHandler = serviceresponsehandler;
    }

    private Message getMessage(PendingAction pendingaction)
    {
        Message message = Message.obtain();
        message.arg1 = pendingaction.actionCode;
        message.setData(pendingaction.bundle);
        message.replyTo = mServiceResponder;
        return message;
    }

    private void sendMessage(Messenger messenger, Message message)
    {
        try
        {
            messenger.send(message);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Messenger messenger)
        {
            CrashUtil.logException(messenger, "Unable to send message to service", new Object[0]);
        }
    }

    public void cancelAll()
    {
        synchronized (mLock)
        {
            mRequestQueue.clear();
            mPendingQueue.clear();
        }
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String generateRequestId()
    {
        return Util.randomString(6);
    }

    public boolean isBound()
    {
        return mService != null;
    }

    public boolean isPending(String s)
    {
        boolean flag;
        synchronized (mLock)
        {
            flag = mRequestQueue.containsKey(s);
        }
        return flag;
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = mLock;
        componentname;
        JVM INSTR monitorenter ;
        ibinder = new Messenger(ibinder);
        mService = ibinder;
        mRequestQueue.putAll(mPendingQueue);
        for (Iterator iterator = mPendingQueue.values().iterator(); iterator.hasNext(); sendMessage(ibinder, getMessage((PendingAction)iterator.next()))) { }
        break MISSING_BLOCK_LABEL_80;
        ibinder;
        componentname;
        JVM INSTR monitorexit ;
        throw ibinder;
        mPendingQueue.clear();
        componentname;
        JVM INSTR monitorexit ;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        synchronized (mLock)
        {
            mService = null;
        }
        return;
        exception;
        componentname;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String queueAndExecute(int i, Bundle bundle)
    {
        String s;
        PendingAction pendingaction;
        s = generateRequestId();
        pendingaction = new PendingAction(i, bundle);
        bundle.putString("rid", s);
        bundle = mLock;
        bundle;
        JVM INSTR monitorenter ;
        Messenger messenger = mService;
        if (messenger == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        mRequestQueue.put(s, pendingaction);
        sendMessage(messenger, getMessage(pendingaction));
_L1:
        bundle;
        JVM INSTR monitorexit ;
        return s;
        mPendingQueue.put(s, pendingaction);
          goto _L1
        Exception exception;
        exception;
        bundle;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public PendingAction remove(String s)
    {
        PendingAction pendingaction;
        synchronized (mLock)
        {
            pendingaction = (PendingAction)mRequestQueue.get(s);
            mRequestQueue.remove(s);
        }
        return pendingaction;
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }


}
