// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

class HttpParameterMap extends HashMap
{

    private static final String TAG = com/threatmetrix/TrustDefenderMobile/HttpParameterMap.getName();
    private int m_postValueLengthLimit;

    HttpParameterMap()
    {
        m_postValueLengthLimit = 0;
    }

    public HttpParameterMap add(String s, String s1)
    {
        put(s, s1);
        return this;
    }

    public HttpParameterMap add(String s, String s1, boolean flag)
    {
        if (flag && s1 != null && !s1.isEmpty())
        {
            put(s, s1.toLowerCase(Locale.US));
            return this;
        } else
        {
            put(s, s1);
            return this;
        }
    }

    public UrlEncodedFormEntity getEntity()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s2 = (String)iterator.next();
            String s1 = (String)get(s2);
            if (!s1.isEmpty())
            {
                String s = s1;
                if (m_postValueLengthLimit != 0)
                {
                    s = s1;
                    if (s1.length() > m_postValueLengthLimit)
                    {
                        s = s1.substring(0, m_postValueLengthLimit);
                    }
                }
                arraylist.add(new BasicNameValuePair(s2, s));
            }
        } while (true);
        UrlEncodedFormEntity urlencodedformentity;
        try
        {
            urlencodedformentity = new UrlEncodedFormEntity(arraylist, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            Log.e(TAG, "Failed url encoding", unsupportedencodingexception);
            return null;
        }
        return urlencodedformentity;
    }

    public String getUrlEncodedParamString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            String s1 = (String)get(s);
            if (s1 != null && !s1.isEmpty())
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append("&");
                }
                stringbuilder.append(s);
                s = s1;
                if (m_postValueLengthLimit != 0)
                {
                    s = s1;
                    if (s1.length() > m_postValueLengthLimit)
                    {
                        s = s1.substring(0, m_postValueLengthLimit);
                    }
                }
                stringbuilder.append("=");
                try
                {
                    stringbuilder.append(URLEncoder.encode(s, "UTF-8"));
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    Log.e(TAG, "Failed url encoding", unsupportedencodingexception);
                }
            }
        } while (true);
        return stringbuilder.toString();
    }

    public void setPostValueLengthLimit(int i)
    {
        m_postValueLengthLimit = i;
    }

}
