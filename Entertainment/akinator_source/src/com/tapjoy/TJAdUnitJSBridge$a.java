// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.webkit.WebView;
import android.widget.RelativeLayout;

// Referenced classes of package com.tapjoy:
//            TJAdUnitJSBridge, TapjoyLog

final class a extends AsyncTask
{

    WebView a;
    final TJAdUnitJSBridge b;

    protected final volatile Object doInBackground(Object aobj[])
    {
        return (Boolean[])aobj;
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Boolean[])obj;
        boolean flag = obj[0].booleanValue();
        boolean flag1 = obj[1].booleanValue();
        if (TJAdUnitJSBridge.d(b) instanceof Activity)
        {
            ((Activity)TJAdUnitJSBridge.d(b)).runOnUiThread(new Runnable(flag, flag1) {

                final boolean a;
                final boolean b;
                final TJAdUnitJSBridge.a c;

                public final void run()
                {
                    if (!a) goto _L2; else goto _L1
_L1:
                    c.a.setVisibility(0);
                    if (!b) goto _L4; else goto _L3
_L3:
                    if (c.a.getParent() instanceof RelativeLayout)
                    {
                        ((RelativeLayout)c.a.getParent()).getBackground().setAlpha(0);
                        ((RelativeLayout)c.a.getParent()).setBackgroundColor(0);
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        c.a.setLayerType(1, null);
                    }
_L6:
                    return;
_L4:
                    if (c.a.getParent() instanceof RelativeLayout)
                    {
                        ((RelativeLayout)c.a.getParent()).getBackground().setAlpha(255);
                        ((RelativeLayout)c.a.getParent()).setBackgroundColor(-1);
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        c.a.setLayerType(0, null);
                        return;
                    }
                    continue; /* Loop/switch isn't completed */
_L2:
                    c.a.setVisibility(4);
                    if (c.a.getParent() instanceof RelativeLayout)
                    {
                        ((RelativeLayout)c.a.getParent()).getBackground().setAlpha(0);
                        ((RelativeLayout)c.a.getParent()).setBackgroundColor(0);
                        return;
                    }
                    if (true) goto _L6; else goto _L5
_L5:
                }

            
            {
                c = TJAdUnitJSBridge.a.this;
                a = flag;
                b = flag1;
                super();
            }
            });
            return;
        } else
        {
            TapjoyLog.e("TJAdUnitJSBridge", "Unable to present offerwall. No Activity context provided.");
            return;
        }
    }

    public _cls1.b(TJAdUnitJSBridge tjadunitjsbridge, WebView webview)
    {
        b = tjadunitjsbridge;
        super();
        a = webview;
    }
}
