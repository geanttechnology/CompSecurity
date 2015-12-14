// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;


// Referenced classes of package myobfuscated.v:
//            ag

final class ao
{

    final Class a;
    final ag b;
    private final Class c;

    public ao(Class class1, Class class2, ag ag)
    {
        c = class1;
        a = class2;
        b = ag;
    }

    public final boolean a(Class class1)
    {
        return c.isAssignableFrom(class1);
    }
}
