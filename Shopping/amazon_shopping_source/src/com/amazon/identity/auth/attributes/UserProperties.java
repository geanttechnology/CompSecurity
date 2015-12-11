// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.accounts.MultipleAccountPlugin;
import com.amazon.identity.auth.accounts.MultipleAccountPluginHolder;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.SSOBroadcastIntentFactory;
import java.util.Iterator;
import java.util.Set;

public final class UserProperties
{

    private static final String TAG = com/amazon/identity/auth/attributes/UserProperties.getName();

    private UserProperties()
    {
    }

    public static void forceSendPropertyChangedBroadcast(Context context, String s, Bundle bundle)
    {
        Object obj = TAG;
        obj = SSOBroadcastIntentFactory.createIntent("com.amazon.dcp.sso.action.AmazonAccountPropertyService.property.changed");
        String s1;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); ((Intent) (obj)).putExtra(s1, bundle.getString(s1)))
        {
            s1 = (String)iterator.next();
            String s2 = TAG;
            String.format("Key = %s, Value = %s", new Object[] {
                s1, bundle.getString(s1)
            });
        }

        bundle = BackwardsCompatiabilityHelper.getAccountWithDirectedId(context, s);
        if (bundle != null)
        {
            ((Intent) (obj)).putExtra("account.property.changed", bundle);
        }
        ((Intent) (obj)).putExtra("new.account.property.changed", s);
        MultipleAccountPluginHolder.getMultipleAccountPlugin(context).notifyToolbarOfUserChanged(s, ((Intent) (obj)), "com.amazon.dcp.sso.permission.AmazonAccountPropertyService.property.changed");
        context = TAG;
    }

    public static String getVisibleToolbarUser(Context context)
    {
        return MultipleAccountPluginHolder.getMultipleAccountPlugin(context).getVisibleUser();
    }

    public static Bundle sendDeviceEmailChangedNotification(Context context, String s, String s1)
    {
        Object obj;
        if (!TextUtils.isEmpty(s1))
        {
            obj = TAG;
        }
        obj = TAG;
        obj = new Bundle();
        ((Bundle) (obj)).putString("com.amazon.dcp.sso.property.deviceemail", s1);
        sendPropertyChangedBroadcast(context, s, ((Bundle) (obj)));
        return ((Bundle) (obj));
    }

    public static Bundle sendDeviceNameChangedNotification(Context context, String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("com.amazon.dcp.sso.property.devicename", s1);
        sendPropertyChangedBroadcast(context, s, bundle);
        return bundle;
    }

    public static void sendPropertyChangedBroadcast(Context context, String s, Bundle bundle)
    {
        String s1 = TAG;
        if (s != null && !s.equals(getVisibleToolbarUser(context)))
        {
            MAPLog.i(TAG, "Not notifying that the given accounts property has changed because it is not currently visibile");
            return;
        } else
        {
            forceSendPropertyChangedBroadcast(context, s, bundle);
            return;
        }
    }

    public static Bundle storeDeviceName(Context context, String s, String s1)
    {
        (new AmazonAccountManager(context)).setUserData(s, "com.amazon.dcp.sso.property.devicename", s1);
        return sendDeviceNameChangedNotification(context, s, s1);
    }

}
