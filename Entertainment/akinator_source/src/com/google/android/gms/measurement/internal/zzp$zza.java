// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;


// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzp

public class zzaMX
{

    private final int mPriority;
    final zzp zzaMV;
    private final boolean zzaMW;
    private final boolean zzaMX;

    public void zzd(String s, Object obj, Object obj1, Object obj2)
    {
        zzaMV.zza(mPriority, zzaMW, zzaMX, s, obj, obj1, obj2);
    }

    public void zze(String s, Object obj, Object obj1)
    {
        zzaMV.zza(mPriority, zzaMW, zzaMX, s, obj, obj1, null);
    }

    public void zzec(String s)
    {
        zzaMV.zza(mPriority, zzaMW, zzaMX, s, null, null, null);
    }

    public void zzj(String s, Object obj)
    {
        zzaMV.zza(mPriority, zzaMW, zzaMX, s, obj, null, null);
    }

    _cls9(zzp zzp1, int i, boolean flag, boolean flag1)
    {
        zzaMV = zzp1;
        super();
        mPriority = i;
        zzaMW = flag;
        zzaMX = flag1;
    }
}
