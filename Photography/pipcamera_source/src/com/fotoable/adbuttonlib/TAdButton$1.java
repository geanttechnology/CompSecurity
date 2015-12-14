// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.view.View;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.ad.StaticFlurryEvent;
import ew;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdButton, TAdItem

class this._cls0
    implements android.view.Listener
{

    final TAdButton this$0;

    public void onClick(View view)
    {
        TAdItem taditem = TAdButton.access$100(TAdButton.this);
        if (taditem != null)
        {
            TAdButton.access$100(TAdButton.this).handleClick();
            FotoCustomReport.addStringToArray(FotoCustomReport.clickedAdBtnId, taditem.madId);
            if (ew.a())
            {
                view = "CN";
            } else
            {
                view = "EN";
            }
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_icon_click, (new StringBuilder()).append(taditem.madId).append(view).toString());
        }
    }

    ()
    {
        this$0 = TAdButton.this;
        super();
    }
}
