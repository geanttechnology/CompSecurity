// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            BottomBarFragment

class a
    implements android.view.ner
{

    final BottomBarFragment a;

    public boolean onLongClick(View view)
    {
        if (BottomBarFragment.b >= 3)
        {
            BottomBarFragment.b++;
            if (BottomBarFragment.b == 6)
            {
                view = a.getActivity();
                if (view instanceof MainActivity)
                {
                    Globals.g();
                    ((BaseActivity)view).a(a.getString(m.bc_developmode_text), 5000);
                    ((MainActivity)view).c(null);
                }
            }
            return false;
        } else
        {
            BottomBarFragment.b = 0;
            return false;
        }
    }

    I(BottomBarFragment bottombarfragment)
    {
        a = bottombarfragment;
        super();
    }
}
