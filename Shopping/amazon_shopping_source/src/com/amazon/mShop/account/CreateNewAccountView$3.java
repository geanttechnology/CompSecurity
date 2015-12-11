// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.account;

import android.content.DialogInterface;
import android.widget.EditText;
import com.amazon.mShop.control.account.NewAccountController;
import com.amazon.mShop.util.ConfigUtils;

// Referenced classes of package com.amazon.mShop.account:
//            CreateNewAccountView

class this._cls0
    implements android.content.Listener
{

    final CreateNewAccountView this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -2)
        {
            CreateNewAccountView.access$500(CreateNewAccountView.this).requestFocus();
        } else
        if (!CreateNewAccountView.access$200(CreateNewAccountView.this).hasServiceCallRunning())
        {
            if (ConfigUtils.isEnabled(CreateNewAccountView.access$900(CreateNewAccountView.this), com.amazon.mShop.android.lib.uires_furigana))
            {
                CreateNewAccountView.access$200(CreateNewAccountView.this).createNewAccount(CreateNewAccountView.access$300(CreateNewAccountView.this).getText().toString(), CreateNewAccountView.access$400(CreateNewAccountView.this).getText().toString(), CreateNewAccountView.access$500(CreateNewAccountView.this).getText().toString(), CreateNewAccountView.access$600(CreateNewAccountView.this).getText().toString(), true, CreateNewAccountView.access$700(CreateNewAccountView.this));
                return;
            } else
            {
                CreateNewAccountView.access$200(CreateNewAccountView.this).createNewAccount(CreateNewAccountView.access$300(CreateNewAccountView.this).getText().toString(), null, CreateNewAccountView.access$500(CreateNewAccountView.this).getText().toString(), CreateNewAccountView.access$600(CreateNewAccountView.this).getText().toString(), true, CreateNewAccountView.access$700(CreateNewAccountView.this));
                return;
            }
        }
    }

    oller()
    {
        this$0 = CreateNewAccountView.this;
        super();
    }
}
