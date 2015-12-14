// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;


// Referenced classes of package com.mopub.common.util:
//            Timer

private static final class  extends Enum
{

    private static final STOPPED $VALUES[];
    public static final STOPPED STARTED;
    public static final STOPPED STOPPED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/common/util/Timer$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STARTED = new <init>("STARTED", 0);
        STOPPED = new <init>("STOPPED", 1);
        $VALUES = (new .VALUES[] {
            STARTED, STOPPED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
