// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.wishabi.flipp.widget:
//            ck

final class cl
    implements TextWatcher
{

    final ck a;

    cl(ck ck1)
    {
        a = ck1;
        super();
    }

    public final void afterTextChanged(Editable editable)
    {
        if (editable == null)
        {
            a.e = null;
            return;
        } else
        {
            a.e = editable.toString();
            return;
        }
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
