// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.b.a;


public final class a
{

    public static a a = new a(null);
    public String b;
    public Throwable c;
    private Object d[];

    public a(String s)
    {
        this(s, null, null);
    }

    public a(String s, Object aobj[], Throwable throwable)
    {
        b = s;
        c = throwable;
        if (throwable == null)
        {
            d = aobj;
            return;
        }
        if (aobj == null || aobj.length == 0)
        {
            throw new IllegalStateException("non-sensical empty or null argument array");
        } else
        {
            int i = aobj.length - 1;
            s = ((String) (new Object[i]));
            System.arraycopy(((Object) (aobj)), 0, s, 0, i);
            d = s;
            return;
        }
    }

}
