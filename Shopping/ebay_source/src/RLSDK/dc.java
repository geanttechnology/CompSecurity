// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            w, aa, dh, v, 
//            q, s, r, p, 
//            ah, y, am, n, 
//            z, do, ao

public final class dc
    implements w
{

    private static final aa a[] = new aa[0];
    private final dh b = new dh();

    public dc()
    {
    }

    public final y a(p p1, Hashtable hashtable)
        throws v, q, s
    {
        if (hashtable != null && hashtable.containsKey(r.b))
        {
            p1 = p1.c();
            int ai[] = p1.a();
            int ai1[] = p1.b();
            if (ai == null || ai1 == null)
            {
                throw v.a();
            }
            int i1 = ((ah) (p1)).b;
            int j1 = ((ah) (p1)).a;
            int k = ai[0];
            int i;
            for (i = ai[1]; k < j1 && i < i1 && p1.a(k, i); i++)
            {
                k++;
            }

            if (k == j1 || i == i1)
            {
                throw v.a();
            }
            i1 = k - ai[0];
            if (i1 == 0)
            {
                throw v.a();
            }
            j1 = ai[1];
            i = ai1[1];
            int k1 = ai[0];
            int l1 = ((ai1[0] - k1) + 1) / i1;
            int i2 = ((i - j1) + 1) / i1;
            if (l1 == 0 || i2 == 0)
            {
                throw v.a();
            }
            if (i2 != l1)
            {
                throw v.a();
            }
            int j2 = i1 >> 1;
            ah ah1 = new ah(l1, i2);
            for (int j = 0; j < i2; j++)
            {
                for (int l = 0; l < l1; l++)
                {
                    if (p1.a(l * i1 + (k1 + j2), j1 + j2 + j * i1))
                    {
                        ah1.b(l, j);
                    }
                }

            }

            p1 = b.a(ah1, hashtable);
            hashtable = a;
        } else
        {
            ao ao1 = (new do(p1.c())).a(hashtable);
            p1 = b.a(ao1.d(), hashtable);
            hashtable = ao1.e();
        }
        hashtable = new y(p1.b(), p1.a(), hashtable, n.k);
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
