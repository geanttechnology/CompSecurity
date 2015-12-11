// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.media.MediaPlayer;
import android.widget.ProgressBar;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            af

class a
    implements android.media.Player.OnPreparedListener
{

    final af a;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        if (a.a != null)
        {
            if (a.m != null)
            {
                a.a.post(new Runnable() {

                    final af._cls2 a;

                    public void run()
                    {
                        l l = a.a.m;
                        a.a.m = null;
                        af.a(a.a, l);
                    }

            
            {
                a = af._cls2.this;
                super();
            }
                });
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

    _cls1.a(af af1)
    {
        a = af1;
        super();
    }
}
