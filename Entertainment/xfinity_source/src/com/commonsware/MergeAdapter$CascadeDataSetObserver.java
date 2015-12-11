// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.commonsware;

import android.database.DataSetObserver;

// Referenced classes of package com.commonsware:
//            MergeAdapter

private class <init> extends DataSetObserver
{

    final MergeAdapter this$0;

    public void onChanged()
    {
        notifyDataSetChanged();
    }

    public void onInvalidated()
    {
        notifyDataSetInvalidated();
    }

    private _cls9()
    {
        this$0 = MergeAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
