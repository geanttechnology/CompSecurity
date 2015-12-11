// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            br, v, ag, s, 
//            r, aa, n, y

public final class bo extends br
{

    static final int a[][];
    private static final int b[] = {
        6, 8, 10, 12, 14, 16, 20, 24, 44
    };
    private static final int d[] = {
        1, 1, 1, 1
    };
    private static final int e[] = {
        1, 1, 3
    };
    private int c;

    public bo()
    {
        c = -1;
    }

    private static int a(ag ag1)
        throws v
    {
        int j = ag1.b;
        int i;
        for (i = 0; i < j && !ag1.a(i); i++) { }
        if (i == j)
        {
            throw v.a();
        } else
        {
            return i;
        }
    }

    private static int a(int ai[])
        throws v
    {
        int j = 107;
        int k = -1;
        int i1 = a.length;
        for (int i = 0; i < i1; i++)
        {
            int l = a(ai, a[i], 204);
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

    private void a(ag ag1, int i)
        throws v
    {
        int j = c * 10;
        for (i--; j > 0 && i >= 0 && !ag1.a(i); i--)
        {
            j--;
        }

        if (j != 0)
        {
            throw v.a();
        } else
        {
            return;
        }
    }

    private static void a(ag ag1, int i, int j, StringBuffer stringbuffer)
        throws v
    {
        int ai[] = new int[10];
        int ai1[] = new int[5];
        int ai2[] = new int[5];
        while (i < j) 
        {
            a(ag1, i, ai);
            for (int k = 0; k < 5; k++)
            {
                int i1 = k << 1;
                ai1[k] = ai[i1];
                ai2[k] = ai[i1 + 1];
            }

            stringbuffer.append((char)(a(ai1) + 48));
            stringbuffer.append((char)(a(ai2) + 48));
            int l = 0;
            while (l < ai.length) 
            {
                i += ai[l];
                l++;
            }
        }
    }

    private int[] b(ag ag1)
        throws v
    {
        ag1.a();
        int ai[];
        ai = c(ag1, a(ag1), e);
        a(ag1, ai[0]);
        int i = ai[0];
        ai[0] = ag1.b - ai[1];
        ai[1] = ag1.b - i;
        ag1.a();
        return ai;
        Exception exception;
        exception;
        ag1.a();
        throw exception;
    }

    private static int[] c(ag ag1, int i, int ai[])
        throws v
    {
        int k1 = ai.length;
        int ai1[] = new int[k1];
        int l1 = ag1.b;
        int j = i;
        int j1 = 0;
        int i1 = 0;
        int l = i;
        i = j;
        while (l < l1) 
        {
            int k;
            if ((ag1.a(l) ^ i1) != 0)
            {
                ai1[j1] = ai1[j1] + 1;
                k = i1;
                i1 = i;
            } else
            {
                if (j1 == k1 - 1)
                {
                    if (a(ai1, ai, 204) < 107)
                    {
                        return (new int[] {
                            i, l
                        });
                    }
                    k = i + (ai1[0] + ai1[1]);
                    for (i = 2; i < k1; i++)
                    {
                        ai1[i - 2] = ai1[i];
                    }

                    ai1[k1 - 2] = 0;
                    ai1[k1 - 1] = 0;
                    i = j1 - 1;
                } else
                {
                    j1++;
                    k = i;
                    i = j1;
                }
                ai1[i] = 1;
                if (i1 == 0)
                {
                    boolean flag = true;
                    i1 = k;
                    j1 = i;
                    k = ((flag) ? 1 : 0);
                } else
                {
                    boolean flag1 = false;
                    i1 = k;
                    j1 = i;
                    k = ((flag1) ? 1 : 0);
                }
            }
            l++;
            i = i1;
            i1 = k;
        }
        throw v.a();
    }

    public final y a(int i, ag ag1, Hashtable hashtable)
        throws s, v
    {
        int ai1[] = c(ag1, a(ag1), d);
        c = ai1[1] - ai1[0] >> 2;
        a(ag1, ai1[0]);
        int ai[] = b(ag1);
        Object obj = new StringBuffer(20);
        a(ag1, ai1[1], ai[0], ((StringBuffer) (obj)));
        obj = ((StringBuffer) (obj)).toString();
        n n1;
        int j;
        int k;
        if (hashtable != null)
        {
            ag1 = (int[])hashtable.get(r.f);
        } else
        {
            ag1 = null;
        }
        hashtable = ag1;
        if (ag1 == null)
        {
            hashtable = b;
        }
        k = ((String) (obj)).length();
        j = 0;
        if (j >= hashtable.length)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        if (k != hashtable[j]) goto _L2; else goto _L1
_L1:
        j = 1;
_L4:
        if (j == 0)
        {
            throw s.a();
        } else
        {
            ag1 = new aa(ai1[1], i);
            hashtable = new aa(ai[0], i);
            n1 = n.i;
            return new y(((String) (obj)), null, new aa[] {
                ag1, hashtable
            }, n1);
        }
_L2:
        j++;
        break MISSING_BLOCK_LABEL_111;
        j = 0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        int ai[] = {
            3, 1, 1, 1, 3
        };
        int ai1[] = {
            1, 3, 1, 1, 3
        };
        int ai2[] = {
            3, 3, 1, 1, 1
        };
        int ai3[] = {
            3, 1, 3, 1, 1
        };
        int ai4[] = {
            3, 1, 1, 3, 1
        };
        a = (new int[][] {
            new int[] {
                1, 1, 3, 3, 1
            }, ai, ai1, ai2, new int[] {
                1, 1, 3, 1, 3
            }, ai3, new int[] {
                1, 3, 3, 1, 1
            }, new int[] {
                1, 1, 1, 3, 3
            }, ai4, new int[] {
                1, 3, 1, 3, 1
            }
        });
    }
}
