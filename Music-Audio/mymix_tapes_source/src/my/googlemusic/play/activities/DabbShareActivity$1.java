// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package my.googlemusic.play.activities:
//            DabbShareActivity

class this._cls0
    implements android.view.
{

    final DabbShareActivity this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (DabbShareActivity.access$100(DabbShareActivity.this).isPlaying())
        {
            DabbShareActivity.access$200(DabbShareActivity.this);
        }
        return true;
    }

    ()
    {
        this$0 = DabbShareActivity.this;
        super();
    }
}
