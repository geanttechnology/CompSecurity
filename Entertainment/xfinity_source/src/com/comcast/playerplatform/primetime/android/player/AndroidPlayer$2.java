// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import android.util.Log;
import com.adobe.ave.MediaErrorCode;
import com.adobe.mediacore.MediaPlayerItem;

// Referenced classes of package com.comcast.playerplatform.primetime.android.player:
//            AndroidPlayer

class this._cls0
    implements com.adobe.mediacore.oader.LoaderListener
{

    final AndroidPlayer this$0;

    public void onError(MediaErrorCode mediaerrorcode, String s)
    {
        Log.i("yourface", "uhoh something went wrong");
    }

    public void onLoadComplete(MediaPlayerItem mediaplayeritem)
    {
        Log.i("yourface", "yaya");
    }

    I()
    {
        this$0 = AndroidPlayer.this;
        super();
    }
}
