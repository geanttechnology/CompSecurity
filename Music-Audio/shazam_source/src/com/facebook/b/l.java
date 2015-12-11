// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.b:
//            v, t, e, p

public class l extends v
{

    private static final String f = com/facebook/b/l.getName();
    private boolean g;

    public l(Context context, String s, String s1)
    {
        super(context, s);
        super.a = s1;
    }

    static void a(l l1)
    {
        l1.v.cancel();
    }

    protected final Bundle a(String s)
    {
        Bundle bundle = t.b(Uri.parse(s).getQuery());
        s = bundle.getString("bridge_args");
        bundle.remove("bridge_args");
        String s1;
        if (!t.a(s))
        {
            try
            {
                bundle.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", e.a(new JSONObject(s)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                t.c(f);
            }
        }
        s1 = bundle.getString("method_results");
        bundle.remove("method_results");
        if (!t.a(s1))
        {
            s = s1;
            if (t.a(s1))
            {
                s = "{}";
            }
            try
            {
                bundle.putBundle("com.facebook.platform.protocol.RESULT_ARGS", e.a(new JSONObject(s)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                t.c(f);
            }
        }
        bundle.remove("version");
        bundle.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", p.a());
        return bundle;
    }

    public void cancel()
    {
        WebView webview = super.c;
        if (!super.e || super.d || webview == null || !webview.isShown())
        {
            super.cancel();
        } else
        if (!g)
        {
            g = true;
            webview.loadUrl((new StringBuilder("javascript:")).append("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();").toString());
            (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {

                final l a;

                public final void run()
                {
                    l.a(a);
                }

            
            {
                a = l.this;
                super();
            }
            }, 1500L);
            return;
        }
    }

}
