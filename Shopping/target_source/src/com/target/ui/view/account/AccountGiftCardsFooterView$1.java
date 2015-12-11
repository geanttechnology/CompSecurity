// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.target.ui.fragment.account.ExternalUrlLauncherImpl;

// Referenced classes of package com.target.ui.view.account:
//            AccountGiftCardsFooterView

class this._cls0 extends ClickableSpan
{

    final AccountGiftCardsFooterView this$0;

    public void onClick(View view)
    {
        (new ExternalUrlLauncherImpl(getContext())).a("https://m-secure.target.com/giftcards/sign-in");
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setUnderlineText(false);
    }

    ()
    {
        this$0 = AccountGiftCardsFooterView.this;
        super();
    }
}
