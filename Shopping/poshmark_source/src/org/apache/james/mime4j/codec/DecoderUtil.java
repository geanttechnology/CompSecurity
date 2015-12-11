// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.james.mime4j.util.CharsetUtil;

// Referenced classes of package org.apache.james.mime4j.codec:
//            Base64InputStream, DecodeMonitor, QuotedPrintableInputStream

public class DecoderUtil
{

    private static final Pattern PATTERN_ENCODED_WORD = Pattern.compile("(.*?)=\\?([^\\?]+?)\\?(\\w)\\?([^\\?]+?)\\?=", 32);

    public DecoderUtil()
    {
    }

    static String decodeB(String s, String s1, DecodeMonitor decodemonitor)
        throws UnsupportedEncodingException
    {
        return new String(decodeBase64(s, decodemonitor), s1);
    }

    private static byte[] decodeBase64(String s, DecodeMonitor decodemonitor)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        s = new Base64InputStream(new ByteArrayInputStream(s.getBytes("US-ASCII")), decodemonitor);
_L1:
        int i = s.read();
        if (i != -1)
        {
            try
            {
                bytearrayoutputstream.write(i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new IllegalStateException(s);
            }
        } else
        {
            return bytearrayoutputstream.toByteArray();
        }
          goto _L1
    }

    static String decodeEncodedWords(String s)
    {
        return decodeEncodedWords(s, DecodeMonitor.SILENT);
    }

    public static String decodeEncodedWords(String s, DecodeMonitor decodemonitor)
        throws IllegalArgumentException
    {
        int i = 0;
        boolean flag = false;
        StringBuilder stringbuilder = new StringBuilder();
        for (Matcher matcher = PATTERN_ENCODED_WORD.matcher(s); matcher.find();)
        {
            String s1 = matcher.group(1);
            String s2 = tryDecodeEncodedWord(matcher.group(2), matcher.group(3), matcher.group(4), decodemonitor);
            if (s2 == null)
            {
                stringbuilder.append(matcher.group(0));
            } else
            {
                if (!flag || !CharsetUtil.isWhitespace(s1))
                {
                    stringbuilder.append(s1);
                }
                stringbuilder.append(s2);
            }
            i = matcher.end();
            if (s2 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        if (i == 0)
        {
            return s;
        } else
        {
            stringbuilder.append(s.substring(i));
            return stringbuilder.toString();
        }
    }

    static String decodeQ(String s, String s1, DecodeMonitor decodemonitor)
        throws UnsupportedEncodingException
    {
        return new String(decodeQuotedPrintable(replaceUnderscores(s), decodemonitor), s1);
    }

    private static byte[] decodeQuotedPrintable(String s, DecodeMonitor decodemonitor)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        s = new QuotedPrintableInputStream(new ByteArrayInputStream(s.getBytes("US-ASCII")), decodemonitor);
_L1:
        int i = s.read();
        if (i != -1)
        {
            try
            {
                bytearrayoutputstream.write(i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new IllegalStateException(s);
            }
        } else
        {
            return bytearrayoutputstream.toByteArray();
        }
          goto _L1
    }

    private static transient void monitor(DecodeMonitor decodemonitor, String s, String s1, String s2, String s3, String as[])
        throws IllegalArgumentException
    {
        if (decodemonitor.isListening())
        {
            s = recombine(s, s1, s2);
            s1 = new StringBuilder();
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                s1.append(as[i]);
            }

            s1.append(" (");
            s1.append(s);
            s1.append(")");
            if (decodemonitor.warn(s1.toString(), s3))
            {
                throw new IllegalArgumentException(s1.toString());
            }
        }
    }

    private static String recombine(String s, String s1, String s2)
    {
        return (new StringBuilder()).append("=?").append(s).append("?").append(s1).append("?").append(s2).append("?=").toString();
    }

    private static String replaceUnderscores(String s)
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        int i = 0;
        while (i < s.length()) 
        {
            char c = s.charAt(i);
            if (c == '_')
            {
                stringbuilder.append("=20");
            } else
            {
                stringbuilder.append(c);
            }
            i++;
        }
        return stringbuilder.toString();
    }

    private static String tryDecodeEncodedWord(String s, String s1, String s2, DecodeMonitor decodemonitor)
    {
        Charset charset = CharsetUtil.lookup(s);
        if (charset == null)
        {
            monitor(decodemonitor, s, s1, s2, "leaving word encoded", new String[] {
                "Mime charser '", s, "' doesn't have a corresponding Java charset"
            });
            return null;
        }
        if (s2.length() == 0)
        {
            monitor(decodemonitor, s, s1, s2, "leaving word encoded", new String[] {
                "Missing encoded text in encoded word"
            });
            return null;
        }
        try
        {
            if (s1.equalsIgnoreCase("Q"))
            {
                return decodeQ(s2, charset.name(), decodemonitor);
            }
            if (s1.equalsIgnoreCase("B"))
            {
                return decodeB(s2, charset.name(), decodemonitor);
            }
            monitor(decodemonitor, s, s1, s2, "leaving word encoded", new String[] {
                "Warning: Unknown encoding in encoded word"
            });
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            monitor(decodemonitor, s, s1, s2, "leaving word encoded", new String[] {
                "Unsupported encoding (", unsupportedencodingexception.getMessage(), ") in encoded word"
            });
            return null;
        }
        catch (RuntimeException runtimeexception)
        {
            monitor(decodemonitor, s, s1, s2, "leaving word encoded", new String[] {
                "Could not decode (", runtimeexception.getMessage(), ") encoded word"
            });
            return null;
        }
        return null;
    }

}
