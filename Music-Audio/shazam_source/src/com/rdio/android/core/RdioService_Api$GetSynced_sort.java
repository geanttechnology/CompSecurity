// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class  extends Enum
{

    private static final Name $VALUES[];
    public static final Name DateAdded;
    public static final Name Name;
    public static final Name PlayCount;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/RdioService_Api$GetSynced_sort, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PlayCount = new <init>("PlayCount", 0);
        DateAdded = new <init>("DateAdded", 1);
        Name = new <init>("Name", 2);
        $VALUES = (new .VALUES[] {
            PlayCount, DateAdded, Name
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
