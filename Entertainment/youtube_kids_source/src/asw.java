// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.util.Log;
import java.io.IOException;

public final class asw
    implements art
{

    private final ass a;
    private final art b;
    private final art c;
    private final art d;
    private final asx e;
    private final boolean f = false;
    private final boolean g = true;
    private art h;
    private Uri i;
    private String j;
    private long k;
    private long l;
    private asy m;
    private boolean n;
    private long o;

    public asw(ass ass1, art art1, art art2, ars ars, boolean flag, boolean flag1, asx asx1)
    {
        a = ass1;
        b = art2;
        d = art1;
        if (ars != null)
        {
            c = new asp(art1, ars);
        } else
        {
            c = null;
        }
        e = asx1;
    }

    private void a(IOException ioexception)
    {
        if (g && (h == b || (ioexception instanceof asv)))
        {
            n = true;
        }
    }

    private void b()
    {
        if (!n) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L5:
        if (obj != null) goto _L4; else goto _L3
_L3:
        h = d;
        obj = new arx(i, k, l, j);
_L8:
        h.a(((arx) (obj)));
        return;
_L2:
        if (l != -1L)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        Log.w("CacheDataSource", "Cache bypassed due to unbounded length.");
        obj = null;
          goto _L5
label0:
        {
            if (!f)
            {
                break label0;
            }
            obj = a.a(j, k);
        }
          goto _L5
        Object obj1;
        try
        {
            obj = a.b(j, k);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
          goto _L5
_L4:
        if (!((asy) (obj)).d) goto _L7; else goto _L6
_L6:
        obj1 = Uri.fromFile(((asy) (obj)).e);
        long l1 = k - ((asy) (obj)).b;
        long l3 = Math.min(((asy) (obj)).c - l1, l);
        obj = new arx(((Uri) (obj1)), k, l3, j, l1);
        obj1 = b;
_L9:
        h = ((art) (obj1));
          goto _L8
_L7:
        m = ((asy) (obj));
        boolean flag;
        long l2;
        if (((asy) (obj)).c == -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        l2 = l;
_L10:
        obj = new arx(i, k, l2, j);
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        obj1 = c;
          goto _L9
        l2 = Math.min(((asy) (obj)).c, l);
          goto _L10
        obj1 = d;
          goto _L9
    }

    private void c()
    {
        if (h != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        h.a();
        h = null;
        if (m == null) goto _L1; else goto _L3
_L3:
        a.a(m);
        m = null;
        return;
        Exception exception;
        exception;
        if (m != null)
        {
            a.a(m);
            m = null;
        }
        throw exception;
    }

    public final int a(byte abyte0[], int i1, int j1)
    {
        int k1;
        try
        {
            k1 = h.a(abyte0, i1, j1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            a(((IOException) (abyte0)));
            throw abyte0;
        }
        if (k1 < 0)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (h == b)
        {
            o = o + (long)k1;
        }
        k = k + (long)k1;
        if (l == -1L)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        l = l - (long)k1;
        return k1;
        c();
        if (l <= 0L || l == -1L)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        b();
        i1 = a(abyte0, i1, j1);
        return i1;
        return k1;
    }

    public final long a(arx arx1)
    {
        a.b(arx1.b);
        long l1;
        try
        {
            i = arx1.a;
            j = arx1.f;
            k = arx1.d;
            l = arx1.e;
            b();
            l1 = arx1.e;
        }
        // Misplaced declaration of an exception variable
        catch (arx arx1)
        {
            a(((IOException) (arx1)));
            throw arx1;
        }
        return l1;
    }

    public final void a()
    {
        if (e != null && o > 0L)
        {
            e.a(a.a(), o);
            o = 0L;
        }
        try
        {
            c();
            return;
        }
        catch (IOException ioexception)
        {
            a(ioexception);
            throw ioexception;
        }
    }
}
