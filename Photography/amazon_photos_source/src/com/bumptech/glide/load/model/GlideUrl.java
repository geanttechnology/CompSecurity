// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;

public class GlideUrl
{

    private URL safeUrl;
    private String stringUrl;
    private final URL url;

    public GlideUrl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("String url must not be empty or null: ").append(s).toString());
        } else
        {
            stringUrl = s;
            url = null;
            return;
        }
    }

    public GlideUrl(URL url1)
    {
        if (url1 == null)
        {
            throw new IllegalArgumentException("URL must not be null!");
        } else
        {
            url = url1;
            stringUrl = null;
            return;
        }
    }

    private URL getSafeUrl()
        throws MalformedURLException
    {
        if (safeUrl != null)
        {
            return safeUrl;
        } else
        {
            safeUrl = new URL(Uri.encode(toString(), "@#&=*+-_.,:!?()/~'%"));
            return safeUrl;
        }
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            return toString().equals(obj.toString());
        }
    }

    public int hashCode()
    {
        return toString().hashCode();
    }

    public String toString()
    {
        if (TextUtils.isEmpty(stringUrl))
        {
            stringUrl = url.toString();
        }
        return stringUrl;
    }

    public URL toURL()
        throws MalformedURLException
    {
        return getSafeUrl();
    }
}
