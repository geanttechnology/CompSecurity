// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            ViewAnimationUtils

final class 
    implements android.view.stener
{

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        while (i1 == 0 && j1 == 0 && k1 == 0 && l1 == 0 || i == i1 && j == j1 && k == k1 && l == l1) 
        {
            return;
        }
        view.setY(j1);
        view.animate().y(j);
    }

    ()
    {
    }
}
