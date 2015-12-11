// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.c.i;
import com.google.android.gms.ads.internal.formats.b;
import com.google.android.gms.b.c;
import com.google.android.gms.b.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            bk

public final class dp extends dk.a
{

    private final i a;

    public dp(i k)
    {
        a = k;
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
        com.google.android.gms.ads.b.a.a a1 = a.getLogo();
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

    public final String f()
    {
        return a.getAdvertiser();
    }

    public final void g()
    {
        a.recordImpression();
    }

    public final boolean h()
    {
        return a.getOverrideImpressionRecording();
    }

    public final boolean i()
    {
        return a.getOverrideClickHandling();
    }

    public final Bundle j()
    {
        return a.getExtras();
    }
}
