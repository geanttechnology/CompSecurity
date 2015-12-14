// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;


// Referenced classes of package org.apache.commons.httpclient:
//            HttpException, ProtocolException

public class StatusLine
{

    private final String httpVersion;
    private final String reasonPhrase = "";
    private final int statusCode;
    private final String statusLine;

    public StatusLine(String s)
        throws HttpException
    {
        int i;
        int j;
        int l;
        l = s.length();
        i = 0;
        j = 0;
        int k;
        while (Character.isWhitespace(s.charAt(j))) 
        {
            i++;
            j++;
        }
        k = j + 4;
        if (!"HTTP".equals(s.substring(j, k)))
        {
            throw new HttpException("Status-Line '" + s + "' does not start with HTTP");
        }
          goto _L1
        Object obj;
        obj;
_L7:
        throw new HttpException("Status-Line '" + s + "' is not valid");
_L1:
        j = s.indexOf(" ", k);
        if (j > 0)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        throw new ProtocolException("Unable to parse HTTP-Version from the status line: '" + s + "'");
        httpVersion = s.substring(i, j).toUpperCase();
        i = j;
        while (s.charAt(i) == ' ') 
        {
            i++;
        }
        j = s.indexOf(" ", i);
        k = j;
        if (j < 0)
        {
            k = l;
        }
        statusCode = Integer.parseInt(s.substring(i, k));
        i = k + 1;
        if (i >= l) goto _L3; else goto _L2
_L2:
        reasonPhrase = s.substring(i).trim();
_L5:
        statusLine = s;
        return;
        obj;
        throw new ProtocolException("Unable to parse status code from status line: '" + s + "'");
_L3:
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static boolean startsWithHTTP(String s)
    {
        int i = 0;
        while (Character.isWhitespace(s.charAt(i))) 
        {
            i++;
        }
        boolean flag;
        try
        {
            flag = "HTTP".equals(s.substring(i, i + 4));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return flag;
    }

    public final String getHttpVersion()
    {
        return httpVersion;
    }

    public final String getReasonPhrase()
    {
        return reasonPhrase;
    }

    public final int getStatusCode()
    {
        return statusCode;
    }

    public final String toString()
    {
        return statusLine;
    }
}
