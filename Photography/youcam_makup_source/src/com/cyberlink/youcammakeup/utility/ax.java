// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            bo, BeautyMode, av

public class ax
{

    private final String a;
    private final Float b;
    private final BeautyMode c;
    private final PanelDataCenter.SourceType d;
    private Boolean e;
    private final String f;
    private final String g;
    private final String h;
    private final List i;
    private final String j;
    private final PanelDataCenter.LipstickProfile k;
    private final av l;

    public ax(String s, Float float1, BeautyMode beautymode, PanelDataCenter.SourceType sourcetype, Boolean boolean1, String s1, String s2, 
            String s3, List list, String s4, PanelDataCenter.LipstickProfile lipstickprofile, av av)
    {
        a = s;
        b = float1;
        c = beautymode;
        d = sourcetype;
        e = boolean1;
        f = s1;
        g = s2;
        h = s3;
        i = list;
        j = s4;
        k = lipstickprofile;
        l = av;
    }

    public String a()
    {
        return a;
    }

    public void a(Boolean boolean1)
    {
        if (e == boolean1)
        {
            return;
        } else
        {
            e = boolean1;
            bo.b(a, boolean1.booleanValue());
            return;
        }
    }

    public BeautyMode b()
    {
        return c;
    }

    public String c()
    {
        return f;
    }

    public PanelDataCenter.SourceType d()
    {
        return d;
    }

    public Boolean e()
    {
        return e;
    }

    public String f()
    {
        return h;
    }

    public String g()
    {
        return j;
    }

    public PanelDataCenter.LipstickProfile h()
    {
        return k;
    }

    public av i()
    {
        return l;
    }
}
