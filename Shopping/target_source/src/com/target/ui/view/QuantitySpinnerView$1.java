// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListPopupWindow;

// Referenced classes of package com.target.ui.view:
//            QuantitySpinnerView

class this._cls0
    implements android.widget.kListener
{

    final QuantitySpinnerView this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        setSelection(i);
        QuantitySpinnerView.a(QuantitySpinnerView.this).dismiss();
    }

    tener()
    {
        this$0 = QuantitySpinnerView.this;
        super();
    }
}
