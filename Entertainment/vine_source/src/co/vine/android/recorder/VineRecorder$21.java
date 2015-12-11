// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.MotionEvent;
import android.view.View;
import co.vine.android.dragsort.DragSortWidget;
import co.vine.android.player.SdkVideoView;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class this._cls0
    implements android.view.ener
{

    final VineRecorder this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (VineRecorder.access$2600(VineRecorder.this) != null)
        {
            return VineRecorder.access$2600(VineRecorder.this).onTouch((View)VineRecorder.access$1900(VineRecorder.this).getParent(), motionevent, VineRecorder.access$3400(VineRecorder.this).getLeft(), VineRecorder.access$3400(VineRecorder.this).getTop());
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
