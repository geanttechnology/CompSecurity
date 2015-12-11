// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Intent;
import android.os.Bundle;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.barcodeSearch.BarcodeFirstTryTipActivity;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItTutorialActivity

public class ViewItScanEntryActivity extends AmazonActivity
{

    public ViewItScanEntryActivity()
    {
    }

    private void checkToStart(Intent intent)
    {
        if (intent != null && intent.getBooleanExtra("MODULE_TYPE_IS_IMAGE_SEARCH", false))
        {
            if (shouldShowFlowTutorialScreen())
            {
                startFlowTutorialActivity(this);
                return;
            } else
            {
                startFlow(this, intent.getStringExtra("clickStreamOrigin"));
                return;
            }
        }
        if (shouldShowBarcodeScanFirstTryTipScreen())
        {
            startBarcodeScanFirstTryTipScreenActivity(this);
            return;
        } else
        {
            startBarcodeScan(this);
            return;
        }
    }

    private boolean shouldShowBarcodeScanFirstTryTipScreen()
    {
        return !com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("keyBarcodeSearchTryAccepted");
    }

    private boolean shouldShowFlowTutorialScreen()
    {
        return !com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("keyTutorialScreenDisplayed");
    }

    private void startBarcodeScan(AmazonActivity amazonactivity)
    {
        Intent intent = new Intent(amazonactivity, com/amazon/mShop/search/viewit/ViewItActivity);
        intent.addFlags(0x20000);
        intent.putExtra("MODULE_TYPE_IS_IMAGE_SEARCH", false);
        amazonactivity.startActivityForResult(intent, 4);
    }

    private void startBarcodeScanFirstTryTipScreenActivity(AmazonActivity amazonactivity)
    {
        Intent intent = new Intent(amazonactivity, com/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity);
        intent.addFlags(0x20000);
        amazonactivity.startActivityForResult(intent, 5);
    }

    private void startFlow(AmazonActivity amazonactivity, String s)
    {
        Intent intent = new Intent(amazonactivity, com/amazon/mShop/search/viewit/ViewItActivity);
        intent.addFlags(0x20000);
        intent.putExtra("MODULE_TYPE_IS_IMAGE_SEARCH", true);
        intent.putExtra("clickStreamOrigin", s);
        amazonactivity.startActivityForResult(intent, 18);
    }

    private void startFlowTutorialActivity(AmazonActivity amazonactivity)
    {
        Intent intent = new Intent(amazonactivity, com/amazon/mShop/search/viewit/ViewItTutorialActivity);
        intent.addFlags(0x20000);
        amazonactivity.startActivityForResult(intent, 19);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 5 && j == 90)
        {
            startBarcodeScan(this);
            return;
        }
        if (i == 19 && j == -1)
        {
            startFlow(this, getIntent().getStringExtra("clickStreamOrigin"));
            return;
        } else
        {
            setResult(j, intent);
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        checkToStart(getIntent());
    }

    protected void onNewIntent(Intent intent)
    {
        setIntent(intent);
        checkToStart(intent);
    }
}
