// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.b:
//            o

public class j
{

    private final int a;
    private final int b;
    private final int c;
    private final o d;
    private final Object e = new Object();
    private ArrayList f;
    private int g;
    private int h;
    private int i;
    private int j;
    private String k;

    public j(int l, int i1, int j1, int k1)
    {
        f = new ArrayList();
        g = 0;
        h = 0;
        i = 0;
        k = "";
        a = l;
        b = i1;
        c = j1;
        d = new o(k1);
    }

    private String a(ArrayList arraylist, int l)
    {
        if (arraylist.isEmpty())
        {
            arraylist = "";
        } else
        {
            Object obj = new StringBuffer();
            arraylist = arraylist.iterator();
            do
            {
                if (!arraylist.hasNext())
                {
                    break;
                }
                ((StringBuffer) (obj)).append((String)arraylist.next());
                ((StringBuffer) (obj)).append(' ');
            } while (((StringBuffer) (obj)).length() <= l);
            ((StringBuffer) (obj)).deleteCharAt(((StringBuffer) (obj)).length() - 1);
            obj = ((StringBuffer) (obj)).toString();
            arraylist = ((ArrayList) (obj));
            if (((String) (obj)).length() >= l)
            {
                return ((String) (obj)).substring(0, l);
            }
        }
        return arraylist;
    }

    private void c(String s)
    {
        if (s == null || s.length() < c)
        {
            return;
        }
        synchronized (e)
        {
            f.add(s);
            g = g + s.length();
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    int a(int l, int i1)
    {
        return a * l + b * i1;
    }

    public void a(int l)
    {
        h = l;
    }

    public void a(String s)
    {
        c(s);
        synchronized (e)
        {
            if (i < 0)
            {
                com.google.android.gms.ads.internal.util.client.b.a("ActivityContent: negative number of WebViews.");
            }
            e();
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean a()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String b()
    {
        return k;
    }

    public void b(String s)
    {
        c(s);
    }

    public void c()
    {
        synchronized (e)
        {
            i = i - 1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d()
    {
        synchronized (e)
        {
            i = i + 1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void e()
    {
        synchronized (e)
        {
            int l = a(g, h);
            if (l > j)
            {
                j = l;
                k = d.a(f);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof j)
        {
            if (obj == this)
            {
                return true;
            }
            obj = (j)obj;
            if (((j) (obj)).b() != null && ((j) (obj)).b().equals(b()))
            {
                return true;
            }
        }
        return false;
    }

    int f()
    {
        return g;
    }

    public int hashCode()
    {
        return b().hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("ActivityContent fetchId: ").append(h).append(" score:").append(j).append(" total_length:").append(g).append("\n text: ").append(a(f, 200)).append("\n signture: ").append(k).toString();
    }
}
