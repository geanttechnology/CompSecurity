// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.accessibility.TalkDelegateFactory;
import com.comcast.cim.cmasl.android.util.view.common.FilterChangeListener;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            FilterEventListener, DibicProgramFilter

public class BrowseFilterCategoryDetailPanel extends Fragment
{

    public static final String ALPHA_FILTER_LABELS[] = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
        "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
        "U", "V", "W", "X", "Y", "Z"
    };
    protected static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel);
    public static final String TAG = com/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel.getCanonicalName();
    protected final AccessibilityUtil accessibilityUtil = CALContainer.getInstance().getAccessibilityUtil();
    ArrayAdapter adapter;
    protected ArrayList filterAdapters;
    private final FilterChangeListener filterChangeListener = new FilterChangeListener() {

        final BrowseFilterCategoryDetailPanel this$0;

        public void onFilterChange(DibicProgramFilter dibicprogramfilter)
        {
            if (adapter != null)
            {
                adapter.notifyDataSetChanged();
            }
        }

        public volatile void onFilterChange(Object obj)
        {
            onFilterChange((DibicProgramFilter)obj);
        }

            
            {
                this$0 = BrowseFilterCategoryDetailPanel.this;
                super();
            }
    };
    protected FilterEventListener filterEventListener;
    List genres;
    private LayoutInflater inflater;
    protected boolean isDualPanel;
    protected DibicProgramFilter.FilterCategory lastCategory;
    private ListView list;
    protected TalkDelegate talkDelegate;
    TalkDelegateFactory talkDelegateFactory;
    protected PlayNowUserManager userManager;

    public BrowseFilterCategoryDetailPanel()
    {
        userManager = PlayerContainer.getInstance().getUserManager();
        talkDelegateFactory = PlayerContainer.getInstance().getTalkDelegateFactory();
        filterAdapters = new ArrayList();
        lastCategory = DibicProgramFilter.FilterCategory.GENRE;
    }

    private Pair[] buildAlphaPairs()
    {
        ArrayList arraylist = new ArrayList();
        String as[] = ALPHA_FILTER_LABELS;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            arraylist.add(new Pair(s, s));
        }

        return (Pair[])CommonUtils.uncheckedCast(((Object) (arraylist.toArray(new Pair[arraylist.size()]))));
    }

    private Pair[] buildGenrePairs()
    {
        ArrayList arraylist = new ArrayList();
        OrderedTag orderedtag;
        for (Iterator iterator = genres.iterator(); iterator.hasNext(); arraylist.add(new Pair(orderedtag.getId(), orderedtag.getName())))
        {
            orderedtag = (OrderedTag)iterator.next();
        }

        Collections.sort(arraylist, new Comparator() {

            final BrowseFilterCategoryDetailPanel this$0;

            public int compare(Pair pair, Pair pair1)
            {
                return ((String)pair.second).compareTo((String)pair1.second);
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Pair)obj, (Pair)obj1);
            }

            
            {
                this$0 = BrowseFilterCategoryDetailPanel.this;
                super();
            }
        });
        return (Pair[])CommonUtils.uncheckedCast(((Object) (arraylist.toArray(new Pair[arraylist.size()]))));
    }

    private Pair[] buildNetworkPairs(List list1)
    {
        ArrayList arraylist = new ArrayList();
        Network network;
        for (list1 = list1.iterator(); list1.hasNext(); arraylist.add(new Pair(String.valueOf(network.getCompanyId()), network.getName())))
        {
            network = (Network)list1.next();
        }

        return (Pair[])CommonUtils.uncheckedCast(((Object) (arraylist.toArray(new Pair[arraylist.size()]))));
    }

    public static BrowseFilterCategoryDetailPanel newInstance(boolean flag, List list1)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isDualPanel", flag);
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(list1);
        bundle.putParcelableArrayList("genres", arraylist);
        list1 = new BrowseFilterCategoryDetailPanel();
        list1.setArguments(bundle);
        return list1;
    }

    private void turnOnTalkBackForAccessibility()
    {
        if (accessibilityUtil.isAccessibilityEnabled() && talkDelegate == null)
        {
            talkDelegate = talkDelegateFactory.getTalkDelegate(getActivity(), getActivity().getWindow().getDecorView().findViewById(0x1020002));
        }
    }

    protected void buildCategoryDetailPanel(final Context final_context, DibicProgramFilter dibicprogramfilter, Pair apair[], DibicProgramFilter.FilterCategory filtercategory)
    {
        adapter = new ArrayAdapter(apair, dibicprogramfilter, filtercategory) {

            final BrowseFilterCategoryDetailPanel this$0;
            final DibicProgramFilter.FilterCategory val$category;
            final DibicProgramFilter val$filter;

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                Pair pair = (Pair)getItem(i);
                View view1 = view;
                if (view == null)
                {
                    view1 = inflater.inflate(com.xfinity.playerlib.R.layout.filter_dialog_list_item, viewgroup, false);
                }
                view = (CheckedTextView)view1.findViewById(com.xfinity.playerlib.R.id.filter_title);
                view.setText((CharSequence)pair.second);
                view.setChecked(filter.getFiltersForCategory(category).containsKey(pair.first));
                return view1;
            }

            
            {
                this$0 = BrowseFilterCategoryDetailPanel.this;
                filter = dibicprogramfilter;
                category = filtercategory;
                super(final_context, final_i, apair);
            }
        };
        filterAdapters.add(adapter);
        if (list != null)
        {
            list.setItemsCanFocus(false);
            setFilterListOnItemClickListener(list, filtercategory);
            list.setAdapter(adapter);
        }
        lastCategory = filtercategory;
    }

    public void changeCategoryDetailPanel(Context context, DibicProgramFilter dibicprogramfilter, DibicProgramFilter.FilterCategory filtercategory, TagsRoot tagsroot)
    {
        if (genres == null)
        {
            genres = getArguments().getParcelableArrayList("genres");
        }
        static class _cls5
        {

            static final int $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory[];

            static 
            {
                $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory = new int[DibicProgramFilter.FilterCategory.values().length];
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory[DibicProgramFilter.FilterCategory.GENRE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory[DibicProgramFilter.FilterCategory.NETWORK.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory[DibicProgramFilter.FilterCategory.ALPHA.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls5..SwitchMap.com.xfinity.playerlib.view.browseprograms.DibicProgramFilter.FilterCategory[filtercategory.ordinal()];
        JVM INSTR tableswitch 1 3: default 56
    //                   1 57
    //                   2 71
    //                   3 113;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        buildCategoryDetailPanel(context, dibicprogramfilter, buildGenrePairs(), DibicProgramFilter.FilterCategory.GENRE);
        return;
_L3:
        filtercategory = tagsroot.getNetworks();
        if (!filtercategory.isEmpty() && filtercategory.size() > 1)
        {
            buildCategoryDetailPanel(context, dibicprogramfilter, buildNetworkPairs(filtercategory), DibicProgramFilter.FilterCategory.NETWORK);
            return;
        }
          goto _L1
_L4:
        buildCategoryDetailPanel(context, dibicprogramfilter, buildAlphaPairs(), DibicProgramFilter.FilterCategory.ALPHA);
        return;
    }

    public FilterChangeListener getFilterChangeListener()
    {
        return filterChangeListener;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        filterEventListener = (FilterEventListener)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null)
        {
            isDualPanel = bundle.getBoolean("isDualPanel", false);
            genres = bundle.getParcelableArrayList("genres");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        inflater = layoutinflater;
        layoutinflater = layoutinflater.inflate(com.xfinity.playerlib.R.layout.filter_dialog_category, viewgroup, false);
        list = (ListView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.list);
        if (adapter != null)
        {
            list.setItemsCanFocus(false);
            setFilterListOnItemClickListener(list, lastCategory);
            list.setAdapter(adapter);
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        if (talkDelegate != null)
        {
            talkDelegate.onDestroy();
        }
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        turnOnTalkBackForAccessibility();
    }

    protected void setFilterListOnItemClickListener(ListView listview, final DibicProgramFilter.FilterCategory category)
    {
        listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BrowseFilterCategoryDetailPanel this$0;
            final DibicProgramFilter.FilterCategory val$category;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                view = (CheckedTextView)view.findViewById(com.xfinity.playerlib.R.id.filter_title);
                adapterview = (Pair)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
                view.toggle();
                if (view.isChecked())
                {
                    filterEventListener.onFilterItemSelected((String)((Pair) (adapterview)).first, (String)((Pair) (adapterview)).second, category);
                    speak(com.xfinity.playerlib.R.string.content_description_changed_to_checked);
                    return;
                } else
                {
                    filterEventListener.onFilterItemDeselected((String)((Pair) (adapterview)).first, category);
                    speak(com.xfinity.playerlib.R.string.content_description_changed_to_unchecked);
                    return;
                }
            }

            
            {
                this$0 = BrowseFilterCategoryDetailPanel.this;
                category = filtercategory;
                super();
            }
        });
    }

    protected void speak(int i)
    {
        if (accessibilityUtil.isAccessibilityEnabled() && talkDelegate != null)
        {
            speak(getString(i));
        }
    }

    protected void speak(String s)
    {
        if (talkDelegate != null)
        {
            talkDelegate.speak(s);
        }
    }


}
