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

final class bf
    implements be
{

    final bc a;
    private final Map b;

    private bf(bc bc)
    {
        a = bc;
        super();
        b = new HashMap();
    }

    bf(bc bc, bc._cls1 _pcls1)
    {
        this(bc);
    }

    public void a(Intent intent, List list, List list1)
    {
        intent = b;
        intent.clear();
        int k = list.size();
        for (int i = 0; i < k; i++)
        {
            bd bd1 = (bd)list.get(i);
            bd1.b = 0.0F;
            intent.put(bd1.a.activityInfo.packageName, bd1);
        }

        int j = list1.size();
        float f = 1.0F;
        for (j--; j >= 0; j--)
        {
            bg bg1 = (bg)list1.get(j);
            bd bd2 = (bd)intent.get(bg1.a.getPackageName());
            if (bd2 != null)
            {
                float f1 = bd2.b;
                bd2.b = bg1.c * f + f1;
                f = 0.95F * f;
            }
        }

        Collections.sort(list);
    }
}
