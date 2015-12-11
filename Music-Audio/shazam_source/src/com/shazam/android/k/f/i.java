// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import android.view.View;
import com.shazam.android.al.c;
import com.shazam.android.analytics.event.AnalyticsInfoFromHierarchy;
import com.shazam.model.advert.AdvertInfo;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.io.Serializable;

public final class i
    implements Serializable
{
    public static final class a
    {

        public AnalyticsInfo a;
        public AdvertInfo b;
        public c c;

        public static a a(i j)
        {
            a a1 = new a();
            a1.a = i.a(j);
            a1.b = i.b(j);
            a1.c = com.shazam.android.k.f.i.c(j);
            return a1;
        }

        public final i a()
        {
            return new i(this, (byte)0);
        }

        public a()
        {
        }
    }


    public final AdvertInfo a;
    private final AnalyticsInfo b;
    private final c c;

    private i(a a1)
    {
        b = a1.a;
        a = a1.b;
        c = a1.c;
    }

    i(a a1, byte byte0)
    {
        this(a1);
    }

    public static i a(View view, i j)
    {
        view = AnalyticsInfoFromHierarchy.addAnalyticsInfoFromViewHierarchy(view).a(DefinedEventParameterKey.SCREEN_NAME);
        view = com.shazam.model.analytics.AnalyticsInfo.Builder.a(j.a()).a(DefinedEventParameterKey.SCREEN_ORIGIN, view).b();
        j = a.a(j);
        j.a = view;
        return j.a();
    }

    static AnalyticsInfo a(i j)
    {
        return j.b;
    }

    static AdvertInfo b(i j)
    {
        return j.a;
    }

    static c c(i j)
    {
        return j.c;
    }

    public final AnalyticsInfo a()
    {
        if (b != null)
        {
            return b;
        } else
        {
            return com.shazam.model.analytics.AnalyticsInfo.Builder.a().b();
        }
    }

    public final c b()
    {
        if (c != null)
        {
            return c;
        } else
        {
            return (new com.shazam.android.al.c.a()).a();
        }
    }
}
