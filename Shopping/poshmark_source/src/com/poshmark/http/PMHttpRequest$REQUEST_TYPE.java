// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http;


// Referenced classes of package com.poshmark.http:
//            PMHttpRequest

public static final class  extends Enum
{

    private static final HTTP_DELETE $VALUES[];
    public static final HTTP_DELETE HTTP_DELETE;
    public static final HTTP_DELETE HTTP_GET;
    public static final HTTP_DELETE HTTP_POST;
    public static final HTTP_DELETE HTTP_PUT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/http/PMHttpRequest$REQUEST_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HTTP_GET = new <init>("HTTP_GET", 0);
        HTTP_POST = new <init>("HTTP_POST", 1);
        HTTP_PUT = new <init>("HTTP_PUT", 2);
        HTTP_DELETE = new <init>("HTTP_DELETE", 3);
        $VALUES = (new .VALUES[] {
            HTTP_GET, HTTP_POST, HTTP_PUT, HTTP_DELETE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
