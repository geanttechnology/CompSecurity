// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class this._cls0
    implements android.view.ener
{

    final VineRecorder this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return false;

        case 0: // '\0'
            VineRecorder.access$4100(VineRecorder.this, 1);
            return false;

        case 2: // '\002'
            VineRecorder.access$4100(VineRecorder.this, 1);
            return false;

        case 1: // '\001'
            VineRecorder.access$4100(VineRecorder.this, 0);
            return false;
        }
    }

    ()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
