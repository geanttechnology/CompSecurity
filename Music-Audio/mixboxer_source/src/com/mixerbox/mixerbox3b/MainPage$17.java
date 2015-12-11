// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements android.view.Listener
{

    final MainPage this$0;

    public void onClick(View view)
    {
        if (videoState == 1)
        {
            MainPage.access$200(MainPage.this).removeMessages(1);
            MainPage.access$200(MainPage.this).sendEmptyMessageDelayed(1, 4000L);
        }
        if (rlPanelPopup.getVisibility() == 8)
        {
            rlPanelPopup.setVisibility(0);
            btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200d3));
            return;
        } else
        {
            rlPanelPopup.setVisibility(8);
            btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200db));
            return;
        }
    }

    andler()
    {
        this$0 = MainPage.this;
        super();
    }
}
