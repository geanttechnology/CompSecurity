// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzcm

public class zzcn extends com.google.android.gms.ads.formats.NativeAd.Image
{

    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzwn;
    private final zzcm zzxc;

    public zzcn(zzcm zzcm1)
    {
        Object obj;
        obj = null;
        super();
        zzxc = zzcm1;
        zzcm1 = zzxc.zzdv();
        if (zzcm1 == null) goto _L2; else goto _L1
_L1:
        zzcm1 = (Drawable)zze.zzp(zzcm1);
_L3:
        mDrawable = zzcm1;
        double d;
        double d1;
        try
        {
            zzcm1 = zzxc.getUri();
        }
        // Misplaced declaration of an exception variable
        catch (zzcm zzcm1)
        {
            zzb.zzb("Failed to get uri.", zzcm1);
            zzcm1 = obj;
        }
        mUri = zzcm1;
        d = 1.0D;
        d1 = zzxc.getScale();
        d = d1;
_L4:
        zzwn = d;
        return;
        zzcm1;
        zzb.zzb("Failed to get drawable.", zzcm1);
_L2:
        zzcm1 = null;
          goto _L3
        zzcm1;
        zzb.zzb("Failed to get scale.", zzcm1);
          goto _L4
    }

    public Drawable getDrawable()
    {
        return mDrawable;
    }

    public double getScale()
    {
        return zzwn;
    }

    public Uri getUri()
    {
        return mUri;
    }
}
