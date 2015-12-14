// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AdapterView

class mInstanceState extends DataSetObserver
{

    private Parcelable mInstanceState;
    final AdapterView this$0;

    public void clearSavedState()
    {
        mInstanceState = null;
    }

    public void onChanged()
    {
        mDataChanged = true;
        mOldItemCount = mItemCount;
        mItemCount = getAdapter().getCount();
        if (getAdapter().hasStableIds() && mInstanceState != null && mOldItemCount == 0 && mItemCount > 0)
        {
            AdapterView.access$000(AdapterView.this, mInstanceState);
            mInstanceState = null;
        } else
        {
            rememberSyncState();
        }
        checkFocus();
        requestLayout();
    }

    public void onInvalidated()
    {
        mDataChanged = true;
        if (getAdapter().hasStableIds())
        {
            mInstanceState = AdapterView.access$100(AdapterView.this);
        }
        mOldItemCount = mItemCount;
        mItemCount = 0;
        mSelectedPosition = -1;
        mSelectedColId = 0x8000000000000000L;
        mNextSelectedPosition = -1;
        mNextSelectedColId = 0x8000000000000000L;
        mNeedSync = false;
        checkFocus();
        requestLayout();
    }

    ()
    {
        this$0 = AdapterView.this;
        super();
        mInstanceState = null;
    }
}
