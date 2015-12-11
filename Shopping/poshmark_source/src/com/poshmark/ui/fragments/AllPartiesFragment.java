// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersListView;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.data_model.adapters.AllPartiesAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PartyFragment, PartyInviteFragment

public class AllPartiesFragment extends PMFragment
    implements PMNotificationListener
{

    public static boolean bIsFetchingFeedOnScroll = false;
    private AllPartiesAdapter adapter;
    StickyListHeadersListView eventListView;
    android.view.View.OnTouchListener touchListener;

    public AllPartiesFragment()
    {
        adapter = null;
        touchListener = new android.view.View.OnTouchListener() {

            final AllPartiesFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }

            
            {
                this$0 = AllPartiesFragment.this;
                super();
            }
        };
    }

    private void setListScrollHandler()
    {
        eventListView.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final AllPartiesFragment this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
                if (!AllPartiesFragment.bIsFetchingFeedOnScroll && k > 0 && i + j >= k)
                {
                    AllPartiesFragment.bIsFetchingFeedOnScroll = true;
                }
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
            }

            
            {
                this$0 = AllPartiesFragment.this;
                super();
            }
        });
    }

    private void setupPartyList()
    {
        updateList();
        eventListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AllPartiesFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (CustomMatrixCursor)((CursorAdapter)eventListView.getWrappedAdapter()).getCursor();
                if (adapterview.moveToPosition(i))
                {
                    adapterview = (PartyEvent)adapterview.get(adapterview.getColumnIndex(PMData.DATA_COL));
                    Object obj = adapterview.getId();
                    view = new Bundle();
                    view.putString("ID", ((String) (obj)));
                    obj = (PMActivity)getActivity();
                    if (obj != null && ((PMActivity) (obj)).isActivityInForeground())
                    {
                        if (adapterview.isHappeningNow() || adapterview.isPastEvent())
                        {
                            ((PMActivity) (obj)).launchFragment(view, com/poshmark/ui/fragments/PartyFragment, adapterview);
                        } else
                        if (adapterview.isFutureEvent())
                        {
                            ((PMActivity) (obj)).launchFragment(view, com/poshmark/ui/fragments/PartyInviteFragment, adapterview);
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = AllPartiesFragment.this;
                super();
            }
        });
    }

    private void updateList()
    {
        if (getUserVisibleHint() && GlobalPartiesController.getGlobalPartiesController().isModelPopulated())
        {
            CustomMatrixCursor custommatrixcursor = new CustomMatrixCursor(new String[] {
                PMData.ID_COL, PMData.DATA_COL
            });
            GlobalPartiesController.getGlobalPartiesController().fillCursor(custommatrixcursor);
            adapter.changeCursor(custommatrixcursor);
            adapter.notifyDataSetChanged();
            bIsFetchingFeedOnScroll = false;
        }
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.EVENTS_FETCH_COMPLETE"))
        {
            updateList();
        } else
        {
            if (intent.getAction().equals("com.poshmark.intents.PARTY_EVENT_END"))
            {
                updateList();
                return;
            }
            if (intent.getAction().equals("com.poshmark.intents.PARTY_EVENT_START"))
            {
                updateList();
                return;
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        adapter = new AllPartiesAdapter(getActivity(), null, 0x80000000);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.EVENTS_FETCH_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.PARTY_EVENT_END", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.PARTY_EVENT_START", this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03000e, viewgroup, false);
        eventListView = (StickyListHeadersListView)layoutinflater.findViewById(0x7f0c005c);
        eventListView.setAdapter(adapter);
        eventListView.setOnHeaderClickListener(null);
        setListScrollHandler();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onPMResume()
    {
        super.onPMResume();
        setupPartyList();
    }

    public void onStop()
    {
        super.onStop();
        adapter.clearImageList();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "parties_home_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(0x7f0601eb);
        showRefreshButton(false);
    }

}
