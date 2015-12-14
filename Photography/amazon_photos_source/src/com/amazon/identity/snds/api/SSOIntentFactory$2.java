// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.content.ComponentName;
import android.content.pm.PackageManager;

// Referenced classes of package com.amazon.identity.snds.api:
//            SSOIntentFactory

static final class ception
    implements mponentFinder
{

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

    ception()
    {
    }
}
