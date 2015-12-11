// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.view.View;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements android.view.epartmentFragment._cls1
{

    final DepartmentFragment this$0;

    public void onClick(View view)
    {
        if (view.getId() == 0x7f10022c)
        {
            loadingIndicator.setVisibility(0);
            errorLayout.setVisibility(8);
            contentDataManager.invalidateAndForceReloadData();
        }
    }

    ager()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
