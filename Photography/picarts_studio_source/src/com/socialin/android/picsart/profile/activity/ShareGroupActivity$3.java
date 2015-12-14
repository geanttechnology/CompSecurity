// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.support.v7.widget.SearchView;
import android.view.View;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            ShareGroupActivity

final class a
    implements android.support.v7.widget.tListener
{

    private View a;
    private ShareGroupActivity b;

    public final boolean onQueryTextChange(String s)
    {
        View view = a;
        byte byte0;
        if ("".equals(s) || s.trim().length() == 0)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        ShareGroupActivity.a(b, s);
        return false;
    }

    public final boolean onQueryTextSubmit(String s)
    {
        ShareGroupActivity.b(b).clearFocus();
        return false;
    }

    (ShareGroupActivity sharegroupactivity, View view)
    {
        b = sharegroupactivity;
        a = view;
        super();
    }
}
