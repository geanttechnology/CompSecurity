// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store.location;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.h;

// Referenced classes of package com.target.ui.fragment.store.location:
//            InStoreLocationOptInDialogFragment

public class a
{

    private static final String DIALOG_PREFERENCES_NAME = "dialog_preferences_name";

    private static SharedPreferences a(Context context)
    {
        return context.getSharedPreferences("dialog_preferences_name", 0);
    }

    public static boolean a(Context context, h h1)
    {
        context = a(context);
        if (context.getBoolean("has_seen_in_store_location_dialog", false))
        {
            return false;
        }
        context.edit().putBoolean("has_seen_in_store_location_dialog", true).apply();
        if (h1.a("InStoreLocationOptInDialogFragment") != null)
        {
            return true;
        } else
        {
            InStoreLocationOptInDialogFragment.a().show(h1, "InStoreLocationOptInDialogFragment");
            return true;
        }
    }
}
