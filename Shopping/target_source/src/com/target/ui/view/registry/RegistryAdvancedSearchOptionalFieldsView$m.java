// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.view.View;
import android.widget.AdapterView;
import com.target.ui.util.validation.a.j;

// Referenced classes of package com.target.ui.view.registry:
//            RegistryAdvancedSearchOptionalFieldsView

private final class <init>
    implements android.widget.FieldsView.m
{

    final RegistryAdvancedSearchOptionalFieldsView this$0;
    private boolean wasAutoSelected;
    private boolean wasValid;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (wasAutoSelected)
        {
            wasAutoSelected = false;
            return;
        }
        adapterview = RegistryAdvancedSearchOptionalFieldsView.f(RegistryAdvancedSearchOptionalFieldsView.this);
        if (i == 0 && wasValid || adapterview.a())
        {
            RegistryAdvancedSearchOptionalFieldsView.a(RegistryAdvancedSearchOptionalFieldsView.this, adapterview);
        }
        wasValid = RegistryAdvancedSearchOptionalFieldsView.f(RegistryAdvancedSearchOptionalFieldsView.this).isValid;
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    private ()
    {
        this$0 = RegistryAdvancedSearchOptionalFieldsView.this;
        super();
        wasAutoSelected = true;
    }

    wasAutoSelected(wasAutoSelected wasautoselected)
    {
        this();
    }
}
