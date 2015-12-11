// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.view.View;

// Referenced classes of package com.target.ui.view.cart:
//            SaveForLaterProductView

class this._cls0
    implements android.view.ductView._cls2
{

    final SaveForLaterProductView this$0;

    public void onClick(View view)
    {
        if (SaveForLaterProductView.a(SaveForLaterProductView.this) == null)
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131756429: 
        case 2131756430: 
            SaveForLaterProductView.a(SaveForLaterProductView.this).a(SaveForLaterProductView.b(SaveForLaterProductView.this).image);
            break;
        }
    }

    ews()
    {
        this$0 = SaveForLaterProductView.this;
        super();
    }
}
