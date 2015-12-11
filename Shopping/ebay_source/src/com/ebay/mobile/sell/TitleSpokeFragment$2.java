// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sell:
//            TitleSpokeFragment

class this._cls0
    implements android.view.tener
{

    final TitleSpokeFragment this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (characterCounter.getVisibility() != 0)
        {
            characterCounter.setVisibility(0);
        }
        if (flag)
        {
            int i = 80 - title.getText().toString().length();
            characterCounter.setText(getView().getContext().getResources().getQuantityString(0x7f080011, i, new Object[] {
                Integer.valueOf(i)
            }));
        }
    }

    ()
    {
        this$0 = TitleSpokeFragment.this;
        super();
    }
}
