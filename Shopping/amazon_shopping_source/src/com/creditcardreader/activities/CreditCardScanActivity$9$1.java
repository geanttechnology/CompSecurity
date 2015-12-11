// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.TextView;
import com.creditcardreader.camera.CreditCardCameraPreview;
import com.creditcardreader.metrics.CreditCardMetricsRecorder;

// Referenced classes of package com.creditcardreader.activities:
//            CreditCardScanActivity

class this._cls1
    implements android.content.ener
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CreditCardScanActivity.access$1100(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/creditcardreader/activities/CreditCardScanActivity$9

/* anonymous class */
    class CreditCardScanActivity._cls9
        implements Runnable
    {

        final CreditCardScanActivity this$0;

        public void run()
        {
            CreditCardScanActivity.access$200(CreditCardScanActivity.this).resetOverlay();
            CreditCardScanActivity.access$200(CreditCardScanActivity.this).stopPreview();
            Object obj = new android.app.AlertDialog.Builder(CreditCardScanActivity.this);
            ((android.app.AlertDialog.Builder) (obj)).setMessage(getResources().getString(com.creditcardreader.R.string.cc_scan_trouble));
            ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(getResources().getString(com.creditcardreader.R.string.cc_scan_rescan), new CreditCardScanActivity._cls9._cls1());
            ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(getResources().getString(com.creditcardreader.R.string.cc_scan_manual), new CreditCardScanActivity._cls9._cls2());
            obj = ((android.app.AlertDialog.Builder) (obj)).create();
            ((AlertDialog) (obj)).setOnCancelListener(new CreditCardScanActivity._cls9._cls3());
            ((AlertDialog) (obj)).show();
            ((TextView)((AlertDialog) (obj)).findViewById(0x102000b)).setGravity(17);
        }

            
            {
                this$0 = CreditCardScanActivity.this;
                super();
            }

        // Unreferenced inner class com/creditcardreader/activities/CreditCardScanActivity$9$2

/* anonymous class */
        class CreditCardScanActivity._cls9._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final CreditCardScanActivity._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                CreditCardScanActivity.access$302(this$0, true);
                CreditCardScanActivity.access$402(this$0, false);
                CreditCardScanActivity.access$800(this$0).recordTimeoutCancel();
                CreditCardScanActivity.access$1200(this$0).post(new CreditCardScanActivity._cls9._cls2._cls1());
            }

                    
                    {
                        this$1 = CreditCardScanActivity._cls9.this;
                        super();
                    }
        }


        // Unreferenced inner class com/creditcardreader/activities/CreditCardScanActivity$9$2$1

/* anonymous class */
        class CreditCardScanActivity._cls9._cls2._cls1
            implements Runnable
        {

            final CreditCardScanActivity._cls9._cls2 this$2;

            public void run()
            {
                setResult(0, new Intent());
                finish();
            }

                    
                    {
                        this$2 = CreditCardScanActivity._cls9._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/creditcardreader/activities/CreditCardScanActivity$9$3

/* anonymous class */
        class CreditCardScanActivity._cls9._cls3
            implements android.content.DialogInterface.OnCancelListener
        {

            final CreditCardScanActivity._cls9 this$1;

            public void onCancel(DialogInterface dialoginterface)
            {
                CreditCardScanActivity.access$1100(this$0);
            }

                    
                    {
                        this$1 = CreditCardScanActivity._cls9.this;
                        super();
                    }
        }

    }

}
