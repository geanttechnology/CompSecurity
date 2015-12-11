// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static final class A extends Enum
{

    private static final APPLIED $VALUES[];
    public static final APPLIED APPLIED;
    public static final APPLIED NOT_APPLIED;

    public static A from(String s)
    {
        try
        {
            s = valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return NOT_APPLIED;
        }
        return s;
    }

    public static NOT_APPLIED valueOf(String s)
    {
        return (NOT_APPLIED)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Promotion$Status, s);
    }

    public static NOT_APPLIED[] values()
    {
        return (NOT_APPLIED[])$VALUES.clone();
    }

    static 
    {
        NOT_APPLIED = new <init>("NOT_APPLIED", 0);
        APPLIED = new <init>("APPLIED", 1);
        $VALUES = (new .VALUES[] {
            NOT_APPLIED, APPLIED
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
