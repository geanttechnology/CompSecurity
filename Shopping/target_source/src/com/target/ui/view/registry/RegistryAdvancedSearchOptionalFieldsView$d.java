// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.target.ui.view.registry:
//            RegistryAdvancedSearchOptionalFieldsView

private final class <init>
    implements TextWatcher
{

    final RegistryAdvancedSearchOptionalFieldsView this$0;
    private boolean wasValid;

    public void afterTextChanged(Editable editable)
    {
        boolean flag = RegistryAdvancedSearchOptionalFieldsView.h(RegistryAdvancedSearchOptionalFieldsView.this);
        RegistryAdvancedSearchOptionalFieldsView.a(RegistryAdvancedSearchOptionalFieldsView.this, flag);
        if (wasValid != flag || RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this) != null)
        {
            RegistryAdvancedSearchOptionalFieldsView.d(RegistryAdvancedSearchOptionalFieldsView.this).a(flag);
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = RegistryAdvancedSearchOptionalFieldsView.h(RegistryAdvancedSearchOptionalFieldsView.this);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
