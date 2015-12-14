// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            bo, av

public class aw
{

    private final String a;
    private final String b;
    private final int c;
    private final List d;
    private final av e;
    private final String f;
    private final PanelDataCenter.SourceType g;
    private final String h;
    private final float i;
    private Boolean j;
    private final String k;
    private final List l;

    public aw(String s, String s1, int i1, List list, av av1, String s2, String s3, 
            PanelDataCenter.SourceType sourcetype, float f1, Boolean boolean1, String s4)
    {
        a = s;
        b = s1;
        c = i1;
        d = list;
        e = av1;
        f = s2;
        h = s3;
        g = sourcetype;
        i = f1;
        j = boolean1;
        k = s4;
        l = bo.x(s1);
        MotionControlHelper.e().b(l);
    }

    public String a()
    {
        return a;
    }

    public void a(Boolean boolean1)
    {
        if (j == boolean1)
        {
            return;
        } else
        {
            j = boolean1;
            bo.c(a, boolean1.booleanValue());
            return;
        }
    }

    public int b()
    {
        return c;
    }

    public List c()
    {
        return d;
    }

    public String d()
    {
        if (e == null)
        {
            return null;
        } else
        {
            return av.a(e);
        }
    }

    public String e()
    {
        return f;
    }

    public String f()
    {
        return h;
    }

    public PanelDataCenter.SourceType g()
    {
        return g;
    }

    public Boolean h()
    {
        return j;
    }

    public List i()
    {
        return l;
    }

    public float j()
    {
        return i;
    }

    public String k()
    {
        return k;
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("Palette guid: ").append(a).toString();
        s = (new StringBuilder()).append(s).append(" colorSetGUID: ").append(b).append(" colorCount: ").append(c).toString();
        s = (new StringBuilder()).append(s).append(" patternGUIDs: ").toString();
        for (int i1 = 0; i1 < d.size(); i1++)
        {
            s = (new StringBuilder()).append(s).append(i1).append(")").append(((String)d.get(i1)).toString()).append(" ").toString();
        }

        return s;
    }
}
