// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.text.TextUtils;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.loopj.android.http:
//            Base64OutputStream, ResponseHandlerInterface, AsyncHttpClient, JsonValueInterface, 
//            LogInterface

public class JsonStreamerEntity
    implements HttpEntity
{

    private static final int BUFFER_SIZE = 4096;
    private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", "gzip");
    private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
    private static final byte JSON_FALSE[] = "false".getBytes();
    private static final byte JSON_NULL[] = "null".getBytes();
    private static final byte JSON_TRUE[] = "true".getBytes();
    private static final String LOG_TAG = "JsonStreamerEntity";
    private static final byte STREAM_CONTENTS[] = escape("contents");
    private static final byte STREAM_NAME[] = escape("name");
    private static final byte STREAM_TYPE[] = escape("type");
    private final byte buffer[] = new byte[4096];
    private final Header contentEncoding;
    private final byte elapsedField[];
    private final Map jsonParams = new HashMap();
    private final ResponseHandlerInterface progressHandler;

    public JsonStreamerEntity(ResponseHandlerInterface responsehandlerinterface, boolean flag, String s)
    {
        Object obj = null;
        super();
        progressHandler = responsehandlerinterface;
        if (flag)
        {
            responsehandlerinterface = HEADER_GZIP_ENCODING;
        } else
        {
            responsehandlerinterface = null;
        }
        contentEncoding = responsehandlerinterface;
        if (TextUtils.isEmpty(s))
        {
            responsehandlerinterface = obj;
        } else
        {
            responsehandlerinterface = escape(s);
        }
        elapsedField = responsehandlerinterface;
    }

    private void endMetaData(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(34);
    }

    static byte[] escape(String s)
    {
        if (s == null)
        {
            return JSON_NULL;
        }
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append('"');
        int k = s.length();
        int i = -1;
label0:
        do
        {
            char c;
            int j;
label1:
            {
                j = i + 1;
                if (j >= k)
                {
                    break label0;
                }
                c = s.charAt(j);
                String s1;
                switch (c)
                {
                default:
                    if (c <= '\037' || c >= '\177' && c <= '\237' || c >= '\u2000' && c <= '\u20FF')
                    {
                        s1 = Integer.toHexString(c);
                        stringbuilder.append("\\u");
                        int l = s1.length();
                        for (i = 0; i < 4 - l; i++)
                        {
                            stringbuilder.append('0');
                        }

                        break;
                    }
                    break label1;

                case 34: // '"'
                    stringbuilder.append("\\\"");
                    i = j;
                    continue;

                case 92: // '\\'
                    stringbuilder.append("\\\\");
                    i = j;
                    continue;

                case 8: // '\b'
                    stringbuilder.append("\\b");
                    i = j;
                    continue;

                case 12: // '\f'
                    stringbuilder.append("\\f");
                    i = j;
                    continue;

                case 10: // '\n'
                    stringbuilder.append("\\n");
                    i = j;
                    continue;

                case 13: // '\r'
                    stringbuilder.append("\\r");
                    i = j;
                    continue;

                case 9: // '\t'
                    stringbuilder.append("\\t");
                    i = j;
                    continue;
                }
                stringbuilder.append(s1.toUpperCase(Locale.US));
                i = j;
                continue;
            }
            stringbuilder.append(c);
            i = j;
        } while (true);
        stringbuilder.append('"');
        return stringbuilder.toString().getBytes();
    }

    private void writeMetaData(OutputStream outputstream, String s, String s1)
        throws IOException
    {
        outputstream.write(STREAM_NAME);
        outputstream.write(58);
        outputstream.write(escape(s));
        outputstream.write(44);
        outputstream.write(STREAM_TYPE);
        outputstream.write(58);
        outputstream.write(escape(s1));
        outputstream.write(44);
        outputstream.write(STREAM_CONTENTS);
        outputstream.write(58);
        outputstream.write(34);
    }

    private void writeToFromFile(OutputStream outputstream, RequestParams.FileWrapper filewrapper)
        throws IOException
    {
        writeMetaData(outputstream, filewrapper.file.getName(), filewrapper.contentType);
        long l = 0L;
        long l1 = filewrapper.file.length();
        filewrapper = new FileInputStream(filewrapper.file);
        Base64OutputStream base64outputstream = new Base64OutputStream(outputstream, 18);
        do
        {
            int i = filewrapper.read(buffer);
            if (i != -1)
            {
                base64outputstream.write(buffer, 0, i);
                l += i;
                progressHandler.sendProgressMessage(l, l1);
            } else
            {
                AsyncHttpClient.silentCloseOutputStream(base64outputstream);
                endMetaData(outputstream);
                AsyncHttpClient.silentCloseInputStream(filewrapper);
                return;
            }
        } while (true);
    }

    private void writeToFromStream(OutputStream outputstream, RequestParams.StreamWrapper streamwrapper)
        throws IOException
    {
        writeMetaData(outputstream, streamwrapper.name, streamwrapper.contentType);
        Base64OutputStream base64outputstream = new Base64OutputStream(outputstream, 18);
        do
        {
            int i = streamwrapper.inputStream.read(buffer);
            if (i == -1)
            {
                break;
            }
            base64outputstream.write(buffer, 0, i);
        } while (true);
        AsyncHttpClient.silentCloseOutputStream(base64outputstream);
        endMetaData(outputstream);
        if (streamwrapper.autoClose)
        {
            AsyncHttpClient.silentCloseInputStream(streamwrapper.inputStream);
        }
    }

    public void addPart(String s, Object obj)
    {
        jsonParams.put(s, obj);
    }

    public void consumeContent()
        throws IOException, UnsupportedOperationException
    {
    }

    public InputStream getContent()
        throws IOException, UnsupportedOperationException
    {
        throw ERR_UNSUPPORTED;
    }

    public Header getContentEncoding()
    {
        return contentEncoding;
    }

    public long getContentLength()
    {
        return -1L;
    }

    public Header getContentType()
    {
        return HEADER_JSON_CONTENT;
    }

    public boolean isChunked()
    {
        return false;
    }

    public boolean isRepeatable()
    {
        return false;
    }

    public boolean isStreaming()
    {
        return false;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        Object obj;
        int k;
        long l;
        if (outputstream == null)
        {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        l = System.currentTimeMillis();
        if (contentEncoding != null)
        {
            outputstream = new GZIPOutputStream(outputstream, 4096);
        }
        outputstream.write(123);
        obj = jsonParams.keySet();
        k = ((Set) (obj)).size();
        if (k <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        int i;
        i = 0;
        iterator = ((Set) (obj)).iterator();
_L20:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        int j;
        obj = (String)iterator.next();
        j = i + 1;
        Object obj1;
        obj1 = jsonParams.get(obj);
        outputstream.write(escape(((String) (obj))));
        outputstream.write(58);
        if (obj1 != null) goto _L6; else goto _L5
_L5:
        outputstream.write(JSON_NULL);
_L18:
        if (elapsedField == null)
        {
            i = j;
            if (j >= k)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        outputstream.write(44);
        i = j;
        continue; /* Loop/switch isn't completed */
_L6:
        boolean flag = obj1 instanceof RequestParams.FileWrapper;
        if (flag) goto _L8; else goto _L7
_L7:
        if (!(obj1 instanceof RequestParams.StreamWrapper)) goto _L9; else goto _L8
_L8:
        outputstream.write(123);
        if (!flag) goto _L11; else goto _L10
_L10:
        writeToFromFile(outputstream, (RequestParams.FileWrapper)obj1);
_L12:
        outputstream.write(125);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if (elapsedField != null || j < k)
        {
            outputstream.write(44);
        }
        throw exception;
_L11:
        writeToFromStream(outputstream, (RequestParams.StreamWrapper)obj1);
        if (true) goto _L12; else goto _L9
_L9:
        if (obj1 instanceof JsonValueInterface)
        {
            outputstream.write(((JsonValueInterface)obj1).getEscapedJsonValue());
            continue; /* Loop/switch isn't completed */
        }
        if (obj1 instanceof JSONObject)
        {
            outputstream.write(obj1.toString().getBytes());
            continue; /* Loop/switch isn't completed */
        }
        if (obj1 instanceof JSONArray)
        {
            outputstream.write(obj1.toString().getBytes());
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj1 instanceof Boolean)) goto _L14; else goto _L13
_L13:
        if (!((Boolean)obj1).booleanValue()) goto _L16; else goto _L15
_L15:
        byte abyte0[] = JSON_TRUE;
_L17:
        outputstream.write(abyte0);
        continue; /* Loop/switch isn't completed */
_L16:
        abyte0 = JSON_FALSE;
        if (true) goto _L17; else goto _L14
_L14:
        if (obj1 instanceof Long)
        {
            outputstream.write((new StringBuilder()).append(((Number)obj1).longValue()).append("").toString().getBytes());
            continue; /* Loop/switch isn't completed */
        }
        if (obj1 instanceof Double)
        {
            outputstream.write((new StringBuilder()).append(((Number)obj1).doubleValue()).append("").toString().getBytes());
            continue; /* Loop/switch isn't completed */
        }
        if (obj1 instanceof Float)
        {
            outputstream.write((new StringBuilder()).append(((Number)obj1).floatValue()).append("").toString().getBytes());
            continue; /* Loop/switch isn't completed */
        }
        if (obj1 instanceof Integer)
        {
            outputstream.write((new StringBuilder()).append(((Number)obj1).intValue()).append("").toString().getBytes());
            continue; /* Loop/switch isn't completed */
        }
        outputstream.write(escape(obj1.toString()));
        if (true) goto _L18; else goto _L4
_L4:
        l = System.currentTimeMillis() - l;
        if (elapsedField != null)
        {
            outputstream.write(elapsedField);
            outputstream.write(58);
            outputstream.write((new StringBuilder()).append(l).append("").toString().getBytes());
        }
        AsyncHttpClient.log.i("JsonStreamerEntity", (new StringBuilder()).append("Uploaded JSON in ").append(Math.floor(l / 1000L)).append(" seconds").toString());
_L2:
        outputstream.write(125);
        outputstream.flush();
        AsyncHttpClient.silentCloseOutputStream(outputstream);
        return;
        if (true) goto _L20; else goto _L19
_L19:
    }

}
