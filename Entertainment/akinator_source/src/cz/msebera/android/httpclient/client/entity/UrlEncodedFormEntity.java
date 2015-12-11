// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

public class UrlEncodedFormEntity extends StringEntity
{

    public UrlEncodedFormEntity(Iterable iterable)
    {
        this(iterable, ((Charset) (null)));
    }

    public UrlEncodedFormEntity(Iterable iterable, Charset charset)
    {
        Charset charset1;
        if (charset != null)
        {
            charset1 = charset;
        } else
        {
            charset1 = HTTP.DEF_CONTENT_CHARSET;
        }
        super(URLEncodedUtils.format(iterable, charset1), ContentType.create("application/x-www-form-urlencoded", charset));
    }

    public UrlEncodedFormEntity(List list)
        throws UnsupportedEncodingException
    {
        this(((Iterable) (list)), (Charset)null);
    }

    public UrlEncodedFormEntity(List list, String s)
        throws UnsupportedEncodingException
    {
        String s1;
        if (s != null)
        {
            s1 = s;
        } else
        {
            s1 = HTTP.DEF_CONTENT_CHARSET.name();
        }
        super(URLEncodedUtils.format(list, s1), ContentType.create("application/x-www-form-urlencoded", s));
    }
}
