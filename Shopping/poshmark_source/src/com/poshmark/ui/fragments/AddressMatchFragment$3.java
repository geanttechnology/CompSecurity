// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.poshmark.data_model.models.AddressCheckerResults;
import com.poshmark.data_model.models.inner_models.Address;

// Referenced classes of package com.poshmark.ui.fragments:
//            AddressMatchFragment

class this._cls0
    implements android.view.chFragment._cls3
{

    final AddressMatchFragment this$0;

    public void onClick(View view)
    {
        view = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("CITY", AddressMatchFragment.access$000(AddressMatchFragment.this).getCity());
        bundle.putString("STATE", AddressMatchFragment.access$000(AddressMatchFragment.this).getState());
        bundle.putString("STREET", AddressMatchFragment.access$000(AddressMatchFragment.this).getStreet());
        bundle.putString("STREET2", AddressMatchFragment.access$000(AddressMatchFragment.this).getStreet2());
        bundle.putString("TYPE", AddressMatchFragment.access$000(AddressMatchFragment.this).getType());
        bundle.putString("ZIP", AddressMatchFragment.access$000(AddressMatchFragment.this).getZip());
        bundle.putString("NAME", AddressMatchFragment.access$100(AddressMatchFragment.this).address_entered.getName());
        bundle.putString("PHONE", AddressMatchFragment.access$100(AddressMatchFragment.this).address_entered.getPhone());
        view.putExtras(bundle);
        finishActivityWithResult(-1, view);
    }

    lts()
    {
        this$0 = AddressMatchFragment.this;
        super();
    }
}
