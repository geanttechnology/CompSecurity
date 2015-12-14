// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.graphics.Rect;
import android.widget.BaseExpandableListAdapter;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            p, u

public abstract class t extends BaseExpandableListAdapter
{

    protected p a;

    public t()
    {
        a = new p(-1, -1);
    }

    public abstract int a(int i);

    public abstract Object a(int i, int j);

    public void a(p p1)
    {
        a = p1;
    }

    public void a(boolean flag)
    {
    }

    public abstract int b(int i);

    public abstract int c(int i);

    public abstract Rect d(int i);

    public abstract u e(int i);

    public Object getGroup(int i)
    {
        return e(i);
    }
}
