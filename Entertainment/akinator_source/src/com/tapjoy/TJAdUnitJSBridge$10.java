// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.webkit.WebView;
import org.json.JSONObject;

// Referenced classes of package com.tapjoy:
//            TJAdUnitJSBridge

final class b
    implements Runnable
{

    final JSONObject a;
    final String b;
    final TJAdUnitJSBridge c;

    public final void run()
    {
        if (android.os.T < 19)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        TJAdUnitJSBridge.e(c).evaluateJavascript(a.getString("command"), null);
_L1:
        c.invokeJSCallback(b, new Object[] {
            Boolean.TRUE
        });
        return;
        try
        {
            TJAdUnitJSBridge.e(c).loadUrl((new StringBuilder("javascript:")).append(a.getString("command")).toString());
        }
        catch (Exception exception)
        {
            c.invokeJSCallback(b, new Object[] {
                Boolean.FALSE
            });
            return;
        }
          goto _L1
    }

    (TJAdUnitJSBridge tjadunitjsbridge, JSONObject jsonobject, String s)
    {
        c = tjadunitjsbridge;
        a = jsonobject;
        b = s;
        super();
    }
}
