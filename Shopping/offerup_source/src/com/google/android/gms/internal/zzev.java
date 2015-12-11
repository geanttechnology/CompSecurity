// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzcm

public class zzev extends zzeq.zza
{

    private final NativeAppInstallAdMapper zzzN;

    public zzev(NativeAppInstallAdMapper nativeappinstalladmapper)
    {
        zzzN = nativeappinstalladmapper;
    }

    public String getBody()
    {
        return zzzN.getBody();
    }

    public String getCallToAction()
    {
        return zzzN.getCallToAction();
    }

    public Bundle getExtras()
    {
        return zzzN.getExtras();
    }

    public String getHeadline()
    {
        return zzzN.getHeadline();
    }

    public List getImages()
    {
        Object obj = zzzN.getImages();
        if (obj != null)
        {
            ArrayList arraylist = new ArrayList();
            com.google.android.gms.ads.formats.NativeAd.Image image;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new zzc(image.getDrawable(), image.getUri(), image.getScale())))
            {
                image = (com.google.android.gms.ads.formats.NativeAd.Image)((Iterator) (obj)).next();
            }

            return arraylist;
        } else
        {
            return null;
        }
    }

    public boolean getOverrideClickHandling()
    {
        return zzzN.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording()
    {
        return zzzN.getOverrideImpressionRecording();
    }

    public String getPrice()
    {
        return zzzN.getPrice();
    }

    public double getStarRating()
    {
        return zzzN.getStarRating();
    }

    public String getStore()
    {
        return zzzN.getStore();
    }

    public void recordImpression()
    {
        zzzN.recordImpression();
    }

    public void zzc(zzd zzd1)
    {
        zzzN.handleClick((View)zze.zzp(zzd1));
    }

    public void zzd(zzd zzd1)
    {
        zzzN.trackView((View)zze.zzp(zzd1));
    }

    public zzcm zzdw()
    {
        com.google.android.gms.ads.formats.NativeAd.Image image = zzzN.getIcon();
        if (image != null)
        {
            return new zzc(image.getDrawable(), image.getUri(), image.getScale());
        } else
        {
            return null;
        }
    }
}
