// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.ViewGroup;
import android.widget.VideoView;

// Referenced classes of package com.amazon.device.ads:
//            co, cn

final class al
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }


    private static String i = com/amazon/device/ads/al.getSimpleName();
    final cn a;
    a b;
    String c;
    boolean d;
    Context e;
    VideoView f;
    android.view.ViewGroup.LayoutParams g;
    ViewGroup h;

    public al(Context context)
    {
        new co();
        a = co.a(i);
        d = false;
        f = null;
        g = null;
        h = null;
        e = context;
    }

    private void b()
    {
        a.b("in removePlayerFromParent", null);
        h.removeView(f);
    }

    public final void a()
    {
        a.b("in releasePlayer", null);
        if (d)
        {
            return;
        } else
        {
            d = true;
            f.stopPlayback();
            b();
            return;
        }
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        a();
        if (b != null)
        {
            b.a();
        }
    }

    public final boolean onError(MediaPlayer mediaplayer, int j, int k)
    {
        b();
        if (b != null)
        {
            b.b();
        }
        return false;
    }

}
