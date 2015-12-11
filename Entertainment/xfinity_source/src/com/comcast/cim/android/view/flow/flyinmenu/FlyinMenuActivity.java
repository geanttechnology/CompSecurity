// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.flow.flyinmenu;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import com.comcast.cim.android.sideribbon.SideMenuBuilder;
import com.comcast.cim.android.sideribbon.SideRibbonDelegate;
import com.comcast.cim.android.sideribbon.SideRibbonDelegateBuilder;
import com.comcast.cim.android.view.launch.AuthenticatingActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FlyinMenuActivity extends AuthenticatingActivity
    implements com.comcast.cim.android.sideribbon.SideRibbonDelegate.RibbonStateChangeListener
{

    private Logger LOG;
    private SideRibbonDelegate sideRibbon;

    public FlyinMenuActivity()
    {
        LOG = LoggerFactory.getLogger(com/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity);
        sideRibbon = null;
    }

    protected abstract int getLayoutId();

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
        setContentView(getLayoutId());
        bundle = getActionBar();
        if (bundle != null)
        {
            bundle.setHomeButtonEnabled(true);
            sideRibbon = getSideRibbonDelegateBuilder().build(this);
            sideRibbon.init();
            sideRibbon.setRibbonContentView(getSideMenuBuilder().build(this, sideRibbon.getRibbonContainer(), sideRibbon));
            sideRibbon.addRibbonStateChangeListener(this);
            sideRibbon.addPassiveStateChangeListener(this);
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

    public void onSideRibbonStateChanged(com.comcast.cim.android.sideribbon.SideRibbonDelegate.State state)
    {
    }
}
