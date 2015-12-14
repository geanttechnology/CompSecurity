// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.deviantart;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import com.socialin.android.adapter.b;

// Referenced classes of package com.socialin.android.deviantart:
//            DeviantArtOAuthMainActivity

final class a
    implements TextWatcher
{

    private b a;
    private DeviantArtOAuthMainActivity b;

    public final void afterTextChanged(Editable editable)
    {
        com.socialin.android.deviantart.DeviantArtOAuthMainActivity.b(b, editable.toString());
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        DeviantArtOAuthMainActivity.a(b, a.b);
        a.b = DeviantArtOAuthMainActivity.d(b).getSelectionStart();
    }

    (DeviantArtOAuthMainActivity deviantartoauthmainactivity, b b1)
    {
        b = deviantartoauthmainactivity;
        a = b1;
        super();
    }
}
