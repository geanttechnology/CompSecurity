// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            PlayNowBrowseProgramsFragment, SortPolicy

public abstract class MultiTypeProgramsFragment extends PlayNowBrowseProgramsFragment
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment);
    protected AlternateInterfaceListener alternateInterfaceListener;
    protected View filterSubNav;
    protected TaskExecutor provider;
    protected SortPolicy sortPolicy;
    protected TaskExecutionListener taskExecutionListener;

    public MultiTypeProgramsFragment()
    {
    }

    protected SortPolicy getSortPolicy()
    {
        return sortPolicy;
    }

    protected TaskExecutionListener getTaskExecutionListener()
    {
        return taskExecutionListener;
    }

    protected TaskExecutor getTaskExecutor()
    {
        return provider;
    }

    protected void hideSortButtons()
    {
        otherSortButton.setVisibility(8);
        alphaSortButton.setVisibility(8);
        popularityButton.setVisibility(8);
        if (filterButton == null)
        {
            filterSubNav.setVisibility(8);
            if (sortBar != null)
            {
                sortBar.setVisibility(8);
            }
        }
        onHideSortBar();
    }

    protected boolean isSortable()
    {
        return sortPolicy != null && sortPolicy.getCurrentSortType() != SortPolicy.SortType.NONE;
    }

    protected void itemLongClicked(DibicProgram dibicprogram)
    {
        if (dibicprogram == null)
        {
            return;
        }
        if (dibicprogram.isMovie())
        {
            bookmarkUtils.promptBookmarkDialog(this, new VideoFavorite(dibicprogram.getMerlinId(), dibicprogram.getTitle(), dibicprogram.isAdult()));
            return;
        } else
        {
            bookmarkUtils.promptBookmarkDialog(this, new VideoFavorite(dibicprogram.getParentMerlinIdIfApplicable(), dibicprogram.getTitle(), dibicprogram.isAdult()));
            return;
        }
    }

    protected volatile void itemLongClicked(Object obj)
    {
        itemLongClicked((DibicProgram)obj);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)super.onCreateView(layoutinflater, viewgroup, bundle);
        setupSortButtons(layoutinflater, sortPolicy.getSortTypes());
        if (sortBar == null)
        {
            filterSubNav = layoutinflater.findViewById(com.xfinity.playerlib.R.id.FilterSubNavBar);
        } else
        {
            filterSubNav = sortBar.findViewById(com.xfinity.playerlib.R.id.list_header);
        }
        setupOtherButton(otherSortButton, (Button)otherSortButton.findViewById(com.xfinity.playerlib.R.id.btn_otherSort), getString(com.xfinity.playerlib.R.string.chronological_series_sort_button_text), getString(com.xfinity.playerlib.R.string.chronological_series_sort_button_speech));
        alternateInterfaceListener.setupPassiveGestureDetector(layoutinflater, com.xfinity.playerlib.R.id.touchy_parent);
        return layoutinflater;
    }

    protected void showSortButtons()
    {
        if (sortPolicy.getSortTypes() == null)
        {
            throw new IllegalStateException("Trying to show nonexistent sort buttons");
        }
        otherSortButton.setVisibility(0);
        alphaSortButton.setVisibility(0);
        if (sortPolicy.getSortTypes().size() == 3)
        {
            popularityButton.setVisibility(0);
        }
        if (filterButton == null)
        {
            filterSubNav.setVisibility(0);
            if (sortBar != null)
            {
                sortBar.setVisibility(0);
            }
        }
        onShowSortBar();
    }

    protected void updateSortButtonStates(SortPolicy.SortType sorttype)
    {
label0:
        {
label1:
            {
                static class _cls1
                {

                    static final int $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[];

                    static 
                    {
                        $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType = new int[SortPolicy.SortType.values().length];
                        try
                        {
                            $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[SortPolicy.SortType.ALPHA.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[SortPolicy.SortType.YEAR.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[SortPolicy.SortType.NEW.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[SortPolicy.SortType.POPULAR.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                if (sortPolicy.getSortTypes() == null)
                {
                    if (sorttype != SortPolicy.SortType.NONE)
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Unexpected sort type: ").append(sorttype).toString());
                    }
                } else
                {
                    switch (_cls1..SwitchMap.com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType[sorttype.ordinal()])
                    {
                    default:
                        throw new IllegalStateException((new StringBuilder()).append("Unexpected sort type: ").append(sorttype).toString());

                    case 2: // '\002'
                    case 3: // '\003'
                        break label1;

                    case 4: // '\004'
                        break label0;

                    case 1: // '\001'
                        select(alphaSortButton);
                        unselect(otherSortButton);
                        unselect(popularityButton);
                        break;
                    }
                }
                return;
            }
            select(otherSortButton);
            unselect(alphaSortButton);
            unselect(popularityButton);
            return;
        }
        select(popularityButton);
        unselect(alphaSortButton);
        unselect(otherSortButton);
    }

}
