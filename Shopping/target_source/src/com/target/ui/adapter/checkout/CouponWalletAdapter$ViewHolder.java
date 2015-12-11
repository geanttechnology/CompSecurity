// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.target.mothership.common.a.f;

// Referenced classes of package com.target.ui.adapter.checkout:
//            CouponWalletAdapter

public static class root
{

    public f fulfillmentType;
    public int position;
    public View root;
    ImageButton walletInfo;
    RadioButton walletItemChoice;
    TextView walletSubTitle;
    TextView walletTitle;

    public (View view)
    {
        position = -1;
        root = view;
        ButterKnife.bind(this, root);
    }
}
