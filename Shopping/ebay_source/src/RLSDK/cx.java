// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            w, aa, da, v, 
//            s, r, p, ah, 
//            y, am, n, db, 
//            ao

public final class cx
    implements w
{

    private static final aa a[] = new aa[0];
    private final da b = new da();

    public cx()
    {
    }

    public final y a(p p1, Hashtable hashtable)
        throws v, s
    {
        boolean flag1 = true;
        if (hashtable != null && hashtable.containsKey(r.b))
        {
            p1 = p1.c();
            hashtable = p1.a();
            int ai[] = p1.b();
            if (hashtable == null || ai == null)
            {
                throw v.a();
            }
            int i = hashtable[0];
            int l = hashtable[1];
            int i1;
            for (i1 = ((ah) (p1)).a; i < i1 && p1.a(i, l); i++) { }
            if (i == i1)
            {
                throw v.a();
            }
            int l1 = i - hashtable[0] >>> 3;
            if (l1 == 0)
            {
                throw v.a();
            }
            int i2 = hashtable[1];
            int j2 = ai[1];
            l = hashtable[0];
            int k1 = ((ah) (p1)).a;
            boolean flag = true;
            for (i = 0; l < k1 - 1 && i < 8; l = i1)
            {
                i1 = l + 1;
                boolean flag3 = p1.a(i1, i2);
                l = i;
                if (flag != flag3)
                {
                    l = i + 1;
                }
                flag = flag3;
                i = l;
            }

            if (l == k1 - 1)
            {
                throw v.a();
            }
            int k2 = hashtable[0];
            for (i = ((ah) (p1)).a - 1; i > k2 && !p1.a(i, i2); i--) { }
            k1 = 0;
            i1 = i;
            flag = flag1;
            for (int j = k1; i1 > k2 && j < 9; i1 = k1)
            {
                k1 = i1 - 1;
                boolean flag2 = p1.a(k1, i2);
                i1 = j;
                if (flag != flag2)
                {
                    i1 = j + 1;
                }
                flag = flag2;
                j = i1;
            }

            if (i1 == k2)
            {
                throw v.a();
            }
            k1 = ((i1 - l) + 1) / l1;
            j2 = ((j2 - i2) + 1) / l1;
            if (k1 == 0 || j2 == 0)
            {
                throw v.a();
            }
            k2 = l1 >> 1;
            hashtable = new ah(k1, j2);
            for (int k = 0; k < j2; k++)
            {
                for (int j1 = 0; j1 < k1; j1++)
                {
                    if (p1.a(j1 * l1 + (l + k2), i2 + k2 + k * l1))
                    {
                        hashtable.b(j1, k);
                    }
                }

            }

            p1 = b;
            hashtable = da.a(hashtable);
            p1 = a;
        } else
        {
            p1 = (new db(p1)).a();
            hashtable = b;
            hashtable = da.a(p1.d());
            p1 = p1.e();
        }
        return new y(hashtable.b(), hashtable.a(), p1, n.j);
    }

    public final void a()
    {
    }

}
