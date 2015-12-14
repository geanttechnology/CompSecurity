// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jivesoftware.smack.util.p;
import org.jivesoftware.smack.util.r;

// Referenced classes of package org.jivesoftware.smack.packet:
//            f, XMPPError

public abstract class e
{

    private static String a = null;
    private static String b = (new StringBuilder()).append(org.jivesoftware.smack.util.p.a(5)).append("-").toString();
    protected static final String c;
    private static long d = 0L;
    private String e;
    private String f;
    private String g;
    private String h;
    private final List i;
    private XMPPError j;

    public e()
    {
        e = a;
        f = null;
        g = null;
        h = null;
        i = new CopyOnWriteArrayList();
        j = null;
    }

    public e(e e1)
    {
        e = a;
        f = null;
        g = null;
        h = null;
        i = new CopyOnWriteArrayList();
        j = null;
        f = e1.q();
        g = e1.r();
        h = e1.s();
        e = e1.e;
        j = e1.j;
        for (e1 = e1.u().iterator(); e1.hasNext(); a((f)e1.next())) { }
    }

    public static void j(String s1)
    {
        a = s1;
    }

    public static String p()
    {
        org/jivesoftware/smack/packet/e;
        JVM INSTR monitorenter ;
        Object obj;
        obj = (new StringBuilder()).append(b);
        long l1 = d;
        d = 1L + l1;
        obj = ((StringBuilder) (obj)).append(Long.toString(l1)).toString();
        org/jivesoftware/smack/packet/e;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    public static String w()
    {
        return c;
    }

    public void a(Collection collection)
    {
        if (collection == null)
        {
            return;
        } else
        {
            i.addAll(collection);
            return;
        }
    }

    public void a(XMPPError xmpperror)
    {
        j = xmpperror;
    }

    public void a(f f1)
    {
        if (f1 == null)
        {
            return;
        } else
        {
            i.add(f1);
            return;
        }
    }

    protected void a(r r1)
    {
        r1.d("id", q());
        r1.d("to", r());
        r1.d("from", s());
    }

    public f c(String s1, String s2)
    {
        if (s2 == null)
        {
            return null;
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext();)
        {
            f f1 = (f)iterator.next();
            if ((s1 == null || s1.equals(f1.a())) && s2.equals(f1.b()))
            {
                return f1;
            }
        }

        return null;
    }

    public String e_()
    {
        return e;
    }

    public boolean equals(Object obj)
    {
        boolean flag1;
        boolean flag2;
        flag1 = true;
        flag2 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag2;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag2;
        if (getClass() != obj.getClass()) goto _L4; else goto _L5
_L5:
        obj = (e)obj;
        if (j == null) goto _L7; else goto _L6
_L6:
        flag = flag2;
        if (!j.equals(((e) (obj)).j)) goto _L4; else goto _L8
_L8:
        if (h == null) goto _L10; else goto _L9
_L9:
        flag = flag2;
        if (!h.equals(((e) (obj)).h)) goto _L4; else goto _L11
_L11:
        flag = flag2;
        if (!i.equals(((e) (obj)).i)) goto _L4; else goto _L12
_L12:
        if (f == null) goto _L14; else goto _L13
_L13:
        flag = flag2;
        if (!f.equals(((e) (obj)).f)) goto _L4; else goto _L15
_L15:
        if (g == null) goto _L17; else goto _L16
_L16:
        flag = flag2;
        if (!g.equals(((e) (obj)).g)) goto _L4; else goto _L18
_L18:
        if (e == null) goto _L20; else goto _L19
_L19:
        flag = flag1;
        if (e.equals(((e) (obj)).e)) goto _L22; else goto _L21
_L21:
        flag = false;
_L22:
        return flag;
_L7:
        if (((e) (obj)).j == null) goto _L8; else goto _L23
_L23:
        return false;
_L10:
        if (((e) (obj)).h == null) goto _L11; else goto _L24
_L24:
        return false;
_L14:
        if (((e) (obj)).f == null) goto _L15; else goto _L25
_L25:
        return false;
_L17:
        if (((e) (obj)).g == null) goto _L18; else goto _L26
_L26:
        return false;
_L20:
        if (((e) (obj)).e != null) goto _L21; else goto _L27
_L27:
        flag = flag1;
          goto _L22
    }

    public abstract CharSequence g();

    public int hashCode()
    {
        int i2 = 0;
        int i1;
        int j1;
        int k1;
        int l1;
        int j2;
        if (e != null)
        {
            i1 = e.hashCode();
        } else
        {
            i1 = 0;
        }
        if (f != null)
        {
            j1 = f.hashCode();
        } else
        {
            j1 = 0;
        }
        if (g != null)
        {
            k1 = g.hashCode();
        } else
        {
            k1 = 0;
        }
        if (h != null)
        {
            l1 = h.hashCode();
        } else
        {
            l1 = 0;
        }
        j2 = i.hashCode();
        if (j != null)
        {
            i2 = j.hashCode();
        }
        return ((l1 + (k1 + (j1 + i1 * 31) * 31) * 31) * 31 + j2) * 31 + i2;
    }

    public void k(String s1)
    {
        f = s1;
    }

    public void l(String s1)
    {
        g = s1;
    }

    public void m(String s1)
    {
        h = s1;
    }

    public String q()
    {
        if ("ID_NOT_AVAILABLE".equals(f))
        {
            return null;
        }
        if (f == null)
        {
            f = p();
        }
        return f;
    }

    public String r()
    {
        return g;
    }

    public String s()
    {
        return h;
    }

    public XMPPError t()
    {
        return j;
    }

    public String toString()
    {
        return g().toString();
    }

    public Collection u()
    {
        this;
        JVM INSTR monitorenter ;
        if (i != null) goto _L2; else goto _L1
_L1:
        List list = Collections.emptyList();
_L4:
        this;
        JVM INSTR monitorexit ;
        return list;
_L2:
        list = Collections.unmodifiableList(new ArrayList(i));
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected CharSequence v()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new r();
        for (Iterator iterator = u().iterator(); iterator.hasNext(); ((r) (obj)).b(((f)iterator.next()).g())) { }
        break MISSING_BLOCK_LABEL_56;
        obj;
        throw obj;
        this;
        JVM INSTR monitorexit ;
        return ((CharSequence) (obj));
    }

    static 
    {
        c = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
    }
}
