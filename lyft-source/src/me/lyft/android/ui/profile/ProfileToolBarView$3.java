// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.profile;

import android.view.View;
import me.lyft.android.common.AppFlow;

// Referenced classes of package me.lyft.android.ui.profile:
//            ProfileToolBarView

class this._cls0
    implements android.view.ToolBarView._cls3
{

    final ProfileToolBarView this$0;

    public void onClick(View view)
    {
        appFlow.goTo(new ofileScreen());
    }

    ofileScreen()
    {
        this$0 = ProfileToolBarView.this;
        super();
    }
}
