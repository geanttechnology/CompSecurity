// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            n, OpeningTutorialActivity, o, LauncherActivity

class a
    implements android.view..OnClickListener
{

    final n a;

    public void onClick(View view)
    {
        OpeningTutorialActivity.b(a.a).a();
        view = new Intent(a.a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity);
        a.a.startActivity(view);
        a.a.finish();
    }

    cherActivity(n n1)
    {
        a = n1;
        super();
    }
}
