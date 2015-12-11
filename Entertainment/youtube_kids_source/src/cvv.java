// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

public final class cvv
    implements art
{

    private final List a;
    private final art b;
    private art c;
    private String d;
    private long e;
    private long f;

    public cvv(List list, art art1)
    {
        a = (List)b.a(list);
        b = (art)b.a(art1);
    }

    private void b()
    {
        Object obj;
        try
        {
            if (a.isEmpty())
            {
                throw new FileNotFoundException("Chunk not found: no caches.");
            }
        }
        catch (InterruptedException interruptedexception)
        {
            throw new RuntimeException(interruptedexception);
        }
        obj = null;
        Iterator iterator = a.iterator();
_L2:
        ass ass1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_171;
        }
        ass1 = (ass)iterator.next();
        obj = ass1.a(d, e);
        if (((asy) (obj)).d)
        {
            Uri uri = Uri.fromFile(((asy) (obj)).e);
            long l = e - ((asy) (obj)).b;
            long l2 = Math.min(((asy) (obj)).c - l, f);
            obj = new arx(uri, e, l2, d, l);
            c = b;
            c.a(((arx) (obj)));
            return;
        }
        ass1.a(((asy) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        long l1 = ((asy) (obj)).b;
        long l3 = ((asy) (obj)).b;
        long l4 = ((asy) (obj)).c;
        throw new FileNotFoundException((new StringBuilder(80)).append("Chunk not found: ").append(l1).append(" - ").append(l3).append(l4).toString());
    }

    private void c()
    {
        if (c == null)
        {
            return;
        } else
        {
            c.a();
            c = null;
            return;
        }
    }

    public final int a(byte abyte0[], int i, int j)
    {
_L6:
        int k = c.a(abyte0, i, j);
        if (k < 0) goto _L2; else goto _L1
_L1:
        e = e + (long)k;
        f = f - (long)k;
_L4:
        return k;
_L2:
        c();
        if (f <= 0L) goto _L4; else goto _L3
_L3:
        b();
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final long a(arx arx1)
    {
        b.b(arx1.b);
        boolean flag;
        if (arx1.e != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        d = arx1.f;
        e = arx1.d;
        f = arx1.e;
        b();
        return arx1.e;
    }

    public final void a()
    {
        c();
    }
}
