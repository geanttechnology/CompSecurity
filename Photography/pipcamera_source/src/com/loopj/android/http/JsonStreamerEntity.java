// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.loopj.android.http:
//            Base64OutputStream, ResponseHandlerInterface, AsyncHttpClient, JsonValueInterface

public class JsonStreamerEntity
    implements HttpEntity
{

    private static final int BUFFER_SIZE = 4096;
    private static final StringBuilder BUILDER = new StringBuilder(128);
    private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", "gzip");
    private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
    private static final byte JSON_FALSE[] = "false".getBytes();
    private static final byte JSON_NULL[] = "null".getBytes();
    private static final byte JSON_TRUE[] = "true".getBytes();
    private static final String LOG_TAG = "JsonStreamerEntity";
    private static final byte STREAM_CONTENTS[] = escape("contents");
    private static final byte STREAM_ELAPSED[] = escape("_elapsed");
    private static final byte STREAM_NAME[] = escape("name");
    private static final byte STREAM_TYPE[] = escape("type");
    private final byte buffer[] = new byte[4096];
    private final Header contentEncoding;
    private final Map jsonParams = new HashMap();
    private final ResponseHandlerInterface progressHandler;

    public JsonStreamerEntity(ResponseHandlerInterface responsehandlerinterface, boolean flag)
    {
        progressHandler = responsehandlerinterface;
        if (flag)
        {
            responsehandlerinterface = HEADER_GZIP_ENCODING;
        } else
        {
            responsehandlerinterface = null;
        }
        contentEncoding = responsehandlerinterface;
    }

    private void endMetaData(OutputStream outputstream)
    {
        outputstream.write(34);
    }

    static byte[] escape(String s)
    {
        int i;
        int k;
        if (s == null)
        {
            return JSON_NULL;
        }
        BUILDER.append('"');
        k = s.length();
        i = -1;
_L10:
        char c;
        int j;
        j = i + 1;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        c = s.charAt(j);
        c;
        JVM INSTR lookupswitch 7: default 112
    //                   8: 222
    //                   9: 270
    //                   10: 246
    //                   12: 234
    //                   13: 258
    //                   34: 195
    //                   92: 210;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break; /* Loop/switch isn't completed */
_L7:
        BUILDER.append("\\\"");
_L11:
        i = j;
        if (true) goto _L10; else goto _L9
_L9:
        BUILDER.append("\\\\");
          goto _L11
_L2:
        BUILDER.append("\\b");
          goto _L11
_L5:
        BUILDER.append("\\f");
          goto _L11
_L4:
        BUILDER.append("\\n");
          goto _L11
_L6:
        BUILDER.append("\\r");
          goto _L11
_L3:
        BUILDER.append("\\t");
          goto _L11
_L1:
        if ((c < 0 || c > '\037') && (c < '\177' || c > '\237') && (c < '\u2000' || c > '\u20FF'))
        {
            break MISSING_BLOCK_LABEL_299;
        }
        String s1 = Integer.toHexString(c);
        BUILDER.append("\\u");
        int l = s1.length();
        for (i = 0; i < 4 - l; i++)
        {
            BUILDER.append('0');
        }

        BUILDER.append(s1.toUpperCase(Locale.US));
        break; /* Loop/switch isn't completed */
        BUILDER.append(c);
          goto _L11
        BUILDER.append('"');
        s = BUILDER.toString().getBytes();
        BUILDER.setLength(0);
        return s;
        s;
        BUILDER.setLength(0);
        throw s;
    }

    private void writeMetaData(OutputStream outputstream, String s, String s1)
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
    {
        writeMetaData(outputstream, filewrapper.file.getName(), filewrapper.contentType);
        int j = (int)filewrapper.file.length();
        filewrapper = new FileInputStream(filewrapper.file);
        Base64OutputStream base64outputstream = new Base64OutputStream(outputstream, 18);
        int i = 0;
        do
        {
            int k = filewrapper.read(buffer);
            if (k != -1)
            {
                base64outputstream.write(buffer, 0, k);
                i += k;
                progressHandler.sendProgressMessage(i, j);
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
    {
    }

    public InputStream getContent()
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
    {
        if (outputstream == null)
        {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long l = System.currentTimeMillis();
        Object obj = outputstream;
        if (contentEncoding != null)
        {
            obj = new GZIPOutputStream(outputstream, 4096);
        }
        ((OutputStream) (obj)).write(123);
        Iterator iterator = jsonParams.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            outputstream = (String)iterator.next();
            Object obj1 = jsonParams.get(outputstream);
            if (obj1 != null)
            {
                ((OutputStream) (obj)).write(escape(outputstream));
                ((OutputStream) (obj)).write(58);
                boolean flag = obj1 instanceof RequestParams.FileWrapper;
                if (flag || (obj1 instanceof RequestParams.StreamWrapper))
                {
                    ((OutputStream) (obj)).write(123);
                    if (flag)
                    {
                        writeToFromFile(((OutputStream) (obj)), (RequestParams.FileWrapper)obj1);
                    } else
                    {
                        writeToFromStream(((OutputStream) (obj)), (RequestParams.StreamWrapper)obj1);
                    }
                    ((OutputStream) (obj)).write(125);
                } else
                if (obj1 instanceof JsonValueInterface)
                {
                    ((OutputStream) (obj)).write(((JsonValueInterface)obj1).getEscapedJsonValue());
                } else
                if (obj1 instanceof JSONObject)
                {
                    ((OutputStream) (obj)).write(((JSONObject)obj1).toString().getBytes());
                } else
                if (obj1 instanceof JSONArray)
                {
                    ((OutputStream) (obj)).write(((JSONArray)obj1).toString().getBytes());
                } else
                if (obj1 instanceof Boolean)
                {
                    if (((Boolean)obj1).booleanValue())
                    {
                        outputstream = JSON_TRUE;
                    } else
                    {
                        outputstream = JSON_FALSE;
                    }
                    ((OutputStream) (obj)).write(outputstream);
                } else
                if (obj1 instanceof Long)
                {
                    ((OutputStream) (obj)).write((new StringBuilder()).append(((Number)obj1).longValue()).append("").toString().getBytes());
                } else
                if (obj1 instanceof Double)
                {
                    ((OutputStream) (obj)).write((new StringBuilder()).append(((Number)obj1).doubleValue()).append("").toString().getBytes());
                } else
                if (obj1 instanceof Float)
                {
                    ((OutputStream) (obj)).write((new StringBuilder()).append(((Number)obj1).floatValue()).append("").toString().getBytes());
                } else
                if (obj1 instanceof Integer)
                {
                    ((OutputStream) (obj)).write((new StringBuilder()).append(((Number)obj1).intValue()).append("").toString().getBytes());
                } else
                {
                    ((OutputStream) (obj)).write(escape(obj1.toString()));
                }
                ((OutputStream) (obj)).write(44);
            }
        } while (true);
        ((OutputStream) (obj)).write(STREAM_ELAPSED);
        ((OutputStream) (obj)).write(58);
        l = System.currentTimeMillis() - l;
        ((OutputStream) (obj)).write((new StringBuilder()).append(l).append("}").toString().getBytes());
        Log.i("JsonStreamerEntity", (new StringBuilder()).append("Uploaded JSON in ").append(Math.floor(l / 1000L)).append(" seconds").toString());
        ((OutputStream) (obj)).flush();
        AsyncHttpClient.silentCloseOutputStream(((OutputStream) (obj)));
    }

}
