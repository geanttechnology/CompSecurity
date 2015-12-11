// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;

import com.groupon.models.search.domain.SortMethod;

// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class SearchFilterSortValueSelectedExtraInfo extends JsonEncodedNSTField
{

    public String query;
    public String sortMethod;

    public SearchFilterSortValueSelectedExtraInfo(String s, SortMethod sortmethod)
    {
        query = s;
        sortMethod = sortmethod.id;
    }
}
