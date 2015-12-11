// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.database.DataSetObserver;

// Referenced classes of package co.vine.android.provider:
//            GroupCursor

private class this._cls0 extends DataSetObserver
{

    final GroupCursor this$0;

    public void onChanged()
    {
        mLocalDataSetObservable.notifyChanged();
    }

    public void onInvalidated()
    {
        mLocalDataSetObservable.notifyInvalidated();
    }

    public e()
    {
        this$0 = GroupCursor.this;
        super();
    }
}
