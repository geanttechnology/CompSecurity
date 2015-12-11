// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager

public class PushHandlerActivity extends Activity
{

    public PushHandlerActivity()
    {
    }

    private void handlePush()
    {
        PushManager.onHandlePush(this);
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        handlePush();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        handlePush();
    }
}
