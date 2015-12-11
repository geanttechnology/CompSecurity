// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.model.player.PlaybackProvider;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            PlayerEventFactory

static class 
{

    static final int a[];

    static 
    {
        a = new int[PlaybackProvider.values().length];
        try
        {
            a[PlaybackProvider.RDIO.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[PlaybackProvider.SPOTIFY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
