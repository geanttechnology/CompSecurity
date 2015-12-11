// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class k extends x
{

    private final f a;
    private final Type b;

    public k(f f1, Type type)
    {
        a = f1;
        b = type;
    }

    public final Object a(a a1)
    {
        if (a1.f() == b.i)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        a1.a();
        for (; a1.e(); arraylist.add(a.a(a1, b))) { }
        a1.b();
        return b.a.d.b.a(arraylist);
    }

    public final void a(c c1, Object obj)
    {
        obj = (b.a.d.b)obj;
        if (obj != null)
        {
            c1.b();
            Object obj1;
            for (obj = ((b.a.d.b) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a.a(obj1, obj1.getClass(), c1))
            {
                obj1 = ((Iterator) (obj)).next();
            }

            c1.c();
            return;
        } else
        {
            c1.f();
            return;
        }
    }
}
