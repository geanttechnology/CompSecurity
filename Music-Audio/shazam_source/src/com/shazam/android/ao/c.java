// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ao;

import com.shazam.b.a.e;
import com.shazam.b.e.a;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.player.ProviderPlaybackIds;

public final class c
    implements e
{

    public c()
    {
    }

    public final boolean apply(Object obj)
    {
        obj = (PlaylistItem)obj;
        return obj != null && a.c(((PlaylistItem) (obj)).a().a(PlaybackProvider.PREVIEW));
    }
}
