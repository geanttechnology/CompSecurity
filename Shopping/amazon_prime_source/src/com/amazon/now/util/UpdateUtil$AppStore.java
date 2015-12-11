// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;


// Referenced classes of package com.amazon.now.util:
//            UpdateUtil

private static final class  extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER AMAZON_APP_STORE;
    public static final OTHER GOOGLE_PLAY;
    public static final OTHER OTHER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/now/util/UpdateUtil$AppStore, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        GOOGLE_PLAY = new <init>("GOOGLE_PLAY", 0);
        AMAZON_APP_STORE = new <init>("AMAZON_APP_STORE", 1);
        OTHER = new <init>("OTHER", 2);
        $VALUES = (new .VALUES[] {
            GOOGLE_PLAY, AMAZON_APP_STORE, OTHER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
