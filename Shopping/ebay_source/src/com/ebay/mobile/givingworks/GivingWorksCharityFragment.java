// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.givingworks;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.activities.BaseDialogFragment;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;

public class GivingWorksCharityFragment extends BaseDialogFragment
{

    public static final String CHARITY_NONPROFIT = "charity_nonprofit";
    private com.ebay.common.model.givingworks.NonprofitData.Nonprofit charity;
    private ImageView image;
    private ImageCache imageCache;
    private TextView location;
    private TextView locationLabel;
    private TextView mission;
    private TextView title;

    public GivingWorksCharityFragment()
    {
    }

    private void updateUI()
    {
        imageCache.setImage(image, charity.getLogoUrl());
        title.setText(charity.name);
        mission.setText(charity.mission);
        String s = charity.getLocationString();
        if (!TextUtils.isEmpty(s))
        {
            location.setText(s);
            return;
        } else
        {
            location.setVisibility(8);
            locationLabel.setVisibility(8);
            return;
        }
    }

    public String getTrackingEventName()
    {
        return "GivingWorksCharityDetail";
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0x7f0a0282);
        imageCache = new ImageCache(getActivity());
        bundle = getArguments();
        if (bundle == null)
        {
            Log.e(getClass().getSimpleName(), "Activity requires a nonprofit extra. None found.");
            dismiss();
        } else
        {
            charity = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)bundle.getParcelable("charity_nonprofit");
            if (charity == null)
            {
                Log.e(getClass().getSimpleName(), "Nonprofit given in intent was null, cannot continue.");
                dismiss();
                return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300b4, viewgroup, false);
        image = (ImageView)layoutinflater.findViewById(0x7f1001cb);
        title = (TextView)layoutinflater.findViewById(0x7f1001cc);
        locationLabel = (TextView)layoutinflater.findViewById(0x7f1001cd);
        location = (TextView)layoutinflater.findViewById(0x7f1001ce);
        mission = (TextView)layoutinflater.findViewById(0x7f1001cf);
        ((TextView)layoutinflater.findViewById(0x7f1003a5)).setText(getString(0x7f07022e));
        layoutinflater.findViewById(0x7f1003ab).setVisibility(8);
        viewgroup = layoutinflater.findViewById(0x7f1003aa);
        if (!getResources().getBoolean(0x7f0b0006))
        {
            viewgroup.setVisibility(0);
            viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

                final GivingWorksCharityFragment this$0;

                public void onClick(View view)
                {
                    dismiss();
                }

            
            {
                this$0 = GivingWorksCharityFragment.this;
                super();
            }
            });
        }
        updateUI();
        layoutinflater.refreshDrawableState();
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(getActivity());
    }
}
