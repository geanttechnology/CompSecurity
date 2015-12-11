// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.groupon.Channel;
import com.groupon.models.mobilescheduler.Deal;
import com.groupon.models.mobilescheduler.MobileSchedulerData;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.LoggingUtils;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            MobileScheduler

private class <init> extends WebViewClient
{

    final MobileScheduler this$0;

    private void showErrorDialog()
    {
        Object obj = MobileScheduler.access$1300(MobileScheduler.this);
        Object obj1 = MobileScheduler.this;
        int i;
        if (isGdt)
        {
            i = 0x7f0801e1;
        } else
        {
            i = 0x7f080342;
        }
        obj1 = ((MobileScheduler) (obj1)).getString(i);
        if (isGdt)
        {
            i = 0x7f08045b;
        } else
        {
            i = 0x7f080139;
        }
        obj = ((DialogManager) (obj)).getDialogFragment(null, obj1, Integer.valueOf(i), false);
        GrouponDialogFragment.show(getFragmentManager(), ((GrouponDialogFragment) (obj)), "scheduler_error_dialog");
    }

    public void onPageFinished(WebView webview, String s)
    {
        loading.setVisibility(8);
        if (isGdt && s.contains("#/order"))
        {
            gdtThanksPageReached = true;
        }
        if (!s.endsWith("#reserved")) goto _L2; else goto _L1
_L1:
        MobileScheduler mobilescheduler = MobileScheduler.this;
        String s1;
        if (isBookableDeal())
        {
            s1 = "booked";
        } else
        {
            s1 = "pending";
        }
        MobileScheduler.access$500(mobilescheduler, s1);
        updateActionBarTitle();
        if (isPrePurchaseBooking || MobileScheduler.access$600(MobileScheduler.this) != null)
        {
            MobileScheduler.access$800(MobileScheduler.this).loadUrl(MobileScheduler.access$700());
            MobileScheduler.access$1000(MobileScheduler.this).logPrePurchaseBookingClick("w_schedule_action", "w_schedule_step", MobileScheduler.access$000(MobileScheduler.this).deal.id, Channel.safeValueOf(MobileScheduler.access$000(MobileScheduler.this).channel), MobileScheduler.access$900());
        }
_L4:
        super.onPageFinished(webview, s);
        return;
_L2:
        if (s.endsWith("#skip") && (isPrePurchaseBooking || MobileScheduler.access$600(MobileScheduler.this) != null))
        {
            Intent intent = MobileScheduler.access$1100(MobileScheduler.this);
            if (intent != null)
            {
                if (intent.getExtras().containsKey("reservation_bundle"))
                {
                    intent.removeExtra("reservation_bundle");
                }
                if (Strings.notEmpty(selectedOptionId))
                {
                    intent.putExtra("optionId", selectedOptionId);
                }
            }
            startActivity(MobileScheduler.access$1200(MobileScheduler.this));
            MobileScheduler.access$1000(MobileScheduler.this).logPrePurchaseBookingClick("w_skip_action", "w_skip_step", MobileScheduler.access$000(MobileScheduler.this).deal.id, Channel.safeValueOf(MobileScheduler.access$000(MobileScheduler.this).channel), MobileScheduler.access$900());
        } else
        if (s.endsWith("#cancelled"))
        {
            MobileScheduler.access$500(MobileScheduler.this, "unbooked");
            updateActionBarTitle(getString(0x7f080328));
        } else
        if (s.endsWith("#"))
        {
            updateActionBarTitle();
        } else
        if (s.endsWith("#error"))
        {
            showErrorDialog();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (!isGdt)
        {
            loading.setVisibility(8);
        }
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        loading.setVisibility(8);
        super.onReceivedError(webview, i, s, s1);
        webview.loadUrl("about:blank");
        showErrorDialog();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return super.shouldOverrideUrlLoading(webview, s);
    }

    private ()
    {
        this$0 = MobileScheduler.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
