// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.util.List;

// Referenced classes of package com.groupon.util:
//            Function1, LocationsAutocompleteServiceWrapper, LocationAutocompleteClient, LocationSearchUtil

class val.keyword
    implements Function1
{

    final LocationsAutocompleteServiceWrapper this$0;
    final String val$keyword;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        if (LocationsAutocompleteServiceWrapper.access$100(LocationsAutocompleteServiceWrapper.this) == null || LocationsAutocompleteServiceWrapper.access$100(LocationsAutocompleteServiceWrapper.this).isTextEmpty())
        {
            return;
        } else
        {
            populateLocationSuggestionsList(LocationsAutocompleteServiceWrapper.access$200(LocationsAutocompleteServiceWrapper.this).getPlacesFromLocationSuggestions(list), val$keyword);
            return;
        }
    }

    ()
    {
        this$0 = final_locationsautocompleteservicewrapper;
        val$keyword = String.this;
        super();
    }
}
