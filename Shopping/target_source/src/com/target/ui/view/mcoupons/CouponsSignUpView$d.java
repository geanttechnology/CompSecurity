// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.mcoupons;

import android.text.Editable;
import com.target.ui.k.b;
import com.target.ui.util.validation.a.m;

// Referenced classes of package com.target.ui.view.mcoupons:
//            CouponsSignUpView

private final class <init> extends b
{

    final CouponsSignUpView this$0;
    private boolean wasValid;

    public void a(Editable editable)
    {
        editable = CouponsSignUpView.c(CouponsSignUpView.this);
        if (wasValid != ((m) (editable)).isValid)
        {
            CouponsSignUpView.a(CouponsSignUpView.this, ((m) (editable)).isValid);
        }
        CouponsSignUpView.a(CouponsSignUpView.this, editable);
    }

    public void a(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = CouponsSignUpView.c(CouponsSignUpView.this).isValid;
    }

    public void b(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = CouponsSignUpView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
