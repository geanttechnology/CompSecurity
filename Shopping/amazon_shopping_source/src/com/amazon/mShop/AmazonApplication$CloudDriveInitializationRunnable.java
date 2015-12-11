// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.amazon.mShop.clouddrive.CloudDriveAvailability;
import com.amazon.mShop.clouddrive.CloudDriveManageStorageActivity;
import com.amazon.mShop.clouddrive.CloudDriveUploadActivity;
import com.amazon.mShop.model.auth.User;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.mShop:
//            AmazonApplication

private static class <init>
    implements Runnable
{

    private final Context mContext;

    public void run()
    {
        boolean flag = false;
        Class class1 = Class.forName("com.amazon.clouddrive.library.CloudDriveLibrary", true, SecondDexEntry.getInstance().getClassLoader());
        Object obj = class1.getDeclaredMethod("getInstance", (Class[])null).invoke(null, (Object[])null);
        class1.getDeclaredMethod("initialize", new Class[] {
            android/content/Context, java/lang/Class, java/lang/Class
        }).invoke(obj, new Object[] {
            mContext, com/amazon/mShop/clouddrive/CloudDriveUploadActivity, com/amazon/mShop/clouddrive/CloudDriveManageStorageActivity
        });
        User.addUserListener(AmazonApplication.access$200());
        flag = true;
_L2:
        CloudDriveAvailability.getInstance().setCloudDriveInitialized(flag);
        return;
        Exception exception;
        exception;
        Log.e("AmazonApplication", "Cloud Drive Photos initialization failed.", exception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private I(Context context)
    {
        mContext = context;
    }

    mContext(Context context, mContext mcontext)
    {
        this(context);
    }
}
