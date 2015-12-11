// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;


// Referenced classes of package org.simpleframework.xml.d:
//            z, v, g, y, 
//            q, t, ac, h, 
//            j, ag

final class ab
    implements z
{

    public ab()
    {
    }

    public final ag a(Class class1)
    {
        if (class1 == Integer.TYPE)
        {
            return new v();
        }
        if (class1 == Boolean.TYPE)
        {
            return new g();
        }
        if (class1 == Long.TYPE)
        {
            return new y();
        }
        if (class1 == Double.TYPE)
        {
            return new q();
        }
        if (class1 == Float.TYPE)
        {
            return new t();
        }
        if (class1 == Short.TYPE)
        {
            return new ac();
        }
        if (class1 == Byte.TYPE)
        {
            return new h();
        }
        if (class1 == Character.TYPE)
        {
            return new j();
        } else
        {
            return null;
        }
    }
}
