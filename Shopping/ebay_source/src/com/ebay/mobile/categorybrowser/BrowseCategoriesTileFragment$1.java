// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.app.FragmentManager;
import android.view.View;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            BrowseCategoriesTileFragment, BrowseCategoriesFragment

class this._cls0
    implements Runnable
{

    final BrowseCategoriesTileFragment this$0;

    public void run()
    {
        browseFragmentContainer.setVisibility(8);
        FragmentManager fragmentmanager = getFragmentManager();
        if (fragmentmanager != null && !fragmentmanager.isDestroyed())
        {
            fragmentmanager.popBackStackImmediate(BrowseCategoriesFragment.createFragmentTag(1), 1);
        }
    }

    ()
    {
        this$0 = BrowseCategoriesTileFragment.this;
        super();
    }
}
