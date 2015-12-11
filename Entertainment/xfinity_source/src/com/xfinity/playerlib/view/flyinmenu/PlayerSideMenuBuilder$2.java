// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.view.View;
import com.comcast.cim.android.sideribbon.SlideClosedRequestListener;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            PlayerSideMenuBuilder

class 
    implements android.view.PlayerSideMenuBuilder._cls2
{

    final PlayerSideMenuBuilder this$0;
    final SlideClosedRequestListener val$slideClosedRequestListener;

    public void onClick(View view)
    {
        val$slideClosedRequestListener.slideClosed(null);
    }

    ()
    {
        this$0 = final_playersidemenubuilder;
        val$slideClosedRequestListener = SlideClosedRequestListener.this;
        super();
    }
}
