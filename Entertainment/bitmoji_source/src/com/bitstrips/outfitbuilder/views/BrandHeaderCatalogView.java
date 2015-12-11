// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.views;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package com.bitstrips.outfitbuilder.views:
//            BrandHeaderView

public class BrandHeaderCatalogView extends BrandHeaderView
{

    public BrandHeaderCatalogView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected int getLayout()
    {
        return com.bitstrips.outfitbuilder.R.layout.brand_header_for_catalog;
    }
}
