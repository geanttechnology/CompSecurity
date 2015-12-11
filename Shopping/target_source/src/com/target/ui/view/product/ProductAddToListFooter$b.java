// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.RadioButton;

// Referenced classes of package com.target.ui.view.product:
//            ProductAddToListFooter

private class <init>
    implements android.view.r
{

    final ProductAddToListFooter this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            ProductAddToListFooter.b(ProductAddToListFooter.this).radioButton.setChecked(true);
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
