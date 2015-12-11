// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Intent;
import android.os.Bundle;
import com.arellomobile.android.push.BasePushMessageReceiver;

// Referenced classes of package com.bitstrips.imoji.ui:
//            LoginActivity

class essageReceiver extends BasePushMessageReceiver
{

    final LoginActivity this$0;

    protected void onMessageReceive(Intent intent)
    {
        LoginActivity.access$500(LoginActivity.this, (new StringBuilder()).append("push message is ").append(intent.getExtras().getString("pw_data_json_string")).toString());
    }

    essageReceiver()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
