// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

// Referenced classes of package b.a:
//            a, b

public final class c
{

    public final Map a = new HashMap();
    public final List b = new ArrayList();
    public final List c = new ArrayList();
    public b d;
    public TimeZone e;
    public boolean f;

    public c()
    {
        e = TimeZone.getDefault();
        f = false;
    }

    public final a a(Class class1)
    {
        a a1;
        Object obj;
        obj = (a)a.get(class1);
        a1 = ((a) (obj));
        if (obj != null) goto _L2; else goto _L1
_L1:
        int i;
        a1 = new a(class1);
        a.put(class1, a1);
        obj = b;
        i = ((List) (obj)).size() - 1;
_L6:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((Class)((List) (obj)).get(i)).isAssignableFrom(class1)) goto _L4; else goto _L3
_L3:
        ((List) (obj)).add(i + 1, class1);
_L2:
        return a1;
_L4:
        i--;
        if (true) goto _L6; else goto _L5
_L5:
        ((List) (obj)).add(0, class1);
        return a1;
    }
}
