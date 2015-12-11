// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.f;

import com.google.a.a.h;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

// Referenced classes of package com.google.a.f:
//            c

private static abstract class <init> extends Enum
    implements h
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/google/a/f/c$c, s);
    }

    public static eOf[] values()
    {
        return (eOf[])c.clone();
    }

    static 
    {
        a = new c.c("IGNORE_TYPE_VARIABLE_OR_WILDCARD") {

            public final volatile boolean a(Object obj)
            {
                obj = (c)obj;
                return !(((c) (obj)).a instanceof TypeVariable) && !(((c) (obj)).a instanceof WildcardType);
            }

        };
        b = new c.c("INTERFACE_ONLY") {

            public final boolean a(Object obj)
            {
                return com.google.a.f.c.c(((c)obj).a).isInterface();
            }

        };
        c = (new c[] {
            a, b
        });
    }

    private _cls2(String s, int i)
    {
        super(s, i);
    }

    t>(String s, int i, byte byte0)
    {
        this(s, i);
    }
}
