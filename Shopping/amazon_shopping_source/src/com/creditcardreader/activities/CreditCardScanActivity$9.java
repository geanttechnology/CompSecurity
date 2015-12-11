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

class this._cls0
    implements Runnable
{

    final CreditCardScanActivity this$0;

    public void run()
    {
        CreditCardScanActivity.access$200(CreditCardScanActivity.this).resetOverlay();
        CreditCardScanActivity.access$200(CreditCardScanActivity.this).stopPreview();
        Object obj = new android.app.>(CreditCardScanActivity.this);
        ((android.app.tCardScanActivity) (obj)).ssage(getResources().getString(com.creditcardreader.Activity.getResources));
        ((android.app.urces) (obj)).sitiveButton(getResources().getString(com.creditcardreader.Activity.getResources), new android.content.DialogInterface.OnClickListener() {

            final CreditCardScanActivity._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                CreditCardScanActivity.access$1100(this$0);
            }

            
            {
                this$1 = CreditCardScanActivity._cls9.this;
                super();
            }
        });
        ((android.app.tCardScanActivity._cls9) (obj)).gativeButton(getResources().getString(com.creditcardreader.Activity.getResources), new android.content.DialogInterface.OnClickListener() {

            final CreditCardScanActivity._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                CreditCardScanActivity.access$302(this$0, true);
                CreditCardScanActivity.access$402(this$0, false);
                CreditCardScanActivity.access$800(this$0).recordTimeoutCancel();
                CreditCardScanActivity.access$1200(this$0).post(new Runnable() {

                    final _cls2 this$2;

                    public void run()
                    {
                        setResult(0, new Intent());
                        finish();
                    }

            
            {
                this$2 = _cls2.this;
                super();
            }
                });
            }

            
            {
                this$1 = CreditCardScanActivity._cls9.this;
                super();
            }
        });
        obj = ((android.app.tCardScanActivity._cls9) (obj)).e();
        ((AlertDialog) (obj)).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final CreditCardScanActivity._cls9 this$1;

            public void onCancel(DialogInterface dialoginterface)
            {
                CreditCardScanActivity.access$1100(this$0);
            }

            
            {
                this$1 = CreditCardScanActivity._cls9.this;
                super();
            }
        });
        ((AlertDialog) (obj)).show();
        ((TextView)((AlertDialog) (obj)).findViewById(0x102000b)).setGravity(17);
    }

    _cls3.this._cls1()
    {
        this$0 = CreditCardScanActivity.this;
        super();
    }
}
