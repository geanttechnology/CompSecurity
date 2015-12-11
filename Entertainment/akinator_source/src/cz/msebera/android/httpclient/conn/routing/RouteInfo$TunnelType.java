// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.routing;


// Referenced classes of package cz.msebera.android.httpclient.conn.routing:
//            RouteInfo

public static final class  extends Enum
{

    private static final TUNNELLED $VALUES[];
    public static final TUNNELLED PLAIN;
    public static final TUNNELLED TUNNELLED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(cz/msebera/android/httpclient/conn/routing/RouteInfo$TunnelType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PLAIN = new <init>("PLAIN", 0);
        TUNNELLED = new <init>("TUNNELLED", 1);
        $VALUES = (new .VALUES[] {
            PLAIN, TUNNELLED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
