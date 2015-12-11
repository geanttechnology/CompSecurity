// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.groupon.activity:
//            Carousel

private static class <init>
    implements android.support.v4.view.it>
{

    private ArrayList listeners;

    public void addOnPageChangeListener(android.support.v4.view.it> it>)
    {
        listeners.add(it>);
    }

    public void onPageScrollStateChanged(int i)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((android.support.v4.view.teners)iterator.next()).geScrollStateChanged(i)) { }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((android.support.v4.view.teners)iterator.next()).geScrolled(i, f, j)) { }
    }

    public void onPageSelected(int i)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((android.support.v4.view.teners)iterator.next()).geSelected(i)) { }
    }

    public void removeOnPageChangeListener(android.support.v4.view.geSelected geselected)
    {
        listeners.remove(geselected);
    }

    private ()
    {
        listeners = new ArrayList();
    }

    listeners(listeners listeners1)
    {
        this();
    }
}
