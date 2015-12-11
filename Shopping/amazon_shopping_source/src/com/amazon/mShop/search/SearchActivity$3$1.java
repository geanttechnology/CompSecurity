// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.view.View;
import com.amazon.mShop.gno.GNODrawerHelper;

// Referenced classes of package com.amazon.mShop.search:
//            SearchActivity

class this._cls1
    implements Runnable
{

    final ntent this$1;

    public void run()
    {
        setSearchEntryViewAsRoot(getIntent(), false);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/search/SearchActivity$3

/* anonymous class */
    class SearchActivity._cls3
        implements android.view.View.OnClickListener
    {

        final SearchActivity this$0;

        public void onClick(View view)
        {
            GNODrawerHelper.closeDrawerAndExecute(SearchActivity.this, true, new SearchActivity._cls3._cls1());
        }

            
            {
                this$0 = SearchActivity.this;
                super();
            }
    }

}
