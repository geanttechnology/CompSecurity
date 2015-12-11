// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.widget.Button;
import android.widget.EditText;
import com.amazon.mShop.account.NonZeroLengthTextWatcher;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDMapActivity

class  extends NonZeroLengthTextWatcher
{

    final CVSDMapActivity this$0;

    public void update()
    {
        CVSDMapActivity.access$2200(CVSDMapActivity.this).setEnabled(CVSDMapActivity.access$2300(CVSDMapActivity.this));
    }

    public (EditText edittext)
    {
        this$0 = CVSDMapActivity.this;
        super(edittext);
    }
}
