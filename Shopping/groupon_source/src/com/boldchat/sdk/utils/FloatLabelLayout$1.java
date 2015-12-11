// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

// Referenced classes of package com.boldchat.sdk.utils:
//            FloatLabelLayout

class this._cls0
    implements TextWatcher
{

    final FloatLabelLayout this$0;

    public void afterTextChanged(Editable editable)
    {
        if (TextUtils.isEmpty(editable))
        {
            hideLabel();
            return;
        } else
        {
            showLabel();
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = FloatLabelLayout.this;
        super();
    }
}
