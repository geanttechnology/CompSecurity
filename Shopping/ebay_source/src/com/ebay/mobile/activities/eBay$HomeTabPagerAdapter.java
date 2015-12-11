// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.ViewGroup;
import com.ebay.mobile.home.StartFragment;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.shared.ui.TaggedFragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            eBay

static class channels extends TaggedFragmentPagerAdapter
{

    private final List channels = new ArrayList();

    public int getCount()
    {
        if (channels == null)
        {
            return 0;
        } else
        {
            return channels.size();
        }
    }

    public String getFragmentTag(int i)
    {
        if (channels == null)
        {
            return "";
        } else
        {
            return ((Channel)channels.get(i)).name;
        }
    }

    public Fragment getItem(int i)
    {
        StartFragment startfragment = new StartFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("ChannelIndex", i);
        startfragment.setArguments(bundle);
        return startfragment;
    }

    public CharSequence getPageTitle(int i)
    {
        if (channels == null)
        {
            return null;
        } else
        {
            return ((Channel)channels.get(i)).displayName.content;
        }
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        viewgroup = ((ViewGroup) (super.instantiateItem(viewgroup, i)));
        if (viewgroup != null && (viewgroup instanceof StartFragment))
        {
            StartFragment startfragment = (StartFragment)viewgroup;
            if (!((Channel)channels.get(i)).equals(startfragment.getChannel()))
            {
                startfragment.update();
            }
        }
        return viewgroup;
    }

    public _cls9(FragmentManager fragmentmanager, List list)
    {
        super(fragmentmanager);
        if (list != null)
        {
            channels.addAll(list);
        }
    }
}
