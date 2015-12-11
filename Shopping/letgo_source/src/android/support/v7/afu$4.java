// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.lang.reflect.Type;

// Referenced classes of package android.support.v7:
//            afz, afu, agc

class b
    implements afz
{

    final Class a;
    final Type b;
    final afu c;
    private final agc d = agc.a();

    public Object a()
    {
        Object obj;
        try
        {
            obj = d.a(a);
        }
        catch (Exception exception)
        {
            throw new RuntimeException((new StringBuilder()).append("Unable to invoke no-args constructor for ").append(b).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
        }
        return obj;
    }

    n(afu afu1, Class class1, Type type)
    {
        c = afu1;
        a = class1;
        b = type;
        super();
    }
}
