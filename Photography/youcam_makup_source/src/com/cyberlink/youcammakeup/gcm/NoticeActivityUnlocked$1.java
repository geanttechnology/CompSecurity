// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.gcm;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.activity.NoticeActivity;

// Referenced classes of package com.cyberlink.youcammakeup.gcm:
//            NoticeActivityUnlocked

class a
    implements android.view.ctivityUnlocked._cls1
{

    final NoticeActivityUnlocked a;

    public void onClick(View view)
    {
        view = new Intent(a.getBaseContext(), com/cyberlink/youcammakeup/activity/NoticeActivity);
        a.startActivity(view);
    }

    (NoticeActivityUnlocked noticeactivityunlocked)
    {
        a = noticeactivityunlocked;
        super();
    }
}
