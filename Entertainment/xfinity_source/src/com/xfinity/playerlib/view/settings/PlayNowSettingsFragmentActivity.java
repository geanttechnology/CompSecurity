// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.comcast.cim.android.sideribbon.SideMenuBuilder;
import com.comcast.cim.android.sideribbon.SideRibbonDelegateBuilder;
import com.comcast.cim.android.view.flow.flyinmenu.FlyinMenuSettingsFragmentActivity;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowSettingsFragment, PlayerPrefsHeaderAdapter

public class PlayNowSettingsFragmentActivity extends FlyinMenuSettingsFragmentActivity
{

    private final PlayerAndroidDevice androidDevice = PlayerContainer.getInstance().getAndroidDevice();
    private final PlayerConfiguration configuration = PlayerContainer.getInstance().getConfiguration();
    private List mHeaders;
    private final SideMenuBuilder sideMenuBuilder = PlayerContainer.getInstance().getSideMenuBuilder();
    private final SideRibbonDelegateBuilder sideRibbonDelegateBuilder = PlayerContainer.getInstance().getSideRibbonDelegateBuilder();
    private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();

    public PlayNowSettingsFragmentActivity()
    {
    }

    protected SideMenuBuilder getSideMenuBuilder()
    {
        return sideMenuBuilder;
    }

    protected SideRibbonDelegateBuilder getSideRibbonDelegateBuilder()
    {
        return sideRibbonDelegateBuilder;
    }

    protected boolean isValidFragment(String s)
    {
        return com/xfinity/playerlib/view/settings/PlayNowSettingsFragment.getName().equals(s);
    }

    public void onBuildHeaders(List list)
    {
        super.onBuildHeaders(list);
        mHeaders = list;
        Resources resources = getResources();
        String s = resources.getString(com.xfinity.playerlib.R.string.settings_signout_title);
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            android.preference.PreferenceActivity.Header header1 = (android.preference.PreferenceActivity.Header)iterator.next();
            if (header1.getTitle(resources) != null && header1.getTitle(resources).toString().equals(s))
            {
                header1.summary = ((PlayNowUser)userManager.getUser()).getUserName();
            }
        } while (true);
        if (!androidDevice.hasCellularCapability())
        {
            String s1 = resources.getString(com.xfinity.playerlib.R.string.settings_use_cellular_title);
            Iterator iterator1 = list.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                android.preference.PreferenceActivity.Header header2 = (android.preference.PreferenceActivity.Header)iterator1.next();
                if (header2.getTitle(resources) != null && header2.getTitle(resources).toString().equals(s1))
                {
                    iterator1.remove();
                }
            } while (true);
        }
        if (!configuration.isDeveloperModeAllowed())
        {
            String s2 = resources.getString(com.xfinity.playerlib.R.string.settings_title_developer_options);
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                android.preference.PreferenceActivity.Header header = (android.preference.PreferenceActivity.Header)list.next();
                if (header.getTitle(resources) != null && header.getTitle(resources).toString().equals(s2))
                {
                    list.remove();
                }
            } while (true);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (androidDevice.isKindle())
        {
            getWindow().addFlags(1024);
        }
    }

    public void setListAdapter(ListAdapter listadapter)
    {
        if (mHeaders == null)
        {
            mHeaders = new ArrayList();
            int j = listadapter.getCount();
            for (int i = 0; i < j; i++)
            {
                mHeaders.add((android.preference.PreferenceActivity.Header)listadapter.getItem(i));
            }

        }
        getListView().setDivider(null);
        getListView().setDividerHeight(0);
        super.setListAdapter(new PlayerPrefsHeaderAdapter(this, mHeaders, androidDevice));
    }

    public void setTitle(CharSequence charsequence)
    {
        if (!androidDevice.isKindle())
        {
            super.setTitle(charsequence);
        }
    }
}
