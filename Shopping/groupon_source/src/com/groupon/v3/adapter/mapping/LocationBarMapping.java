// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.v3.view.list_view.LocationBarHeader;
import com.groupon.view.LocationBar;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class LocationBarMapping extends Mapping
{
    private class LocationBarHolder extends GrouponViewHolder
    {

        protected LocationBar locationBar;
        final LocationBarMapping this$0;

        public LocationBarHolder(View view)
        {
            this$0 = LocationBarMapping.this;
            super(view);
            locationBar = (LocationBar)view.findViewById(0x7f100289);
        }
    }


    public static final String NST_CLICK_DIVISION_TYPE = "click_country_selector";
    private Channel channel;
    private IntentFactory intentFactory;
    private Logger logger;

    public LocationBarMapping(Context context, Channel channel1)
    {
        super(com/groupon/v3/view/list_view/LocationBarHeader);
        channel = channel1;
        RoboGuice.getInjector(context).injectMembers(this);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, final UniversalListAdapter wrapper)
    {
        viewholder = (LocationBarHolder)viewholder;
        wrapper = (LocationBarHeader)wrapper.getItem(i);
        ((LocationBarHolder) (viewholder)).locationBar.setText(((LocationBarHeader) (wrapper)).location);
        ((LocationBarHolder) (viewholder)).itemView.setTag(0x7f100001, wrapper);
        ((LocationBarHolder) (viewholder)).locationBar.setOnClickListener(new android.view.View.OnClickListener() {

            final LocationBarMapping this$0;
            final LocationBarHeader val$wrapper;

            public void onClick(View view)
            {
                logger.logClick("", "click_country_selector", channel.toString(), wrapper.location);
                view.getContext().startActivity(intentFactory.newCountryOrDivisionSelector());
            }

            
            {
                this$0 = LocationBarMapping.this;
                wrapper = locationbarheader;
                super();
            }
        });
    }

    public View createView(Context context)
    {
        return LayoutInflater.from(context).inflate(0x7f0300df, null);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }

    protected GrouponViewHolder getHolderWithCallback(Context context, UniversalListAdapter universallistadapter)
    {
        return new LocationBarHolder(createView(context)) {

            final LocationBarMapping this$0;

            public void onClick(View view)
            {
                IViewCallback iviewcallback = (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback);
                if (iviewcallback != null)
                {
                    iviewcallback.onViewClick(view);
                }
            }

            
            {
                this$0 = LocationBarMapping.this;
                super(view);
            }
        };
    }

    public boolean getSpanAllColumns()
    {
        return true;
    }



}
