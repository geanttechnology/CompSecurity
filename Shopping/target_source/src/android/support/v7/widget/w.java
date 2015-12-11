// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import java.util.List;

class w
{
    static interface a
    {

        public abstract void a(a.b b1);

        public abstract a.b b(int i, int j, int k);
    }


    final a a;

    public w(a a1)
    {
        a = a1;
    }

    private void a(List list, int i, int j)
    {
        a.b b1 = (a.b)list.get(i);
        a.b b2 = (a.b)list.get(j);
        switch (b2.a)
        {
        default:
            return;

        case 1: // '\001'
            a(list, i, b1, j, b2);
            return;

        case 0: // '\0'
            c(list, i, b1, j, b2);
            return;

        case 2: // '\002'
            b(list, i, b1, j, b2);
            break;
        }
    }

    private int b(List list)
    {
        boolean flag = false;
        for (int i = list.size() - 1; i >= 0; i--)
        {
            if (((a.b)list.get(i)).a == 3)
            {
                if (flag)
                {
                    return i;
                }
            } else
            {
                flag = true;
            }
        }

        return -1;
    }

    private void c(List list, int i, a.b b1, int j, a.b b2)
    {
        byte byte0 = 0;
        if (b1.c < b2.b)
        {
            byte0 = -1;
        }
        int k = byte0;
        if (b1.b < b2.b)
        {
            k = byte0 + 1;
        }
        if (b2.b <= b1.b)
        {
            b1.b = b1.b + b2.c;
        }
        if (b2.b <= b1.c)
        {
            b1.c = b1.c + b2.c;
        }
        b2.b = k + b2.b;
        list.set(i, b2);
        list.set(j, b1);
    }

    void a(List list)
    {
        do
        {
            int i = b(list);
            if (i != -1)
            {
                a(list, i, i + 1);
            } else
            {
                return;
            }
        } while (true);
    }

    void a(List list, int i, a.b b1, int j, a.b b2)
    {
        boolean flag1 = false;
        a.b b3;
        boolean flag;
        int k;
        int l;
        int i1;
        if (b1.b < b1.c)
        {
            if (b2.b == b1.b && b2.c == b1.c - b1.b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (b2.b == b1.c + 1 && b2.c == b1.b - b1.c)
        {
            flag1 = true;
            flag = true;
        } else
        {
            flag = false;
            flag1 = true;
        }
        if (b1.c >= b2.b) goto _L2; else goto _L1
_L1:
        b2.b = b2.b - 1;
_L4:
        if (b1.b <= b2.b)
        {
            b2.b = b2.b + 1;
            b3 = null;
        } else
        if (b1.b < b2.b + b2.c)
        {
            k = b2.b;
            l = b2.c;
            i1 = b1.b;
            b3 = a.b(1, b1.b + 1, (k + l) - i1);
            b2.c = b1.b - b2.b;
        } else
        {
            b3 = null;
        }
        if (flag)
        {
            list.set(i, b2);
            list.remove(j);
            a.a(b1);
        } else
        {
            if (flag1)
            {
                if (b3 != null)
                {
                    if (b1.b > b3.b)
                    {
                        b1.b = b1.b - b3.c;
                    }
                    if (b1.c > b3.b)
                    {
                        b1.c = b1.c - b3.c;
                    }
                }
                if (b1.b > b2.b)
                {
                    b1.b = b1.b - b2.c;
                }
                if (b1.c > b2.b)
                {
                    b1.c = b1.c - b2.c;
                }
            } else
            {
                if (b3 != null)
                {
                    if (b1.b >= b3.b)
                    {
                        b1.b = b1.b - b3.c;
                    }
                    if (b1.c >= b3.b)
                    {
                        b1.c = b1.c - b3.c;
                    }
                }
                if (b1.b >= b2.b)
                {
                    b1.b = b1.b - b2.c;
                }
                if (b1.c >= b2.b)
                {
                    b1.c = b1.c - b2.c;
                }
            }
            list.set(i, b2);
            if (b1.b != b1.c)
            {
                list.set(j, b1);
            } else
            {
                list.remove(j);
            }
            if (b3 != null)
            {
                list.add(i, b3);
                return;
            }
        }
_L5:
        return;
_L2:
        if (b1.c >= b2.b + b2.c) goto _L4; else goto _L3
_L3:
        b2.c = b2.c - 1;
        b1.a = 1;
        b1.c = 1;
        if (b2.c == 0)
        {
            list.remove(j);
            a.a(b2);
            return;
        }
          goto _L5
    }

    void b(List list, int i, a.b b1, int j, a.b b2)
    {
        a.b b4 = null;
        a.b b3;
        if (b1.c < b2.b)
        {
            b2.b = b2.b - 1;
            b3 = null;
        } else
        if (b1.c < b2.b + b2.c)
        {
            b2.c = b2.c - 1;
            b3 = a.b(2, b1.b, 1);
        } else
        {
            b3 = null;
        }
        if (b1.b <= b2.b)
        {
            b2.b = b2.b + 1;
        } else
        if (b1.b < b2.b + b2.c)
        {
            int k = (b2.b + b2.c) - b1.b;
            b4 = a.b(2, b1.b + 1, k);
            b2.c = b2.c - k;
        }
        list.set(j, b1);
        if (b2.c > 0)
        {
            list.set(i, b2);
        } else
        {
            list.remove(i);
            a.a(b2);
        }
        if (b3 != null)
        {
            list.add(i, b3);
        }
        if (b4 != null)
        {
            list.add(i, b4);
        }
    }
}
