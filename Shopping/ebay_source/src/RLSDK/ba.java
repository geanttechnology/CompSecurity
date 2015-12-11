// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            w, aa, be, v, 
//            q, s, r, p, 
//            ah, y, am, n, 
//            z, bg, ao

public final class ba
    implements w
{

    private static final aa a[] = new aa[0];
    private final be b = new be();

    public ba()
    {
    }

    public final y a(p p1, Hashtable hashtable)
        throws v, q, s
    {
        if (hashtable != null && hashtable.containsKey(r.b))
        {
            p1 = p1.c();
            hashtable = p1.a();
            int ai[] = p1.b();
            if (hashtable == null || ai == null)
            {
                throw v.a();
            }
            int k = ((ah) (p1)).a;
            int i = hashtable[0];
            for (int i1 = hashtable[1]; i < k && p1.a(i, i1); i++) { }
            if (i == k)
            {
                throw v.a();
            }
            int j1 = i - hashtable[0];
            if (j1 == 0)
            {
                throw v.a();
            }
            int k1 = hashtable[1];
            i = ai[1];
            int l1 = hashtable[0];
            int i2 = ((ai[0] - l1) + 1) / j1;
            int j2 = ((i - k1) + 1) / j1;
            if (i2 == 0 || j2 == 0)
            {
                throw v.a();
            }
            int k2 = j1 >> 1;
            hashtable = new ah(i2, j2);
            for (int j = 0; j < j2; j++)
            {
                for (int l = 0; l < i2; l++)
                {
                    if (p1.a(l * j1 + (k2 + l1), k1 + k2 + j * j1))
                    {
                        hashtable.b(l, j);
                    }
                }

            }

            p1 = b.a(hashtable);
            hashtable = a;
        } else
        {
            hashtable = (new bg(p1.c())).a();
            p1 = b.a(hashtable.d());
            hashtable = hashtable.e();
        }
        hashtable = new y(p1.b(), p1.a(), hashtable, n.f);
        if (p1.c() != null)
        {
            hashtable.a(z.c, p1.c());
        }
        if (p1.d() != null)
        {
            hashtable.a(z.d, p1.d().toString());
        }
        return hashtable;
    }

    public final void a()
    {
    }

}
