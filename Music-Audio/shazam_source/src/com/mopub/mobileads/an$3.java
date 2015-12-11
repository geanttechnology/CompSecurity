// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.media.MediaPlayer;
import com.mopub.common.d.a;
import com.mopub.mobileads.b.e;
import com.mopub.mobileads.b.f;

// Referenced classes of package com.mopub.mobileads:
//            an, am, ah, af, 
//            ak, al

final class a
    implements android.media.Player.OnPreparedListener
{

    final am a;
    final an b;

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        b.w = b.e.getDuration();
        mediaplayer = b;
        int i = ((an) (mediaplayer)).e.getDuration();
        if (i < 16000)
        {
            mediaplayer.q = i;
        }
        Integer integer = ((an) (mediaplayer)).d.b(i);
        if (integer != null)
        {
            mediaplayer.q = integer.intValue();
            mediaplayer.u = true;
        }
        if (b.l == null)
        {
            mediaplayer = a;
            Object obj = b.h;
            String s = b.d.k;
            if (((am) (mediaplayer)).b != null)
            {
                mediaplayer.a = new af(((am) (mediaplayer)).b, ((android.widget.ImageView) (obj)), mediaplayer.getDuration());
                int j;
                int k;
                try
                {
                    com.mopub.common.d.a.a(((am) (mediaplayer)).a, new String[] {
                        s
                    });
                }
                // Misplaced declaration of an exception variable
                catch (MediaPlayer mediaplayer)
                {
                    com.mopub.common.c.a.b("Failed to blur last video frame", mediaplayer);
                }
            }
        }
        mediaplayer = b.i;
        j = b.e.getDuration();
        k = b.q;
        obj = ((ak) (mediaplayer)).a;
        obj.a = j;
        obj.b = k;
        obj.e = (float)((e) (obj)).b / (float)((e) (obj)).a;
        mediaplayer.setVisibility(0);
        mediaplayer = b.j;
        j = b.q;
        ((al) (mediaplayer)).a.a = j;
        mediaplayer.setVisibility(0);
        b.v = true;
    }

    (an an1, am am1)
    {
        b = an1;
        a = am1;
        super();
    }
}
