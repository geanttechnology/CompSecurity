// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mobile.mash.constants.WebConstants;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebActivity

public class DebugHtmlSandboxSettingsActivity extends AmazonActivity
{

    public DebugHtmlSandboxSettingsActivity()
    {
    }

    protected void onCreate(final Bundle content)
    {
        super.onCreate(content);
        content = LayoutInflater.from(this).inflate(com.amazon.mShop.android.lib.R.layout.html_sandbox_debug_settings, null);
        ((Button)content.findViewById(com.amazon.mShop.android.lib.R.id.html_go_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugHtmlSandboxSettingsActivity this$0;
            final View val$content;

            public void onClick(View view)
            {
                view = ((EditText)content.findViewById(com.amazon.mShop.android.lib.R.id.html_sandbox_url)).getText().toString();
                Intent intent = new Intent(DebugHtmlSandboxSettingsActivity.this, com/amazon/mShop/web/MShopWebActivity);
                intent.putExtra(WebConstants.getWebViewUrlKey(), view);
                startActivity(intent);
            }

            
            {
                this$0 = DebugHtmlSandboxSettingsActivity.this;
                content = view;
                super();
            }
        });
        pushView(content);
    }
}
