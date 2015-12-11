// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.ViewUtil;
import co.vine.android.views.SdkListView;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.twitter.android.widget:
//            TopScrollable, RefreshListener, ItemPosition

public class RefreshableListView extends SdkListView
    implements TopScrollable
{
    private class AdapterDataSetObserver extends DataSetObserver
    {

        private final ArrayList mObservers = new ArrayList();
        final RefreshableListView this$0;

        public void onChanged()
        {
            updateItemCount();
            ArrayList arraylist = mObservers;
            arraylist;
            JVM INSTR monitorenter ;
            int i = mObservers.size() - 1;
_L2:
            if (i < 0)
            {
                break; /* Loop/switch isn't completed */
            }
            ((DataSetObserver)mObservers.get(i)).onChanged();
            i--;
            if (true) goto _L2; else goto _L1
_L1:
            arraylist;
            JVM INSTR monitorexit ;
            requestLayout();
            return;
            Exception exception;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onInvalidated()
        {
            mItemCount = 0;
            ArrayList arraylist = mObservers;
            arraylist;
            JVM INSTR monitorenter ;
            int i = mObservers.size() - 1;
_L2:
            if (i < 0)
            {
                break; /* Loop/switch isn't completed */
            }
            ((DataSetObserver)mObservers.get(i)).onInvalidated();
            i--;
            if (true) goto _L2; else goto _L1
_L1:
            arraylist;
            JVM INSTR monitorexit ;
            requestLayout();
            return;
            Exception exception;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void registerDataSetObserver(DataSetObserver datasetobserver)
        {
            mObservers.add(datasetobserver);
        }

        public void unregisterDataSetObserver(DataSetObserver datasetobserver)
        {
            mObservers.remove(datasetobserver);
        }

        public AdapterDataSetObserver()
        {
            this$0 = RefreshableListView.this;
            super();
        }
    }

    class AnimateLoader
        implements Runnable
    {

        int mRotate;
        private ImageView mView;
        final RefreshableListView this$0;

        public void cancel()
        {
            Handler handler = getHandler();
            if (handler != null)
            {
                handler.removeCallbacks(this);
            }
        }

        public void run()
        {
            mRotate = mRotate + 500;
            if (mRotate > 10000)
            {
                mRotate = 0;
            }
            mView.setImageLevel(mRotate);
            postDelayed(this, 32L);
        }

        public AnimateLoader(ImageView imageview)
        {
            this$0 = RefreshableListView.this;
            super();
            mView = imageview;
        }
    }

    private class RefreshViewListAdapter extends HeaderViewListAdapter
    {

        private final AdapterDataSetObserver mDataSetObserver;
        private boolean mRegistered;
        final RefreshableListView this$0;

        public int getCount()
        {
            return mItemCount;
        }

        public Object getItem(int i)
        {
            if (isMode(34))
            {
                if (i == 0)
                {
                    return null;
                } else
                {
                    return super.getItem(i - 1);
                }
            } else
            {
                return super.getItem(i);
            }
        }

        public long getItemId(int i)
        {
            if (isMode(34))
            {
                if (i == 0)
                {
                    return 0L;
                } else
                {
                    return super.getItemId(i - 1);
                }
            } else
            {
                return super.getItemId(i);
            }
        }

        public int getItemViewType(int i)
        {
            if (isMode(34))
            {
                if (i == 0)
                {
                    return -1;
                } else
                {
                    return super.getItemViewType(i - 1);
                }
            } else
            {
                return super.getItemViewType(i);
            }
        }

        int getSuperCount()
        {
            return super.getCount();
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (isMode(34))
            {
                if (i == 0)
                {
                    return mRefreshView;
                } else
                {
                    return super.getView(i - 1, view, viewgroup);
                }
            }
            try
            {
                view = super.getView(i, view, viewgroup);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                CrashUtil.logException(view);
                return mRefreshView;
            }
            return view;
        }

        public boolean isEnabled(int i)
        {
            if (isMode(34))
            {
                return i > 0 && superEnabled(i - 1);
            }
            boolean flag;
            try
            {
                flag = superEnabled(i);
            }
            catch (IndexOutOfBoundsException indexoutofboundsexception)
            {
                int j = mHeaderViewInfos.size();
                if (i < j)
                {
                    return ((android.widget.ListView.FixedViewInfo)mHeaderViewInfos.get(i)).isSelectable;
                }
                int l = i - j;
                i = 0;
                if (mAdapter != null)
                {
                    int k = mAdapter.getCount();
                    i = k;
                    if (l < k)
                    {
                        return mAdapter.isEnabled(l);
                    }
                }
                boolean flag1;
                try
                {
                    flag1 = ((android.widget.ListView.FixedViewInfo)mFooterViewInfos.get(l - i)).isSelectable;
                }
                catch (Exception exception)
                {
                    CrashUtil.logException(exception);
                    return false;
                }
                return flag1;
            }
            return flag;
        }

        public final void registerDataSetObserver()
        {
            if (!mRegistered)
            {
                super.registerDataSetObserver(mDataSetObserver);
                mRegistered = true;
            }
        }

        public void registerDataSetObserver(DataSetObserver datasetobserver)
        {
            mDataSetObserver.registerDataSetObserver(datasetobserver);
        }

        public boolean superEnabled(int i)
        {
            boolean flag;
            try
            {
                flag = super.isEnabled(i);
            }
            catch (IndexOutOfBoundsException indexoutofboundsexception)
            {
                int j = mHeaderViewInfos.size();
                if (i < j)
                {
                    return ((android.widget.ListView.FixedViewInfo)mHeaderViewInfos.get(i)).isSelectable;
                }
                int l = i - j;
                i = 0;
                if (mAdapter != null)
                {
                    int k = mAdapter.getCount();
                    i = k;
                    if (l < k)
                    {
                        return mAdapter.isEnabled(l);
                    }
                }
                boolean flag1;
                try
                {
                    flag1 = ((android.widget.ListView.FixedViewInfo)mFooterViewInfos.get(l - i)).isSelectable;
                }
                catch (Exception exception)
                {
                    CrashUtil.logException(exception);
                    return false;
                }
                return flag1;
            }
            return flag;
        }

        public final void unregisterDataSetObserver()
        {
            if (mRegistered)
            {
                super.unregisterDataSetObserver(mDataSetObserver);
                mRegistered = false;
            }
        }

        public void unregisterDataSetObserver(DataSetObserver datasetobserver)
        {
            mDataSetObserver.unregisterDataSetObserver(datasetobserver);
        }

        public RefreshViewListAdapter(ArrayList arraylist, ArrayList arraylist1, ListAdapter listadapter, AdapterDataSetObserver adapterdatasetobserver)
        {
            this$0 = RefreshableListView.this;
            super(arraylist, arraylist1, listadapter);
            mDataSetObserver = adapterdatasetobserver;
            registerDataSetObserver();
        }
    }

    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public int mode;
        public boolean refreshable;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            if (refreshable)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            parcel.writeInt(mode);
        }


        public SavedState(Parcel parcel)
        {
            boolean flag = true;
            super(parcel);
            if (parcel.readInt() != 1)
            {
                flag = false;
            }
            refreshable = flag;
            mode = parcel.readInt();
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    private class ScrollRunnable
        implements Runnable
    {

        private static final int AUTO_SCROLL_DURATION = 450;
        private int mLastY;
        final RefreshableListView this$0;

        public void run()
        {
            if (!isMode(10))
            {
                return;
            }
            Scroller scroller = mScroller;
            boolean flag;
            int i;
            int j;
            if (scroller.timePassed() < 450 && scroller.computeScrollOffset())
            {
                flag = true;
            } else
            {
                f