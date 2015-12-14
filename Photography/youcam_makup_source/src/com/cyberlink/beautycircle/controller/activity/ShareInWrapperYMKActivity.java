// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

public class ShareInWrapperYMKActivity extends Activity
{

    public ShareInWrapperYMKActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        if (bundle != null)
        {
            bundle.setClass(this, com/cyberlink/beautycircle/controller/activity/ShareInActivity);
            startActivity(bundle);
        }
        finish();
    }
}
