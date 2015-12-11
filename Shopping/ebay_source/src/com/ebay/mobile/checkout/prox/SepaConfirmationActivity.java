// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.mobile.activities.ModalActivity;
import com.ebay.mobile.activities.ShowWebViewActivity;

public class SepaConfirmationActivity extends ModalActivity
    implements android.view.View.OnClickListener
{

    private static final int ACTIVITY_RESULT_SEPA_WEB_VIEW = 0xe66c3;
    public static final String EXTRA_LEGAL_BUTTON_LABEL = "sepaButtonText";
    public static final String EXTRA_LEGAL_BUTTON_LINK = "sepaButtonLink";
    public static final String EXTRA_LEGAL_TEXT = "sepaText";

    public SepaConfirmationActivity()
    {
    }

    public void onBackPressed()
    {
        setResult(0);
        super.onBackPressed();
    }

    public void onClick(View view)
    {
        if (view == null)
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131755456: 
            setResult(-1);
            finish();
            return;

        case 2131756326: 
            view = new Intent(this, com/ebay/mobile/activities/ShowWebViewActivity);
            break;
        }
        view.putExtra("url", getIntent().getStringExtra("sepaButtonLink"));
        view.putExtra("android.intent.extra.TITLE", getTitle());
        view.putExtra("use_sso", false);
        view.putExtra("back", true);
        startActivityForResult(view, 0xe66c3);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301b3);
        hideCloseButton();
        showBackButton();
        setBackButtonOnClickListener(new android.view.View.OnClickListener() {

            final SepaConfirmationActivity this$0;

            public void onClick(View view)
            {
                onBackPressed();
            }

            
            {
                this$0 = SepaConfirmationActivity.this;
                super();
            }
        });
        bundle = getIntent();
        Object obj = (TextView)findViewById(0x7f100525);
        if (obj != null)
        {
            ((TextView) (obj)).setText(bundle.getStringExtra("sepaText"));
        }
        obj = (Button)findViewById(0x7f1001c0);
        if (obj != null)
        {
            ((Button) (obj)).setOnClickListener(this);
        }
        obj = (Button)findViewById(0x7f100526);
        if (obj != null)
        {
            ((Button) (obj)).setText(bundle.getStringExtra("sepaButtonText"));
            ((Button) (obj)).setOnClickListener(this);
        }
    }
}
