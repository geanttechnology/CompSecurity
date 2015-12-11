// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.scan;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.target.ui.adapter.g.a;
import com.target.ui.model.scan.ScanResultItem;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.scan:
//            ScanHeaderView

public class ScanSummaryView extends FrameLayout
{
    public static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i)
            {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        private List savedItems;

        static List a(SavedState savedstate)
        {
            return savedstate.savedItems;
        }

        static List a(SavedState savedstate, List list)
        {
            savedstate.savedItems = list;
            return list;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeList(savedItems);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            savedItems = new ArrayList();
            parcel.readList(savedItems, getClass().getClassLoader());
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    public static interface a
    {

        public abstract void c();
    }

    private class b
    {

        final ListView listView;
        final ScanSummaryView this$0;

        b(View view)
        {
            this$0 = ScanSummaryView.this;
            super();
            listView = (ListView)view.findViewById(0x7f100593);
        }
    }


    private static final int MAX_SCAN_RESULTS_LIST = 3;
    private com.target.ui.adapter.g.a mAdapter;
    private ScanHeaderView mHeaderView;
    private List mScanResultItems;
    private b mViews;

    public ScanSummaryView(Context context)
    {
        super(context);
        a();
    }

    public ScanSummaryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301e5, this);
        setBackgroundResource(0x106000d);
        mViews = new b(this);
        mHeaderView = new ScanHeaderView(getContext());
        mViews.listView.addHeaderView(mHeaderView);
        mScanResultItems = new ArrayList();
        mAdapter = new com.target.ui.adapter.g.a(getContext(), mScanResultItems);
        mViews.listView.setAdapter(mAdapter);
    }

    private void a(SavedState savedstate)
    {
        mScanResultItems.clear();
        mScanResultItems.addAll(com.target.ui.view.scan.SavedState.a(savedstate));
        mAdapter.notifyDataSetChanged();
    }

    private void b()
    {
        if (mScanResultItems.size() == 4)
        {
            mViews.listView.measure(0, 0);
            int i = mViews.listView.getWidth();
            int j = mViews.listView.getHeight();
            mViews.listView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(i, j));
            mViews.listView.requestLayout();
        }
    }

    private void b(SavedState savedstate)
    {
        com.target.ui.view.scan.SavedState.a(savedstate, mScanResultItems);
    }

    public ScanResultItem a(String s)
    {
        s = new ScanResultItem(s);
        mScanResultItems.add(s);
        mAdapter.notifyDataSetChanged();
        mViews.listView.setSelection(mScanResultItems.size() - 1);
        b();
        return s;
    }

    public void a(ScanResultItem scanresultitem)
    {
        scanresultitem.a(com.target.ui.model.scan.ScanResultItem.a.PRODUCT_NOT_FOUND);
        mAdapter.notifyDataSetChanged();
    }

    public void a(ScanResultItem scanresultitem, String s)
    {
        scanresultitem.b(s);
        scanresultitem.a(com.target.ui.model.scan.ScanResultItem.a.PRODUCT_RESULT);
        mAdapter.notifyDataSetChanged();
    }

    public void b(ScanResultItem scanresultitem)
    {
        scanresultitem.a(com.target.ui.model.scan.ScanResultItem.a.CONNECTION_ISSUE);
        mAdapter.notifyDataSetChanged();
    }

    public List getScanResultItems()
    {
        return mScanResultItems;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        a(parcelable);
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        b(savedstate);
        return savedstate;
    }

    public void setScanListener(a a1)
    {
        if (a1 == null)
        {
            return;
        } else
        {
            mHeaderView.setScanListener(a1);
            return;
        }
    }
}
