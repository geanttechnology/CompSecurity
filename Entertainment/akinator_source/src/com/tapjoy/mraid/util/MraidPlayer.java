// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.listener.Player;

// Referenced classes of package com.tapjoy.mraid.util:
//            Utils

public class MraidPlayer extends VideoView
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    private static String h = "Loading. Please Wait..";
    private static String i = "MRAID Player";
    private com.tapjoy.mraid.controller.Abstract.PlayerProperties a;
    private AudioManager b;
    private Player c;
    private int d;
    private String e;
    private RelativeLayout f;
    private ImageButton g;
    private boolean j;

    public MraidPlayer(Context context)
    {
        super(context);
        b = (AudioManager)getContext().getSystemService("audio");
    }

    private void a()
    {
        e = e.trim();
        e = Utils.convert(e);
        if (e == null && c != null)
        {
            b();
            c.onError();
        } else
        {
            setVideoURI(Uri.parse(e));
            TapjoyLog.d("player", Uri.parse(e).toString());
            if (a.showControl())
            {
                MediaController mediacontroller = new MediaController(getContext());
                setMediaController(mediacontroller);
                mediacontroller.setAnchorView(this);
            }
            setOnCompletionListener(this);
            setOnErrorListener(this);
            setOnPreparedListener(this);
            if (!a.inline && !a.inline)
            {
                f = new RelativeLayout(getContext());
                f.setLayoutParams(getLayoutParams());
                TextView textview = new TextView(getContext());
                textview.setText(h);
                textview.setTextColor(-1);
                android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                layoutparams.addRule(13);
                f.addView(textview, layoutparams);
                ((ViewGroup)getParent()).addView(f);
            }
            if (a.isAutoPlay())
            {
                start();
                return;
            }
        }
    }

    private void b()
    {
        ViewGroup viewgroup = (ViewGroup)getParent();
        if (viewgroup != null)
        {
            viewgroup.removeAllViews();
        }
    }

    private void c()
    {
        if (f != null)
        {
            ((ViewGroup)getParent()).removeView(f);
        }
    }

    public ImageButton getCloseImageButton()
    {
        return g;
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        if (a.doLoop())
        {
            start();
        } else
        if (a.exitOnComplete() || a.inline)
        {
            releasePlayer();
            return;
        }
    }

    public boolean onError(MediaPlayer mediaplayer, int k, int l)
    {
        TapjoyLog.i(i, (new StringBuilder("Player error : ")).append(k).toString());
        c();
        b();
        if (c != null)
        {
            c.onError();
        }
        return false;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        c();
        if (c != null)
        {
            c.onPrepared();
        }
    }

    public void playAudio()
    {
        a();
    }

    public void playVideo()
    {
        if (a.doMute())
        {
            d = b.getStreamVolume(3);
            b.setStreamVolume(3, 0, 4);
        }
        a();
    }

    public void releasePlayer()
    {
        if (!j)
        {
            j = true;
            stopPlayback();
            b();
            if (a != null && a.doMute())
            {
                b.setStreamVolume(3, d, 4);
            }
            if (c != null)
            {
                c.onComplete();
                return;
            }
        }
    }

    public void setListener(Player player)
    {
        c = player;
    }

    public void setPlayData(com.tapjoy.mraid.controller.Abstract.PlayerProperties playerproperties, String s)
    {
        j = false;
        a = playerproperties;
        e = s;
    }

}
