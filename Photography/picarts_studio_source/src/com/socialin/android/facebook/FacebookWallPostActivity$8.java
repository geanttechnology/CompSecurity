// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.view.View;
import android.widget.CheckBox;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookWallPostActivity

final class b
    implements android.view.llPostActivity._cls8
{

    private View a;
    private boolean b;
    private FacebookWallPostActivity c;

    public final void onClick(View view)
    {
        int i = 0;
        boolean flag1 = FacebookWallPostActivity.e(c).isChecked();
        view = FacebookWallPostActivity.e(c);
        boolean flag;
        if (!flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
        view = a;
        if (!b || flag1)
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    (FacebookWallPostActivity facebookwallpostactivity, View view, boolean flag)
    {
        c = facebookwallpostactivity;
        a = view;
        b = flag;
        super();
    }
}
