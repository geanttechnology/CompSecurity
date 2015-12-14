// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            MobileRegisterActivity

class <init>
    implements TextWatcher
{

    final MobileRegisterActivity this$0;

    public void afterTextChanged(Editable editable)
    {
        if (TextUtils.isEmpty(MobileRegisterActivity.access$0(MobileRegisterActivity.this).getText().toString()) || TextUtils.isEmpty(MobileRegisterActivity.access$1(MobileRegisterActivity.this).getText().toString()))
        {
            MobileRegisterActivity.access$2(MobileRegisterActivity.this);
            return;
        } else
        {
            MobileRegisterActivity.access$3(MobileRegisterActivity.this);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = MobileRegisterActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
