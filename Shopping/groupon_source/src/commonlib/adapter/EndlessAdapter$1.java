// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.adapter;

import android.database.DataSetObserver;

// Referenced classes of package commonlib.adapter:
//            EndlessAdapter

class nit> extends DataSetObserver
{

    final EndlessAdapter this$0;

    public void onChanged()
    {
        EndlessAdapter.access$002(EndlessAdapter.this, null);
        EndlessAdapter.access$102(EndlessAdapter.this, false);
    }

    public void onInvalidated()
    {
        onChanged();
    }

    ()
    {
        this$0 = EndlessAdapter.this;
        super();
    }
}
