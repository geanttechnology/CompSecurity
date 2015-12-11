// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ll, lk, nz

public class qi extends qd.a
{

    private final NativeContentAdMapper a;

    public qi(NativeContentAdMapper nativecontentadmapper)
    {
        a = nativecontentadmapper;
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
        com.google.android.gms.ads.formats.NativeAd.Image image = a.getLogo();
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

    public String f()
    {
        return a.getAdvertiser();
    }

    public void g()
    {
        a.recordImpression();
    }

    public boolean h()
    {
        return a.getOverrideImpressionRecording();
    }

    public boolean i()
    {
        return a.getOverrideClickHandling();
    }

    public Bundle j()
    {
        return a.getExtras();
    }
}
