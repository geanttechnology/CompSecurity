// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package w.panzoomview:
//            o, m, d

public final class ViewSetting
{

    private final boolean a;
    private final m b;
    private final d c;
    private final List d;

    private ViewSetting(o o1)
    {
        a = o.a(o1);
        b = o.b(o1);
        c = o.c(o1);
        if (o.d(o1) == null || o.d(o1).isEmpty())
        {
            o1 = Collections.emptyList();
        } else
        {
            o1 = new ArrayList(o.d(o1));
        }
        d = o1;
    }


    public boolean a()
    {
        return a;
    }

    public m b()
    {
        return b;
    }

    public d c()
    {
        return c;
    }

    public List d()
    {
        return d;
    }
}
