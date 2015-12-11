// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;


// Referenced classes of package com.target.ui.analytics.a:
//            al

public static final class  extends Enum
{

    private static final AddToList $VALUES[];
    public static final AddToList AddToList;
    public static final AddToList PickUp;
    public static final AddToList ShipIt;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/analytics/a/al$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ShipIt = new <init>("ShipIt", 0);
        PickUp = new <init>("PickUp", 1);
        AddToList = new <init>("AddToList", 2);
        $VALUES = (new .VALUES[] {
            ShipIt, PickUp, AddToList
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
