// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.database.ContentObservable;
import android.database.ContentObserver;

// Referenced classes of package co.vine.android.provider:
//            GroupCursor

private class this._cls0 extends ContentObserver
{

    final GroupCursor this$0;

    public void onChange(boolean flag)
    {
        mSelfChange = flag;
        if (mPreparing)
        {
            mNeedsDispatchChange = true;
            return;
        } else
        {
            GroupCursor.access$000(GroupCursor.this).dispatchChange(flag);
            return;
        }
    }

    public ()
    {
        this$0 = GroupCursor.this;
        super(null);
    }
}
