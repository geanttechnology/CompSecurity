// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;


// Referenced classes of package com.bitstrips.imoji.ui:
//            FavoriteImojiFragment, ImagesGridViewsWrapper

class this._cls0
    implements tarChangeListener
{

    final FavoriteImojiFragment this$0;

    public void onChanged()
    {
        recentGridViewsWrapper.notifyDataSetChanged();
        popularGridViewsWrapper.notifyDataSetChanged();
        purchasedGridViewsWrapper.notifyDataSetChanged();
    }

    tarChangeListener()
    {
        this$0 = FavoriteImojiFragment.this;
        super();
    }
}
