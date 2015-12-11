// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.io.IOException;
import java.net.ProtocolException;

public final class StatusLine
{

    private final int httpMinorVersion;
    private final int responseCode;
    private final String responseMessage;
    private final String statusLine;

    public StatusLine(String s)
        throws IOException
    {
        int i;
        byte byte0;
label0:
        {
label1:
            {
label2:
                {
                    super();
                    if (s.startsWith("HTTP/1."))
                    {
                        if (s.length() < 9 || s.charAt(8) != ' ')
                        {
                            throw new ProtocolException((new StringBuilder()).append("Unexpected status line: ").append(s).toString());
                        }
                        int j = s.charAt(7) - 48;
                        byte0 = 9;
                        if (j >= 0)
                        {
                            i = j;
                            if (j <= 9)
                            {
                                break label2;
                            }
                        }
                        throw new ProtocolException((new StringBuilder()).append("Unexpected status line: ").append(s).toString());
                    }
                    if (!s.startsWith("ICY "))
                    {
                        break label1;
                    }
                    i = 0;
                    byte0 = 4;
                }
                if (s.length() < byte0 + 3)
                {
                    throw new ProtocolException((new StringBuilder()).append("Unexpected status line: ").append(s).toString());
                }
                break label0;
            }
            throw new ProtocolException((new StringBuilder()).append("Unexpected status line: ").append(s).toString());
        }
        Object obj;
        int k;
        try
        {
            k = Integer.parseInt(s.substring(byte0, byte0 + 3));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ProtocolException((new StringBuilder()).append("Unexpected status line: ").append(s).toString());
        }
        obj = "";
        if (s.length() > byte0 + 3)
        {
            if (s.charAt(byte0 + 3) != ' ')
            {
                throw new ProtocolException((new StringBuilder()).append("Unexpected status line: ").append(s).toString());
            }
            obj = s.substring(byte0 + 4);
        }
        responseMessage = ((String) (obj));
        responseCode = k;
        statusLine = s;
        httpMinorVersion = i;
    }

    public int code()
    {
        return responseCode;
    }

    public String getStatusLine()
    {
        return statusLine;
    }

    public int httpMinorVersion()
    {
        if (httpMinorVersion != -1)
        {
            return httpMinorVersion;
        } else
        {
            return 1;
        }
    }

    public String message()
    {
        return responseMessage;
    }
}
