// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import co.vine.android.util.CrashUtil;

// Referenced classes of package co.vine.android:
//            BaseAdapterFragment

public abstract class BaseCursorAdapterFragment extends BaseAdapterFragment
    implements android.support.v4.app.LoaderManager.LoaderCallbacks
{
    protected class ChangeObserver extends ContentObserver
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

        public ChangeObserver(Handler handler)
        {
            this$0 = BaseCursorAdapterFragment.this;
            super(handler);
        }
    }


    protected static final int LOADER_ID_DEFAULT = 0;
    protected static final int PROGRESS_FIRST_USER = 6;
    protected static final int PROGRESS_LOAD_DATA = 5;
    protected static final int PROGRESS_LOAD_DATA_OLDER = 7;
    protected ChangeObserver mChangeObserver;
    protected CursorAdapter mCursorAdapter;
    private int mLoaderId;
    protected boolean mRefreshing;

    public BaseCursorAdapterFragment()
    {
        mLoaderId = 0;
    }

    protected abstract void handleContentChanged();

    protected void initLoader()
    {
        initLoader(0);
    }

    protected final void initLoader(int i)
    {
        if (mChangeObserver == null)
        {
            mChangeObserver = new ChangeObserver(mHandler);
            mLoaderId = i;
        }
        getLoaderManager().initLoader(i, null, this);
    }

    protected void loadCursor(boolean flag)
    {
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return null;
    }

    public void onDestroy()
    {
        if (mCursorAdapter != null)
        {
            Cursor cursor = mCursorAdapter.swapCursor(null);
            if (cursor != null && mChangeObserver != null)
            {
                try
                {
                    cursor.unregisterContentObserver(mChangeObserver);
                }
                catch (IllegalStateException illegalstateexception)
                {
                    CrashUtil.logException(illegalstateexception, "This is ok, because this cursor probably didn't need a change observer.", new Object[0]);
                }
            }
        }
        super.onDestroy();
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        loader = mCursorAdapter.getCursor();
        if (loader != null)
        {
            loader.unregisterContentObserver(mChangeObserver);
        }
        if (cursor != null)
        {
            cursor.registerContentObserver(mChangeObserver);
        }
        mCursorAdapter.swapCursor(cursor);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onLoaderReset(Loader loader)
    {
        if (mCursorAdapter != null)
        {
            loader = mCursorAdapter.getCursor();
            if (loader != null)
            {
                loader.unregisterContentObserver(mChangeObserver);
            }
            mCursorAdapter.swapCursor(null);
        }
    }

    protected boolean restartLoader()
    {
        return restartLoader(mLoaderId);
    }

    protected boolean restartLoader(int i)
    {
        if (mChangeObserver == null)
        {
            return false;
        } else
        {
            getLoaderManager().restartLoader(i, null, this);
            return true;
        }
    }
}
