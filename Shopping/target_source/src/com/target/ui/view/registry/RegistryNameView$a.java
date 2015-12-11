// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.target.ui.view.registry:
//            RegistryNameView

private final class <init>
    implements android.view.istener
{

    final RegistryNameView this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (RegistryNameView.a(RegistryNameView.this) == null)
        {
            return;
        } else
        {
            view = RegistryNameView.b(RegistryNameView.this).firstName.getText().toString();
            RegistryNameView.a(RegistryNameView.this).a(view, flag);
            return;
        }
    }

    private ews()
    {
        this$0 = RegistryNameView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
