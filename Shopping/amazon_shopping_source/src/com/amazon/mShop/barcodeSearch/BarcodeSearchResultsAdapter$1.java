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

class this._cls0
    implements android.view.hResultsAdapter._cls1
{

    final BarcodeSearchResultsAdapter this$0;

    public void onClick(View view)
    {
        BarcodeSearchResultsAdapter.access$000(BarcodeSearchResultsAdapter.this).reportMismatch();
        view = (new com.amazon.mShop.t>(BarcodeSearchResultsAdapter.access$100(BarcodeSearchResultsAdapter.this))).essage(BarcodeSearchResultsAdapter.access$100(BarcodeSearchResultsAdapter.this).getResources().getString(com.amazon.mShop.android.lib.cknowledgement));
        android.content.r r = new android.content.DialogInterface.OnClickListener() {

            final BarcodeSearchResultsAdapter._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = BarcodeSearchResultsAdapter._cls1.this;
                super();
            }
        };
        view.ositiveButton(com.amazon.mShop.android.lib.n, r);
        view.te().show();
    }

    _cls1.this._cls1()
    {
        this$0 = BarcodeSearchResultsAdapter.this;
        super();
    }
}
