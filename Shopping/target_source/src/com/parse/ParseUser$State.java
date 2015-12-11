// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser

static class Builder extends e
{
    static class Builder extends ParseObject.State.Init
    {

        private boolean isNew;

        public volatile ParseObject.State.Init apply(ParseObject.State state)
        {
            return apply(state);
        }

        public Builder apply(ParseObject.State state)
        {
            isNew(((ParseUser.State)state).isNew());
            return (Builder)super.apply(state);
        }

        public Builder authData(Map map)
        {
            return (Builder)put("authData", map);
        }

        public volatile ParseObject.State build()
        {
            return build();
        }

        public ParseUser.State build()
        {
            return new ParseUser.State(this, null);
        }

        public Builder isNew(boolean flag)
        {
            isNew = flag;
            return this;
        }

        public Builder putAuthData(String s, Map map)
        {
            Map map1 = (Map)serverData.get("authData");
            Object obj = map1;
            if (map1 == null)
            {
                obj = new HashMap();
            }
            ((Map) (obj)).put(s, map);
            serverData.put("authData", obj);
            return this;
        }

        volatile ParseObject.State.Init self()
        {
            return self();
        }

        Builder self()
        {
            return this;
        }

        public Builder sessionToken(String s)
        {
            return (Builder)put("sessionToken", s);
        }


        public Builder()
        {
            super("_User");
        }

        Builder(ParseUser.State state)
        {
            super(state);
            isNew = state.isNew();
        }
    }


    private final boolean isNew;

    public Map authData()
    {
        Map map = (Map)get("authData");
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
        }
        return ((Map) (obj));
    }

    public boolean isNew()
    {
        return isNew;
    }

    public volatile e.Init newBuilder()
    {
        return newBuilder();
    }

    public Builder newBuilder()
    {
        return new Builder(this);
    }

    public String sessionToken()
    {
        return (String)get("sessionToken");
    }

    private Builder(Builder builder)
    {
        super(builder);
        isNew = builder.isNew;
    }

    Builder(Builder builder, Builder builder1)
    {
        this(builder);
    }
}
