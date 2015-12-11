// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.target.ui.view.AddActionView;
import com.target.ui.view.a;
import com.target.ui.view.account.AccountGiftCardsFooterView;
import com.target.ui.view.checkout.GiftCardInputView;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountGiftCardsFragment

static class  extends a
{

    AddActionView addActionView;
    View emptyListContainer;
    TextView emptyListPrimaryHint;
    TextView emptyListSecondaryHint;
    TargetErrorView errorView;
    View giftCardInputContainer;
    GiftCardInputView giftCardInputView;
    AccountGiftCardsFooterView giftCardsFooterView;
    ListView listView;

    (View view)
    {
        super(view);
    }
}
