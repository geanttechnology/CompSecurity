// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.view.View;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragmentActivity

class this._cls0
    implements android.view.ctivity._cls5
{

    final SearchResultFragmentActivity this$0;

    public void onClick(View view)
    {
        if (!isFollowing())
        {
            onFollowSearch(llowSearchOrigin.GLOBAL_HEADER);
            return;
        } else
        {
            onUnfollowSearch();
            return;
        }
    }

    llowSearchOrigin()
    {
        this$0 = SearchResultFragmentActivity.this;
        super();
    }
}
