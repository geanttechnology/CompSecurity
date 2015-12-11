// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.media.MediaPlayer;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e

class a
    implements android.media.Player.OnErrorListener
{

    final e a;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        e.j(a);
        return true;
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
