// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.fragments;

import com.bitstrips.imoji.ui.adapters.FavouriteAdapter;

// Referenced classes of package com.bitstrips.imoji.ui.fragments:
//            FavouriteFragment

class ookup extends android.support.v7.widget.anSizeLookup
{

    final FavouriteFragment this$0;
    final FavouriteAdapter val$adapter;

    public int getSpanSize(int i)
    {
        return val$adapter.getSpanSizeForItem(i);
    }

    ookup()
    {
        this$0 = final_favouritefragment;
        val$adapter = FavouriteAdapter.this;
        super();
    }
}
