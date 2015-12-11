// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.database.DataSetObservable;

// Referenced classes of package co.vine.android.provider:
//            GroupCursor

protected class mNotifyOnChange extends DataSetObservable
{

    private boolean mNotifyOnChange;
    final GroupCursor this$0;

    public void notifyChanged()
    {
        if (mNotifyOnChange)
        {
            super.notifyChanged();
        }
    }

    public void setNotifyOnChange(boolean flag)
    {
        mNotifyOnChange = flag;
    }

    public A()
    {
        this$0 = GroupCursor.this;
        super();
        mNotifyOnChange = true;
    }
}
