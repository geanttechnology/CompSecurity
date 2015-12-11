// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.ebay.mobile.home.departments.DepartmentPageChangeListener;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements android.view.ngeListener
{

    final StartFragment this$0;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (StartFragment.access$300(StartFragment.this) == view && departmentPageChangeListener != null)
        {
            departmentPageChangeListener.onPageScrolled(departmentIndex, 0.0F, 0);
        }
        StartFragment.access$300(StartFragment.this).removeOnLayoutChangeListener(this);
    }

    w()
    {
        this$0 = StartFragment.this;
        super();
    }
}
