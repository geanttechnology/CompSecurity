// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.adapter.LocationIndexerAdapter;
import com.groupon.models.Place;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

class val.suggestion
    implements android.view.nt._cls21._cls1
{

    final dReason.locationSet this$1;
    final Place val$suggestion;

    public void onClick(View view)
    {
        NearbyDealsFragment.access$2000(_fld0).saveRecentLocation(val$suggestion);
        NearbyDealsFragment.access$1400(_fld0).dismiss();
        view.setBackgroundColor(getResources().getColor(0x7f0e00be));
        NearbyDealsFragment.access$1200(_fld0).requestFocus();
        NearbyDealsFragment.access$1700(_fld0).logClick("", "suggestion_selected", Channel.NEARBY.toString(), val$suggestion.value);
        setLocationAndReload(val$suggestion, dReason.locationSet);
    }

    it>()
    {
        this$1 = final_it>;
        val$suggestion = Place.this;
        super();
    }

    // Unreferenced inner class com/groupon/fragment/NearbyDealsFragment$21

/* anonymous class */
    class NearbyDealsFragment._cls21 extends LocationIndexerAdapter
    {

        final NearbyDealsFragment this$0;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            Place place = (Place)originalObjects.get(i);
            if (view == null)
            {
                view = NearbyDealsFragment.access$2600(NearbyDealsFragment.this).inflate(0x7f030155, viewgroup, false);
            }
            view = (TextView)view.findViewById(0x7f100204);
            view.setText(NearbyDealsFragment.access$2000(NearbyDealsFragment.this).getLocationDisplayLabel(place));
            view.setOnClickListener(place. new NearbyDealsFragment._cls21._cls1());
            return view;
        }

            
            {
                this$0 = NearbyDealsFragment.this;
                super(context, i, list);
            }
    }

}
