// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mixtape.service:
//            AccountSync

private static class <init>
{

    private final Map mAccountStates;

    public int accountErrored(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        mAccountStates.put(s, Integer.valueOf(2));
        i = getState();
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    public int finishAccountSync(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        mAccountStates.remove(s);
        i = getState();
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    public int getState()
    {
        byte byte0 = 2;
        this;
        JVM INSTR monitorenter ;
        boolean flag = mAccountStates.isEmpty();
        if (!flag) goto _L2; else goto _L1
_L1:
        byte0 = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return byte0;
_L2:
        flag = mAccountStates.containsValue(Integer.valueOf(2));
        if (!flag)
        {
            byte0 = 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public int startAccountSync(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        mAccountStates.put(s, Integer.valueOf(1));
        i = getState();
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    private ()
    {
        mAccountStates = new HashMap();
    }

    mAccountStates(mAccountStates maccountstates)
    {
        this();
    }
}
