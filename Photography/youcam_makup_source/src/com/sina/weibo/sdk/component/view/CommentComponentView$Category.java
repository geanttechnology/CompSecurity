// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;


public final class mVal extends Enum
{

    private static final TRAVEL ENUM$VALUES[];
    public static final TRAVEL MOVIE;
    public static final TRAVEL TRAVEL;
    private String mVal;

    public static mVal valueOf(String s)
    {
        return (mVal)Enum.valueOf(com/sina/weibo/sdk/component/view/CommentComponentView$Category, s);
    }

    public static mVal[] values()
    {
        mVal amval[] = ENUM$VALUES;
        int i = amval.length;
        mVal amval1[] = new ENUM.VALUES[i];
        System.arraycopy(amval, 0, amval1, 0, i);
        return amval1;
    }

    public String getValue()
    {
        return mVal;
    }

    static 
    {
        MOVIE = new <init>("MOVIE", 0, "1001");
        TRAVEL = new <init>("TRAVEL", 1, "1002");
        ENUM$VALUES = (new ENUM.VALUES[] {
            MOVIE, TRAVEL
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mVal = s1;
    }
}
