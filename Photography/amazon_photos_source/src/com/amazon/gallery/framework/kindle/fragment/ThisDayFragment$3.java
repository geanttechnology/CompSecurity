// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ThisDayFragment

class val.emailButton
    implements TextWatcher
{

    final ThisDayFragment this$0;
    final AppCompatButton val$emailButton;
    final TextInputLayout val$textInputLayout;

    public void afterTextChanged(Editable editable)
    {
        if (val$textInputLayout.getVisibility() == 0)
        {
            AppCompatButton appcompatbutton = val$emailButton;
            boolean flag;
            if (!StringUtils.isEmpty(editable))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            appcompatbutton.setEnabled(flag);
            val$textInputLayout.setError(null);
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = final_thisdayfragment;
        val$textInputLayout = textinputlayout;
        val$emailButton = AppCompatButton.this;
        super();
    }
}
