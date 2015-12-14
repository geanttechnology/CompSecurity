// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import com.nostra13.universalimageloader.core.f;

public class n extends f
{

    private static volatile n b;

    public n()
    {
    }

    public static n a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        com/nostra13/universalimageloader/core/f;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new n();
        }
        com/nostra13/universalimageloader/core/f;
        JVM INSTR monitorexit ;
_L2:
        return b;
        Exception exception;
        exception;
        com/nostra13/universalimageloader/core/f;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
