// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.gcm;

import android.view.Window;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.gcm:
//            NoticeActivityLocked

class a
    implements Runnable
{

    final NoticeActivityLocked a;

    public void run()
    {
        a.getWindow().clearFlags(128);
        m.a("NoticeActivityLocked", (new StringBuilder()).append("removeFlag(), id").append(hashCode()).toString());
    }

    (NoticeActivityLocked noticeactivitylocked)
    {
        a = noticeactivitylocked;
        super();
    }
}
