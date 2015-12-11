// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDRefinementsView

class val.selectedIndex
    implements android.view.tsView._cls1
{

    final CVSDRefinementsView this$0;
    final int val$selectedIndex;

    public void onClick(View view)
    {
        view = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("com.amazon.mShop.cvsd.CVSDRefinementsView.KEY_REFINEMENTS_SELECTED_INDEX", val$selectedIndex);
        view.putExtras(bundle);
        amazonActivity.setResult(-1, view);
        amazonActivity.finish();
    }

    ()
    {
        this$0 = final_cvsdrefinementsview;
        val$selectedIndex = I.this;
        super();
    }
}
