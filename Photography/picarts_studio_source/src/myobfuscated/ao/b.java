// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.j;
import java.util.Collection;
import myobfuscated.ap.a;

// Referenced classes of package myobfuscated.ao:
//            c

public final class b
    implements j
{

    private final com.millennialmedia.google.gson.internal.a a;

    public b(com.millennialmedia.google.gson.internal.a a1)
    {
        a = a1;
    }

    public final i a(com.millennialmedia.google.gson.b b1, a a1)
    {
        java.lang.reflect.Type type = a1.b;
        Class class1 = a1.a;
        if (!java/util/Collection.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            type = com.millennialmedia.google.gson.internal..Gson.Types.a(type, class1);
            return new c(b1, type, b1.a(myobfuscated.ap.a.a(type)), a.a(a1));
        }
    }
}
