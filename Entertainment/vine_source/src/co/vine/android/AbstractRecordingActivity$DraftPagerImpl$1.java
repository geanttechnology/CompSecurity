// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.graphics.Point;
import android.view.View;
import co.vine.android.animation.MoveResizeAnimator;
import co.vine.android.util.CrashUtil;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity, DraftFragment

class val.fragment
    implements android.view.._cls1
{

    final is._cls0 this$1;
    final DraftFragment val$fragment;

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131362006 2131362006: default 24
    //                   2131362006 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (!AbstractRecordingActivity.access$1700(_fld0) && !AbstractRecordingActivity.access$1300(_fld0))
        {
            CrashUtil.log("User clicked on fragment to resume.");
            AbstractRecordingActivity.access$3002(_fld0, true);
            AbstractRecordingActivity.access$3100(_fld0, val$fragment);
            AbstractRecordingActivity.access$3200(_fld0);
            float f = (float)AbstractRecordingActivity.access$3300(_fld0).x / (float)AbstractRecordingActivity.access$3400(_fld0).getLayoutParams()._fld0;
            (new MoveResizeAnimator(2, AbstractRecordingActivity.access$3500(_fld0), 0, f, 2D, 300, null, view.getTag())).start();
            (new MoveResizeAnimator(1, AbstractRecordingActivity.access$3400(_fld0), AbstractRecordingActivity.access$3500(_fld0).getLayoutParams()._fld0 * 2, f, f, 300, _fld0, view.getTag())).start();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    ()
    {
        this$1 = final_;
        val$fragment = DraftFragment.this;
        super();
    }
}
