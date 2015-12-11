// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Collection;

// Referenced classes of package com.flurry.sdk:
//            is, jw, iz, ia, 
//            ja, ir

public final class jk
    implements is
{

    private final ja a;

    public jk(ja ja1)
    {
        a = ja1;
    }

    public ir a(ia ia1, jw jw1)
    {
        Type type = jw1.b();
        Class class1 = jw1.a();
        if (!java/util/Collection.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            type = iz.a(type, class1);
            return new a(ia1, type, ia1.a(jw.a(type)), a.a(jw1));
        }
    }

    private class a extends ir
    {

        private final ir a;
        private final jf b;

        public Collection a(jx jx1)
        {
            if (jx1.f() == jy.i)
            {
                jx1.j();
                return null;
            }
            Collection collection = (Collection)b.a();
            jx1.a();
            for (; jx1.e(); collection.add(a.b(jx1))) { }
            jx1.b();
            return collection;
        }

        public volatile void a(jz jz1, Object obj)
        {
            a(jz1, (Collection)obj);
        }

        public void a(jz jz1, Collection collection)
        {
            if (collection == null)
            {
                jz1.f();
                return;
            }
            jz1.b();
            Object obj;
            for (collection = collection.iterator(); collection.hasNext(); a.a(jz1, obj))
            {
                obj = collection.next();
            }

            jz1.c();
        }

        public Object b(jx jx1)
        {
            return a(jx1);
        }

        public a(ia ia1, Type type, ir ir1, jf jf1)
        {
            a = new ju(ia1, ir1, type);
            b = jf1;
        }
    }

}
