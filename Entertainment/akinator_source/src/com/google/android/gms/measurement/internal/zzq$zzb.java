// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;


// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzq

private static class <init>
    implements Runnable
{

    private final zzaNa zzaMY;
    private final Throwable zzaMZ;
    private final byte zzaNa[];
    private final int zzys;

    public void run()
    {
        zzaMY.zza(zzys, zzaMZ, zzaNa);
    }

    private _cls9(_cls9 _pcls9, int i, Throwable throwable, byte abyte0[])
    {
        zzaMY = _pcls9;
        zzys = i;
        zzaMZ = throwable;
        zzaNa = abyte0;
    }

    zzaNa(zzaNa zzana, int i, Throwable throwable, byte abyte0[], zzaNa zzana1)
    {
        this(zzana, i, throwable, abyte0);
    }
}
