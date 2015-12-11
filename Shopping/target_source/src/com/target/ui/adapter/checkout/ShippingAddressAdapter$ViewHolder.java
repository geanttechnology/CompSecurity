// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.adapter.checkout:
//            ShippingAddressAdapter

static class position extends a
{

    RadioButton addressChoice;
    ImageView checkoutImageView;
    ImageButton editAddressButton;
    TextView mainAddressView;
    int position;
    View root;
    TextView secondaryTextView;

    (View view)
    {
        super(view);
        position = -1;
    }
}
