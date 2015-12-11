// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1

class this._cls0
    implements android.view.er
{

    final OnBoardingMultiStepA1 this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            imm.showSoftInput(inputField, 0);
            if (Strings.isEmpty(inputField.getText()))
            {
                inputField.setHint("");
            }
        }
    }

    ()
    {
        this$0 = OnBoardingMultiStepA1.this;
        super();
    }
}
