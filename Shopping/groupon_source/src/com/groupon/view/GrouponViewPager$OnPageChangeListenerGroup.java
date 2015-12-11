// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.groupon.view:
//            GrouponViewPager

protected static class pageListeners
    implements android.support.v4.view.teners
{

    private ArrayList pageListeners;

    public void addOnPageChangeListener(android.support.v4.view.teners teners)
    {
        pageListeners.add(teners);
    }

    public void onPageScrollStateChanged(int i)
    {
        for (Iterator iterator = pageListeners.iterator(); iterator.hasNext(); ((android.support.v4.view.teners)iterator.next()).StateChanged(i)) { }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        for (Iterator iterator = pageListeners.iterator(); iterator.hasNext(); ((android.support.v4.view.teners)iterator.next()).ed(i, f, j)) { }
    }

    public void onPageSelected(int i)
    {
        for (Iterator iterator = pageListeners.iterator(); iterator.hasNext(); ((android.support.v4.view.teners)iterator.next()).ed(i)) { }
    }

    protected A()
    {
        pageListeners = new ArrayList();
    }
}
