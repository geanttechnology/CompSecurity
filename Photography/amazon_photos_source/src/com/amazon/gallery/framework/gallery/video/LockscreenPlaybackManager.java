// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            GalleryVideoViewer

public class LockscreenPlaybackManager
{

    private static final int STOP_PLAYBACK_DELAY_MS;
    private static final String TAG = com/amazon/gallery/framework/gallery/video/LockscreenPlaybackManager.getName();
    private boolean appHasFocus;
    private Context context;
    private GalleryVideoViewer galleryVideoViewer;
    private boolean isScreenOff;
    private boolean isShutdown;
    private boolean resumeOnWindowFocus;
    private BroadcastReceiver screenOffBroadcastReceiver;
    private BroadcastReceiver stopPlaybackBroadcastReceiver;
    private boolean wasPlayingOnAppPause;

    public LockscreenPlaybackManager(GalleryVideoViewer galleryvideoviewer)
    {
        isScreenOff = false;
        isShutdown = false;
        galleryVideoViewer = galleryvideoviewer;
        context = galleryvideoviewer.getContext();
    }

    private void cancelStopPlaybackAlarm()
    {
        ((AlarmManager)context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent("com.amazon.photos.STOP_PLAYBACK_CALLBACK"), 0));
        unregisterStopPlayBackBroadcastReceiver();
    }

    private void pausePlayback()
    {
        setStopPlaybackAlarm();
        wasPlayingOnAppPause = galleryVideoViewer.isPlaying();
        galleryVideoViewer.pauseVideo();
    }

    private void registerScreenOffBroadcastReceiver()
    {
        if (screenOffBroadcastReceiver == null)
        {
            GLogger.i(TAG, "register screen off broadcast receiver", new Object[0]);
            screenOffBroadcastReceiver = new BroadcastReceiver() {

                final LockscreenPlaybackManager this$0;

                public void onReceive(Context context1, Intent intent)
                {
                    GLogger.i(LockscreenPlaybackManager.TAG, "Screen is turned off", new Object[0]);
                    isScreenOff = true;
                    unregisterScreenOffBroadcastReceiver();
                }

            
            {
                this$0 = LockscreenPlaybackManager.this;
                super();
            }
            };
            context.registerReceiver(screenOffBroadcastReceiver, new IntentFilter("android.intent.action.SCREEN_OFF"));
        }
    }

    private void registerStopPlayBackBroadcastReceiver()
    {
        stopPlaybackBroadcastReceiver = new BroadcastReceiver() {

            final LockscreenPlaybackManager this$0;

            public void onReceive(Context context1, Intent intent)
            {
                galleryVideoViewer.stopVideoPlayer();
                unregisterBroadcastReceivers();
            }

            
            {
                this$0 = LockscreenPlaybackManager.this;
                super();
            }
        };
        context.registerReceiver(stopPlaybackBroadcastReceiver, new IntentFilter("com.amazon.photos.STOP_PLAYBACK_CALLBACK"));
    }

    private void resumePlayback()
    {
        resumeOnWindowFocus = false;
        cancelStopPlaybackAlarm();
        galleryVideoViewer.resumeVideoPlayer();
        if (wasPlayingOnAppPause)
        {
            galleryVideoViewer.resumeVideo();
        }
    }

    private void setStopPlaybackAlarm()
    {
        if (stopPlaybackBroadcastReceiver != null)
        {
            return;
        } else
        {
            registerStopPlayBackBroadcastReceiver();
            AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
            PendingIntent pendingintent = PendingIntent.getBroadcast(context, 0, new Intent("com.amazon.photos.STOP_PLAYBACK_CALLBACK"), 0);
            alarmmanager.set(2, SystemClock.elapsedRealtime() + (long)STOP_PLAYBACK_DELAY_MS, pendingintent);
            return;
        }
    }

    private void unregisterBroadcastReceivers()
    {
        unregisterStopPlayBackBroadcastReceiver();
        unregisterScreenOffBroadcastReceiver();
    }

    private void unregisterScreenOffBroadcastReceiver()
    {
        if (screenOffBroadcastReceiver != null)
        {
            GLogger.i(TAG, "unregister screen off broadcast receiver", new Object[0]);
            context.unregisterReceiver(screenOffBroadcastReceiver);
            screenOffBroadcastReceiver = null;
        }
    }

    private void unregisterStopPlayBackBroadcastReceiver()
    {
        if (stopPlaybackBroadcastReceiver != null)
        {
            context.unregisterReceiver(stopPlaybackBroadcastReceiver);
            stopPlaybackBroadcastReceiver = null;
        }
    }

    public void onPause()
    {
        if (isShutdown)
        {
            return;
        } else
        {
            resumeOnWindowFocus = false;
            pausePlayback();
            return;
        }
    }

    public void onResume()
    {
        if (appHasFocus || isScreenOff)
        {
            resumePlayback();
        } else
        {
            resumeOnWindowFocus = true;
        }
        isScreenOff = false;
    }

    public void onWindowFocusChanged(boolean flag)
    {
        appHasFocus = flag;
        if (appHasFocus && resumeOnWindowFocus)
        {
            resumePlayback();
        }
    }

    public void shutdown()
    {
        unregisterBroadcastReceivers();
        isShutdown = true;
    }

    public void start()
    {
        registerScreenOffBroadcastReceiver();
        isShutdown = false;
    }

    static 
    {
        STOP_PLAYBACK_DELAY_MS = (int)TimeUnit.MINUTES.toMillis(5L);
    }





/*
    static boolean access$302(LockscreenPlaybackManager lockscreenplaybackmanager, boolean flag)
    {
        lockscreenplaybackmanager.isScreenOff = flag;
        return flag;
    }

*/

}
