// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.fragments;

import com.bitstrips.imoji.models.Imoji;

// Referenced classes of package com.bitstrips.imoji.ui.fragments:
//            FavouriteFragment

class this._cls0
    implements com.bitstrips.imoji.ui.adapters.ouriteClickListener
{

    final FavouriteFragment this$0;

    public void onClick(Imoji imoji)
    {
        if (FavouriteFragment.access$000(FavouriteFragment.this) != null)
        {
            FavouriteFragment.access$000(FavouriteFragment.this).onClick(imoji);
        }
    }

    uriteClickListener()
    {
        this$0 = FavouriteFragment.this;
        super();
    }
}
