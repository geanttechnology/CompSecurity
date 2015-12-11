// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import android.text.TextWatcher;
import com.target.ui.util.validation.a.e;

// Referenced classes of package com.target.ui.view.checkout:
//            AltSmsRecipientView

private final class <init>
    implements TextWatcher
{

    final AltSmsRecipientView this$0;
    private boolean wasValid;

    public void afterTextChanged(Editable editable)
    {
        editable = AltSmsRecipientView.c(AltSmsRecipientView.this);
        boolean flag = editable.a();
        if (wasValid != flag)
        {
            a(AltSmsRecipientView.b(AltSmsRecipientView.this).toName, flag);
        }
        AltSmsRecipientView.b(AltSmsRecipientView.this, editable);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = AltSmsRecipientView.c(AltSmsRecipientView.this).isValid;
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ews()
    {
        this$0 = AltSmsRecipientView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
