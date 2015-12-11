// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.a.g;
import com.google.a.c.ad;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

// Referenced classes of package com.google.a.f:
//            e, a

static abstract class <init> extends Enum
{

    public static final a a;
    public static final a b;
    public static final a c;
    static final a d;
    private static final a e[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/google/a/f/e$c, s);
    }

    public static eOf[] values()
    {
        return (eOf[])e.clone();
    }

    final ad a(Type atype[])
    {
        com.google.a.c.  = ad.g();
        int j = atype.length;
        for (int i = 0; i < j; i++)
        {
            .c(b(atype[i]));
        }

        return .a();
    }

    abstract Type a(Type type);

    abstract Type b(Type type);

    String c(Type type)
    {
        return com.google.a.f.e.b(type);
    }

    static 
    {
        a = new e.c("JAVA6") {

            final Type a(Type type)
            {
                return new e.b(type);
            }

            final Type b(Type type)
            {
                g.a(type);
                Object obj = type;
                if (type instanceof Class)
                {
                    Class class1 = (Class)type;
                    obj = type;
                    if (class1.isArray())
                    {
                        obj = new e.b(class1.getComponentType());
                    }
                }
                return ((Type) (obj));
            }

        };
        b = new e.c("JAVA7") {

            final Type a(Type type)
            {
                if (type instanceof Class)
                {
                    return com.google.a.f.e.a((Class)type);
                } else
                {
                    return new e.b(type);
                }
            }

            final Type b(Type type)
            {
                return (Type)g.a(type);
            }

        };
        c = new e.c("JAVA8") {

            final Type a(Type type)
            {
                return b.a(type);
            }

            final Type b(Type type)
            {
                return b.b(type);
            }

            final String c(Type type)
            {
                try
                {
                    type = (String)java/lang/reflect/Type.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                }
                // Misplaced declaration of an exception variable
                catch (Type type)
                {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                }
                // Misplaced declaration of an exception variable
                catch (Type type)
                {
                    throw new RuntimeException(type);
                }
                // Misplaced declaration of an exception variable
                catch (Type type)
                {
                    throw new RuntimeException(type);
                }
                return type;
            }

        };
        e = (new e[] {
            a, b, c
        });
        if (java/lang/reflect/AnnotatedElement.isAssignableFrom(java/lang/reflect/TypeVariable))
        {
            d = c;
        } else
        if ((new a() {

    }).a() instanceof Class)
        {
            d = b;
        } else
        {
            d = a;
        }
    }

    private _cls4(String s, int i)
    {
        super(s, i);
    }

    t>(String s, int i, byte byte0)
    {
        this(s, i);
    }
}
