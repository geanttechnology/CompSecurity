// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ShippingAddress

class this._cls0
    implements android.widget.SelectedListener
{

    final ShippingAddress this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = Strings.toString(shippingCountry.getSelectedItem());
        adapterview = getShippingStringArray("shipping_state_", adapterview);
        initializeSpinner(shippingState, adapterview, null);
        setSpinnerValue(shippingState, ShippingAddress.access$100(ShippingAddress.this).getString("preferredShippingState", ""), adapterview);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    edListener()
    {
        this$0 = ShippingAddress.this;
        super();
    }
}
