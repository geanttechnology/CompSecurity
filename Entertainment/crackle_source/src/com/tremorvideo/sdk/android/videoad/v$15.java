// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.media.MediaPlayer;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v, ad

class a
    implements android.media.Player.OnErrorListener
{

    final v a;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        ad.d((new StringBuilder()).append("Media player error: What: ").append(i).append(" Extra: ").append(j).toString());
        return false;
    }

    (v v1)
    {
        a = v1;
        super();
    }
}
