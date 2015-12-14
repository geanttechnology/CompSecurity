// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.io.InputStream;

// Referenced classes of package com.amazon.device.ads.identity:
//            WebRequest, ResponseReader

public class this._cls0
{

    private String httpStatus;
    private int httpStatusCode;
    private putStream inputStream;
    final WebRequest this$0;

    public String getHttpStatus()
    {
        return httpStatus;
    }

    public int getHttpStatusCode()
    {
        return httpStatusCode;
    }

    public ResponseReader getResponseReader()
    {
        ResponseReader responsereader = new ResponseReader(inputStream);
        responsereader.enableLog(logResponseEnabled);
        responsereader.setExternalLogTag(getLogTag());
        return responsereader;
    }

    public boolean isHttpStatusCodeOK()
    {
        return getHttpStatusCode() == 200;
    }

    protected void setHttpStatus(String s)
    {
        httpStatus = s;
    }

    protected void setHttpStatusCode(int i)
    {
        httpStatusCode = i;
    }

    protected void setInputStream(InputStream inputstream)
    {
        inputStream = new putStream(WebRequest.this, inputstream);
    }

    protected putStream()
    {
        this$0 = WebRequest.this;
        super();
    }
}
