// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.groupon.util.Function0;

// Referenced classes of package com.groupon.activity:
//            MyCreditCards

class this._cls0
    implements Function0
{

    final MyCreditCards this$0;

    public void execute()
    {
        byte byte0 = 8;
        if (MyCreditCards.access$400(MyCreditCards.this))
        {
            loadingView.setVisibility(8);
            addCardButton.setEnabled(true);
            if (cardContainer.getChildCount() > 0)
            {
                byte0 = 0;
            }
            cardContainer.setVisibility(byte0);
            if (!MyCreditCards.access$100(MyCreditCards.this))
            {
                savedCardsContainer.setVisibility(byte0);
            }
        }
    }

    ()
    {
        this$0 = MyCreditCards.this;
        super();
    }
}
