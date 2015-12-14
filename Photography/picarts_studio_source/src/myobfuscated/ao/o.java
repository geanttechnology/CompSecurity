// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.b;
import com.millennialmedia.google.gson.i;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import myobfuscated.ap.a;

// Referenced classes of package myobfuscated.ao:
//            k

final class o extends i
{

    private final b a;
    private final i b;
    private final Type c;

    o(b b1, i j, Type type)
    {
        a = b1;
        b = j;
        c = type;
    }

    public final Object a(com.millennialmedia.google.gson.stream.a a1)
    {
        return b.a(a1);
    }

    public final void a(com.millennialmedia.google.gson.stream.b b1, Object obj)
    {
        Object obj1;
        i j;
label0:
        {
            j = b;
            Type type = c;
            obj1 = type;
            if (obj == null)
            {
                break label0;
            }
            if (type != java/lang/Object && !(type instanceof TypeVariable))
            {
                obj1 = type;
                if (!(type instanceof Class))
                {
                    break label0;
                }
            }
            obj1 = obj.getClass();
        }
        if (obj1 != c)
        {
            j = a.a(myobfuscated.ap.a.a(((Type) (obj1))));
            obj1 = j;
            if (j instanceof k)
            {
                obj1 = j;
                if (!(b instanceof k))
                {
                    obj1 = b;
                }
            }
        } else
        {
            obj1 = j;
        }
        ((i) (obj1)).a(b1, obj);
    }
}
