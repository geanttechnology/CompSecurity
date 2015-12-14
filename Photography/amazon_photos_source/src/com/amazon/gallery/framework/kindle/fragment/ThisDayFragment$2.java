// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.amazon.gallery.thor.ftue.DesktopScreen;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ThisDayFragment

class val.emailButton
    implements android.widget.ctionListener
{

    final ThisDayFragment this$0;
    final AppCompatButton val$emailButton;
    final EditText val$emailInputField;
    final TextInputLayout val$textInputLayout;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        textview = val$emailInputField.getText();
        if (i == 2 && !DesktopScreen.isValidEmail(textview))
        {
            val$textInputLayout.setError(getString(0x7f0e00b2));
        } else
        {
            ThisDayFragment.access$000(ThisDayFragment.this, textview, val$emailButton);
        }
        return true;
    }

    ()
    {
        this$0 = final_thisdayfragment;
        val$emailInputField = edittext;
        val$textInputLayout = textinputlayout;
        val$emailButton = AppCompatButton.this;
        super();
    }
}
