// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.codec.DecodeMonitor;
import org.apache.james.mime4j.util.MimeUtil;

// Referenced classes of package org.apache.james.mime4j.stream:
//            BodyDescriptorBuilder, RawField, RawFieldParser, RawBody, 
//            NameValuePair, Field, BasicBodyDescriptor, BodyDescriptor

class FallbackBodyDescriptorBuilder
    implements BodyDescriptorBuilder
{

    private static final String DEFAULT_MEDIA_TYPE = "text";
    private static final String DEFAULT_MIME_TYPE = "text/plain";
    private static final String DEFAULT_SUB_TYPE = "plain";
    private static final String EMAIL_MESSAGE_MIME_TYPE = "message/rfc822";
    private static final String MEDIA_TYPE_MESSAGE = "message";
    private static final String MEDIA_TYPE_TEXT = "text";
    private static final String SUB_TYPE_EMAIL = "rfc822";
    private static final String US_ASCII = "us-ascii";
    private String boundary;
    private String charset;
    private long contentLength;
    private String mediaType;
    private String mimeType;
    private final DecodeMonitor monitor;
    private final String parentMimeType;
    private String subType;
    private String transferEncoding;

    public FallbackBodyDescriptorBuilder()
    {
        this(null, null);
    }

    public FallbackBodyDescriptorBuilder(String s, DecodeMonitor decodemonitor)
    {
        parentMimeType = s;
        if (decodemonitor == null)
        {
            decodemonitor = DecodeMonitor.SILENT;
        }
        monitor = decodemonitor;
        reset();
    }

    private void parseContentType(Field field)
        throws MimeException
    {
        String s2;
        HashMap hashmap;
        if (field instanceof RawField)
        {
            field = (RawField)field;
        } else
        {
            field = new RawField(field.getName(), field.getBody());
        }
        field = RawFieldParser.DEFAULT.parseRawBody(field);
        s2 = field.getValue();
        hashmap = new HashMap();
        NameValuePair namevaluepair;
        for (field = field.getParams().iterator(); field.hasNext(); hashmap.put(namevaluepair.getName().toLowerCase(Locale.US), namevaluepair.getValue()))
        {
            namevaluepair = (NameValuePair)field.next();
        }

        String s1 = null;
        Object obj = null;
        String s = null;
        Object obj1 = null;
        field = s2;
        if (s2 != null)
        {
            s2 = s2.toLowerCase().trim();
            int i = s2.indexOf('/');
            boolean flag1 = false;
            field = s2;
            s = obj1;
            s1 = obj;
            boolean flag = flag1;
            if (i != -1)
            {
                String s3 = s2.substring(0, i).trim();
                String s4 = s2.substring(i + 1).trim();
                field = s2;
                s = s4;
                s1 = s3;
                flag = flag1;
                if (s3.length() > 0)
                {
                    field = s2;
                    s = s4;
                    s1 = s3;
                    flag = flag1;
                    if (s4.length() > 0)
                    {
                        field = (new StringBuilder()).append(s3).append("/").append(s4).toString();
                        flag = true;
                        s1 = s3;
                        s = s4;
                    }
                }
            }
            if (!flag)
            {
                field = null;
                s1 = null;
                s = null;
            }
        }
        s2 = (String)hashmap.get("boundary");
        if (field != null && (field.startsWith("multipart/") && s2 != null || !field.startsWith("multipart/")))
        {
            mimeType = field;
            mediaType = s1;
            subType = s;
        }
        if (MimeUtil.isMultipart(mimeType))
        {
            boundary = s2;
        }
        field = (String)hashmap.get("charset");
        charset = null;
        if (field != null)
        {
            field = field.trim();
            if (field.length() > 0)
            {
                charset = field;
            }
        }
    }

    public Field addField(RawField rawfield)
        throws MimeException
    {
        Object obj = rawfield.getName().toLowerCase(Locale.US);
        if (!((String) (obj)).equals("content-transfer-encoding") || transferEncoding != null) goto _L2; else goto _L1
_L1:
        rawfield = rawfield.getBody();
        if (rawfield != null)
        {
            rawfield = rawfield.trim().toLowerCase(Locale.US);
            if (rawfield.length() > 0)
            {
                transferEncoding = rawfield;
            }
        }
_L4:
        return null;
_L2:
        if (((String) (obj)).equals("content-length") && contentLength == -1L)
        {
            rawfield = rawfield.getBody();
            if (rawfield != null)
            {
                rawfield = rawfield.trim();
                try
                {
                    contentLength = Long.parseLong(rawfield.trim());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    if (monitor.warn((new StringBuilder()).append("Invalid content length: ").append(rawfield).toString(), "ignoring Content-Length header"))
                    {
                        throw new MimeException((new StringBuilder()).append("Invalid Content-Length header: ").append(rawfield).toString());
                    }
                }
            }
        } else
        if (((String) (obj)).equals("content-type") && mimeType == null)
        {
            parseContentType(rawfield);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public BodyDescriptor build()
    {
        String s3 = mimeType;
        String s1 = mediaType;
        String s2 = subType;
        String s4 = charset;
        String s = s3;
        String s5;
        if (s3 == null)
        {
            if (MimeUtil.isSameMimeType("multipart/digest", parentMimeType))
            {
                s = "message/rfc822";
                s1 = "message";
                s2 = "rfc822";
            } else
            {
                s = "text/plain";
                s1 = "text";
                s2 = "plain";
            }
        }
        s3 = s4;
        if (s4 == null)
        {
            s3 = s4;
            if ("text".equals(s1))
            {
                s3 = "us-ascii";
            }
        }
        s5 = boundary;
        if (transferEncoding != null)
        {
            s4 = transferEncoding;
        } else
        {
            s4 = "7bit";
        }
        return new BasicBodyDescriptor(s, s1, s2, s5, s3, s4, contentLength);
    }

    public BodyDescriptorBuilder newChild()
    {
        return new FallbackBodyDescriptorBuilder(mimeType, monitor);
    }

    public void reset()
    {
        mimeType = null;
        subType = null;
        mediaType = null;
        boundary = null;
        charset = null;
        transferEncoding = null;
        contentLength = -1L;
    }
}
