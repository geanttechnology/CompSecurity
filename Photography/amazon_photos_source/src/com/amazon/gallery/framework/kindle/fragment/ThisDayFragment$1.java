// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import com.amazon.gallery.thor.ftue.DesktopScreen;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ThisDayFragment

class val.emailInputField
    implements android.view.er
{

    final ThisDayFragment this$0;
    final AppCompatButton val$emailButton;
    final EditText val$emailInputField;
    final String val$prefetchedEmailAddress;
    final TextInputLayout val$textInputLayout;

    public void onClick(View view)
    {
        if (DesktopScreen.isValidEmail(val$prefetchedEmailAddress))
        {
            ThisDayFragment.access$000(ThisDayFragment.this, val$prefetchedEmailAddress, val$emailButton);
            return;
        }
        if (val$textInputLayout.getVisibility() == 0)
        {
            view = val$emailInputField.getText();
            if (!DesktopScreen.isValidEmail(view))
            {
                val$textInputLayout.setError(getString(0x7f0e00b2));
                return;
            } else
            {
                ThisDayFragment.access$000(ThisDayFragment.this, view, val$emailButton);
                return;
            }
        } else
        {
            val$emailInputField.setText("");
            val$emailInputField.clearFocus();
            val$textInputLayout.setVisibility(0);
            return;
        }
    }

    ()
    {
        this$0 = final_thisdayfragment;
        val$prefetchedEmailAddress = s;
        val$emailButton = appcompatbutton;
        val$textInputLayout = textinputlayout;
        val$emailInputField = EditText.this;
        super();
    }
}
