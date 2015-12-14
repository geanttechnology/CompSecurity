// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import java.io.File;
import myobfuscated.t.a;
import myobfuscated.t.b;
import myobfuscated.t.d;
import myobfuscated.t.i;

final class h
{

    private b a;
    private volatile a b;

    public h(b b1)
    {
        a = b1;
    }

    public final a a()
    {
        Object obj = null;
        if (b != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (b != null) goto _L4; else goto _L3
_L3:
        b b1;
        File file;
        b1 = a;
        file = b1.b.a();
        if (file != null) goto _L6; else goto _L5
_L5:
        a a1 = obj;
_L8:
        b = a1;
_L4:
        if (b == null)
        {
            b = new d();
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return b;
_L6:
        if (file.mkdirs())
        {
            break MISSING_BLOCK_LABEL_97;
        }
        a1 = obj;
        if (!file.exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        a1 = obj;
        if (!file.isDirectory())
        {
            continue; /* Loop/switch isn't completed */
        }
        a1 = i.a(file, b1.a);
        if (true) goto _L8; else goto _L7
_L7:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
