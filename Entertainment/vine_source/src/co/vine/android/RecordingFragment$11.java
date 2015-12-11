// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.res.Resources;
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
            ViewUtil.fillColor(val$res, RecordingFragment.access$900(RecordingFragment.this), 0x7f02018b, RecordingFragment.access$700(RecordingFragment.this));
            RecordingFragment.access$700(RecordingFragment.this).setAlpha(1.0F);
            return;
        } else
        {
            ViewUtil.fillColor(val$res, RecordingFragment.access$900(RecordingFragment.this), 0x7f02018b, RecordingFragment.access$700(RecordingFragment.this));
            RecordingFragment.access$700(RecordingFragment.this).setAlpha(0.35F);
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
