// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import java.io.Serializable;

public abstract class com.google.a.a.b
{
    public static final class a extends com.google.a.a.b
        implements Serializable
    {

        public static final a a = new a();

        protected final int b(Object obj)
        {
            return obj.hashCode();
        }

        protected final boolean b(Object obj, Object obj1)
        {
            return obj.equals(obj1);
        }


        a()
        {
        }
    }

    public static final class b extends com.google.a.a.b
        implements Serializable
    {

        public static final b a = new b();

        protected final int b(Object obj)
        {
            return System.identityHashCode(obj);
        }

        protected final boolean b(Object obj, Object obj1)
        {
            return false;
        }


        b()
        {
        }
    }


    protected com.google.a.a.b()
    {
    }

    public final int a(Object obj)
    {
        if (obj == null)
        {
            return 0;
        } else
        {
            return b(obj);
        }
    }

    public final boolean a(Object obj, Object obj1)
    {
        if (obj == obj1)
        {
            return true;
        }
        if (obj == null || obj1 == null)
        {
            return false;
        } else
        {
            return b(obj, obj1);
        }
    }

    protected abstract int b(Object obj);

    protected abstract boolean b(Object obj, Object obj1);
}
