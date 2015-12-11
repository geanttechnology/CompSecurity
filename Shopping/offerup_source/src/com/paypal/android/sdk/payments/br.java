// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import com.paypal.android.sdk.ac;
import com.paypal.android.sdk.az;
import com.paypal.android.sdk.cl;
import com.paypal.android.sdk.cm;
import com.paypal.android.sdk.dd;
import com.paypal.android.sdk.ex;
import com.paypal.android.sdk.fa;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bu, bt, PayPalService, bh

final class br
    implements ac
{

    br()
    {
    }

    public static AlertDialog a(Context context, fa fa1, String s, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        fa1 = ex.a(fa1);
        String s1 = ex.a(fa.at);
        return (new android.app.AlertDialog.Builder(context)).setMessage(s).setCancelable(false).setTitle(fa1).setPositiveButton(s1, onclicklistener).create();
    }

    static Dialog a(Activity activity, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        return (new android.app.AlertDialog.Builder(activity)).setIcon(0x1080027).setCancelable(false).setTitle(ex.a(fa.aR)).setMessage(ex.a(fa.aK)).setPositiveButton(ex.a(fa.aR), onclicklistener).setNegativeButton(ex.a(fa.f), new bu(activity)).create();
    }

    static Dialog a(Activity activity, fa fa1, Bundle bundle, int i)
    {
        return a(((Context) (activity)), fa1, bundle.getString("alert_errors"), ((android.content.DialogInterface.OnClickListener) (new bt(activity, i))));
    }

    static Dialog a(Activity activity, fa fa1, Bundle bundle, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        return a(((Context) (activity)), fa1, bundle.getString("alert_errors"), onclicklistener);
    }

    static Dialog a(Context context, fa fa1, fa fa2)
    {
        context = new ProgressDialog(context);
        context.setTitle(ex.a(fa1));
        context.setMessage(ex.a(fa2));
        context.setCancelable(false);
        return context;
    }

    static Intent a(Activity activity)
    {
        Intent intent = new Intent(activity.getApplicationContext(), com/paypal/android/sdk/payments/PayPalService);
        intent.putExtra("initializingActivity", activity.getClass().getSimpleName());
        if (activity.getIntent().hasExtra("com.paypal.android.sdk.paypalConfiguration"))
        {
            intent.putExtra("com.paypal.android.sdk.paypalConfiguration", activity.getIntent().getParcelableExtra("com.paypal.android.sdk.paypalConfiguration"));
        }
        return intent;
    }

    static void a(Activity activity, TextView textview, fa fa1)
    {
        Object obj;
        if (fa1 != null)
        {
            fa1 = ex.a(fa1);
        } else
        {
            fa1 = "";
        }
        obj = cm.c("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpCNDMzRTRFQ0M2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpCNDMzRTRFREM2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkI0MzNFNEVBQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkI0MzNFNEVCQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+Eyd0MQAABoFJREFUeNrMWl1M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", activity);
        obj = new BitmapDrawable(activity.getResources(), ((android.graphics.Bitmap) (obj)));
        activity.setTitle((new StringBuilder()).append("PayPal - ").append(fa1).toString());
        if (dd.a())
        {
            ActionBar actionbar = activity.getActionBar();
            actionbar.setBackgroundDrawable(cl.c);
            actionbar.setTitle(fa1);
            activity = (TextView)activity.findViewById(Resources.getSystem().getIdentifier("action_bar_title", "id", "android"));
            if (activity != null)
            {
                activity.setTextColor(-1);
            }
            actionbar.setDisplayHomeAsUpEnabled(false);
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                actionbar.setIcon(((android.graphics.drawable.Drawable) (obj)));
            } else
            {
                actionbar.setDisplayShowHomeEnabled(false);
            }
            if (textview != null)
            {
                textview.setVisibility(8);
            }
        } else
        if (textview != null)
        {
            textview.setText(fa1);
            return;
        }
    }

    static void a(Activity activity, bh bh1)
    {
        boolean flag1 = false;
        boolean flag;
        if (bh1.a != null && bh1.a.intValue() >= 500 || bh1.c())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            activity.showDialog(2);
            return;
        }
        flag = flag1;
        if (bh1.a())
        {
            flag = flag1;
            if ("invalid_client".equals(bh1.b))
            {
                flag = true;
            }
        }
        if (flag)
        {
            a(activity, ex.a(fa.bd), 3);
            return;
        } else
        {
            a(activity, ex.a(fa.bb), 1);
            return;
        }
    }

    static void a(Activity activity, String s, int i)
    {
        Bundle bundle = new Bundle();
        bundle.putString("alert_errors", s);
        activity.removeDialog(i);
        activity.showDialog(i, bundle);
    }

    static void a(TextView textview, String s)
    {
label0:
        {
            if (textview != null)
            {
                if (s != null && !az.c(s))
                {
                    break label0;
                }
                textview.setVisibility(8);
            }
            return;
        }
        if (az.b(s))
        {
            textview.setText(ex.a(fa.ag));
            return;
        }
        if (az.a(s))
        {
            textview.setText(ex.a(fa.af));
            return;
        } else
        {
            textview.setText(s);
            return;
        }
    }

    public static Object d()
    {
        throw new RuntimeException("Dev error");
    }

    public final String a()
    {
        return "2.11.1";
    }

    public final String b()
    {
        String s = android.os.Build.VERSION.RELEASE;
        String s1 = (new StringBuilder()).append(Build.MANUFACTURER).append(" ").append(Build.MODEL).toString();
        StringBuilder stringbuilder = new StringBuilder();
        if (dd.c("touch;"))
        {
            stringbuilder.append("touch; ");
        }
        return String.format("PayPalSDK/%s %s (%s %s; %s; %s)", new Object[] {
            "PayPal-Android-SDK", "2.11.1", "Android", s, s1, stringbuilder.toString().trim()
        });
    }

    public final String c()
    {
        return "6a0b485c921dfcd98e0852d3a54c5b09ab9a95ff";
    }
}
