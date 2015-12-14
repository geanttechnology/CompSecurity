// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.widgetpool.common.u;
import java.util.List;

public class d extends u
{

    private String e;
    private int f;
    private int g;

    public d(int i, List list, String s, int j, int k)
    {
        super(i, list, 0, 0);
        e = s;
        f = j;
        g = k;
    }

    public aw a(int i)
    {
        return (aw)b().get(i);
    }

    public void a(String s)
    {
        e = s;
    }

    public String f()
    {
        return e;
    }

    public int g()
    {
        return g;
    }
}
