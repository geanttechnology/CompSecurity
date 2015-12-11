// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.media.MediaPlayer;

// Referenced classes of package com.flurry.sdk:
//            dw

class it>
    implements android.media.Player.OnBufferingUpdateListener
{

    final dw a;

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        dw.c(a, i);
    }

    layer(dw dw1)
    {
        a = dw1;
        super();
    }
}
