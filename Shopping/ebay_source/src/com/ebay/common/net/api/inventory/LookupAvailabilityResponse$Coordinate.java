// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;


// Referenced classes of package com.ebay.common.net.api.inventory:
//            LookupAvailabilityResponse

static final class lon
{

    double lat;
    double lon;

    public boolean equals(Object obj)
    {
label0:
        {
            boolean flag = false;
            if (obj instanceof lon)
            {
                obj = (lon)obj;
                if (lat != ((lat) (obj)).lat || lon != ((lon) (obj)).lon)
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        return false;
    }

    (double d, double d1)
    {
        lat = d;
        lon = d1;
    }
}
