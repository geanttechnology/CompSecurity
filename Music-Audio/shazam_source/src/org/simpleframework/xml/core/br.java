// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.e.a;
import org.simpleframework.xml.e.b;

// Referenced classes of package org.simpleframework.xml.core:
//            bq

final class br
{
    private final class a
        implements bq
    {

        final br a;
        private Object b;
        private Class c;

        public final Object a()
        {
            if (b == null)
            {
                br br1 = a;
                Class class1 = c;
                Constructor constructor1 = (Constructor)br1.a.a(class1);
                Constructor constructor = constructor1;
                if (constructor1 == null)
                {
                    constructor = class1.getDeclaredConstructor(new Class[0]);
                    if (!constructor.isAccessible())
                    {
                        constructor.setAccessible(true);
                    }
                    br1.a.a(class1, constructor);
                }
                b = constructor.newInstance(new Object[0]);
            }
            return b;
        }

        public final Object a(Object obj)
        {
            b = obj;
            return obj;
        }

        public final Class b()
        {
            return c;
        }

        public final boolean c()
        {
            return false;
        }

        public a(Class class1)
        {
            a = br.this;
            super();
            c = class1;
        }
    }


    final org.simpleframework.xml.e.a a = new b();

    public br()
    {
    }
}
