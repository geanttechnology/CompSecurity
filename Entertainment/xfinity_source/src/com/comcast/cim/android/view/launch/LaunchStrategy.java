// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            LaunchActivity

public abstract class LaunchStrategy
{

    public LaunchStrategy()
    {
    }

    public Bundle createExitBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("exit", true);
        return bundle;
    }

    public void exitApp(Activity activity)
    {
        Intent intent = new Intent(activity, com/comcast/cim/android/view/launch/LaunchActivity);
        intent.putExtras(createExitBundle());
        intent.addFlags(0x64000000);
        activity.startActivity(intent);
        activity.finish();
    }

    public abstract Class getDefaultActivityClass();

    public void restartAppFlow(Context context)
    {
        Intent intent = new Intent(context, com/comcast/cim/android/view/launch/LaunchActivity);
        intent.addFlags(0x24000000);
        context.startActivity(intent);
    }
}
