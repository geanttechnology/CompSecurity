// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;


// Referenced classes of package com.target.ui.analytics.a:
//            be

private static final class  extends Enum
{

    private static final Target $VALUES[];
    public static final Target PointInside;
    public static final Target Target;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/analytics/a/be$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PointInside = new <init>("PointInside", 0);
        Target = new <init>("Target", 1);
        $VALUES = (new .VALUES[] {
            PointInside, Target
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
