// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.adapters;

import android.view.View;
import com.bitstrips.outfitbuilder.models.OBBrand;
import com.bitstrips.outfitbuilder.views.BrandHeaderView;

// Referenced classes of package com.bitstrips.outfitbuilder.adapters:
//            OBCatalogArrayAdapter

class brandHeaderView extends android.support.v7.widget.ViewHolder
{

    BrandHeaderView brandHeaderView;
    final OBCatalogArrayAdapter this$0;

    public void setBrand(OBBrand obbrand)
    {
        brandHeaderView.setBrandData(obbrand);
    }

    public (View view)
    {
        this$0 = OBCatalogArrayAdapter.this;
        super(view);
        brandHeaderView = (BrandHeaderView)view.findViewById(com.bitstrips.outfitbuilder.ewHolder.brandHeaderView);
    }
}
