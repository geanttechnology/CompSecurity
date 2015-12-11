// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

// Referenced classes of package android.support.v7:
//            kh, kj

public final class qm
{

    public static kg.a a(int i)
    {
        switch (i)
        {
        default:
            return kg.a.a;

        case 2: // '\002'
            return kg.a.c;

        case 1: // '\001'
            return kg.a.b;
        }
    }

    public static kh a(AdSizeParcel adsizeparcel)
    {
        int i = 0;
        kh akh[] = new kh[6];
        akh[0] = kh.a;
        akh[1] = kh.b;
        akh[2] = kh.c;
        akh[3] = kh.d;
        akh[4] = kh.e;
        akh[5] = kh.f;
        for (; i < akh.length; i++)
        {
            if (akh[i].a() == adsizeparcel.width && akh[i].b() == adsizeparcel.height)
            {
                return akh[i];
            }
        }

        return new kh(zza.zza(adsizeparcel.width, adsizeparcel.height, adsizeparcel.zzsG));
    }

    public static kj a(AdRequestParcel adrequestparcel)
    {
        HashSet hashset;
        if (adrequestparcel.zzss != null)
        {
            hashset = new HashSet(adrequestparcel.zzss);
        } else
        {
            hashset = null;
        }
        return new kj(new Date(adrequestparcel.zzsq), a(adrequestparcel.zzsr), hashset, adrequestparcel.zzst, adrequestparcel.zzsy);
    }
}
