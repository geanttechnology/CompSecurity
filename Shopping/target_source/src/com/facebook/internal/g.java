// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;

// Referenced classes of package com.facebook.internal:
//            q, o, d, k

public class g extends q
{

    private static final String a = com/facebook/internal/g.getName();
    private boolean b;

    public g(Context context, String s, String s1)
    {
        super(context, s);
        b(s1);
    }

    static void a(g g1)
    {
        g1.q.cancel();
    }

    protected Bundle a(String s)
    {
        Bundle bundle = o.b(Uri.parse(s).getQuery());
        s = bundle.getString("bridge_args");
        bundle.remove("bridge_args");
        String s1;
        if (!o.a(s))
        {
            try
            {
                bundle.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", d.a(JSONObjectInstrumentation.init(s)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                o.a(a, "Unable to parse bridge_args JSON", s);
            }
        }
        s1 = bundle.getString("method_results");
        bundle.remove("method_results");
        if (!o.a(s1))
        {
            s = s1;
            if (o.a(s1))
            {
                s = "{}";
            }
            try
            {
                bundle.putBundle("com.facebook.platform.protocol.RESULT_ARGS", d.a(JSONObjectInstrumentation.init(s)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                o.a(a, "Unable to parse bridge_args JSON", s);
            }
        }
        bundle.remove("version");
        bundle.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", k.a());
        return bundle;
    }

    public void cancel()
    {
        WebView webview = c();
        if (!b() || a() || webview == null || !webview.isShown())
        {
            super.cancel();
        } else
        if (!b)
        {
            b = true;
            webview.loadUrl((new StringBuilder()).append("javascript:").append("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();").toString());
            (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {

                final g a;

                public void run()
                {
                    g.a(a);
                }

            
            {
                a = g.this;
                super();
            }
            }, 1500L);
            return;
        }
    }

}
