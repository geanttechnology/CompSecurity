// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jeremyfeinstein.slidingmenu.lib;

import android.util.Log;
import android.view.View;

// Referenced classes of package com.jeremyfeinstein.slidingmenu.lib:
//            SlidingMenu

class val.layerType
    implements Runnable
{

    final SlidingMenu this$0;
    final int val$layerType;

    public void run()
    {
        String s = SlidingMenu.access$500();
        StringBuilder stringbuilder = (new StringBuilder()).append("changing layerType. hardware? ");
        boolean flag;
        if (val$layerType == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Log.v(s, stringbuilder.append(flag).toString());
        getContent().setLayerType(val$layerType, null);
        getMenu().setLayerType(val$layerType, null);
        if (getSecondaryMenu() != null)
        {
            getSecondaryMenu().setLayerType(val$layerType, null);
        }
    }

    ()
    {
        this$0 = final_slidingmenu;
        val$layerType = I.this;
        super();
    }
}
