// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder;

import android.support.v7.app.AppCompatActivity;
import com.bitstrips.outfitbuilder.adapters.OBCatalogArrayAdapter;
import com.bitstrips.outfitbuilder.models.OBCatalog;
import com.bitstrips.outfitbuilder.models.OBOutfit;

// Referenced classes of package com.bitstrips.outfitbuilder:
//            OBCatalogActivity

class rayAdapter extends OBCatalogArrayAdapter
{

    final OBCatalogActivity this$0;

    public void onOutfitClicked(OBOutfit oboutfit)
    {
        goToFittingRoom(oboutfit.getId());
    }

    rayAdapter(AppCompatActivity appcompatactivity, OBCatalog obcatalog)
    {
        this$0 = OBCatalogActivity.this;
        super(appcompatactivity, obcatalog);
    }
}
