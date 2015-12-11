// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.database.ContentObserver;
import android.os.Handler;

// Referenced classes of package co.vine.android:
//            BaseCursorAdapterFragment

protected class this._cls0 extends ContentObserver
{

    final BaseCursorAdapterFragment this$0;

    public boolean deliverSelfNotifications()
    {
        return true;
    }

    public void onChange(boolean flag)
    {
        if (!mRefreshing)
        {
            handleContentChanged();
        }
    }

    public (Handler handler)
    {
        this$0 = BaseCursorAdapterFragment.this;
        super(handler);
    }
}
