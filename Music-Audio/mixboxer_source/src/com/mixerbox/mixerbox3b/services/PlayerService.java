// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.mixerbox.mixerbox3b.MainPage;

public class PlayerService extends Service
{

    public static final String BITMAP = "bitmap";
    public static final String IS_PLAYING = "is_playing";
    public static final String SONG_NAME = "song_name";
    public static final String SONG_SOURCE = "song_source";
    public static final String URL = "url";

    public PlayerService()
    {
    }

    private void play(String s, String s1, boolean flag, int i, Bitmap bitmap)
    {
        Object obj = new Intent(this, com/mixerbox/mixerbox3b/MainPage);
        ((Intent) (obj)).setFlags(0x24000000);
        Object obj1 = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0x8000000);
        obj = new Intent("PlayerBroadcastReceiver");
        ((Intent) (obj)).putExtra("player", 1);
        obj = PendingIntent.getBroadcast(this, 1, ((Intent) (obj)), 0x8000000);
        Object obj2 = new Intent("PlayerBroadcastReceiver");
        ((Intent) (obj2)).putExtra("player", 2);
        obj2 = PendingIntent.getBroadcast(this, 2, ((Intent) (obj2)), 0x8000000);
        Object obj3 = new Intent("PlayerBroadcastReceiver");
        ((Intent) (obj3)).putExtra("player", 3);
        obj3 = PendingIntent.getBroadcast(this, 3, ((Intent) (obj3)), 0x8000000);
        Object obj4 = new Intent("PlayerBroadcastReceiver");
        ((Intent) (obj4)).putExtra("player", 4);
        obj4 = PendingIntent.getBroadcast(this, 4, ((Intent) (obj4)), 0x8000000);
        RemoteViews remoteviews = new RemoteViews(getPackageName(), 0x7f030043);
        remoteviews.setOnClickPendingIntent(0x7f0700ed, ((PendingIntent) (obj)));
        remoteviews.setOnClickPendingIntent(0x7f0700ec, ((PendingIntent) (obj2)));
        remoteviews.setOnClickPendingIntent(0x7f0700ee, ((PendingIntent) (obj3)));
        remoteviews.setOnClickPendingIntent(0x7f0700ef, ((PendingIntent) (obj4)));
        if (flag)
        {
            remoteviews.setImageViewResource(0x7f0700ed, 0x7f0200ed);
        } else
        {
            remoteviews.setImageViewResource(0x7f0700ed, 0x7f0200ef);
        }
        remoteviews.setTextViewText(0x7f0700ea, s);
        if (i == 2)
        {
            if (s1.length() > 0)
            {
                remoteviews.setImageViewUri(0x7f0700e8, Uri.parse(s1));
            }
        } else
        if (bitmap != null)
        {
            remoteviews.setImageViewBitmap(0x7f0700e8, bitmap);
        }
        obj1 = (new android.support.v4.app.NotificationCompat.Builder(getApplicationContext())).setOngoing(false).setSmallIcon(0x7f0200df).setContentTitle("MixerBox 2").setContentText(s).setContentIntent(((PendingIntent) (obj1))).setWhen(0L).build();
        obj1.flags = ((Notification) (obj1)).flags | 0x20;
        obj1.contentView = remoteviews;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            remoteviews = new RemoteViews(getPackageName(), 0x7f030042);
            remoteviews.setOnClickPendingIntent(0x7f0700ed, ((PendingIntent) (obj)));
            remoteviews.setOnClickPendingIntent(0x7f0700ec, ((PendingIntent) (obj2)));
            remoteviews.setOnClickPendingIntent(0x7f0700ee, ((PendingIntent) (obj3)));
            remoteviews.setOnClickPendingIntent(0x7f0700ef, ((PendingIntent) (obj4)));
            if (flag)
            {
                remoteviews.setImageViewResource(0x7f0700ed, 0x7f0200ed);
            } else
            {
                remoteviews.setImageViewResource(0x7f0700ed, 0x7f0200ef);
            }
            if (i == 2)
            {
                if (s1.length() > 0)
                {
                    remoteviews.setImageViewUri(0x7f0700e8, Uri.parse(s1));
                }
            } else
            if (bitmap != null)
            {
                remoteviews.setImageViewBitmap(0x7f0700e8, bitmap);
            }
            remoteviews.setTextViewText(0x7f0700ea, s);
            obj1.bigContentView = remoteviews;
        }
        startForeground(16, ((Notification) (obj1)));
    }

    private void stop()
    {
        stopForeground(true);
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onDestroy()
    {
        stopForeground(true);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        String s = intent.getStringExtra("song_name");
        String s1 = intent.getStringExtra("url");
        boolean flag = intent.getBooleanExtra("is_playing", true);
        Bitmap bitmap = (Bitmap)intent.getParcelableExtra("bitmap");
        play(s, s1, flag, intent.getIntExtra("song_source", 1), bitmap);
        return 2;
    }
}
