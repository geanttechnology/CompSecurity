// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.content.Context;
import com.comcast.cim.cmasl.android.util.view.common.FilterChangeListener;
import com.comcast.cim.cmasl.utils.collections.CollectionUtils;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DibicProgramFilter
{
    public static final class FilterCategory extends Enum
    {

        private static final FilterCategory $VALUES[];
        public static final FilterCategory ALPHA;
        public static final FilterCategory GENRE;
        public static final FilterCategory NETWORK;
        public static final FilterCategory PROGRAM_TYPE;
        private final int contentDescriptionResStringId;
        private final int labelResStringId;
        private int navListIndex;

        public static FilterCategory int2FilterCategory(int i)
        {
            FilterCategory afiltercategory[] = values();
            int k = afiltercategory.length;
            for (int j = 0; j < k; j++)
            {
                FilterCategory filtercategory = afiltercategory[j];
                if (filtercategory.ordinal() == i)
                {
                    return filtercategory;
                }
            }

            return GENRE;
        }

        public static FilterCategory valueOf(String s)
        {
            return (FilterCategory)Enum.valueOf(com/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory, s);
        }

        public static FilterCategory[] values()
        {
            return (FilterCategory[])$VALUES.clone();
        }

        public CharSequence getContentDescription(Context context)
        {
            String s = context.getString(contentDescriptionResStringId);
            return context.getString(com.xfinity.playerlib.R.string.content_description_filter, new Object[] {
                s
            });
        }

        public CharSequence getLabel(Context context)
        {
            return context.getString(labelResStringId);
        }

        public int getNavListIndex()
        {
            return navListIndex;
        }

        static 
        {
            NETWORK = new FilterCategory("NETWORK", 0, com.xfinity.playerlib.R.string.filter_networks, 1, com.xfinity.playerlib.R.string.content_description_filter_networks);
            GENRE = new FilterCategory("GENRE", 1, com.xfinity.playerlib.R.string.filter_genres, 0, com.xfinity.playerlib.R.string.content_description_filter_genres);
            PROGRAM_TYPE = new FilterCategory("PROGRAM_TYPE", 2, com.xfinity.playerlib.R.string.filter_type, 3, com.xfinity.playerlib.R.string.content_description_filter_type);
            ALPHA = new FilterCategory("ALPHA", 3, com.xfinity.playerlib.R.string.filter_titles_atoz, 2, com.xfinity.playerlib.R.string.content_description_filter_titles_atoz);
            $VALUES = (new FilterCategory[] {
                NETWORK, GENRE, PROGRAM_TYPE, ALPHA
            });
        }

        private FilterCategory(String s, int i, int j, int k, int l)
        {
            super(s, i);
            labelResStringId = j;
            navListIndex = k;
            contentDescriptionResStringId = l;
        }
    }


    private HashMap currentAlphaFilters;
    private HashMap currentGenreFilters;
    private HashMap currentNetworkFilters;
    private HashMap currentProgramTypeFilters;
    private boolean downloadableOn;
    private List filterChangeListeners;
    private boolean hideLockedOn;

    public DibicProgramFilter()
    {
        filterChangeListeners = new ArrayList();
        currentGenreFilters = new HashMap();
        currentAlphaFilters = new HashMap();
        currentNetworkFilters = new HashMap();
        currentProgramTypeFilters = new HashMap();
    }

    public DibicProgramFilter(DibicProgramFilter dibicprogramfilter)
    {
        filterChangeListeners = new ArrayList();
        currentGenreFilters = new HashMap();
        currentAlphaFilters = new HashMap();
        currentNetworkFilters = new HashMap();
        currentProgramTypeFilters = new HashMap();
        currentGenreFilters = new HashMap(dibicprogramfilter.currentGenreFilters);
        currentAlphaFilters = new HashMap(dibicprogramfilter.getCurrentAlphaFilters());
        currentNetworkFilters = new HashMap(dibicprogramfilter.getCurrentNetworkFilters());
        currentProgramTypeFilters = new HashMap(dibicprogramfilter.getCurrentProgramTypeFilters());
        hideLockedOn = dibicprogramfilter.hideLockedOn;
        downloadableOn = dibicprogramfilter.downloadableOn;
        filterChangeListeners = dibicprogramfilter.filterChangeListeners;
    }

    private boolean matches(DibicProgram dibicprogram, VideoEntitlement videoentitlement)
    {
label0:
        {
            boolean flag6 = false;
            Object obj;
            Object obj1;
            boolean flag;
            boolean flag1;
            if (CollectionUtils.nullOrEmpty(getCurrentGenreFilters().keySet()) || CollectionUtils.containsAny(getCurrentGenreFilters().keySet(), dibicprogram.getGenreIds()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = currentAlphaFilters.values();
            if (CollectionUtils.nullOrEmpty(((Collection) (obj))) || titleStartsWithAny(dibicprogram.getSortTitle(), ((Collection) (obj))))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj1 = getCurrentNetworkFilters().keySet();
            obj = new ArrayList();
            for (obj1 = ((Collection) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((ArrayList) (obj)).add(Long.valueOf((String)((Iterator) (obj1)).next()))) { }
            boolean flag2;
            boolean flag3;
            boolean flag4;
            boolean flag5;
            if (CollectionUtils.nullOrEmpty(((Collection) (obj))) || CollectionUtils.containsAny(((Collection) (obj)), dibicprogram.getNetworkCompanyIds()))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (!hideLockedOn || videoentitlement.isEntitled(dibicprogram))
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (!downloadableOn || dibicprogram.isDownloadable())
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            if (!CollectionUtils.nullOrEmpty(getCurrentProgramTypeFilters().keySet()) && (!getCurrentProgramTypeFilters().keySet().contains("movies") || !dibicprogram.isMovie()))
            {
                flag5 = flag6;
                if (getCurrentProgramTypeFilters().keySet().contains("movies"))
                {
                    break label0;
                }
                flag5 = flag6;
                if (dibicprogram.isMovie())
                {
                    break label0;
                }
            }
            flag5 = true;
        }
        return flag & flag1 & flag2 & flag3 & flag4 & flag5;
    }

    private boolean titleStartsWithAny(String s, Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext();)
        {
            if (s.startsWith((String)collection.next()))
            {
                return true;
            }
        }

        return false;
    }

    protected void addEntry(String s, String s1, Map map)
    {
        if (!map.containsKey(s))
        {
            map.put(s, s1);
            notifyOnChangeListeners();
        }
    }

    public void addToSelectedList(String s, String s1, FilterCategory filtercategory)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory[];

            static 
            {
                $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory = new int[FilterCategory.values().length];
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory[FilterCategory.ALPHA.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory[FilterCategory.NETWORK.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory[FilterCategory.GENRE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory[FilterCategory.PROGRAM_TYPE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.xfinity.playerlib.view.browseprograms.DibicProgramFilter.FilterCategory[filtercategory.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            addEntry(s, s1, currentAlphaFilters);
            return;

        case 2: // '\002'
            addEntry(s, s1, currentNetworkFilters);
            return;

        case 3: // '\003'
            addEntry(s, s1, currentGenreFilters);
            return;

        case 4: // '\004'
            addEntry(s, s1, currentProgramTypeFilters);
            break;
        }
    }

    public void clearAllFilters()
    {
        currentAlphaFilters.clear();
        currentNetworkFilters.clear();
        currentGenreFilters.clear();
        currentProgramTypeFilters.clear();
        hideLockedOn = false;
        downloadableOn = false;
        notifyOnChangeListeners();
    }

    public void clearFiltersForCategory(FilterCategory filtercategory)
    {
        getFiltersForCategory(filtercategory).clear();
        notifyOnChangeListeners();
    }

    public boolean empty()
    {
        return currentNetworkFilters.size() <= 0 && currentGenreFilters.size() <= 0 && currentAlphaFilters.size() <= 0 && currentProgramTypeFilters.size() <= 0 && !hideLockedOn && !downloadableOn;
    }

    public HashMap getCurrentAlphaFilters()
    {
        return currentAlphaFilters;
    }

    public HashMap getCurrentGenreFilters()
    {
        return currentGenreFilters;
    }

    public HashMap getCurrentNetworkFilters()
    {
        return currentNetworkFilters;
    }

    public HashMap getCurrentProgramTypeFilters()
    {
        return currentProgramTypeFilters;
    }

    public List getFilteredPrograms(List list, VideoEntitlement videoentitlement)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            DibicProgram dibicprogram = (DibicProgram)list.next();
            if (matches(dibicprogram, videoentitlement))
            {
                arraylist.add(dibicprogram);
            }
        } while (true);
        return arraylist;
    }

    public Map getFiltersForCategory(FilterCategory filtercategory)
    {
        switch (_cls1..SwitchMap.com.xfinity.playerlib.view.browseprograms.DibicProgramFilter.FilterCategory[filtercategory.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Was not expecting category: ").append(filtercategory).toString());

        case 3: // '\003'
            return currentGenreFilters;

        case 2: // '\002'
            return currentNetworkFilters;

        case 1: // '\001'
            return currentAlphaFilters;

        case 4: // '\004'
            return currentProgramTypeFilters;
        }
    }

    public boolean isDownloadableOn()
    {
        return downloadableOn;
    }

    public boolean isHideLockOn()
    {
        return hideLockedOn;
    }

    protected void notifyOnChangeListeners()
    {
        for (Iterator iterator = filterChangeListeners.iterator(); iterator.hasNext(); ((FilterChangeListener)iterator.next()).onFilterChange(this)) { }
    }

    public boolean registerOnChangeListener(FilterChangeListener filterchangelistener)
    {
        return filterChangeListeners.add(filterchangelistener);
    }

    protected void removeEntry(String s, Map map)
    {
        if (map.containsKey(s))
        {
            map.remove(s);
            notifyOnChangeListeners();
        }
    }

    public void removeFromSelectedList(String s, FilterCategory filtercategory)
    {
        switch (_cls1..SwitchMap.com.xfinity.playerlib.view.browseprograms.DibicProgramFilter.FilterCategory[filtercategory.ordinal()])
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unexpected SearchCategory: ").append(filtercategory).toString());

        case 1: // '\001'
            removeEntry(s, currentAlphaFilters);
            return;

        case 2: // '\002'
            removeEntry(s, currentNetworkFilters);
            return;

        case 3: // '\003'
            removeEntry(s, currentGenreFilters);
            return;

        case 4: // '\004'
            removeEntry(s, currentProgramTypeFilters);
            break;
        }
    }

    public void setDownloadableOn(boolean flag)
    {
        if (downloadableOn != flag)
        {
            downloadableOn = flag;
            notifyOnChangeListeners();
        }
    }

    public void setHideLockOn(boolean flag)
    {
        if (hideLockedOn != flag)
        {
            hideLockedOn = flag;
            notifyOnChangeListeners();
        }
    }

    public boolean unregisterOnChangeListener(FilterChangeListener filterchangelistener)
    {
        return filterChangeListeners.remove(filterchangelistener);
    }

    public void updateWith(DibicProgramFilter dibicprogramfilter)
    {
        currentGenreFilters = dibicprogramfilter.currentGenreFilters;
        currentAlphaFilters = dibicprogramfilter.currentAlphaFilters;
        filterChangeListeners = dibicprogramfilter.filterChangeListeners;
        currentNetworkFilters = dibicprogramfilter.currentNetworkFilters;
        currentProgramTypeFilters = dibicprogramfilter.currentProgramTypeFilters;
        hideLockedOn = dibicprogramfilter.hideLockedOn;
        downloadableOn = dibicprogramfilter.downloadableOn;
        notifyOnChangeListeners();
    }
}
