// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.tag;


// Referenced classes of package com.shazam.server.request.tag:
//            RequestTag

public static final class  extends Enum
{

    private static final PLAYER $VALUES[];
    public static final PLAYER AUDIO;
    public static final PLAYER BEAM;
    public static final PLAYER CONTEXT;
    public static final PLAYER FBDEEPLINK;
    public static final PLAYER PLAYER;
    public static final PLAYER SEARCH;
    public static final PLAYER SHARE;
    public static final PLAYER WEB;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/shazam/server/request/tag/RequestTag$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AUDIO = new <init>("AUDIO", 0);
        SEARCH = new <init>("SEARCH", 1);
        SHARE = new <init>("SHARE", 2);
        BEAM = new <init>("BEAM", 3);
        WEB = new <init>("WEB", 4);
        FBDEEPLINK = new <init>("FBDEEPLINK", 5);
        CONTEXT = new <init>("CONTEXT", 6);
        PLAYER = new <init>("PLAYER", 7);
        $VALUES = (new .VALUES[] {
            AUDIO, SEARCH, SHARE, BEAM, WEB, FBDEEPLINK, CONTEXT, PLAYER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
