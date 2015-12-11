// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.networkcollections.NetworkActionBarController;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            MultiTypeProgramsFragment, NetworkProgramsFilterDialog, DibicProgramFilter

public class NetworkProgramsFragment extends MultiTypeProgramsFragment
{
    public static final class DisplayType extends Enum
    {

        private static final DisplayType $VALUES[];
        public static final DisplayType ALL_MOVIES;
        public static final DisplayType ALL_TV_SERIES;
        public static final DisplayType COLLECTION;

        public static DisplayType valueOf(String s)
        {
            return (DisplayType)Enum.valueOf(com/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType, s);
        }

        public static DisplayType[] values()
        {
            return (DisplayType[])$VALUES.clone();
        }

        static 
        {
            ALL_MOVIES = new DisplayType("ALL_MOVIES", 0);
            ALL_TV_SERIES = new DisplayType("ALL_TV_SERIES", 1);
            COLLECTION = new DisplayType("COLLECTION", 2);
            $VALUES = (new DisplayType[] {
                ALL_MOVIES, ALL_TV_SERIES, COLLECTION
            });
        }

        private DisplayType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment);
    protected NetworkActionBarController actionBarController;
    private OrderedTag category;
    protected String categoryId;
    protected long companyId;
    private DisplayType displayType;
    protected Network network;

    public NetworkProgramsFragment()
    {
    }

    public static Bundle createBundle(Network network1, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("companyId", network1.getCompanyId());
        bundle.putString("categoryId", s);
        return bundle;
    }

    protected CharSequence getContentDescriptionForAccessibility()
    {
        return null;
    }

    protected Bundle getFilterBundle()
    {
        return NetworkProgramsFilterDialog.createBundle(Long.valueOf(companyId), categoryId);
    }

    protected DibicProgramFilter getFilterValue()
    {
        return ((PlayerUserSettings)userManager.getUserSettings()).getNetworkProgramsFilter(companyId, categoryId);
    }

    protected TaskExecutionListener getTaskExecutionListener()
    {
        if (taskExecutionListener == null)
        {
            taskExecutionListener = new DefaultTaskExecutionListener() {

                final NetworkProgramsFragment this$0;

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    getLoadingViewDelegate().onLoadingFailed();
                }

                public void onPostExecute(Tuple3 tuple3)
                {
                    Object obj;
                    obj = (DibicResource)tuple3.e1;
                    TagsRoot tagsroot = (TagsRoot)tuple3.e2;
                    tuple3 = (VideoEntitlement)tuple3.e3;
                    network = tagsroot.getNetworkByCompanyId(companyId);
                    category = network.getCategoryById(categoryId);
                    static class _cls2
                    {

                        static final int $SwitchMap$com$xfinity$playerlib$view$browseprograms$NetworkProgramsFragment$DisplayType[];

                        static 
                        {
                            $SwitchMap$com$xfinity$playerlib$view$browseprograms$NetworkProgramsFragment$DisplayType = new int[DisplayType.values().length];
                            try
                            {
                                $SwitchMap$com$xfinity$playerlib$view$browseprograms$NetworkProgramsFragment$DisplayType[DisplayType.ALL_MOVIES.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror2) { }
                            try
                            {
                                $SwitchMap$com$xfinity$playerlib$view$browseprograms$NetworkProgramsFragment$DisplayType[DisplayType.ALL_TV_SERIES.ordinal()] = 2;
                            }
                            catch (NoSuchFieldError nosuchfielderror1) { }
                            try
                            {
                                $SwitchMap$com$xfinity$playerlib$view$browseprograms$NetworkProgramsFragment$DisplayType[DisplayType.COLLECTION.ordinal()] = 3;
                            }
                            catch (NoSuchFieldError nosuchfielderror)
                            {
                                return;
                            }
                        }
                    }

                    _cls2..SwitchMap.com.xfinity.playerlib.view.browseprograms.NetworkProgramsFragment.DisplayType[displayType.ordinal()];
                    JVM INSTR tableswitch 1 3: default 108
                //                               1 205
                //                               2 258
                //                               3 311;
                       goto _L1 _L2 _L3 _L4
_L1:
                    break; /* Loop/switch isn't completed */
_L4:
                    break MISSING_BLOCK_LABEL_311;
_L5:
                    if (shouldShowFilterButton)
                    {
                        showFilterButton();
                    } else
                    if (companyId != null)
                    {
                        filterSubNav.setVisibility(8);
                    }
                    if (actionBarController != null)
                    {
                        if (network.isPremium())
                        {
                            actionBarController.loadNetworkLogoAndCategory(network, category);
                        } else
                        {
                            actionBarController.setNetworkNameAndCategory(network, category);
                        }
                    }
                    obj = ((DibicResource) (obj)).getProgramsMatchingGenreAndNetwork(category, network);
                    displayPrograms(((java.util.List) (obj)), tuple3);
                    return;
_L2:
                    setupOtherButton(otherSortButton, (Button)otherSortButton.findViewById(com.xfinity.playerlib.R.id.btn_otherSort), getString(com.xfinity.playerlib.R.string.chronological_movie_sort_button_text), getString(com.xfinity.playerlib.R.string.chronological_movie_sort_button_speech));
                      goto _L5
_L3:
                    setupOtherButton(otherSortButton, (Button)otherSortButton.findViewById(com.xfinity.playerlib.R.id.btn_otherSort), getString(com.xfinity.playerlib.R.string.chronological_series_sort_button_text), getString(com.xfinity.playerlib.R.string.chronological_series_sort_button_speech));
                      goto _L5
                    shouldShowFilterButton = false;
                      goto _L5
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Tuple3)obj);
                }

            
            {
                this$0 = NetworkProgramsFragment.this;
                super();
            }
            };
        }
        return taskExecutionListener;
    }

    protected void itemClicked(DibicProgram dibicprogram)
    {
        startActivity((new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(dibicprogram)).companyId(Long.valueOf(network.getCompanyId())).build().getIntent(getActivity()));
    }

    protected volatile void itemClicked(Object obj)
    {
        itemClicked((DibicProgram)obj);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof NetworkActionBarController)
        {
            actionBarController = (NetworkActionBarController)activity;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new Bundle();
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null)
        {
            bundle.putAll(intent.getExtras());
        }
        if (getArguments() != null)
        {
            bundle.putAll(getArguments());
        }
        companyId = bundle.getLong("companyId");
        categoryId = bundle.getString("categoryId");
        shouldShowFilterButton = bundle.getBoolean("showFilterButton", true);
        Validate.notNull(categoryId);
        bundle = PlayerContainer.getInstance();
        if (categoryId.equals(OrderedTag.ALL_MOVIES.getId()))
        {
            displayType = DisplayType.ALL_MOVIES;
            provider = bundle.getMoviesAndTagsAndEntitlementTaskExecutor();
            sortPolicy = bundle.getMovieCollectionSortPolicy();
            return;
        }
        if (categoryId.equals(OrderedTag.ALL_TV.getId()))
        {
            displayType = DisplayType.ALL_TV_SERIES;
            provider = bundle.getSeriesAndTagsAndEntitlementTaskExecutor();
            sortPolicy = bundle.getSeriesCollectionSortPolicy();
            return;
        } else
        {
            displayType = DisplayType.COLLECTION;
            provider = bundle.getProgramsAndTagsAndEntitlementTaskExecutor();
            sortPolicy = bundle.getNullSortPolicy();
            return;
        }
    }




/*
    static OrderedTag access$002(NetworkProgramsFragment networkprogramsfragment, OrderedTag orderedtag)
    {
        networkprogramsfragment.category = orderedtag;
        return orderedtag;
    }

*/


}
