// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ai;

import com.shazam.i.b.ah.f.a;
import com.shazam.i.b.ah.f.e;
import com.shazam.model.player.DbPlaylistItemStatusChecker;
import com.shazam.model.player.PlaylistItemStatusChecker;

public final class c
{

    public static PlaylistItemStatusChecker a()
    {
        return new DbPlaylistItemStatusChecker(com.shazam.i.b.ah.f.a.a(), e.a());
    }
}
