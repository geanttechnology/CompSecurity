// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.app.Activity;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class AboutMenu
{

    private static final String TAG = com/amazon/gallery/framework/kindle/ui/AboutMenu.getName();

    public AboutMenu()
    {
    }

    public static void launchSettingsPage(Activity activity, Class class1)
    {
        GLogger.i(TAG, "Settings requested, starting Settings app", new Object[0]);
        try
        {
            class1 = new Intent(activity, class1);
            class1.putExtra("com.amazon.photos.FROM_PHOTOS", true);
            activity.startActivity(class1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            GLogger.ex(TAG, "Cannot settings App", activity);
        }
    }

}
