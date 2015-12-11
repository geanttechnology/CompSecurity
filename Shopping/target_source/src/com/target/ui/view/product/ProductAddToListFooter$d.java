// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.widget.CompoundButton;
import android.widget.EditText;
import com.target.mothership.util.o;
import com.target.ui.util.e.a;

// Referenced classes of package com.target.ui.view.product:
//            ProductAddToListFooter

private class <init>
    implements android.widget.hangeListener
{

    final ProductAddToListFooter this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        com.target.ui.view.product.ProductAddToListFooter.a(ProductAddToListFooter.this, flag);
        if (flag)
        {
            if (com.target.ui.view.product.ProductAddToListFooter.a(ProductAddToListFooter.this) != null)
            {
                com.target.ui.view.product.ProductAddToListFooter.a(ProductAddToListFooter.this).a();
                com.target.ui.view.product.ProductAddToListFooter.a(ProductAddToListFooter.this).a(o.g(ProductAddToListFooter.b(ProductAddToListFooter.this).editText.getText().toString()));
            }
            ProductAddToListFooter.b(ProductAddToListFooter.this).editText.requestFocus();
            a.c(ProductAddToListFooter.b(ProductAddToListFooter.this).editText);
        }
    }

    private ews()
    {
        this$0 = ProductAddToListFooter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
