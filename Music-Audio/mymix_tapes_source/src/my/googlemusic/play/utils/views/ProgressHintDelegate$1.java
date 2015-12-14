// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.views;

import android.widget.SeekBar;

// Referenced classes of package my.googlemusic.play.utils.views:
//            ProgressHintDelegate

class this._cls0
    implements android.view.alLayoutListener
{

    final ProgressHintDelegate this$0;

    public void onGlobalLayout()
    {
        if (mSeekBar.getVisibility() != 0)
        {
            hidePopup();
            return;
        } else
        {
            ProgressHintDelegate.access$100(ProgressHintDelegate.this);
            return;
        }
    }

    ()
    {
        this$0 = ProgressHintDelegate.this;
        super();
    }
}
