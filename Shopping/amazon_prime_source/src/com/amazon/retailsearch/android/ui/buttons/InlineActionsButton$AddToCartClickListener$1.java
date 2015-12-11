// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;


// Referenced classes of package com.amazon.retailsearch.android.ui.buttons:
//            InlineActionsButton, AddToCartState

class this._cls1
    implements com.amazon.retailsearch.interaction.ck
{

    final this._cls1 this$1;

    public void error()
    {
        cess._mth000(this._cls1.this).reset();
    }

    public void error(int i, String s, int j)
    {
        cess._mth000(this._cls1.this).update(i, s, j);
    }

    public void success()
    {
        cess._mth000(this._cls1.this).reset(1);
    }

    public void success(int i, String s, int j)
    {
        cess._mth000(this._cls1.this).update(i, s, j);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
