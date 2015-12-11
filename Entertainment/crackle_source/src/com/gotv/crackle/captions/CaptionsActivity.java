// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import com.gotv.crackle.Application;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.helpers.ChromeCastHelper;

// Referenced classes of package com.gotv.crackle.captions:
//            CaptionSettingsFragment

public class CaptionsActivity extends BaseActivity
{

    CaptionSettingsFragment _settingsFragment;

    public CaptionsActivity()
    {
    }

    private CaptionSettingsFragment.CaptionSettingsMode getCaptionSettingsMode()
    {
        int i = 0;
        String s = getIntent().getStringExtra("CAPTION_SETTINGS_MODE");
        if (s != null)
        {
            i = Integer.parseInt(s);
        }
        return CaptionSettingsFragment.getCaptionSettingsModeForInt(i);
    }

    public void onAppSdkEvent(long l, int i, String s)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (Application.getInstance().isTablet())
        {
            requestWindowFeature(8);
            getWindow().setFlags(2, 2);
            bundle = getWindow().getAttributes();
            int i = Math.min(Application.getScreenWidth(), Application.getScreenHeight());
            bundle.height = (int)((float)i * 0.8F);
            bundle.width = (int)((float)i * 0.9F);
            bundle.alpha = 1.0F;
            bundle.dimAmount = 0.5F;
            getWindow().setAttributes(bundle);
        }
        setContentView(0x7f030020);
        bundle = getSupportFragmentManager().beginTransaction();
        _settingsFragment = CaptionSettingsFragment.getFragmentForMode(getCaptionSettingsMode());
        bundle.add(0x7f0a007f, _settingsFragment);
        bundle.commit();
        setActionBarTitle(_settingsFragment.getFragmentTitle());
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (getCaptionSettingsMode() == CaptionSettingsFragment.CaptionSettingsMode.Main)
        {
            getMenuInflater().inflate(0x7f0f0000, menu);
            MenuItemCompat.setShowAsAction(menu.findItem(0x7f0a01b0), 2);
            mChromeCastHelper.setupMenuItem(menu);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        performMenuAction(menuitem.getItemId());
        return true;
    }

    protected void performMenuAction(int i)
    {
        if (i == 0x102002c)
        {
            finish();
        } else
        if (i == 0x7f0a01b0)
        {
            _settingsFragment.reset();
            return;
        }
    }

    protected void setTheme()
    {
        setTheme(0x7f0c008d);
    }
}
