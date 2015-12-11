// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.media.MediaPlayer;
import android.widget.ProgressBar;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            af

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        l l = a.a.m;
        a.a.m = null;
        af.a(a.a, l);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/tremorvideo/sdk/android/richmedia/af$2

/* anonymous class */
    class af._cls2
        implements android.media.MediaPlayer.OnPreparedListener
    {

        final af a;

        public void onPrepared(MediaPlayer mediaplayer)
        {
            if (a.a != null)
            {
                if (a.m != null)
                {
                    a.a.post(new af._cls2._cls1(this));
                    return;
                }
                if (!af.a(a))
                {
                    a.i = 200L;
                    a.l = false;
                    a.g = a.a.getDuration();
                    if (a.d)
                    {
                        boolean flag;
                        if (a.e != null)
                        {
                            flag = a.e.a(a);
                        } else
                        {
                            flag = true;
                        }
                        af.b(a);
                        if (flag)
                        {
                            a.a.start();
                            if (af.c(a))
                            {
                                af.b(a, true);
                            }
                            if (a.k != null && a.k.isShown())
                            {
                                a.k.setVisibility(8);
                            }
                            if (af.d(a) != -1)
                            {
                                a.a.seekTo(af.d(a));
                                af.a(a, -1);
                                return;
                            }
                        }
                    }
                }
            }
        }

            
            {
                a = af1;
                super();
            }
    }

}
