// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;


// Referenced classes of package com.shazam.server.response.config:
//            AmpStyles, AmpHome, AmpOnboarding, AmpVisual

public static class _cls9
{

    private AmpHome ampHome;
    private AmpOnboarding ampOnboarding;
    private AmpVisual ampVisual;
    private String caption;

    public static _cls9 ampStyles()
    {
        return new <init>();
    }

    public AmpStyles build()
    {
        return new AmpStyles(this, null);
    }

    public <init> withAmpHome(AmpHome amphome)
    {
        ampHome = amphome;
        return this;
    }

    public ampHome withAmpOnboarding(AmpOnboarding amponboarding)
    {
        ampOnboarding = amponboarding;
        return this;
    }

    public ampOnboarding withAmpVisual(AmpVisual ampvisual)
    {
        ampVisual = ampvisual;
        return this;
    }

    public ampVisual withCaption(String s)
    {
        caption = s;
        return this;
    }





    public _cls9()
    {
    }
}
