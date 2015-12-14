// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Vector;

public final class fg
    implements fc
{

    private Vector a;
    private ff b;
    private double c;

    public fg()
    {
        a = new Vector();
        b = null;
        c = 0.0D;
    }

    private Vector b(int i, int j)
    {
        Vector vector = new Vector();
        Vector vector1 = c(i, j);
        for (i = 0; i < vector1.size(); i++)
        {
            fh fh1 = (fh)vector1.elementAt(i);
            if (fh1.e())
            {
                vector.addElement(fh1);
            }
        }

        return vector;
    }

    private Vector c(int i)
    {
        Vector vector = new Vector();
        int l = toString().length();
        Vector vector1;
        int j;
        int k;
        if (i > 0)
        {
            j = i - 1;
        } else
        {
            j = i;
        }
        k = i;
        if (i < l)
        {
            k = i + 1;
        }
        vector1 = c(j, k);
        for (i = 0; i < vector1.size(); i++)
        {
            fh fh1 = (fh)vector1.elementAt(i);
            if (fh1.e())
            {
                vector.addElement(fh1);
            }
        }

        return vector;
    }

    private Vector c(int i, int j)
    {
        int k = 0;
        Vector vector = new Vector();
        int l1 = toString().length();
        int l = -1;
        int i1 = -1;
        int k1;
        for (int j1 = 0; k < a.size(); j1 = k1)
        {
            if (i == j1 && j == j1)
            {
                return vector;
            }
            k1 = j1 + d(k).b().length();
            j1 = i1;
            if (i1 == -1)
            {
                j1 = i1;
                if (i < k1)
                {
                    j1 = k;
                }
            }
            i1 = l;
            if (j1 != -1)
            {
                i1 = l;
                if (l == -1)
                {
                    i1 = l;
                    if (j <= k1)
                    {
                        i1 = k;
                    }
                }
            }
            k++;
            l = i1;
            i1 = j1;
        }

        i = l;
        if (l == -1)
        {
            i = l;
            if (j == l1)
            {
                i = a.size() - 1;
            }
        }
        if (i1 == -1 || i == -1)
        {
            return vector;
        }
        for (; i1 <= i; i1++)
        {
            vector.addElement(d(i1));
        }

        return vector;
    }

    private fh d(int i)
    {
        return (fh)a.elementAt(i);
    }

    public final int a()
    {
        int i;
        int k;
        int l;
        i = 0;
        k = 0;
        l = a.size();
        if (l != 0) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        int j = 0;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            k = i;
            if (!d(j).f())
            {
                k = i + 1;
            }
            j++;
            i = k;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final ez a(int i, int j)
    {
        int k = toString().length();
        if (i < 0 || j > k)
        {
            throw new IndexOutOfBoundsException();
        }
        if (j < i)
        {
            throw new IllegalArgumentException("Cursor position end is less than begin");
        }
        Vector vector;
        if (i == j)
        {
            vector = c(i);
        } else
        {
            vector = b(i, j);
        }
        if (vector.isEmpty())
        {
            return new ez(new Vector());
        }
        Vector vector1 = b.a(this, vector);
        for (i = 0; i < a.size(); i++)
        {
            d(i);
            vector.firstElement();
            vector.lastElement();
        }

        return new ez(vector1);
    }

    public final fd a(int i)
    {
        int j;
        int k;
        k = -1;
        j = -1;
_L9:
        if (k == i) goto _L2; else goto _L1
_L1:
        int l = j + 1;
        if (l <= a.size()) goto _L4; else goto _L3
_L3:
        Object obj = null;
_L6:
        return ((fd) (obj));
_L4:
        j = l;
        if (!d(l).f())
        {
            k++;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        fh fh1;
        fh1 = d(j);
        if (j + 1 < a.size() && d(j + 1).f())
        {
            d(j + 1);
        }
        obj = fh1;
        if (j == 0) goto _L6; else goto _L5
_L5:
        obj = fh1;
        if (!d(j - 1).f()) goto _L6; else goto _L7
_L7:
        d(j - 1);
        return fh1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    final fe a(long l, long l1)
    {
        Vector vector;
        int i;
        vector = new Vector();
        i = 0;
_L5:
        if (i >= a.size()) goto _L2; else goto _L1
_L1:
        fh fh1;
        long l2;
        long l3;
        fh1 = d(i);
        l2 = fh1.c();
        l3 = fh1.d();
        if (l2 >= l1 || l3 <= l) goto _L4; else goto _L3
_L3:
        vector.addElement(fh1);
_L6:
        i++;
          goto _L5
_L4:
        if (l2 <= l1) goto _L6; else goto _L2
_L2:
        if (vector.size() > 0 && ((fh)vector.firstElement()).f())
        {
            vector.removeElementAt(0);
        }
        if (vector.size() > 0 && ((fh)vector.lastElement()).f())
        {
            vector.removeElementAt(vector.size() - 1);
        }
        return new fe(vector);
    }

    public final void a(double d1)
    {
        c = d1;
    }

    final void a(ff ff1)
    {
        b = ff1;
    }

    public final void a(fh fh1)
    {
        if (a.size() != 0 && !((fh)a.lastElement()).h() && !fh1.g())
        {
            int i = a.size();
            fh fh2;
            long l;
            if (a.size() == 0)
            {
                l = 0L;
            } else
            if (i == a.size())
            {
                l = d(i - 1).d();
            } else
            {
                l = d(i).c();
            }
            fh2 = new fh(" ", l, l, 0.0D, false, (byte)0);
            a.insertElementAt(fh2, i);
        }
        a.addElement(fh1);
    }

    public final double b()
    {
        return c;
    }

    public final fd b(int i)
    {
        fd fd1;
        Object obj;
        int j;
        j = 0;
        obj = null;
        fd1 = null;
        break MISSING_BLOCK_LABEL_7;
        if (a.size() > 0 && i <= toString().length())
        {
            int k = 0;
            fd1 = obj;
            while (k <= i) 
            {
                fd fd2 = (fd)a.get(j);
                int l = j + 1;
                fd1 = fd2;
                j = l;
                if (fd2 != null)
                {
                    k += fd2.toString().length();
                    fd1 = fd2;
                    j = l;
                }
            }
        }
        return fd1;
    }

    final void c()
    {
        String s1 = System.getProperty("line.separator");
        String s = s1;
        if (s1 == null)
        {
            s = "\n";
        }
        for (int i = 0; i < a.size(); i++)
        {
            fh fh1 = d(i);
            StringBuffer stringbuffer = new StringBuffer(fh1.b());
            int j = 0;
            do
            {
                if (j >= stringbuffer.length())
                {
                    break;
                }
                j = stringbuffer.toString().indexOf("\r\n", j);
                if (j == -1)
                {
                    break;
                }
                stringbuffer.deleteCharAt(j);
                stringbuffer.deleteCharAt(j);
                stringbuffer.insert(j, '\n');
                j++;
            } while (true);
            j = 0;
            do
            {
                if (j >= stringbuffer.length())
                {
                    break;
                }
                j = stringbuffer.toString().indexOf("\n", j);
                if (j == -1)
                {
                    break;
                }
                stringbuffer.deleteCharAt(j);
                stringbuffer.insert(j, s);
                j += s.length();
            } while (true);
            fh1.a(stringbuffer.toString());
        }

    }

    public final String toString()
    {
        if (a.size() == 0)
        {
            return "";
        }
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < a.size(); i++)
        {
            stringbuffer.append(d(i).toString());
        }

        return stringbuffer.toString();
    }
}
