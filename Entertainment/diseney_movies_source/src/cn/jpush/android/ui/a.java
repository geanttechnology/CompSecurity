// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import cn.jpush.android.data.d;
import cn.jpush.android.util.x;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package cn.jpush.android.ui:
//            b, c, WebViewCallback, d, 
//            f

public final class a extends RelativeLayout
{

    private static final String z[];
    ImageView a;
    android.view.View.OnTouchListener b;
    private final Context c;
    private WebView d;
    private c e;

    public a(Context context, d d1)
    {
        super(context);
        b = new b(this);
        e = new c(this);
        c = context;
        ProgressBar progressbar = new ProgressBar(context, null, 0x1010078);
        progressbar.setMax(100);
        progressbar.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, cn.jpush.android.util.a.a(context, 5F)));
        d = new WebView(context);
        d.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        d.setScrollbarFadingEnabled(true);
        d.setScrollBarStyle(0x2000000);
        WebSettings websettings = d.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setDefaultTextEncodingName(z[3]);
        websettings.setSupportZoom(true);
        websettings.setCacheMode(2);
        d.addJavascriptInterface(new WebViewCallback(context, d1), z[2]);
        d.setWebChromeClient(new cn.jpush.android.ui.d(progressbar));
        d.setWebViewClient(new f(d1));
        d.setOnTouchListener(b);
        addView(progressbar, new android.widget.RelativeLayout.LayoutParams(-1, cn.jpush.android.util.a.a(context, 5F)));
        addView(d, new android.widget.RelativeLayout.LayoutParams(-1, -1));
    }

    static c a(a a1)
    {
        return a1.e;
    }

    static void b(a a1)
    {
        if (a1.a == null)
        {
            return;
        } else
        {
            a1.e.removeMessages(4);
            a1.e.removeMessages(0);
            a1.a.setVisibility(8);
            a1.a.setVisibility(0);
            a1.e.sendEmptyMessageDelayed(4, 2000L);
            return;
        }
    }

    static void c(a a1)
    {
        if (a1.a == null)
        {
            return;
        } else
        {
            a1.a.setVisibility(4);
            return;
        }
    }

    public final void a()
    {
        removeAllViews();
        if (d != null)
        {
            d.removeAllViews();
            d.destroy();
            d = null;
        }
        if (a != null)
        {
            a = null;
        }
    }

    public final void a(android.view.View.OnClickListener onclicklistener)
    {
        Object obj;
        obj = c;
        x.c();
        a = new ImageView(((Context) (obj)));
        InputStream inputstream = ((Context) (obj)).getResources().getAssets().open(z[1]);
        BitmapDrawable bitmapdrawable = new BitmapDrawable(inputstream);
        a.setImageDrawable(bitmapdrawable);
        a.setVisibility(4);
        try
        {
            inputstream.close();
        }
        catch (IOException ioexception)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new android.widget.RelativeLayout.LayoutParams(cn.jpush.android.util.a.a(((Context) (obj)), 40F), cn.jpush.android.util.a.a(((Context) (obj)), 40F));
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11, -1);
        addView(a, ((android.view.ViewGroup.LayoutParams) (obj)));
        e.sendEmptyMessage(0);
_L2:
        if (a != null)
        {
            a.setOnClickListener(onclicklistener);
        }
        return;
        IOException ioexception1;
        ioexception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a(String s)
    {
        if (d != null)
        {
            (new StringBuilder(z[0])).append(s).toString();
            x.c();
            d.loadUrl(s);
        }
    }

    static 
    {
        Object obj;
        String as2[];
        int i;
        int j;
        as2 = new String[4];
        obj = "fO)!uxLr";
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
            break MISSING_BLOCK_LABEL_298;
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
    //                   3 291;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 32;
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
            obj = "`P=6HUC$*So\0168+G";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            obj = "@p=6H]E*";
            j = 2;
            i = 1;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            j = 3;
            obj = "_t\016h\030";
            i = 2;
            break;

        case 2: // '\002'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 10;
          goto _L11
_L3:
        i = 32;
          goto _L11
_L4:
        i = 72;
          goto _L11
_L5:
        i = 69;
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
