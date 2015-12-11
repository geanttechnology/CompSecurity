// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.ApiSettings;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity, eBay

public class PaisaPayWebViewActivity extends ShowWebViewActivity
{

    public static final String BASE_XO_URL = "https://m.ebay.in/mobinxo/ReviewOrder?srcApp=ANDR&_trksid=p2059707.m2931.l5787";
    public static final String BASE_XO_URL_FORMAT = "https://m.ebay.in/mobinxo/ReviewOrder?srcApp=ANDR&_trksid=p2059707.m2931.l5787quantity=%d&itemID=%d";
    public static final String ITEM_ID = "itemID";
    public static final String MSKU_FORMAT = "&var=%s";
    public static final String QUANTITY = "quantity";
    public static final String SRC_APP_ID = "srcAppID";
    public static final String VARIATION_ID = "var";

    public PaisaPayWebViewActivity()
    {
    }

    protected void onDone(boolean flag)
    {
        Intent intent = new Intent(this, com/ebay/mobile/activities/eBay);
        try
        {
            if ("success".equalsIgnoreCase(Uri.parse(url).getQueryParameter(COMPLETION_STATUS)))
            {
                intent.setFlags(0x4000000);
                startActivity(intent);
                finish();
                return;
            }
        }
        catch (Exception exception) { }
        super.onDone(flag);
    }

    protected void readIntent()
    {
        super.readIntent();
        useSso = true;
        Object obj = getIntent();
        int i = ((Intent) (obj)).getIntExtra("quantity", 1);
        long l = ((Intent) (obj)).getLongExtra("itemID", 0L);
        obj = ((Intent) (obj)).getStringExtra("var");
        android.net.Uri.Builder builder = Uri.parse(ApiSettings.get(EbaySettings.paisaPayMobileWebXoUrl)).buildUpon();
        builder.appendQueryParameter("itemID", Long.toString(l));
        builder.appendQueryParameter("quantity", Integer.toString(i));
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            builder.appendQueryParameter("var", ((String) (obj)));
        }
        builder.appendQueryParameter("srcAppID", "2571");
        url = builder.build().toString();
    }
}
