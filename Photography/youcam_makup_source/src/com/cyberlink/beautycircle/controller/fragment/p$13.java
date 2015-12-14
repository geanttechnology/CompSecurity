// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.view.View;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements android.view.OnLongClickListener
{

    final p a;

    public boolean onLongClick(View view)
    {
        if (p.q(a) == 3)
        {
            view = a.getActivity();
            if (view instanceof MainActivity)
            {
                ((BaseActivity)view).a(view.getString(m.bc_poweruser_text), 5000);
                Globals.h();
            }
        }
        return false;
    }

    ctivity(p p1)
    {
        a = p1;
        super();
    }
}
