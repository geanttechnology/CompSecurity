// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import com.smule.android.c.aa;
import com.smule.pianoandroid.a.t;
import com.smule.pianoandroid.data.model.AchievementState;
import com.smule.pianoandroid.e.b;
import com.smule.pianoandroid.magicpiano.ProductListActivity;
import com.smule.pianoandroid.utils.q;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano.a:
//            e

public class f
    implements b
{

    public f()
    {
    }

    public void a(t t1)
    {
        if (t1 == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        List list = e.d();
        list;
        JVM INSTR monitorenter ;
        AchievementState achievementstate;
        for (Iterator iterator = t1.a.iterator(); iterator.hasNext(); q.i(achievementstate.definitionId))
        {
            achievementstate = (AchievementState)iterator.next();
            aa.a(e.c(), (new StringBuilder()).append("adding ").append(achievementstate.definitionId).toString());
        }

        break MISSING_BLOCK_LABEL_86;
        t1;
        list;
        JVM INSTR monitorexit ;
        throw t1;
        list;
        JVM INSTR monitorexit ;
        if (!t1.a.isEmpty())
        {
            ProductListActivity.a(t1.a.size());
        }
        e.e();
        return;
    }
}
