// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ac;


// Referenced classes of package myobfuscated.ac:
//            d

final class f
{

    final d a;
    private final Class b;
    private final Class c;

    f(Class class1, Class class2, d d)
    {
        b = class1;
        c = class2;
        a = d;
    }

    public final boolean a(Class class1, Class class2)
    {
        return b.isAssignableFrom(class1) && class2.isAssignableFrom(c);
    }
}
