// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ap;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class a
{

    public final Class a;
    public final Type b;
    private int c;

    protected a()
    {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        } else
        {
            b = com.millennialmedia.google.gson.internal..Gson.Types.a(((ParameterizedType)type).getActualTypeArguments()[0]);
            a = com.millennialmedia.google.gson.internal..Gson.Types.b(b);
            c = b.hashCode();
            return;
        }
    }

    public a(Type type)
    {
        b = com.millennialmedia.google.gson.internal..Gson.Types.a((Type)com.appboy.ui.AppboyFeedFragment._cls5.a(type));
        a = com.millennialmedia.google.gson.internal..Gson.Types.b(b);
        c = b.hashCode();
    }

    public static a a(Type type)
    {
        return new a(type);
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof a) && com.millennialmedia.google.gson.internal..Gson.Types.a(b, ((a)obj).b);
    }

    public final int hashCode()
    {
        return c;
    }

    public final String toString()
    {
        return com.millennialmedia.google.gson.internal..Gson.Types.c(b);
    }
}
