// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;


// Referenced classes of package org.springframework.http:
//            HttpStatus

public static final class value extends Enum
{

    private static final SERVER_ERROR $VALUES[];
    public static final SERVER_ERROR CLIENT_ERROR;
    public static final SERVER_ERROR INFORMATIONAL;
    public static final SERVER_ERROR REDIRECTION;
    public static final SERVER_ERROR SERVER_ERROR;
    public static final SERVER_ERROR SUCCESSFUL;
    private final int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(org/springframework/http/HttpStatus$Series, s);
    }

    private static value valueOf(HttpStatus httpstatus)
    {
        int j = httpstatus.value() / 100;
        value avalue[] = values();
        int k = avalue.length;
        for (int i = 0; i < k; i++)
        {
            value value1 = avalue[i];
            if (value1.value == j)
            {
                return value1;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("No matching constant for [").append(httpstatus).append("]").toString());
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        INFORMATIONAL = new <init>("INFORMATIONAL", 0, 1);
        SUCCESSFUL = new <init>("SUCCESSFUL", 1, 2);
        REDIRECTION = new <init>("REDIRECTION", 2, 3);
        CLIENT_ERROR = new <init>("CLIENT_ERROR", 3, 4);
        SERVER_ERROR = new <init>("SERVER_ERROR", 4, 5);
        $VALUES = (new .VALUES[] {
            INFORMATIONAL, SUCCESSFUL, REDIRECTION, CLIENT_ERROR, SERVER_ERROR
        });
    }


    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
