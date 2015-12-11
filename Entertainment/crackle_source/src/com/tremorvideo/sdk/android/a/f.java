// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.a;

import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.tremorvideo.sdk.android.a:
//            d, g, e, h

class f
{
    private static interface a
    {

        public abstract d b(Map map, WebView webview);
    }


    private static Map a;

    static d a(String s, Map map, WebView webview)
    {
        s = (a)a.get(s);
        if (s != null)
        {
            return s.b(map, webview);
        } else
        {
            return null;
        }
    }

    static 
    {
        a = new HashMap();
        a.put("trigger-event", new a() {

            public g a(Map map, WebView webview)
            {
                return new g(map, webview);
            }

            public d b(Map map, WebView webview)
            {
                return a(map, webview);
            }

        });
        a.put("cancel-auto-skip", new a() {

            public e a(Map map, WebView webview)
            {
                return new e(map, webview);
            }

            public d b(Map map, WebView webview)
            {
                return a(map, webview);
            }

        });
        a.put("validate-complete", new a() {

            public h a(Map map, WebView webview)
            {
                return new h(map, webview);
            }

            public d b(Map map, WebView webview)
            {
                return a(map, webview);
            }

        });
    }
}
