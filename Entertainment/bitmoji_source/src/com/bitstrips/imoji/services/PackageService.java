// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.bitstrips.imoji.InjectorApplication;

public class PackageService
{

    Context context;

    public PackageService(Context context1)
    {
        ((InjectorApplication)context1).inject(this);
    }

    public boolean isAppInstalled(String s)
    {
label0:
        {
            boolean flag = false;
            try
            {
                if (context == null)
                {
                    break label0;
                }
                context.getPackageManager().getApplicationInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            flag = true;
        }
        return flag;
    }

    public boolean launchApp(String s)
    {
label0:
        {
            boolean flag = false;
            try
            {
                if (context == null)
                {
                    break label0;
                }
                context.getPackageManager().getApplicationInfo(s, 0);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName(s, "com.bitstrips.imoji.ui.ImojiBrowserActivity"));
                intent.setFlags(0x10000000);
                context.startActivity(intent);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            flag = true;
        }
        return flag;
    }
}
