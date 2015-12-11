// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.b.a;

import java.io.PrintStream;

public final class i
{
    private static final class a extends SecurityManager
    {

        protected final Class[] getClassContext()
        {
            return super.getClassContext();
        }

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }


    private static final a a = new a((byte)0);

    private i()
    {
    }

    public static Class a()
    {
        Class aclass[] = a.getClassContext();
        String s = org/b/a/i.getName();
        int j;
        for (j = 0; j < aclass.length && !s.equals(aclass[j].getName()); j++) { }
        if (j >= aclass.length || j + 2 >= aclass.length)
        {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        } else
        {
            return aclass[j + 2];
        }
    }

    public static final void a(String s)
    {
        System.err.println((new StringBuilder("SLF4J: ")).append(s).toString());
    }

    public static final void a(String s, Throwable throwable)
    {
        System.err.println(s);
        System.err.println("Reported exception:");
        throwable.printStackTrace();
    }

}
