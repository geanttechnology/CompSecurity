// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.app.Activity;
import android.view.View;
import android.view.Window;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            DirectDebitTabFragment

class this._cls0
    implements android.view.r
{

    final DirectDebitTabFragment this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            DirectDebitTabFragment.access$100(DirectDebitTabFragment.this, view);
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    ()
    {
        this$0 = DirectDebitTabFragment.this;
        super();
    }
}
