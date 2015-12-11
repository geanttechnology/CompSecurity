// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.pager;


// Referenced classes of package com.aio.downloader.pager:
//            JazzyViewPager

private static final class  extends Enum
{

    private static final GOING_RIGHT ENUM$VALUES[];
    public static final GOING_RIGHT GOING_LEFT;
    public static final GOING_RIGHT GOING_RIGHT;
    public static final GOING_RIGHT IDLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aio/downloader/pager/JazzyViewPager$State, s);
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
        IDLE = new <init>("IDLE", 0);
        GOING_LEFT = new <init>("GOING_LEFT", 1);
        GOING_RIGHT = new <init>("GOING_RIGHT", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            IDLE, GOING_LEFT, GOING_RIGHT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
