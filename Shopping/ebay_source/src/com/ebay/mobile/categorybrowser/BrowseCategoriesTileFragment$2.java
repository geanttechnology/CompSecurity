// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.support.v7.widget.RecyclerView;
import android.view.View;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            BrowseCategoriesTileFragment

class this._cls0
    implements Runnable
{

    final BrowseCategoriesTileFragment this$0;

    public void run()
    {
        browseFragmentContainer.setTranslationX(BrowseCategoriesTileFragment.access$000(BrowseCategoriesTileFragment.this).getWidth() / 2);
        browseFragmentContainer.setVisibility(0);
    }

    ()
    {
        this$0 = BrowseCategoriesTileFragment.this;
        super();
    }
}
