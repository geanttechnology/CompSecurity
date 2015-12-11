// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.adapters;

import android.view.View;
import com.bitstrips.outfitbuilder.views.ShowcaseView;
import java.util.List;

// Referenced classes of package com.bitstrips.outfitbuilder.adapters:
//            OBCatalogArrayAdapter

class this._cls0 extends android.support.v7.widget.ViewHolder
{

    final OBCatalogArrayAdapter this$0;

    public void setCarousel(List list)
    {
        ((ShowcaseView)itemView).setCatalog(list);
    }

    public (View view)
    {
        this$0 = OBCatalogArrayAdapter.this;
        super(view);
    }
}
