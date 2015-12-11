// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.player;

import com.shazam.k.c;
import com.shazam.k.s;

// Referenced classes of package com.shazam.model.player:
//            PlaylistItemStatusChecker, PlayerItemStatus

public class DbPlaylistItemStatusChecker
    implements PlaylistItemStatusChecker
{

    private final c dislikedRepository;
    private final s tagRepository;

    public DbPlaylistItemStatusChecker(c c1, s s1)
    {
        dislikedRepository = c1;
        tagRepository = s1;
    }

    public final PlayerItemStatus a(String s1)
    {
        if (dislikedRepository.c(s1))
        {
            return PlayerItemStatus.DISLIKED;
        }
        if (tagRepository.c(s1))
        {
            return PlayerItemStatus.LIKED;
        } else
        {
            return PlayerItemStatus.NEUTRAL;
        }
    }
}
