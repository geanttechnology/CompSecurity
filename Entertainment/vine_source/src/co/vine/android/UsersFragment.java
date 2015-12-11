// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import co.vine.android.widget.UsersMemoryAdapterHelper;

// Referenced classes of package co.vine.android:
//            BaseArrayListFragment

public class UsersFragment extends BaseArrayListFragment
{

    private final UsersMemoryAdapterHelper mHelper;

    public UsersFragment()
    {
        mHelper = new UsersMemoryAdapterHelper(this, mPendingRequestHelper, "", "");
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mListView.setAdapter(mHelper.getAdapter(getActivity(), mAppController));
        mListView.setDividerHeight(0);
        mAppSessionListener = mHelper.getAppSessionListener();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mHelper.onCreate(getArguments(), bundle, mRefreshable);
    }

    public void onListItemClick(ListView listview, View view, int i, long l)
    {
        mHelper.onListItemClick(l);
    }

    public void onResume()
    {
        super.onResume();
        mHelper.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        mHelper.onSaveInstanceState(bundle);
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        mHelper.onScroll(mListState, i, j, k);
    }

    protected void refresh()
    {
        mHelper.refresh();
    }
}
