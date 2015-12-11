// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;


// Referenced classes of package amazon.communication.identity:
//            IRServiceEndpoint

public static final class mName extends Enum
{

    private static final HTTPS $VALUES[];
    public static final HTTPS HTTP;
    public static final HTTPS HTTPS;
    public static final HTTPS WS;
    public static final HTTPS WSS;
    private final String mName;

    public static mName valueOf(String s)
    {
        return (mName)Enum.valueOf(amazon/communication/identity/IRServiceEndpoint$Scheme, s);
    }

    public static mName[] values()
    {
        return (mName[])$VALUES.clone();
    }

    public String toString()
    {
        return mName;
    }

    static 
    {
        WS = new <init>("WS", 0, "ws");
        WSS = new <init>("WSS", 1, "wss");
        HTTP = new <init>("HTTP", 2, "http");
        HTTPS = new <init>("HTTPS", 3, "https");
        $VALUES = (new .VALUES[] {
            WS, WSS, HTTP, HTTPS
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }
}
