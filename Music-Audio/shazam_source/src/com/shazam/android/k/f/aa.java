// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import android.net.Uri;
import com.shazam.b.e.a;
import com.shazam.model.TrackStyle;

// Referenced classes of package com.shazam.android.k.f:
//            x, a

public final class aa
    implements x
{
    public static final class a
    {

        public TrackStyle a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        boolean k;
        public boolean l;

        public final aa a()
        {
            return new aa(this, (byte)0);
        }

        public a()
        {
        }
    }


    private final Uri a;

    private aa(Uri uri)
    {
        a = uri;
    }

    private aa(a a1)
    {
        Object obj = a1.a;
        android.net.Uri.Builder builder = (new android.net.Uri.Builder()).scheme(com.shazam.android.k.f.a.a).authority("tag");
        if (obj != null && a1.j)
        {
            obj = ((TrackStyle) (obj)).getStyle();
        } else
        {
            obj = "unknown";
        }
        obj = builder.path(((String) (obj))).appendQueryParameter("isMyShazamTag", String.valueOf(a1.g)).appendQueryParameter("isAutoTag", String.valueOf(a1.h)).appendQueryParameter("isTrackBased", String.valueOf(a1.i)).appendQueryParameter("isChartBased", String.valueOf(a1.k)).appendQueryParameter("isFull", String.valueOf(a1.j)).appendQueryParameter("isNewsFeedTrackUri", String.valueOf(a1.l));
        a(((android.net.Uri.Builder) (obj)), "requestId", a1.b);
        a(((android.net.Uri.Builder) (obj)), "trackKey", a1.d);
        a(((android.net.Uri.Builder) (obj)), "trackTitle", a1.c);
        a(((android.net.Uri.Builder) (obj)), "artist", a1.e);
        a(((android.net.Uri.Builder) (obj)), "artUrl", a1.f);
        a = ((android.net.Uri.Builder) (obj)).build();
    }

    aa(a a1, byte byte0)
    {
        this(a1);
    }

    public static x a(Uri uri)
    {
        return new aa(uri);
    }

    private static void a(android.net.Uri.Builder builder, String s, String s1)
    {
        if (com.shazam.b.e.a.c(s1))
        {
            builder.appendQueryParameter(s, s1);
        }
    }

    public final Uri a()
    {
        return a;
    }

    public final boolean a(String s)
    {
        return a.getScheme().equals(s);
    }

    public final String b()
    {
        return a.getQueryParameter("requestId");
    }

    public final String c()
    {
        return a.getQueryParameter("trackTitle");
    }

    public final String d()
    {
        return a.getQueryParameter("trackKey");
    }

    public final String e()
    {
        return a.getQueryParameter("artist");
    }

    public final String f()
    {
        return a.getQueryParameter("artUrl");
    }

    public final String g()
    {
        return a.getLastPathSegment();
    }

    public final boolean h()
    {
        return a.getBooleanQueryParameter("isMyShazamTag", false);
    }

    public final boolean i()
    {
        return a.getBooleanQueryParameter("isTrackBased", false);
    }

    public final boolean j()
    {
        return a.getBooleanQueryParameter("isAutoTag", false);
    }

    public final boolean k()
    {
        return a.getBooleanQueryParameter("isChartBased", false);
    }

    public final boolean l()
    {
        return a.getBooleanQueryParameter("isNewsFeedTrackUri", false);
    }

    public final boolean m()
    {
        return a.getBooleanQueryParameter("isFull", false);
    }
}
