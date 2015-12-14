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
    private i b;

    public final i a(b b1, a a1)
    {
        if (a.isAssignableFrom(a1.a))
        {
            return b;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[typeHierarchy=")).append(a.getName()).append(",adapter=").append(b).append("]").toString();
    }

    oogle.gson.i(Class class1, i i)
    {
        a = class1;
        b = i;
        super();
    }
}
