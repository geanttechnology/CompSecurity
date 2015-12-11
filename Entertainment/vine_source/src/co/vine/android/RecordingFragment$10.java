// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import co.vine.android.util.ViewUtil;

// Referenced classes of package co.vine.android:
//            RecordingFragment

class val.res
    implements android.widget.kedChangeListener
{

    final RecordingFragment this$0;
    final Resources val$res;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            RecordingFragment.access$1000(RecordingFragment.this).startAnimation(RecordingFragment.access$1200(RecordingFragment.this));
            ViewUtil.fillColor(val$res, RecordingFragment.access$900(RecordingFragment.this), 0x7f02018e, RecordingFragment.access$600(RecordingFragment.this));
            RecordingFragment.access$600(RecordingFragment.this).setAlpha(1.0F);
            return;
        } else
        {
            RecordingFragment.access$1000(RecordingFragment.this).startAnimation(RecordingFragment.access$1300(RecordingFragment.this));
            ViewUtil.fillColor(val$res, RecordingFragment.access$900(RecordingFragment.this), 0x7f02018e, RecordingFragment.access$600(RecordingFragment.this));
            RecordingFragment.access$600(RecordingFragment.this).setAlpha(0.35F);
            return;
        }
    }

    edChangeListener()
    {
        this$0 = final_recordingfragment;
        val$res = Resources.this;
        super();
    }
}
