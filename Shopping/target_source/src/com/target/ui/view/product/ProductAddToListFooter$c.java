// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.text.Editable;
import android.text.TextWatcher;
import com.target.mothership.util.o;

// Referenced classes of package com.target.ui.view.product:
//            ProductAddToListFooter

private class <init>
    implements TextWatcher
{

    final ProductAddToListFooter this$0;

    public void afterTextChanged(Editable editable)
    {
        ProductAddToListFooter.a(ProductAddToListFooter.this, editable.toString());
        if (ProductAddToListFooter.a(ProductAddToListFooter.this) == null)
        {
            return;
        } else
        {
            ProductAddToListFooter.a(ProductAddToListFooter.this).a(o.g(ProductAddToListFooter.c(ProductAddToListFooter.this).trim()));
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private _cls9()
    {
        this$0 = ProductAddToListFooter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
