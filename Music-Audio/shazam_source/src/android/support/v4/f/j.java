// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.f;

import java.io.PrintWriter;

public final class j
{

    private static final Object a = new Object();
    private static char b[] = new char[24];

    private static int a(char ac[], int i, char c, int k, boolean flag)
    {
label0:
        {
label1:
            {
                int l;
                if (!flag)
                {
                    l = k;
                    if (i <= 0)
                    {
                        break label0;
                    }
                }
                int j1;
                int k1;
                if (i > 99)
                {
                    int i1 = i / 100;
                    ac[k] = (char)(i1 + 48);
                    l = k + 1;
                    i -= i1 * 100;
                } else
                {
                    l = k;
                }
                if (i <= 9)
                {
                    k1 = l;
                    j1 = i;
                    if (k == l)
                    {
                        break label1;
                    }
                }
                k = i / 10;
                ac[l] = (char)(k + 48);
                k1 = l + 1;
                j1 = i - k * 10;
            }
            ac[k1] = (char)(j1 + 48);
            i = k1 + 1;
            ac[i] = c;
            l = i + 1;
        }
        return l;
    }

    public static void a(long l, long l1, PrintWriter printwriter)
    {
        if (l == 0L)
        {
            printwriter.print("--");
            return;
        } else
        {
            b(l - l1, printwriter);
            return;
        }
    }

    public static void a(long l, PrintWriter printwriter)
    {
        b(l, printwriter);
    }

    private static void b(long l, PrintWriter printwriter)
    {
        int i;
        boolean flag1;
        flag1 = true;
        i = 1;
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        char ac[];
        if (b.length < 0)
        {
            b = new char[0];
        }
        ac = b;
        if (l != 0L)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        ac[0] = '0';
_L1:
        printwriter.print(new String(b, 0, i));
        obj;
        JVM INSTR monitorexit ;
        return;
        boolean flag;
        if (l > 0L)
        {
            c = '+';
        } else
        {
            l = -l;
            c = '-';
        }
        k1 = (int)(l % 1000L);
        i = (int)Math.floor(l / 1000L);
        if (i <= 0x15180)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        k = i / 0x15180;
_L4:
        for (i -= 0x15180 * k; i <= 3600;)
        {
            break MISSING_BLOCK_LABEL_289;
        }

        i1 = i / 3600;
_L3:
        for (i -= i1 * 3600; i <= 60;)
        {
            break MISSING_BLOCK_LABEL_283;
        }

        j1 = i / 60;
        i -= j1 * 60;
_L2:
        ac[0] = c;
        k = a(ac, k, 'd', 1, false);
        if (k != 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = a(ac, i1, 'h', k, flag);
        if (k != 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = a(ac, j1, 'm', k, flag);
        if (k != 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        i = a(ac, k1, 'm', a(ac, i, 's', k, flag), true);
        ac[i] = 's';
        i++;
          goto _L1
        printwriter;
        obj;
        JVM INSTR monitorexit ;
        throw printwriter;
        j1 = 0;
          goto _L2
        i1 = 0;
          goto _L3
        k = 0;
          goto _L4
    }

}
