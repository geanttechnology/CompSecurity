// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;


// Referenced classes of package com.sessionm.core:
//            f, AchievementImpl

class 
    implements Runnable
{

    final f cM;
    final boolean cZ;
    final AchievementImpl da;

    public void run()
    {
        if (!cZ && da != null)
        {
            f.a(cM, da);
        }
    }

    vementImpl(f f1, boolean flag, AchievementImpl achievementimpl)
    {
        cM = f1;
        cZ = flag;
        da = achievementimpl;
        super();
    }
}
