// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public class bwf extends bwg
{

    final InputStream a;
    final OutputStream b;
    final HttpRequest c;

    public bwf(HttpRequest httprequest, Closeable closeable, boolean flag, InputStream inputstream, OutputStream outputstream)
    {
        c = httprequest;
        a = inputstream;
        b = outputstream;
        super(closeable, flag);
    }

    public HttpRequest a()
    {
        byte abyte0[] = new byte[HttpRequest.a(c)];
        do
        {
            int i = a.read(abyte0);
            if (i != -1)
            {
                b.write(abyte0, 0, i);
            } else
            {
                return c;
            }
        } while (true);
    }

    public Object b()
    {
        return a();
    }
}
