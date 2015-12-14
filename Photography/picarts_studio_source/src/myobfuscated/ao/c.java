// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.internal.j;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.a;
import com.millennialmedia.google.gson.stream.b;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package myobfuscated.ao:
//            o

final class c extends i
{

    private final i a;
    private final j b;

    public c(com.millennialmedia.google.gson.b b1, Type type, i k, j j1)
    {
        a = new o(b1, k, type);
        b = j1;
    }

    public final Object a(a a1)
    {
        if (a1.f() == JsonToken.NULL)
        {
            a1.k();
            return null;
        }
        Collection collection = (Collection)b.a();
        a1.a();
        for (; a1.e(); collection.add(a.a(a1))) { }
        a1.b();
        return collection;
    }

    public final void a(b b1, Object obj)
    {
        obj = (Collection)obj;
        if (obj == null)
        {
            b1.e();
            return;
        }
        b1.a();
        Object obj1;
        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a.a(b1, obj1))
        {
            obj1 = ((Iterator) (obj)).next();
        }

        b1.b();
    }
}
