// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.views;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

// Referenced classes of package my.googlemusic.play.utils.views:
//            ProgressHintDelegate

class this._cls0
    implements android.view.ressHintDelegate._cls3
{

    final ProgressHintDelegate this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view = getHintDragCoordinates(motionevent);
        view = MotionEvent.obtain(motionevent.getDownTime(), motionevent.getEventTime(), motionevent.getAction(), ((PointF) (view)).x, ((PointF) (view)).y, motionevent.getMetaState());
        return mSeekBar.dispatchTouchEvent(view);
    }

    ()
    {
        this$0 = ProgressHintDelegate.this;
        super();
    }
}
