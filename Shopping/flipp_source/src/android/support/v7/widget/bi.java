// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ap;
import android.util.Log;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            av, az

public abstract class bi
{

    public final View a;
    int b;
    int c;
    long d;
    int e;
    int f;
    bi g;
    bi h;
    int i;
    az j;
    private int k;

    public bi(View view)
    {
        b = -1;
        c = -1;
        d = -1L;
        e = -1;
        f = -1;
        g = null;
        h = null;
        k = 0;
        j = null;
        if (view == null)
        {
            throw new IllegalArgumentException("itemView may not be null");
        } else
        {
            a = view;
            return;
        }
    }

    final void a()
    {
        c = -1;
        f = -1;
    }

    final void a(int i1)
    {
        i = i | i1;
    }

    final void a(int i1, int j1)
    {
        i = i & ~j1 | i1 & j1;
    }

    final void a(int i1, boolean flag)
    {
        if (c == -1)
        {
            c = b;
        }
        if (f == -1)
        {
            f = b;
        }
        if (flag)
        {
            f = f + i1;
        }
        b = b + i1;
        if (a.getLayoutParams() != null)
        {
            ((av)a.getLayoutParams()).e = true;
        }
    }

    public final void a(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = k - 1;
        } else
        {
            i1 = k + 1;
        }
        k = i1;
        if (k < 0)
        {
            k = 0;
            Log.e("View", (new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ")).append(this).toString());
        } else
        {
            if (!flag && k == 1)
            {
                i = i | 0x10;
                return;
            }
            if (flag && k == 0)
            {
                i = i & 0xffffffef;
                return;
            }
        }
    }

    final boolean b()
    {
        return (i & 0x80) != 0;
    }

    public final int c()
    {
        if (f == -1)
        {
            return b;
        } else
        {
            return f;
        }
    }

    final boolean d()
    {
        return j != null;
    }

    final void e()
    {
        j.b(this);
    }

    final boolean f()
    {
        return (i & 0x20) != 0;
    }

    final void g()
    {
        i = i & 0xffffffdf;
    }

    final void h()
    {
        i = i & 0xfffffeff;
    }

    final boolean i()
    {
        return (i & 4) != 0;
    }

    final boolean j()
    {
        return (i & 2) != 0;
    }

    final boolean k()
    {
        return (i & 0x40) != 0;
    }

    final boolean l()
    {
        return (i & 1) != 0;
    }

    final boolean m()
    {
        return (i & 8) != 0;
    }

    final boolean n()
    {
        return (i & 0x100) != 0;
    }

    final void o()
    {
        i = 0;
        b = -1;
        c = -1;
        d = -1L;
        f = -1;
        k = 0;
        g = null;
        h = null;
    }

    public final boolean p()
    {
        return (i & 0x10) == 0 && !ap.c(a);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder((new StringBuilder("ViewHolder{")).append(Integer.toHexString(hashCode())).append(" position=").append(b).append(" id=").append(d).append(", oldPos=").append(c).append(", pLpos:").append(f).toString());
        if (d())
        {
            stringbuilder.append(" scrap");
        }
        if (i())
        {
            stringbuilder.append(" invalid");
        }
        if (!l())
        {
            stringbuilder.append(" unbound");
        }
        if (j())
        {
            stringbuilder.append(" update");
        }
        if (m())
        {
            stringbuilder.append(" removed");
        }
        if (b())
        {
            stringbuilder.append(" ignored");
        }
        if (k())
        {
            stringbuilder.append(" changed");
        }
        if (n())
        {
            stringbuilder.append(" tmpDetached");
        }
        if (!p())
        {
            stringbuilder.append((new StringBuilder(" not recyclable(")).append(k).append(")").toString());
        }
        if (a.getParent() == null)
        {
            stringbuilder.append(" no parent");
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
