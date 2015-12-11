// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.target.ui.view.checkout:
//            AltPickUpDetailsView

private final class <init>
    implements TextWatcher
{

    final AltPickUpDetailsView this$0;
    private boolean wasValid;

    public void afterTextChanged(Editable editable)
    {
        boolean flag = AltPickUpDetailsView.b(AltPickUpDetailsView.this);
        if (wasValid != flag)
        {
            a(AltPickUpDetailsView.a(AltPickUpDetailsView.this).emailId, flag);
        }
        AltPickUpDetailsView.a(AltPickUpDetailsView.this, flag);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = AltPickUpDetailsView.b(AltPickUpDetailsView.this);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ews()
    {
        this$0 = AltPickUpDetailsView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
