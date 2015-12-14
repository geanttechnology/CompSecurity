// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public interface acv
{

    public static final acv a = new acv() {

        public HttpURLConnection a(URL url)
        {
            return (HttpURLConnection)url.openConnection();
        }

        public HttpURLConnection a(URL url, Proxy proxy)
        {
            return (HttpURLConnection)url.openConnection(proxy);
        }

    };

    public abstract HttpURLConnection a(URL url);

    public abstract HttpURLConnection a(URL url, Proxy proxy);

}
