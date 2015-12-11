// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view:
//            QuantitySpinnerView

class this._cls0
    implements android.widget.istener
{

    final QuantitySpinnerView this$0;

    public void onDismiss()
    {
        if (QuantitySpinnerView.b(QuantitySpinnerView.this) != null)
        {
            getSelectedItem().toString();
            QuantitySpinnerView.b(QuantitySpinnerView.this).a();
            al.b(QuantitySpinnerView.this);
        }
    }

    ner()
    {
        this$0 = QuantitySpinnerView.this;
        super();
    }
}
