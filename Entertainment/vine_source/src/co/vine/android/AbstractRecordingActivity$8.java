// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity

class val.goToCamera
    implements android.view.._cls8
{

    final AbstractRecordingActivity this$0;
    final boolean val$goToCamera;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (val$goToCamera)
        {
            AbstractRecordingActivity.access$800(AbstractRecordingActivity.this).setVisibility(8);
        } else
        {
            AbstractRecordingActivity.access$900(AbstractRecordingActivity.this).setVisibility(8);
            AbstractRecordingActivity.access$1000(AbstractRecordingActivity.this).setVisibility(8);
        }
        return false;
    }

    ()
    {
        this$0 = final_abstractrecordingactivity;
        val$goToCamera = Z.this;
        super();
    }
}
