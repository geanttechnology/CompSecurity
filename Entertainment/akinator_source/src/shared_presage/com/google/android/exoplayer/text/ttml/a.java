// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text.ttml;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

final class a
{

    public final String a;
    public final String b;
    public final boolean c;
    public final long d;
    public final long e;
    private List f;

    private a(String s, String s1, long l, long l1)
    {
        a = s;
        b = s1;
        boolean flag;
        if (s1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        d = l;
        e = l1;
    }

    private SpannableStringBuilder a(long l, SpannableStringBuilder spannablestringbuilder, boolean flag)
    {
        if (c && flag)
        {
            spannablestringbuilder.append(b);
        } else
        {
            if ("br".equals(a) && flag)
            {
                spannablestringbuilder.append('\n');
                return spannablestringbuilder;
            }
            if (!"metadata".equals(a))
            {
                int i;
                if (d == -1L && e == -1L || d <= l && e == -1L || d == -1L && l < e || d <= l && l < e)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    boolean flag2 = "p".equals(a);
                    i = 0;
                    do
                    {
                        int j;
                        if (f == null)
                        {
                            j = 0;
                        } else
                        {
                            j = f.size();
                        }
                        if (i >= j)
                        {
                            break;
                        }
                        if (f == null)
                        {
                            throw new IndexOutOfBoundsException();
                        }
                        a a1 = (a)f.get(i);
                        boolean flag1;
                        if (flag || flag2)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        a1.a(l, spannablestringbuilder, flag1);
                        i++;
                    } while (true);
                    if (flag2)
                    {
                        a(spannablestringbuilder);
                        return spannablestringbuilder;
                    }
                }
            }
        }
        return spannablestringbuilder;
    }

    public static a a(String s)
    {
        return new a(null, s.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -1L, -1L);
    }

    public static a a(String s, long l, long l1)
    {
        return new a(s, null, l, l1);
    }

    private static void a(SpannableStringBuilder spannablestringbuilder)
    {
        int i;
        for (i = spannablestringbuilder.length() - 1; i >= 0 && spannablestringbuilder.charAt(i) == ' '; i--) { }
        if (i >= 0 && spannablestringbuilder.charAt(i) != '\n')
        {
            spannablestringbuilder.append('\n');
        }
    }

    private void a(TreeSet treeset, boolean flag)
    {
        boolean flag2 = "p".equals(a);
        if (flag || flag2)
        {
            if (d != -1L)
            {
                treeset.add(Long.valueOf(d));
            }
            if (e != -1L)
            {
                treeset.add(Long.valueOf(e));
            }
        }
        if (f != null)
        {
            int i = 0;
            while (i < f.size()) 
            {
                a a1 = (a)f.get(i);
                boolean flag1;
                if (flag || flag2)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                a1.a(treeset, flag1);
                i++;
            }
        }
    }

    public final CharSequence a(long l)
    {
        SpannableStringBuilder spannablestringbuilder = a(l, new SpannableStringBuilder(), false);
        int i = spannablestringbuilder.length();
        for (int j = 0; j < i; j++)
        {
            if (spannablestringbuilder.charAt(j) != ' ')
            {
                continue;
            }
            int i1;
            for (i1 = j + 1; i1 < spannablestringbuilder.length() && spannablestringbuilder.charAt(i1) == ' '; i1++) { }
            i1 -= j + 1;
            if (i1 > 0)
            {
                spannablestringbuilder.delete(j, j + i1);
                i -= i1;
            }
        }

        int k = i;
        if (i > 0)
        {
            k = i;
            if (spannablestringbuilder.charAt(0) == ' ')
            {
                spannablestringbuilder.delete(0, 1);
                k = i - 1;
            }
        }
        i = k;
        int j1;
        for (k = 0; k < i - 1; i = j1)
        {
            j1 = i;
            if (spannablestringbuilder.charAt(k) == '\n')
            {
                j1 = i;
                if (spannablestringbuilder.charAt(k + 1) == ' ')
                {
                    spannablestringbuilder.delete(k + 1, k + 2);
                    j1 = i - 1;
                }
            }
            k++;
        }

        k = i;
        if (i > 0)
        {
            k = i;
            if (spannablestringbuilder.charAt(i - 1) == ' ')
            {
                spannablestringbuilder.delete(i - 1, i);
                k = i - 1;
            }
        }
        int k1 = 0;
        for (i = k; k1 < i - 1; i = k)
        {
            k = i;
            if (spannablestringbuilder.charAt(k1) == ' ')
            {
                k = i;
                if (spannablestringbuilder.charAt(k1 + 1) == '\n')
                {
                    spannablestringbuilder.delete(k1, k1 + 1);
                    k = i - 1;
                }
            }
            k1++;
        }

        k = i;
        if (i > 0)
        {
            k = i;
            if (spannablestringbuilder.charAt(i - 1) == '\n')
            {
                spannablestringbuilder.delete(i - 1, i);
                k = i - 1;
            }
        }
        return spannablestringbuilder.subSequence(0, k);
    }

    public final void a(a a1)
    {
        if (f == null)
        {
            f = new ArrayList();
        }
        f.add(a1);
    }

    public final long[] a()
    {
        Object obj = new TreeSet();
        a(((TreeSet) (obj)), false);
        long al[] = new long[((TreeSet) (obj)).size()];
        obj = ((TreeSet) (obj)).iterator();
        for (int i = 0; ((Iterator) (obj)).hasNext(); i++)
        {
            al[i] = ((Long)((Iterator) (obj)).next()).longValue();
        }

        return al;
    }
}
