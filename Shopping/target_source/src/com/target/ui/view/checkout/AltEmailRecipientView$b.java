// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.target.ui.view.checkout:
//            AltEmailRecipientView

private final class <init>
    implements TextWatcher
{

    final AltEmailRecipientView this$0;
    private boolean wasValid;

    public void afterTextChanged(Editable editable)
    {
        boolean flag = AltEmailRecipientView.a(AltEmailRecipientView.this);
        if (wasValid != flag)
        {
            a(AltEmailRecipientView.b(AltEmailRecipientView.this).email, flag);
        }
        AltEmailRecipientView.a(AltEmailRecipientView.this, flag);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = AltEmailRecipientView.a(AltEmailRecipientView.this);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ews()
    {
        this$0 = AltEmailRecipientView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
