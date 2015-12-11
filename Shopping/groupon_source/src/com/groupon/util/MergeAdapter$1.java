// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.database.DataSetObserver;

// Referenced classes of package com.groupon.util:
//            MergeAdapter

class  extends DataSetObserver
{

    final MergeAdapter this$0;

    public void onChanged()
    {
        init();
        notifyDataSetChanged();
    }

    public void onInvalidated()
    {
        init();
        notifyDataSetInvalidated();
    }

    ()
    {
        this$0 = MergeAdapter.this;
        super();
    }
}
