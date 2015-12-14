// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.mainViewPager;

import android.view.View;
import sl;

// Referenced classes of package com.pipcamera.activity.mainViewPager:
//            ViewMainPage1

class a
    implements android.view.ener
{

    final ViewMainPage1 a;

    public void onClick(View view)
    {
        if (a.clickerListener != null)
        {
            a.clickerListener.a(view, "item_classic");
        }
    }

    (ViewMainPage1 viewmainpage1)
    {
        a = viewmainpage1;
        super();
    }
}
