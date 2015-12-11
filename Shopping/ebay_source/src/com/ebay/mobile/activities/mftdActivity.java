// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity

public class mftdActivity extends BaseActivity
{

    Button mftdButton;

    public mftdActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Object obj1 = getIntent().getExtras();
        bundle = new String();
        Object obj = new String();
        String s = new String();
        if (obj1 != null)
        {
            bundle = ((Bundle) (obj1)).getString("android.intent.extra.TEXT");
            obj = ((Bundle) (obj1)).getString("android.intent.extra.TITLE");
            s = ((Bundle) (obj1)).getString("format");
        }
        setContentView(0x7f030163);
        setTitle(((CharSequence) (obj)));
        obj = (TextView)findViewById(0x7f10039c);
        obj1 = (WebView)findViewById(0x7f10039d);
        s = s.toLowerCase(Locale.US);
        if (s.contains("html"))
        {
            ((TextView) (obj)).setVisibility(8);
            ((WebView) (obj1)).setVisibility(0);
            ((WebView) (obj1)).loadDataWithBaseURL(null, bundle, s, "utf-8", null);
        } else
        {
            ((TextView) (obj)).setVisibility(0);
            ((WebView) (obj1)).setVisibility(8);
            ((TextView) (obj)).setText(bundle);
        }
        mftdButton = (Button)findViewById(0x7f10039e);
        mftdButton.setOnClickListener(new android.view.View.OnClickListener() {

            final mftdActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = mftdActivity.this;
                super();
            }
        });
    }
}
