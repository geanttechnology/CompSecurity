// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.internal:
//            zzbd, zzbb, zzie, zzhu, 
//            zzan

public class zzbc
{

    public zzbc()
    {
    }

    private zzbb zza(Context context, VersionInfoParcel versioninfoparcel, zzie zzie1, zzan zzan)
    {
        context = new zzbd(context, versioninfoparcel, zzan);
        context.zza(new _cls2(zzie1, context));
        return context;
    }

    static zzbb zza(zzbc zzbc1, Context context, VersionInfoParcel versioninfoparcel, zzie zzie1, zzan zzan)
    {
        return zzbc1.zza(context, versioninfoparcel, zzie1, zzan);
    }

    public Future zza(Context context, VersionInfoParcel versioninfoparcel, String s, zzan zzan)
    {
        zzie zzie1 = new zzie();
        zzhu.zzHK.post(new _cls1(context, versioninfoparcel, zzie1, zzan, s));
        return zzie1;
    }

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
