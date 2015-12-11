// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity

class hasMovedOut
    implements android.view.._cls4
{

    boolean hasMovedOut;
    final AbstractRecordingActivity this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag2 = true;
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 34
    //                   1 72
    //                   2 85;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        if (mCurrentPage != AbstractRecordingActivity.access$000(AbstractRecordingActivity.this).size())
        {
            AbstractRecordingActivity.access$200(AbstractRecordingActivity.this).setActivated(true);
            hasMovedOut = false;
            return false;
        }
          goto _L1
_L3:
        AbstractRecordingActivity.access$200(AbstractRecordingActivity.this).setActivated(false);
        return false;
_L4:
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        boolean flag;
        boolean flag1;
        if (f >= 0.0F && f <= (float)AbstractRecordingActivity.access$300(AbstractRecordingActivity.this).getWidth() && f1 >= 0.0F && f1 <= (float)AbstractRecordingActivity.access$300(AbstractRecordingActivity.this).getHeight())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            hasMovedOut = true;
        }
        view = AbstractRecordingActivity.access$200(AbstractRecordingActivity.this);
        if (flag && !hasMovedOut)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        view.setActivated(flag1);
        view = AbstractRecordingActivity.access$300(AbstractRecordingActivity.this);
        if (flag && !hasMovedOut)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        view.setActivated(flag1);
        return false;
    }

    ()
    {
        this$0 = AbstractRecordingActivity.this;
        super();
        hasMovedOut = false;
    }
}
