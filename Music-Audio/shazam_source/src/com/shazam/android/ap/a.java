// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ap;

import android.net.Uri;
import com.shazam.android.ag.h.b;
import com.shazam.android.ag.h.c;
import com.shazam.android.ay.c.j;
import com.shazam.android.ay.c.l;
import com.shazam.android.ay.c.m;
import com.shazam.android.ay.c.p;
import com.shazam.android.k.f.r;
import com.shazam.android.k.f.s;
import com.shazam.android.view.tagging.f;
import com.shazam.model.Cache;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.model.TrackStyle;
import com.shazam.model.analytics.TaggedBeaconSender;
import com.shazam.model.details.TagAdder;
import com.shazam.model.tag.MiniTagResultItem;

public final class com.shazam.android.ap.a
{
    private final class a
        implements m
    {

        final com.shazam.android.ap.a a;

        public final void onError(com.shazam.android.ay.b b1, com.shazam.android.d.c c1)
        {
            public static final class _cls1
            {

                public static final int a[];
                static final int b[];

                static 
                {
                    b = new int[com.shazam.android.ay.b.values().length];
                    try
                    {
                        b[com.shazam.android.ay.b.c.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    a = new int[com.shazam.android.ag.h.b.values().length];
                    try
                    {
                        a[com.shazam.android.ag.h.b.c.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[com.shazam.android.ag.h.b.a.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (com.shazam.android.ap._cls1.b[b1.ordinal()])
            {
            default:
                com.shazam.android.ap.a a1 = a;
                (new StringBuilder("Error performing recognition. Error type: ")).append(b1).append(". Error branding: ").append(c1);
                a1.a();
                return;

            case 1: // '\001'
                a.b(com.shazam.android.ag.h.b.e);
                break;
            }
            a.a(com.shazam.android.ag.h.b.e);
        }

        private a()
        {
            a = com.shazam.android.ap.a.this;
            super();
        }

        public a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements p
    {

        final com.shazam.android.ap.a a;

        public final void a(Uri uri)
        {
            Object obj1 = null;
            Object obj = a.a(uri);
            TaggedBeaconSender taggedbeaconsender;
            if (obj != null)
            {
                obj = ((Tag) (obj)).track;
            } else
            {
                obj = null;
            }
            taggedbeaconsender = a.d;
            if (obj != null)
            {
                obj1 = ((Track) (obj)).trackStyle.getStyle();
            }
            taggedbeaconsender.sendTagInfo(((String) (obj1)));
            obj = a;
            obj1 = new com.shazam.android.ag.h.a();
            obj1.b = true;
            obj1.a = uri;
            ((com.shazam.android.ap.a) (obj)).a(((com.shazam.android.ag.h.a) (obj1)).a());
        }

        private b()
        {
            a = com.shazam.android.ap.a.this;
            super();
        }

        public b(byte byte0)
        {
            this();
        }
    }

    private final class c
        implements com.shazam.android.ay.c.r
    {

        final com.shazam.android.ap.a a;

        public final void e()
        {
            a.d.sendTagInfo(null);
            a.b();
        }

        private c()
        {
            a = com.shazam.android.ap.a.this;
            super();
        }

        public c(byte byte0)
        {
            this();
        }
    }

    private final class d
        implements l
    {

        final com.shazam.android.ap.a a;

        public final void a()
        {
            if (!a.a.b().j)
            {
                a.c.a();
            }
        }

        private d()
        {
            a = com.shazam.android.ap.a.this;
            super();
        }

        public d(byte byte0)
        {
            this();
        }
    }


    public final com.shazam.android.ag.h.c a;
    public final j b;
    final f c;
    final TaggedBeaconSender d;
    private final Cache e;
    private final TagAdder f;
    private final com.shazam.b.a.a g;
    private final com.shazam.b.a.a h;

    public com.shazam.android.ap.a(f f1, TagAdder tagadder, Cache cache, com.shazam.b.a.a a1, com.shazam.b.a.a a2, com.shazam.android.ag.h.c c1, j j, 
            TaggedBeaconSender taggedbeaconsender)
    {
        c = f1;
        f = tagadder;
        e = cache;
        g = a1;
        h = a2;
        b = j;
        a = c1;
        d = taggedbeaconsender;
    }

    final Tag a(Uri uri)
    {
        uri = r.a(uri);
        if (uri != null)
        {
            return (Tag)e.a(((r) (uri)).c.d);
        } else
        {
            return null;
        }
    }

    final void a()
    {
        b(com.shazam.android.ag.h.b.f);
        a(com.shazam.android.ag.h.b.f);
    }

    public final void a(com.shazam.android.ag.h.a a1)
    {
        Uri uri = a1.a;
        Object obj = a(uri);
        if (obj == null)
        {
            (new StringBuilder("Internal error while performing recognition. Engine returned match, but no tag found in tag cache. Uri found was: ")).append(uri);
            a();
            return;
        }
        obj = (MiniTagResultItem)g.a(obj);
        if (obj != null)
        {
            if (a1.b)
            {
                a1 = (Tag)h.a(obj);
                TagAdder tagadder = f;
                com.shazam.model.details.AddToListActionInfo.Builder builder = com.shazam.model.details.AddToListActionInfo.Builder.a();
                builder.tag = a1;
                tagadder.a(builder.b());
                f.a(((MiniTagResultItem) (obj)).tagId);
            }
            c.a(((MiniTagResultItem) (obj)));
            a(com.shazam.android.ag.h.b.c);
            a1 = a;
            obj = new com.shazam.android.ag.h.a();
            obj.a = uri;
            obj.b = false;
            a1.a(((com.shazam.android.ag.h.a) (obj)).a());
            return;
        } else
        {
            b();
            return;
        }
    }

    public final void a(com.shazam.android.ag.h.b b1)
    {
        a.a(b1);
    }

    final void b()
    {
        a(com.shazam.android.ag.h.b.d);
        b(com.shazam.android.ag.h.b.d);
    }

    public final void b(com.shazam.android.ag.h.b b1)
    {
        c.a(b1);
    }
}
