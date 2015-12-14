// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.net.http.AndroidHttpClient;
import bolts.Task;
import com.parse.entity.mime.HttpMultipartMode;
import com.parse.entity.mime.content.ByteArrayBody;
import com.parse.entity.mime.content.StringBody;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRequest, CountingMultipartEntity, ParseException, Parse, 
//            ProgressCallback

class ParseAWSRequest extends ParseRequest
{

    private byte data[];
    private String mimeType;
    private JSONObject postParams;
    private ProgressCallback progressCallback;

    public ParseAWSRequest(int i, String s)
    {
        super(i, s);
    }

    public ParseAWSRequest(String s)
    {
        super(s);
    }

    protected HttpEntity newEntity()
    {
        Object obj = new CountingMultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, progressCallback);
        Iterator iterator;
        try
        {
            ((CountingMultipartEntity) (obj)).addPart("Content-Type", new StringBody(mimeType));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((UnsupportedEncodingException) (obj)).getMessage());
        }
        for (iterator = postParams.keys(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            try
            {
                ((CountingMultipartEntity) (obj)).addPart(s, new StringBody(postParams.getString(s)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((UnsupportedEncodingException) (obj)).getMessage());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((JSONException) (obj)).getMessage());
            }
        }

        ((CountingMultipartEntity) (obj)).addPart("file", new ByteArrayBody(data, mimeType, "file"));
        return ((HttpEntity) (obj));
    }

    protected volatile Object onResponse(HttpResponse httpresponse, ProgressCallback progresscallback)
        throws IOException, ParseException
    {
        return onResponse(httpresponse, progresscallback);
    }

    protected byte[] onResponse(HttpResponse httpresponse, ProgressCallback progresscallback)
        throws IOException, ParseException
    {
label0:
        {
            int i = httpresponse.getStatusLine().getStatusCode();
            ByteArrayOutputStream bytearrayoutputstream;
            if (i >= 200 && i < 300 || i == 304)
            {
                if (method != 0)
                {
                    break label0;
                }
                int j = -1;
                Header aheader[] = httpresponse.getHeaders("Content-Length");
                if (aheader.length > 0)
                {
                    j = Integer.parseInt(aheader[0].getValue());
                }
                int k = 0;
                httpresponse = AndroidHttpClient.getUngzippedContent(httpresponse.getEntity());
                bytearrayoutputstream = new ByteArrayOutputStream();
                byte abyte0[] = new byte[32768];
                do
                {
                    int l = httpresponse.read(abyte0, 0, abyte0.length);
                    if (l == -1)
                    {
                        break;
                    }
                    bytearrayoutputstream.write(abyte0, 0, l);
                    l = k + l;
                    k = l;
                    if (progresscallback != null)
                    {
                        k = l;
                        if (j != -1)
                        {
                            Parse.callbackOnMainThreadAsync(Task.forResult(Integer.valueOf(Math.round(((float)l / (float)j) * 100F))), progresscallback);
                            k = l;
                        }
                    }
                } while (true);
            } else
            {
                if (method == 0)
                {
                    progresscallback = "Download from";
                } else
                {
                    progresscallback = "Upload to";
                }
                throw new ParseException(100, String.format("%s S3 failed. %s", new Object[] {
                    progresscallback, httpresponse.getStatusLine().getReasonPhrase()
                }));
            }
            return bytearrayoutputstream.toByteArray();
        }
        return null;
    }

    public void setData(byte abyte0[])
    {
        data = abyte0;
    }

    public void setMimeType(String s)
    {
        mimeType = s;
    }

    public void setPostParams(JSONObject jsonobject)
    {
        postParams = jsonobject;
    }

    public void setProgressCallback(ProgressCallback progresscallback)
    {
        progressCallback = progresscallback;
    }
}
