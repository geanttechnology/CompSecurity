// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;


// Referenced classes of package com.livemixtapes:
//            PullToRefreshListView

private static final class  extends Enum
{

    private static final REFRESHING ENUM$VALUES[];
    public static final REFRESHING PULL_TO_REFRESH;
    public static final REFRESHING REFRESHING;
    public static final REFRESHING RELEASE_TO_REFRESH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/livemixtapes/PullToRefreshListView$State, s);
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
        PULL_TO_REFRESH = new <init>("PULL_TO_REFRESH", 0);
        RELEASE_TO_REFRESH = new <init>("RELEASE_TO_REFRESH", 1);
        REFRESHING = new <init>("REFRESHING", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            PULL_TO_REFRESH, RELEASE_TO_REFRESH, REFRESHING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
