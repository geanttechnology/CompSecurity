// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.barcodeSearch;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.StandardView;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;

public class BarcodeFirstTryTipActivity extends AmazonActivity
{

    public BarcodeFirstTryTipActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(com.amazon.mShop.android.lib.R.string.help_root_title);
    }

    protected void onStart()
    {
        super.onStart();
        setStopBehavior(1);
        StandardView standardview = new StandardView(this, Integer.valueOf(com.amazon.mShop.android.lib.R.string.bc_search_help_title));
        standardview.setContentView(com.amazon.mShop.android.lib.R.layout.barcode_search_first_try_help);
        ((Button)standardview.findViewById(com.amazon.mShop.android.lib.R.id.barcode_search_first_try_screen_try_it_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final BarcodeFirstTryTipActivity this$0;

            public void onClick(View view)
            {
                RefMarkerObserver.logRefMarker("scan_try_it_btn");
                com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("keyBarcodeSearchTryAccepted", true);
                setResult(90);
                finish();
            }

            
            {
                this$0 = BarcodeFirstTryTipActivity.this;
                super();
            }
        });
        pushView(standardview);
    }
}
