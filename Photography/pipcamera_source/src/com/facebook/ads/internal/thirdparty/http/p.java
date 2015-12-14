// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.thirdparty.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

// Referenced classes of package com.facebook.ads.internal.thirdparty.http:
//            j, m

public interface p
{

    public abstract OutputStream a(HttpURLConnection httpurlconnection);

    public abstract HttpURLConnection a(String s);

    public abstract void a(OutputStream outputstream, byte abyte0[]);

    public abstract void a(HttpURLConnection httpurlconnection, j j, String s);

    public abstract boolean a(m m);

    public abstract byte[] a(InputStream inputstream);

    public abstract InputStream b(HttpURLConnection httpurlconnection);
}
