// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1Intl

class this._cls0
    implements android.view._cls1Intl._cls3
{

    final OnBoardingMultiStepA1Intl this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            imm.showSoftInput(inputField, 0);
        }
    }

    ()
    {
        this$0 = OnBoardingMultiStepA1Intl.this;
        super();
    }
}
