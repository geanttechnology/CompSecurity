// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonCacheManager

public static final class A extends Enum
{

    private static final UPDATED $VALUES[];
    public static final UPDATED CACHED;
    public static final UPDATED NO_UPDATE;
    public static final UPDATED UNKNOWN;
    public static final UPDATED UPDATED;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/amazon/android/webkit/AmazonCacheManager$AppCacheStatus, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        NO_UPDATE = new <init>("NO_UPDATE", 1);
        CACHED = new <init>("CACHED", 2);
        UPDATED = new <init>("UPDATED", 3);
        $VALUES = (new .VALUES[] {
            UNKNOWN, NO_UPDATE, CACHED, UPDATED
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
