// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import java.io.IOException;

public final class lv
{

    private final Activity a;
    private MediaPlayer b;
    private boolean c;
    private boolean d;

    public lv(Activity activity)
    {
        a = activity;
        b = null;
        a();
    }

    private static MediaPlayer a(Context context)
    {
        MediaPlayer mediaplayer = new MediaPlayer();
        mediaplayer.setAudioStreamType(3);
        mediaplayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mediaplayer1)
            {
                mediaplayer1.seekTo(0);
            }

        });
        context = context.getResources().openRawResourceFd(0x7f070000);
        try
        {
            mediaplayer.setDataSource(context.getFileDescriptor(), context.getStartOffset(), context.getLength());
            context.close();
            mediaplayer.setVolume(0.1F, 0.1F);
            mediaplayer.prepare();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return mediaplayer;
    }

    private static boolean a(SharedPreferences sharedpreferences, Context context)
    {
        return ((AudioManager)context.getSystemService("audio")).getRingerMode() == 2;
    }

    public void a()
    {
        c = a(PreferenceManager.getDefaultSharedPreferences(a), ((Context) (a)));
        d = true;
        if (c && b == null)
        {
            a.setVolumeControlStream(3);
            b = a(((Context) (a)));
        }
    }

    public void b()
    {
        if (c && b != null)
        {
            b.start();
        }
        if (d)
        {
            ((Vibrator)a.getSystemService("vibrator")).vibrate(200L);
        }
    }
}
