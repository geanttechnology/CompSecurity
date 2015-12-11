// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;

public class LocalNotificationService extends Service
{

    String artist;
    String artistId;
    String context;
    String itemCount;
    private NotificationManager mManager;
    String playlistId;
    String playlistName;
    int serviceId;
    String smallContext;
    String smallTitle;
    Boolean sound;
    int tab;
    int type;
    String url;

    public LocalNotificationService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public int onStartCommand(final Intent pendingNotificationIntent, int i, int j)
    {
        pendingNotificationIntent = pendingNotificationIntent.getExtras();
        type = pendingNotificationIntent.getInt("type");
        sound = Boolean.valueOf(pendingNotificationIntent.getBoolean("sound"));
        tab = pendingNotificationIntent.getInt("tab");
        serviceId = pendingNotificationIntent.getInt("serviceId");
        if (type != 0) goto _L2; else goto _L1
_L1:
        artist = pendingNotificationIntent.getString("artist");
        playlistId = pendingNotificationIntent.getString("playlistId");
        artistId = pendingNotificationIntent.getString("artistId");
        playlistName = pendingNotificationIntent.getString("playlistName");
        url = pendingNotificationIntent.getString("url");
        itemCount = pendingNotificationIntent.getString("itemCount");
        mManager = (NotificationManager)getApplicationContext().getSystemService("notification");
        pendingNotificationIntent = new Intent(getApplicationContext(), com/mixerbox/mixerbox3b/MainPage);
        final PendingIntent pendingNotificationIntentPlay = new Bundle();
        pendingNotificationIntentPlay.putInt("tab", tab);
        pendingNotificationIntentPlay.putInt("play", 0);
        pendingNotificationIntentPlay.putBoolean("subscribe", false);
        pendingNotificationIntentPlay.putString("playlistId", playlistId);
        pendingNotificationIntentPlay.putString("itemCount", itemCount);
        pendingNotificationIntentPlay.putString("artistId", artistId);
        pendingNotificationIntentPlay.putString("artist", artist);
        pendingNotificationIntentPlay.putString("url", url);
        pendingNotificationIntentPlay.putString("playlistName", playlistName);
        pendingNotificationIntent.putExtras(pendingNotificationIntentPlay);
        pendingNotificationIntent.addFlags(0x24000000);
        pendingNotificationIntent = PendingIntent.getActivity(getApplicationContext(), serviceId + 456, pendingNotificationIntent, 0x8000000);
        pendingNotificationIntentPlay = new Intent(getApplicationContext(), com/mixerbox/mixerbox3b/MainPage);
        final PendingIntent pendingNotificationIntentSubscribe = new Bundle();
        pendingNotificationIntentSubscribe.putInt("tab", tab);
        pendingNotificationIntentSubscribe.putInt("play", 1);
        pendingNotificationIntentSubscribe.putBoolean("subscribe", false);
        pendingNotificationIntentSubscribe.putString("playlistId", playlistId);
        pendingNotificationIntentSubscribe.putString("playlistName", playlistName);
        pendingNotificationIntentSubscribe.putString("itemCount", itemCount);
        pendingNotificationIntentSubscribe.putString("artistId", artistId);
        pendingNotificationIntentSubscribe.putString("artist", artist);
        pendingNotificationIntentSubscribe.putString("url", url);
        pendingNotificationIntentPlay.putExtras(pendingNotificationIntentSubscribe);
        pendingNotificationIntentPlay.addFlags(0x24000000);
        pendingNotificationIntentPlay = PendingIntent.getActivity(getApplicationContext(), serviceId + 123, pendingNotificationIntentPlay, 0x8000000);
        pendingNotificationIntentSubscribe = new Intent(getApplicationContext(), com/mixerbox/mixerbox3b/MainPage);
        Object obj = new Bundle();
        ((Bundle) (obj)).putInt("tab", tab);
        ((Bundle) (obj)).putInt("play", -1);
        ((Bundle) (obj)).putBoolean("subscribe", true);
        ((Bundle) (obj)).putString("playlistId", playlistId);
        ((Bundle) (obj)).putString("playlistName", playlistName);
        ((Bundle) (obj)).putString("itemCount", itemCount);
        ((Bundle) (obj)).putString("artistId", artistId);
        ((Bundle) (obj)).putString("artist", artist);
        ((Bundle) (obj)).putString("url", url);
        pendingNotificationIntentSubscribe.putExtras(((Bundle) (obj)));
        pendingNotificationIntentSubscribe.addFlags(0x24000000);
        pendingNotificationIntentSubscribe = PendingIntent.getActivity(getApplicationContext(), serviceId + 234, pendingNotificationIntentSubscribe, 0x8000000);
        obj = new MixerBoxSQLite(this);
        ((MixerBoxSQLite) (obj)).putHasPushed(playlistId, playlistName, artistId, artist, itemCount, "0", url);
        ((MixerBoxSQLite) (obj)).close();
        (new Thread(new _cls1())).start();
_L4:
        return 2;
_L2:
        if (type == 1)
        {
            smallTitle = pendingNotificationIntent.getString("smallTitle");
            smallContext = pendingNotificationIntent.getString("smallContext");
            context = pendingNotificationIntent.getString("context");
            mManager = (NotificationManager)getApplicationContext().getSystemService("notification");
            pendingNotificationIntent = new Intent(getApplicationContext(), com/mixerbox/mixerbox3b/MainPage);
            Bundle bundle = new Bundle();
            bundle.putInt("tab", tab);
            pendingNotificationIntent.putExtras(bundle);
            pendingNotificationIntent.addFlags(0x24000000);
            (new Thread(new _cls2())).start();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }


    private class _cls1
        implements Runnable
    {

        final LocalNotificationService this$0;
        final PendingIntent val$pendingNotificationIntent;
        final PendingIntent val$pendingNotificationIntentPlay;
        final PendingIntent val$pendingNotificationIntentSubscribe;

        public void run()
        {
            Object obj = (new StringBuilder()).append(getResources().getString(0x7f080132)).append(artist).append(getResources().getString(0x7f080133)).append(playlistName).append(getResources().getString(0x7f080134)).toString();
            if (getResources().getString(0x7f080135).equals("false"))
            {
                obj = (new StringBuilder()).append(getResources().getString(0x7f080132)).append(playlistName).append(getResources().getString(0x7f080133)).append(artist).append(getResources().getString(0x7f080134)).toString();
            }
            obj = (new android.support.v4.app.NotificationCompat.Builder(LocalNotificationService.this)).setOngoing(true).setSmallIcon(0x7f02010e).setLargeIcon(BitmapFactory.decodeResource(getResources(), 0x7f0200df)).setContentIntent(pendingNotificationIntent).setContentTitle(getResources().getString(0x7f080131)).setContentText((new StringBuilder()).append(artist).append(" - ").append(playlistName).toString()).setTicker(((CharSequence) (obj))).build();
            obj.flags = 16;
            if (sound.booleanValue())
            {
                obj.defaults = -1;
            }
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                RemoteViews remoteviews = new RemoteViews(getPackageName(), 0x7f03003e);
                remoteviews.setImageViewBitmap(0x7f07004a, MixerBoxUtils.getBitmapFromURL(url));
                remoteviews.setTextViewText(0x7f0700b3, (new StringBuilder()).append(artist).append(" - ").append(playlistName).toString());
                remoteviews.setOnClickPendingIntent(0x7f0700b4, pendingNotificationIntentSubscribe);
                remoteviews.setOnClickPendingIntent(0x7f0700b5, pendingNotificationIntentPlay);
                obj.bigContentView = remoteviews;
            }
            mManager.notify(serviceId, ((Notification) (obj)));
        }

        _cls1()
        {
            this$0 = LocalNotificationService.this;
            pendingNotificationIntent = pendingintent;
            pendingNotificationIntentSubscribe = pendingintent1;
            pendingNotificationIntentPlay = pendingintent2;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final LocalNotificationService this$0;
        final PendingIntent val$pendingNotificationIntent;

        public void run()
        {
            Notification notification = (new android.support.v4.app.NotificationCompat.Builder(LocalNotificationService.this)).setOngoing(true).setSmallIcon(0x7f02010e).setContentIntent(pendingNotificationIntent).setContentTitle(smallTitle).setLargeIcon(BitmapFactory.decodeResource(getResources(), 0x7f0200df)).setContentText(smallContext).setTicker(context).build();
            notification.flags = 16;
            if (sound.booleanValue())
            {
                notification.defaults = -1;
            }
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                RemoteViews remoteviews = new RemoteViews(getPackageName(), 0x7f03003f);
                remoteviews.setTextViewText(0x7f070075, context);
                notification.bigContentView = remoteviews;
            }
            mManager.notify(serviceId, notification);
        }

        _cls2()
        {
            this$0 = LocalNotificationService.this;
            pendingNotificationIntent = pendingintent;
            super();
        }
    }

}
