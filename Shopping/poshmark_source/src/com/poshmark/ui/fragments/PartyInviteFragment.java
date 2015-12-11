// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.RoundedImageView;
import com.poshmark.utils.ViewUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PartyGuidelinesFragment, ShareFragment

public class PartyInviteFragment extends PMFragment
{

    private PartyEvent event;

    public PartyInviteFragment()
    {
    }

    private void setupView(View view)
    {
        Object obj = ImageLoader.getInstance();
        Object obj1 = (ImageView)view.findViewById(0x7f0c024b);
        ((ImageLoader) (obj)).displayImage(event.getCovershot(), ((ImageView) (obj1)));
        obj1 = (RoundedImageView)view.findViewById(0x7f0c024c);
        ((RoundedImageView) (obj1)).setHasBorder(true);
        ((ImageLoader) (obj)).displayImage(event.getCovershot(), ((ImageView) (obj1)));
        ((PMTextView)view.findViewById(0x7f0c024d)).setText(event.getTitle());
        obj = (PMTextView)view.findViewById(0x7f0c024e);
        if (event.isHappeningNow())
        {
            ((PMTextView) (obj)).setText(getString(0x7f06013d));
        } else
        if (event.isPastEvent())
        {
            ((PMTextView) (obj)).setText(getString(0x7f060090));
        } else
        {
            ((PMTextView) (obj)).setText(event.getStartDateTimeString(getActivity()));
        }
        ((PMTextView)view.findViewById(0x7f0c0135)).setText(event.getDescription());
        obj = event.getHosts();
        obj1 = (GridLayout)view.findViewById(0x7f0c0252);
        ViewUtils.populatePartyHostsInLayout(getActivity(), ((java.util.List) (obj)), ((GridLayout) (obj1)));
        ((PMTextView)view.findViewById(0x7f0c0250)).setOnClickListener(new android.view.View.OnClickListener() {

            final PartyInviteFragment this$0;

            public void onClick(View view1)
            {
                showPartyGuidelines();
            }

            
            {
                this$0 = PartyInviteFragment.this;
                super();
            }
        });
        ((PMButton)view.findViewById(0x7f0c0253)).setOnClickListener(new android.view.View.OnClickListener() {

            final PartyInviteFragment this$0;

            public void onClick(View view1)
            {
                showPartyInviteOptions();
            }

            
            {
                this$0 = PartyInviteFragment.this;
                super();
            }
        });
    }

    private void showPartyGuidelines()
    {
        ((PMContainerActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/PartyGuidelinesFragment, event);
    }

    private void showPartyInviteOptions()
    {
        Bundle bundle = new Bundle();
        bundle.putString("MODE", com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_PARTY.name());
        ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ShareFragment, event);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (event.isPastEvent())
        {
            setTitle(0x7f0601ed);
            return;
        } else
        {
            setTitle(0x7f0601f1);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((Bundle) (getFragmentDataOfType(com/poshmark/data_model/models/PartyEvent)));
        if (bundle != null)
        {
            event = (PartyEvent)bundle;
        } else
        {
            bundle = getArguments().getString("ID");
            if (GlobalPartiesController.getGlobalPartiesController().isModelPopulated())
            {
                event = GlobalPartiesController.getGlobalPartiesController().getParty(bundle);
                return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030097, viewgroup, false);
        setupView(layoutinflater);
        return layoutinflater;
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "party_invite_screen";
    }


}
