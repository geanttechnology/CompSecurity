// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.merch;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.ebay.mobile.merch:
//            MerchandiseFragment

class this._cls0
    implements android.view.balLayoutListener
{

    final MerchandiseFragment this$0;

    public void onGlobalLayout()
    {
        ViewTreeObserver viewtreeobserver = getView().getViewTreeObserver();
        if (viewtreeobserver.isAlive())
        {
            viewtreeobserver.removeOnGlobalLayoutListener(this);
            MerchandiseFragment.access$100(MerchandiseFragment.this, MerchandiseFragment.access$000(MerchandiseFragment.this), getView());
        }
    }

    Listener()
    {
        this$0 = MerchandiseFragment.this;
        super();
    }
}
