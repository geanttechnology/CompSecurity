// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.ProgressBar;
import com.nhaarman.supertooltips.ToolTipView;

// Referenced classes of package my.googlemusic.play.activities:
//            DabbRecordActivity

class this._cls0
    implements Runnable
{

    final DabbRecordActivity this$0;

    public void run()
    {
        DabbRecordActivity.access$400(DabbRecordActivity.this).recordingProgress.setProgress(0);
        DabbRecordActivity.access$600(DabbRecordActivity.this);
        if (DabbRecordActivity.access$400(DabbRecordActivity.this).tutorialView != null)
        {
            DabbRecordActivity.access$400(DabbRecordActivity.this).tutorialView.remove();
        }
    }

    ewHolder()
    {
        this$0 = DabbRecordActivity.this;
        super();
    }
}
