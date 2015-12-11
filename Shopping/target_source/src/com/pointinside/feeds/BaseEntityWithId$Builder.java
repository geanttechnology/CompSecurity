// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            BaseEntityWithId

protected static class venueId extends venueId
{

    private String venueId;

    public venueId setVenueId(String s)
    {
        venueId = s;
        return this;
    }


    protected ()
    {
        venueId = null;
    }

    public venueId(BaseEntityWithId baseentitywithid)
    {
        super(baseentitywithid);
        venueId = null;
        venueId = baseentitywithid.venueId;
    }
}
