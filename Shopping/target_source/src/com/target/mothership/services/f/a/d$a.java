// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.f.a;


// Referenced classes of package com.target.mothership.services.f.a:
//            d

public static final class  extends Enum
{

    private static final PUT $VALUES[];
    public static final PUT DELETE;
    public static final PUT GET;
    public static final PUT POST;
    public static final PUT PUT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/mothership/services/f/a/d$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DELETE = new <init>("DELETE", 0);
        GET = new <init>("GET", 1);
        POST = new <init>("POST", 2);
        PUT = new <init>("PUT", 3);
        $VALUES = (new .VALUES[] {
            DELETE, GET, POST, PUT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
