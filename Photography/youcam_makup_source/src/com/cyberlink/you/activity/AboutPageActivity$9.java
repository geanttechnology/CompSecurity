// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.cyberlink.you.activity:
//            AboutPageActivity, SelectXmppServerActivity

class a
    implements android.view.
{

    final AboutPageActivity a;

    public void onClick(View view)
    {
        view = new Intent(AboutPageActivity.c(a), com/cyberlink/you/activity/SelectXmppServerActivity);
        a.startActivity(view);
    }

    vity(AboutPageActivity aboutpageactivity)
    {
        a = aboutpageactivity;
        super();
    }
}
