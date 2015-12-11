// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, SignInModalActivity

public class OrderSummaryInstructionsActivity extends BaseActivity
{

    private String message;
    private TextView textView;

    public OrderSummaryInstructionsActivity()
    {
    }

    private void resumeUi()
    {
        TextView textview = textView;
        String s;
        if (message != null)
        {
            s = message;
        } else
        {
            s = "";
        }
        textview.setText(s);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 65 65: default 28
    //                   65 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j != -1)
        {
            finish();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030193);
        textView = (TextView)findViewById(0x7f1004aa);
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn("OrderSummary", this), 65);
        }
        if (bundle != null)
        {
            message = bundle.getString("order_instructions");
            return;
        } else
        {
            message = getIntent().getStringExtra("order_instructions");
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    public void onResume()
    {
        super.onResume();
        resumeUi();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("order_instructions", message);
    }
}
