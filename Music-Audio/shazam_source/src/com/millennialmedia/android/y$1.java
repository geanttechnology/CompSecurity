// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.widget.ProgressBar;

// Referenced classes of package com.millennialmedia.android:
//            y

final class a
    implements android.media.aPlayer.OnPreparedListener
{

    final y a;

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        if (y.c(a))
        {
            mediaplayer.setOnInfoListener(new android.media.MediaPlayer.OnInfoListener() {

                final y._cls1 a;

                public final boolean onInfo(MediaPlayer mediaplayer1, int i, int j)
                {
                    if (i == 3)
                    {
                        y.h(a.a);
                    }
                    return false;
                }

            
            {
                a = y._cls1.this;
                super();
            }
            });
        }
        y.a(a).q = b.c;
        if (y.a(a).k && y.a(a).p == a.a)
        {
            y.a(a).p = a.c;
        }
        a.d.setVisibility(8);
        a.g = a.getDuration();
        a.seekTo(y.a(a).o);
        y.i(a);
    }

    _cls1.a(y y1)
    {
        a = y1;
        super();
    }
}
