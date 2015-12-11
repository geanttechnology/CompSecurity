// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.disney;

import android.media.MediaPlayer;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.playerplatform.primetime.android.disney:
//            DisneyPlayer

class this._cls0
    implements AsyncHandler
{

    final DisneyPlayer this$0;

    public void onAsyncTask()
    {
    }

    public void onError(Exception exception)
    {
        DisneyPlayer.access$700().error(String.format("TeaTime-error: ", new Object[] {
            exception.getMessage()
        }));
        if (DisneyPlayer.access$500(DisneyPlayer.this) != null)
        {
            DisneyPlayer.access$600(DisneyPlayer.this, exception);
        }
        DisneyPlayer.access$800(DisneyPlayer.this).release();
    }

    public void onSuccess(MediaPlayer mediaplayer)
    {
        DisneyPlayer.access$1200(DisneyPlayer.this, mediaplayer);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((MediaPlayer)obj);
    }

    ()
    {
        this$0 = DisneyPlayer.this;
        super();
    }
}
