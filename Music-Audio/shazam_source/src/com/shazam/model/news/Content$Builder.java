// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;


// Referenced classes of package com.shazam.model.news:
//            Content, Image, Overlays

public static class 
{

    public String attribution;
    public String body;
    public String context;
    public String headline;
    public Image image;
    public Overlays overlays;

    public static  a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.attribution;
    }

    static String b(attribution attribution1)
    {
        return attribution1.headline;
    }

    static String c(headline headline1)
    {
        return headline1.body;
    }

    static String d(body body1)
    {
        return body1.context;
    }

    static Image e(context context1)
    {
        return context1.image;
    }

    static Overlays f(image image1)
    {
        return image1.overlays;
    }

    public ()
    {
    }
}
