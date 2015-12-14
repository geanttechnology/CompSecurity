// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.af;


final class f
{

    final Class a;
    final com.bumptech.glide.load.f b;
    private final Class c;

    public f(Class class1, Class class2, com.bumptech.glide.load.f f1)
    {
        c = class1;
        a = class2;
        b = f1;
    }

    public final boolean a(Class class1, Class class2)
    {
        return c.isAssignableFrom(class1) && class2.isAssignableFrom(a);
    }
}
