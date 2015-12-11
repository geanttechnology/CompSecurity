// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.common;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.common:
//            FragmentDelegate

public class DelegatingFragment extends Fragment
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/android/util/view/common/DelegatingFragment);
    private List delegateList;

    public DelegatingFragment()
    {
        delegateList = new ArrayList();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        for (Iterator iterator = delegateList.iterator(); iterator.hasNext(); ((FragmentDelegate)iterator.next()).onAttach(activity)) { }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        for (bundle = delegateList.iterator(); bundle.hasNext(); ((FragmentDelegate)bundle.next()).onCreate()) { }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = null;
        Object obj = delegateList.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            FragmentDelegate fragmentdelegate = (FragmentDelegate)((Iterator) (obj)).next();
            if (view == null)
            {
                view = fragmentdelegate.onCreateView(layoutinflater, viewgroup, bundle);
            }
        } while (true);
        obj = view;
        if (view == null)
        {
            obj = super.onCreateView(layoutinflater, viewgroup, bundle);
        }
        return ((View) (obj));
    }

    public void onPause()
    {
        super.onPause();
        for (Iterator iterator = delegateList.iterator(); iterator.hasNext(); ((FragmentDelegate)iterator.next()).onPause()) { }
    }

    public void onResume()
    {
        super.onResume();
        boolean flag = true;
        for (Iterator iterator = delegateList.iterator(); iterator.hasNext();)
        {
            FragmentDelegate fragmentdelegate = (FragmentDelegate)iterator.next();
            if (flag && fragmentdelegate.onResume())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        if (flag)
        {
            onResumeInternal();
        }
    }

    public void onResumeInternal()
    {
    }

    public void onStart()
    {
        super.onStart();
        for (Iterator iterator = delegateList.iterator(); iterator.hasNext(); ((FragmentDelegate)iterator.next()).onStart()) { }
        onStartInternal();
    }

    public void onStartInternal()
    {
    }

    public void onStop()
    {
        super.onStop();
        for (Iterator iterator = delegateList.iterator(); iterator.hasNext(); ((FragmentDelegate)iterator.next()).onStop()) { }
    }

}
