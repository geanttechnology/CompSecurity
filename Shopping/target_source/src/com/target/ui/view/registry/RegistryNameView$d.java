// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.text.Editable;
import com.target.ui.k.b;

// Referenced classes of package com.target.ui.view.registry:
//            RegistryNameView

private final class <init> extends b
{

    final RegistryNameView this$0;

    public void a(Editable editable)
    {
        if (RegistryNameView.a(RegistryNameView.this) == null)
        {
            return;
        } else
        {
            editable = editable.toString();
            RegistryNameView.a(RegistryNameView.this).b(editable);
            return;
        }
    }

    public void a(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void b(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = RegistryNameView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
