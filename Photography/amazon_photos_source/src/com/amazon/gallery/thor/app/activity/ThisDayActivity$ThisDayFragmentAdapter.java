// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.amazon.gallery.framework.kindle.fragment.ThisDayFragment;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThisDayActivity

private static class tabTitles extends FragmentPagerAdapter
{

    private final ThisDayFragment fragments[] = new ThisDayFragment[3];
    private final String tabTitles[];

    public void addFragment(ThisDayFragment thisdayfragment, int i)
    {
        fragments[i] = thisdayfragment;
    }

    public int getCount()
    {
        return fragments.length;
    }

    public Fragment getItem(int i)
    {
        return fragments[i];
    }

    public CharSequence getPageTitle(int i)
    {
        return tabTitles[i];
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        viewgroup = (ThisDayFragment)super.instantiateItem(viewgroup, i);
        fragments[i] = viewgroup;
        return viewgroup;
    }

    Q(FragmentManager fragmentmanager, String as[])
    {
        super(fragmentmanager);
        tabTitles = as;
    }
}
