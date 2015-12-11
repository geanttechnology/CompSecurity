// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            BaseEntity

public class BaseEntityWithId extends BaseEntity
{
    protected static class Builder extends BaseEntity.Builder
    {

        private String venueId;

        public Builder setVenueId(String s)
        {
            venueId = s;
            return this;
        }


        protected Builder()
        {
            venueId = null;
        }

        public Builder(BaseEntityWithId baseentitywithid)
        {
            super(baseentitywithid);
            venueId = null;
            venueId = baseentitywithid.venueId;
        }
    }


    public final String venueId;

    BaseEntityWithId()
    {
        this(new Builder());
    }

    protected BaseEntityWithId(Builder builder)
    {
        super(builder);
        venueId = builder.venueId;
    }
}
