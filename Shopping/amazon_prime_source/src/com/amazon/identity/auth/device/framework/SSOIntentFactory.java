// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            TrustedPackageManager

public abstract class SSOIntentFactory
{
    protected static interface ComponentFinder
    {

        public abstract boolean componentExists(TrustedPackageManager trustedpackagemanager, ComponentName componentname);
    }


    public static final ComponentFinder SERVICE_FINDER = new ComponentFinder() {

        public boolean componentExists(TrustedPackageManager trustedpackagemanager, ComponentName componentname)
        {
            boolean flag = false;
            try
            {
                trustedpackagemanager = trustedpackagemanager.getServiceInfo$42997c6b(componentname);
            }
            // Misplaced declaration of an exception variable
            catch (TrustedPackageManager trustedpackagemanager)
            {
                return false;
            }
            if (trustedpackagemanager != null)
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

    public static ComponentName findSSOComponent(Context context, String s, ComponentFinder componentfinder)
    {
        TrustedPackageManager trustedpackagemanager = new TrustedPackageManager(context);
        ComponentName componentname = new ComponentName("com.amazon.imp", s);
        ComponentName componentname2 = new ComponentName("com.amazon.sso", s);
        ComponentName componentname3 = new ComponentName("com.amazon.dcp", s);
        ComponentName componentname4 = new ComponentName("com.amazon.fv", s);
        ComponentName componentname5 = new ComponentName("com.amazon.canary", s);
        context = new ComponentName(context, s);
        for (int i = 0; i < 6; i++)
        {
            ComponentName componentname6 = (new ComponentName[] {
                componentname, componentname2, componentname3, componentname4, componentname5, context
            })[i];
            if (componentfinder.componentExists(trustedpackagemanager, componentname6))
            {
                return componentname6;
            }
        }

        for (context = trustedpackagemanager.getTrustedInstalledPackages().iterator(); context.hasNext();)
        {
            ComponentName componentname1 = new ComponentName((String)context.next(), s);
            if (componentfinder.componentExists(trustedpackagemanager, componentname1))
            {
                return componentname1;
            }
        }

        return null;
    }

    public Intent buildIntent(String s)
    {
        Intent intent = new Intent();
        intent.setAction(s);
        if (mComponentName != null)
        {
            intent.setComponent(mComponentName);
        }
        return intent;
    }

}
