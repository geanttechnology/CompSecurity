// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Vibrator;

// Referenced classes of package com.groupon.activity:
//            AboutGroupon, IntentFactory

class this._cls0
    implements Runnable
{

    final AboutGroupon this$0;

    public void run()
    {
        ((Vibrator)getSystemService("vibrator")).vibrate(100L);
        startActivity(AboutGroupon.access$000(AboutGroupon.this).newSecretAdminSettingsWithOktaAuthenticationIntent());
    }

    ()
    {
        this$0 = AboutGroupon.this;
        super();
    }
}
