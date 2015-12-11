// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;

// Referenced classes of package com.target.ui.view.checkout:
//            AddressFormView

class this._cls0
    implements android.view.Listener
{

    final AddressFormView this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (!flag)
        {
            AddressFormView.a(AddressFormView.this);
        }
    }

    ()
    {
        this$0 = AddressFormView.this;
        super();
    }
}
