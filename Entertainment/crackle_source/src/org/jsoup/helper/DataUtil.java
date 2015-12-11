// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.helper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

// Referenced classes of package org.jsoup.helper:
//            Validate

public class DataUtil
{

    private static final int bufferSize = 0x20000;
    private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*\"?([^\\s;\"]*)");
    static final String defaultCharset = "UTF-8";

    private DataUtil()
    {
    }

    static String getCharsetFromContentType(String s)
    {
        if (s != null)
        {
            if ((s = charsetPattern.matcher(s)).find())
            {
                return s.group(1).trim().toUpperCase();
            }
        }
        return null;
    }

    public static Document load(File file, String s, String s1)
        throws IOException
    {
        Object obj = null;
        file = new FileInputStream(file);
        s = parseByteData(readToByteBuffer(file), s, s1, Parser.htmlParser());
        if (file != null)
        {
            file.close();
        }
        return s;
        s;
        file = obj;
_L2:
        if (file != null)
        {
            file.close();
        }
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Document load(InputStream inputstream, String s, String s1)
        throws IOException
    {
        return parseByteData(readToByteBuffer(inputstream), s, s1, Parser.htmlParser());
    }

    public static Document load(InputStream inputstream, String s, String s1, Parser parser)
        throws IOException
    {
        return parseByteData(readToByteBuffer(inputstream), s, s1, parser);
    }

    static Document parseByteData(ByteBuffer bytebuffer, String s, String s1, Parser parser)
    {
        Document document = null;
        String s2;
        Object obj1;
        if (s == null)
        {
            String s3 = Charset.forName("UTF-8").decode(bytebuffer).toString();
            Document document1 = parser.parseInput(s3, s1);
            Object obj = document1.select("meta[http-equiv=content-type], meta[charset]").first();
            document = document1;
            s2 = s3;
            obj1 = s;
            if (obj != null)
            {
                if (((Element) (obj)).hasAttr("http-equiv"))
                {
                    obj = getCharsetFromContentType(((Element) (obj)).attr("content"));
                } else
                {
                    obj = ((Element) (obj)).attr("charset");
                }
                document = document1;
                s2 = s3;
                obj1 = s;
                if (obj != null)
                {
                    document = document1;
                    s2 = s3;
                    obj1 = s;
                    if (((String) (obj)).length() != 0)
                    {
                        document = document1;
                        s2 = s3;
                        obj1 = s;
                        if (!((String) (obj)).equals("UTF-8"))
                        {
                            obj1 = obj;
                            bytebuffer.rewind();
                            s2 = Charset.forName(((String) (obj))).decode(bytebuffer).toString();
                            document = null;
                        }
                    }
                }
            }
        } else
        {
            Validate.notEmpty(s, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
            s2 = Charset.forName(s).decode(bytebuffer).toString();
            obj1 = s;
        }
        bytebuffer = document;
        if (document == null)
        {
            bytebuffer = s2;
            if (s2.charAt(0) == '\uFEFF')
            {
                bytebuffer = s2.substring(1);
            }
            bytebuffer = parser.parseInput(bytebuffer, s1);
            bytebuffer.outputSettings().charset(((String) (obj1)));
        }
        return bytebuffer;
    }

    static ByteBuffer readToByteBuffer(InputStream inputstream)
        throws IOException
    {
        byte abyte0[] = new byte[0x20000];
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(0x20000);
        do
        {
            int i = inputstream.read(abyte0);
            if (i == -1)
            {
                return ByteBuffer.wrap(bytearrayoutputstream.toByteArray());
            }
            bytearrayoutputstream.write(abyte0, 0, i);
        } while (true);
    }

}
