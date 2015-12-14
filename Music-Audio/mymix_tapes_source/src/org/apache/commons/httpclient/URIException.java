// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;


// Referenced classes of package org.apache.commons.httpclient:
//            HttpException

public class URIException extends HttpException
{

    public static final int ESCAPING = 3;
    public static final int PARSING = 1;
    public static final int PUNYCODE = 4;
    public static final int UNKNOWN = 0;
    public static final int UNSUPPORTED_ENCODING = 2;
    protected String reason;
    protected int reasonCode;

    public URIException()
    {
    }

    public URIException(int i)
    {
        reasonCode = i;
    }

    public URIException(int i, String s)
    {
        super(s);
        reason = s;
        reasonCode = i;
    }

    public URIException(String s)
    {
        super(s);
        reason = s;
        reasonCode = 0;
    }

    public String getReason()
    {
        return reason;
    }

    public int getReasonCode()
    {
        return reasonCode;
    }

    public void setReason(String s)
    {
        reason = s;
    }

    public void setReasonCode(int i)
    {
        reasonCode = i;
    }
}
