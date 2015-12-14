// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import com.amazon.gallery.framework.gallery.widget.holder.LoadingHolderInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GridStatus
{

    private boolean forceShow;
    private Set visibleList;

    public GridStatus()
    {
        visibleList = Collections.newSetFromMap(new ConcurrentHashMap(40));
        forceShow = false;
    }

    public boolean isLoading()
    {
        if (forceShow)
        {
            return true;
        }
        for (Iterator iterator = visibleList.iterator(); iterator.hasNext();)
        {
            if (((LoadingHolderInterface)iterator.next()).isLoading())
            {
                return true;
            }
        }

        return false;
    }

    public void onHidden(LoadingHolderInterface loadingholderinterface)
    {
        visibleList.remove(loadingholderinterface);
    }

    public void onVisible(LoadingHolderInterface loadingholderinterface)
    {
        visibleList.add(loadingholderinterface);
    }

    public void reset()
    {
        visibleList.clear();
    }

    public void setForceShow(boolean flag)
    {
        forceShow = flag;
    }
}
