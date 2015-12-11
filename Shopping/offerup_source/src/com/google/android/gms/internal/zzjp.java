// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IInterface;
import com.google.android.gms.appdatasearch.UsageInfo;

// Referenced classes of package com.google.android.gms.internal:
//            zzjq

public interface zzjp
    extends IInterface
{

    public abstract void zza(com.google.android.gms.appdatasearch.GetRecentContextCall.Request request, zzjq zzjq);

    public abstract void zza(zzjq zzjq);

    public abstract void zza(zzjq zzjq, String s, String s1);

    public abstract void zza(zzjq zzjq, String s, UsageInfo ausageinfo[]);

    public abstract void zza(zzjq zzjq, boolean flag);

    public abstract void zzb(zzjq zzjq);
}
