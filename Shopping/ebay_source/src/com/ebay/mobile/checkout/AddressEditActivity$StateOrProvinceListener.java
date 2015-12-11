// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.view.View;
import android.widget.AdapterView;
import com.ebay.nautilus.domain.data.Address;

// Referenced classes of package com.ebay.mobile.checkout:
//            AddressEditActivity

public class this._cls0
    implements android.widget.eListener
{

    final AddressEditActivity this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (i > 0)
        {
            currentAddress.addressFields._fld0 = adapterview.getItemAtPosition(i).toString();
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    public ()
    {
        this$0 = AddressEditActivity.this;
        super();
    }
}
