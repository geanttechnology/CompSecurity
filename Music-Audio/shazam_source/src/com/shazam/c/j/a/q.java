// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.news.Image;
import com.shazam.server.response.news.Overlays;

public final class q
    implements a
{

    private final a a;

    public q(a a1)
    {
        a = a1;
    }

    public final Object a(Object obj)
    {
        obj = (Overlays)obj;
        com.shazam.model.news.Overlays.Builder builder = com.shazam.model.news.Overlays.Builder.a();
        builder.title = ((Overlays) (obj)).title;
        builder.subtitle = ((Overlays) (obj)).subtitle;
        builder.image = (Image)a.a(((Overlays) (obj)).image);
        return new com.shazam.model.news.Overlays(builder, null);
    }
}
