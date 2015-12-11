// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.streaming;


public final class SubscriptionType extends Enum
{

    private static final SubscriptionType $VALUES[];
    public static final SubscriptionType FREE;
    public static final SubscriptionType TRIAL;
    public static final SubscriptionType UNLIMITED;
    private final boolean allowsPlayback;
    private final String beaconValue;

    private SubscriptionType(String s, int i, String s1, boolean flag)
    {
        super(s, i);
        beaconValue = s1;
        allowsPlayback = flag;
    }

    public static SubscriptionType from(String s)
    {
        SubscriptionType asubscriptiontype[] = values();
        int j = asubscriptiontype.length;
        for (int i = 0; i < j; i++)
        {
            SubscriptionType subscriptiontype = asubscriptiontype[i];
            if (subscriptiontype.name().equals(s))
            {
                return subscriptiontype;
            }
        }

        return FREE;
    }

    public static SubscriptionType fromSpotifyProduct(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 32
    //                   -318452137: 74
    //                   110628630: 60;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_74;
_L4:
        switch (byte0)
        {
        default:
            return FREE;

        case 0: // '\0'
            return TRIAL;

        case 1: // '\001'
            return UNLIMITED;
        }
_L3:
        if (s.equals("trial"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s.equals("premium"))
        {
            byte0 = 1;
        }
          goto _L4
    }

    public static SubscriptionType valueOf(String s)
    {
        return (SubscriptionType)Enum.valueOf(com/shazam/model/streaming/SubscriptionType, s);
    }

    public static SubscriptionType[] values()
    {
        return (SubscriptionType[])$VALUES.clone();
    }

    public final boolean allowsPlayback()
    {
        return allowsPlayback;
    }

    public final String getBeaconValue()
    {
        return beaconValue;
    }

    static 
    {
        FREE = new SubscriptionType("FREE", 0, "free", false);
        UNLIMITED = new SubscriptionType("UNLIMITED", 1, "paid", true);
        TRIAL = new SubscriptionType("TRIAL", 2, "paid", true);
        $VALUES = (new SubscriptionType[] {
            FREE, UNLIMITED, TRIAL
        });
    }
}
