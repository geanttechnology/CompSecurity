// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.wishabi.flipp.app:
//            fg

final class fm
    implements TextWatcher
{

    final fg a;

    fm(fg fg1)
    {
        a = fg1;
        super();
    }

    public final void afterTextChanged(Editable editable)
    {
        fg.e(a);
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
