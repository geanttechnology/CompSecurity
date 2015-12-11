// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.view.View;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.DepartmentTitleViewModel;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements com.ebay.mobile.common.view.ener
{

    final DepartmentFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof DepartmentTitleViewModel)
        {
            toggleFeaturedCategories();
        }
    }

    ()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
