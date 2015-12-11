// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            MultiTypeProgramsFragment, DibicProgramFilter

public class KidsProgramsFragment extends MultiTypeProgramsFragment
{

    private String label;

    public KidsProgramsFragment()
    {
    }

    protected CharSequence getContentDescriptionForAccessibility()
    {
        return getString(com.xfinity.playerlib.R.string.flyin_menu_kids);
    }

    protected Bundle getFilterBundle()
    {
        return new Bundle();
    }

    protected DibicProgramFilter getFilterValue()
    {
        return ((PlayerUserSettings)userManager.getUserSettings()).getKidsFilter();
    }

    protected TaskExecutionListener getTaskExecutionListener()
    {
        if (taskExecutionListener == null)
        {
            taskExecutionListener = new DefaultTaskExecutionListener() {

                final KidsProgramsFragment this$0;

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    getLoadingViewDelegate().onLoadingFailed();
                }

                public void onPostExecute(Tuple3 tuple3)
                {
                    Object obj = (DibicResource)tuple3.e1;
                    tuple3 = (VideoEntitlement)tuple3.e3;
                    showFilterButton();
                    obj = new ArrayList(((DibicResource) (obj)).getPrograms());
                    Iterator iterator = ((List) (obj)).iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        if (!((DibicProgram)iterator.next()).isKids())
                        {
                            iterator.remove();
                        }
                    } while (true);
                    displayPrograms(((List) (obj)), tuple3);
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Tuple3)obj);
                }

            
            {
                this$0 = KidsProgramsFragment.this;
                super();
            }
            };
        }
        return taskExecutionListener;
    }

    protected void itemClicked(DibicProgram dibicprogram)
    {
        startActivity((new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(dibicprogram)).wantsSubscriptionOnly(getFilterValue().isHideLockOn()).build().getIntent(getActivity()));
    }

    protected volatile void itemClicked(Object obj)
    {
        itemClicked((DibicProgram)obj);
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
        label = bundle.getString("label");
        bundle = PlayerContainer.getInstance();
        provider = bundle.getProgramsAndTagsAndEntitlementTaskExecutor();
        sortPolicy = bundle.getNullSortPolicy();
        setHasOptionsMenu(true);
    }
}
