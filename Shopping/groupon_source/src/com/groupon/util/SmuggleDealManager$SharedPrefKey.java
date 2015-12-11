// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            SmuggleDealManager

public static final class template extends Enum
{

    private static final SMUGGLED_DEALS_ON_CHANNEL $VALUES[];
    public static final SMUGGLED_DEALS_ON_CHANNEL LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL;
    public static final SMUGGLED_DEALS_ON_CHANNEL SMUGGLED_DEALS_ON_CHANNEL;
    private final String template;

    public static template valueOf(String s)
    {
        return (template)Enum.valueOf(com/groupon/util/SmuggleDealManager$SharedPrefKey, s);
    }

    public static template[] values()
    {
        return (template[])$VALUES.clone();
    }

    public String format(String s)
    {
        return String.format(template, new Object[] {
            s
        });
    }

    static 
    {
        LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL = new <init>("LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL", 0, "last_smuggle_timestamp_on_%s");
        SMUGGLED_DEALS_ON_CHANNEL = new <init>("SMUGGLED_DEALS_ON_CHANNEL", 1, "smuggled_deals_on_%s");
        $VALUES = (new .VALUES[] {
            LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL, SMUGGLED_DEALS_ON_CHANNEL
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        template = s1;
    }
}
