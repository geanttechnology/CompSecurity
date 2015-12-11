// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;


// Referenced classes of package com.target.ui.analytics.a:
//            be

static final class  extends Enum
{

    private static final DeepLink $VALUES[];
    public static final DeepLink Browse;
    public static final DeepLink DeepLink;
    public static final DeepLink Query;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/analytics/a/be$b, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Browse = new <init>("Browse", 0);
        Query = new <init>("Query", 1);
        DeepLink = new <init>("DeepLink", 2);
        $VALUES = (new .VALUES[] {
            Browse, Query, DeepLink
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
