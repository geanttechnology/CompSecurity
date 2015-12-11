// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.util.StringTokenizer;
import org.cybergarage.util.Debug;

public class HTTPStatus
{

    public static final int BAD_REQUEST = 400;
    public static final int CONTINUE = 100;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int INVALID_RANGE = 416;
    public static final int NOT_FOUND = 404;
    public static final int OK = 200;
    public static final int PARTIAL_CONTENT = 206;
    public static final int PRECONDITION_FAILED = 412;
    private String reasonPhrase;
    private int statusCode;
    private String version;

    public HTTPStatus()
    {
        version = "";
        statusCode = 0;
        reasonPhrase = "";
        setVersion("");
        setStatusCode(0);
        setReasonPhrase("");
    }

    public HTTPStatus(String s)
    {
        version = "";
        statusCode = 0;
        reasonPhrase = "";
        set(s);
    }

    public HTTPStatus(String s, int i, String s1)
    {
        version = "";
        statusCode = 0;
        reasonPhrase = "";
        setVersion(s);
        setStatusCode(i);
        setReasonPhrase(s1);
    }

    public static final String code2String(int i)
    {
        switch (i)
        {
        default:
            return "";

        case 100: // 'd'
            return "Continue";

        case 200: 
            return "OK";

        case 206: 
            return "Partial Content";

        case 400: 
            return "Bad Request";

        case 404: 
            return "Not Found";

        case 412: 
            return "Precondition Failed";

        case 416: 
            return "Invalid Range";

        case 500: 
            return "Internal Server Error";
        }
    }

    public static final boolean isSuccessful(int i)
    {
        return 200 <= i && i < 300;
    }

    public String getReasonPhrase()
    {
        return reasonPhrase;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public String getVersion()
    {
        return version;
    }

    public boolean isSuccessful()
    {
        return isSuccessful(getStatusCode());
    }

    public void set(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        setVersion("1.1");
        setStatusCode(500);
        setReasonPhrase(code2String(500));
_L4:
        return;
_L2:
        StringTokenizer stringtokenizer = new StringTokenizer(s, " ");
        if (!stringtokenizer.hasMoreTokens()) goto _L4; else goto _L3
_L3:
        setVersion(stringtokenizer.nextToken().trim());
        if (!stringtokenizer.hasMoreTokens()) goto _L4; else goto _L5
_L5:
        s = stringtokenizer.nextToken();
        int i = 0;
        int j = Integer.parseInt(s);
        i = j;
_L9:
        try
        {
            setStatusCode(i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Debug.warning(s);
            return;
        }
        s = "";
_L7:
        if (!stringtokenizer.hasMoreTokens())
        {
            setReasonPhrase(s.trim());
            return;
        }
        String s1 = s;
        if (s.length() >= 0)
        {
            s1 = (new StringBuilder(String.valueOf(s))).append(" ").toString();
        }
        s = (new StringBuilder(String.valueOf(s1))).append(stringtokenizer.nextToken()).toString();
        if (true) goto _L7; else goto _L6
_L6:
        s;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void setReasonPhrase(String s)
    {
        reasonPhrase = s;
    }

    public void setStatusCode(int i)
    {
        statusCode = i;
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
