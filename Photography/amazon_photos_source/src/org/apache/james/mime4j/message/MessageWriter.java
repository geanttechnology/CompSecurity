// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.message;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.james.mime4j.codec.CodecUtil;
import org.apache.james.mime4j.field.ContentTypeField;
import org.apache.james.mime4j.parser.Field;
import org.apache.james.mime4j.util.ByteArrayBuffer;
import org.apache.james.mime4j.util.ByteSequence;
import org.apache.james.mime4j.util.ContentUtil;
import org.apache.james.mime4j.util.MimeUtil;

// Referenced classes of package org.apache.james.mime4j.message:
//            Multipart, Entity, Header, Message, 
//            SingleBody, BinaryBody, BodyPart, Body

public class MessageWriter
{

    private static final byte CRLF[] = {
        13, 10
    };
    private static final byte DASHES[] = {
        45, 45
    };
    public static final MessageWriter DEFAULT = new MessageWriter();

    protected MessageWriter()
    {
    }

    private ByteSequence getBoundary(ContentTypeField contenttypefield)
    {
        contenttypefield = contenttypefield.getBoundary();
        if (contenttypefield == null)
        {
            throw new IllegalArgumentException("Multipart boundary not specified");
        } else
        {
            return ContentUtil.encode(contenttypefield);
        }
    }

    private ContentTypeField getContentType(Multipart multipart)
    {
        multipart = multipart.getParent();
        if (multipart == null)
        {
            throw new IllegalArgumentException("Missing parent entity in multipart");
        }
        multipart = multipart.getHeader();
        if (multipart == null)
        {
            throw new IllegalArgumentException("Missing header in parent entity");
        }
        multipart = (ContentTypeField)multipart.getField("Content-Type");
        if (multipart == null)
        {
            throw new IllegalArgumentException("Content-Type field not specified");
        } else
        {
            return multipart;
        }
    }

    private void writeBytes(ByteSequence bytesequence, OutputStream outputstream)
        throws IOException
    {
        if (bytesequence instanceof ByteArrayBuffer)
        {
            bytesequence = (ByteArrayBuffer)bytesequence;
            outputstream.write(bytesequence.buffer(), 0, bytesequence.length());
            return;
        } else
        {
            outputstream.write(bytesequence.toByteArray());
            return;
        }
    }

    protected OutputStream encodeStream(OutputStream outputstream, String s, boolean flag)
        throws IOException
    {
        OutputStream outputstream1;
        if (MimeUtil.isBase64Encoding(s))
        {
            outputstream1 = CodecUtil.wrapBase64(outputstream);
        } else
        {
            outputstream1 = outputstream;
            if (MimeUtil.isQuotedPrintableEncoded(s))
            {
                return CodecUtil.wrapQuotedPrintable(outputstream, flag);
            }
        }
        return outputstream1;
    }

    public void writeBody(Body body, OutputStream outputstream)
        throws IOException
    {
        if (body instanceof Message)
        {
            writeEntity((Message)body, outputstream);
            return;
        }
        if (body instanceof Multipart)
        {
            writeMultipart((Multipart)body, outputstream);
            return;
        }
        if (body instanceof SingleBody)
        {
            ((SingleBody)body).writeTo(outputstream);
            return;
        } else
        {
            throw new IllegalArgumentException("Unsupported body class");
        }
    }

    public void writeEntity(Entity entity, OutputStream outputstream)
        throws IOException
    {
        Object obj = entity.getHeader();
        if (obj == null)
        {
            throw new IllegalArgumentException("Missing header");
        }
        writeHeader(((Header) (obj)), outputstream);
        obj = entity.getBody();
        if (obj == null)
        {
            throw new IllegalArgumentException("Missing body");
        }
        boolean flag = obj instanceof BinaryBody;
        entity = encodeStream(outputstream, entity.getContentTransferEncoding(), flag);
        writeBody(((Body) (obj)), entity);
        if (entity != outputstream)
        {
            entity.close();
        }
    }

    public void writeHeader(Header header, OutputStream outputstream)
        throws IOException
    {
        for (header = header.iterator(); header.hasNext(); outputstream.write(CRLF))
        {
            writeBytes(((Field)header.next()).getRaw(), outputstream);
        }

        outputstream.write(CRLF);
    }

    public void writeMultipart(Multipart multipart, OutputStream outputstream)
        throws IOException
    {
        ByteSequence bytesequence = getBoundary(getContentType(multipart));
        writeBytes(multipart.getPreambleRaw(), outputstream);
        outputstream.write(CRLF);
        for (Iterator iterator = multipart.getBodyParts().iterator(); iterator.hasNext(); outputstream.write(CRLF))
        {
            BodyPart bodypart = (BodyPart)iterator.next();
            outputstream.write(DASHES);
            writeBytes(bytesequence, outputstream);
            outputstream.write(CRLF);
            writeEntity(bodypart, outputstream);
        }

        outputstream.write(DASHES);
        writeBytes(bytesequence, outputstream);
        outputstream.write(DASHES);
        outputstream.write(CRLF);
        writeBytes(multipart.getEpilogueRaw(), outputstream);
    }

}
