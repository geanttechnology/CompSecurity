// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.instamag.activity.commonview.MagFilterActionBar;

// Referenced classes of package com.instamag.activity.lib:
//            LocalLibFragement

class a
    implements android.view.
{

    final LocalLibFragement a;

    public void onClick(View view)
    {
        if (LocalLibFragement.d(a).getVisibility() == 4)
        {
            LocalLibFragement.d(a).setVisibility(0);
            view = new AlphaAnimation(0.0F, 1.0F);
            view.setDuration(200L);
            LocalLibFragement.d(a).startAnimation(view);
            return;
        } else
        {
            view = new AlphaAnimation(1.0F, 0.0F);
            view.setDuration(200L);
            LocalLibFragement.d(a).startAnimation(view);
            LocalLibFragement.d(a).setVisibility(4);
            return;
        }
    }

    onBar(LocalLibFragement locallibfragement)
    {
        a = locallibfragement;
        super();
    }
}
