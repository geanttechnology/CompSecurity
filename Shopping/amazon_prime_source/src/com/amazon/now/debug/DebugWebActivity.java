// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.amazon.now.util.AppUtils;
import com.amazon.now.web.NowWebFragment;
import com.amazon.now.web.WebActivity;

public class DebugWebActivity extends WebActivity
{

    public DebugWebActivity()
    {
    }

    private void attachClearHandler()
    {
        ((Button)findViewById(0x7f0e0036)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugWebActivity this$0;

            public void onClick(View view)
            {
                ((EditText)findViewById(0x7f0e0034)).setText("");
            }

            
            {
                this$0 = DebugWebActivity.this;
                super();
            }
        });
    }

    private void attachGoHandler()
    {
        ((Button)findViewById(0x7f0e0035)).setOnClickListener(new android.view.View.OnClickListener() {

            final DebugWebActivity this$0;

            public void onClick(View view)
            {
                view = (EditText)findViewById(0x7f0e0034);
                String s = view.getText().toString();
                if (s != null)
                {
                    DebugWebActivity.this.Object.loadUrl(s);
                }
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            
            {
                this$0 = DebugWebActivity.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        findViewById(0x7f0e0033).setVisibility(0);
        ((EditText)findViewById(0x7f0e0034)).setText(AppUtils.getServiceUrl(this));
        attachGoHandler();
        attachClearHandler();
    }

}
