// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.view.a;
import com.target.ui.view.cart.CartHeaderView;
import com.target.ui.view.cart.CartProductListView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.product.PdpRecommendationsView;

// Referenced classes of package com.target.ui.fragment.cart:
//            CartHomeFragment

static class notEmptyRecommendationsView extends a
{

    Button checkoutButton;
    LinearLayout emptyCartContainer;
    TextView emptyCartMessage;
    LinearLayout emptyCartReauthView;
    TargetErrorView errorView;
    CartHeaderView headerView;
    CartProductListView listView;
    PdpRecommendationsView notEmptyRecommendationsView;
    GridView productRecommendationsView;
    View reauthView;

    (View view)
    {
        super(view);
        headerView = (CartHeaderView)LayoutInflater.from(view.getContext()).inflate(0x7f03010d, null);
        notEmptyRecommendationsView = (PdpRecommendationsView)LayoutInflater.from(view.getContext()).inflate(0x7f03011a, null);
    }
}
