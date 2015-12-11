// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ll, lk, nz

public class qh extends qc.a
{

    private final NativeAppInstallAdMapper a;

    public qh(NativeAppInstallAdMapper nativeappinstalladmapper)
    {
        a = nativeappinstalladmapper;
    }

    public String a()
    {
        return a.getHeadline();
    }

    public void a(lk lk)
    {
        a.handleClick((View)ll.a(lk));
    }

    public List b()
    {
        Object obj = a.getImages();
        if (obj != null)
        {
            ArrayList arraylist = new ArrayList();
            com.google.android.gms.ads.formats.NativeAd.Image image;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new zzc(image.getDrawable(), image.getUri())))
            {
                image = (com.google.android.gms.ads.formats.NativeAd.Image)((Iterator) (obj)).next();
            }

            return arraylist;
        } else
        {
            return null;
        }
    }

    public void b(lk lk)
    {
        a.trackView((View)ll.a(lk));
    }

    public String c()
    {
        return a.getBody();
    }

    public nz d()
    {
        com.google.android.gms.ads.formats.NativeAd.Image image = a.getIcon();
        if (image != null)
        {
            return new zzc(image.getDrawable(), image.getUri());
        } else
        {
            return null;
        }
    }

    public String e()
    {
        return a.getCallToAction();
    }

    public double f()
    {
        return a.getStarRating();
    }

    public String g()
    {
        return a.getStore();
    }

    public String h()
    {
        return a.getPrice();
    }

    public void i()
    {
        a.recordImpression();
    }

    public boolean j()
    {
        return a.getOverrideImpressionRecording();
    }

    public boolean k()
    {
        return a.getOverrideClickHandling();
    }

    public Bundle l()
    {
        return a.getExtras();
    }
}
