// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ViewGroup;
import com.bitstrips.imoji.models.Templates;
import com.bitstrips.imoji.ui.ImojiBrowserFragment;
import com.bitstrips.imoji.ui.fragments.FavouriteFragment;
import java.util.List;

public class ImojiPagerAdapter extends FragmentPagerAdapter
{

    private static final String TAG = com/bitstrips/imoji/ui/adapters/ImojiPagerAdapter.getCanonicalName();
    private Context context;
    private FragmentManager fragmentManager;
    private int imageResId[] = {
        0x7f0200e0, 0x7f0200e0, 0x7f0200e0, 0x7f0200e0, 0x7f0200e0, 0x7f0200e0
    };
    private List superTags;

    public ImojiPagerAdapter(FragmentManager fragmentmanager, Context context1, Templates templates)
    {
        super(fragmentmanager);
        context = context1;
        fragmentManager = fragmentmanager;
        updateTemplates(templates);
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        try
        {
            Fragment fragment = (Fragment)obj;
            FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
            fragmenttransaction.remove(fragment);
            fragmenttransaction.commitAllowingStateLoss();
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log.d(TAG, (new StringBuilder()).append("Caught unexpected exception while destroying item: ").append(illegalstateexception.toString()).toString());
        }
        super.destroyItem(viewgroup, i, obj);
    }

    public int getCount()
    {
        return superTags.size();
    }

    public Fragment getItem(int i)
    {
        if (i == 0)
        {
            return FavouriteFragment.newInstance();
        } else
        {
            return ImojiBrowserFragment.newInstance((String)superTags.get(i));
        }
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public CharSequence getTabSupertag(int i)
    {
        if (i == 0)
        {
            return "recent";
        } else
        {
            return ((String)superTags.get(i)).replace("#i", "");
        }
    }

    public void updateTemplates(Templates templates)
    {
        superTags = templates.getSuperTags();
    }

}
