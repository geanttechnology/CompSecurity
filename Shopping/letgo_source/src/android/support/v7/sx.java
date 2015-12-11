// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;

// Referenced classes of package android.support.v7:
//            sw, sv, ll, sy, 
//            lk

public class sx extends com.google.android.gms.ads.internal.reward.mediation.client.zza.zza
{

    private sv a;
    private sy b;
    private sw c;

    public sx(sw sw1)
    {
        c = sw1;
    }

    public void a(sv sv1)
    {
        a = sv1;
    }

    public void a(sy sy1)
    {
        b = sy1;
    }

    public void zza(lk lk, RewardItemParcel rewarditemparcel)
    {
        if (c != null)
        {
            c.a(rewarditemparcel);
        }
    }

    public void zzb(lk lk, int i)
    {
        if (a != null)
        {
            a.a(i);
        }
    }

    public void zzc(lk lk, int i)
    {
        if (b != null)
        {
            b.a(ll.a(lk).getClass().getName(), i);
        }
    }

    public void zzg(lk lk)
    {
        if (a != null)
        {
            a.a();
        }
    }

    public void zzh(lk lk)
    {
        if (b != null)
        {
            b.a(ll.a(lk).getClass().getName());
        }
    }

    public void zzi(lk lk)
    {
        if (c != null)
        {
            c.c();
        }
    }

    public void zzj(lk lk)
    {
        if (c != null)
        {
            c.d();
        }
    }

    public void zzk(lk lk)
    {
        if (c != null)
        {
            c.e();
        }
    }

    public void zzl(lk lk)
    {
        if (c != null)
        {
            c.f();
        }
    }

    public void zzm(lk lk)
    {
        if (c != null)
        {
            c.g();
        }
    }
}
