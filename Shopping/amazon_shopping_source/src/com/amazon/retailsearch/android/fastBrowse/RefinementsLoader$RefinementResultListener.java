// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            RefinementsLoader

public static interface 
{

    public abstract void onError(Exception exception);

    public abstract void onResult(SearchResult searchresult);
}
