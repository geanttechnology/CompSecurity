// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.httpUtils;

import android.graphics.Bitmap;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.poshmark.http.PMHttpRequest;
import com.poshmark.http.PMMultipartItem;
import com.poshmark.utils.view_holders.MultiMap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class PMHttpUtils
{

    public PMHttpUtils()
    {
    }

    public static HttpEntity getEntityForRequest(PMHttpRequest pmhttprequest)
    {
label0:
        {
            if (pmhttprequest.multipartData.size() > 0)
            {
                MultipartEntity multipartentity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                java.util.Map.Entry entry;
                Object obj;
                for (Iterator iterator = pmhttprequest.multipartData.entrySet().iterator(); iterator.hasNext(); multipartentity.addPart((String)entry.getKey(), ((org.apache.http.entity.mime.content.ContentBody) (obj))))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                    obj = (PMMultipartItem)entry.getValue();
                    obj = new ByteArrayBody(((PMMultipartItem) (obj)).data, ((PMMultipartItem) (obj)).mimeType, ((PMMultipartItem) (obj)).fileName);
                }

                Iterator iterator1 = pmhttprequest.formData.entrySet().iterator();
                do
                {
                    pmhttprequest = multipartentity;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    pmhttprequest = (java.util.Map.Entry)iterator1.next();
                    try
                    {
                        multipartentity.addPart((String)pmhttprequest.getKey(), new StringBody((String)pmhttprequest.getValue()));
                    }
                    // Misplaced declaration of an exception variable
                    catch (PMHttpRequest pmhttprequest)
                    {
                        pmhttprequest.printStackTrace();
                    }
                } while (true);
            } else
            {
                if (pmhttprequest.nestedFormData.entrySet().size() <= 0)
                {
                    break label0;
                }
                try
                {
                    pmhttprequest = new UrlEncodedFormEntity(getNameValuePairsNested(pmhttprequest.nestedFormData), "UTF-8");
                }
                // Misplaced declaration of an exception variable
                catch (PMHttpRequest pmhttprequest)
                {
                    pmhttprequest.printStackTrace();
                    return null;
                }
            }
            return pmhttprequest;
        }
        try
        {
            pmhttprequest = new UrlEncodedFormEntity(getNameValuePairs(pmhttprequest.formData), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (PMHttpRequest pmhttprequest)
        {
            pmhttprequest.printStackTrace();
            return null;
        }
        return pmhttprequest;
    }

    public static byte[] getJPGContents(String s)
    {
        s = BitmapFactoryInstrumentation.decodeFile((new File(s)).getAbsolutePath());
        if (s != null)
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            s.compress(android.graphics.Bitmap.CompressFormat.JPEG, 95, bytearrayoutputstream);
            return bytearrayoutputstream.toByteArray();
        } else
        {
            return null;
        }
    }

    private static List getNameValuePairs(Map map)
    {
        ArrayList arraylist = new ArrayList(map.size());
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return arraylist;
    }

    private static List getNameValuePairsNested(Map map)
    {
        ArrayList arraylist = new ArrayList(map.size());
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); arraylist.add(new BasicNameValuePair((String)entry.getKey(), entry.getValue().toString())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return arraylist;
    }

    public static String getParamsString(List list)
    {
        return URLEncodedUtils.format(list, "UTF-8");
    }

    public static String getParamsString(Map map)
    {
        return getParamsString(getNameValuePairs(map));
    }

    public static String getResponseString(HttpResponse httpresponse)
        throws IOException
    {
        if (httpresponse.getEntity() != null)
        {
            return EntityUtils.toString(new BufferedHttpEntity(httpresponse.getEntity()), "UTF-8");
        } else
        {
            return null;
        }
    }

    public static String getUrlWithQueryString(String s, Map map)
    {
label0:
        {
            String s1 = s;
            if (map != null)
            {
                map = getParamsString(map);
                if (s.contains("?"))
                {
                    break label0;
                }
                s1 = (new StringBuilder()).append(s).append("?").append(map).toString();
            }
            return s1;
        }
        return (new StringBuilder()).append(s).append("&").append(map).toString();
    }
}
