// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;


// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class  extends Enum
{

    public static final EGold EGold;
    private static final EGold ENUM$VALUES[];
    public static final EGold ESilver;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        ESilver = new <init>("ESilver", 0);
        EGold = new <init>("EGold", 1);
        ENUM$VALUES = (new ENUM.VALUES[] {
            ESilver, EGold
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
