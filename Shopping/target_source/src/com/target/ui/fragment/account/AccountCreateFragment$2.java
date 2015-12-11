// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountCreateFragment

class this._cls0 extends ClickableSpan
{

    final AccountCreateFragment this$0;

    public void onClick(View view)
    {
        AccountCreateFragment.a(AccountCreateFragment.this, "file:///android_asset/htmls/terms.html", getString(0x7f090313));
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setUnderlineText(false);
    }

    ()
    {
        this$0 = AccountCreateFragment.this;
        super();
    }
}
