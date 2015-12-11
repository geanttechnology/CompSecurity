// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.callback;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PendingRequestCallbackHolder
{
    private class InflightCallback
        implements Callback
    {

        private final String mId;
        final PendingRequestCallbackHolder this$0;

        public void onError(Bundle bundle)
        {
            this = this.getAndClearInFlightCallbacksForId(bundle);
        }

        public void onSuccess(Bundle bundle)
        {
            this = this.getAndClearInFlightCallbacksForId(bundle);
        }

        public InflightCallback(String s)
        {
            this$0 = PendingRequestCallbackHolder.this;
            super();
            mId = s;
        }
    }


    private final Map mIdentiferToPendingCallback = new HashMap();

    public PendingRequestCallbackHolder()
    {
    }

    private List addEmptyListToId(String s)
    {
        this;
        JVM INSTR monitorenter ;
        LinkedList linkedlist;
        linkedlist = new LinkedList();
        mIdentiferToPendingCallback.put(s, linkedlist);
        this;
        JVM INSTR monitorexit ;
        return linkedlist;
        s;
        throw s;
    }

    private List getAndClearInFlightCallbacksForId(String s)
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        list = getInFlightCallbacksForId(s);
        if (list.size() > 0)
        {
            addEmptyListToId(s);
        }
        this;
        JVM INSTR monitorexit ;
        return list;
        s;
        throw s;
    }

    private List getInFlightCallbacksForId(String s)
    {
        this;
        JVM INSTR monitorenter ;
        List list1 = (List)mIdentiferToPendingCallback.get(s);
        List list;
        list = list1;
        if (list1 != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        list = addEmptyListToId(s);
        this;
        JVM INSTR monitorexit ;
        return list;
        s;
        throw s;
    }

    public Callback waitForInflightRequestOrMakeRequest(String s, Callback callback)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        List list = getInFlightCallbacksForId(s);
        list.add(callback);
        i = list.size();
        if (i <= 1) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = new InflightCallback(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }


/*
    static void access$000(PendingRequestCallbackHolder pendingrequestcallbackholder, String s, Bundle bundle)
    {
        pendingrequestcallbackholder = pendingrequestcallbackholder.getAndClearInFlightCallbacksForId(s);
        for (s = pendingrequestcallbackholder.iterator(); s.hasNext(); ((Callback)s.next()).onSuccess(bundle)) { }
        pendingrequestcallbackholder.clear();
        return;
    }

*/


/*
    static void access$100(PendingRequestCallbackHolder pendingrequestcallbackholder, String s, Bundle bundle)
    {
        pendingrequestcallbackholder = pendingrequestcallbackholder.getAndClearInFlightCallbacksForId(s);
        for (s = pendingrequestcallbackholder.iterator(); s.hasNext(); ((Callback)s.next()).onError(bundle)) { }
        pendingrequestcallbackholder.clear();
        return;
    }

*/
}
