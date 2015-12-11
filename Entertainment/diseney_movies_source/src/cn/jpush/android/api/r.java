// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.data.d;
import cn.jpush.android.data.s;
import cn.jpush.android.ui.f;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.api:
//            q, t, s

final class r
    implements Runnable
{

    private static final String z[];
    final d a;
    final Context b;

    r(d d1, Context context)
    {
        a = d1;
        b = context;
        super();
    }

    public final void run()
    {
        if ((a instanceof s) && a.f())
        {
            x.c();
            String s1 = ((s)a).a;
            WindowManager windowmanager = (WindowManager)b.getSystemService(z[2]);
            WebView webview = new WebView(b);
            ImageButton imagebutton = new ImageButton(b);
            q.a(b, windowmanager, webview, imagebutton);
            webview.setHorizontalScrollBarEnabled(false);
            webview.setVerticalScrollBarEnabled(false);
            webview.setScrollbarFadingEnabled(true);
            webview.setScrollBarStyle(0x2000000);
            WebSettings websettings = webview.getSettings();
            websettings.setJavaScriptEnabled(true);
            websettings.setDefaultTextEncodingName(z[1]);
            websettings.setSupportZoom(true);
            websettings.setCacheMode(2);
            webview.addJavascriptInterface(new t(b, a, windowmanager, webview, imagebutton), z[3]);
            webview.setWebViewClient(new f(a));
            if (!TextUtils.isEmpty(s1) && s1.startsWith(z[0]))
            {
                webview.loadUrl(s1);
            }
            imagebutton.setOnClickListener(new cn.jpush.android.api.s(this, windowmanager, webview, imagebutton));
            return;
        } else
        {
            x.f();
            return;
        }
    }

    static 
    {
        Object obj;
        String as2[];
        int i;
        int j;
        as2 = new String[4];
        obj = "\0077vu";
        i = -1;
        j = 0;
_L10:
        String as[];
        int k;
        int l;
        int i1;
        int j1;
        as = as2;
        obj = ((String) (obj)).toCharArray();
        k = obj.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        l = 0;
        i1 = j;
        j1 = i;
_L9:
        j = l;
_L7:
        char ac[];
        int k1;
        ac = ((char []) (obj));
        k1 = ac[l];
        j % 5;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 270
    //                   1 277
    //                   2 284
    //                   3 290;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 26;
_L11:
label0:
        {
            ac[l] = (char)(i ^ k1);
            j++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        i = k;
        as1 = as;
        l1 = i1;
        ac = ((char []) (obj));
        k1 = j1;
_L12:
        j1 = k1;
        obj = ac;
        i1 = l1;
        as = as1;
        k = i;
        l = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(ac)).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj = ":\027D(\"";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            obj = "\030*lau\030";
            j = 2;
            i = 1;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            j = 3;
            obj = "%\023wvr8&`";
            i = 2;
            break;

        case 2: // '\002'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 111;
          goto _L11
_L3:
        i = 67;
          goto _L11
_L4:
        i = 2;
          goto _L11
_L5:
        i = 5;
          goto _L11
        boolean flag = false;
        k1 = i;
        ac = ((char []) (obj));
        l1 = j;
        as1 = as;
        i = k;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
