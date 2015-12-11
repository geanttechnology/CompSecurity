// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;


// Referenced classes of package com.target.mothership.common.params:
//            ProductSummaryParam

public static final class mValue extends Enum
{

    private static final ONLINE $VALUES[];
    public static final ONLINE MOBILE;
    public static final ONLINE ONLINE;
    private String mValue;

    public static mValue valueOf(String s)
    {
        return (mValue)Enum.valueOf(com/target/mothership/common/params/ProductSummaryParam$a, s);
    }

    public static mValue[] values()
    {
        return (mValue[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        MOBILE = new <init>("MOBILE", 0, "mobile");
        ONLINE = new <init>("ONLINE", 1, "online");
        $VALUES = (new .VALUES[] {
            MOBILE, ONLINE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }
}
