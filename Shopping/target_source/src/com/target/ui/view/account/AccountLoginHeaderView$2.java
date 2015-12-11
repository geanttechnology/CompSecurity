// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

// Referenced classes of package com.target.ui.view.account:
//            AccountLoginHeaderView

class this._cls0 extends ClickableSpan
{

    final AccountLoginHeaderView this$0;

    public void onClick(View view)
    {
        if (AccountLoginHeaderView.a(AccountLoginHeaderView.this) == null)
        {
            return;
        } else
        {
            AccountLoginHeaderView.a(AccountLoginHeaderView.this).a(AccountLoginHeaderView.a(AccountLoginHeaderView.this, 0x7f090058));
            return;
        }
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setUnderlineText(false);
    }

    _cls9()
    {
        this$0 = AccountLoginHeaderView.this;
        super();
    }
}
