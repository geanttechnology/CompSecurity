// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            SearchServiceCall, SearchListener

public static interface 
{

    public abstract SearchResult parse(InputStream inputstream, SearchListener searchlistener)
        throws IOException;
}
