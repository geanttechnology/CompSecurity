// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;


// Referenced classes of package com.amazon.insights.core.http:
//            HttpClient

public static final class _cls9 extends Enum
{

    private static final POST $VALUES[];
    public static final POST GET;
    public static final POST POST;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/amazon/insights/core/http/HttpClient$HttpMethod, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        GET = new <init>("GET", 0);
        POST = new <init>("POST", 1);
        $VALUES = (new .VALUES[] {
            GET, POST
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
