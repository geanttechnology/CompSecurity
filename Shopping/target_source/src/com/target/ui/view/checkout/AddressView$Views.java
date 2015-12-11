// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.checkout:
//            AddressView

static class  extends a
{

    EditText addressLine;
    CustomErrorViewWrapper addressLineWrapper;
    EditText apartmentNumber;
    CustomErrorViewWrapper apartmentNumberWrapper;
    EditText city;
    CustomErrorViewWrapper cityWrapper;
    Spinner stateSpinner;
    CustomErrorViewWrapper stateWrapper;
    EditText zipCode;
    CustomErrorViewWrapper zipCodeWrapper;

    (View view)
    {
        super(view);
    }
}
