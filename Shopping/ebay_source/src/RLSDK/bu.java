// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            br, bt, bn, v, 
//            ag, q, s, x, 
//            aa, ab, r, y, 
//            n, z

public abstract class bu extends br
{

    static final int b[] = {
        1, 1, 1
    };
    static final int c[] = {
        1, 1, 1, 1, 1
    };
    static final int d[][] = {
        {
            3, 2, 1, 1
        }, {
            2, 2, 2, 1
        }, {
            2, 1, 2, 2
        }, {
            1, 4, 1, 1
        }, {
            1, 1, 3, 2
        }, {
            1, 2, 3, 1
        }, {
            1, 1, 1, 4
        }, {
            1, 3, 1, 2
        }, {
            1, 2, 1, 3
        }, {
            3, 1, 1, 2
        }
    };
    static final int e[][];
    private final StringBuffer a = new StringBuffer(20);
    private final bt f = new bt();
    private final bn g = new bn();

    protected bu()
    {
    }

    static int a(ag ag1, int ai[], int i, int ai1[][])
        throws v
    {
        a(ag1, i, ai);
        int j = 107;
        int k = -1;
        int i1 = ai1.length;
        for (i = 0; i < i1; i++)
        {
            int l = a(ai, ai1[i], 179);
            if (l < j)
            {
                k = i;
                j = l;
            }
        }

        if (k >= 0)
        {
            return k;
        } else
        {
            throw v.a();
        }
    }

    static int[] a(ag ag1)
        throws v
    {
        int i = 0;
        int ai[] = null;
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int ai1[] = a(ag1, i, false, b);
            int k = ai1[0];
            int j = ai1[1];
            int l = k - (j - k);
            i = j;
            ai = ai1;
            if (l >= 0)
            {
                flag = ag1.a(l, k);
                i = j;
                ai = ai1;
            }
        } while (true);
        return ai;
    }

    static int[] a(ag ag1, int i, boolean flag, int ai[])
        throws v
    {
        int i1 = ai.length;
        int ai1[] = new int[i1];
        int j1 = ag1.b;
        boolean flag1 = false;
        boolean flag2;
        do
        {
            flag2 = flag1;
            if (i >= j1)
            {
                break;
            }
            if (!ag1.a(i))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag2 = flag1;
            if (flag == flag1)
            {
                break;
            }
            i++;
        } while (true);
        int k = i;
        int j = 0;
        flag = flag2;
        while (k < j1) 
        {
            int l;
            if (ag1.a(k) ^ flag)
            {
                ai1[j] = ai1[j] + 1;
                l = j;
                j = i;
            } else
            {
                if (j == i1 - 1)
                {
                    if (a(ai1, ai, 179) < 107)
                    {
                        return (new int[] {
                            i, k
                        });
                    }
                    l = i + (ai1[0] + ai1[1]);
                    for (i = 2; i < i1; i++)
                    {
                        ai1[i - 2] = ai1[i];
                    }

                    ai1[i1 - 2] = 0;
                    ai1[i1 - 1] = 0;
                    i = j - 1;
                    j = l;
                } else
                {
                    l = j + 1;
                    j = i;
                    i = l;
                }
                ai1[i] = 1;
                if (!flag)
                {
                    flag = true;
                    l = i;
                } else
                {
                    flag = false;
                    l = i;
                }
            }
            k++;
            i = j;
            j = l;
        }
        throw v.a();
    }

    protected abstract int a(ag ag1, int ai[], StringBuffer stringbuffer)
        throws v;

    public y a(int i, ag ag1, Hashtable hashtable)
        throws v, q, s
    {
        return a(i, ag1, a(ag1), hashtable);
    }

    public y a(int i, ag ag1, int ai[], Hashtable hashtable)
        throws v, q, s
    {
        int ai1[];
        Object obj;
        int j;
        int k;
        if (hashtable == null)
        {
            hashtable = null;
        } else
        {
            hashtable = (ab)hashtable.get(r.h);
        }
        if (hashtable != null)
        {
            hashtable.a(new aa((float)(ai[0] + ai[1]) / 2.0F, i));
        }
        obj = a;
        ((StringBuffer) (obj)).setLength(0);
        j = a(ag1, ai, ((StringBuffer) (obj)));
        if (hashtable != null)
        {
            hashtable.a(new aa(j, i));
        }
        ai1 = a(ag1, j);
        if (hashtable != null)
        {
            hashtable.a(new aa((float)(ai1[0] + ai1[1]) / 2.0F, i));
        }
        j = ai1[1];
        k = (j - ai1[0]) + j;
        if (k >= ag1.b || !ag1.a(j, k))
        {
            throw v.a();
        }
        hashtable = ((StringBuffer) (obj)).toString();
        if (!a(((String) (hashtable))))
        {
            throw q.a();
        }
        float f1 = (float)(ai[1] + ai[0]) / 2.0F;
        float f2 = (float)(ai1[1] + ai1[0]) / 2.0F;
        obj = b();
        ai = new y(hashtable, null, new aa[] {
            new aa(f1, i), new aa(f2, i)
        }, ((n) (obj)));
        try
        {
            ag1 = f.a(i, ag1, ai1[1]);
            ai.a(ag1.d());
            ai.a(ag1.b());
        }
        // Misplaced declaration of an exception variable
        catch (ag ag1) { }
        if (n.h.equals(obj) || n.n.equals(obj))
        {
            ag1 = g.a(hashtable);
            if (ag1 != null)
            {
                ai.a(z.g, ag1);
            }
        }
        return ai;
    }

    boolean a(String s1)
        throws q, s
    {
        boolean flag1 = false;
        int l = s1.length();
        boolean flag = flag1;
        if (l != 0)
        {
            int i = l - 2;
            int k = 0;
            for (; i >= 0; i -= 2)
            {
                int j1 = s1.charAt(i) - 48;
                if (j1 < 0 || j1 > 9)
                {
                    throw s.a();
                }
                k += j1;
            }

            k *= 3;
            for (int j = l - 1; j >= 0; j -= 2)
            {
                int i1 = s1.charAt(j) - 48;
                if (i1 < 0 || i1 > 9)
                {
                    throw s.a();
                }
                k += i1;
            }

            flag = flag1;
            if (k % 10 == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    int[] a(ag ag1, int i)
        throws v
    {
        return a(ag1, i, false, b);
    }

    abstract n b();

    static 
    {
        e = new int[20][];
        for (int i = 0; i < 10; i++)
        {
            e[i] = d[i];
        }

        for (int j = 10; j < 20; j++)
        {
            int ai[] = d[j - 10];
            int ai1[] = new int[ai.length];
            for (int k = 0; k < ai.length; k++)
            {
                ai1[k] = ai[ai.length - k - 1];
            }

            e[j] = ai1;
        }

    }
}
