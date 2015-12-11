// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.util.FlurryUtils;
import co.vine.android.widget.OnTabChangedListener;
import co.vine.android.widget.tabs.TabScrollListener;
import com.twitter.android.widget.ItemPosition;
import com.twitter.android.widget.RefreshListener;
import com.twitter.android.widget.RefreshableListView;

// Referenced classes of package co.vine.android:
//            BaseCursorAdapterFragment, PendingRequestHelper, ListState

public class BaseCursorListFragment extends BaseCursorAdapterFragment
    implements android.widget.AbsListView.OnScrollListener, OnTabChangedListener, RefreshListener
{

    public static final String ARG_BG_COLOR = "bg_color";
    public static final String ARG_CHOICE_MODE = "chmode";
    public static final String ARG_DATA = "data";
    public static final String ARG_EMPTY_DESC = "empty_desc";
    public static final String ARG_OWNER_ID = "owner_id";
    public static final String ARG_REFRESHABLE = "refresh";
    public static final String ARG_TAKE_FOCUS = "take_focus";
    private static final String STATE_SCROLL_OFF_KEY = "scroll_off";
    private static final String STATE_SCROLL_POS_KEY = "scroll_pos";
    protected int mBgColor;
    protected int mChoiceMode;
    private ProgressBar mEmptyProgress;
    protected TextView mEmptyText;
    protected int mEmptyTextStringRes;
    private View mEmptyView;
    protected boolean mFocused;
    private boolean mIsSadFaceHeaderAdded;
    private boolean mIsSadFacePartOfHeader;
    protected ListState mListState;
    protected ListView mListView;
    private final android.widget.AdapterView.OnItemClickListener mOnItemClickListener = new android.widget.AdapterView.OnItemClickListener() {

        final BaseCursorListFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            onListItemClick((ListView)adapterview, view, i, l);
        }

            
            {
                this$0 = BaseCursorListFragment.this;
                super();
            }
    };
    private final android.widget.AdapterView.OnItemLongClickListener mOnItemLongClickListenerClickListener = new android.widget.AdapterView.OnItemLongClickListener() {

        final BaseCursorListFragment this$0;

        public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
        {
            return onListItemLongClick((ListView)adapterview, view, i, l);
        }

            
            {
                this$0 = BaseCursorListFragment.this;
                super();
            }
    };
    protected long mOwnerId;
    protected boolean mRefreshable;
    private final Runnable mRequestFocus = new Runnable() {

        final BaseCursorListFragment this$0;

        public void run()
        {
            mListView.focusableViewAvailable(mListView);
        }

            
            {
                this$0 = BaseCursorListFragment.this;
                super();
            }
    };
    private View mRootView;
    protected View mSadface;
    private TabScrollListener mScrollListener;
    private int mScrollOffset;
    private int mScrollPos;

    public BaseCursorListFragment()
    {
    }

    public static Bundle prepareArguments(Intent intent, boolean flag)
    {
        Bundle bundle1 = intent.getExtras();
        Bundle bundle = bundle1;
        if (bundle1 == null)
        {
            bundle = new Bundle();
        }
        bundle.putParcelable("data", intent.getData());
        bundle.putBoolean("refresh", flag);
        return bundle;
    }

    private void showLoading(boolean flag)
    {
        if (flag)
        {
            mListView.setVisibility(8);
            if (mSadface != null)
            {
                mSadface.setVisibility(8);
            }
            if (mEmptyProgress != null)
            {
                mEmptyProgress.setVisibility(0);
            }
        } else
        {
            ListView listview = mListView;
            if (!isEmpty())
            {
                listview.setVisibility(0);
                return;
            }
            if (mEmptyProgress != null)
            {
                mEmptyProgress.setVisibility(8);
                return;
            }
        }
    }

    protected View createDefaultView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        return createView(layoutinflater, 0x7f03005f, viewgroup);
    }

    public View createView(LayoutInflater layoutinflater, int i, ViewGroup viewgroup)
    {
        layoutinflater = layoutinflater.inflate(i, viewgroup, false);
        mRootView = layoutinflater;
        viewgroup = (ListView)layoutinflater.findViewById(0x102000a);
        viewgroup.setOnItemClickListener(mOnItemClickListener);
        viewgroup.setOnItemLongClickListener(mOnItemLongClickListenerClickListener);
        viewgroup.setScrollbarFadingEnabled(true);
        viewgroup.setOnScrollListener(this);
        viewgroup.setChoiceMode(mChoiceMode);
        i = mBgColor;
        if (i != 0)
        {
            viewgroup.setBackgroundColor(i);
            viewgroup.setCacheColorHint(i);
        }
        View view = layoutinflater.findViewById(0x1020004);
        if (view != null)
        {
            viewgroup.setEmptyView(view);
            mEmptyProgress = (ProgressBar)view.findViewById(0x7f0a00f1);
        }
        mEmptyView = view;
        mEmptyText = (TextView)layoutinflater.findViewById(0x7f0a007f);
        if (mEmptyTextStringRes > 0 && mEmptyText != null)
        {
            mEmptyText.setText(mEmptyTextStringRes);
        }
        mSadface = layoutinflater.findViewById(0x7f0a007e);
        if (mRefreshable)
        {
            ((RefreshableListView)viewgroup).setRefreshListener(this);
        }
        mListView = viewgroup;
        return layoutinflater;
    }

    public ItemPosition getFirstItemPosition()
    {
        int j = 0;
        ListView listview = mListView;
        if (listview.getCount() < 1)
        {
            return null;
        }
        int k = listview.getFirstVisiblePosition();
        int l = listview.getHeaderViewsCount();
        int i = l;
        if (mRefreshing)
        {
            i = l + 1;
        }
        View view;
        long l1;
        if (k < i)
        {
            view = listview.getChildAt(i - k);
        } else
        {
            i = k;
            view = listview.getChildAt(0);
        }
        l1 = listview.getItemIdAtPosition(i);
        if (view != null)
        {
            j = view.getTop();
        }
        return new ItemPosition(i, l1, j);
    }

    protected int getIdColumnIndex()
    {
        return -1;
    }

    public int getPositionForItemId(long l)
    {
        int i = getIdColumnIndex();
        if (i >= 0)
        {
            Cursor cursor = mCursorAdapter.getCursor();
            if (cursor != null && cursor.moveToFirst())
            {
                do
                {
                    if (cursor.getLong(i) == l)
                    {
                        int k = cursor.getPosition() + mListView.getHeaderViewsCount();
                        int j = k;
                        if (mRefreshing)
                        {
                            j = k + 1;
                        }
                        return j;
                    }
                } while (cursor.moveToNext());
            }
        }
        return 0;
    }

    public View getRootView()
    {
        return mRootView;
    }

    protected void handleContentChanged()
    {
        onContentChanged();
    }

    protected void hideProgress(int i)
    {
        i;
        JVM INSTR tableswitch 1 5: default 36
    //                   1 71
    //                   2 43
    //                   3 37
    //                   4 43
    //                   5 37;
           goto _L1 _L2 _L3 _L4 _L3 _L4
_L1:
        return;
_L4:
        showLoading(false);
        return;
_L3:
        showLoading(false);
        if (mRefreshable)
        {
            ((RefreshableListView)mListView).stopRefresh();
            mRefreshing = false;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (mRefreshable)
        {
            ((RefreshableListView)mListView).refreshMore(false);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    void invokeScrollFirstItem()
    {
        if (mScrollListener != null)
        {
            mScrollListener.onScrollFirstItem();
        }
    }

    protected boolean isEmpty()
    {
        ListView listview = mListView;
        return listview.getCount() - listview.getHeaderViewsCount() - listview.getFooterViewsCount() == 0;
    }

    protected boolean isFocused()
    {
        return mFocused;
    }

    public boolean isSadFacePartOfHeader()
    {
        return mIsSadFacePartOfHeader;
    }

    public void makeSadFaceHeaderView()
    {
        this;
        JVM INSTR monitorenter ;
        if (mIsSadFacePartOfHeader) goto _L2; else goto _L1
_L1:
        mIsSadFacePartOfHeader = true;
        mIsSadFaceHeaderAdded = true;
        if (mSadface == null) goto _L2; else goto _L3
_L3:
        boolean flag1 = false;
        Object obj = mSadface.getParent();
        boolean flag = flag1;
        if (obj == null) goto _L5; else goto _L4
_L4:
        if (!(obj instanceof ViewGroup)) goto _L7; else goto _L6
_L6:
        if (obj == mListView) goto _L9; else goto _L8
_L8:
        ((ViewGroup)obj).removeView(mSadface);
        flag = flag1;
_L5:
        if (flag) goto _L2; else goto _L10
_L10:
        obj = mSadface.getLayoutParams();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        obj = new android.widget.AbsListView.LayoutParams(((android.view.ViewGroup.LayoutParams) (obj)).width, ((android.view.ViewGroup.LayoutParams) (obj)).height);
        mSadface.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mListView.addHeaderView(mSadface, null, false);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L9:
        flag = true;
        if (true) goto _L5; else goto _L7
_L7:
        throw new IllegalStateException((new StringBuilder()).append("The sad face does not belong to a valid parent: ").append(obj).toString());
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        mPendingRequestHelper.onActivityResult(i, j, intent);
    }

    protected void onContentChanged()
    {
        onRefreshFinished();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mListState = new ListState();
        if (bundle != null)
        {
            mScrollPos = bundle.getInt("scroll_pos");
            mScrollOffset = bundle.getInt("scroll_off");
            mPendingRequestHelper.restorePendingCaptchaRequest(bundle);
        } else
        {
            mScrollPos = 0;
            mScrollOffset = 0;
        }
        bundle = getArguments();
        if (bundle != null)
        {
            mRefreshable = bundle.getBoolean("refresh", true);
            mOwnerId = bundle.getLong("owner_id", mAppController.getActiveId());
            if (bundle.containsKey("chmode"))
            {
                mChoiceMode = bundle.getInt("chmode", 0);
            }
            mBgColor = bundle.getInt("bg_color", 0);
            mEmptyTextStringRes = bundle.getInt("empty_desc", 0);
            return;
        } else
        {
            mRefreshable = true;
            mOwnerId = mAppController.getActiveId();
            mChoiceMode = 0;
            mBgColor = 0;
            return;
        }
    }

    protected Dialog onCreateDialog(int i)
    {
        return null;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return createDefaultView(layoutinflater, viewgroup);
    }

    public void onDestroyView()
    {
        mHandler.removeCallbacks(mRequestFocus);
        super.onDestroyView();
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
    }

    protected boolean onListItemLongClick(ListView listview, View view, int i, long l)
    {
        return false;
    }

    public void onMoveAway(int i)
    {
        mFocused = false;
    }

    public void onMoveTo(int i)
    {
        mFocused = true;
    }

    public void onPause()
    {
        super.onPause();
        savePosition();
    }

    public void onRefreshCancelled()
    {
    }

    public void onRefreshFinished()
    {
        CursorAdapter cursoradapter = mCursorAdapter;
        if (cursoradapter != null)
        {
            if (cursoradapter.getCursor() == null);
        }
    }

    public void onRefreshFinishedNewData()
    {
    }

    public void onRefreshFinishedNoChange()
    {
    }

    public void onRefreshPulled()
    {
    }

    public void onRefreshReleased(boolean flag)
    {
        if (flag)
        {
            FlurryUtils.trackValidPullToRefreshRelease(getClass().getName());
            refresh();
        }
    }

    public void onResume()
    {
        super.onResume();
        restorePosition();
        mPendingRequestHelper.handlePendingCaptchaRequest();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        savePosition();
        bundle.putInt("scroll_pos", mScrollPos);
        bundle.putInt("scroll_off", mScrollOffset);
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        mListState.firstVisibleItem = i;
        mListState.visibleItemCount = j;
        mListState.totalItemCount = k;
        if (j != 0)
        {
            if (i == 0 && mScrollListener != null)
            {
                mScrollListener.onScrollFirstItem();
            }
            if (i > 0 && mCursorAdapter != null && i + j >= k - 1 && mCursorAdapter.getCount() > 0)
            {
                abslistview = mCursorAdapter.getCursor();
                if (abslistview != null && abslistview.moveToLast() && mListState.hasNewScrollState)
                {
                    mListState.hasNewScrollState = false;
                    onScrollLastItem(abslistview);
                    return;
                }
            }
        }
    }

    protected void onScrollLastItem(Cursor cursor)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        mListState.hasNewScrollState = true;
        mListState.setScrollState(i);
        if (i == 0)
        {
            onScroll(abslistview, mListState.firstVisibleItem, mListState.visibleItemCount, mListState.totalItemCount);
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        mHandler.post(mRequestFocus);
    }

    protected void processPostOptionsResult(PostOptionsDialogActivity.Result result)
    {
        if (result.request != null)
        {
            addRequest(result.request);
        }
        if (result.intent != null)
        {
            startActivity(result.intent);
        }
    }

    protected void refresh()
    {
    }

    protected void restorePosition()
    {
        mListView.setSelectionFromTop(mScrollPos, mScrollOffset);
    }

    protected void saveItemPosition(ItemPosition itemposition)
    {
    }

    protected void savePosition()
    {
        ListView listview = mListView;
        if (listview != null)
        {
            View view = listview.getChildAt(0);
            int i;
            if (view != null)
            {
                i = view.getTop();
            } else
            {
                i = 0;
            }
            mScrollPos = listview.getFirstVisiblePosition();
            mScrollOffset = i;
        }
    }

    protected void setEmptyStringMessage(int i)
    {
        mEmptyText.setText(getString(i));
    }

    public void setFocused(boolean flag)
    {
        mFocused = flag;
    }

    public void setOwnerId(long l)
    {
        mOwnerId = l;
    }

    public void setRefreshableHeaderOffset(int i)
    {
        if (mRefreshable)
        {
            ((RefreshableListView)mListView).setViewYOffset(i);
        }
    }

    public void setScrollListener(TabScrollListener tabscrolllistener)
    {
        mScrollListener = tabscrolllistener;
    }

    public void showDialog(int i)
    {
        Dialog dialog = onCreateDialog(i);
        if (dialog != null)
        {
            dialog.show();
        }
    }

    protected void showProgress(int i)
    {
        i;
        JVM INSTR tableswitch 1 7: default 44
    //                   1 45
    //                   2 64
    //                   3 87
    //                   4 64
    //                   5 87
    //                   6 44
    //                   7 45;
           goto _L1 _L2 _L3 _L4 _L3 _L4 _L1 _L2
_L1:
        return;
_L2:
        if (mRefreshable)
        {
            ((RefreshableListView)mListView).refreshMore(true);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (mRefreshable)
        {
            ((RefreshableListView)mListView).startRefresh();
            mRefreshing = true;
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        showLoading(true);
        return;
    }

    protected void showSadface(boolean flag)
    {
        showSadface(flag, flag);
    }

    protected void showSadface(boolean flag, boolean flag1)
    {
        int i = 0;
        if (flag)
        {
            if (mListView != null && mSadface != null)
            {
                View view;
                if (!mIsSadFacePartOfHeader)
                {
                    mListView.setVisibility(8);
                } else
                {
                    mListView.setVisibility(0);
                    if (!mIsSadFaceHeaderAdded)
                    {
                        mListView.addHeaderView(mSadface);
                        mIsSadFaceHeaderAdded = true;
                    }
                }
                mSadface.setVisibility(0);
                view = mSadface.findViewById(0x7f0a00e3);
                if (view != null)
                {
                    if (!flag1)
                    {
                        i = 8;
                    }
                    view.setVisibility(i);
                }
            }
        } else
        if (mListView != null && mSadface != null)
        {
            mListView.setVisibility(0);
            if (mIsSadFacePartOfHeader)
            {
                if (mIsSadFaceHeaderAdded)
                {
                    mListView.removeHeaderView(mSadface);
                    mSadface.setVisibility(8);
                    mIsSadFacePartOfHeader = false;
                    return;
                }
            } else
            {
                mSadface.setVisibility(8);
                return;
            }
        }
    }
}
