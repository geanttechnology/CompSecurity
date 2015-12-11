// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;


// Referenced classes of package com.sessionm.net:
//            Request

public static final class eS extends Enum
{

    public static final eR eM;
    public static final eR eN;
    public static final eR eO;
    public static final eR eP;
    public static final eR eQ;
    public static final eR eR;
    private static final eR eT[];
    private final String eS;

    public static eS valueOf(String s)
    {
        return (eS)Enum.valueOf(com/sessionm/net/Request$Header, s);
    }

    public static eS[] values()
    {
        return (eS[])eT.clone();
    }

    public String getKey()
    {
        return eS;
    }

    static 
    {
        eM = new <init>("CACHE_CONTROL", 0, "Cache-Control");
        eN = new <init>("USER_AGENT", 1, "User-Agent");
        eO = new <init>("CONTENT_TYPE", 2, "Content-Type");
        eP = new <init>("SET_COOKIE", 3, "Set-Cookie");
        eQ = new <init>("LOCATION", 4, "Location");
        eR = new <init>("CONTENT_LENGTH", 5, "Content-Length");
        eT = (new eT[] {
            eM, eN, eO, eP, eQ, eR
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        eS = s1;
    }
}
