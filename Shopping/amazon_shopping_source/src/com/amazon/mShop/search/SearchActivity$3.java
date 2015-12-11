// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.view.View;
import com.amazon.mShop.gno.GNODrawerHelper;

// Referenced classes of package com.amazon.mShop.search:
//            SearchActivity

class this._cls0
    implements android.view.ner
{

    final SearchActivity this$0;

    public void onClick(View view)
    {
        GNODrawerHelper.closeDrawerAndExecute(SearchActivity.this, true, new Runnable() {

            final SearchActivity._cls3 this$1;

            public void run()
            {
                setSearchEntryViewAsRoot(getIntent(), false);
            }

            
            {
                this$1 = SearchActivity._cls3.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = SearchActivity.this;
        super();
    }
}
