// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import com.cyberlink.you.utility.d;

// Referenced classes of package com.cyberlink.you.activity:
//            AboutPageActivity

class a
    implements android.view.geActivity._cls13
{

    final AboutPageActivity a;

    public void onClick(View view)
    {
        AboutPageActivity.a(a);
        if (AboutPageActivity.b(a) >= 10)
        {
            AboutPageActivity.a(a, 0);
            d.a(AboutPageActivity.c(a), "Enable Debug Mode");
            com.cyberlink.you.activity.AboutPageActivity.d(a);
        }
    }

    (AboutPageActivity aboutpageactivity)
    {
        a = aboutpageactivity;
        super();
    }
}
