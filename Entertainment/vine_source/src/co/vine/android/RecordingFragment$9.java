// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import co.vine.android.util.ViewUtil;

// Referenced classes of package co.vine.android:
//            RecordingFragment

class val.switchCameraButton
    implements android.view.
{

    final RecordingFragment this$0;
    final Resources val$res;
    final View val$switchCameraButton;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (view.getId())
        {
        case 2131362240: 
            switch (motionevent.getAction())
            {
            case 0: // '\0'
                ViewUtil.fillColor(val$res, RecordingFragment.access$900(RecordingFragment.this), 0x7f020188, val$switchCameraButton);
                val$switchCameraButton.setAlpha(1.0F);
                break;

            case 1: // '\001'
                ViewUtil.fillColor(val$res, RecordingFragment.access$900(RecordingFragment.this), 0x7f020188, val$switchCameraButton);
                val$switchCameraButton.setAlpha(0.35F);
                break;
            }
            break;
        }
        while (true) 
        {
            return false;
        }
    }

    ()
    {
        this$0 = final_recordingfragment;
        val$res = resources;
        val$switchCameraButton = View.this;
        super();
    }
}
