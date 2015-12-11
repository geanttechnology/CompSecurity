// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import co.vine.android.client.AppController;
import co.vine.android.client.Session;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.util.Util;
import co.vine.android.widget.UserViewHolder;

// Referenced classes of package co.vine.android:
//            BaseCursorListFragment, UsersAdapter, FindFriendsBaseActivity, Friendships, 
//            FindFriendsNUXActivity

public abstract class FindFriendsBaseFragment extends BaseCursorListFragment
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener, FindFriendsNUXActivity.FilterableFriendsList
{

    protected static final int DIALOG_STORE_CONTACTS = 1;
    protected static final String EVENT_SOURCE_TITLE = "Find Friends: Address";
    protected static final int LOADER_ID_FILTER = 1;
    protected static final String STATE_FETCHED = "fetch";
    protected static final String STATE_FRIENDSHIPS = "friendships";
    protected FindFriendsBaseActivity mActivity;
    protected StyleSpan mBold[];
    protected boolean mFetched;
    protected Friendships mFriendships;
    protected int mNewFollowsCount;
    protected String mProjection[];
    protected volatile String mSearchQuery;
    protected String mSortOrder;

    public FindFriendsBaseFragment()
    {
    }

    protected void fetchContent(int i)
    {
        mFetched = true;
        showProgress(i);
        ProgressDialog progressdialog;
        switch (i)
        {
        default:
            return;

        case 3: // '\003'
            progressdialog = new ProgressDialog(getActivity(), 0x7f0f0037);
            break;
        }
        progressdialog.setMessage(getString(0x7f0e00f4));
        progressdialog.setProgressStyle(0);
        progressdialog.show();
        mProgressDialog = progressdialog;
        mAppController.fetchAddressFriends(mAppController.getActiveSession());
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (mCursorAdapter == null)
        {
            mProjection = co.vine.android.provider.VineDatabaseSQL.UsersQuery.PROJECTION;
            mSortOrder = "username ASC";
            mCursorAdapter = new UsersAdapter(getActivity(), mAppController, true, this, mFriendships, 0);
        }
        mListView.setAdapter(mCursorAdapter);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mActivity = (FindFriendsBaseActivity)activity;
    }

    public abstract void onClick(View view);

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mBold = (new StyleSpan[] {
            new StyleSpan(1)
        });
        if (bundle != null)
        {
            if (bundle.containsKey("fetch"))
            {
                mFetched = bundle.getBoolean("fetch");
            }
            if (bundle.containsKey("friendships"))
            {
                mFriendships = (Friendships)bundle.getParcelable("friendships");
            }
        } else
        {
            mFriendships = new Friendships();
        }
        mAppController.removeUsers(mAppController.getActiveSession(), 7);
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        switch (i)
        {
        default:
            bundle = ContentUris.withAppendedId(co.vine.android.provider.Vine.UserGroupsView.CONTENT_URI_FIND_FRIENDS_ADDRESS, mAppController.getActiveId());
            return new CursorLoader(getActivity(), bundle, mProjection, null, null, mSortOrder);

        case 1: // '\001'
            bundle = ContentUris.withAppendedId(co.vine.android.provider.Vine.UserGroupsView.CONTENT_URI_FRIENDS_FILTER, mAppController.getActiveId()).buildUpon();
            break;
        }
        bundle.appendQueryParameter("filter", Uri.encode(mSearchQuery));
        bundle.appendQueryParameter("group_type", String.valueOf(7));
        return new CursorLoader(getActivity(), bundle.build(), mProjection, null, null, mSortOrder);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = createView(layoutinflater, 0x7f03003d, viewgroup);
        mListView.setDividerHeight(0);
        return layoutinflater;
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        VineAccountHelper.setDidShowStoreContactsPrompt(AccountManager.get(getActivity()), VineAccountHelper.getAccount(getActivity(), mAppController.getActiveSession().getLoginEmail()));
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        boolean flag;
        if (j == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mAppController.updateEnableAddressBook(flag);
        Util.getDefaultSharedPrefs(getActivity()).edit().putBoolean("enable_address_book", flag).apply();
        fetchContent(3);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (view.getTag() instanceof UserViewHolder)
        {
            startProfileActivity(((UserViewHolder)view.getTag()).userId);
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        super.onLoadFinished(loader, cursor);
        if (cursor.getCount() > 0 && (mActivity instanceof FindFriendsNUXActivity))
        {
            ((FindFriendsNUXActivity)mActivity).showSearchIcon(true);
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onLoaderReset(Loader loader)
    {
        mCursorAdapter.swapCursor(null);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("fetch", mFetched);
        bundle.putParcelable("friendships", mFriendships);
    }

    public abstract void onTextChanged(CharSequence charsequence, int i, int j, int k);

    public boolean shouldShowSearchIcon()
    {
        return mCursorAdapter != null && !mCursorAdapter.isEmpty();
    }

    protected abstract void startProfileActivity(long l);
}
