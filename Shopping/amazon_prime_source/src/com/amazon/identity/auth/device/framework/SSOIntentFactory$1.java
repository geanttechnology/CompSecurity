// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ComponentName;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            SSOIntentFactory, TrustedPackageManager

static final class er
    implements mponentFinder
{

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

    er()
    {
    }
}
