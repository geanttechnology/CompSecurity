// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;

// Referenced classes of package com.target.ui.view.account:
//            OrderSummaryView

static class 
{

    TextView orderDate;
    LinearLayout orderList;
    TextView orderNumber;

    (View view)
    {
        ButterKnife.bind(this, view);
    }
}
