// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.amazon.mobile.mash.constants.WebConstants;

// Referenced classes of package com.amazon.mShop.web:
//            DebugHtmlSandboxSettingsActivity, MShopWebActivity

class val.content
    implements android.view.ivity._cls1
{

    final DebugHtmlSandboxSettingsActivity this$0;
    final View val$content;

    public void onClick(View view)
    {
        view = ((EditText)val$content.findViewById(com.amazon.mShop.android.lib.ent)).getText().toString();
        Intent intent = new Intent(DebugHtmlSandboxSettingsActivity.this, com/amazon/mShop/web/MShopWebActivity);
        intent.putExtra(WebConstants.getWebViewUrlKey(), view);
        startActivity(intent);
    }

    ()
    {
        this$0 = final_debughtmlsandboxsettingsactivity;
        val$content = View.this;
        super();
    }
}
