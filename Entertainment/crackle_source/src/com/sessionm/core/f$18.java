// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import com.sessionm.api.AchievementActivity;
import com.sessionm.b.a;
import com.sessionm.net.Request;
import com.sessionm.net.RequestQueue;

// Referenced classes of package com.sessionm.core:
//            f, AchievementImpl

class 
    implements Runnable
{

    final f cM;
    final AchievementActivity db;

    public void run()
    {
        a a1 = a.aG();
        Object obj = (AchievementImpl)db.getAchievement();
        a1.put("achievement_id", (new StringBuilder()).append("").append(((AchievementImpl) (obj)).a()).toString());
        obj = new Request(com.sessionm.net.st.Type.fo, new Object[] {
            cM.F()
        });
        ((Request) (obj)).d(a1);
        cM.M().e(((Request) (obj)));
    }

    ementActivity(f f1, AchievementActivity achievementactivity)
    {
        cM = f1;
        db = achievementactivity;
        super();
    }
}
