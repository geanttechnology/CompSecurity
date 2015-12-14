// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.ImageButton;

// Referenced classes of package my.googlemusic.play.activities:
//            DabbShareActivity

class this._cls0
    implements android.media.edListener
{

    final DabbShareActivity this$0;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        mediaplayer.setLooping(true);
        DabbShareActivity.access$700(DabbShareActivity.this).play.setVisibility(0);
        if (DabbShareActivity.access$100(DabbShareActivity.this) != null && !DabbShareActivity.access$100(DabbShareActivity.this).isPlaying())
        {
            DabbShareActivity.access$100(DabbShareActivity.this).setVolume(0.0F, 0.0F);
            DabbShareActivity.access$100(DabbShareActivity.this).start();
    /* block-local class not found */
    class _cls1 {}

            (new Handler()).postDelayed(new _cls1(), 300L);
        }
    }

    _cls1()
    {
        this$0 = DabbShareActivity.this;
        super();
    }
}
