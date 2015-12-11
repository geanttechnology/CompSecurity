// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.support.v4.app.j;
import com.target.ui.util.q;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.common:
//            TabbedFragment, BaseNavigationFragment

public static class mItems extends j
{

    private final List mItems;

    public int a(Object obj)
    {
        for (Iterator iterator = mItems.iterator(); iterator.hasNext();)
        {
            if (((mItems)iterator.next()).a() == obj)
            {
                return -1;
            }
        }

        return -2;
    }

    public Fragment a(int i)
    {
        Fragment fragment = ((gment)mItems.get(i)).a();
        try
        {
            BaseNavigationFragment basenavigationfragment = (BaseNavigationFragment)fragment;
            basenavigationfragment.m(false);
            basenavigationfragment.n(false);
            basenavigationfragment.h(2);
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(fragment.toString()).append(" must subclass ").append("BaseNavigationFragment to be used with TabbedFragment").toString());
        }
        return fragment;
    }

    public void a(gment.h h, int i)
    {
        if (i >= mItems.size())
        {
            q.a(TabbedFragment.TAG, (new StringBuilder()).append("Invalid index ").append(i).append(", unable to replace fragment").toString());
            return;
        } else
        {
            mItems.remove(i);
            mItems.add(i, h);
            c();
            return;
        }
    }

    public int b()
    {
        return mItems.size();
    }

    public long b(int i)
    {
        mItems mitems = (mItems)mItems.get(i);
        if (mitems.c() == 0x8000000000000000L)
        {
            return (long)i;
        } else
        {
            return mitems.c();
        }
    }

    public CharSequence c(int i)
    {
        return ((c)mItems.get(i)).b();
    }

    public gment(h h, List list)
    {
        super(h);
        mItems = list;
    }
}
