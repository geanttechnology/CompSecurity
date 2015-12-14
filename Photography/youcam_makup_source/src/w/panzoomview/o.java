// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package w.panzoomview:
//            ViewSetting, m, d

public final class o
{

    private boolean a;
    private m b;
    private d c;
    private List d;

    public o()
    {
        a = false;
        b = null;
        c = null;
        d = new ArrayList();
    }

    static boolean a(o o1)
    {
        return o1.a;
    }

    static m b(o o1)
    {
        return o1.b;
    }

    static d c(o o1)
    {
        return o1.c;
    }

    static List d(o o1)
    {
        return o1.d;
    }

    public ViewSetting a()
    {
        return new ViewSetting(this, null);
    }

    public o a(d d1)
    {
        d.add(ViewSetting.SettingAction.c);
        c = d1;
        return this;
    }

    public o a(m m)
    {
        d.add(ViewSetting.SettingAction.b);
        b = m;
        return this;
    }
}
