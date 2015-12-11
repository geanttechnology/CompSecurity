// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shazam.model.preview.PlayerState;

// Referenced classes of package com.shazam.android.service.player:
//            MusicPlayerService

final class a extends BroadcastReceiver
{

    final MusicPlayerService a;

    public final void onReceive(Context context, Intent intent)
    {
        if (MusicPlayerService.j() == PlayerState.PLAYING)
        {
            a.d();
        } else
        if (MusicPlayerService.j() == PlayerState.PREPARING)
        {
            a.c();
            return;
        }
    }

    (MusicPlayerService musicplayerservice)
    {
        a = musicplayerservice;
        super();
    }
}
