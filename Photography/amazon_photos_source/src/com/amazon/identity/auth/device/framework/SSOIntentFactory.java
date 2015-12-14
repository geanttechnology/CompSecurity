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
        ComponentName acomponentname[] = new ComponentName[6];
        acomponentname[0] = new ComponentName("com.amazon.imp", s);
        acomponentname[1] = new ComponentName("com.amazon.sso", s);
        acomponentname[2] = new ComponentName("com.amazon.dcp", s);
        acomponentname[3] = new ComponentName("com.amazon.fv", s);
        acomponentname[4] = new ComponentName("com.amazon.canary", s);
        acomponentname[5] = new ComponentName(context, s);
        int j = acomponentname.length;
        for (int i = 0; i < j; i++)
        {
            context = acomponentname[i];
            if (componentfinder.componentExists(trustedpackagemanager, context))
            {
                return context;
            }
        }

        for (context = trustedpackagemanager.getTrustedInstalledPackages().iterator(); context.hasNext();)
        {
            ComponentName componentname = new ComponentName((String)context.next(), s);
            if (componentfinder.componentExists(trustedpackagemanager, componentname))
            {
                return componentname;
            }
        }

        return null;
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
