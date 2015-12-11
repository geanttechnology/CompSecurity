// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.doubleclick;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzx;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.doubleclick:
//            PublisherAdRequest

public final class 
{

    private final com.google.android.gms.ads.internal.client. zznP = new com.google.android.gms.ads.internal.client.();

    static com.google.android.gms.ads.internal.client. zza( )
    {
        return .zznP;
    }

    public final zznP addCategoryExclusion(String s)
    {
        zznP.(s);
        return this;
    }

    public final zznP addCustomEventExtrasBundle(Class class1, Bundle bundle)
    {
        zznP.(class1, bundle);
        return this;
    }

    public final zznP addCustomTargeting(String s, String s1)
    {
        zznP.(s, s1);
        return this;
    }

    public final zznP addCustomTargeting(String s, List list)
    {
        if (list != null)
        {
            zznP.(s, zzv.zzcq(",").zza(list));
        }
        return this;
    }

    public final zznP addKeyword(String s)
    {
        zznP.(s);
        return this;
    }

    public final zznP addNetworkExtras(NetworkExtras networkextras)
    {
        zznP.(networkextras);
        return this;
    }

    public final zznP addNetworkExtrasBundle(Class class1, Bundle bundle)
    {
        zznP.(class1, bundle);
        return this;
    }

    public final zznP addTestDevice(String s)
    {
        zznP.(s);
        return this;
    }

    public final PublisherAdRequest build()
    {
        return new PublisherAdRequest(this, null);
    }

    public final zznP setBirthday(Date date)
    {
        zznP.(date);
        return this;
    }

    public final zznP setContentUrl(String s)
    {
        zzx.zzb(s, "Content URL must be non-null.");
        zzx.zzh(s, "Content URL must be non-empty.");
        boolean flag;
        if (s.length() <= 512)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Content URL must not exceed %d in length.  Provided length was %d.", new Object[] {
            Integer.valueOf(512), Integer.valueOf(s.length())
        });
        zznP.(s);
        return this;
    }

    public final zznP setGender(int i)
    {
        zznP.(i);
        return this;
    }

    public final zznP setLocation(Location location)
    {
        zznP.(location);
        return this;
    }

    public final zznP setManualImpressionsEnabled(boolean flag)
    {
        zznP.sEnabled(flag);
        return this;
    }

    public final sionsEnabled setPublisherProvidedId(String s)
    {
        zznP.(s);
        return this;
    }

    public final zznP setRequestAgent(String s)
    {
        zznP.(s);
        return this;
    }

    public final zznP tagForChildDirectedTreatment(boolean flag)
    {
        zznP.(flag);
        return this;
    }

    public ()
    {
    }
}
