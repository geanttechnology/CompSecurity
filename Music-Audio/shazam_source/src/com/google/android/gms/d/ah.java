// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.d:
//            am

public final class ah
{

    final Object a = new Object();
    int b;
    int c;
    int d;
    int e;
    public String f;
    private final int g;
    private final int h;
    private final int i;
    private final am j;
    private ArrayList k;

    public ah(int l, int i1, int j1, int k1)
    {
        k = new ArrayList();
        b = 0;
        c = 0;
        d = 0;
        f = "";
        g = l;
        h = i1;
        i = j1;
        j = new am(k1);
    }

    private static String a(ArrayList arraylist)
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
            } while (((StringBuffer) (obj)).length() <= 200);
            ((StringBuffer) (obj)).deleteCharAt(((StringBuffer) (obj)).length() - 1);
            obj = ((StringBuffer) (obj)).toString();
            arraylist = ((ArrayList) (obj));
            if (((String) (obj)).length() >= 200)
            {
                return ((String) (obj)).substring(0, 200);
            }
        }
        return arraylist;
    }

    public final void a(String s)
    {
        b(s);
        synchronized (a)
        {
            if (d < 0)
            {
                com.google.android.gms.ads.internal.util.client.b.a(3);
            }
            c();
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean a()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (d == 0)
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

    public final void b()
    {
        synchronized (a)
        {
            d = d + 1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final void b(String s)
    {
        if (s == null || s.length() < i)
        {
            return;
        }
        synchronized (a)
        {
            k.add(s);
            b = b + s.length();
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void c()
    {
        Object obj1 = a;
        obj1;
        JVM INSTR monitorenter ;
        int l;
        l = b;
        int i1 = c;
        l = l * g + i1 * h;
        if (l <= e) goto _L2; else goto _L1
_L1:
        Object obj;
        StringBuffer stringbuffer;
        e = l;
        obj = j;
        Object obj2 = k;
        stringbuffer = new StringBuffer();
        for (obj2 = ((ArrayList) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); stringbuffer.append('\n'))
        {
            stringbuffer.append(((String)((Iterator) (obj2)).next()).toLowerCase(Locale.US));
        }

          goto _L3
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
_L3:
        ((am) (obj)).a;
        JVM INSTR tableswitch 0 1: default 180
    //                   0 156
    //                   1 168;
           goto _L4 _L5 _L6
_L4:
        break MISSING_BLOCK_LABEL_180;
_L7:
        f = ((String) (obj));
_L2:
        obj1;
        JVM INSTR monitorexit ;
        return;
_L5:
        obj = ((am) (obj)).b(stringbuffer.toString());
          goto _L7
_L6:
        obj = ((am) (obj)).a(stringbuffer.toString());
          goto _L7
        obj = "";
          goto _L7
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof ah)
        {
            if (obj == this)
            {
                return true;
            }
            obj = (ah)obj;
            if (((ah) (obj)).f != null && ((ah) (obj)).f.equals(f))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return f.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("ActivityContent fetchId: ")).append(c).append(" score:").append(e).append(" total_length:").append(b).append("\n text: ").append(a(k)).append("\n signture: ").append(f).toString();
    }
}
