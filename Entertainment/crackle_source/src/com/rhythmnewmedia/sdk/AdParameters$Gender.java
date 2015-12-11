// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;


// Referenced classes of package com.rhythmnewmedia.sdk:
//            AdParameters

public static final class  extends Enum
{

    private static final female a[];
    public static final female female;
    public static final female male;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rhythmnewmedia/sdk/AdParameters$Gender, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        male = new <init>("male", 0);
        female = new <init>("female", 1);
        a = (new a[] {
            male, female
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
