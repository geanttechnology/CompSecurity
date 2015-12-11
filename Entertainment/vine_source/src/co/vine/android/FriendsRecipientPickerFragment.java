// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import co.vine.android.api.VineRecipient;
import co.vine.android.client.AppController;
import co.vine.android.provider.FriendsPickerExclusiveCursor;
import co.vine.android.provider.Vine;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.StringAnchorManager;
import com.edisonwang.android.slog.SLog;
import com.twitter.android.widget.RefreshableListView;
import java.util.ArrayList;

// Referenced classes of package co.vine.android:
//            BaseRecipientPickerFragment, FriendsPickerAdapter, RecipientPickerActivity, FindFriendsActivity, 
//            FriendsPickerViewHolder

public class FriendsRecipientPickerFragment extends BaseRecipientPickerFragment
    implements android.view.View.OnClickListener
{
    private class FilterRunnable
        implements Runnable
    {

        final FriendsRecipientPickerFragment this$0;

        public void run()
        {
            mLastFiredQuery = mQueryString;
            mAppController.fetchFriendsTypeAhead(mQueryString);
        }

        public FilterRunnable(String s)
        {
            this$0 = FriendsRecipientPickerFragment.this;
            super();
            mQueryString = s;
        }
    }


    private static final int LOADER_ID_FILTER_FRIENDS = 1;
    private StringAnchorManager mAnchorManager;
    private RecipientPickerActivity mCallback;
    private Button mFindFriendsCta;
    private FriendsPickerAdapter mFriendsPickerAdapter;
    private boolean mIsFetched;
    private boolean mIsFiltering;
    private boolean mIsLoaderReady;
    private String mLastFiredQuery;
    private long mRefreshingTime;

    public FriendsRecipientPickerFragment()
    {
    }

    private void fetchContent(int i)
    {
        if (!hasPendingRequest(i)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        SLog.d((new StringBuilder()).append("Fetching content: ").append(i).toString());
        i;
        JVM INSTR tableswitch 1 4: default 64
    //                   1 103
    //                   2 98
    //                   3 93
    //                   4 98;
           goto _L3 _L4 _L5 _L6 _L5
_L4:
        break MISSING_BLOCK_LABEL_103;
_L6:
        break; /* Loop/switch isn't completed */
_L3:
        int j = 1;
_L8:
        String s = mAppController.fetchFriends(j, 0);
        if (s != null)
        {
            showProgress(i);
            addRequest(s, i);
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
        j = 1;
          goto _L8
_L5:
        j = 1;
          goto _L8
        j = 3;
          goto _L8
    }

    private void showFindFriendsCta(boolean flag)
    {
        Button button = mFindFriendsCta;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        button.setVisibility(i);
    }

    protected void handleFocus()
    {
        if (!mIsFetched)
        {
            showProgress(3);
            fetchContent(3);
        }
        hideProgress(3);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mAnchorManager = Vine.getUserSectionsAnchorManager(getActivity(), 0);
        mContentUri = ContentUris.withAppendedId(co.vine.android.provider.Vine.UserGroupsView.CONTENT_URI_FRIENDS, mAppController.getActiveId());
        mProjection = co.vine.android.provider.VineDatabaseSQL.UsersQuery.PROJECTION;
        refreshSelections();
        ((RefreshableListView)mListView).disablePTR();
        mSortOrder = "last_section_refresh DESC, section_index ASC";
        if (mCursorAdapter == null)
        {
            mFriendsPickerAdapter = new FriendsPickerAdapter(getActivity(), mAppController, 0, this);
            mCursorAdapter = mFriendsPickerAdapter;
        }
        mListView.setAdapter(mCursorAdapter);
        mListView.setChoiceMode(0);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mCallback = (RecipientPickerActivity)activity;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362117: 
            FlurryUtils.trackVisitFindFriends("VM Share");
            break;
        }
        startActivity(new Intent(getActivity(), co/vine/android/FindFriendsActivity));
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        switch (i)
        {
        default:
            return super.onCreateLoader(i, bundle);

        case 1: // '\001'
            bundle = ContentUris.withAppendedId(co.vine.android.provider.Vine.UserGroupsView.CONTENT_URI_FRIENDS_FILTER, mAppController.getActiveId()).buildUpon();
            break;
        }
        bundle.appendQueryParameter("filter", Uri.encode(mQueryString));
        bundle.appendQueryParameter("group_type", String.valueOf(10));
        return new CursorLoader(getActivity(), bundle.build(), mProjection, null, null, null);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return createView(layoutinflater, 0x7f03007c, viewgroup);
    }

    protected void onGetFriendsComplete(int i)
    {
        mIsFetched = true;
        boolean flag;
        if (mRefreshingTime != mAnchorManager.getRefreshTime())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SLog.d("Has refresh time changed? {}", Boolean.valueOf(flag));
        hideProgress(1);
        if (flag)
        {
            refreshSelections();
            mIsLoaderReady = true;
            initLoader(0);
        } else
        if (!mIsLoaderReady)
        {
            mIsLoaderReady = true;
            initLoader(0);
            return;
        }
    }

    public void onGetFriendsTypeAheadComplete(String s, ArrayList arraylist)
    {
        if (arraylist != null && s.equals(mLastFiredQuery))
        {
            onLoadFinished(null, new FriendsPickerExclusiveCursor(arraylist));
        } else
        {
            s = getLoaderManager().getLoader(1);
            if (s != null && s.isStarted())
            {
                restartLoader(1);
            } else
            {
                initLoader(1);
            }
        }
        mLastFiredQuery = null;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (FriendsPickerViewHolder)view.getTag();
        if (isRecipientSelected(((FriendsPickerViewHolder) (adapterview)).recipient))
        {
            removeRecipient(((FriendsPickerViewHolder) (adapterview)).recipient);
            adapterview.setSelected(getResources(), false);
            return;
        } else
        {
            addRecipient(((FriendsPickerViewHolder) (adapterview)).recipient);
            adapterview.setSelected(getResources(), true);
            return;
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        if ((!mIsFiltering || loader == null) && (mIsFiltering || loader != null))
        {
            Object obj = cursor;
            if (!(cursor instanceof FriendsPickerExclusiveCursor))
            {
                obj = new FriendsPickerExclusiveCursor(cursor);
            }
            ((FriendsPickerExclusiveCursor)obj).prepare();
            int i = ((Cursor) (obj)).getCount();
            boolean flag;
            if (i < 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showSadface(flag);
            if (i < 10)
            {
                mCallback.showPage("address_book");
                showFindFriendsCta(true);
            }
            super.onLoadFinished(loader, ((Cursor) (obj)));
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onRecipientItemRemoved(VineRecipient vinerecipient)
    {
        mFriendsPickerAdapter.onRecipientItemRemoved(vinerecipient);
    }

    protected void onScrollLastItem(Cursor cursor)
    {
        if (!mIsFiltering && mAnchorManager.haveMore())
        {
            fetchContent(1);
            showProgress(7);
        }
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        charsequence = charsequence.toString();
        if (!TextUtils.isEmpty(charsequence))
        {
            mIsFiltering = true;
            mHandler.postDelayed(new FilterRunnable(charsequence), 150L);
            return;
        } else
        {
            mIsFiltering = false;
            restartLoader(0);
            return;
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        mFindFriendsCta = (Button)view.findViewById(0x7f0a0145);
        mFindFriendsCta.setOnClickListener(this);
        mFindFriendsCta.bringToFront();
    }

    public void refresh()
    {
        showProgress(3);
        handleFocus();
    }

    public void refreshSelections()
    {
        mRefreshingTime = mAnchorManager.getRefreshTime();
        SLog.d("Refreshing time: {}.", Long.valueOf(mRefreshingTime));
        mSelection = "section_type=0 AND last_section_refresh=?";
        mSelArgs = (new String[] {
            String.valueOf(mRefreshingTime)
        });
    }

    protected void showSadface(boolean flag)
    {
        super.showSadface(flag, flag);
        showFindFriendsCta(flag);
    }


/*
    static String access$002(FriendsRecipientPickerFragment friendsrecipientpickerfragment, String s)
    {
        friendsrecipientpickerfragment.mLastFiredQuery = s;
        return s;
    }

*/
}
