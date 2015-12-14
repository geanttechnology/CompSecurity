// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.cyberlink.you.activity:
//            AboutPageActivity, LogBrowserActivity

class a
    implements android.view.
{

    final AboutPageActivity a;

    public void onClick(View view)
    {
        view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/LogBrowserActivity);
        view.putExtra("type", com.cyberlink.you.utility.g.toString());
        a.startActivity(view);
    }

    (AboutPageActivity aboutpageactivity)
    {
        a = aboutpageactivity;
        super();
    }
}
