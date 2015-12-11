// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.c;
import c.e;
import c.f;
import c.i;
import c.l;
import c.m;
import c.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

// Referenced classes of package com.g.b.a.d:
//            d, n

final class j
{

    int a;
    final e b;
    private final l c;

    public j(e e1)
    {
        c = new l(new i(e1) {

            final j a;

            public final long a(c c1, long l1)
            {
                if (a.a != 0)
                {
                    if ((l1 = super.a(c1, Math.min(l1, a.a))) != -1L)
                    {
                        a.a = (int)((long)a.a - l1);
                        return l1;
                    }
                }
                return -1L;
            }

            
            {
                a = j.this;
                super(s);
            }
        }, new Inflater() {

            final j a;

            public final int inflate(byte abyte0[], int i, int k)
            {
                int j1 = super.inflate(abyte0, i, k);
                int i1 = j1;
                if (j1 == 0)
                {
                    i1 = j1;
                    if (needsDictionary())
                    {
                        setDictionary(n.a);
                        i1 = super.inflate(abyte0, i, k);
                    }
                }
                return i1;
            }

            
            {
                a = j.this;
                super();
            }
        });
        b = m.a(c);
    }

    private f a()
    {
        int i = b.i();
        return b.c(i);
    }

    public final List a(int i)
    {
        a = a + i;
        int k = b.i();
        if (k < 0)
        {
            throw new IOException((new StringBuilder("numberOfPairs < 0: ")).append(k).toString());
        }
        if (k > 1024)
        {
            throw new IOException((new StringBuilder("numberOfPairs > 1024: ")).append(k).toString());
        }
        ArrayList arraylist = new ArrayList(k);
        for (i = 0; i < k; i++)
        {
            f f1 = a().c();
            f f2 = a();
            if (f1.c.length == 0)
            {
                throw new IOException("name.size == 0");
            }
            arraylist.add(new d(f1, f2));
        }

        if (a > 0)
        {
            c.b();
            if (a != 0)
            {
                throw new IOException((new StringBuilder("compressedLimit > 0: ")).append(a).toString());
            }
        }
        return arraylist;
    }
}
