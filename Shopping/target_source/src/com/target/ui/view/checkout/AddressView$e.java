// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.AdapterView;
import com.target.ui.util.validation.a.j;

// Referenced classes of package com.target.ui.view.checkout:
//            AddressView

private final class <init>
    implements android.widget.ItemSelectedListener
{

    final AddressView this$0;
    private boolean wasAutoSelected;
    private boolean wasValid;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (wasAutoSelected)
        {
            wasAutoSelected = false;
            return;
        }
        adapterview = AddressView.d(AddressView.this);
        if (wasValid != ((j) (adapterview)).isValid)
        {
            AddressView.a(AddressView.this, ((j) (adapterview)).isValid);
        }
        if (i == 0 && wasValid || adapterview.a())
        {
            AddressView.a(AddressView.this, adapterview);
        }
        wasValid = AddressView.d(AddressView.this).isValid;
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    private istener()
    {
        this$0 = AddressView.this;
        super();
        wasAutoSelected = true;
    }

    wasAutoSelected(wasAutoSelected wasautoselected)
    {
        this();
    }
}
