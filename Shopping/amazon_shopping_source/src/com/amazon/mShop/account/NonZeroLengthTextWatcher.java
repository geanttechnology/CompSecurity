// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class NonZeroLengthTextWatcher
    implements TextWatcher
{

    private final EditText mWatched;
    private boolean mWatchedNonZeroLength;

    public NonZeroLengthTextWatcher(EditText edittext)
    {
        mWatched = edittext;
        mWatched.addTextChangedListener(this);
        boolean flag;
        if (mWatched.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mWatchedNonZeroLength = flag;
    }

    public void afterTextChanged(Editable editable)
    {
        boolean flag;
        if (editable.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mWatchedNonZeroLength = flag;
        update();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public boolean isWatchedNonZeroLength()
    {
        return mWatchedNonZeroLength;
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public abstract void update();
}
