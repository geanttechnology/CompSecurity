// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk;


// Referenced classes of package com.penthera.virtuososdk:
//            Common

public static final class  extends Enum
{

    private static final cellular ENUM$VALUES[];
    public static final cellular cellular;
    public static final cellular none;
    public static final cellular wifi;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/penthera/virtuososdk/Common$BearerType, s);
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
        none = new <init>("none", 0);
        wifi = new <init>("wifi", 1);
        cellular = new <init>("cellular", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            none, wifi, cellular
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
