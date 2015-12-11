// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.media.MediaPlayer;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            as, ad

class a
    implements android.media.Player.OnCompletionListener
{

    final as a;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        ad.d("WebView - Video Complete");
        if (mediaplayer != null)
        {
            mediaplayer.stop();
        }
        as.e(a);
        if (mediaplayer != null)
        {
            mediaplayer.release();
        }
    }

    tener(as as1)
    {
        a = as1;
        super();
    }
}
