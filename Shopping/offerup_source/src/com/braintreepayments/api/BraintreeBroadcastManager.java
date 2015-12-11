// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;

public class BraintreeBroadcastManager
{

    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static BraintreeBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final HashMap mActions = new HashMap();
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList mPendingBroadcasts = new ArrayList();
    private final HashMap mReceivers = new HashMap();

    private BraintreeBroadcastManager(Context context)
    {
        mAppContext = context;
        mHandler = new _cls1(context.getMainLooper());
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

    public static BraintreeBroadcastManager getInstance(Context context)
    {
        synchronized (mLock)
        {
            if (mInstance == null)
            {
                mInstance = new BraintreeBroadcastManager(context.getApplicationContext());
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

    public boolean sendBroadcast(Intent intent)
    {
        boolean flag = false;
        HashMap hashmap = mReceivers;
        hashmap;
        JVM INSTR monitorenter ;
        String s;
        String s1;
        android.net.Uri uri;
        String s2;
        java.util.Set set;
        ArrayList arraylist1;
        s = intent.getAction();
        s1 = intent.resolveTypeIfNeeded(mAppContext.getContentResolver());
        uri = intent.getData();
        s2 = intent.getScheme();
        set = intent.getCategories();
        arraylist1 = (ArrayList)mActions.get(intent.getAction());
        if (arraylist1 == null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int i;
        arraylist = null;
        i = 0;
_L8:
        if (i >= arraylist1.size()) goto _L4; else goto _L3
_L3:
        ReceiverRecord receiverrecord = (ReceiverRecord)arraylist1.get(i);
        if (receiverrecord.broadcasting || receiverrecord.filter.match(s, s1, s2, uri, set, "BraintreeBroadcastManager") < 0) goto _L6; else goto _L5
_L5:
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        arraylist = new ArrayList();
        arraylist.add(receiverrecord);
        receiverrecord.broadcasting = true;
          goto _L6
_L7:
        if (i >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_185;
        }
        ((ReceiverRecord)arraylist.get(i)).broadcasting = false;
        i++;
          goto _L7
        mPendingBroadcasts.add(new BroadcastRecord(intent, arraylist));
        if (!mHandler.hasMessages(1))
        {
            mHandler.sendEmptyMessage(1);
        }
        hashmap;
        JVM INSTR monitorexit ;
        return true;
_L2:
        hashmap;
        JVM INSTR monitorexit ;
        return false;
        intent;
        hashmap;
        JVM INSTR monitorexit ;
        throw intent;
_L6:
        i++;
          goto _L8
_L4:
        if (arraylist == null) goto _L2; else goto _L9
_L9:
        i = ((flag) ? 1 : 0);
          goto _L7
    }

    public void sendBroadcastSync(Intent intent)
    {
        if (sendBroadcast(intent))
        {
            executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastreceiver)
    {
        HashMap hashmap = mReceivers;
        hashmap;
        JVM INSTR monitorenter ;
        ArrayList arraylist = (ArrayList)mReceivers.remove(broadcastreceiver);
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        hashmap;
        JVM INSTR monitorexit ;
        return;
_L15:
        int j;
        if (j >= arraylist.size()) goto _L4; else goto _L3
_L3:
        IntentFilter intentfilter = (IntentFilter)arraylist.get(j);
        int k = 0;
_L13:
        String s;
        ArrayList arraylist1;
        if (k >= intentfilter.countActions())
        {
            break; /* Loop/switch isn't completed */
        }
        s = intentfilter.getAction(k);
        arraylist1 = (ArrayList)mActions.get(s);
        if (arraylist1 == null) goto _L6; else goto _L5
_L5:
        int i = 0;
_L11:
        if (i >= arraylist1.size()) goto _L8; else goto _L7
_L7:
        if (((ReceiverRecord)arraylist1.get(i)).receiver != broadcastreceiver) goto _L10; else goto _L9
_L9:
        arraylist1.remove(i);
        i--;
          goto _L10
_L8:
        if (arraylist1.size() <= 0)
        {
            mActions.remove(s);
        }
        break; /* Loop/switch isn't completed */
_L4:
        hashmap;
        JVM INSTR monitorexit ;
        return;
        broadcastreceiver;
        hashmap;
        JVM INSTR monitorexit ;
        throw broadcastreceiver;
_L2:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L10:
        i++;
        if (true) goto _L11; else goto _L6
_L6:
        k++;
        if (true) goto _L13; else goto _L12
_L12:
        j++;
        if (true) goto _L15; else goto _L14
_L14:
    }



    private class _cls1 extends Handler
    {

        final BraintreeBroadcastManager this$0;

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

        _cls1(Looper looper)
        {
            this$0 = BraintreeBroadcastManager.this;
            super(looper);
        }
    }


    private class BroadcastRecord
    {

        final Intent intent;
        final ArrayList receivers;

        BroadcastRecord(Intent intent1, ArrayList arraylist)
        {
            intent = intent1;
            receivers = arraylist;
        }
    }


    private class ReceiverRecord
    {

        boolean broadcasting;
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

}
