// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            Image, TemplatedString

public final class PhotoCard extends b
{

    private Image logo;
    private List tappableImages;
    private TemplatedString title;

    public PhotoCard()
    {
    }

    public final volatile b clone()
    {
        return clone();
    }

    public final volatile l clone()
    {
        return clone();
    }

    public final PhotoCard clone()
    {
        return (PhotoCard)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final Image getLogo()
    {
        return logo;
    }

    public final List getTappableImages()
    {
        return tappableImages;
    }

    public final TemplatedString getTitle()
    {
        return title;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final PhotoCard set(String s, Object obj)
    {
        return (PhotoCard)super.set(s, obj);
    }

    public final PhotoCard setLogo(Image image)
    {
        logo = image;
        return this;
    }

    public final PhotoCard setTappableImages(List list)
    {
        tappableImages = list;
        return this;
    }

    public final PhotoCard setTitle(TemplatedString templatedstring)
    {
        title = templatedstring;
        return this;
    }
}
