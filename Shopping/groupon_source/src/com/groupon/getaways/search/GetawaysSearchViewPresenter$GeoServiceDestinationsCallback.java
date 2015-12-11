// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import java.util.Map;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchViewPresenter, DestinationsData, GetawaysSearchView

private class query
    implements query
{

    private final String query;
    final GetawaysSearchViewPresenter this$0;

    public void onDestinationsData(DestinationsData destinationsdata)
    {
        if (destinationsdata.error == null && destinationsdata.destinations != null)
        {
            GetawaysSearchViewPresenter.access$600(GetawaysSearchViewPresenter.this).put(query, destinationsdata.destinations);
            if (GetawaysSearchViewPresenter.access$700(GetawaysSearchViewPresenter.this) != null && query.equals(query(GetawaysSearchViewPresenter.access$800(GetawaysSearchViewPresenter.this))))
            {
                GetawaysSearchViewPresenter.access$700(GetawaysSearchViewPresenter.this).showAutocompleteDestinations(destinationsdata.destinations);
                return;
            }
        }
    }

    public (String s)
    {
        this$0 = GetawaysSearchViewPresenter.this;
        super();
        query = s;
    }
}
