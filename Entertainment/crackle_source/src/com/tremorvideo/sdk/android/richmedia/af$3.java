// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.media.MediaPlayer;
import com.tremorvideo.sdk.android.videoad.ad;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            af

class a
    implements android.media.Player.OnErrorListener
{

    final af a;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        ad.d((new StringBuilder()).append("Media Player Error: ").append(i).append(" Extra: ").append(j).toString());
        if (!a.a.a)
        {
            if (af.c(a))
            {
                a.m();
            } else
            {
                a.a.a = true;
                if (a.e != null)
                {
                    a.e.p();
                    return true;
                }
            }
        }
        return true;
    }

    (af af1)
    {
        a = af1;
        super();
    }
}
