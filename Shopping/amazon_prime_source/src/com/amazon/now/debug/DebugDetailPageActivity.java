// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.location.Location;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.DataStore;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;

public class DebugDetailPageActivity extends AmazonActivity
{

    public static final String DETAIL_PAGE_SERVICE_URL_KEY = "detail_page_service_url_key";

    public DebugDetailPageActivity()
    {
    }

    private String getDetailPageServiceUrl()
    {
        Object obj = DataStore.getString("detail_page_service_url_key");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return ((String) (obj));
        }
        obj = SearchConfiguration.getConfiguration().getRealmByObfuscatedMarketplaceId(Location.getMarketplace());
        if (obj != null)
        {
            obj = ((SearchRealm) (obj)).getSecureSiteUrl();
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                Uri uri = Uri.parse(((String) (obj)));
                if (uri.getHost() != null && uri.getScheme() != null)
                {
                    return ((String) (obj));
                }
            }
        }
        return AppUtils.getServiceUrl(this);
    }

    private void setupServiceUrlButton(View view)
    {
        final EditText serviceUrlText = (EditText)view.findViewById(0x7f0e0043);
        serviceUrlText.setText(getDetailPageServiceUrl());
        ((Button)view.findViewById(0x7f0e0044)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugDetailPageActivity this$0;
            final EditText val$serviceUrlText;

            public void onClick(View view1)
            {
                UIUtils.closeSoftKeyboard(view1);
                DataStore.removeKey("detail_page_service_url_key");
                serviceUrlText.setText(getDetailPageServiceUrl());
                Toast.makeText(DebugDetailPageActivity.this, "Detail Page Endpoint Reset!", 0).show();
            }

            
            {
                this$0 = DebugDetailPageActivity.this;
                serviceUrlText = edittext;
                super();
            }
        });
        ((Button)view.findViewById(0x7f0e0045)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugDetailPageActivity this$0;
            final EditText val$serviceUrlText;

            public void onClick(View view1)
            {
                UIUtils.closeSoftKeyboard(view1);
                DataStore.putString("detail_page_service_url_key", serviceUrlText.getText().toString());
                Toast.makeText(DebugDetailPageActivity.this, "Detail Page Endpoint Saved!", 0).show();
                finish();
            }

            
            {
                this$0 = DebugDetailPageActivity.this;
                serviceUrlText = edittext;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!AppUtils.isAppDebuggable(this))
        {
            finish();
        }
        bundle = LayoutInflater.from(this).inflate(0x7f030008, null);
        setRootView(bundle, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
        setupServiceUrlButton(bundle);
    }

}
