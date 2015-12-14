// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.gcm;

import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.gcm:
//            NoticeActivityUnlocked

class a
    implements Runnable
{

    final NoticeActivityUnlocked a;

    public void run()
    {
        m.a("NoticeActivityUnlocked", (new StringBuilder()).append("NoticeActivityTranslucent::autoFinish, id").append(hashCode()).toString());
        a.finish();
    }

    (NoticeActivityUnlocked noticeactivityunlocked)
    {
        a = noticeactivityunlocked;
        super();
    }
}
