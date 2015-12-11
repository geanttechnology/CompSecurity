// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.view.ViewGroup;
import com.ebay.mobile.categorybrowser.TopLevelCategoriesFragment;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.shared.ui.TaggedFragmentPagerAdapter;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

public class DepartmentFragmentAdapter extends TaggedFragmentPagerAdapter
{

    public static final String ALL_CATEGORIES_LITERAL = "ALLCATEGORIES";
    private final boolean isTablet;
    private final List subChannels;

    public DepartmentFragmentAdapter(FragmentManager fragmentmanager, List list, boolean flag)
    {
        super(fragmentmanager);
        if (list == null)
        {
            fragmentmanager = Collections.emptyList();
        } else
        {
            fragmentmanager = Collections.unmodifiableList(list);
        }
        subChannels = fragmentmanager;
        isTablet = flag;
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        super.destroyItem(viewgroup, i, obj);
    }

    public int getAllCategoriesIndex()
    {
        if (!subChannels.isEmpty())
        {
            int j = subChannels.size();
            for (int i = 0; i < j; i++)
            {
                if (((Channel)subChannels.get(i)).name.equals("ALLCATEGORIES"))
                {
                    return i;
                }
            }

        }
        return -1;
    }

    public int getCount()
    {
        return subChannels.size();
    }

    public String getFragmentTag(int i)
    {
        if (subChannels == null || i < 0 || i >= subChannels.size())
        {
            return null;
        }
        Channel channel = (Channel)subChannels.get(i);
        if (channel.isDepartment)
        {
            return channel.departmentName;
        } else
        {
            return channel.name;
        }
    }

    public Fragment getItem(int i)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (i < 0) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (i >= subChannels.size()) goto _L2; else goto _L3
_L3:
        Channel channel;
        byte byte0;
        channel = (Channel)subChannels.get(i);
        obj = channel.name;
        byte0 = -1;
        ((String) (obj)).hashCode();
        JVM INSTR tableswitch 1981284957 1981284957: default 68
    //                   1981284957 141;
           goto _L4 _L5
_L4:
        switch (byte0)
        {
        default:
            String s;
            String s1;
            if (channel.isDepartment)
            {
                obj = channel.departmentName;
            } else
            {
                obj = channel.name;
            }
            s1 = channel.displayName.content;
            if (isTablet)
            {
                s = channel.topBannerLarge;
            } else
            {
                s = channel.topBannerSmall;
            }
            obj = DepartmentFragment.create(((String) (obj)), s1, s, channel.isDepartment, i);
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */
        }
_L2:
        return ((Fragment) (obj));
_L5:
        if (((String) (obj)).equals("ALLCATEGORIES"))
        {
            byte0 = 0;
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (isTablet)
        {
            obj = channel.topBannerLarge;
        } else
        {
            obj = channel.topBannerSmall;
        }
        if (channel.displayName != null)
        {
            s = channel.displayName.content;
        } else
        {
            s = null;
        }
        return TopLevelCategoriesFragment.create(((String) (obj)), s);
    }
}
