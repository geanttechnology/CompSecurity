// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.model.news.Image;
import com.shazam.model.news.Overlays;
import com.shazam.server.response.news.Content;

public final class a
    implements com.shazam.b.a.a
{

    private final com.shazam.b.a.a a;
    private final com.shazam.b.a.a b;

    public a(com.shazam.b.a.a a1, com.shazam.b.a.a a2)
    {
        a = a1;
        b = a2;
    }

    public final Object a(Object obj)
    {
        Object obj1 = (Content)obj;
        obj = com.shazam.model.news.Content.Builder.a();
        obj.attribution = ((Content) (obj1)).attribution;
        obj.headline = ((Content) (obj1)).headline;
        obj.context = ((Content) (obj1)).context;
        obj.body = ((Content) (obj1)).body;
        com.shazam.server.response.news.Image image = ((Content) (obj1)).image;
        if (image != null)
        {
            obj.image = (Image)a.a(image);
        }
        obj1 = ((Content) (obj1)).overlays;
        if (obj1 != null)
        {
            obj.overlays = (Overlays)b.a(obj1);
        }
        return new com.shazam.model.news.Content(((com.shazam.model.news.Content.Builder) (obj)), null);
    }
}
