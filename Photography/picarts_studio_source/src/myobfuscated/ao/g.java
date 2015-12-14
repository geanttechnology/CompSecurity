// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.b;
import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.j;
import java.util.Map;
import myobfuscated.ap.a;

// Referenced classes of package myobfuscated.ao:
//            p, h

public final class g
    implements j
{

    final boolean a = false;
    private final com.millennialmedia.google.gson.internal.a b;

    public g(com.millennialmedia.google.gson.internal.a a1, boolean flag)
    {
        b = a1;
    }

    public final i a(b b1, a a1)
    {
        Object obj = a1.b;
        if (!java/util/Map.isAssignableFrom(a1.a))
        {
            return null;
        }
        java.lang.reflect.Type atype[] = com.millennialmedia.google.gson.internal..Gson.Types.b(((java.lang.reflect.Type) (obj)), com.millennialmedia.google.gson.internal..Gson.Types.b(((java.lang.reflect.Type) (obj))));
        obj = atype[0];
        i i;
        if (obj == Boolean.TYPE || obj == java/lang/Boolean)
        {
            obj = p.c;
        } else
        {
            obj = b1.a(myobfuscated.ap.a.a(((java.lang.reflect.Type) (obj))));
        }
        i = b1.a(myobfuscated.ap.a.a(atype[1]));
        a1 = b.a(a1);
        return new h(this, b1, atype[0], ((i) (obj)), atype[1], i, a1);
    }
}
