// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMTabButton;
import java.util.EmptyStackException;
import java.util.Stack;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class RootTabFragment extends Fragment
    implements PMNotificationListener, TraceFieldInterface
{

    boolean bIsChildFragmentCreated;
    boolean bPopToTop;
    Class childFragmentClass;
    public int fragmentContainerId;
    Bundle fragmentDataBundle;
    boolean isSaved;
    Stack stack;
    PMTabButton tabButton;

    public RootTabFragment()
    {
        bIsChildFragmentCreated = false;
        stack = new Stack();
        bPopToTop = false;
        isSaved = false;
    }

    public void attachTabButton(PMTabButton pmtabbutton)
    {
        tabButton = pmtabbutton;
    }

    public void collapseAllSubfragments()
    {
        if (isAdded())
        {
            FragmentManager fragmentmanager = getChildFragmentManager();
            int j = fragmentmanager.getBackStackEntryCount();
            for (int i = 1; i < j; i++)
            {
                fragmentmanager.popBackStackImmediate();
            }

        } else
        {
            Object obj = getActivity();
            if (obj != null)
            {
                obj = ((FragmentActivity) (obj)).getSupportFragmentManager();
                FragmentTransaction fragmenttransaction = ((FragmentManager) (obj)).beginTransaction();
                fragmenttransaction.remove(this);
                fragmenttransaction.commitAllowingStateLoss();
                ((FragmentManager) (obj)).executePendingTransactions();
                tabButton.detachFragmentFromTabButton();
            }
        }
    }

    public int getContainerId()
    {
        return fragmentContainerId;
    }

    public PMFragment getCurrentActiveChildFragment()
    {
        return (PMFragment)stack.peek();
    }

    public boolean handleBackPressed()
    {
        PMFragment pmfragment;
        FragmentManager fragmentmanager;
        pmfragment = (PMFragment)stack.peek();
        if (pmfragment.handleBack())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        fragmentmanager = getChildFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() == 1)
        {
            return false;
        }
        try
        {
            ((PMContainerActivity)getActivity()).killDrawerFragment(pmfragment);
            fragmentmanager.popBackStackImmediate();
            stack.pop();
        }
        catch (EmptyStackException emptystackexception)
        {
            return false;
        }
        return true;
        return true;
    }

    public void handleNotification(Intent intent)
    {
    }

    public boolean isStateSavingCompleted()
    {
        return isSaved;
    }

    public void launchChildFragment()
    {
        PMFragment pmfragment;
        FragmentTransaction fragmenttransaction;
        try
        {
            pmfragment = (PMFragment)childFragmentClass.newInstance();
            pmfragment.setArguments(fragmentDataBundle);
            pmfragment.setUserVisibleHint(true);
        }
        catch (InstantiationException instantiationexception)
        {
            instantiationexception.printStackTrace();
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            illegalaccessexception.printStackTrace();
            return;
        }
        if (pmfragment == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        fragmenttransaction = getChildFragmentManager().beginTransaction();
        fragmenttransaction.add(fragmentContainerId, pmfragment);
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commit();
        stack.push(pmfragment);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (!bIsChildFragmentCreated)
        {
            bIsChildFragmentCreated = true;
            launchChildFragment();
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        PMFragment pmfragment = getCurrentActiveChildFragment();
        if (pmfragment != null)
        {
            pmfragment.onActivityResult(i, j, intent);
        }
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("RootTabFragment");
        TraceMachine.enterMethod(_nr_trace, "RootTabFragment#onCreate", null);
_L1:
        super.onCreate(bundle);
        bundle = getArguments().getString("FRAGMENT_CLASS");
        NoSuchFieldError nosuchfielderror;
        if (bundle != null)
        {
            try
            {
                childFragmentClass = Class.forName(bundle);
                fragmentDataBundle = getArguments().getBundle("FRAGMENT_DATA");
                PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", this);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        TraceMachine.exitMethod();
        return;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "RootTabFragment#onCreate", null);
          goto _L1
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "RootTabFragment#onCreateView", null);
_L1:
        layoutinflater = layoutinflater.inflate(0x7f0300a9, viewgroup, false);
        fragmentContainerId = 0x7f0c027a;
        TraceMachine.exitMethod();
        return layoutinflater;
        bundle;
        TraceMachine.enterMethod(null, "RootTabFragment#onCreateView", null);
          goto _L1
    }

    public void onDestroy()
    {
        super.onDestroy();
        bIsChildFragmentCreated = false;
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void onResume()
    {
        super.onResume();
        isSaved = false;
        if (bPopToTop)
        {
            bPopToTop = false;
            popFragmentsToTop();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        isSaved = true;
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void popFragmentsToTop()
    {
        if (isAdded())
        {
            FragmentManager fragmentmanager = getChildFragmentManager();
            int j = fragmentmanager.getBackStackEntryCount();
            for (int i = 1; i < j; i++)
            {
                fragmentmanager.popBackStackImmediate();
                stack.pop();
            }

        } else
        {
            bPopToTop = true;
        }
    }

    public void replaceChildFragment(PMFragment pmfragment)
    {
        FragmentTransaction fragmenttransaction = getChildFragmentManager().beginTransaction();
        Fragment fragment = (Fragment)stack.peek();
        if (fragment != null)
        {
            fragmenttransaction.hide(fragment);
        }
        fragmenttransaction.add(getContainerId(), pmfragment);
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commit();
        stack.push(pmfragment);
    }

    public void startChildFragment(PMFragment pmfragment)
    {
        FragmentTransaction fragmenttransaction = getChildFragmentManager().beginTransaction();
        fragmenttransaction.replace(getContainerId(), pmfragment);
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commit();
        stack.push(pmfragment);
    }
}
