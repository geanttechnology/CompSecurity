// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.provider.VineDatabaseHelper;
import co.vine.android.service.PendingAction;
import co.vine.android.util.Util;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

// Referenced classes of package co.vine.android:
//            BaseSearchFragment, UsersAdapter, ProfileActivity, PendingRequestHelper, 
//            PendingRequest

public class UserSearchFragment extends BaseSearchFragment
{
    private class UserSearchSessionListener extends AppSessionListener
    {

        final UserSearchFragment this$0;

        public void onCaptchaRequired(String s, String s1, PendingAction pendingaction)
        {
            if (removeRequest(s) != null)
            {
                mPendingRequestHelper.onCaptchaRequired(getActivity(), s, pendingaction.actionCode, pendingaction.bundle, s1);
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            ((UsersAdapter)mCursorAdapter).setUserImages(hashmap);
        }

        public void onUserSearchComplete(String s, int i, String s1, int j, int k, int l)
        {
            s = removeRequest(s);
            if (s == null) goto _L2; else goto _L1
_L1:
            hideProgress(((PendingRequest) (s)).fetchType);
            i;
            JVM INSTR tableswitch 200 200: default 44
        //                       200 76;
               goto _L3 _L4
_L3:
            s = s1;
            if (TextUtils.isEmpty(s1))
            {
                s = getString(0x7f0e00cf);
            }
            Util.showCenteredToast(getActivity(), s);
_L2:
            return;
_L4:
            if (j < 1)
            {
                cleanSearchResults();
                showSadface(true, false);
                return;
            }
            if (true) goto _L2; else goto _L5
_L5:
        }

        private UserSearchSessionListener()
        {
            this$0 = UserSearchFragment.this;
            super();
        }

    }


    private static final String EVENT_SOURCE_TITLE = "User Search Results";

    public UserSearchFragment()
    {
    }

    public void cleanSearchResults()
    {
        mExecutor.execute(new Runnable() {

            final UserSearchFragment this$0;

            public void run()
            {
                mDbHelper.cleanUserSearchResults();
            }

            
            {
                this$0 = UserSearchFragment.this;
                super();
            }
        });
    }

    protected void fetchContent(int i)
    {
        if (!hasPendingRequest(i)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        i;
        JVM INSTR tableswitch 1 4: default 40
    //                   1 82
    //                   2 77
    //                   3 72
    //                   4 77;
           goto _L3 _L4 _L5 _L6 _L5
_L4:
        break MISSING_BLOCK_LABEL_82;
_L6:
        break; /* Loop/switch isn't completed */
_L3:
        int j = 1;
_L8:
        String s = mAppController.searchUsers(mEncodedQueryString, j);
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
        j = 2;
          goto _L8
        j = 3;
          goto _L8
    }

    public int getMinimumSearchQueryLength()
    {
        return 2;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (mCursorAdapter == null)
        {
            mProjection = co.vine.android.provider.VineDatabaseSQL.UsersQuery.PROJECTION;
            mSortOrder = "_id ASC";
            mCursorAdapter = new UsersAdapter(getActivity(), mAppController, false, this, null, 0);
        }
        mListView.setAdapter(mCursorAdapter);
        mListView.setDividerHeight(0);
        mAppSessionListener = new UserSearchSessionListener();
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(getActivity(), co.vine.android.provider.Vine.UserGroupsView.CONTENT_URI_USER_SEARCH_RESULTS, mProjection, null, null, mSortOrder);
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        if (l > 0L)
        {
            ProfileActivity.start(getActivity(), l, "User Search Results");
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        super.onLoadFinished(loader, cursor);
        hideProgress(3);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    protected void onScrollLastItem(Cursor cursor)
    {
        if (cursor.getInt(17) == 0 && cursor.getCount() <= 400)
        {
            fetchContent(1);
        }
    }

    public void performSearch()
    {
        hideSearchHint();
        cleanSearchResults();
        fetchContent(3);
    }
}
