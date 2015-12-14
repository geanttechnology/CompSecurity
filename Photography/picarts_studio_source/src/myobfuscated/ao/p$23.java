// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.b;
import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.j;
import myobfuscated.ap.a;

// Referenced classes of package myobfuscated.ao:
//            p

final class t>
    implements j
{

    private Class a;
    private Class b;
    private i c;

    public final i a(b b1, a a1)
    {
        b1 = a1.a;
        if (b1 == a || b1 == b)
        {
            return c;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[type=")).append(a.getName()).append("+").append(b.getName()).append(",adapter=").append(c).append("]").toString();
    }

    oogle.gson.i(Class class1, Class class2, i i)
    {
        a = class1;
        b = class2;
        c = i;
        super();
    }
}
