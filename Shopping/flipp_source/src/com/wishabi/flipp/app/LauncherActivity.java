// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.wishabi.flipp.app:
//            MainActivity

public class LauncherActivity extends Activity
{

    public LauncherActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        startActivity(new Intent(getApplicationContext(), com/wishabi/flipp/app/MainActivity));
        finish();
    }
}
