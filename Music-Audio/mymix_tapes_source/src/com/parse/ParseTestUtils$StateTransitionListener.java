// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.parse:
//            ParseTestUtils, PushConnection

static class transitions
    implements transitions
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

    public void onStateChange(PushConnection pushconnection, transitions transitions1, transitions transitions2)
    {
        this;
        JVM INSTR monitorenter ;
        transitions.add(new transitions(SystemClock.elapsedRealtime(), pushconnection, transitions1, transitions2));
        if (transitions2 == null) goto _L2; else goto _L1
_L1:
        if (ParseTestUtils.access$000() == null || !(transitions2 instanceof transitions)) goto _L2; else goto _L3
_L3:
        ParseTestUtils.access$000().release();
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (transitions2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (ParseTestUtils.access$100() != null && (transitions2 instanceof transitions))
        {
            ParseTestUtils.access$100().release();
        }
        if (true) goto _L5; else goto _L4
_L4:
        pushconnection;
        throw pushconnection;
    }

    ()
    {
        transitions = new ArrayList();
    }
}
