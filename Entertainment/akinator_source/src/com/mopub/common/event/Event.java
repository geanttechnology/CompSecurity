// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;


// Referenced classes of package com.mopub.common.event:
//            BaseEvent

public class Event extends BaseEvent
{
    public static class Builder extends BaseEvent.Builder
    {

        public volatile BaseEvent build()
        {
            return build();
        }

        public Event build()
        {
            return new Event(this);
        }

        public Builder(BaseEvent.Name name, BaseEvent.Category category, double d)
        {
            super(BaseEvent.ScribeCategory.EXCHANGE_CLIENT_EVENT, name, category, d);
        }
    }


    private Event(Builder builder)
    {
        super(builder);
    }

}
