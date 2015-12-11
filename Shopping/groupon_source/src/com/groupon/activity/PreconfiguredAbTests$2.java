// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Filter;
import com.groupon.adapter.ABTestListAdapter;

// Referenced classes of package com.groupon.activity:
//            PreconfiguredAbTests

class this._cls0
    implements TextWatcher
{

    final PreconfiguredAbTests this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        PreconfiguredAbTests.access$000(PreconfiguredAbTests.this).getFilter().filter(charsequence);
    }

    ()
    {
        this$0 = PreconfiguredAbTests.this;
        super();
    }
}
