// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.cart;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.mothership.common.a.f;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.adapter.cart:
//            CartPickupStoreAdapter

static class position extends a
{

    f fulfillmentType;
    RadioButton pickupStoreChoice;
    int position;
    View root;
    TextView stockStatus;
    ImageButton storeInfo;
    TextView storeName;

    (View view)
    {
        super(view);
        position = -1;
    }
}
