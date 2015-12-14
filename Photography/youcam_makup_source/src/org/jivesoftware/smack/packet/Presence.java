// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.r;

// Referenced classes of package org.jivesoftware.smack.packet:
//            e, XMPPError

public class Presence extends e
{

    private Type a;
    private String b;
    private int d;
    private Mode e;
    private String f;

    public Presence(Type type)
    {
        a = Type.a;
        b = null;
        d = 0x80000000;
        e = null;
        a(type);
    }

    public Type a()
    {
        return a;
    }

    public void a(int i)
    {
        if (i < -128 || i > 128)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Priority value ").append(i).append(" is not valid. Valid range is -128 through 128.").toString());
        } else
        {
            d = i;
            return;
        }
    }

    public void a(String s)
    {
        b = s;
    }

    public void a(Mode mode)
    {
        e = mode;
    }

    public void a(Type type)
    {
        if (type == null)
        {
            throw new NullPointerException("Type cannot be null");
        } else
        {
            a = type;
            return;
        }
    }

    public void b(String s)
    {
        f = s;
    }

    public String c()
    {
        return b;
    }

    public Mode d()
    {
        return e;
    }

    public String e()
    {
        return f;
    }

    public r f()
    {
        r r1 = new r();
        r1.a("presence");
        r1.d(e_());
        r1.e(e());
        a(r1);
        if (a != Type.a)
        {
            r1.b("type", a);
        }
        r1.b();
        r1.b("status", b);
        if (d != 0x80000000)
        {
            r1.a("priority", Integer.toString(d));
        }
        if (e != null && e != Mode.b)
        {
            r1.a("show", e);
        }
        r1.b(v());
        XMPPError xmpperror = t();
        if (xmpperror != null)
        {
            r1.b(xmpperror.c());
        }
        r1.c("presence");
        return r1;
    }

    public CharSequence g()
    {
        return f();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(a);
        if (e != null)
        {
            stringbuilder.append(": ").append(e);
        }
        if (c() != null)
        {
            stringbuilder.append(" (").append(c()).append(")");
        }
        return stringbuilder.toString();
    }

    private class Type extends Enum
    {

        public static final Type a;
        public static final Type b;
        public static final Type c;
        public static final Type d;
        public static final Type e;
        public static final Type f;
        public static final Type g;
        private static final Type h[];

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(org/jivesoftware/smack/packet/Presence$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])h.clone();
        }

        static 
        {
            a = new Type("available", 0);
            b = new Type("unavailable", 1);
            c = new Type("subscribe", 2);
            d = new Type("subscribed", 3);
            e = new Type("unsubscribe", 4);
            f = new Type("unsubscribed", 5);
            g = new Type("error", 6);
            h = (new Type[] {
                a, b, c, d, e, f, g
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    /* member class not found */
    class Mode {}

}
