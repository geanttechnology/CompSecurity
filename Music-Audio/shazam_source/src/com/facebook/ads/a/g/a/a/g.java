// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g.a.a;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.VideoView;

// Referenced classes of package com.facebook.ads.a.g.a.a:
//            e, c, b

public final class g extends VideoView
    implements android.media.MediaPlayer.OnPreparedListener, e
{

    private View a;
    private Uri b;
    private b c;

    public g(Context context)
    {
        super(context);
    }

    public final void a(View view, Uri uri)
    {
        a = view;
        b = uri;
        setOnPreparedListener(this);
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        mediaplayer.setLooping(true);
        mediaplayer.setOnInfoListener(new c(a));
        if (c != null)
        {
            c.a(mediaplayer);
        }
    }

    public final void pause()
    {
        a.setVisibility(0);
        stopPlayback();
    }

    public final void setFrameVideoViewListener(b b1)
    {
        c = b1;
    }

    public final void start()
    {
        setVideoURI(b);
        super.start();
    }
}
