// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;
import co.vine.android.dragsort.DragSortWidget;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder, SegmentEditorAdapter, RecordSegment

class this._cls0
    implements android.view.ener
{

    final VineRecorder this$0;

    public void onClick(View view)
    {
        VineRecorder.access$2900(VineRecorder.this).toPlay = null;
        VineRecorder.access$2900(VineRecorder.this).forceRefresh = true;
        pausePreview(true);
        if (VineRecorder.access$2300(VineRecorder.this) != null)
        {
            VineRecorder.access$2300(VineRecorder.this).undoDelete();
            showThumbnailOverlay((RecordSegment)VineRecorder.access$2300(VineRecorder.this).getItem(0));
        }
        VineRecorder.access$4100(VineRecorder.this, 2);
        if (VineRecorder.access$4200(VineRecorder.this) != null)
        {
            VineRecorder.access$4200(VineRecorder.this).setVisibility(8);
        }
        if (VineRecorder.access$2600(VineRecorder.this) != null)
        {
            VineRecorder.access$2600(VineRecorder.this).setFocused(0);
        }
    }

    pter()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
