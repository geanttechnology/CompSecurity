// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;


// Referenced classes of package org.apache.commons.httpclient:
//            URI

public static class reasonCode extends RuntimeException
{

    public static final int DOCUMENT_CHARSET = 2;
    public static final int PROTOCOL_CHARSET = 1;
    public static final int UNKNOWN = 0;
    private String reason;
    private int reasonCode;

    public String getReason()
    {
        return reason;
    }

    public int getReasonCode()
    {
        return reasonCode;
    }

    public (int i, String s)
    {
        super(s);
        reason = s;
        reasonCode = i;
    }
}
