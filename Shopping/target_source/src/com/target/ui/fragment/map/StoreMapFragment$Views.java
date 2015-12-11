// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.map;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.StarRatingView;
import com.target.ui.view.TargetFloatingActionButton;
import com.target.ui.view.a;
import com.target.ui.view.list.ListItemMapView;
import com.target.ui.view.map.SingleGenericItemView;
import com.target.ui.view.map.StoreMapView;
import com.target.ui.view.product.ProductEyebrowView;
import com.target.ui.view.product.ProductPriceView;

// Referenced classes of package com.target.ui.fragment.map:
//            StoreMapFragment

static class  extends a
{

    ListView blackFridayDealProductListView;
    RecyclerView blackFridayDealRecyclerView;
    View divider;
    ProductEyebrowView eyebrow;
    BitmapImageView image;
    ListItemMapView mListItemView;
    View mapContent;
    ProductPriceView price;
    View productDetailArea;
    View productDetailView;
    StarRatingView rating;
    Button selectStoreButton;
    View selectStoreView;
    SingleGenericItemView singleGenericItemView;
    StoreMapView storeMapView;
    TargetFloatingActionButton targetFloatingLocationButton;
    TextView title;

    public (View view)
    {
        super(view);
    }
}
