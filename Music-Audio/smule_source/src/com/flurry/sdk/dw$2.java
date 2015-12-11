// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.media.MediaPlayer;
import android.net.Uri;

// Referenced classes of package com.flurry.sdk:
//            dw, gd, dz

class it>
    implements android.media.Player.OnPreparedListener
{

    final dw a;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        dw.a(a, d);
        gd.a(5, dw.f(), (new StringBuilder()).append("OnPreparedListener: ").append(dw.d(a)).toString());
        if (dw.e(a) > 3)
        {
            a.seekTo(dw.e(a));
        } else
        {
            a.seekTo(3);
        }
        if (dw.b(a) != null && dw.d(a) != null)
        {
            dw.b(a).a(dw.d(a).toString());
        }
    }

    layer(dw dw1)
    {
        a = dw1;
        super();
    }
}
