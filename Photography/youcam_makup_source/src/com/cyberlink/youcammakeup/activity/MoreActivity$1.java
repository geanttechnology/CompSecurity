// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            MoreActivity, NoticeActivity

class a
    implements android.view.tener
{

    final MoreActivity a;

    public void onClick(View view)
    {
        MoreActivity.a(a, false);
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/NoticeActivity);
        view.putExtra("previousActivity", "morePage");
        a.startActivity(view);
    }

    (MoreActivity moreactivity)
    {
        a = moreactivity;
        super();
    }
}
