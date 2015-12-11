// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.NetworkInfo;
import android.net.Uri;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            ald, alb, ako, alj, 
//            alf

class akw extends ald
{
    static class a extends IOException
    {

        public a(String s)
        {
            super(s);
        }
    }


    private final ako a;
    private final alf b;

    public akw(ako ako1, alf alf1)
    {
        a = ako1;
        b = alf1;
    }

    int a()
    {
        return 2;
    }

    public ald.a a(alb alb1, int i)
        throws IOException
    {
        ako.a a1 = a.a(alb1.d, alb1.c);
        if (a1 == null)
        {
            return null;
        }
        Object obj;
        if (a1.c)
        {
            alb1 = aky.d.b;
        } else
        {
            alb1 = aky.d.c;
        }
        obj = a1.b();
        if (obj != null)
        {
            return new ald.a(((android.graphics.Bitmap) (obj)), alb1);
        }
        obj = a1.a();
        if (obj == null)
        {
            return null;
        }
        if (alb1 == aky.d.b && a1.c() == 0L)
        {
            alj.a(((java.io.InputStream) (obj)));
            throw new a("Received response with 0 content-length header.");
        }
        if (alb1 == aky.d.c && a1.c() > 0L)
        {
            b.a(a1.c());
        }
        return new ald.a(((java.io.InputStream) (obj)), alb1);
    }

    public boolean a(alb alb1)
    {
        alb1 = alb1.d.getScheme();
        return "http".equals(alb1) || "https".equals(alb1);
    }

    boolean a(boolean flag, NetworkInfo networkinfo)
    {
        return networkinfo == null || networkinfo.isConnected();
    }

    boolean b()
    {
        return true;
    }
}
