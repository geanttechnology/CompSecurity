// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.applovin.adview:
//            a

public class AppLovinConfirmationActivity extends Activity
{

    public AppLovinConfirmationActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new android.app.AlertDialog.Builder(this);
        Intent intent = getIntent();
        bundle.setTitle(intent.getStringExtra("dialog_title"));
        bundle.setMessage(intent.getStringExtra("dialog_body"));
        bundle.setCancelable(false);
        bundle.setPositiveButton(intent.getStringExtra("dialog_button_text"), new a(this));
        bundle.show();
    }
}
