// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.amazon.now.util.AppUtils;

// Referenced classes of package com.amazon.now.home:
//            WelcomeScreen

class this._cls0
    implements android.view.ener
{

    final WelcomeScreen this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            int i = AppUtils.getPxFromDp(WelcomeScreen.access$000(WelcomeScreen.this), (int)WelcomeScreen.access$000(WelcomeScreen.this).getResources().getDimension(0x7f0b0124));
            if (motionevent.getX() <= (float)(WelcomeScreen.access$100(WelcomeScreen.this).getCompoundDrawables()[0].getBounds().width() + i))
            {
                WelcomeScreen.access$200(WelcomeScreen.this);
                return true;
            }
        }
        return false;
    }

    ()
    {
        this$0 = WelcomeScreen.this;
        super();
    }
}
