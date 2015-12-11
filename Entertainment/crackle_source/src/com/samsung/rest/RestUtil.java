// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestUtil
{

    private static int CONNECTED_PORT = 0;
    private static final String DEVICE_ID_KEY = "DEVICE_ID";
    private static final String IP_ADDRESS_KEY = "IP_ADDRESS";
    private static final String PORT_KEY = "PORT";
    private static final String WIDGET_ID_KEY = "WIDGET_ID";

    public RestUtil()
    {
    }

    public static void changePort(int i)
    {
        CONNECTED_PORT = i;
    }

    private static CharBuffer decodeHelper(byte abyte0[], int i, Charset charset)
        throws IOException
    {
        charset = charset.newDecoder();
        try
        {
            abyte0 = charset.decode(ByteBuffer.wrap(abyte0, 0, i));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        return abyte0;
    }

    public static String getCharsetFromContentType(String s)
    {
        s = Pattern.compile("^.+charset=([^;]+).*$").matcher(s);
        if (s.matches())
        {
            return s.group(1).trim();
        } else
        {
            return null;
        }
    }

    public static int getStatusCodeFromStatusLine(String s)
    {
        int i = -1;
        s = Pattern.compile("[^\\s]+\\s([0-9]{3})\\s.*").matcher(s);
        if (s.matches())
        {
            i = Integer.parseInt(s.group(1));
        }
        return i;
    }

    public static byte[] inputStream2Bytes(InputStream inputstream)
        throws IOException
    {
        byte abyte0[];
        byte abyte1[];
        abyte0 = new ByteArrayOutputStream();
        abyte1 = new byte[8192];
_L1:
        int i = inputstream.read(abyte1);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        abyte0 = abyte0.toByteArray();
        inputstream.close();
        return abyte0;
        abyte0.write(abyte1, 0, i);
          goto _L1
        Exception exception;
        exception;
        inputstream.close();
        throw exception;
    }

    public static String inputStream2String(InputStream inputstream, Charset charset)
        throws IOException
    {
        Object obj;
        Object obj1;
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        obj1 = new byte[4096];
        obj = new byte[1];
        int i = 0;
        CharsetDecoder charsetdecoder = charset.newDecoder();
_L5:
        int l = inputstream.read(((byte []) (obj1)));
        if (l != -1)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        charsetdecoder.decode(ByteBuffer.wrap(((byte []) (obj)), 0, obj.length));
        charset = stringbuilder.toString();
        if (inputstream != null)
        {
            inputstream.close();
        }
        return charset;
        byte abyte0[];
        int j;
        int k;
        abyte0 = ((byte []) (obj1));
        j = i;
        k = l;
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        abyte0 = new byte[obj.length + obj1.length];
        System.arraycopy(obj, 0, abyte0, 0, obj.length);
        System.arraycopy(obj1, 0, abyte0, obj.length, obj1.length);
        j = 0;
        k = l + obj.length;
        CharBuffer charbuffer = decodeHelper(abyte0, k, charset);
        obj1 = charbuffer;
        i = j;
        if (charbuffer != null) goto _L2; else goto _L1
_L1:
        i = 0;
        obj = charbuffer;
_L7:
        if (obj == null) goto _L4; else goto _L3
_L3:
        byte abyte1[] = new byte[i];
        l = 1;
        j = 0;
        break MISSING_BLOCK_LABEL_346;
_L2:
        ((CharBuffer) (obj1)).rewind();
        stringbuilder.append(((CharBuffer) (obj1)).toString());
        obj1 = abyte0;
          goto _L5
        charset;
        if (inputstream != null)
        {
            inputstream.close();
        }
        throw charset;
_L4:
        j = i + 1;
        obj1 = decodeHelper(abyte0, k - j, charset);
        obj = obj1;
        i = j;
        if (j <= 10) goto _L7; else goto _L6
_L6:
        obj = obj1;
        i = j;
        if (j >= k) goto _L7; else goto _L8
_L8:
        obj = charsetdecoder.decode(ByteBuffer.wrap(abyte0, 0, k));
        i = j;
          goto _L7
        obj;
        throw new IOException((new StringBuilder("File not in supported encoding (")).append(charset.displayName()).append(")").toString());
        obj;
        throw new IOException((new StringBuilder("File not in supported encoding (")).append(charset.displayName()).append(")").toString());
_L9:
label0:
        {
            if (j < i)
            {
                break label0;
            }
            obj1 = obj;
            i = l;
            obj = abyte1;
        }
          goto _L2
        abyte1[j] = abyte0[(k - i) + j];
        j++;
          goto _L9
    }

    public static String prepareConnectionUrl(String s, URL url, String s1)
    {
        return s.replaceAll("WIDGET_ID", s1).replaceAll("IP_ADDRESS", url.getHost()).replaceAll("PORT", (new StringBuilder()).append(CONNECTED_PORT).toString());
    }

    public static String prepareGetUrl(String s, URL url, String s1, String s2)
    {
        return s.replaceAll("DEVICE_ID", s2).replaceAll("WIDGET_ID", s1).replaceAll("IP_ADDRESS", url.getHost()).replaceAll("PORT", (new StringBuilder()).append(CONNECTED_PORT).toString());
    }

    public static String preparePostUrl(String s, URL url, String s1)
    {
        return s.replaceAll("WIDGET_ID", s1).replaceAll("IP_ADDRESS", url.getHost()).replaceAll("PORT", (new StringBuilder()).append(CONNECTED_PORT).toString());
    }

    public static byte[] toArray(ArrayList arraylist)
    {
        byte abyte0[] = new byte[arraylist.size()];
        int i = 0;
        do
        {
            if (i >= arraylist.size())
            {
                return abyte0;
            }
            abyte0[i] = ((Byte)arraylist.get(i)).byteValue();
            i++;
        } while (true);
    }

    public static ArrayList toArrayList(byte abyte0[])
    {
        ArrayList arraylist = new ArrayList();
        int j = abyte0.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return arraylist;
            }
            arraylist.add(Byte.valueOf(abyte0[i]));
            i++;
        } while (true);
    }

    static 
    {
        CONNECTED_PORT = 80;
    }
}
