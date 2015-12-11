// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.Activity;
import co.vine.android.dragsort.DragSortWidget;
import co.vine.android.player.SdkVideoView;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder, SegmentEditorAdapter, RecordSegment

public class runThread
    implements Runnable
{

    private static final int SLEEP_MILLIS = 40;
    public int lastFirstItem;
    public boolean runThread;
    final VineRecorder this$0;

    public void run()
    {
_L12:
        if (!runThread)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        if (VineRecorder.access$4400(VineRecorder.this) != -1 || VineRecorder.access$2300(VineRecorder.this) == null || !VineRecorder.access$1900(VineRecorder.this).isPlaying()) goto _L2; else goto _L1
_L1:
        int j = VineRecorder.access$1900(VineRecorder.this).getCurrentPosition() + 20;
        if (j <= 0) goto _L2; else goto _L3
_L3:
        Object obj;
        int i;
        obj = VineRecorder.access$2300(VineRecorder.this).getData();
        i = ((ArrayList) (obj)).size();
        if (i <= 0) goto _L2; else goto _L4
_L4:
        i--;
_L10:
        if (i < 0) goto _L2; else goto _L5
_L5:
        if ((long)j < ((RecordSegment)((ArrayList) (obj)).get(i)).startTimestamp) goto _L7; else goto _L6
_L6:
        if (lastFirstItem != i) goto _L8; else goto _L2
_L2:
        Thread.sleep(40L);
        continue; /* Loop/switch isn't completed */
_L8:
        lastFirstItem = i;
        obj = mActivity;
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((Activity) (obj)).runOnUiThread(new Runnable() {

            final VineRecorder.SegmentChangeDetector this$1;

            public void run()
            {
                if (VineRecorder.access$4400(this$0) == -1)
                {
                    DragSortWidget dragsortwidget = VineRecorder.access$2600(this$0);
                    if (dragsortwidget != null)
                    {
                        dragsortwidget.setFocused(lastFirstItem);
                    }
                }
            }

            
            {
                this$1 = VineRecorder.SegmentChangeDetector.this;
                super();
            }
        });
        if (true) goto _L2; else goto _L7
_L7:
        i--;
        if (true) goto _L10; else goto _L9
_L9:
        InterruptedException interruptedexception;
        interruptedexception;
        return;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public _cls1.this._cls1()
    {
        this$0 = VineRecorder.this;
        super();
        lastFirstItem = 0;
        runThread = true;
    }
}
