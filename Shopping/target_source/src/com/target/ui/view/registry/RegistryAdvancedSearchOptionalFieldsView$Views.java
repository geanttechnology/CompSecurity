// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.registry:
//            RegistryAdvancedSearchOptionalFieldsView

static class  extends a
{

    EditText city;
    CustomErrorViewWrapper cityWrapper;
    EditText email;
    CustomErrorViewWrapper emailWrapper;
    EditText endDate;
    ImageView endDateDatePicker;
    CustomErrorViewWrapper endDateWrapper;
    Spinner registryTypeSpinner;
    CustomErrorViewWrapper registryTypeWrapper;
    EditText startDate;
    ImageView startDateDatePicker;
    CustomErrorViewWrapper startDateWrapper;
    Spinner stateSpinner;
    CustomErrorViewWrapper stateWrapper;

    (View view)
    {
        super(view);
    }
}
