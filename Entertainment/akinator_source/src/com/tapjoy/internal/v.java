// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;

// Referenced classes of package com.tapjoy.internal:
//            w

public final class v extends ContentHandler
{

    public static final v a = new v();

    private v()
    {
    }

    public static Bitmap a(URLConnection urlconnection)
    {
        urlconnection = urlconnection.getInputStream();
        Bitmap bitmap = w.a.a(urlconnection);
        urlconnection.close();
        return bitmap;
        Exception exception;
        exception;
        urlconnection.close();
        throw exception;
    }

    public final Object getContent(URLConnection urlconnection)
    {
        return a(urlconnection);
    }

}
