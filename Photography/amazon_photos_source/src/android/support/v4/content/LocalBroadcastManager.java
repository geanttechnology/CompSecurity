// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public class LocalBroadcastManager
{
    private static class BroadcastRecord
    {

        final Intent intent;
        final ArrayList receivers;
    }

    private static class ReceiverRecord
    {

        final IntentFilter filter;
        final BroadcastReceiver receiver;

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder(128);
            stringbuilder.append("Receiver{");
            stringbuilder.append(receiver);
            stringbuilder.append(" filter=");
            stringbuilder.append(filter);
            stringbuilder.append("}");
            return stringbuilder.toString();
        }

        ReceiverRecord(IntentFilter intentfilter, BroadcastReceiver broadcastreceiver)
        {
            filter = intentfilter;
            receiver = broadcastreceiver;
        }
    }


    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final HashMap mActions = new HashMap();
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList mPendingBroadcasts = new ArrayList();
    private final HashMap mReceivers = new HashMap();

    private LocalBroadcastManager(Context context)
    {
        mAppContext = context;
        mHandler = new Handler(context.getMainLooper()) {

            final LocalBroadcastManager this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    super.handleMessage(message);
                    return;

                case 1: // '\001'
                    executePendingBroadcasts();
                    break;
                }
            }

            
            {
                this$0 = LocalBroadcastManager.this;
                super(looper);
            }
        };
    }

    private void executePendingBroadcasts()
    {
_L4:
        Object obj = mReceivers;
        obj;
        JVM INSTR monitorenter ;
        int i = mPendingBroadcasts.size();
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        BroadcastRecord abroadcastrecord[];
        abroadcastrecord = new BroadcastRecord[i];
        mPendingBroadcasts.toArray(abroadcastrecord);
        mPendingBroadcasts.clear();
        obj;
        JVM INSTR monitorexit ;
        i = 0;
_L2:
        if (i < abroadcastrecord.length)
        {
            obj = abroadcastrecord[i];
            for (int j = 0; j < ((BroadcastRecord) (obj)).receivers.size(); j++)
            {
                ((ReceiverRecord)((BroadcastRecord) (obj)).receivers.get(j)).receiver.onReceive(mAppContext, ((BroadcastRecord) (obj)).intent);
            }

            break MISSING_BLOCK_LABEL_112;
        }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static LocalBroadcastManager getInstance(Context context)
    {
        synchronized (mLock)
        {
            if (mInstance == null)
            {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            context = mInstance;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        HashMap hashmap = mReceivers;
        hashmap;
        JVM INSTR monitorenter ;
        Object obj;
        ReceiverRecord receiverrecord;
        receiverrecord = new ReceiverRecord(intentfilter, broadcastreceiver);
        obj = (ArrayList)mReceivers.get(broadcastreceiver);
        ArrayList arraylist;
        arraylist = ((ArrayList) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        arraylist = new ArrayList(1);
        mReceivers.put(broadcastreceiver, arraylist);
        arraylist.add(intentfilter);
        int i = 0;
_L2:
        if (i >= intentfilter.countActions())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = intentfilter.getAction(i);
        arraylist = (ArrayList)mActions.get(obj);
        broadcastreceiver = arraylist;
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        broadcastreceiver = new ArrayList(1);
        mActions.put(obj, broadcastreceiver);
        broadcastreceiver.add(receiverrecord);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        hashmap;
        JVM INSTR monitorexit ;
        return;
        broadcastreceiver;
        hashmap;
        JVM INSTR monitorexit ;
        throw broadcastreceiver;
    }


}
