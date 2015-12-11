// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.widget.ImageView;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedback, UserFeedbackSpec, UserFeedbackActivity

class val.thisActivity extends AsyncTask
{

    ImageView mAppIcon;
    int mAppIconRes;
    final UserFeedbackActivity this$0;
    final Activity val$thisActivity;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        mAppIcon = (ImageView)val$thisActivity.findViewById(val.thisActivity);
        Object obj = UserFeedback.userFeedback().getSpec().getContext();
        avoid = ((Context) (obj)).getPackageName();
        obj = ((Context) (obj)).getPackageManager();
        mAppIconRes = mAppIconRes;
        try
        {
            mAppIconRes = ((PackageManager) (obj)).getApplicationInfo(avoid, 0).icon;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        mAppIcon.setImageResource(mAppIconRes);
    }

    ()
    {
        this$0 = final_userfeedbackactivity;
        val$thisActivity = Activity.this;
        super();
    }
}
