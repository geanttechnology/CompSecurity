// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;


// Referenced classes of package com.rdio.android.core:
//            RdioService_Api

public static final class  extends Enum
{

    private static final Unban $VALUES[];
    public static final Unban Ban;
    public static final Unban Unban;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/RdioService_Api$VoteForItemOnStation_vote, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Ban = new <init>("Ban", 0);
        Unban = new <init>("Unban", 1);
        $VALUES = (new .VALUES[] {
            Ban, Unban
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
