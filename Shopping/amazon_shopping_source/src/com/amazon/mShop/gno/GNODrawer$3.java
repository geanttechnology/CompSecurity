// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.view.View;
import android.widget.AdapterView;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawer, GNODrawerItem

class this._cls0
    implements android.widget.OnItemClickListener
{

    final GNODrawer this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (AmazonActivity.getTopMostBaseActivity() != null)
        {
            ((GNODrawerItem)adapterview.getItemAtPosition(i)).onClick(AmazonActivity.getTopMostBaseActivity(), GNODrawer.this);
        }
    }

    m()
    {
        this$0 = GNODrawer.this;
        super();
    }
}
