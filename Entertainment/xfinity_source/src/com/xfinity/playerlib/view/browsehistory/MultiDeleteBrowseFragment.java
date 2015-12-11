// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.model.provider.RetryingTaskExecutionListener;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.view.ScrollStateTracker;
import com.xfinity.playerlib.view.favorite.MultiDeleteActionFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            MultiDeleteBrowseAdapter

public abstract class MultiDeleteBrowseFragment extends MultiDeleteActionFragment
    implements ScrollStateTracker
{
    public static interface ItemClickListener
    {

        public abstract void onItemClicked(Object obj);
    }


    public static String EXTRA_BABY_GUIDE_MODE = "babyGuideMode";
    private AbsListView absListView;
    protected MultiDeleteBrowseAdapter adapter;
    protected AlternateInterfaceListener alternateInterfaceListener;
    private ViewGroup bodyContainer;
    private ArrayList checkedItemPositionsToRestore;
    protected Long currentlyPlayingVideoId;
    private final ErrorDialogFactory errorDialogFactory = PlayerContainer.getInstance().getErrorDialogFactory();
    protected boolean inBabyGuideMode;
    private LayoutInflater layoutInflator;
    private ViewGroup loadingIndicator;
    private TextView noContentMessage;
    private int scrollState;
    private RetryingTaskExecutionListener taskExecutionListener;

    public MultiDeleteBrowseFragment()
    {
        checkedItemPositionsToRestore = Lists.newArrayList();
    }

    private ArrayList getCheckedItemPositions()
    {
        SparseBooleanArray sparsebooleanarray = absListView.getCheckedItemPositions();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < sparsebooleanarray.size(); i++)
        {
            if (sparsebooleanarray.valueAt(i))
            {
                arraylist.add(Integer.valueOf(sparsebooleanarray.keyAt(i)));
            }
        }

        return arraylist;
    }

    private void hideNoContentMessage()
    {
        noContentMessage.setVisibility(8);
        safeSetVisibility(bodyContainer, 0);
    }

    private void showNoContentMessage()
    {
        noContentMessage.setVisibility(0);
        safeSetVisibility(bodyContainer, 8);
    }

    private void toggleItem(int i)
    {
        boolean flag = false;
        SparseBooleanArray sparsebooleanarray = absListView.getCheckedItemPositions();
        AbsListView abslistview = absListView;
        if (!sparsebooleanarray.get(i, false))
        {
            flag = true;
        }
        abslistview.setItemChecked(i, flag);
        showSelectedCountOnActionMenu();
    }

    private void uncheckAll()
    {
        for (int i = 0; i < absListView.getCount(); i++)
        {
            absListView.setItemChecked(i, false);
        }

    }

    protected abstract MultiDeleteBrowseAdapter createAdapter(LayoutInflater layoutinflater);

    protected abstract void deleteItem(Object obj);

    protected void deleteItems()
    {
        Object obj = getCheckedItemPositions();
        ArrayList arraylist = Lists.newArrayList();
        AbsListView abslistview = getListView();
        Object obj1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(obj1))
        {
            Integer integer = (Integer)((Iterator) (obj)).next();
            obj1 = CommonUtils.uncheckedCast(abslistview.getItemAtPosition(integer.intValue()));
            abslistview.setItemChecked(integer.intValue(), false);
            deleteItem(obj1);
        }

        adapter.removeItems(arraylist);
        int i = arraylist.size();
        if (i > 0)
        {
            String s = getActivity().getResources().getQuantityString(com.xfinity.playerlib.R.plurals.items_removed, i, new Object[] {
                Integer.valueOf(i)
            });
            Toast.makeText(getActivity(), s, 0).show();
            alternateInterfaceListener.getTalkDelegate().speak(s);
        }
        if (adapter.getData().size() == 0)
        {
            showNoContentMessage();
        }
    }

    protected int getCheckedItemsCount()
    {
        return getCheckedItemPositions().size();
    }

    protected abstract List getData(Object obj);

    protected abstract TaskExecutor getDataTaskExecutor();

    protected abstract ItemClickListener getItemClickListener();

    protected abstract CharSequence getListHeaderText();

    public AbsListView getListView()
    {
        return absListView;
    }

    protected abstract int getListViewId();

    protected int getTotalItemsCount()
    {
        return adapter.getCount();
    }

    protected void hideLoading()
    {
        if (loadingIndicator != null && bodyContainer != null)
        {
            loadingIndicator.setVisibility(8);
            bodyContainer.setVisibility(0);
        }
    }

    protected boolean isEditEnabled()
    {
        return !inBabyGuideMode;
    }

    public boolean isFlinging()
    {
        return scrollState == 2;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutInflator = layoutinflater;
        Object obj = new Bundle();
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null)
        {
            ((Bundle) (obj)).putAll(intent.getExtras());
        }
        if (getArguments() != null)
        {
            ((Bundle) (obj)).putAll(getArguments());
        }
        inBabyGuideMode = ((Bundle) (obj)).getBoolean(EXTRA_BABY_GUIDE_MODE, false);
        currentlyPlayingVideoId = Long.valueOf(((Bundle) (obj)).getLong("EXTRA_CURRENT_WATCH_VIDEO_ID", 0L));
        if (currentlyPlayingVideoId.longValue() == 0L)
        {
            obj = null;
        } else
        {
            obj = currentlyPlayingVideoId;
        }
        currentlyPlayingVideoId = ((Long) (obj));
        if (bundle != null && bundle.containsKey("previouslyCheckedItemPositions"))
        {
            checkedItemPositionsToRestore = bundle.getIntegerArrayList("previouslyCheckedItemPositions");
        }
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        loadingIndicator = (ViewGroup)layoutinflater.findViewById(com.xfinity.playerlib.R.id.loading_indicator);
        bodyContainer = (ViewGroup)layoutinflater.findViewById(com.xfinity.playerlib.R.id.body_container);
        absListView = (AbsListView)layoutinflater.findViewById(getListViewId());
        noContentMessage = (TextView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.no_content_message);
        setupListView(absListView);
        return layoutinflater;
    }

    protected void onEditModeChanged(boolean flag)
    {
        if (!flag)
        {
            uncheckAll();
        }
        adapter.setEditMode(flag);
    }

    public void onPause()
    {
        super.onPause();
        checkedItemPositionsToRestore = getCheckedItemPositions();
    }

    protected void onResourceFetched(Object obj)
    {
        setData(getData(obj));
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        showLoading();
        android.content.DialogInterface.OnCancelListener oncancellistener = new android.content.DialogInterface.OnCancelListener() {

            final MultiDeleteBrowseFragment this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                hideLoading();
            }

            
            {
                this$0 = MultiDeleteBrowseFragment.this;
                super();
            }
        };
        TaskExecutor taskexecutor = getDataTaskExecutor();
        taskExecutionListener = (RetryingTaskExecutionListener)taskexecutor.execute(new RetryingTaskExecutionListener(taskexecutor, getActivity(), errorDialogFactory, oncancellistener) {

            final MultiDeleteBrowseFragment this$0;

            public void onPostExecute(Object obj)
            {
                onResourceFetched(obj);
                if (ACCESSIBILITY_ANNOUNCE_LOADED)
                {
                    int i;
                    for (obj = checkedItemPositionsToRestore.iterator(); ((Iterator) (obj)).hasNext(); absListView.setItemChecked(i, true))
                    {
                        i = ((Integer)((Iterator) (obj)).next()).intValue();
                    }

                    showSelectedCountOnActionMenu();
                }
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.id.ACCESSIBILITY_ANNOUNCE_LOADED);
            }

            public void onPreAsynchronousExecute()
            {
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.loading);
            }

            
            {
                this$0 = MultiDeleteBrowseFragment.this;
                super(taskexecutor, context, errordialogfactory, oncancellistener);
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putIntegerArrayList("previouslyCheckedItemPositions", checkedItemPositionsToRestore);
    }

    public void onStop()
    {
        super.onStop();
        getDataTaskExecutor().cancelNotificationsFor(taskExecutionListener);
    }

    protected void setData(List list)
    {
        hideLoading();
        if (list.size() > 0)
        {
            hideNoContentMessage();
            adapter.setData(list);
            adapter.notifyDataSetChanged();
            return;
        } else
        {
            showNoContentMessage();
            return;
        }
    }

    protected void setupListView(AbsListView abslistview)
    {
        abslistview.setChoiceMode(2);
        if (!inBabyGuideMode)
        {
            abslistview.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() );
        }
        adapter = createAdapter(layoutInflator);
        abslistview.setAdapter(adapter);
        abslistview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() );
        abslistview.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final MultiDeleteBrowseFragment this$0;

            public void onScroll(AbsListView abslistview1, int i, int j, int k)
            {
            }

            public void onScrollStateChanged(AbsListView abslistview1, int i)
            {
                scrollState = i;
            }

            
            {
                this$0 = MultiDeleteBrowseFragment.this;
                super();
            }
        });
    }

    protected void showLoading()
    {
        if (loadingIndicator != null && bodyContainer != null)
        {
            loadingIndicator.setVisibility(0);
            bodyContainer.setVisibility(8);
        }
    }





/*
    static int access$1002(MultiDeleteBrowseFragment multideletebrowsefragment, int i)
    {
        multideletebrowsefragment.scrollState = i;
        return i;
    }

*/








}
