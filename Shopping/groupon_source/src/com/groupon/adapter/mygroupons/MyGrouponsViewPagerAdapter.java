// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.mygroupons;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;
import com.groupon.models.MyGrouponsPage;
import java.util.List;

// Referenced classes of package com.groupon.adapter.mygroupons:
//            MyGrouponsPagesCreator

public class MyGrouponsViewPagerAdapter extends FragmentPagerAdapter
{

    private MyGrouponsPagesCreator myGrouponsPagesCreator;

    public MyGrouponsViewPagerAdapter(Context context, FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
        myGrouponsPagesCreator = new MyGrouponsPagesCreator(context);
        myGrouponsPagesCreator.createPages();
    }

    public int getCount()
    {
        return myGrouponsPagesCreator.getMyGrouponsPages().size();
    }

    public Fragment getItem(int i)
    {
        return ((MyGrouponsPage)myGrouponsPagesCreator.getMyGrouponsPages().get(i)).getPageFragment();
    }

    public CharSequence getPageTitle(int i)
    {
        return ((MyGrouponsPage)myGrouponsPagesCreator.getMyGrouponsPages().get(i)).getTitle();
    }
}
