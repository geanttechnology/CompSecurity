// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods.multipart;


// Referenced classes of package org.apache.commons.httpclient.methods.multipart:
//            Part

public abstract class PartBase extends Part
{

    private String charSet;
    private String contentType;
    private String name;
    private String transferEncoding;

    public PartBase(String s, String s1, String s2, String s3)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name must not be null");
        } else
        {
            name = s;
            contentType = s1;
            charSet = s2;
            transferEncoding = s3;
            return;
        }
    }

    public String getCharSet()
    {
        return charSet;
    }

    public String getContentType()
    {
        return contentType;
    }

    public String getName()
    {
        return name;
    }

    public String getTransferEncoding()
    {
        return transferEncoding;
    }

    public void setCharSet(String s)
    {
        charSet = s;
    }

    public void setContentType(String s)
    {
        contentType = s;
    }

    public void setName(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name must not be null");
        } else
        {
            name = s;
            return;
        }
    }

    public void setTransferEncoding(String s)
    {
        transferEncoding = s;
    }
}
