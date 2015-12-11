// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.account;

import android.widget.EditText;

// Referenced classes of package com.amazon.mShop.account:
//            NonZeroLengthTextWatcher, LoginActivity

private final class  extends NonZeroLengthTextWatcher
{

    final LoginActivity this$0;

    public void update()
    {
        LoginActivity.access$000(LoginActivity.this);
    }

    public (EditText edittext)
    {
        this$0 = LoginActivity.this;
        super(edittext);
    }
}
