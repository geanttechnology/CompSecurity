// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import java.util.List;

public abstract class GroupCursor extends CursorWrapper
{
    private class LocalContentObserver extends ContentObserver
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
                mContentObservable.dispatchChange(flag);
                return;
            }
        }

        public LocalContentObserver()
        {
            this$0 = GroupCursor.this;
            super(null);
        }
    }

    protected class LocalDataSetObservable extends DataSetObservable
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

        public LocalDataSetObservable()
        {
            this$0 = GroupCursor.this;
            super();
            mNotifyOnChange = true;
        }
    }

    private class LocalDataSetObserver extends DataSetObserver
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

        public LocalDataSetObserver()
        {
            this$0 = GroupCursor.this;
            super();
        }
    }


    public static final int LIMIT_DEFAULT = 20;
    private final ContentObservable mContentObservable;
    protected Cursor mCursor;
    protected int mCursorPosition;
    protected int mLimit;
    protected List mList;
    protected final LocalDataSetObservable mLocalDataSetObservable;
    volatile boolean mNeedsDispatchChange;
    volatile boolean mPreparing;
    volatile boolean mSelfChange;

    public GroupCursor(Cursor cursor)
    {
        this(cursor, 20);
    }

    public GroupCursor(Cursor cursor, int i)
    {
        super(cursor);
        mCursorPosition = -1;
        mLocalDataSetObservable = new LocalDataSetObservable();
        mContentObservable = new ContentObservable();
        mCursor = cursor;
        if (i <= 0)
        {
            mLimit = 20;
        } else
        {
            mLimit = i;
        }
        if (cursor != null && !cursor.isClosed())
        {
            cursor.registerDataSetObserver(new LocalDataSetObserver());
            cursor.registerContentObserver(new LocalContentObserver());
        }
    }

    public int getCount()
    {
        if (mList != null)
        {
            return mList.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        if (mList == null)
        {
            return null;
        } else
        {
            return mList.get(i);
        }
    }

    public int getPosition()
    {
        return mCursorPosition;
    }

    public boolean moveToFirst()
    {
        return moveToPosition(0);
    }

    public boolean moveToLast()
    {
        return moveToPosition(mList.size() - 1);
    }

    public boolean moveToNext()
    {
        return moveToPosition(mCursorPosition + 1);
    }

    public boolean moveToPosition(int i)
    {
        int j = getCount();
        if (i <= -1)
        {
            mCursorPosition = -1;
            return false;
        }
        if (i >= j)
        {
            mCursorPosition = j;
            return false;
        } else
        {
            mCursorPosition = i;
            return true;
        }
    }

    public boolean moveToPrevious()
    {
        return moveToPosition(mCursorPosition - 1);
    }

    public abstract void onPrepare();

    public final void prepare()
    {
        mPreparing = true;
        onPrepare();
        mPreparing = false;
        if (mNeedsDispatchChange)
        {
            mNeedsDispatchChange = false;
            mContentObservable.dispatchChange(mSelfChange);
        }
    }

    public void registerContentObserver(ContentObserver contentobserver)
    {
        if (contentobserver != null)
        {
            mContentObservable.registerObserver(contentobserver);
        }
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        if (datasetobserver != null)
        {
            mLocalDataSetObservable.registerObserver(datasetobserver);
        }
    }

    public boolean requery()
    {
        boolean flag1 = false;
        LocalDataSetObservable localdatasetobservable = mLocalDataSetObservable;
        localdatasetobservable.setNotifyOnChange(false);
        boolean flag = flag1;
        if (!mCursor.isClosed())
        {
            flag = flag1;
            if (mCursor.requery())
            {
                flag = true;
            }
        }
        prepare();
        localdatasetobservable.setNotifyOnChange(true);
        localdatasetobservable.notifyChanged();
        return flag;
    }

    public void unregisterContentObserver(ContentObserver contentobserver)
    {
        if (contentobserver != null)
        {
            mContentObservable.unregisterObserver(contentobserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        if (datasetobserver != null)
        {
            mLocalDataSetObservable.unregisterObserver(datasetobserver);
        }
    }

}
