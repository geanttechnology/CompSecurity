// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.cast.CastDevice;

public final class aum
{

    CastDevice a;
    aun b;
    private int c;

    public aum(CastDevice castdevice, aun aun)
    {
        a.f(castdevice, "CastDevice parameter cannot be null");
        a.f(aun, "CastListener parameter cannot be null");
        a = castdevice;
        b = aun;
        c = 0;
    }
}
