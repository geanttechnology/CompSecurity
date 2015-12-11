// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.model.LocationResults;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            LocationServiceCall, LocationListener

public static interface Q
{

    public abstract LocationResults parse(InputStream inputstream, LocationListener locationlistener)
        throws IOException;
}
