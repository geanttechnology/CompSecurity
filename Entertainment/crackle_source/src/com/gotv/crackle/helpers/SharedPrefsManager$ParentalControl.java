// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;


// Referenced classes of package com.gotv.crackle.helpers:
//            SharedPrefsManager

public static final class A extends Enum
{

    private static final RESTRICT_ALL_CONTENT $VALUES[];
    public static final RESTRICT_ALL_CONTENT RESTRICT_ALL_CONTENT;
    public static final RESTRICT_ALL_CONTENT RESTRICT_MATURE_CONTENT;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/gotv/crackle/helpers/SharedPrefsManager$ParentalControl, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        RESTRICT_MATURE_CONTENT = new <init>("RESTRICT_MATURE_CONTENT", 0);
        RESTRICT_ALL_CONTENT = new <init>("RESTRICT_ALL_CONTENT", 1);
        $VALUES = (new .VALUES[] {
            RESTRICT_MATURE_CONTENT, RESTRICT_ALL_CONTENT
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
