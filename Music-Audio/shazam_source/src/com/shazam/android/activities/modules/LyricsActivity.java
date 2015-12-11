// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.modules;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.Display;
import android.view.MenuItem;
import android.view.WindowManager;
import com.shazam.android.activities.a.a;
import com.shazam.android.base.activities.BaseAppCompatActivity;

public class LyricsActivity extends BaseAppCompatActivity
{

    public LyricsActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030026);
        bundle = (WindowManager)getSystemService("window");
        Configuration configuration = getResources().getConfiguration();
        int i = bundle.getDefaultDisplay().getRotation();
        if ((i == 0 || i == 2) && configuration.orientation == 2 || (i == 1 || i == 3) && configuration.orientation == 1)
        {
            setRequestedOrientation(0);
            return;
        } else
        {
            setRequestedOrientation(1);
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            onBackPressed();
            break;
        }
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        k k1 = getSupportFragmentManager();
        if (k1.a("lyrics_fragment") == null)
        {
            k1.a().b(0x7f1100c3, com.shazam.android.fragment.musicdetails.modules.a.a(a.a(getIntent())), "lyrics_fragment").a();
        }
    }
}
