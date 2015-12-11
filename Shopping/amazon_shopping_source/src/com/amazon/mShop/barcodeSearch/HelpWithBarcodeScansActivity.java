// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.barcodeSearch;

import android.os.Bundle;
import android.view.Window;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.StandardView;

public class HelpWithBarcodeScansActivity extends AmazonActivity
{

    public HelpWithBarcodeScansActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(com.amazon.mShop.android.lib.R.string.help_using_amazon_remembers_help_with_barcode_scans_title);
        getWindow().setFlags(1024, 1024);
    }

    protected void onStart()
    {
        super.onStart();
        setStopBehavior(1);
        StandardView standardview = new StandardView(this, Integer.valueOf(com.amazon.mShop.android.lib.R.string.help_using_amazon_remembers_help_with_barcode_scans_title));
        standardview.setContentView(com.amazon.mShop.android.lib.R.layout.help_with_barcode_scans);
        pushView(standardview);
    }
}
