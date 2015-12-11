// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.text.Editable;
import com.target.ui.k.b;
import com.target.ui.util.validation.a.k;

// Referenced classes of package com.target.ui.view.common:
//            NameView

private final class <init> extends b
{

    final NameView this$0;
    private boolean wasValid;

    public void a(Editable editable)
    {
        editable = NameView.a(NameView.this);
        NameView.a(NameView.this, editable, wasValid);
        NameView.a(NameView.this, editable);
        NameView.a(NameView.this, NameView.this.a());
    }

    public void a(CharSequence charsequence, int i, int j, int l)
    {
        wasValid = NameView.a(NameView.this).a();
    }

    public void b(CharSequence charsequence, int i, int j, int l)
    {
    }

    private ()
    {
        this$0 = NameView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
