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
import co.vine.android.util.Util;
import co.vine.android.widget.TagViewHolder;
import java.util.concurrent.ExecutorService;

// Referenced classes of package co.vine.android:
//            BaseSearchFragment, TagsAdapter, ExploreVideoListActivity, PendingRequest

public class TagSearchFragment extends BaseSearchFragment
{
    private class TagSearchSessionListener extends AppSessionListener
    {

        final TagSearchFragment this$0;

        public void onTagSearchComplete(String s, int i, String s1, int j, int k, int l)
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

        private TagSearchSessionListener()
        {
            this$0 = TagSearchFragment.this;
            super();
        }

    }


    public TagSearchFragment()
    {
    }

    public void cleanSearchResults()
    {
        mExecutor.execute(new Runnable() {

            final TagSearchFragment this$0;

            public void run()
            {
                mDbHelper.cleanTagSearchResults();
            }

            
            {
                this$0 = TagSearchFragment.this;
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
        String s = mAppController.searchTags(mEncodedQueryString, j);
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
        return 3;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (mCursorAdapter == null)
        {
            mProjection = co.vine.android.provider.VineDatabaseSQL.TagsQuery.PROJECTION;
            mSortOrder = "_id ASC";
            mCursorAdapter = new TagsAdapter(getActivity(), mAppController, 0);
        }
        mListView.setAdapter(mCursorAdapter);
        mAppSessionListener = new TagSearchSessionListener();
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(getActivity(), co.vine.android.provider.Vine.TagSearchResults.CONTENT_URI, mProjection, null, null, mSortOrder);
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        listview = ((ListView) (view.getTag()));
        if (listview instanceof TagViewHolder)
        {
            listview = (TagViewHolder)listview;
            startActivity(ExploreVideoListActivity.getIntent(getActivity(), "tag", ((TagViewHolder) (listview)).tagName));
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
        if (cursor.getInt(4) == 0 && cursor.getCount() <= 400)
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
