// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.b;


// Referenced classes of package com.target.ui.analytics.b:
//            g

public static final class  extends Enum
{

    private static final Remove $VALUES[];
    public static final Remove Add;
    public static final Remove Remove;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/analytics/b/g$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Add = new <init>("Add", 0);
        Remove = new <init>("Remove", 1);
        $VALUES = (new .VALUES[] {
            Add, Remove
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
