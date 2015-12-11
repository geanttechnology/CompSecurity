// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.EbayCountry;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PreferredCountryFragment extends BaseFragment
{
    final class PreferredSiteListAdapter extends ArrayAdapter
        implements SectionIndexer
    {

        Map alphaIndexer;
        List displayNames;
        List items;
        String sections[];
        final PreferredCountryFragment this$0;

        public int getPositionForSection(int i)
        {
            String s = sections[i];
            return ((Integer)alphaIndexer.get(s)).intValue();
        }

        public int getSectionForPosition(int i)
        {
            return 0;
        }

        public Object[] getSections()
        {
            return sections;
        }

        public int getSelectedPosition()
        {
            int i;
            for (i = 0; i < items.size() && !((com.ebay.common.view.util.EbayCountryManager.CountryResources)items.get(i)).belongsToCountry(currentCountry); i++) { }
            int j = i;
            if (i == items.size())
            {
                j = 0;
            }
            return j;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            view = super.getView(i, view, viewgroup);
            viewgroup = (com.ebay.common.view.util.EbayCountryManager.CountryResources)getItem(i);
            ((ImageView)view.findViewById(0x1020006)).setImageResource(viewgroup.getFlagResourceId());
            ImageView imageview = (ImageView)view.findViewById(0x7f100121);
            if (viewgroup.belongsToCountry(currentCountry))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            imageview.setVisibility(i);
            return view;
        }

        public PreferredSiteListAdapter(Context context, int i, int j, List list)
        {
            this$0 = PreferredCountryFragment.this;
            super(context, i, j, list);
            items = list;
            alphaIndexer = new HashMap();
            preferredcountryfragment = Collator.getInstance(Locale.getDefault());
            setStrength(0);
            Collections.sort(items, new com.ebay.common.view.util.EbayCountryManager.CountryResources.Comparator(PreferredCountryFragment.this));
            i = list.size();
            context = new ArrayList();
            for (i--; i >= 0; i--)
            {
                String s = ((com.ebay.common.view.util.EbayCountryManager.CountryResources)list.get(i)).getCountryName().substring(0, 1);
                alphaIndexer.put(s, Integer.valueOf(i));
                context.add(s);
            }

            Collections.sort(context, PreferredCountryFragment.this);
            sections = new String[context.size()];
            context.toArray(sections);
        }
    }


    private PreferredSiteListAdapter adapter;
    protected ListView countriesView;
    private EbayCountry currentCountry;

    public PreferredCountryFragment()
    {
    }

    private android.widget.AdapterView.OnItemClickListener getItemClickListener()
    {
        android.widget.AdapterView.OnItemClickListener onitemclicklistener = null;
        if (this instanceof android.widget.AdapterView.OnItemClickListener)
        {
            onitemclicklistener = (android.widget.AdapterView.OnItemClickListener)this;
        } else
        {
            android.app.Activity activity = getActivity();
            if (activity instanceof android.widget.AdapterView.OnItemClickListener)
            {
                return (android.widget.AdapterView.OnItemClickListener)activity;
            }
        }
        return onitemclicklistener;
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup filterView, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030082, null);
        filterView = getArguments();
        if (filterView != null && filterView.containsKey("extraCountry"))
        {
            currentCountry = (EbayCountry)filterView.getParcelable("extraCountry");
        } else
        {
            currentCountry = MyApp.getPrefs().getCurrentCountry();
        }
        filterView = (EditText)layoutinflater.findViewById(0x7f10015e);
        filterView.addTextChangedListener(new TextWatcher() {

            final PreferredCountryFragment this$0;

            public void afterTextChanged(Editable editable)
            {
                adapter.getFilter().filter(editable.toString());
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = PreferredCountryFragment.this;
                super();
            }
        });
        filterView.postDelayed(new Runnable() {

            final PreferredCountryFragment this$0;
            final EditText val$filterView;

            public void run()
            {
                Util.forceEditTextFocus(filterView);
            }

            
            {
                this$0 = PreferredCountryFragment.this;
                filterView = edittext;
                super();
            }
        }, 250L);
        countriesView = (ListView)layoutinflater.findViewById(0x7f10015f);
        adapter = new PreferredSiteListAdapter(getActivity(), 0x7f030064, 0x1020014, com.ebay.common.view.util.EbayCountryManager.CountryResources.getAvailableInstances(getResources()));
        countriesView.setAdapter(adapter);
        filterView = getItemClickListener();
        if (filterView != null)
        {
            countriesView.setOnItemClickListener(filterView);
        }
        countriesView.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final PreferredCountryFragment this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
                if (1 == i)
                {
                    abslistview = getView().findViewById(0x7f10015e);
                    Util.hideSoftInput(getActivity(), abslistview);
                }
            }

            
            {
                this$0 = PreferredCountryFragment.this;
                super();
            }
        });
        countriesView.setSelection(adapter.getSelectedPosition());
        return layoutinflater;
    }


}
