// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.widget.ProgressBar;

// Referenced classes of package com.millennialmedia.android:
//            y

final class a
    implements android.media.layer.OnInfoListener
{

    final a a;

    public final boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        if (i == 3)
        {
            y.h(a.a);
        }
        return false;
    }

    edListener(edListener edlistener)
    {
        a = edlistener;
        super();
    }

    // Unreferenced inner class com/millennialmedia/android/y$1

/* anonymous class */
    final class y._cls1
        implements android.media.MediaPlayer.OnPreparedListener
    {

        final y a;

        public final void onPrepared(MediaPlayer mediaplayer)
        {
            if (y.c(a))
            {
                mediaplayer.setOnInfoListener(new y._cls1._cls1(this));
            }
            y.a(a).q = y.a.b.c;
            if (y.a(a).k && y.a(a).p == y.a.a.a)
            {
                y.a(a).p = y.a.a.c;
            }
            a.d.setVisibility(8);
            a.g = a.getDuration();
            a.seekTo(y.a(a).o);
            y.i(a);
        }

            
            {
                a = y1;
                super();
            }
    }

}
