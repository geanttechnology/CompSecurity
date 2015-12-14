// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.widget.Adapter;

public class cu extends DataSetObserver
{

    final AdapterViewCompat a;
    private Parcelable b;

    public cu(AdapterViewCompat adapterviewcompat)
    {
        a = adapterviewcompat;
        super();
        b = null;
    }

    public void onChanged()
    {
        a.mDataChanged = true;
        a.mOldItemCount = a.mItemCount;
        a.mItemCount = a.getAdapter().getCount();
        if (a.getAdapter().hasStableIds() && b != null && a.mOldItemCount == 0 && a.mItemCount > 0)
        {
            AdapterViewCompat.access$000(a, b);
            b = null;
        } else
        {
            a.rememberSyncState();
        }
        a.checkFocus();
        a.requestLayout();
    }

    public void onInvalidated()
    {
        a.mDataChanged = true;
        if (a.getAdapter().hasStableIds())
        {
            b = AdapterViewCompat.access$100(a);
        }
        a.mOldItemCount = a.mItemCount;
        a.mItemCount = 0;
        a.mSelectedPosition = -1;
        a.mSelectedRowId = 0x8000000000000000L;
        a.mNextSelectedPosition = -1;
        a.mNextSelectedRowId = 0x8000000000000000L;
        a.mNeedSync = false;
        a.checkFocus();
        a.requestLayout();
    }
}
