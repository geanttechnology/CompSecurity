// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.Context;
import android.net.Uri;
import com.nostra13.universalimageloader.b.b;
import com.nostra13.universalimageloader.core.download.a;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class z extends a
{

    public z(Context context)
    {
        super(context);
    }

    protected HttpURLConnection a(String s, Object obj)
    {
        s = Uri.encode(s, "@#&=*+-_.,:!?()/~'%");
        s = (new OkUrlFactory(new OkHttpClient())).open(new URL(s));
        s.setConnectTimeout(b);
        s.setReadTimeout(c);
        s.setInstanceFollowRedirects(true);
        return s;
    }

    protected InputStream b(String s, Object obj)
    {
        s = a(s, obj);
        try
        {
            obj = s.getInputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.nostra13.universalimageloader.b.b.a(s.getErrorStream());
            throw obj;
        }
        if (!a(s))
        {
            com.nostra13.universalimageloader.b.b.a(((java.io.Closeable) (obj)));
            throw new IOException((new StringBuilder()).append("Image request failed with response code ").append(s.getResponseCode()).toString());
        } else
        {
            return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(((InputStream) (obj)), 32768), s.getContentLength());
        }
    }
}
