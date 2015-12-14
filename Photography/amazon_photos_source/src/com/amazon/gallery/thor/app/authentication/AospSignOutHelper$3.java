// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.app.Activity;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MultipleAccountManager;

// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            AospSignOutHelper

class val.activity extends Thread
{

    final AospSignOutHelper this$0;
    final Activity val$activity;

    public void run()
    {
        MAPAccountManager mapaccountmanager = new MAPAccountManager(val$activity);
        MultipleAccountManager multipleaccountmanager = new MultipleAccountManager(val$activity);
        String s = mapaccountmanager.getAccount();
        if (multipleaccountmanager.doesAccountHaveMapping(s, com.amazon.identity.auth.device.api.er.PackageMappingType.createCurrentPackageMapping(val$activity.getApplicationContext())))
        {
            multipleaccountmanager.removeAccountMappings(s, new com.amazon.identity.auth.device.api.er.AccountMappingType[] {
                com.amazon.identity.auth.device.api.er.PackageMappingType.createCurrentPackageMapping(val$activity.getApplicationContext())
            });
        }
        mapaccountmanager.deregisterAccount(s, new gnOutCallback(AospSignOutHelper.this, null));
    }

    gnOutCallback()
    {
        this$0 = final_aospsignouthelper;
        val$activity = Activity.this;
        super();
    }
}
