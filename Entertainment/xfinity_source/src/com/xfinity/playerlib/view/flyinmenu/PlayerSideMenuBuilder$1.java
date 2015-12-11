// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.app.Activity;
import android.view.View;
import com.comcast.cim.android.sideribbon.SlideClosedRequestListener;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            PlayerSideMenuBuilder, PlayerActivityStarter, FlyinMenuOptions

class val.activity
    implements android.view.PlayerSideMenuBuilder._cls1
{

    final PlayerSideMenuBuilder this$0;
    final Activity val$activity;
    final FlyinMenuOptions val$item;
    final SlideClosedRequestListener val$slideClosedRequestListener;

    public void onClick(View view)
    {
        val$slideClosedRequestListener.slideClosed(new PlayerActivityStarter(val$item.getActivity(), val$activity));
    }

    ()
    {
        this$0 = final_playersidemenubuilder;
        val$slideClosedRequestListener = slideclosedrequestlistener;
        val$item = flyinmenuoptions;
        val$activity = Activity.this;
        super();
    }
}
