// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.media.MediaPlayer;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v

class a
    implements android.media.aPlayer.OnErrorListener
{

    final v a;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        v.k(a);
        return true;
    }

    r(v v1)
    {
        a = v1;
        super();
    }
}
