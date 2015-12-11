// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class A extends Enum
{

    private static final LastUpdated $VALUES[];
    public static final LastUpdated LastUpdated;
    public static final LastUpdated Name;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/rdio/android/core/RdioService_Api$GetUserPlaylists_sort, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        Name = new <init>("Name", 0);
        LastUpdated = new <init>("LastUpdated", 1);
        $VALUES = (new .VALUES[] {
            Name, LastUpdated
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
