// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.LogViewer;
import com.groupon.debug.DebugQualityTools;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.inject.Lazy;

public class SecretAdminSettingsMenuHelper
{

    private String VERSION_NAME;
    private Context context;
    private Lazy intentFactory;
    private Lazy logger;
    private SharedPreferences prefs;

    public SecretAdminSettingsMenuHelper()
    {
    }

    private boolean handleMenuWithId(Activity activity, int i)
    {
        i;
        JVM INSTR tableswitch 2131755020 2131755024: default 36
    //                   2131755020 38
    //                   2131755021 106
    //                   2131755022 36
    //                   2131755023 36
    //                   2131755024 91;
           goto _L1 _L2 _L3 _L1 _L1 _L4
_L1:
        return false;
_L2:
        String s = String.format("%s.hprof", new Object[] {
            VERSION_NAME
        });
        DebugQualityTools.dumpHprof(s);
        Toast.makeText(activity.getApplicationContext(), (new StringBuilder()).append("Dumped hprof to ").append(s).toString(), 1).show();
        return false;
_L4:
        ((Logger)logger.get()).forceLogRotate();
        return false;
_L3:
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            WebView.setWebContentsDebuggingEnabled(true);
            return false;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void init()
    {
        intentFactory = new Lazy(context) {

            final SecretAdminSettingsMenuHelper this$0;

            
            {
                this$0 = SecretAdminSettingsMenuHelper.this;
                super(context1);
            }
        };
        logger = new Lazy(context) {

            final SecretAdminSettingsMenuHelper this$0;

            
            {
                this$0 = SecretAdminSettingsMenuHelper.this;
                super(context1);
            }
        };
    }

    public void createMenu(Menu menu, Context context1)
    {
        menu.add(0, 0x7f100008, 0, "Admin");
        menu.add(0, 0x7f10000c, 0, "Dump hprof");
        menu.add(0, 0x7f100022, 0, "View Logcat").setIntent(new Intent(context1, com/groupon/activity/LogViewer));
        menu.add(0, 0x7f100010, 0, "Force NST Upload");
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            menu.add(0, 0x7f10000d, 0, "Enable Debuggable WebViews");
        }
    }

    public boolean handleMenuItem(Activity activity, MenuItem menuitem)
    {
        return handleMenuWithId(activity, menuitem.getItemId());
    }

    public void prepareMenu(Menu menu, Context context1)
    {
        boolean flag = prefs.getBoolean("adminMenuEnabled", false);
        context1 = menu.findItem(0x7f100008);
        if (context1 != null)
        {
            context1.setVisible(flag);
            if (flag)
            {
                context1.setIntent(((IntentFactory)intentFactory.get()).newSecretAdminSettingsIntent());
            }
        }
        context1 = menu.findItem(0x7f10000c);
        if (context1 != null)
        {
            context1.setVisible(flag);
        }
        context1 = menu.findItem(0x7f100010);
        if (context1 != null)
        {
            context1.setVisible(flag);
        }
        context1 = menu.findItem(0x7f100022);
        if (context1 != null)
        {
            context1.setVisible(flag);
        }
        context1 = menu.findItem(0x7f10000d);
        if (context1 != null)
        {
            context1.setVisible(flag);
        }
        menu = menu.findItem(0x7f10001b);
        if (menu != null)
        {
            menu.setVisible(true);
        }
    }
}
