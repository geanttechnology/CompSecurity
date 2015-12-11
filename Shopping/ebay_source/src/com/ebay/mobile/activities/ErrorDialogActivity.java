// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.activities:
//            eBay

public class ErrorDialogActivity extends Activity
    implements android.view.View.OnClickListener
{

    private static final String LOG_TAG = "ErrorDialogActivity";
    private static boolean haveOneUp = false;
    private static final String param_alert_icon = "alert_icon";
    private static final String param_code = "errorcode";
    private static final String param_is_html = "is_html";
    private static final String param_msg = "errortext";
    private static final String param_title = "title";

    public ErrorDialogActivity()
    {
    }

    public static void StartActivity(Context context, String s, String s1)
    {
        StartActivity(context, context.getResources().getString(0x7f070130), s, s1, true);
    }

    public static void StartActivity(Context context, String s, String s1, String s2, boolean flag)
    {
        Intent intent;
        if (haveOneUp)
        {
            return;
        }
        haveOneUp = true;
        intent = new Intent(context, com/ebay/mobile/activities/ErrorDialogActivity);
        if (s2 == null || !s2.contains("</")) goto _L2; else goto _L1
_L1:
        intent.putExtra("is_html", true);
_L4:
        intent.putExtra("title", s);
        intent.putExtra("errorcode", s1);
        intent.putExtra("errortext", s2);
        context.startActivity(intent);
        Log.e("ErrorDialogActivity", (new StringBuilder()).append("Error code = ").append(s1).toString());
        Log.e("ErrorDialogActivity", (new StringBuilder()).append("Error text = ").append(s2).toString());
        return;
_L2:
        if (flag)
        {
            intent.putExtra("alert_icon", true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void StartActivity(Context context, String s, String s1, boolean flag)
    {
        StartActivity(context, s, null, s1, flag);
    }

    protected void createUI()
    {
        Object obj = getIntent();
        if (((Intent) (obj)).getBooleanExtra("is_html", false))
        {
            ((WebView)findViewById(0x7f100190)).loadData(((Intent) (obj)).getStringExtra("errortext"), "text/html", "utf-8");
        } else
        {
            ((TextView)findViewById(0x7f10018f)).setText(((Intent) (obj)).getStringExtra("errortext"));
        }
        obj = ((Intent) (obj)).getStringExtra("errorcode");
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            findViewById(0x7f100191).setVisibility(8);
        } else
        {
            ((TextView)findViewById(0x7f100193)).setText(((CharSequence) (obj)));
        }
        ((Button)findViewById(0x7f100140)).setOnClickListener(this);
    }

    public void finish()
    {
        haveOneUp = false;
        super.finish();
    }

    public void onClick(View view)
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        int i;
        boolean flag;
        boolean flag1;
        try
        {
            super.onCreate(bundle);
            bundle = getIntent();
            flag = bundle.getBooleanExtra("is_html", false);
            flag1 = bundle.getBooleanExtra("alert_icon", false);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.e("ErrorDialogActivity", "OutOfMemory trying to display an OOM dialog...");
            eBay.Kill(this);
            finish();
            return;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        requestWindowFeature(1);
          goto _L3
_L6:
        setContentView(i);
        getWindow().setFlags(2, 2);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        TypedValue typedvalue = new TypedValue();
        if (!getTheme().resolveAttribute(0x1010355, typedvalue, true) || typedvalue.resourceId == 0)
        {
            typedvalue.resourceId = 0x1080027;
        }
        getWindow().setFeatureDrawableResource(3, typedvalue.resourceId);
        setTitle(bundle.getStringExtra("title"));
        createUI();
        return;
_L2:
        if (!flag1) goto _L3; else goto _L4
_L4:
        requestWindowFeature(3);
_L3:
        while (!flag) 
        {
            i = 0x7f030094;
            continue; /* Loop/switch isn't completed */
        }
        i = 0x7f030095;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        haveOneUp = false;
    }
}
