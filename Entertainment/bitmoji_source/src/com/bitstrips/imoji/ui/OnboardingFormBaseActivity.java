// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class OnboardingFormBaseActivity extends AppCompatActivity
    implements com.bitstrips.imoji.ui.views.Form.ValidationCallbacksActivity
{

    protected Menu mOptionsMenu;
    protected Button mainButton;

    public OnboardingFormBaseActivity()
    {
    }

    protected void disableButtons()
    {
        mainButton.setEnabled(false);
        setTopButtonEnabled(false);
    }

    protected void enableButtons()
    {
        mainButton.setEnabled(true);
        setTopButtonEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        mOptionsMenu = menu;
        disableButtons();
        return true;
    }

    public void onDestroy()
    {
        mOptionsMenu.getItem(0).getIcon().setAlpha(255);
        super.onDestroy();
    }

    public void onInvalidData()
    {
        disableButtons();
    }

    public void onValidData()
    {
        enableButtons();
    }

    protected void setMainButton(Button button)
    {
        mainButton = button;
    }

    protected void setTopButtonEnabled(boolean flag)
    {
        if (mOptionsMenu == null)
        {
            return;
        }
        mOptionsMenu.getItem(0).setEnabled(flag);
        Drawable drawable = mOptionsMenu.getItem(0).getIcon();
        char c;
        if (flag)
        {
            c = '\377';
        } else
        {
            c = '}';
        }
        drawable.setAlpha(c);
    }
}
