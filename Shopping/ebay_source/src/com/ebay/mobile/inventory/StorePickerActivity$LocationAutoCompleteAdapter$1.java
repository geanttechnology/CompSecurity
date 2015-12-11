// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.widget.Filter;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.inventory:
//            StorePickerActivity

class this._cls1 extends Filter
{

    final tifyDataSetInvalidated this$1;

    protected android.widget.eAdapter._cls1 performFiltering(CharSequence charsequence)
    {
        android.widget.eAdapter eadapter = new android.widget.eAdapter();
        if (charsequence != null)
        {
            cess._mth702(this._cls1.this, cess._mth800(this._cls1.this, charsequence.toString()));
            eadapter.eAdapter = cess._mth700(this._cls1.this);
            eadapter.eAdapter = cess._mth700(this._cls1.this).size();
        }
        return eadapter;
    }

    protected void publishResults(CharSequence charsequence, android.widget.eAdapter._cls1 _pcls1)
    {
        if (_pcls1 != null && _pcls1._fld1 > 0)
        {
            tifyDataSetChanged();
            return;
        } else
        {
            tifyDataSetInvalidated();
            return;
        }
    }

    Q()
    {
        this$1 = this._cls1.this;
        super();
    }
}
