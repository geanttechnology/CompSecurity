// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.search.HasCustomContent;
import com.ebay.mobile.search.RefinementLocks;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.refine.adapters.RefineOptionAdapter;
import com.ebay.mobile.util.ContentSyncManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            DetailController

public abstract class BaseDetailController
    implements DetailController
{

    private static final String EXTRA_ONE_SHOT = "isOneShot";
    private static List defaultSyncKeys = new ArrayList();
    protected View customView;
    protected Bundle deferredStateExtras;
    protected boolean oneShot;
    protected ViewGroup parentView;
    protected final Activity refineActivity;
    protected final SearchRefineFragment refineFragment;
    protected boolean syncRegistered;

    public BaseDetailController(SearchRefineFragment searchrefinefragment)
    {
        deferredStateExtras = null;
        oneShot = false;
        syncRegistered = false;
        refineFragment = searchrefinefragment;
        refineActivity = searchrefinefragment.getActivity();
    }

    protected void closeIfActive()
    {
        if (isActive())
        {
            refineFragment.closeRefinement();
        }
    }

    public View createView()
    {
        return null;
    }

    public RefineOptionAdapter getAdapter()
    {
        return null;
    }

    public List getContentSyncKeys()
    {
        return defaultSyncKeys;
    }

    public View getCustomView()
    {
        if (customView == null)
        {
            customView = createView();
        }
        return customView;
    }

    protected RefinementLocks getRefinementLocks()
    {
        return refineFragment.locks;
    }

    protected SearchParameters getSearchParameters()
    {
        return refineFragment.searchParameters;
    }

    public Bundle getStateExtras()
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isOneShot", isOneShot());
        return bundle;
    }

    protected String getString(int i)
    {
        return refineActivity.getString(i);
    }

    protected boolean isActive()
    {
        return refineFragment.getActiveDetailController() == this;
    }

    public boolean isMainHeaderVisible()
    {
        return !oneShot;
    }

    public boolean isOneShot()
    {
        return oneShot;
    }

    public void notifyHeaderClicked()
    {
    }

    public void onBackClicked()
    {
    }

    public void onDoneClicked()
    {
    }

    public void onPause()
    {
    }

    public void onResume()
    {
        if ((this instanceof com.ebay.mobile.util.ContentSyncManager.ContentSync) && !syncRegistered)
        {
            Object obj = getContentSyncKeys();
            if (obj != null && ((List) (obj)).size() > 0)
            {
                String s;
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ContentSyncManager.register((com.ebay.mobile.util.ContentSyncManager.ContentSync)this, new String[] {
    s
}))
                {
                    s = (String)((Iterator) (obj)).next();
                }

            }
            syncRegistered = true;
        }
        if (this instanceof HasCustomContent)
        {
            android.view.ViewParent viewparent = customView.getParent();
            if (viewparent != parentView)
            {
                if (viewparent != null)
                {
                    ((ViewGroup)customView.getParent()).removeView(customView);
                }
                parentView.addView(customView);
            }
        }
    }

    public void onUpClicked()
    {
    }

    protected void searchParamsUpdated()
    {
        refineFragment.searchParamsUpdated();
    }

    public void setCustomViewHost(ViewGroup viewgroup)
    {
        parentView = viewgroup;
        if (this instanceof HasCustomContent)
        {
            customView = ((HasCustomContent)this).getCustomView();
        }
    }

    public void setOneShot(boolean flag)
    {
        oneShot = flag;
    }

    public void setStateExtras(Bundle bundle)
    {
        deferredStateExtras = bundle;
        boolean flag;
        if (bundle != null && bundle.getBoolean("isOneShot"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setOneShot(flag);
    }

    protected void unlockRefinements(com.ebay.mobile.search.RefinementLocks.RefinementLockType arefinementlocktype[])
    {
        int j = arefinementlocktype.length;
        for (int i = 0; i < j; i++)
        {
            com.ebay.mobile.search.RefinementLocks.RefinementLockType refinementlocktype = arefinementlocktype[i];
            refineFragment.locks.unlock(refinementlocktype);
        }

    }

}
