// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.ave.MediaErrorCode;
import com.adobe.mediacore.MediaPlayerItem;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;

// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            PrimeTimePlayer

class this._cls0
    implements com.adobe.mediacore.der.LoaderListener
{

    final PrimeTimePlayer this$0;

    public void onError(MediaErrorCode mediaerrorcode, String s)
    {
        PrimeTimePlayer.access$200(PrimeTimePlayer.this).e("PrimetimePlayer", s);
    }

    public void onLoadComplete(MediaPlayerItem mediaplayeritem)
    {
        PrimeTimePlayer.access$200(PrimeTimePlayer.this).e("PrimetimePlayer", "Success");
    }

    ()
    {
        this$0 = PrimeTimePlayer.this;
        super();
    }
}
