// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;


// Referenced classes of package org.apache.james.mime4j.stream:
//            BodyDescriptor

class BasicBodyDescriptor
    implements BodyDescriptor
{

    private final String boundary;
    private final String charset;
    private final long contentLength;
    private final String mediaType;
    private final String mimeType;
    private final String subType;
    private final String transferEncoding;

    BasicBodyDescriptor(String s, String s1, String s2, String s3, String s4, String s5, long l)
    {
        mimeType = s;
        mediaType = s1;
        subType = s2;
        boundary = s3;
        charset = s4;
        transferEncoding = s5;
        contentLength = l;
    }

    public String getBoundary()
    {
        return boundary;
    }

    public String getCharset()
    {
        return charset;
    }

    public long getContentLength()
    {
        return contentLength;
    }

    public String getMediaType()
    {
        return mediaType;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public String getSubType()
    {
        return subType;
    }

    public String getTransferEncoding()
    {
        return transferEncoding;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[mimeType=");
        stringbuilder.append(mimeType);
        stringbuilder.append(", mediaType=");
        stringbuilder.append(mediaType);
        stringbuilder.append(", subType=");
        stringbuilder.append(subType);
        stringbuilder.append(", boundary=");
        stringbuilder.append(boundary);
        stringbuilder.append(", charset=");
        stringbuilder.append(charset);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
