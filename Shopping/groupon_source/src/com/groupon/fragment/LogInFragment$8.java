// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.ViewTreeObserver;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            LogInFragment

class val.buttonText
    implements android.view..OnGlobalLayoutListener
{

    final LogInFragment this$0;
    final String val$buttonText;

    public void onGlobalLayout()
    {
        int i = submit.getPaddingLeft();
        int j = submit.getPaddingRight();
        i = submit.getWidth() - (i + j) - submit.getCompoundDrawables()[0].getIntrinsicWidth();
        j = Math.round(submit.getPaint().measureText(val$buttonText));
        if (i > 0 && i < j)
        {
            submit.setText(0x7f0801cd);
        }
        submit.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    lLayoutListener()
    {
        this$0 = final_loginfragment;
        val$buttonText = String.this;
        super();
    }
}
