// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.JsonSyntaxException;
import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.internal.j;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.a;
import com.millennialmedia.google.gson.stream.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package myobfuscated.ao:
//            l

public final class k extends i
{

    private final j a;
    private final Map b;

    private k(j j1, Map map)
    {
        a = j1;
        b = map;
    }

    k(j j1, Map map, byte byte0)
    {
        this(j1, map);
    }

    public final Object a(a a1)
    {
        Object obj;
        if (a1.f() == JsonToken.NULL)
        {
            a1.k();
            return null;
        }
        obj = a.a();
        a1.c();
_L1:
        Object obj1;
        if (!a1.e())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        obj1 = a1.h();
        obj1 = (l)b.get(obj1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (((l) (obj1)).c)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        a1.o();
          goto _L1
        try
        {
            ((l) (obj1)).a(a1, obj);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw new JsonSyntaxException(a1);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw new AssertionError(a1);
        }
          goto _L1
        a1.d();
        return obj;
    }

    public final void a(b b1, Object obj)
    {
        if (obj == null)
        {
            b1.e();
            return;
        }
        b1.c();
        try
        {
            Iterator iterator = b.values().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                l l1 = (l)iterator.next();
                if (l1.b)
                {
                    b1.a(l1.a);
                    l1.a(b1, obj);
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            throw new AssertionError();
        }
        b1.d();
    }
}
