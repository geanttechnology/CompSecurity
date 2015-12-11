// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebSettings

public static final class A extends Enum
{

    private static final SINGLE_COLUMN $VALUES[];
    public static final SINGLE_COLUMN NARROW_COLUMNS;
    public static final SINGLE_COLUMN NORMAL;
    public static final SINGLE_COLUMN SINGLE_COLUMN;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/amazon/android/webkit/AmazonWebSettings$LayoutAlgorithm, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        NARROW_COLUMNS = new <init>("NARROW_COLUMNS", 0);
        NORMAL = new <init>("NORMAL", 1);
        SINGLE_COLUMN = new <init>("SINGLE_COLUMN", 2);
        $VALUES = (new .VALUES[] {
            NARROW_COLUMNS, NORMAL, SINGLE_COLUMN
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
