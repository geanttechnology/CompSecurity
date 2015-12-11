// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.barcodeSearch;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.control.barcodeSearch.BarcodeSearchController;

// Referenced classes of package com.amazon.mShop.barcodeSearch:
//            BarcodeSearchResultsAdapter

class this._cls1
    implements android.content.ltsAdapter._cls1._cls1
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1

/* anonymous class */
    class BarcodeSearchResultsAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final BarcodeSearchResultsAdapter this$0;

        public void onClick(View view)
        {
            BarcodeSearchResultsAdapter.access$000(BarcodeSearchResultsAdapter.this).reportMismatch();
            view = (new com.amazon.mShop.AmazonAlertDialog.Builder(BarcodeSearchResultsAdapter.access$100(BarcodeSearchResultsAdapter.this))).setMessage(BarcodeSearchResultsAdapter.access$100(BarcodeSearchResultsAdapter.this).getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_bad_match_acknowledgement));
            BarcodeSearchResultsAdapter._cls1._cls1 _lcls1 = new BarcodeSearchResultsAdapter._cls1._cls1();
            view.setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, _lcls1);
            view.create().show();
        }

            
            {
                this$0 = BarcodeSearchResultsAdapter.this;
                super();
            }
    }

}
