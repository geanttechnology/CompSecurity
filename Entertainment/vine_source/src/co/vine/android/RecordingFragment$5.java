// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.widget.ToggleButton;
import co.vine.android.recorder.RecordingFile;
import co.vine.android.recorder.VineRecorder;
import java.io.File;

// Referenced classes of package co.vine.android:
//            RecordingFragment, AbstractRecordingActivity

class this._cls0
    implements Runnable
{

    final RecordingFragment this$0;

    public void run()
    {
        AbstractRecordingActivity abstractrecordingactivity = (AbstractRecordingActivity)getActivity();
        if (abstractrecordingactivity != null)
        {
            if (RecordingFragment.access$600(RecordingFragment.this).isChecked())
            {
                RecordingFragment.access$600(RecordingFragment.this).setChecked(false);
            }
            if (RecordingFragment.access$700(RecordingFragment.this).isChecked())
            {
                RecordingFragment.access$800(RecordingFragment.this).setGhostMode(false);
            }
            if (RecordingFragment.access$800(RecordingFragment.this).grabThumbnailsRunnable != null)
            {
                RecordingFragment.access$800(RecordingFragment.this).grabThumbnailsRunnable.run();
                RecordingFragment.access$800(RecordingFragment.this).grabThumbnailsRunnable = null;
            }
            String s;
            if (RecordingFragment.access$800(RecordingFragment.this).isSavedSession())
            {
                s = RecordingFragment.access$800(RecordingFragment.this).getFile().folder.getName();
            } else
            {
                s = String.valueOf("camera_preview");
            }
            abstractrecordingactivity.showDrafts(s);
        }
    }

    le()
    {
        this$0 = RecordingFragment.this;
        super();
    }
}
