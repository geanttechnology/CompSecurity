// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.common.api.Releasable;

// Referenced classes of package com.google.android.gms.internal:
//            zzip

public abstract class zzdr
    implements Releasable
{

    protected zzip zzoL;

    public zzdr(zzip zzip)
    {
        zzoL = zzip;
    }

    public abstract void abort();

    public void release()
    {
    }

    public abstract boolean zzZ(String s);

    protected void zza(String s, String s1, int i)
    {
        zza.zzIy.post(new _cls2(s, s1, i));
    }

    protected void zza(String s, String s1, int i, int j, boolean flag)
    {
        zza.zzIy.post(new _cls1(s, s1, i, j, flag));
    }

    protected String zzaa(String s)
    {
        return zzk.zzcE().zzaB(s);
    }

    protected void zzf(String s, String s1)
    {
        zza.zzIy.post(new _cls3(s, s1));
    }

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}

}
