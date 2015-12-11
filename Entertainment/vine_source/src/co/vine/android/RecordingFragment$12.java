// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            RecordingFragment

class this._cls0
    implements android.view._cls12
{

    final RecordingFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return false;

        case 0: // '\0'
            RecordingFragment.access$100(RecordingFragment.this).setAlpha(1.0F);
            return true;

        case 1: // '\001'
            RecordingFragment.access$100(RecordingFragment.this).setAlpha(0.35F);
            break;
        }
        onSessionSwitchPressed(null);
        return true;
    }

    ()
    {
        this$0 = RecordingFragment.this;
        super();
    }
}
