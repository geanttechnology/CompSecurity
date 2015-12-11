// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import com.g.c.ad;
import com.g.c.u;
import com.shazam.android.aq.l;
import com.shazam.android.aq.q;
import com.shazam.i.m.b;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.preview.PlayerState;

// Referenced classes of package com.shazam.android.service.player:
//            MusicPlayerService, PlayerMediaButtonReceiver

public final class h
{

    final u a = com.shazam.i.m.b.a();
    final MusicPlayerService b;
    final android.support.v7.a.n.a c;
    final android.support.v4.media.MediaMetadataCompat.a d = new android.support.v4.media.MediaMetadataCompat.a();
    MediaSessionCompat e;
    PlaylistItem f;
    long g;
    private final NotificationManager h;

    public h(MusicPlayerService musicplayerservice)
    {
        b = musicplayerservice;
        h = (NotificationManager)musicplayerservice.getSystemService("notification");
        c = new android.support.v7.a.n.a(musicplayerservice);
        musicplayerservice = new q();
        Object obj = new ComponentName(b.getPackageName(), com/shazam/android/service/player/PlayerMediaButtonReceiver.getName());
        Object obj1 = new Intent("android.intent.action.MEDIA_BUTTON");
        ((Intent) (obj1)).setComponent(((ComponentName) (obj)));
        obj1 = PendingIntent.getBroadcast(b, 0, ((Intent) (obj1)), 0);
        e = new MediaSessionCompat(b, com/shazam/android/service/player/MusicPlayerService.getName(), ((ComponentName) (obj)), ((PendingIntent) (obj1)));
        obj = e;
        try
        {
            ((MediaSessionCompat) (obj)).a(3);
            ((MediaSessionCompat) (obj)).a();
        }
        catch (Exception exception)
        {
            ((MediaSessionCompat) (obj)).a(2);
            ((MediaSessionCompat) (obj)).a();
        }
        PlayerMediaButtonReceiver.a(b);
        musicplayerservice = c.a(((Integer)musicplayerservice.a()).intValue()).a(0L);
        musicplayerservice.a(2, false);
        obj = new android.support.v7.a.n.e();
        obj.b = e.b();
        musicplayerservice.a(((android.support.v4.app.u.p) (obj)));
    }

    static void a(h h1)
    {
        h1.a();
        h1.h.notify(10101, h1.c.b());
    }

    final void a()
    {
        MediaSessionCompat mediasessioncompat = e;
        Object obj = new android.support.v4.media.session.PlaybackStateCompat.a();
        byte byte0;
        if (MusicPlayerService.a() == PlayerState.PAUSED)
        {
            byte0 = 2;
        } else
        {
            byte0 = 3;
        }
        obj = ((android.support.v4.media.session.PlaybackStateCompat.a) (obj)).a(byte0);
        obj.a = g;
        mediasessioncompat.a(((android.support.v4.media.session.PlaybackStateCompat.a) (obj)).a());
        mediasessioncompat = e;
        obj = new MediaMetadataCompat(d.a, (byte)0);
        mediasessioncompat.a.a(((MediaMetadataCompat) (obj)));
    }

    // Unreferenced inner class com/shazam/android/service/player/h$1

/* anonymous class */
    final class _cls1
        implements ad
    {

        final h a;

        public final void a()
        {
            if (a.f.equals(a.b.b()))
            {
                Bitmap bitmap = BitmapFactory.decodeResource(a.b.getResources(), 0x7f0200c3);
                a.c.g = bitmap;
                a.d.a("android.media.metadata.ART", bitmap);
                a.d.a("android.media.metadata.ALBUM_ART", bitmap);
                h.a(a);
            }
        }

        public final void a(Bitmap bitmap)
        {
            if (a.f.equals(a.b.b()) && !bitmap.isRecycled())
            {
                a.c.g = bitmap;
                a.d.a("android.media.metadata.ART", bitmap);
                a.d.a("android.media.metadata.ALBUM_ART", bitmap);
                h.a(a);
            }
        }

            
            {
                a = h.this;
                super();
            }
    }

}
