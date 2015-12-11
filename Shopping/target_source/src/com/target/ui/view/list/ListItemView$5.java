// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.os.Handler;
import android.view.View;
import com.target.ui.util.e.a;
import com.target.ui.view.QuantitySpinnerView;

// Referenced classes of package com.target.ui.view.list:
//            ListItemView

class this._cls0
    implements android.view.ngeListener
{

    final ListItemView this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            a.a(ListItemView.this);
            (new Handler()).postDelayed(new Runnable() {

                final ListItemView._cls5 this$1;

                public void run()
                {
                    mViews.quantitySpinner.performClick();
                }

            
            {
                this$1 = ListItemView._cls5.this;
                super();
            }
            }, 600L);
        }
    }

    _cls1.this._cls1()
    {
        this$0 = ListItemView.this;
        super();
    }
}
