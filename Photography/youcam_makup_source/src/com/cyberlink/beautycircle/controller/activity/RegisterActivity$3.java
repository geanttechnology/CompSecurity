// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.view.widgetpool.facebook.LoginButton;
import com.facebook.Session;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a
    implements android.view.r
{

    final RegisterActivity a;

    public void onClick(View view)
    {
label0:
        {
            if (a.i != null)
            {
                view = Session.getActiveSession();
                if (!view.isOpened())
                {
                    break label0;
                }
                RegisterActivity.a(a, view);
            }
            return;
        }
        a.l = true;
        a.i.performClick();
    }

    (RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
