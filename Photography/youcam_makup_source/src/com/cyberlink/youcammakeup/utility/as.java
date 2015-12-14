// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.res.Resources;
import android.graphics.Point;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            av, bo, an, ao, 
//            BeautyMode, at

public class as
{

    private final String a;
    private av b;
    private final an c;
    private final String d;
    private final String e;
    private final float f;
    private final PanelDataCenter.SourceType g;
    private Boolean h;
    private final List i;
    private Boolean j;
    private Boolean k;
    private Boolean l;
    private MakeupItemMetadata m;
    private String n;

    as(String s, String s1, String s2, float f1, av av1, an an1, PanelDataCenter.SourceType sourcetype, 
            Boolean boolean1, List list)
    {
        a = s;
        d = s1;
        e = s2;
        f = f1;
        b = av1;
        c = an1;
        g = sourcetype;
        h = boolean1;
        i = list;
        j = Boolean.valueOf(false);
    }

    as(String s, String s1, String s2, float f1, av av1, an an1, PanelDataCenter.SourceType sourcetype, 
            Boolean boolean1, List list, Boolean boolean2, MakeupItemMetadata makeupitemmetadata, Boolean boolean3)
    {
        a = s;
        d = s1;
        e = s2;
        f = f1;
        b = av1;
        c = an1;
        g = sourcetype;
        h = boolean1;
        i = list;
        j = boolean2;
        m = makeupitemmetadata;
        k = boolean3;
        l = Boolean.valueOf(false);
    }

    public String a()
    {
        return a;
    }

    public void a(av av1)
    {
        b = av1;
    }

    public void a(Boolean boolean1)
    {
        l = boolean1;
    }

    public void a(String s)
    {
        n = s;
    }

    public String b()
    {
        if (a != null && a.equals("default_original_looks"))
        {
            return Globals.d().getResources().getString(0x7f0703ce);
        } else
        {
            return av.a(b);
        }
    }

    public void b(Boolean boolean1)
    {
        if (h == boolean1)
        {
            return;
        } else
        {
            h = boolean1;
            bo.a(a, boolean1.booleanValue());
            return;
        }
    }

    public String c()
    {
        return b.o;
    }

    public String d()
    {
        return d;
    }

    public String e()
    {
        return e;
    }

    public PanelDataCenter.SourceType f()
    {
        return g;
    }

    public Boolean g()
    {
        return h;
    }

    public Boolean h()
    {
        return j;
    }

    public Boolean i()
    {
        return l;
    }

    public Boolean j()
    {
        boolean flag;
        if (!m.k())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public MakeupItemMetadata k()
    {
        return m;
    }

    public String l()
    {
        return an.a(c);
    }

    public List m()
    {
        return i;
    }

    public String n()
    {
        return n;
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("").append("GUID: ").append(a).append(" thumbnail: ").append(d).append(" version: ").append(f).append("\n").toString();
        for (Iterator iterator2 = i.iterator(); iterator2.hasNext();)
        {
            ao ao1 = (ao)iterator2.next();
            s = (new StringBuilder()).append(s).append("effetType: ").append(ao1.a().name()).append(" externalPatternGUID: ").append(ao.a(ao1)).append("\n").toString();
            for (Iterator iterator = ao.b(ao1).iterator(); iterator.hasNext();)
            {
                PanelDataCenter.Mask mask = (PanelDataCenter.Mask)iterator.next();
                s = (new StringBuilder()).append(s).append("mask:-> src: ").append(mask.b()).append(" patternId: ").append(mask.a()).append(" order: ").append(mask.B()).append(" eyeleft: ").append(mask.g().toString()).append(" eyetop: ").append(mask.h().toString()).append(" eyeright: ").append(mask.i().toString()).append(" eyebottom: ").append(mask.j().toString()).append("\n").toString();
            }

            for (Iterator iterator1 = ao.c(ao1).iterator(); iterator1.hasNext();)
            {
                at at1 = (at)iterator1.next();
                s = (new StringBuilder()).append(s).append("color: ").append(String.format("FF%02X%02X%02X", new Object[] {
                    at1.a(), at1.b(), at1.c()
                })).append(" intensity: ").append(at1.d()).append("\n").toString();
            }

            String s1 = s;
            if (ao.d(ao1).b() != PanelDataCenter.LipstickProfile.LipstickType.e)
            {
                s1 = (new StringBuilder()).append(s).append("lipstickProfile: ").append(ao.d(ao1).toString()).append("\n").toString();
            }
            s = s1;
            if (ao.e(ao1) > 0)
            {
                s = (new StringBuilder()).append(s1).append("intensity: ").append(ao.e(ao1)).append("\n").toString();
            }
            s = (new StringBuilder()).append(s).append("\n").toString();
        }

        return s;
    }
}
