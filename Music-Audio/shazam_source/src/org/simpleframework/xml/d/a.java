// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;


// Referenced classes of package org.simpleframework.xml.d:
//            z, i, ad, b, 
//            ag

final class a
    implements z
{

    private final z a;

    public a(z z1)
    {
        a = z1;
    }

    public final ag a(Class class1)
    {
        class1 = class1.getComponentType();
        if (class1 == Character.TYPE)
        {
            return new i(class1);
        }
        if (class1 == java/lang/Character)
        {
            return new i(class1);
        }
        if (class1 == java/lang/String)
        {
            return new ad();
        }
        ag ag = a.a(class1);
        if (ag == null)
        {
            return null;
        } else
        {
            return new b(ag, class1);
        }
    }
}
