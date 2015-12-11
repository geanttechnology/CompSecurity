// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1

class this._cls0
    implements android.view.lLayoutListener
{

    final OnBoardingMultiStepA1 this$0;

    public void onGlobalLayout()
    {
        while (categoriesContainer == null || userInputContainer == null || bottomContainer == null || OnBoardingMultiStepA1.access$000(OnBoardingMultiStepA1.this)) 
        {
            return;
        }
        OnBoardingMultiStepA1.access$002(OnBoardingMultiStepA1.this, true);
        if (OnBoardingMultiStepA1.access$100(OnBoardingMultiStepA1.this))
        {
            bottomContainer.setY(bottomContainer.getY() + (float)userInputContainer.getHeight());
            OnBoardingMultiStepA1.access$200(OnBoardingMultiStepA1.this);
            return;
        } else
        {
            categoriesContainer.setVisibility(8);
            return;
        }
    }

    istener()
    {
        this$0 = OnBoardingMultiStepA1.this;
        super();
    }
}
