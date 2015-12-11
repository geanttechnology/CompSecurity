// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.b;

import java.lang.reflect.Array;
import org.simpleframework.xml.c.u;
import org.simpleframework.xml.c.y;

// Referenced classes of package org.simpleframework.xml.b:
//            d, b, f, a, 
//            c, g

public final class e
    implements d
{

    private final b a;
    private final String b;
    private final String c;

    public e()
    {
        this("class", "length");
    }

    private e(String s, String s1)
    {
        a = new b();
        b = s1;
        c = s;
    }

    public final g a(f f1, y y1)
    {
        u u1 = y1.b(c);
        Class class2 = f1.C_();
        Class class1 = class2;
        if (class2.isArray())
        {
            class1 = class2.getComponentType();
        }
        if (u1 != null)
        {
            class1 = org.simpleframework.xml.b.b.a(u1.d());
        }
        f1 = f1.C_();
        if (f1.isArray())
        {
            f1 = y1.b(b);
            int i = 0;
            if (f1 != null)
            {
                i = Integer.parseInt(f1.d());
            }
            return new a(class1, i);
        }
        if (f1 != class1)
        {
            return new c(class1);
        } else
        {
            return null;
        }
    }

    public final boolean a(f f1, Object obj, y y1)
    {
        Class class1 = obj.getClass();
        Class class2 = f1.C_();
        if (class1.isArray())
        {
            int i = Array.getLength(obj);
            if (b != null)
            {
                y1.a(b, String.valueOf(i));
            }
            f1 = class2.getComponentType();
        } else
        {
            f1 = class1;
        }
        if (class1 != class2)
        {
            y1.a(c, f1.getName());
        }
        return false;
    }
}
