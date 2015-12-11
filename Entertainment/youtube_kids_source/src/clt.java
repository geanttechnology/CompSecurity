// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

public final class clt extends asd
{

    private final int d;
    private final boolean e;
    private final bmi f;
    private long g;
    private Uri h;
    private arx i;
    private Uri j;
    private long k;
    private boolean l;

    public clt(bmi bmi1, String s, atj atj, asq asq, int i1, int j1, int k1, 
            boolean flag)
    {
        super(s, atj, asq, i1, j1);
        f = (bmi)b.a(bmi1);
        d = k1;
        e = flag;
    }

    private void c()
    {
        j = null;
        k = 0L;
        l = false;
    }

    private void d()
    {
        j = null;
        k = 0L;
        boolean flag;
        if (e && !l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l = flag;
    }

    public final int a(byte abyte0[], int i1, int j1)
    {
        try
        {
            if (d > 0)
            {
                long l1 = f.b() - g;
                if (l1 > (long)d)
                {
                    throw new clu(i, l1, super.c, b());
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            d();
            throw abyte0;
        }
        i1 = super.a(abyte0, i1, j1);
        return i1;
    }

    public final long a(arx arx1)
    {
        g = f.b();
        if (j != null && g - k > 0x927c0L)
        {
            c();
        }
        if (!arx1.a.equals(h))
        {
            c();
            h = arx1.a;
        }
        if (j == null) goto _L2; else goto _L1
_L1:
        arx1 = new arx(j, arx1.c, arx1.e, arx1.f, arx1.d);
_L4:
        i = arx1;
        long l1;
        try
        {
            l1 = super.a(arx1);
            if (j == null)
            {
                j = Uri.parse(super.b.getURL().toString());
                k = f.b();
            }
        }
        // Misplaced declaration of an exception variable
        catch (arx arx1)
        {
            d();
            throw arx1;
        }
        return l1;
_L2:
        if (l)
        {
            arx1 = new arx(arx1.a.buildUpon().appendQueryParameter("cmo", "pf=1").build(), arx1.c, arx1.e, arx1.f, arx1.d);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a()
    {
        Object obj;
        Method method;
        long l1;
        try
        {
            obj = super.b;
        }
        catch (asf asf1)
        {
            d();
            throw asf1;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        l1 = b();
        if (l1 <= 2048L)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        try
        {
            obj = ((HttpURLConnection) (obj)).getInputStream();
            if (obj.getClass().getName().equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"))
            {
                method = obj.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                method.setAccessible(true);
                method.invoke(obj, new Object[0]);
            }
        }
        catch (IOException ioexception) { }
        catch (Exception exception) { }
        super.a();
        return;
    }
}
