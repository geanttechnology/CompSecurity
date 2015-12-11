// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.util:
//            GrouponDialogFragment

public class GrouponRatingPrompter
{

    public static final String PREFERENCES_ALREADY_RATED_KEY = "GRP.alreadyRated";
    public static final String PREFERENCES_NAME_KEY = "GRP.ratingsDictionary";
    private final Activity mActivity;
    private final String mAppName;

    public GrouponRatingPrompter(Activity activity)
    {
        Object obj;
        String s;
        mActivity = activity;
        obj = mActivity.getPackageManager();
        s = mActivity.getPackageName();
        activity = null;
        obj = ((PackageManager) (obj)).getApplicationInfo(s, 0).loadLabel(((PackageManager) (obj))).toString();
        activity = ((Activity) (obj));
_L2:
        mAppName = activity;
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Ln.e(namenotfoundexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected boolean connectedToNetwork()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)mActivity.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isAvailable() && networkinfo.isConnected();
    }

    public void maybeShowPrompt()
    {
        if (!shouldPrompt())
        {
            return;
        } else
        {
            GrouponDialogFragment groupondialogfragment = new GrouponDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("dialog_title_res_id", 0x7f080147);
            bundle.putInt("dialog_message_res_id", 0x7f0802de);
            bundle.putString("dialog_positive_button_text", mActivity.getString(0x7f080301, new Object[] {
                mAppName
            }));
            bundle.putInt("dialog_negative_button_text_res_id", 0x7f080313);
            groupondialogfragment.setArguments(bundle);
            GrouponDialogFragment.show(mActivity.getFragmentManager(), groupondialogfragment, "rating_dialog");
            return;
        }
    }

    public boolean shouldPrompt()
    {
        while (mAppName == null || !connectedToNetwork() || mActivity.getSharedPreferences("GRP.ratingsDictionary", 0).getBoolean("GRP.alreadyRated", false)) 
        {
            return false;
        }
        return true;
    }
}
