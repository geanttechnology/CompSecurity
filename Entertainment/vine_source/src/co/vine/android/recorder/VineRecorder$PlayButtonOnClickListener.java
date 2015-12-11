// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;
import co.vine.android.dragsort.DragSortWidget;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder, RecordSegment

private class <init>
    implements android.view.ickListener
{

    boolean forceRefresh;
    final VineRecorder this$0;
    RecordSegment toPlay;

    public void onClick(View view)
    {
        if (toPlay == null)
        {
            VineRecorder.access$4402(VineRecorder.this, -1);
            if (VineRecorder.access$2600(VineRecorder.this) != null)
            {
                VineRecorder.access$2600(VineRecorder.this).setSelection(-1);
            }
            VineRecorder.access$4100(VineRecorder.this, 2);
        }
        playPreview(toPlay, forceRefresh);
    }

    private ()
    {
        this$0 = VineRecorder.this;
        super();
        toPlay = null;
        forceRefresh = false;
    }

    forceRefresh(forceRefresh forcerefresh)
    {
        this();
    }
}
