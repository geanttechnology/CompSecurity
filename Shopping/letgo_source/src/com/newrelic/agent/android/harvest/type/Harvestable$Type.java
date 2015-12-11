// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest.type;


// Referenced classes of package com.newrelic.agent.android.harvest.type:
//            Harvestable

public static final class  extends Enum
{

    private static final VALUE $VALUES[];
    public static final VALUE ARRAY;
    public static final VALUE OBJECT;
    public static final VALUE VALUE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/newrelic/agent/android/harvest/type/Harvestable$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OBJECT = new <init>("OBJECT", 0);
        ARRAY = new <init>("ARRAY", 1);
        VALUE = new <init>("VALUE", 2);
        $VALUES = (new .VALUES[] {
            OBJECT, ARRAY, VALUE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
