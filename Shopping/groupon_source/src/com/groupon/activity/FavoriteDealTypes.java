// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.groupon.service.DealTypeService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function1;
import com.groupon.view.FavoriteDealTypeItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            GrouponListActivity, IntentFactory

public class FavoriteDealTypes extends GrouponListActivity
{
    private class IdArrayAdapter extends ArrayAdapter
    {

        private final List allIds;
        private final List names;
        final FavoriteDealTypes this$0;

        public int getCount()
        {
            return allIds.size();
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public String getItem(int i)
        {
            return (String)allIds.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view instanceof FavoriteDealTypeItem)
            {
                view = (FavoriteDealTypeItem)view;
            } else
            {
                view = new FavoriteDealTypeItem(getContext());
            }
            viewgroup = getItem(i);
            view.setClickable(false);
            view.setTypeId(viewgroup);
            view.setTypeName((CharSequence)names.get(i));
            view.setHostPageValue(2);
            view.setTextColor(Color.rgb(51, 51, 51));
            view.setTooltipPaddingX(6);
            if (dealTypeService.doesUserHaveDealTypeInFavoriteList(viewgroup))
            {
                viewgroup = com.groupon.view.FavoriteDealTypeItem.HeartState.On;
            } else
            {
                viewgroup = com.groupon.view.FavoriteDealTypeItem.HeartState.Off;
            }
            view.setState(viewgroup);
            return view;
        }

        public IdArrayAdapter(List list, List list1)
        {
            this$0 = FavoriteDealTypes.this;
            super(FavoriteDealTypes.this, 0x7f0300db, 0x7f100284, list);
            allIds = list;
            names = list1;
        }
    }


    private DealTypeService dealTypeService;
    private IntentFactory intentFactory;
    ListView listView;
    private Logger logger;
    Button seePersonalizedDeals;

    public FavoriteDealTypes()
    {
    }

    private void setup()
    {
        final ArrayList allIds = new ArrayList();
        final ArrayList names = new ArrayList();
        final IdArrayAdapter adapter = new IdArrayAdapter(allIds, names);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FavoriteDealTypes this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (view instanceof FavoriteDealTypeItem)
                {
                    ((FavoriteDealTypeItem)view).toggleStateWithApiCall(null);
                }
            }

            
            {
                this$0 = FavoriteDealTypes.this;
                super();
            }
        });
        listView.setAdapter(adapter);
        seePersonalizedDeals.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoriteDealTypes this$0;

            public void onClick(View view)
            {
                Ln.d(String.format("DEALTYPES: cat=%s, action=%s, label=%s, value=%d", new Object[] {
                    "deal_types", "see_personalized_deals_click", "page", Integer.valueOf(2)
                }), new Object[0]);
                logger.logGeneralEvent("deal_types", "see_personalized_deals_click", "page", 2, Logger.NULL_NST_FIELD);
                startActivity(intentFactory.newCarouselIntent());
            }

            
            {
                this$0 = FavoriteDealTypes.this;
                super();
            }
        });
        dealTypeService.getAllDealTypes(new Function1() {

            final FavoriteDealTypes this$0;
            final ArrayAdapter val$adapter;
            final List val$allIds;
            final List val$names;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((HashMap)obj);
            }

            public void execute(HashMap hashmap)
            {
                allIds.clear();
                names.clear();
                String s;
                for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); names.add(hashmap.get(s)))
                {
                    s = (String)iterator.next();
                    allIds.add(s);
                }

                adapter.notifyDataSetChanged();
            }

            
            {
                this$0 = FavoriteDealTypes.this;
                allIds = list;
                names = list1;
                adapter = arrayadapter;
                super();
            }
        });
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f0801b0));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(0x7f0801b0);
        setContentView(0x7f0300dc);
        setup();
    }

    protected void onPause()
    {
        super.onPause();
        for (int i = listView.getFirstVisiblePosition(); i < listView.getLastVisiblePosition(); i++)
        {
            View view = listView.getChildAt(i);
            if (view instanceof FavoriteDealTypeItem)
            {
                ((FavoriteDealTypeItem)view).dispose();
            }
        }

    }

    protected void onResume()
    {
        super.onResume();
        logger.logGeneralEvent("deal_types", "page_view", "page", 2, Logger.NULL_NST_FIELD);
    }



}
