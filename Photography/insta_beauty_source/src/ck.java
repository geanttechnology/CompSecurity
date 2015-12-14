// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ck
    implements cj
{

    final cg a;
    private final Map b;

    private ck(cg cg)
    {
        a = cg;
        super();
        b = new HashMap();
    }

    ck(cg cg, ch ch)
    {
        this(cg);
    }

    public void a(Intent intent, List list, List list1)
    {
        intent = b;
        intent.clear();
        int k = list.size();
        for (int i = 0; i < k; i++)
        {
            ci ci1 = (ci)list.get(i);
            ci1.b = 0.0F;
            intent.put(ci1.a.activityInfo.packageName, ci1);
        }

        int j = list1.size();
        float f = 1.0F;
        for (j--; j >= 0; j--)
        {
            cl cl1 = (cl)list1.get(j);
            ci ci2 = (ci)intent.get(cl1.a.getPackageName());
            if (ci2 != null)
            {
                float f1 = ci2.b;
                ci2.b = cl1.c * f + f1;
                f = 0.95F * f;
            }
        }

        Collections.sort(list);
    }
}
