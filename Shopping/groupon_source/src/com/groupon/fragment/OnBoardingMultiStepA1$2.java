// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1

class this._cls0
    implements android.view.tepA1._cls2
{

    final OnBoardingMultiStepA1 this$0;

    public void onClick(View view)
    {
        if (categoriesContainer != null && categoriesContainer.getVisibility() == 0)
        {
            exitAnimationDelay = 0;
            stopCategoriesAnimation();
            return;
        } else
        {
            logger.logClick("", "zipcode_continue_button_click", com/groupon/fragment/OnBoardingMultiStepA1.getSimpleName(), "");
            OnBoardingMultiStepA1.access$300(OnBoardingMultiStepA1.this);
            imm.hideSoftInputFromWindow(inputField.getWindowToken(), 0);
            return;
        }
    }

    ()
    {
        this$0 = OnBoardingMultiStepA1.this;
        super();
    }
}
