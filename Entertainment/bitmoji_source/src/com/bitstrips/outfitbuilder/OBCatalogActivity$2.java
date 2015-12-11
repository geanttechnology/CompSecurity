// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder;

import com.bitstrips.outfitbuilder.adapters.OBCatalogArrayAdapter;

// Referenced classes of package com.bitstrips.outfitbuilder:
//            OBCatalogActivity

class SizeLookup extends android.support.v7.widget.anSizeLookup
{

    final OBCatalogActivity this$0;
    final OBCatalogArrayAdapter val$adapter;

    public int getSpanSize(int i)
    {
        return val$adapter.getSpanSizeForItem(i, 3);
    }

    rayAdapter()
    {
        this$0 = final_obcatalogactivity;
        val$adapter = OBCatalogArrayAdapter.this;
        super();
    }
}
