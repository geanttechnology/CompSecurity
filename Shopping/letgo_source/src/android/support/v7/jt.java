// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            kd, kb, jm, jx

public class jt extends kd
{

    private static final String a = android/support/v7/jt.getName();
    private boolean b;

    public jt(Context context, String s, String s1)
    {
        super(context, s);
        b(s1);
    }

    static void a(jt jt1)
    {
        jt1.kd.cancel();
    }

    protected Bundle a(String s)
    {
        Bundle bundle = kb.b(Uri.parse(s).getQuery());
        s = bundle.getString("bridge_args");
        bundle.remove("bridge_args");
        String s1;
        if (!kb.a(s))
        {
            try
            {
                bundle.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", jm.a(new JSONObject(s)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                kb.a(a, "Unable to parse bridge_args JSON", s);
            }
        }
        s1 = bundle.getString("method_results");
        bundle.remove("method_results");
        if (!kb.a(s1))
        {
            s = s1;
            if (kb.a(s1))
            {
                s = "{}";
            }
            try
            {
                bundle.putBundle("com.facebook.platform.protocol.RESULT_ARGS", jm.a(new JSONObject(s)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                kb.a(a, "Unable to parse bridge_args JSON", s);
            }
        }
        bundle.remove("version");
        bundle.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", jx.a());
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

                final jt a;

                public void run()
                {
                    jt.a(a);
                }

            
            {
                a = jt.this;
                super();
            }
            }, 1500L);
            return;
        }
    }

}
