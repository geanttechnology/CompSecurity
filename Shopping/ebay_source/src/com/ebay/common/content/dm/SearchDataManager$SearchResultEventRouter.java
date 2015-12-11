// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.net.api.search.SearchResult;
import com.ebay.nautilus.domain.content.ListContent;

// Referenced classes of package com.ebay.common.content.dm:
//            SearchDataManager

private class er
    implements com.ebay.common.net.api.search.bserver
{

    final SearchDataManager this$0;

    private boolean isCurrent()
    {
        return SearchDataManager.access$500(SearchDataManager.this) == this;
    }

    public void onSearchContentChanged(ListContent listcontent)
    {
        if (!isCurrent() || SearchDataManager.access$000(SearchDataManager.this) == null)
        {
            return;
        } else
        {
            ((this._cls0)SearchDataManager.access$600(SearchDataManager.this)).Changed(listcontent);
            return;
        }
    }

    public er(SearchResult searchresult)
    {
        this$0 = SearchDataManager.this;
        super();
        while (searchresult == null || searchresult.resultOwner == null) 
        {
            return;
        }
        searchresult.resultOwner.bserver(this);
    }
}
