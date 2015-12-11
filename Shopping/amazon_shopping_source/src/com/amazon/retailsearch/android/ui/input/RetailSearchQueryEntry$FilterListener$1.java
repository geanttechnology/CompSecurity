// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.input;

import android.graphics.drawable.Drawable;
import com.amazon.retailsearch.android.ui.ClearableAutoCompleteTextView;

// Referenced classes of package com.amazon.retailsearch.android.ui.input:
//            RetailSearchQueryEntry

class this._cls0
    implements Runnable
{

    final this._cls0 this$0;

    public void run()
    {
        if (cess._mth300(this._cls0.this) != null && cess._mth400(this._cls0.this) != null)
        {
            cess._mth300(this._cls0.this).setCompoundDrawablesWithIntrinsicBounds(cess._mth500(this._cls0.this), null, cess._mth400(this._cls0.this), null);
            cess._mth400(this._cls0.this).setVisible(true, false);
        }
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
