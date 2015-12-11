// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import com.shazam.android.util.s;

// Referenced classes of package com.shazam.android.service.player:
//            MusicPlayerService

final class a
    implements Runnable
{

    final MusicPlayerService a;

    public final void run()
    {
        MusicPlayerService.a(a).a(MusicPlayerService.k());
    }

    (MusicPlayerService musicplayerservice)
    {
        a = musicplayerservice;
        super();
    }
}
