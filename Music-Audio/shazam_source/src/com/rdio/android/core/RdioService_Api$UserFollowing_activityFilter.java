// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class  extends Enum
{

    private static final Inactive $VALUES[];
    public static final Inactive Active;
    public static final Inactive All;
    public static final Inactive Inactive;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/RdioService_Api$UserFollowing_activityFilter, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Active = new <init>("Active", 0);
        All = new <init>("All", 1);
        Inactive = new <init>("Inactive", 2);
        $VALUES = (new .VALUES[] {
            Active, All, Inactive
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
