// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.ebay.mobile.checkout:
//            IncentivesActivity

class this._cls0
    implements android.view.sActivity._cls2
{

    final IncentivesActivity this$0;

    public void onClick(View view)
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        if (IncentivesActivity.access$000(IncentivesActivity.this) == ewState.INCENTIVE_LIST)
        {
            IncentivesActivity.access$100(IncentivesActivity.this);
            return;
        } else
        {
            IncentivesActivity.access$002(IncentivesActivity.this, ewState.INCENTIVE_LIST);
            IncentivesActivity.access$200(IncentivesActivity.this);
            IncentivesActivity.access$300(IncentivesActivity.this, true);
            return;
        }
    }

    ewState()
    {
        this$0 = IncentivesActivity.this;
        super();
    }
}
