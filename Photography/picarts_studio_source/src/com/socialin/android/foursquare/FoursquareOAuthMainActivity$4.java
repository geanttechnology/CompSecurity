// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.foursquare;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package com.socialin.android.foursquare:
//            FoursquareOAuthMainActivity

final class a
    implements TextWatcher
{

    private FoursquareOAuthMainActivity a;

    public final void afterTextChanged(Editable editable)
    {
        FoursquareOAuthMainActivity.a(a, FoursquareOAuthMainActivity.b(a).getText().toString());
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (FoursquareOAuthMainActivity foursquareoauthmainactivity)
    {
        a = foursquareoauthmainactivity;
        super();
    }
}
