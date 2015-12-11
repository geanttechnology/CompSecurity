// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import com.target.mothership.model.cart.b.d;
import com.target.mothership.model.common.GiftCardTender;
import com.target.ui.adapter.checkout.GiftCardAdapter;

// Referenced classes of package com.target.ui.fragment.checkout:
//            GiftCardSelectorDialogFragment

class this._cls0
    implements this._cls0
{

    final GiftCardSelectorDialogFragment this$0;

    public void a()
    {
        dismiss();
    }

    public void b()
    {
        dismiss();
        Object obj = GiftCardSelectorDialogFragment.a(GiftCardSelectorDialogFragment.this).e();
        if (GiftCardSelectorDialogFragment.b(GiftCardSelectorDialogFragment.this) != null && obj != null)
        {
            obj = new d(((GiftCardTender) (obj)).b(), ((GiftCardTender) (obj)).c());
            GiftCardSelectorDialogFragment.b(GiftCardSelectorDialogFragment.this).a(((d) (obj)), GiftCardSelectorDialogFragment.TAG);
        }
    }

    public void c()
    {
        dismiss();
    }

    ()
    {
        this$0 = GiftCardSelectorDialogFragment.this;
        super();
    }
}
