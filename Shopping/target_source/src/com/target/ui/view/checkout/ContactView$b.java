// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import com.target.ui.k.b;

// Referenced classes of package com.target.ui.view.checkout:
//            ContactView

private final class <init> extends b
{

    final ContactView this$0;
    boolean wasValid;

    public void a(Editable editable)
    {
        boolean flag = ContactView.a(ContactView.this);
        if (wasValid != flag)
        {
            ContactView.this.a(com.target.ui.view.checkout.ContactView.b(ContactView.this).email, flag);
        }
        ContactView.this.b(com.target.ui.view.checkout.ContactView.b(ContactView.this).email, flag);
        ContactView.a(ContactView.this, flag);
    }

    public void a(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = ContactView.a(ContactView.this);
    }

    public void b(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ews()
    {
        this$0 = ContactView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
