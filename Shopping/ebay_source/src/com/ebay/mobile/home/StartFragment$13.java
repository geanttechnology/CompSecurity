// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.view.View;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.SellingDraftViewModel;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.Listener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof SellingDraftViewModel)
        {
            StartFragment.access$800(StartFragment.this, (SellingDraftViewModel)viewmodel);
        }
    }

    tViewModel()
    {
        this$0 = StartFragment.this;
        super();
    }
}
