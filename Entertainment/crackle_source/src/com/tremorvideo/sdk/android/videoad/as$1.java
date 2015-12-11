// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.media.MediaPlayer;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            as, ad

class a
    implements android.media.Player.OnPreparedListener
{

    final as a;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        ad.d("WebView - Video Available");
        as.f(a);
        mediaplayer.start();
    }

    ner(as as1)
    {
        a = as1;
        super();
    }
}
