// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;


public final class  extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    private static final i j[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/you/utility/ULogUtility$LogType, s);
    }

    public static [] values()
    {
        return ([])j.clone();
    }

    static 
    {
        a = new <init>("XMPP", 0);
        b = new <init>("PingServer", 1);
        c = new <init>("GCM", 2);
        d = new <init>("SendPhoto", 3);
        e = new <init>("Heartbeat", 4);
        f = new <init>("Notification", 5);
        g = new <init>("DB", 6);
        h = new <init>("VoiceCall", 7);
        i = new <init>("UnreadCnt", 8);
        j = (new j[] {
            a, b, c, d, e, f, g, h, i
        });
    }

    private (String s, int k)
    {
        super(s, k);
    }
}
