// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.entity.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.james.mime4j.field.ContentTypeField;
import org.apache.james.mime4j.message.BodyPart;
import org.apache.james.mime4j.message.Entity;
import org.apache.james.mime4j.message.Header;
import org.apache.james.mime4j.message.MessageWriter;
import org.apache.james.mime4j.message.Multipart;
import org.apache.james.mime4j.parser.Field;
import org.apache.james.mime4j.util.ByteArrayBuffer;
import org.apache.james.mime4j.util.ByteSequence;
import org.apache.james.mime4j.util.CharsetUtil;

// Referenced classes of package org.apache.http.entity.mime:
//            MIME, HttpMultipartMode

public class HttpMultipart extends Multipart
{

    private static final ByteArrayBuffer CR_LF;
    private static final ByteArrayBuffer TWO_DASHES;
    private HttpMultipartMode mode;

    public HttpMultipart(String s)
    {
        super(s);
        mode = HttpMultipartMode.STRICT;
    }

    private void doWriteTo(HttpMultipartMode httpmultipartmode, OutputStream outputstream, boolean flag)
        throws IOException
    {
        Charset charset;
        List list;
        ByteArrayBuffer bytearraybuffer;
        list = getBodyParts();
        charset = getCharset();
        bytearraybuffer = encode(charset, getBoundary());
        static class _cls1
        {

            static final int $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[];

            static 
            {
                $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode = new int[HttpMultipartMode.values().length];
                try
                {
                    $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[HttpMultipartMode.STRICT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.org.apache.http.entity.mime.HttpMultipartMode[httpmultipartmode.ordinal()];
        JVM INSTR tableswitch 1 2: default 52
    //                   1 53
    //                   2 286;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        httpmultipartmode = getPreamble();
        if (httpmultipartmode != null && httpmultipartmode.length() != 0)
        {
            writeBytes(encode(charset, httpmultipartmode), outputstream);
            writeBytes(CR_LF, outputstream);
        }
        for (int i = 0; i < list.size(); i++)
        {
            writeBytes(TWO_DASHES, outputstream);
            writeBytes(bytearraybuffer, outputstream);
            writeBytes(CR_LF, outputstream);
            httpmultipartmode = (BodyPart)list.get(i);
            for (Iterator iterator = httpmultipartmode.getHeader().getFields().iterator(); iterator.hasNext(); writeBytes(CR_LF, outputstream))
            {
                writeBytes(((Field)iterator.next()).getRaw(), outputstream);
            }

            writeBytes(CR_LF, outputstream);
            if (flag)
            {
                MessageWriter.DEFAULT.writeBody(httpmultipartmode.getBody(), outputstream);
            }
            writeBytes(CR_LF, outputstream);
        }

        writeBytes(TWO_DASHES, outputstream);
        writeBytes(bytearraybuffer, outputstream);
        writeBytes(TWO_DASHES, outputstream);
        writeBytes(CR_LF, outputstream);
        httpmultipartmode = getEpilogue();
        if (httpmultipartmode != null && httpmultipartmode.length() != 0)
        {
            writeBytes(encode(charset, httpmultipartmode), outputstream);
            writeBytes(CR_LF, outputstream);
            return;
        }
          goto _L1
_L3:
        for (int j = 0; j < list.size(); j++)
        {
            writeBytes(TWO_DASHES, outputstream);
            writeBytes(bytearraybuffer, outputstream);
            writeBytes(CR_LF, outputstream);
            httpmultipartmode = (BodyPart)list.get(j);
            Field field = httpmultipartmode.getHeader().getField("Content-Disposition");
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(field.getName());
            stringbuilder.append(": ");
            stringbuilder.append(field.getBody());
            writeBytes(encode(charset, stringbuilder.toString()), outputstream);
            writeBytes(CR_LF, outputstream);
            writeBytes(CR_LF, outputstream);
            if (flag)
            {
                MessageWriter.DEFAULT.writeBody(httpmultipartmode.getBody(), outputstream);
            }
            writeBytes(CR_LF, outputstream);
        }

        writeBytes(TWO_DASHES, outputstream);
        writeBytes(bytearraybuffer, outputstream);
        writeBytes(TWO_DASHES, outputstream);
        writeBytes(CR_LF, outputstream);
        return;
    }

    private static ByteArrayBuffer encode(Charset charset, String s)
    {
        charset = charset.encode(CharBuffer.wrap(s));
        s = new ByteArrayBuffer(charset.remaining());
        s.append(charset.array(), charset.position(), charset.remaining());
        return s;
    }

    private static void writeBytes(ByteArrayBuffer bytearraybuffer, OutputStream outputstream)
        throws IOException
    {
        outputstream.write(bytearraybuffer.buffer(), 0, bytearraybuffer.length());
    }

    private static void writeBytes(ByteSequence bytesequence, OutputStream outputstream)
        throws IOException
    {
        if (bytesequence instanceof ByteArrayBuffer)
        {
            writeBytes((ByteArrayBuffer)bytesequence, outputstream);
            return;
        } else
        {
            outputstream.write(bytesequence.toByteArray());
            return;
        }
    }

    protected String getBoundary()
    {
        return ((ContentTypeField)getParent().getHeader().getField("Content-Type")).getBoundary();
    }

    protected Charset getCharset()
    {
        ContentTypeField contenttypefield = (ContentTypeField)getParent().getHeader().getField("Content-Type");
        switch (_cls1..SwitchMap.org.apache.http.entity.mime.HttpMultipartMode[mode.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return MIME.DEFAULT_CHARSET;

        case 2: // '\002'
            break;
        }
        if (contenttypefield.getCharset() != null)
        {
            return CharsetUtil.getCharset(contenttypefield.getCharset());
        } else
        {
            return CharsetUtil.getCharset("ISO-8859-1");
        }
    }

    public long getTotalLength()
    {
        Object obj = getBodyParts();
        long l = 0L;
        for (int i = 0; i < ((List) (obj)).size();)
        {
            org.apache.james.mime4j.message.Body body = ((BodyPart)((List) (obj)).get(i)).getBody();
            if (body instanceof ContentBody)
            {
                long l1 = ((ContentBody)body).getContentLength();
                if (l1 >= 0L)
                {
                    l += l1;
                    i++;
                } else
                {
                    return -1L;
                }
            } else
            {
                return -1L;
            }
        }

        obj = new ByteArrayOutputStream();
        int j;
        try
        {
            doWriteTo(mode, ((OutputStream) (obj)), false);
            j = ((ByteArrayOutputStream) (obj)).toByteArray().length;
        }
        catch (IOException ioexception)
        {
            return -1L;
        }
        return (long)j + l;
    }

    public void setMode(HttpMultipartMode httpmultipartmode)
    {
        mode = httpmultipartmode;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        doWriteTo(mode, outputstream, true);
    }

    static 
    {
        CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
        TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
    }
}
