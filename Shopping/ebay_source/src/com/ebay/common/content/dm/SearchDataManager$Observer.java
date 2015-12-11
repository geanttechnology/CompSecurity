// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchResultState;
import com.ebay.nautilus.domain.content.ListContent;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.content.dm:
//            SearchDataManager

public static interface 
{

    public abstract void onAdsLoaded(SearchResultState searchresultstate);

    public abstract void onPopularSearchesAvailable(ArrayList arraylist, int i);

    public abstract void onSearchCancelled();

    public abstract void onSearchComplete(SearchResultState searchresultstate);

    public abstract void onSearchContentChanged(ListContent listcontent);

    public abstract void onSearchStarted(SearchParameters searchparameters);
}
