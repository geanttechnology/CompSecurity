// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.http;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.net.MediaType;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public abstract class Part
{

    private static final String CONTENT_DISPOSITION_FORM_DATA = "Content-Disposition: form-data; name=\"";
    private static final String CONTENT_TYPE = "Content-Type: ";
    private static final String NEW_LINE = "\r\n";
    private static final char QUOTE = 34;
    private final MediaType mContentType;
    private final String mName;

    public Part(String s, MediaType mediatype)
    {
        Preconditions.checkNotNull(s, "Part name cannot be null");
        Preconditions.checkNotNull(mediatype, "Part Content-Type cannot be null");
        mName = s;
        mContentType = mediatype;
    }

    private void writeFooter(OutputStream outputstream)
        throws IOException
    {
        outputstream.write("\r\n".getBytes(Charsets.UTF_8.displayName()));
    }

    private void writeHeaders(OutputStream outputstream)
        throws IOException
    {
        outputstream.write((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(mName).append('"').append("\r\n").append("Content-Type: ").append(mContentType.toString()).append("\r\n").append("\r\n").toString().getBytes(Charsets.UTF_8.displayName()));
    }

    protected abstract void writeBody(OutputStream outputstream)
        throws Exception;

    public void writePart(OutputStream outputstream)
        throws Exception
    {
        writeHeaders(outputstream);
        writeBody(outputstream);
        writeFooter(outputstream);
    }
}
