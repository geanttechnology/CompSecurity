// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.b;

import e.f.a;
import e.f.d;
import java.util.Set;

// Referenced classes of package e.b:
//            j

public final class i extends RuntimeException
{

    private final Object a;

    public i(Object obj)
    {
        StringBuilder stringbuilder = new StringBuilder("OnError while emitting onNext value: ");
        if (obj != null) goto _L2; else goto _L1
_L1:
        String s = "null";
_L4:
        super(stringbuilder.append(s).toString());
        a = obj;
        return;
_L2:
        if (e.b.j.a.contains(obj.getClass()))
        {
            s = obj.toString();
        } else
        if (obj instanceof String)
        {
            s = (String)obj;
        } else
        if (obj instanceof Enum)
        {
            s = ((Enum)obj).name();
        } else
        {
            String s1 = d.a().b().a(obj);
            s = s1;
            if (s1 == null)
            {
                s = (new StringBuilder()).append(obj.getClass().getName()).append(".class").toString();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final Object a()
    {
        return a;
    }
}
