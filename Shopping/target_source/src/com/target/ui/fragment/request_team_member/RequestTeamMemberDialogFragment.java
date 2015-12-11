// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.request_team_member;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.a.h;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.adapter.request_team_member.DepartmentAdjacencyAdapter;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.fragment.request_team_member.a.a;
import com.target.ui.service.RequestTeamMemberAlarmManager;
import com.target.ui.service.e;
import com.target.ui.service.k;
import com.target.ui.service.l;
import com.target.ui.service.provider.d;
import com.target.ui.service.provider.f;
import com.target.ui.util.al;
import com.target.ui.view.DepartmentAdjacencyBadgeView;
import com.target.ui.view.TargetButton;
import com.target.ui.view.common.PulseView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import java.util.List;

public class RequestTeamMemberDialogFragment extends BaseDialogFragment
    implements com.target.ui.adapter.request_team_member.DepartmentAdjacencyAdapter.a, com.target.ui.fragment.request_team_member.a.a
{
    static class Views extends com.target.ui.view.a
    {

        TargetButton actionButton;
        RelativeLayout buttonContainer;
        TargetButton cancelButton;
        ImageView headerImage;
        View listDivider;
        DepartmentAdjacencyBadgeView mBadgeView;
        TargetErrorView mErrorView;
        View progressContainer;
        PulseView pulseView;
        RecyclerView recyclerView;
        final View rootView;
        TextView tvRequestTeamMemberExplaination;
        TextView tvRequestTeamMemberHeader;
        TextView tvRequestTeamMemberTitle;

        public Views(View view)
        {
            super(view);
            rootView = view;
        }
    }

    public static interface a
    {

        public abstract void b(Guest guest);
    }


    private static final String KEY_LAST_KNOWN_X = "lastKnownX";
    private static final String KEY_LAST_KNOWN_Y = "lastKnownY";
    private static final String KEY_STORE = "store";
    private DepartmentAdjacencyAdapter mAdapter;
    private List mDepartmentAdjacencies;
    private a mRequestTeamMemberDialogListener;
    private com.target.ui.fragment.request_team_member.b.a mRequestTeamMemberPresenter;
    private Views mViews;

    public RequestTeamMemberDialogFragment()
    {
    }

    public static RequestTeamMemberDialogFragment a(Fragment fragment, Store store, int i1, int j1)
    {
        RequestTeamMemberDialogFragment requestteammemberdialogfragment = new RequestTeamMemberDialogFragment();
        requestteammemberdialogfragment.setTargetFragment(fragment, 0);
        fragment = new Bundle();
        fragment.putParcelable("store", store);
        fragment.putInt("lastKnownX", i1);
        fragment.putInt("lastKnownY", j1);
        requestteammemberdialogfragment.setArguments(fragment);
        return requestteammemberdialogfragment;
    }

    static com.target.ui.fragment.request_team_member.b.a a(RequestTeamMemberDialogFragment requestteammemberdialogfragment)
    {
        return requestteammemberdialogfragment.mRequestTeamMemberPresenter;
    }

    private void a(Context context)
    {
        BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

            final RequestTeamMemberDialogFragment this$0;

            public void onReceive(Context context1, Intent intent)
            {
                if (com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment.a(RequestTeamMemberDialogFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment.a(RequestTeamMemberDialogFragment.this).j();
                    return;
                }
            }

            
            {
                this$0 = RequestTeamMemberDialogFragment.this;
                super();
            }
        };
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("request_team_member_minimum_time_event");
        android.support.v4.a.h.a(context).a(broadcastreceiver, intentfilter);
    }

    private void l()
    {
        mViews.actionButton.setOnClickListener(new android.view.View.OnClickListener() {

            final RequestTeamMemberDialogFragment this$0;

            public void onClick(View view)
            {
                com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment.a(RequestTeamMemberDialogFragment.this).g();
            }

            
            {
                this$0 = RequestTeamMemberDialogFragment.this;
                super();
            }
        });
        mViews.cancelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final RequestTeamMemberDialogFragment this$0;

            public void onClick(View view)
            {
                com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment.a(RequestTeamMemberDialogFragment.this).h();
            }

            
            {
                this$0 = RequestTeamMemberDialogFragment.this;
                super();
            }
        });
        mViews.mErrorView.setClickListener(new c() {

            final RequestTeamMemberDialogFragment this$0;

            public void A_()
            {
                com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment.a(RequestTeamMemberDialogFragment.this).i();
            }

            
            {
                this$0 = RequestTeamMemberDialogFragment.this;
                super();
            }
        });
    }

    public void a()
    {
        al.a(mViews.tvRequestTeamMemberTitle, true);
        mViews.tvRequestTeamMemberTitle.setText(getResources().getString(0x7f0904cd));
    }

    public void a(com.target.mothership.model.a.c.a a1)
    {
        mRequestTeamMemberPresenter.b(a1);
    }

    public void a(Guest guest)
    {
        if (mRequestTeamMemberDialogListener == null)
        {
            return;
        } else
        {
            mRequestTeamMemberDialogListener.b(guest);
            return;
        }
    }

    public void a(String s)
    {
        al.a(new View[] {
            mViews.recyclerView, mViews.listDivider, mViews.tvRequestTeamMemberHeader
        });
        al.a(mViews.tvRequestTeamMemberExplaination, true);
        mViews.tvRequestTeamMemberExplaination.setText(getResources().getString(0x7f0904cf, new Object[] {
            s
        }));
    }

    public void a(List list)
    {
        mDepartmentAdjacencies = list;
        al.b(new View[] {
            mViews.recyclerView, mViews.listDivider
        });
        al.a(mViews.tvRequestTeamMemberExplaination, false);
        mAdapter.a(mDepartmentAdjacencies);
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            al.a(mViews.buttonContainer, true);
        }
        al.a(mViews.cancelButton, flag);
    }

    public void b()
    {
        mViews.tvRequestTeamMemberExplaination.setText(getResources().getString(0x7f0904d0));
    }

    public void b(com.target.mothership.model.a.c.a a1)
    {
        mViews.mBadgeView.setDepartmentAdjacency(a1);
        al.a(mViews.pulseView, true);
        mViews.pulseView.a();
    }

    public void b(boolean flag)
    {
        al.a(mViews.tvRequestTeamMemberHeader, flag);
        mViews.tvRequestTeamMemberHeader.setText(getResources().getString(0x7f0904f7));
    }

    public void c()
    {
        mViews.tvRequestTeamMemberTitle.setText(getResources().getString(0x7f0904ce));
    }

    public void c(boolean flag)
    {
        al.a(mViews.headerImage, flag);
    }

    public void d()
    {
        mViews.pulseView.b();
    }

    public void d(boolean flag)
    {
        if (flag)
        {
            al.a(mViews.mErrorView, false);
        }
        al.a(mViews.progressContainer, flag);
    }

    public void e()
    {
        al.a(mViews.buttonContainer, false);
    }

    public void f()
    {
        al.a(mViews.buttonContainer, true);
        al.a(mViews.actionButton, true);
        mViews.actionButton.setText(getResources().getString(0x7f0904ca));
    }

    public void g()
    {
        al.a(mViews.buttonContainer, true);
        al.a(mViews.actionButton, true);
        mViews.actionButton.setText(getResources().getString(0x7f0904c9));
    }

    public void h()
    {
        al.a(mViews.mErrorView, new View[] {
            mViews.tvRequestTeamMemberExplaination, mViews.tvRequestTeamMemberHeader, mViews.recyclerView
        });
        mViews.mErrorView.a(com.target.ui.view.common.b.a.ERROR_DEFAULT, false);
    }

    public void i()
    {
        al.a(mViews.mErrorView, new View[] {
            mViews.tvRequestTeamMemberExplaination, mViews.recyclerView, mViews.tvRequestTeamMemberHeader
        });
        mViews.mErrorView.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, false);
    }

    public void j()
    {
        dismiss();
    }

    public void k()
    {
        mViews.mErrorView.a(com.target.ui.view.common.b.a.ERROR_DEFAULT, false);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mRequestTeamMemberDialogListener = (a)getTargetFragment();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAdapter = new DepartmentAdjacencyAdapter(this);
        mAdapter.a(mDepartmentAdjacencies);
        bundle = (Store)getArguments().getParcelable("store");
        int i1 = getArguments().getInt("lastKnownX");
        int j1 = getArguments().getInt("lastKnownY");
        RequestTeamMemberAlarmManager requestteammemberalarmmanager = new RequestTeamMemberAlarmManager(getActivity());
        mRequestTeamMemberPresenter = new com.target.ui.fragment.request_team_member.b.a(new com.target.ui.helper.m.a(com.target.ui.service.l.a(requestteammemberalarmmanager), com.target.ui.service.e.a(), com.target.ui.service.k.a(), new d(), new f()), bundle, new com.target.ui.fragment.request_team_member.c.a(requestteammemberalarmmanager), i1, j1);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03007a, viewgroup, true);
        mViews = new Views(layoutinflater);
        mViews.recyclerView.a(new com.target.ui.util.k(getActivity(), 1));
        mViews.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViews.recyclerView.setHasFixedSize(true);
        mViews.recyclerView.setAdapter(mAdapter);
        mRequestTeamMemberPresenter.a(this);
        l();
        a(getActivity());
        return layoutinflater;
    }

    public void onDestroy()
    {
        mRequestTeamMemberPresenter.v_();
        super.onDestroy();
    }

    public void onDestroyView()
    {
        mRequestTeamMemberPresenter.z_();
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        mRequestTeamMemberDialogListener = null;
    }
}
