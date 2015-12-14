// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookWallPostActivity

final class a
    implements TextWatcher
{

    private FacebookWallPostActivity a;

    public final void afterTextChanged(Editable editable)
    {
        FacebookWallPostActivity.a(a, FacebookWallPostActivity.c(a).getText().toString());
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (FacebookWallPostActivity facebookwallpostactivity)
    {
        a = facebookwallpostactivity;
        super();
    }
}
