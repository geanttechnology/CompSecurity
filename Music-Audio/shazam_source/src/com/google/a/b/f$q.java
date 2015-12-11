// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.a.b;

// Referenced classes of package com.google.a.b:
//            f

static abstract class <init> extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/google/a/b/f$q, s);
    }

    public static eOf[] values()
    {
        return (eOf[])d.clone();
    }

    abstract b a();

    abstract lone a(lone lone, lone lone1, Object obj);

    static 
    {
        a = new f.q("STRONG") {

            final b a()
            {
                return com.google.a.a.b.a.a;
            }

            final f.x a(f.o o, f.n n, Object obj)
            {
                return new f.u(obj);
            }

        };
        b = new f.q("SOFT") {

            final b a()
            {
                return com.google.a.a.b.b.a;
            }

            final f.x a(f.o o, f.n n, Object obj)
            {
                return new f.p(o.i, obj, n);
            }

        };
        c = new f.q("WEAK") {

            final b a()
            {
                return com.google.a.a.b.b.a;
            }

            final f.x a(f.o o, f.n n, Object obj)
            {
                return new f.ac(o.i, obj, n);
            }

        };
        d = (new d[] {
            a, b, c
        });
    }

    private _cls3(String s, int i)
    {
        super(s, i);
    }

    t>(String s, int i, byte byte0)
    {
        this(s, i);
    }
}
