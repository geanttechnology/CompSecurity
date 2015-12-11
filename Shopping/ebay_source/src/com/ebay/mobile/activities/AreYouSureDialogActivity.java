// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class AreYouSureDialogActivity extends Activity
    implements android.view.View.OnClickListener
{
    public static final class DEFAULT_BUTTONS extends Enum
    {

        private static final DEFAULT_BUTTONS $VALUES[];
        public static final DEFAULT_BUTTONS OK;
        public static final DEFAULT_BUTTONS OK_CANCEL;
        public static final DEFAULT_BUTTONS YES_NO;

        public static DEFAULT_BUTTONS valueOf(String s)
        {
            return (DEFAULT_BUTTONS)Enum.valueOf(com/ebay/mobile/activities/AreYouSureDialogActivity$DEFAULT_BUTTONS, s);
        }

        public static DEFAULT_BUTTONS[] values()
        {
            return (DEFAULT_BUTTONS[])$VALUES.clone();
        }

        static 
        {
            OK = new DEFAULT_BUTTONS("OK", 0);
            OK_CANCEL = new DEFAULT_BUTTONS("OK_CANCEL", 1);
            YES_NO = new DEFAULT_BUTTONS("YES_NO", 2);
            $VALUES = (new DEFAULT_BUTTONS[] {
                OK, OK_CANCEL, YES_NO
            });
        }

        private DEFAULT_BUTTONS(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String EXTRA_DEFAULT_BUTTONS = "default_buttons";
    private static final String EXTRA_DEFAULT_OK = "ok_is_default";
    private static final String EXTRA_MESSAGE = "message";
    private static final String EXTRA_REQUEST_CODE = "param_request_code";
    private static final String EXTRA_TITLE = "param_title";

    public AreYouSureDialogActivity()
    {
    }

    public static void StartActivity(Activity activity, String s, String s1, int i, boolean flag, DEFAULT_BUTTONS default_buttons)
    {
        StartActivity(activity, s, s1, i, flag, default_buttons, null);
    }

    public static void StartActivity(Activity activity, String s, String s1, int i, boolean flag, DEFAULT_BUTTONS default_buttons, Bundle bundle)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/activities/AreYouSureDialogActivity);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        if (!TextUtils.isEmpty(s))
        {
            intent.putExtra("param_title", s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            intent.putExtra("message", s1);
        }
        if (i != -1)
        {
            intent.putExtra("param_request_code", i);
        }
        if (flag)
        {
            intent.putExtra("ok_is_default", flag);
        }
        intent.putExtra("default_buttons", default_buttons.toString());
        activity.startActivityForResult(intent, i);
    }

    public void onClick(View view)
    {
        Intent intent = getIntent();
        int i = intent.getIntExtra("param_request_code", -1);
        switch (view.getId())
        {
        default:
            return;

        case 2131755198: 
            setResult(-1, new Intent(intent));
            finishActivity(i);
            finish();
            return;

        case 2131755197: 
            setResult(0);
            finishActivity(i);
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        Object obj = bundle.getStringExtra("param_title");
        TextView textview;
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            setTitle(((CharSequence) (obj)));
        } else
        {
            requestWindowFeature(1);
        }
        getWindow().setFlags(2, 2);
        setContentView(0x7f030021);
        findViewById(0x7f1000be).setOnClickListener(this);
        findViewById(0x7f1000bd).setOnClickListener(this);
        obj = bundle.getStringExtra("message");
        textview = (TextView)findViewById(0x7f1000bc);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            textview.setText(((CharSequence) (obj)));
        } else
        {
            textview.setVisibility(8);
        }
        obj = DEFAULT_BUTTONS.valueOf(bundle.getStringExtra("default_buttons"));
        if (DEFAULT_BUTTONS.OK == obj)
        {
            ((Button)findViewById(0x7f1000be)).setText(getString(0x7f070738));
            findViewById(0x7f1000bd).setVisibility(8);
        } else
        if (DEFAULT_BUTTONS.OK_CANCEL == obj)
        {
            ((Button)findViewById(0x7f1000be)).setText(getString(0x7f070738));
            ((Button)findViewById(0x7f1000bd)).setText(getString(0x7f0701cc));
        }
        if (bundle.getBooleanExtra("ok_is_default", false))
        {
            setResult(-1, new Intent(bundle));
            return;
        } else
        {
            setResult(0);
            return;
        }
    }
}
