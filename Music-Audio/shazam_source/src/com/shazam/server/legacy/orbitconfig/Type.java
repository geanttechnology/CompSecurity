// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.orbitconfig;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import com.shazam.model.analytics.BeaconEventKey;

public final class Type extends Enum
{
    public static class Deserializer
        implements k
    {

        public Type deserialize(l l1, java.lang.reflect.Type type, j j)
        {
            return Type.fromString(l1.h().b());
        }

        public volatile Object deserialize(l l1, java.lang.reflect.Type type, j j)
        {
            return deserialize(l1, type, j);
        }

        public Deserializer()
        {
        }
    }


    private static final Type $VALUES[];
    public static final Type email;
    public static final Type social;
    public static final Type unknown;
    private final BeaconEventKey beaconEventKey;
    private final String typeAnalyticsName;

    private Type(String s, int i, String s1, BeaconEventKey beaconeventkey)
    {
        super(s, i);
        typeAnalyticsName = s1;
        beaconEventKey = beaconeventkey;
    }

    public static Type fromString(String s)
    {
        if ("email".equals(s))
        {
            return email;
        }
        if ("social".equals(s))
        {
            return social;
        } else
        {
            return unknown;
        }
    }

    public static Type valueOf(String s)
    {
        return (Type)Enum.valueOf(com/shazam/server/legacy/orbitconfig/Type, s);
    }

    public static Type[] values()
    {
        return (Type[])$VALUES.clone();
    }

    public final BeaconEventKey getEventType()
    {
        return beaconEventKey;
    }

    public final String getTypeAnalyticsName()
    {
        return typeAnalyticsName;
    }

    static 
    {
        email = new Type("email", 0, "registration", BeaconEventKey.USER_EVENT);
        social = new Type("social", 1, "sociallogin", BeaconEventKey.USER_EVENT);
        unknown = new Type("unknown", 2, "unknown", BeaconEventKey.USER_EVENT);
        $VALUES = (new Type[] {
            email, social, unknown
        });
    }
}
