// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.aq;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            TutorialActivity

class a
    implements android.view.r
{

    final TutorialActivity a;

    public void onClick(View view)
    {
        Globals.a();
        b.a(new aq("explore", ""));
    }

    (TutorialActivity tutorialactivity)
    {
        a = tutorialactivity;
        super();
    }
}
