// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;


// Referenced classes of package com.google.a.b:
//            f

static abstract class <init> extends Enum
{

    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    static final h i[];
    private static final h j[];

    static <init> a(<init> <init>1, boolean flag, boolean flag1)
    {
        byte byte1 = 0;
        byte byte0;
        boolean flag2;
        if (<init>1 == c)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        if (flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag1)
        {
            byte1 = 2;
        }
        return i[byte1 | (flag2 | byte0)];
    }

    static void a(i k, i l)
    {
        l.a(k.e());
        com.google.a.b.f.a(k.g(), l);
        com.google.a.b.f.a(l, k.f());
        com.google.a.b.f.a(k);
    }

    static void b(f f1, f f2)
    {
        f2.b(f1.h());
        com.google.a.b.f.b(f1.j(), f2);
        com.google.a.b.f.b(f2, f1.i());
        com.google.a.b.f.b(f1);
    }

    public static i valueOf(String s)
    {
        return (i)Enum.valueOf(com/google/a/b/f$d, s);
    }

    public static eOf[] values()
    {
        return (eOf[])j.clone();
    }

    lone a(lone lone, lone lone1, lone lone2)
    {
        return a(lone, lone1.d(), lone1.c(), lone2);
    }

    abstract c a(c c1, Object obj, int k, c c2);

    static 
    {
        a = new f.d("STRONG") {

            final f.n a(f.o o, Object obj, int k, f.n n)
            {
                return new f.t(obj, k, n);
            }

        };
        b = new f.d("STRONG_ACCESS") {

            final f.n a(f.o o, f.n n, f.n n1)
            {
                o = a(o, n, n1);
                a(n, ((f.n) (o)));
                return o;
            }

            final f.n a(f.o o, Object obj, int k, f.n n)
            {
                return new f.r(obj, k, n);
            }

        };
        c = new f.d("STRONG_WRITE") {

            final f.n a(f.o o, f.n n, f.n n1)
            {
                o = a(o, n, n1);
                b(n, o);
                return o;
            }

            final f.n a(f.o o, Object obj, int k, f.n n)
            {
                return new f.v(obj, k, n);
            }

        };
        d = new f.d("STRONG_ACCESS_WRITE") {

            final f.n a(f.o o, f.n n, f.n n1)
            {
                o = a(o, n, n1);
                a(n, ((f.n) (o)));
                b(n, o);
                return o;
            }

            final f.n a(f.o o, Object obj, int k, f.n n)
            {
                return new f.s(obj, k, n);
            }

        };
        e = new f.d("WEAK") {

            final f.n a(f.o o, Object obj, int k, f.n n)
            {
                return new f.ab(o.h, obj, k, n);
            }

        };
        f = new f.d("WEAK_ACCESS") {

            final f.n a(f.o o, f.n n, f.n n1)
            {
                o = a(o, n, n1);
                a(n, ((f.n) (o)));
                return o;
            }

            final f.n a(f.o o, Object obj, int k, f.n n)
            {
                return new f.z(o.h, obj, k, n);
            }

        };
        g = new f.d("WEAK_WRITE") {

            final f.n a(f.o o, f.n n, f.n n1)
            {
                o = a(o, n, n1);
                b(n, o);
                return o;
            }

            final f.n a(f.o o, Object obj, int k, f.n n)
            {
                return new f.ad(o.h, obj, k, n);
            }

        };
        h = new f.d("WEAK_ACCESS_WRITE") {

            final f.n a(f.o o, f.n n, f.n n1)
            {
                o = a(o, n, n1);
                a(n, ((f.n) (o)));
                b(n, o);
                return o;
            }

            final f.n a(f.o o, Object obj, int k, f.n n)
            {
                return new f.aa(o.h, obj, k, n);
            }

        };
        j = (new j[] {
            a, b, c, d, e, f, g, h
        });
        i = (new i[] {
            a, b, c, d, e, f, g, h
        });
    }

    private _cls8(String s, int k)
    {
        super(s, k);
    }

    t>(String s, int k, byte byte0)
    {
        this(s, k);
    }
}
