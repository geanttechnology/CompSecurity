// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.aio.downloader.views:
//            DeletableEditText

private class <init>
    implements TextWatcher
{

    final DeletableEditText this$0;

    public void afterTextChanged(Editable editable)
    {
        boolean flag = true;
        if (getText().toString().length() < 1)
        {
            flag = false;
        }
        setClearDrawableVisible(flag);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = DeletableEditText.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
