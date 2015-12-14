// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.session.client;


// Referenced classes of package com.amazon.insights.session.client:
//            DefaultSessionClient

protected static final class  extends Enum
{

    private static final PAUSED $VALUES[];
    public static final PAUSED ACTIVE;
    public static final PAUSED INACTIVE;
    public static final PAUSED PAUSED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/insights/session/client/DefaultSessionClient$SessionState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INACTIVE = new <init>("INACTIVE", 0);
        ACTIVE = new <init>("ACTIVE", 1);
        PAUSED = new <init>("PAUSED", 2);
        $VALUES = (new .VALUES[] {
            INACTIVE, ACTIVE, PAUSED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
