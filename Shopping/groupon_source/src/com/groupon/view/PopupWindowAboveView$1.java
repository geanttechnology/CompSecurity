// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.groupon.view:
//            PopupWindowAboveView

class val.onDismiss
    implements android.view.w._cls1
{

    final PopupWindowAboveView this$0;
    final Runnable val$onDismiss;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 4)
        {
            dismiss();
            val$onDismiss.run();
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = final_popupwindowaboveview;
        val$onDismiss = Runnable.this;
        super();
    }
}
