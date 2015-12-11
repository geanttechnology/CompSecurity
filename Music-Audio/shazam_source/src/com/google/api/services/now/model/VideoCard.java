// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;

// Referenced classes of package com.google.api.services.now.model:
//            TemplatedString, Image, TappableImage

public final class VideoCard extends b
{

    private String backgroundColor;
    private TemplatedString content;
    private Long durationSeconds;
    private Image logo;
    private TappableImage tappableImage;
    private TemplatedString title;

    public VideoCard()
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

    public final VideoCard clone()
    {
        return (VideoCard)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final String getBackgroundColor()
    {
        return backgroundColor;
    }

    public final TemplatedString getContent()
    {
        return content;
    }

    public final Long getDurationSeconds()
    {
        return durationSeconds;
    }

    public final Image getLogo()
    {
        return logo;
    }

    public final TappableImage getTappableImage()
    {
        return tappableImage;
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

    public final VideoCard set(String s, Object obj)
    {
        return (VideoCard)super.set(s, obj);
    }

    public final VideoCard setBackgroundColor(String s)
    {
        backgroundColor = s;
        return this;
    }

    public final VideoCard setContent(TemplatedString templatedstring)
    {
        content = templatedstring;
        return this;
    }

    public final VideoCard setDurationSeconds(Long long1)
    {
        durationSeconds = long1;
        return this;
    }

    public final VideoCard setLogo(Image image)
    {
        logo = image;
        return this;
    }

    public final VideoCard setTappableImage(TappableImage tappableimage)
    {
        tappableImage = tappableimage;
        return this;
    }

    public final VideoCard setTitle(TemplatedString templatedstring)
    {
        title = templatedstring;
        return this;
    }
}
