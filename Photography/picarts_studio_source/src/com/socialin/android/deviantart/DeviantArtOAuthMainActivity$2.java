// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.deviantart;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.deviantart:
//            DeviantArtOAuthMainActivity

final class a
    implements TextWatcher
{

    private DeviantArtOAuthMainActivity a;

    public final void afterTextChanged(Editable editable)
    {
        editable = DeviantArtOAuthMainActivity.a(a).getText().toString();
        DeviantArtOAuthMainActivity.a(a, editable);
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        a = deviantartoauthmainactivity;
        super();
    }
}
