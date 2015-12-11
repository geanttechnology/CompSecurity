// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup;


// Referenced classes of package org.jsoup:
//            Connection

public static final class  extends Enum
{

    private static final POST $VALUES[];
    public static final POST GET;
    public static final POST POST;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/jsoup/Connection$Method, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        GET = new <init>("GET", 0);
        POST = new <init>("POST", 1);
        $VALUES = (new .VALUES[] {
            GET, POST
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
