// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import android.widget.Button;
import com.poshmark.data_model.models.AddressCheckerResults;

// Referenced classes of package com.poshmark.ui.fragments:
//            AddressMatchFragment

class this._cls0
    implements android.view.chFragment._cls2
{

    final AddressMatchFragment this$0;

    public void onClick(View view)
    {
        AddressMatchFragment.access$002(AddressMatchFragment.this, AddressMatchFragment.access$100(AddressMatchFragment.this).address_entered);
        AddressMatchFragment.access$300(AddressMatchFragment.this).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f02007d, 0);
        AddressMatchFragment.access$200(AddressMatchFragment.this).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    lts()
    {
        this$0 = AddressMatchFragment.this;
        super();
    }
}
