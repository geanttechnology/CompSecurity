// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.controller.activity.MainActivity;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            t

class a
    implements android.view..OnLongClickListener
{

    final t a;

    public boolean onLongClick(View view)
    {
        t.v++;
        if (t.v >= 3)
        {
            t.v = 0;
            view = a.getActivity();
            if (view instanceof MainActivity)
            {
                ((MainActivity)view).v();
            }
        }
        return false;
    }

    Activity(t t1)
    {
        a = t1;
        super();
    }
}
