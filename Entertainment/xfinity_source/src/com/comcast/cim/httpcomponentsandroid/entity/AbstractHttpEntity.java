// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.entity;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.message.BasicHeader;

public abstract class AbstractHttpEntity
    implements HttpEntity
{

    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    protected AbstractHttpEntity()
    {
    }

    public Header getContentEncoding()
    {
        return contentEncoding;
    }

    public Header getContentType()
    {
        return contentType;
    }

    public boolean isChunked()
    {
        return chunked;
    }

    public void setChunked(boolean flag)
    {
        chunked = flag;
    }

    public void setContentEncoding(Header header)
    {
        contentEncoding = header;
    }

    public void setContentEncoding(String s)
    {
        BasicHeader basicheader = null;
        if (s != null)
        {
            basicheader = new BasicHeader("Content-Encoding", s);
        }
        setContentEncoding(((Header) (basicheader)));
    }

    public void setContentType(Header header)
    {
        contentType = header;
    }

    public void setContentType(String s)
    {
        BasicHeader basicheader = null;
        if (s != null)
        {
            basicheader = new BasicHeader("Content-Type", s);
        }
        setContentType(((Header) (basicheader)));
    }
}
