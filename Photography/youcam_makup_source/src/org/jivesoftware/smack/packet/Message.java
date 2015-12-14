// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.jivesoftware.smack.util.r;

// Referenced classes of package org.jivesoftware.smack.packet:
//            e, d, c, XMPPError

public class Message extends e
{

    private Type a;
    private String b;
    private String d;
    private Date e;
    private Date f;
    private boolean g;
    private int h;
    private String i;
    private final Set j;
    private final Set k;

    public Message()
    {
        a = Type.a;
        b = null;
        e = null;
        f = null;
        g = false;
        h = 1;
        i = null;
        j = new HashSet();
        k = new HashSet();
    }

    public Message(String s, Type type)
    {
        a = Type.a;
        b = null;
        e = null;
        f = null;
        g = false;
        h = 1;
        i = null;
        j = new HashSet();
        k = new HashSet();
        l(s);
        if (type != null)
        {
            a = type;
        }
    }

    private d n(String s)
    {
        s = p(s);
        for (Iterator iterator = j.iterator(); iterator.hasNext();)
        {
            d d1 = (d)iterator.next();
            if (s.equals(org.jivesoftware.smack.packet.d.b(d1)))
            {
                return d1;
            }
        }

        return null;
    }

    private c o(String s)
    {
        s = p(s);
        for (Iterator iterator = k.iterator(); iterator.hasNext();)
        {
            c c1 = (c)iterator.next();
            if (s.equals(org.jivesoftware.smack.packet.c.b(c1)))
            {
                return c1;
            }
        }

        return null;
    }

    private String p(String s)
    {
        if ("".equals(s))
        {
            s = null;
        }
        String s1;
        if (s == null && d != null)
        {
            s1 = d;
        } else
        {
            s1 = s;
            if (s == null)
            {
                return w();
            }
        }
        return s1;
    }

    public String a(String s)
    {
        s = n(s);
        if (s == null)
        {
            return null;
        } else
        {
            return org.jivesoftware.smack.packet.d.a(s);
        }
    }

    public d a(String s, String s1)
    {
        s = new d(p(s), s1, null);
        j.add(s);
        return s;
    }

    public void a(int i1)
    {
        h = i1;
    }

    public void a(Date date)
    {
        e = date;
    }

    public void a(Type type)
    {
        if (type == null)
        {
            throw new IllegalArgumentException("Type cannot be null.");
        } else
        {
            a = type;
            return;
        }
    }

    public void a(boolean flag)
    {
        g = flag;
    }

    public c b(String s, String s1)
    {
        s = new c(p(s), s1, null);
        k.add(s);
        return s;
    }

    public void b(String s)
    {
        if (s == null)
        {
            c("");
            return;
        } else
        {
            a(null, s);
            return;
        }
    }

    public void b(Date date)
    {
        f = date;
    }

    public Type c()
    {
        return a;
    }

    public boolean c(String s)
    {
        s = p(s);
        for (Iterator iterator = j.iterator(); iterator.hasNext();)
        {
            d d1 = (d)iterator.next();
            if (s.equals(org.jivesoftware.smack.packet.d.b(d1)))
            {
                return j.remove(d1);
            }
        }

        return false;
    }

    public String d()
    {
        return a(((String) (null)));
    }

    public String d(String s)
    {
        s = o(s);
        if (s == null)
        {
            return null;
        } else
        {
            return org.jivesoftware.smack.packet.c.a(s);
        }
    }

    public Collection e()
    {
        return Collections.unmodifiableCollection(j);
    }

    public void e(String s)
    {
        if (s == null)
        {
            f("");
            return;
        } else
        {
            b(null, s);
            return;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag2;
        boolean flag3;
        flag2 = true;
        flag3 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag3;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag3;
        if (getClass() != obj.getClass()) goto _L4; else goto _L5
_L5:
        obj = (Message)obj;
        flag = flag3;
        if (!super.equals(obj)) goto _L4; else goto _L6
_L6:
        flag = flag3;
        if (k.size() != ((Message) (obj)).k.size()) goto _L4; else goto _L7
_L7:
        flag = flag3;
        if (!k.containsAll(((Message) (obj)).k)) goto _L4; else goto _L8
_L8:
        if (d == null) goto _L10; else goto _L9
_L9:
        flag = flag3;
        if (!d.equals(((Message) (obj)).d)) goto _L4; else goto _L11
_L11:
        flag = flag3;
        if (j.size() != ((Message) (obj)).j.size()) goto _L4; else goto _L12
_L12:
        flag = flag3;
        if (!j.containsAll(((Message) (obj)).j)) goto _L4; else goto _L13
_L13:
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        flag = flag3;
        if (!b.equals(((Message) (obj)).b)) goto _L4; else goto _L14
_L14:
        boolean flag1;
        if (a == ((Message) (obj)).a)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        return flag1;
_L10:
        if (((Message) (obj)).d != null)
        {
            return false;
        }
          goto _L11
        if (((Message) (obj)).b != null)
        {
            return false;
        }
          goto _L14
    }

    public String f()
    {
        return d(null);
    }

    public boolean f(String s)
    {
        s = p(s);
        for (Iterator iterator = k.iterator(); iterator.hasNext();)
        {
            c c1 = (c)iterator.next();
            if (s.equals(org.jivesoftware.smack.packet.c.b(c1)))
            {
                return k.remove(c1);
            }
        }

        return false;
    }

    public CharSequence g()
    {
        return l();
    }

    public void g(String s)
    {
        b = s;
    }

    public Collection h()
    {
        return Collections.unmodifiableCollection(k);
    }

    public void h(String s)
    {
        d = s;
    }

    public int hashCode()
    {
        int k1 = 0;
        int i1;
        int j1;
        int l1;
        if (a != null)
        {
            i1 = a.hashCode();
        } else
        {
            i1 = 0;
        }
        l1 = j.hashCode();
        if (b != null)
        {
            j1 = b.hashCode();
        } else
        {
            j1 = 0;
        }
        if (d != null)
        {
            k1 = d.hashCode();
        }
        return ((j1 + (i1 * 31 + l1) * 31) * 31 + k1) * 31 + k.hashCode();
    }

    public Date i()
    {
        return e;
    }

    public void i(String s)
    {
        i = s;
    }

    public Date j()
    {
        return f;
    }

    public String k()
    {
        return d;
    }

    public r l()
    {
        r r1 = new r();
        r1.a("message");
        r1.d(e_());
        r1.e(k());
        a(r1);
        if (a != Type.a)
        {
            r1.b("type", a);
        }
        if (e != null)
        {
            r1.d("ts", String.valueOf(e.getTime()));
        }
        if (f != null)
        {
            r1.d("st", String.valueOf(f.getTime()));
        }
        r1.d("mv", String.valueOf(o()));
        r1.b();
        Object obj = n(null);
        if (obj != null)
        {
            r1.a("subject", org.jivesoftware.smack.packet.d.a(((d) (obj))));
        }
        Iterator iterator = e().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            d d1 = (d)iterator.next();
            if (!d1.equals(obj))
            {
                r1.a("subject").e(org.jivesoftware.smack.packet.d.b(d1)).b();
                r1.f(org.jivesoftware.smack.packet.d.a(d1));
                r1.c("subject");
            }
        } while (true);
        obj = o(null);
        if (obj != null)
        {
            r1.a("body", org.jivesoftware.smack.packet.c.a(((c) (obj))));
        }
        iterator = h().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            c c1 = (c)iterator.next();
            if (!c1.equals(obj))
            {
                r1.a("body").e(c1.a()).b();
                r1.f(c1.b());
                r1.c("body");
            }
        } while (true);
        r1.b("thread", b);
        if (a == Type.e)
        {
            XMPPError xmpperror = t();
            if (xmpperror != null)
            {
                r1.b(xmpperror.c());
            }
        }
        r1.b(v());
        r1.c("message");
        return r1;
    }

    public String m()
    {
        return i;
    }

    public boolean n()
    {
        return g;
    }

    public int o()
    {
        return h;
    }

    private class Type extends Enum
    {

        public static final Type a;
        public static final Type b;
        public static final Type c;
        public static final Type d;
        public static final Type e;
        private static final Type f[];

        public static Type a(String s)
        {
            try
            {
                s = valueOf(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return a;
            }
            return s;
        }

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(org/jivesoftware/smack/packet/Message$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])f.clone();
        }

        static 
        {
            a = new Type("normal", 0);
            b = new Type("chat", 1);
            c = new Type("groupchat", 2);
            d = new Type("headline", 3);
            e = new Type("error", 4);
            f = (new Type[] {
                a, b, c, d, e
            });
        }

        private Type(String s, int i1)
        {
            super(s, i1);
        }
    }

}
