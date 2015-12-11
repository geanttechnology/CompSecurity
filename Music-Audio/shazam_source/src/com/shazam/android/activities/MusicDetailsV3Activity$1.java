// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shazam.l.e.b;
import com.shazam.model.preview.PlayerState;

// Referenced classes of package com.shazam.android.activities:
//            MusicDetailsV3Activity

final class a extends BroadcastReceiver
{

    final MusicDetailsV3Activity a;

    public final void onReceive(Context context, Intent intent)
    {
        context = (PlayerState)intent.getSerializableExtra("extraNewMusicPlayerState");
        MusicDetailsV3Activity.a(a).a(context);
    }

    (MusicDetailsV3Activity musicdetailsv3activity)
    {
        a = musicdetailsv3activity;
        super();
    }
}
