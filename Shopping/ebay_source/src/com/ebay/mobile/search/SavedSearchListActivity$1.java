// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.nautilus.domain.content.DatedContent;

// Referenced classes of package com.ebay.mobile.search:
//            SavedSearchListActivity

class ger.SimpleObserver extends com.ebay.common.content.dm.SimpleObserver
{

    final SavedSearchListActivity this$0;

    public void onFollowedSearchesLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
    {
        if (isFinishing())
        {
            return;
        } else
        {
            SavedSearchListActivity.access$1000(SavedSearchListActivity.this);
            return;
        }
    }

    ger()
    {
        this$0 = SavedSearchListActivity.this;
        super();
    }
}
