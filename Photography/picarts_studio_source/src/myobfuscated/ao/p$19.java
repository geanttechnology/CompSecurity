// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.b;
import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.j;
import myobfuscated.ap.a;

// Referenced classes of package myobfuscated.ao:
//            p, q

final class oogle.gson.i
    implements j
{

    public final i a(b b, a a1)
    {
        a1 = a1.a;
        if (!java/lang/Enum.isAssignableFrom(a1) || a1 == java/lang/Enum)
        {
            return null;
        }
        b = a1;
        if (!a1.isEnum())
        {
            b = a1.getSuperclass();
        }
        return new q(b);
    }

    oogle.gson.i()
    {
    }
}
