// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzcm

public class zzew extends zzer.zza
{

    private final NativeContentAdMapper zzzO;

    public zzew(NativeContentAdMapper nativecontentadmapper)
    {
        zzzO = nativecontentadmapper;
    }

    public String getAdvertiser()
    {
        return zzzO.getAdvertiser();
    }

    public String getBody()
    {
        return zzzO.getBody();
    }

    public String getCallToAction()
    {
        return zzzO.getCallToAction();
    }

    public Bundle getExtras()
    {
        return zzzO.getExtras();
    }

    public String getHeadline()
    {
        return zzzO.getHeadline();
    }

    public List getImages()
    {
        Object obj = zzzO.getImages();
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
        return zzzO.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording()
    {
        return zzzO.getOverrideImpressionRecording();
    }

    public void recordImpression()
    {
        zzzO.recordImpression();
    }

    public void zzc(zzd zzd1)
    {
        zzzO.handleClick((View)zze.zzp(zzd1));
    }

    public void zzd(zzd zzd1)
    {
        zzzO.trackView((View)zze.zzp(zzd1));
    }

    public zzcm zzdA()
    {
        com.google.android.gms.ads.formats.NativeAd.Image image = zzzO.getLogo();
        if (image != null)
        {
            return new zzc(image.getDrawable(), image.getUri(), image.getScale());
        } else
        {
            return null;
        }
    }
}
