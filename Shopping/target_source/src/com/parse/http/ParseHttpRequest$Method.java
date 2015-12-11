// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.http;


// Referenced classes of package com.parse.http:
//            ParseHttpRequest

public static final class  extends Enum
{

    private static final DELETE $VALUES[];
    public static final DELETE DELETE;
    public static final DELETE GET;
    public static final DELETE POST;
    public static final DELETE PUT;

    public static  fromString(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 48
    //                   70454: 112
    //                   79599: 140
    //                   2461856: 126
    //                   2012838315: 154;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_154;
_L6:
        switch (byte0)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid http method: <").append(s).append(">").toString());

        case 0: // '\0'
            return GET;

        case 1: // '\001'
            return POST;

        case 2: // '\002'
            return PUT;

        case 3: // '\003'
            return DELETE;
        }
_L2:
        if (s.equals("GET"))
        {
            byte0 = 0;
        }
          goto _L6
_L4:
        if (s.equals("POST"))
        {
            byte0 = 1;
        }
          goto _L6
_L3:
        if (s.equals("PUT"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("DELETE"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    public static DELETE valueOf(String s)
    {
        return (DELETE)Enum.valueOf(com/parse/http/ParseHttpRequest$Method, s);
    }

    public static DELETE[] values()
    {
        return (DELETE[])$VALUES.clone();
    }

    public String toString()
    {
        switch (chMap.com.parse.http.ParseHttpRequest.Method[ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid http method: <").append(this).append(">").toString());

        case 1: // '\001'
            return "GET";

        case 2: // '\002'
            return "POST";

        case 3: // '\003'
            return "PUT";

        case 4: // '\004'
            return "DELETE";
        }
    }

    static 
    {
        GET = new <init>("GET", 0);
        POST = new <init>("POST", 1);
        PUT = new <init>("PUT", 2);
        DELETE = new <init>("DELETE", 3);
        $VALUES = (new .VALUES[] {
            GET, POST, PUT, DELETE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
