// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.k;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;

public abstract class a extends PhoneNumberFormattingTextWatcher
{

    private boolean mIsFirstLaunch;

    public a()
    {
        mIsFirstLaunch = true;
    }

    public abstract void a(Editable editable);

    public abstract void a(CharSequence charsequence, int i, int j, int k);

    public final void afterTextChanged(Editable editable)
    {
        this;
        JVM INSTR monitorenter ;
        super.afterTextChanged(editable);
        if (!mIsFirstLaunch) goto _L2; else goto _L1
_L1:
        int i = editable.length();
        if (i > 0) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mIsFirstLaunch = false;
        a(editable);
        if (true) goto _L3; else goto _L4
_L4:
        editable;
        throw editable;
    }

    public abstract void b(CharSequence charsequence, int i, int j, int k);

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.beforeTextChanged(charsequence, i, j, k);
        a(charsequence, i, j, k);
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        b(charsequence, i, j, k);
    }
}
