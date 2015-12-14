// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryAdapterView

class mInstanceState extends DataSetObserver
{

    private Parcelable mInstanceState;
    final AviaryAdapterView this$0;

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
            AviaryAdapterView.access$100(AviaryAdapterView.this, mInstanceState);
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
            mInstanceState = AviaryAdapterView.access$200(AviaryAdapterView.this);
        }
        mOldItemCount = mItemCount;
        mItemCount = 0;
        mSelectedPosition = -1;
        mSelectedRowId = 0x8000000000000000L;
        mNextSelectedPosition = -1;
        mNextSelectedRowId = 0x8000000000000000L;
        mNeedSync = false;
        checkFocus();
        requestLayout();
    }

    ()
    {
        this$0 = AviaryAdapterView.this;
        super();
        mInstanceState = null;
    }
}
