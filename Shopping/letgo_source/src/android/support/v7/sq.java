// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

// Referenced classes of package android.support.v7:
//            sr, pz

public class sq extends com.google.android.gms.ads.internal.reward.client.zzb.zza
{

    private final Context a;
    private final VersionInfoParcel b;
    private final sr c;
    private final Object d = new Object();

    public sq(Context context, pz pz, VersionInfoParcel versioninfoparcel)
    {
        a = context;
        b = versioninfoparcel;
        c = new sr(context, AdSizeParcel.zzcB(), pz, versioninfoparcel);
    }

    public void destroy()
    {
        synchronized (d)
        {
            c.destroy();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isLoaded()
    {
        boolean flag;
        synchronized (d)
        {
            flag = c.b();
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void pause()
    {
        synchronized (d)
        {
            c.pause();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void resume()
    {
        synchronized (d)
        {
            c.resume();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setUserId(String s)
    {
        synchronized (d)
        {
            c.a(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void show()
    {
        synchronized (d)
        {
            c.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zza(RewardedVideoAdRequestParcel rewardedvideoadrequestparcel)
    {
        synchronized (d)
        {
            c.a(rewardedvideoadrequestparcel);
        }
        return;
        rewardedvideoadrequestparcel;
        obj;
        JVM INSTR monitorexit ;
        throw rewardedvideoadrequestparcel;
    }

    public void zza(zzd zzd)
    {
        synchronized (d)
        {
            c.a(zzd);
        }
        return;
        zzd;
        obj;
        JVM INSTR monitorexit ;
        throw zzd;
    }
}
