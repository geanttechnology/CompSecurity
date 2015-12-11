// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.groupon.activity:
//            Countries

class this._cls1
    implements TextWatcher
{

    final is._cls0 this$1;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        Countries.access$600(_fld0, charsequence);
    }

    A()
    {
        this$1 = this._cls1.this;
        super();
    }
}
