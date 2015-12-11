// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.tracking.PlayNowTab;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            PlayNowBrowseProgramsFragment, DibicProgramFilter, SortPolicy

public class SeriesFragment extends PlayNowBrowseProgramsFragment
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/SeriesFragment);
    private SortPolicy sortPolicy;
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;

    public SeriesFragment()
    {
        taskExecutor = PlayerContainer.getInstance().getSeriesAndEntitlementTaskExecutor();
        sortPolicy = PlayerContainer.getInstance().getSeriesSortPolicy();
    }

    protected CharSequence getContentDescriptionForAccessibility()
    {
        return getString(com.xfinity.playerlib.R.string.tv_series);
    }

    protected Bundle getFilterBundle()
    {
        return new Bundle();
    }

    protected DibicProgramFilter getFilterValue()
    {
        return ((PlayerUserSettings)userManager.getUserSettings()).getSeriesFilter();
    }

    protected SortPolicy getSortPolicy()
    {
        return sortPolicy;
    }

    protected TaskExecutionListener getTaskExecutionListener()
    {
        if (taskExecutionListener == null)
        {
            taskExecutionListener = new DefaultTaskExecutionListener() {

                final SeriesFragment this$0;

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    getLoadingViewDelegate().onLoadingFailed();
                }

                public void onPostExecute(Tuple tuple)
                {
                    displayPrograms(((DibicResource)tuple.e1).getPrograms(), (VideoEntitlement)tuple.e2);
                    alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.id.ACCESSIBILITY_ANNOUNCE_LOADED);
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Tuple)obj);
                }

                public void onPreAsynchronousExecute()
                {
                    alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.loading);
                }

            
            {
                this$0 = SeriesFragment.this;
                super();
            }
            };
        }
        return taskExecutionListener;
    }

    protected TaskExecutor getTaskExecutor()
    {
        return taskExecutor;
    }

    protected void hideSortButtons()
    {
        alphaSortButton.setVisibility(8);
        otherSortButton.setVisibility(8);
        popularityButton.setVisibility(8);
        if (filterButton == null && sortBar != null)
        {
            sortBar.setVisibility(8);
        }
        onHideSortBar();
    }

    protected void itemClicked(DibicProgram dibicprogram)
    {
        startActivity((new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(dibicprogram)).wantsSubscriptionOnly(getFilterValue().isHideLockOn()).build().getIntent(getActivity()));
    }

    protected volatile void itemClicked(Object obj)
    {
        itemClicked((DibicProgram)obj);
    }

    protected void itemLongClicked(DibicProgram dibicprogram)
    {
        if (dibicprogram == null)
        {
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

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)super.onCreateView(layoutinflater, viewgroup, bundle);
        setupSortButtons(layoutinflater, sortPolicy.getSortTypes());
        setupOtherButton(otherSortButton, (Button)otherSortButton.findViewById(com.xfinity.playerlib.R.id.btn_otherSort), getString(com.xfinity.playerlib.R.string.chronological_series_sort_button_text), getString(com.xfinity.playerlib.R.string.chronological_series_sort_button_speech));
        trackingService.trackTabRendered(PlayNowTab.TV_SERIES);
        showFilterButton();
        return layoutinflater;
    }

    protected void showSortButtons()
    {
        alphaSortButton.setVisibility(0);
        otherSortButton.setVisibility(0);
        popularityButton.setVisibility(0);
        if (filterButton == null && sortBar != null)
        {
            sortBar.setVisibility(0);
        }
        onShowSortBar();
    }

    public void updateSortButtonStates(SortPolicy.SortType sorttype)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[];

            static 
            {
                $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType = new int[SortPolicy.SortType.values().length];
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[SortPolicy.SortType.ALPHA.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[SortPolicy.SortType.NEW.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[SortPolicy.SortType.POPULAR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType[sorttype.ordinal()])
        {
        default:
            LOG.warn((new StringBuilder()).append("unexpected sort=").append(sorttype).toString());
            return;

        case 1: // '\001'
            select(alphaSortButton);
            unselect(otherSortButton);
            unselect(popularityButton);
            return;

        case 2: // '\002'
            select(otherSortButton);
            unselect(alphaSortButton);
            unselect(popularityButton);
            return;

        case 3: // '\003'
            select(popularityButton);
            break;
        }
        unselect(alphaSortButton);
        unselect(otherSortButton);
    }

}
