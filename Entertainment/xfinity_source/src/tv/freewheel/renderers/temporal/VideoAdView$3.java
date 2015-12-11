// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.temporal;

import android.media.MediaPlayer;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.temporal:
//            VideoAdView, VideoRenderer

class this._cls0
    implements android.media.InfoListener
{

    final VideoAdView this$0;

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        VideoAdView.access$000(VideoAdView.this).debug((new StringBuilder()).append("onInfo(").append(i).append(",").append(j).append(")").toString());
        switch (i)
        {
        default:
            return true;

        case 701: 
            VideoAdView.access$400(VideoAdView.this).onAdViewBuffered(false);
            return true;

        case 702: 
            VideoAdView.access$400(VideoAdView.this).onAdViewBuffered(true);
            break;
        }
        return true;
    }

    ()
    {
        this$0 = VideoAdView.this;
        super();
    }
}
