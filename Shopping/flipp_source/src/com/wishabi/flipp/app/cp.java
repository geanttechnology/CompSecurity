// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.wishabi.flipp.util.k;

// Referenced classes of package com.wishabi.flipp.app:
//            cn

final class cp
    implements TextWatcher
{

    final cn a;

    cp(cn cn1)
    {
        a = cn1;
        super();
    }

    public final void afterTextChanged(Editable editable)
    {
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int l)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int l)
    {
        if (cn.c(a) == null)
        {
            return;
        } else
        {
            cn.c(a).setEnabled(k.d(charsequence.toString()));
            return;
        }
    }
}
