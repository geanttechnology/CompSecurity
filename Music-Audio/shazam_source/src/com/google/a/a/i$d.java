// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;


// Referenced classes of package com.google.a.a:
//            h, i

static abstract class <init> extends Enum
    implements h
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/google/a/a/i$d, s);
    }

    public static eOf[] values()
    {
        return (eOf[])e.clone();
    }

    static 
    {
        a = new i.d("ALWAYS_TRUE") {

            public final boolean a(Object obj)
            {
                return true;
            }

            public final String toString()
            {
                return "Predicates.alwaysTrue()";
            }

        };
        b = new i.d("ALWAYS_FALSE") {

            public final boolean a(Object obj)
            {
                return false;
            }

            public final String toString()
            {
                return "Predicates.alwaysFalse()";
            }

        };
        c = new i.d("IS_NULL") {

            public final boolean a(Object obj)
            {
                return obj == null;
            }

            public final String toString()
            {
                return "Predicates.isNull()";
            }

        };
        d = new i.d("NOT_NULL") {

            public final boolean a(Object obj)
            {
                return obj != null;
            }

            public final String toString()
            {
                return "Predicates.notNull()";
            }

        };
        e = (new e[] {
            a, b, c, d
        });
    }

    private _cls4(String s, int j)
    {
        super(s, j);
    }

    t>(String s, int j, byte byte0)
    {
        this(s, j);
    }
}
