// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package co.vine.android:
//            SonyRecordingActivity

class this._cls0
    implements android.view.._cls2
{

    final SonyRecordingActivity this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        SonyRecordingActivity.access$200(SonyRecordingActivity.this).onTouchEvent(motionevent);
        if (SonyRecordingActivity.access$200(SonyRecordingActivity.this).isPressed())
        {
            SonyRecordingActivity.access$200(SonyRecordingActivity.this).setColorFilter(SonyRecordingActivity.access$300(SonyRecordingActivity.this));
        } else
        {
            SonyRecordingActivity.access$200(SonyRecordingActivity.this).clearColorFilter();
        }
        return true;
    }

    ()
    {
        this$0 = SonyRecordingActivity.this;
        super();
    }
}
