// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;

// Referenced classes of package com.socialin.android.photo.callout:
//            SelectCalloutActivity

final class a
    implements TextWatcher
{

    private SelectCalloutActivity a;

    public final void afterTextChanged(Editable editable)
    {
        editable = SelectCalloutActivity.d(a).getText().toString();
        SelectCalloutActivity.a(a, editable, SelectCalloutActivity.e(a), SelectCalloutActivity.f(a));
        SelectCalloutActivity.a(a, editable);
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (SelectCalloutActivity selectcalloutactivity)
    {
        a = selectcalloutactivity;
        super();
    }
}
