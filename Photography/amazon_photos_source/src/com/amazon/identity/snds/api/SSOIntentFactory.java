// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class SSOIntentFactory
{
    protected static interface ComponentFinder
    {

        public abstract boolean componentExists(PackageManager packagemanager, ComponentName componentname);
    }


    protected static final ComponentFinder BROADCAST_RECEIVER_FINDER = new ComponentFinder() {

        public boolean componentExists(PackageManager packagemanager, ComponentName componentname)
        {
            boolean flag = false;
            try
            {
                packagemanager = packagemanager.getReceiverInfo(componentname, 128);
            }
            // Misplaced declaration of an exception variable
            catch (PackageManager packagemanager)
            {
                return false;
            }
            if (packagemanager != null)
            {
                flag = true;
            }
            return flag;
        }

    };
    protected static final ComponentFinder SERVICE_FINDER = new ComponentFinder() {

        public boolean componentExists(PackageManager packagemanager, ComponentName componentname)
        {
            boolean flag = false;
            try
            {
                packagemanager = packagemanager.getServiceInfo(componentname, 128);
            }
            // Misplaced declaration of an exception variable
            catch (PackageManager packagemanager)
            {
                return false;
            }
            if (packagemanager != null)
            {
                flag = true;
            }
            return flag;
        }

    };
    protected final ComponentName mComponentName;

    public SSOIntentFactory(ComponentName componentname)
    {
        mComponentName = componentname;
    }

    protected static ComponentName findSSOComponent(Context context, String s, ComponentFinder componentfinder)
    {
        PackageManager packagemanager = context.getPackageManager();
        ComponentName acomponentname[] = new ComponentName[4];
        acomponentname[0] = new ComponentName("com.amazon.imp", s);
        acomponentname[1] = new ComponentName("com.amazon.sso", s);
        acomponentname[2] = new ComponentName("com.amazon.dcp", s);
        acomponentname[3] = new ComponentName(context, s);
        int j = acomponentname.length;
        for (int i = 0; i < j; i++)
        {
            ComponentName componentname1 = acomponentname[i];
            if (componentfinder.componentExists(packagemanager, componentname1))
            {
                return componentname1;
            }
        }

        for (context = getTrustedPackages(context).iterator(); context.hasNext();)
        {
            ComponentName componentname = new ComponentName(((PackageInfo)context.next()).packageName, s);
            if (componentfinder.componentExists(packagemanager, componentname))
            {
                return componentname;
            }
        }

        return null;
    }

    private static List getTrustedPackages(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        context = context.getPackageName();
        Object obj = packagemanager.getInstalledPackages(64);
        ArrayList arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            PackageInfo packageinfo = (PackageInfo)((Iterator) (obj)).next();
            if (packagemanager.checkSignatures(context, packageinfo.packageName) == 0)
            {
                arraylist.add(packageinfo);
            }
        } while (true);
        return arraylist;
    }

    public Intent buildIntent(String s)
    {
        Intent intent = new Intent();
        if (s != null)
        {
            intent.setAction(s);
        }
        if (mComponentName != null)
        {
            intent.setComponent(mComponentName);
        }
        return intent;
    }

}
