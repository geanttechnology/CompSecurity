// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import com.nhaarman.supertooltips.ToolTipView;

// Referenced classes of package my.googlemusic.play.activities:
//            DabbRecordActivity

class this._cls0
    implements Runnable
{

    final DabbRecordActivity this$0;

    public void run()
    {
        if (DabbRecordActivity.access$400(DabbRecordActivity.this).tutorialView.getVisibility() == 0)
        {
            DabbRecordActivity.access$400(DabbRecordActivity.this).tutorialView.remove();
            DabbRecordActivity.access$702(DabbRecordActivity.this, null);
        }
    }

    ewHolder()
    {
        this$0 = DabbRecordActivity.this;
        super();
    }
}
