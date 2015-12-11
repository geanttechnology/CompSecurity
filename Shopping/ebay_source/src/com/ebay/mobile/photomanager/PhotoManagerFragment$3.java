// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.database.DataSetObserver;

// Referenced classes of package com.ebay.mobile.photomanager:
//            PhotoManagerFragment

class this._cls0 extends DataSetObserver
{

    final PhotoManagerFragment this$0;

    public void onChanged()
    {
        super.onChanged();
        publishChanges();
    }

    _cls9()
    {
        this$0 = PhotoManagerFragment.this;
        super();
    }
}
