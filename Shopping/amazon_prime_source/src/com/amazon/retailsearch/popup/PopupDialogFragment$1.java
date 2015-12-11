// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.popup;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

// Referenced classes of package com.amazon.retailsearch.popup:
//            PopupDialogFragment

class this._cls0 extends Dialog
{

    final PopupDialogFragment this$0;

    private boolean isOutOfBounds(MotionEvent motionevent)
    {
        int i = (int)motionevent.getX();
        int j = (int)motionevent.getY();
        motionevent = getWindow().getDecorView();
        return i < 0 || j < 0 || i > motionevent.getWidth() || j > motionevent.getHeight();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1 = super.onTouchEvent(motionevent);
        boolean flag = flag1;
        if (!flag1)
        {
            flag = flag1;
            if (isShowing())
            {
                flag = flag1;
                if (motionevent.getAction() == 0)
                {
                    flag = flag1;
                    if (isOutOfBounds(motionevent))
                    {
                        cancel();
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    _cls9(Context context, int i)
    {
        this$0 = PopupDialogFragment.this;
        super(context, i);
    }
}
