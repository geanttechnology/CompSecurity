// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.j;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.b;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package myobfuscated.ao:
//            o

public final class a extends i
{

    public static final j a = new j() {

        public final i a(com.millennialmedia.google.gson.b b1, myobfuscated.ap.a a1)
        {
            a1 = a1.b;
            if (!(a1 instanceof GenericArrayType) && (!(a1 instanceof Class) || !((Class)a1).isArray()))
            {
                return null;
            } else
            {
                a1 = com.millennialmedia.google.gson.internal..Gson.Types.d(a1);
                return new a(b1, b1.a(myobfuscated.ap.a.a(a1)), com.millennialmedia.google.gson.internal..Gson.Types.b(a1));
            }
        }

    };
    private final Class b;
    private final i c;

    public a(com.millennialmedia.google.gson.b b1, i j, Class class1)
    {
        c = new o(b1, j, class1);
        b = class1;
    }

    public final Object a(com.millennialmedia.google.gson.stream.a a1)
    {
        if (a1.f() == JsonToken.NULL)
        {
            a1.k();
            return null;
        }
        ArrayList arraylist = new ArrayList();
        a1.a();
        for (; a1.e(); arraylist.add(c.a(a1))) { }
        a1.b();
        a1 = ((com.millennialmedia.google.gson.stream.a) (Array.newInstance(b, arraylist.size())));
        for (int j = 0; j < arraylist.size(); j++)
        {
            Array.set(a1, j, arraylist.get(j));
        }

        return a1;
    }

    public final void a(b b1, Object obj)
    {
        if (obj == null)
        {
            b1.e();
            return;
        }
        b1.a();
        int j = 0;
        for (int k = Array.getLength(obj); j < k; j++)
        {
            Object obj1 = Array.get(obj, j);
            c.a(b1, obj1);
        }

        b1.b();
    }

}
