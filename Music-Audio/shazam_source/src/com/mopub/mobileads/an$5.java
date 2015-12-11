// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.media.MediaPlayer;
import com.mopub.c.p;
import com.mopub.common.m;

// Referenced classes of package com.mopub.mobileads:
//            an, ah, am, i, 
//            y

final class a
    implements android.media.Player.OnErrorListener
{

    final am a;
    final an b;

    public final boolean onError(MediaPlayer mediaplayer, int j, int k)
    {
        if (a.a(mediaplayer, j, k, b.d.k))
        {
            return true;
        } else
        {
            b.k();
            b.i();
            b.h();
            b.t = true;
            mediaplayer = b.d;
            android.content.Context context = ((i) (b)).a;
            y y1 = y.d;
            j = b.e.getCurrentPosition();
            m.a(context, "context cannot be null");
            p.a(((ah) (mediaplayer)).h, y1, Integer.valueOf(j), ((ah) (mediaplayer)).j, context);
            return false;
        }
    }

    (an an1, am am1)
    {
        b = an1;
        a = am1;
        super();
    }
}
