// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ebay.mobile.activities.ShowWebViewFragment;

public class PayPalIdentityFragment extends ShowWebViewFragment
{

    private static final int IDL_ERROR_EBAY_USER_LOGGED_OUT = 7;
    private static final int IDL_ERROR_SESSION_EXPIRED = 4;
    private static final int IDL_ERROR_USER_CANCELED = 10;

    public PayPalIdentityFragment()
    {
    }

    protected void createUI()
    {
        super.createUI();
        webview.setVerticalScrollBarEnabled(false);
        webview.getSettings().setBuiltInZoomControls(false);
    }

    protected boolean isUrlPastLastPage(String s)
    {
        Object obj;
        String s1;
        if (!s.startsWith("http://prox.ebay.com/"))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj = Uri.parse(s);
        s1 = ((Uri) (obj)).getQueryParameter("idllink");
        s = getActivity();
        if (s == null)
        {
            return true;
        }
        if (s1 != null)
        {
            s.setResult(-1, (new Intent()).putExtra("payPalLinkId", s1));
            return true;
        }
        s1 = ((Uri) (obj)).getQueryParameter("idlerror");
        if (s1 == null) goto _L2; else goto _L1
_L1:
        byte byte0 = 2;
        Integer.parseInt(s1);
        JVM INSTR lookupswitch 3: default 108
    //                   4: 123
    //                   7: 117
    //                   10: 129;
           goto _L3 _L4 _L5 _L6
_L3:
        s.setResult(byte0, null);
        return true;
_L5:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        byte0 = 3;
        continue; /* Loop/switch isn't completed */
_L6:
        byte0 = 0;
        if (true) goto _L3; else goto _L2
_L2:
        obj = ((Uri) (obj)).getQueryParameter("code");
        if (obj != null)
        {
            if ("302".equals(obj))
            {
                s.setResult(4, null);
                return true;
            }
            if ("400".equals(obj))
            {
                s.setResult(5, null);
                return true;
            }
        }
        s.setResult(-1, null);
        return true;
        return false;
    }

    protected void onDone(boolean flag)
    {
        if (flag)
        {
            getActivity().finish();
        }
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
    }
}
