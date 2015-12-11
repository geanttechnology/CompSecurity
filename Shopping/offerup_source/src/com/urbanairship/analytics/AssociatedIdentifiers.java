// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AssociatedIdentifiers
{

    private static final String ADVERTISING_ID_KEY = "com.urbanairship.aaid";
    public static final int MAX_CHARACTER_COUNT = 255;
    public static final int MAX_IDS = 100;
    private final Map ids;

    private AssociatedIdentifiers(Builder builder)
    {
        ids = new HashMap(builder.ids);
    }

    AssociatedIdentifiers(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public Map getIds()
    {
        return Collections.unmodifiableMap(ids);
    }

    private class Builder
    {

        private final Map ids = new HashMap();

        public AssociatedIdentifiers create()
        {
            return new AssociatedIdentifiers(this, null);
        }

        public Builder setAdvertisingId(String s)
        {
            ids.put("com.urbanairship.aaid", s);
            return this;
        }

        public Builder setIdentifier(String s, String s1)
        {
            ids.put(s, s1);
            return this;
        }


        public Builder()
        {
        }
    }

}
