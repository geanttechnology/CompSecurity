// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.r;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g

class a
    implements android.view.OnClickListener
{

    final g a;

    public void onClick(View view)
    {
label0:
        {
            if (a.p != null)
            {
                b.a(new r(a.p));
            }
            view = a.getActivity();
            if (view instanceof MainActivity)
            {
                if (!view.getPackageName().equals("com.cyberlink.youcammakeup") && !view.getPackageName().equals("com.cyberlink.youperfect"))
                {
                    break label0;
                }
                c.a(view);
            }
            return;
        }
        ((MainActivity)view).f();
    }

    ctivity(g g1)
    {
        a = g1;
        super();
    }
}
