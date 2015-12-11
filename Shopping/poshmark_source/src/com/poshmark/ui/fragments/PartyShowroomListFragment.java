// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.ImageView;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersListView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.data_model.adapters.PartyShowroomListAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.data_model.models.inner_models.Host;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.RoundedImageView;
import com.poshmark.utils.ViewUtils;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMDialogFragment, PMFragment, ClosetFragment, PartyInviteFragment

public class PartyShowroomListFragment extends PMDialogFragment
{

    private PartyShowroomListAdapter adapter;
    private PartyEvent event;
    private View headerView;
    private StickyListHeadersListView listView;

    public PartyShowroomListFragment()
    {
    }

    private void setupList()
    {
        updateList();
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PartyShowroomListFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (((CustomMatrixCursor)((CursorAdapter)listView.getWrappedAdapter()).getCursor()).moveToPosition(i - 1))
                {
                    adapterview = new Bundle();
                    adapterview.putInt("SHOWROOM_INDEX", i - 1);
                    view = (PMFragment)getTargetFragment();
                    if (view != null)
                    {
                        view.onFragmentResult(adapterview, getTargetRequestCode());
                    }
                    dismiss();
                }
            }

            
            {
                this$0 = PartyShowroomListFragment.this;
                super();
            }
        });
    }

    private void updateHeaderView()
    {
        Object obj;
        Object obj1;
        ImageView imageview;
        obj = (ImageView)headerView.findViewById(0x7f0c024b);
        ImageLoader.getInstance().displayImage(event.getCovershot(), ((ImageView) (obj)));
        obj1 = (PMTextView)headerView.findViewById(0x7f0c0243);
        obj = event.getHosts();
        int i;
        int k;
        int l;
        int i1;
        if (((List) (obj)).size() <= 1)
        {
            ((PMTextView) (obj1)).setText(0x7f060140);
        } else
        {
            ((PMTextView) (obj1)).setText(0x7f060142);
        }
        obj1 = (GridLayout)headerView.findViewById(0x7f0c0244);
        l = 0;
        i = 0;
        i1 = ((List) (obj)).size();
        k = 0;
        while (k < i1) 
        {
            Object obj2 = (Host)((List) (obj)).get(k);
            final String hostUserId = ((Host) (obj2)).id;
            RoundedImageView roundedimageview = new RoundedImageView(getActivity(), null);
            roundedimageview.setUser(((Host) (obj2)).getUsername());
            roundedimageview.setOnClickListener(new android.view.View.OnClickListener() {

                final PartyShowroomListFragment this$0;
                final String val$hostUserId;

                public void onClick(View view)
                {
                    view = new Bundle();
                    view.putString("NAME", hostUserId);
                    ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/ClosetFragment, null);
                    dismiss();
                }

            
            {
                this$0 = PartyShowroomListFragment.this;
                hostUserId = s;
                super();
            }
            });
            int j1 = (int)ViewUtils.dipToPixels(getActivity().getApplicationContext(), 10F);
            int k1 = j1 * 3;
            hostUserId = new android.widget.GridLayout.LayoutParams(GridLayout.spec(l, 1), GridLayout.spec(i, 1));
            hostUserId.width = k1;
            hostUserId.height = k1;
            hostUserId.setMargins(0, j1 / 2, j1, 0);
            ((GridLayout) (obj1)).addView(roundedimageview, hostUserId);
            obj2 = ((Host) (obj2)).getAvataar();
            if (obj2 != null)
            {
                ImageLoader.getInstance().loadImage(((String) (obj2)), roundedimageview.listener);
            } else
            {
                roundedimageview.setBitmap(0x7f0200d4);
            }
            if (i + 1 == 7)
            {
                l++;
                i = 0;
            } else
            {
                i++;
            }
            k++;
        }
        obj = (ImageView)headerView.findViewById(0x7f0c0245);
        imageview = (ImageView)headerView.findViewById(0x7f0c0246);
        obj1 = (PMTextView)headerView.findViewById(0x7f0c0247);
        if (!event.isHappeningNow()) goto _L2; else goto _L1
_L1:
        ((ImageView) (obj)).setVisibility(0);
        imageview.setVisibility(8);
        ((PMTextView) (obj1)).setText(event.getFormattedPendingTime());
_L4:
        ((PMTextView)headerView.findViewById(0x7f0c024a)).setOnClickListener(new android.view.View.OnClickListener() {

            final PartyShowroomListFragment this$0;

            public void onClick(View view)
            {
                view = new Bundle();
                view.putString("ID", event.getId());
                ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/PartyInviteFragment, event);
                dismiss();
            }

            
            {
                this$0 = PartyShowroomListFragment.this;
                super();
            }
        });
        return;
_L2:
        int j;
        if (!event.isPastEvent())
        {
            continue; /* Loop/switch isn't completed */
        }
        ((ImageView) (obj)).setVisibility(8);
        imageview.setVisibility(0);
        j = event.getListingCount();
        if (j != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = getString(0x7f0601d2);
_L5:
        ((PMTextView) (obj1)).setText(((CharSequence) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
        if (j == 1)
        {
            obj = (new StringBuilder()).append(Integer.toString(j)).append(" ").append(getString(0x7f060167)).toString();
        } else
        {
            obj = (new StringBuilder()).append(Integer.toString(j)).append(" ").append(getString(0x7f06018f)).toString();
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    private void updateList()
    {
        if (getUserVisibleHint() && GlobalPartiesController.getGlobalPartiesController().isModelPopulated())
        {
            CustomMatrixCursor custommatrixcursor = new CustomMatrixCursor(new String[] {
                PMData.ID_COL, PMData.DATA_COL
            });
            event.fillCursor(custommatrixcursor);
            adapter.changeCursor(custommatrixcursor);
            adapter.notifyDataSetChanged();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupList();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((Bundle) (getFragmentDataOfType(com/poshmark/data_model/models/PartyEvent)));
        if (bundle != null)
        {
            event = (PartyEvent)bundle;
        }
        adapter = new PartyShowroomListAdapter(getActivity(), this, null, 0x80000000);
        adapter.setEvent(event);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        bundle = layoutinflater.inflate(0x7f03009a, viewgroup, false);
        listView = (StickyListHeadersListView)bundle.findViewById(0x7f0c025a);
        headerView = layoutinflater.inflate(0x7f03009b, viewgroup, false);
        updateHeaderView();
        listView.addHeaderView(headerView);
        listView.setAdapter(adapter);
        return bundle;
    }

    public void onStop()
    {
        super.onStop();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "party_showroom_list_screen";
    }


}
