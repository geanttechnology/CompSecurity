// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class WeiboParameters
{

    private static final String DEFAULT_CHARSET = "UTF-8";
    private String mAppKey;
    private LinkedHashMap mParams;

    public WeiboParameters(String s)
    {
        mParams = new LinkedHashMap();
        mAppKey = s;
    }

    public void add(String s, int i)
    {
        mParams.put(s, String.valueOf(i));
    }

    public void add(String s, long l)
    {
        mParams.put(s, String.valueOf(l));
    }

    public void add(String s, Object obj)
    {
        mParams.put(s, obj.toString());
    }

    public void add(String s, String s1)
    {
        mParams.put(s, s1);
    }

    public boolean containsKey(String s)
    {
        return mParams.containsKey(s);
    }

    public boolean containsValue(String s)
    {
        return mParams.containsValue(s);
    }

    public String encodeUrl()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = mParams.keySet().iterator();
        boolean flag = true;
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    return stringbuilder.toString();
                }
                String s = (String)iterator.next();
                Object obj;
                if (flag)
                {
                    flag = false;
                } else
                {
                    stringbuilder.append("&");
                }
                obj = mParams.get(s);
            } while (!(obj instanceof String));
            obj = (String)obj;
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                try
                {
                    stringbuilder.append((new StringBuilder(String.valueOf(URLEncoder.encode(s, "UTF-8")))).append("=").append(URLEncoder.encode(((String) (obj)), "UTF-8")).toString());
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    unsupportedencodingexception.printStackTrace();
                }
            }
            LogUtil.i("encodeUrl", stringbuilder.toString());
        } while (true);
    }

    public Object get(String s)
    {
        return mParams.get(s);
    }

    public String getAppKey()
    {
        return mAppKey;
    }

    public LinkedHashMap getParams()
    {
        return mParams;
    }

    public boolean hasBinaryData()
    {
        Iterator iterator = mParams.keySet().iterator();
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }
            obj = (String)iterator.next();
            obj = mParams.get(obj);
        } while (!(obj instanceof ByteArrayOutputStream) && !(obj instanceof Bitmap));
        return true;
    }

    public Set keySet()
    {
        return mParams.keySet();
    }

    public void put(String s, int i)
    {
        mParams.put(s, String.valueOf(i));
    }

    public void put(String s, long l)
    {
        mParams.put(s, String.valueOf(l));
    }

    public void put(String s, Bitmap bitmap)
    {
        mParams.put(s, bitmap);
    }

    public void put(String s, Object obj)
    {
        mParams.put(s, obj.toString());
    }

    public void put(String s, String s1)
    {
        mParams.put(s, s1);
    }

    public void remove(String s)
    {
        if (mParams.containsKey(s))
        {
            mParams.remove(s);
            mParams.remove(mParams.get(s));
        }
    }

    public void setParams(LinkedHashMap linkedhashmap)
    {
        mParams = linkedhashmap;
    }

    public int size()
    {
        return mParams.size();
    }
}
