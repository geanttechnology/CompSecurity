// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;


// Referenced classes of package com.google.android.gms.cast:
//            Cast, CastDevice

public static final class <init>
{

    CastDevice kv;
    kx kw;
    private int kx;

    static int a(<init> <init>1)
    {
        return <init>1.kx;
    }

    public kx build()
    {
        return new kx(this, null);
    }

    public kx setDebuggingEnabled()
    {
        kx = kx | 1;
        return this;
    }

    private (CastDevice castdevice,  )
    {
        kv = castdevice;
        kw = ;
        kx = 0;
    }

    kx(CastDevice castdevice, kx kx1, kx kx2)
    {
        this(castdevice, kx1);
    }
}
