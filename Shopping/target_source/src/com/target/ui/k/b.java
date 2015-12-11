// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.k;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class b
    implements TextWatcher
{

    private boolean mIsFirstLaunch;

    public b()
    {
        mIsFirstLaunch = true;
    }

    public abstract void a(Editable editable);

    public abstract void a(CharSequence charsequence, int i, int j, int k);

    public final void afterTextChanged(Editable editable)
    {
        if (mIsFirstLaunch && editable.length() <= 0)
        {
            return;
        } else
        {
            mIsFirstLaunch = false;
            a(editable);
            return;
        }
    }

    public abstract void b(CharSequence charsequence, int i, int j, int k);

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        a(charsequence, i, j, k);
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        b(charsequence, i, j, k);
    }
}
