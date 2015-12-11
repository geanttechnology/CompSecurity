// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            a, w

static final class it> extends it>
{

    ArrayList a;

    final it> a(it> it>)
    {
        a.add(it>);
        return this;
    }

    final  a(int i)
    {
          = a(i, null);
        if ( != null)
        {
            return ;
        } else
        {
            return new <init>();
        }
    }

    final <init> a(int i, <init> <init>1)
    {
        <init> <init>3 = (<init>)a.get(i);
        <init> <init>2 = <init>1;
        if (<init>3 != null)
        {
            <init>2 = <init>1;
            if (<init>3.l())
            {
                <init>2 = <init>3.m();
            }
        }
        return <init>2;
    }

    final void a(w w1)
    {
        int j = a.size();
        if (j == 0)
        {
            w1.a("[]");
            return;
        }
        if (j == 1 && ((e)a.get(0)).g())
        {
            w1.a("[");
            ((g)a.get(0)).a(w1);
            w1.a("]");
            return;
        }
        w1.b("[");
        w1.b = w1.b + 2;
        int i = 0;
        boolean flag = true;
        while (i < j) 
        {
            if (flag)
            {
                flag = false;
            } else
            {
                w1.b();
            }
            ((a)a.get(i)).a(w1);
            i++;
        }
        w1.b('\n');
        w1.b = w1.b - 2;
        w1.a("]");
    }

    final boolean f()
    {
        return true;
    }

    final boolean g()
    {
        return a.size() == 0 || a.size() == 1 && ((e)a.get(0)).g();
    }

    final g h()
    {
        return this;
    }

    ()
    {
        a = new ArrayList();
    }
}
