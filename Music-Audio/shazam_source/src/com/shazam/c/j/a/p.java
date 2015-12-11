// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.server.response.news.Dimensions;
import com.shazam.server.response.news.Image;

public final class p
    implements a
{

    public p()
    {
    }

    public final Object a(Object obj)
    {
        Object obj1 = (Image)obj;
        obj = com.shazam.model.news.Image.Builder.a();
        obj.url = ((Image) (obj1)).url;
        obj1 = ((Image) (obj1)).dimensions;
        obj.aspectRatio = (float)((Dimensions) (obj1)).height / (float)((Dimensions) (obj1)).width;
        return new com.shazam.model.news.Image(((com.shazam.model.news.Image.Builder) (obj)), null);
    }
}
