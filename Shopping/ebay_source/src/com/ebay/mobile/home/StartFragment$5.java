// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.view.View;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.kListener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (view.getId() == 0x7f10022c)
        {
            StartFragment.access$500(StartFragment.this, annelState.STATE_LOADING);
            StartFragment.access$100(StartFragment.this).invalidateAndForceReloadData();
        }
    }

    ()
    {
        this$0 = StartFragment.this;
        super();
    }
}
