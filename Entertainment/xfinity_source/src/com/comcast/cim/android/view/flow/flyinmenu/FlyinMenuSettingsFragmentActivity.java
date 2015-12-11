// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.flow.flyinmenu;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.comcast.cim.android.sideribbon.SideMenuBuilder;
import com.comcast.cim.android.sideribbon.SideRibbonDelegate;
import com.comcast.cim.android.sideribbon.SideRibbonDelegateBuilder;
import com.comcast.cim.android.view.settings.SettingsFragmentActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FlyinMenuSettingsFragmentActivity extends SettingsFragmentActivity
{

    private Logger LOG;
    private ActionBar actionBar;
    private TextView actionBarTitle;
    private SideRibbonDelegate sideRibbon;

    public FlyinMenuSettingsFragmentActivity()
    {
        LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity);
        sideRibbon = null;
    }

    protected abstract SideMenuBuilder getSideMenuBuilder();

    protected abstract SideRibbonDelegateBuilder getSideRibbonDelegateBuilder();

    public void onBackPressed()
    {
        if (sideRibbon == null || !sideRibbon.handleBackPressed())
        {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        actionBar = getActionBar();
        if (actionBar != null && actionBar.getCustomView() != null)
        {
            actionBarTitle = (TextView)actionBar.getCustomView().findViewById(com.comcast.cim.android.R.id.title);
            actionBarTitle.setText(getTitle());
            sideRibbon = getSideRibbonDelegateBuilder().build(this);
            sideRibbon.init();
            sideRibbon.setRibbonContentView(getSideMenuBuilder().build(this, sideRibbon.getRibbonContainer(), sideRibbon));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 32;
           goto _L1 _L2
_L1:
        super.onOptionsItemSelected(menuitem);
_L4:
        return true;
_L2:
        if (sideRibbon != null)
        {
            sideRibbon.toggleSlideIn();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void setActionBarIcon(int i)
    {
        actionBar.setIcon(i);
    }

    public void setTitle(int i)
    {
        super.setTitle(i);
        if (actionBarTitle != null)
        {
            actionBarTitle.setText(i);
        }
    }

    public void setTitle(CharSequence charsequence)
    {
        super.setTitle(charsequence);
        if (actionBarTitle != null)
        {
            actionBarTitle.setText(charsequence);
        }
    }
}
