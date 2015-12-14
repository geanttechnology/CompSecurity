// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements android.view.istener
{

    final EditViewActivity a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        for (view = StatusManager.j().s(); view == BeautyMode.v || view == BeautyMode.a || view == BeautyMode.b || view == BeautyMode.m || view == BeautyMode.l || view == BeautyMode.r || view == BeautyMode.n || i1 == 0 && j1 == 0 && k1 == 0 && l1 == 0 || i == i1 && j == j1 && k == k1 && l == l1;)
        {
            return;
        }

        view = a.findViewById(0x1020002);
        a.c(view.getHeight() - j);
    }

    er(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
