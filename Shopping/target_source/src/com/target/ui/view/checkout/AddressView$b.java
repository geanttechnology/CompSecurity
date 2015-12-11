// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import com.target.ui.k.b;
import com.target.ui.util.validation.a.a;

// Referenced classes of package com.target.ui.view.checkout:
//            AddressView

private final class <init> extends b
{

    final AddressView this$0;
    private boolean wasValid;

    public void a(Editable editable)
    {
        editable = com.target.ui.view.checkout.AddressView.a(AddressView.this);
        if (wasValid != ((a) (editable)).isValid)
        {
            com.target.ui.view.checkout.AddressView.a(AddressView.this, ((a) (editable)).isValid);
        }
        com.target.ui.view.checkout.AddressView.a(AddressView.this, editable);
    }

    public void a(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = com.target.ui.view.checkout.AddressView.a(AddressView.this).isValid;
    }

    public void b(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = AddressView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
