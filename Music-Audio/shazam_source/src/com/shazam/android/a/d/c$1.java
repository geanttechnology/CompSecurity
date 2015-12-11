// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.d;

import com.shazam.model.news.FeedCardType;

// Referenced classes of package com.shazam.android.a.d:
//            c

static final class ardType
{

    static final int a[];

    static 
    {
        a = new int[FeedCardType.values().length];
        try
        {
            a[FeedCardType.TAG.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[FeedCardType.TRACK.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[FeedCardType.ARTIST_POST.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
