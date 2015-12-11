// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.util.Pair;
import android.view.View;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewActivity;

// Referenced classes of package com.ebay.mobile.activities:
//            EbnOrderDetailsActivity

class this._cls0
    implements android.view.ilsActivity._cls1
{

    final EbnOrderDetailsActivity this$0;

    public void onClick(View view)
    {
        if (Util.hasNetwork())
        {
            if ((view = ((View) (view.getTag()))) instanceof Pair)
            {
                view = (Pair)view;
                ItemViewActivity.StartActivity(EbnOrderDetailsActivity.this, ((Long)((Pair) (view)).first).longValue(), (String)((Pair) (view)).second, com.ebay.common.on);
                finish();
                return;
            }
        }
    }

    ()
    {
        this$0 = EbnOrderDetailsActivity.this;
        super();
    }
}
