// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.e;

import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package c.a.a.a.a.e:
//            g

final class h
    implements g
{

    h()
    {
    }

    public final HttpURLConnection a(URL url)
    {
        return (HttpURLConnection)url.openConnection();
    }
}
