// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;


// Referenced classes of package com.sessionm.core:
//            Config

public static final class  extends Enum
{

    public static final at ap;
    public static final at aq;
    public static final at ar;
    public static final at as;
    public static final at at;
    private static final at au[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sessionm/core/Config$ServerType, s);
    }

    public static [] values()
    {
        return ([])au.clone();
    }

    static 
    {
        ap = new <init>("PRODUCTION", 0);
        aq = new <init>("STAGING", 1);
        ar = new <init>("DEVELOPMENT", 2);
        as = new <init>("JAPAN", 3);
        at = new <init>("CUSTOM", 4);
        au = (new au[] {
            ap, aq, ar, as, at
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
