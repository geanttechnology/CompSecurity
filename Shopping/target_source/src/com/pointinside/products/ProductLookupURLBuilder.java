// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.location.Location;
import com.pointinside.net.EndpointType;

// Referenced classes of package com.pointinside.products:
//            SearchURLBuilder

public class ProductLookupURLBuilder extends SearchURLBuilder
{

    public ProductLookupURLBuilder(Location location)
    {
        super(EndpointType.LOOKUP, location);
    }
}
