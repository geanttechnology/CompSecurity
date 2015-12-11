// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.c.h;
import com.google.android.gms.ads.internal.formats.b;
import com.google.android.gms.b.c;
import com.google.android.gms.b.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            bk

public final class do extends dj.a
{

    private final h a;

    public do(h h1)
    {
        a = h1;
    }

    public final String a()
    {
        return a.getHeadline();
    }

    public final void a(c c1)
    {
        a.handleClick((View)com.google.android.gms.b.d.a(c1));
    }

    public final List b()
    {
        Object obj = a.getImages();
        if (obj != null)
        {
            ArrayList arraylist = new ArrayList();
            com.google.android.gms.ads.b.a.a a1;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new b(a1.a(), a1.b())))
            {
                a1 = (com.google.android.gms.ads.b.a.a)((Iterator) (obj)).next();
            }

            return arraylist;
        } else
        {
            return null;
        }
    }

    public final void b(c c1)
    {
        a.trackView((View)com.google.android.gms.b.d.a(c1));
    }

    public final String c()
    {
        return a.getBody();
    }

    public final bk d()
    {
        com.google.android.gms.ads.b.a.a a1 = a.getIcon();
        if (a1 != null)
        {
            return new b(a1.a(), a1.b());
        } else
        {
            return null;
        }
    }

    public final String e()
    {
        return a.getCallToAction();
    }

    public final double f()
    {
        return a.getStarRating();
    }

    public final String g()
    {
        return a.getStore();
    }

    public final String h()
    {
        return a.getPrice();
    }

    public final void i()
    {
        a.recordImpression();
    }

    public final boolean j()
    {
        return a.getOverrideImpressionRecording();
    }

    public final boolean k()
    {
        return a.getOverrideClickHandling();
    }

    public final Bundle l()
    {
        return a.getExtras();
    }
}
