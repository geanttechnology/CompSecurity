// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.socialin.android.photo.textart:
//            b, TextPreview, TextArtStyle

final class a
    implements TextWatcher
{

    private b a;

    public final void afterTextChanged(Editable editable)
    {
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        b.a(a, charsequence.toString());
        b.a(a).invalidate();
        if (b.a(a).a != 0)
        {
            b.a().setTextHeight(b.a(a).a);
        }
    }

    rtStyle(b b1)
    {
        a = b1;
        super();
    }
}
