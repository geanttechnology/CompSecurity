// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.open.a.k;
import com.tencent.open.c.b;
import com.tencent.open.utils.c;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.a;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.b:
//            g, m, h, f, 
//            j, k

public class e extends Dialog
{

    private String a;
    private g b;
    private com.tencent.tauth.b c;
    private Handler d;
    private FrameLayout e;
    private LinearLayout f;
    private FrameLayout g;
    private ProgressBar h;
    private String i;
    private b j;
    private Context k;
    private com.tencent.open.web.security.c l;
    private boolean m;
    private int n;
    private String o;
    private String p;
    private long q;
    private long r;
    private HashMap s;

    public e(Context context, String s1, String s2, com.tencent.tauth.b b1, com.tencent.connect.b.m m1)
    {
        super(context, 0x1030010);
        m = false;
        q = 0L;
        r = 30000L;
        k = context;
        a = s2;
        b = new g(this, s1, s2, m1.b(), b1);
        d = new h(this, b, context.getMainLooper());
        c = b1;
        i = s1;
        l = new com.tencent.open.web.security.c();
        getWindow().setSoftInputMode(32);
    }

    static long a(e e1, long l1)
    {
        e1.q = l1;
        return l1;
    }

    static Context a(e e1)
    {
        return e1.k;
    }

    private String a()
    {
        String s1 = a.substring(a.indexOf("?") + 1);
        s1 = (new StringBuilder()).append("http://qzs.qq.com/open/mobile/login/qzsjump.html?").append(s1).toString();
        com.tencent.open.a.k.c("openSDK_LOG.authDlg", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return s1;
    }

    static String a(e e1, Object obj)
    {
        obj = (new StringBuilder()).append(e1.a).append(obj).toString();
        e1.a = ((String) (obj));
        return ((String) (obj));
    }

    static String a(e e1, String s1)
    {
        return e1.a(s1);
    }

    private String a(String s1)
    {
        s1 = new StringBuilder(s1);
        if (!TextUtils.isEmpty(p) && p.length() >= 4)
        {
            String s2 = p.substring(p.length() - 4);
            s1.append("_u_").append(s2);
        }
        return s1.toString();
    }

    static void a(Context context, String s1)
    {
        b(context, s1);
    }

    static boolean a(e e1, boolean flag)
    {
        e1.m = flag;
        return flag;
    }

    static String b(e e1, String s1)
    {
        e1.p = s1;
        return s1;
    }

    private void b()
    {
        c();
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        j = new b(k);
        j.setLayoutParams(layoutparams);
        e = new FrameLayout(k);
        layoutparams.gravity = 17;
        e.setLayoutParams(layoutparams);
        e.addView(j);
        e.addView(g);
        setContentView(e);
    }

    private static void b(Context context, String s1)
    {
        try
        {
            s1 = com.tencent.open.utils.m.d(s1);
            int i1 = s1.getInt("type");
            s1 = s1.getString("msg");
            Toast.makeText(context.getApplicationContext(), s1, i1).show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    static boolean b(e e1)
    {
        return e1.e();
    }

    static String c(e e1, String s1)
    {
        e1.o = s1;
        return s1;
    }

    private void c()
    {
        h = new ProgressBar(k);
        Object obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        h.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        f = new LinearLayout(k);
        obj = null;
        if (i.equals("action_login"))
        {
            Object obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
            obj1.gravity = 16;
            obj1.leftMargin = 5;
            obj = new TextView(k);
            if (Locale.getDefault().getLanguage().equals("zh"))
            {
                ((TextView) (obj)).setText("\u767B\u5F55\u4E2D...");
            } else
            {
                ((TextView) (obj)).setText("Logging in...");
            }
            ((TextView) (obj)).setTextColor(Color.rgb(255, 255, 255));
            ((TextView) (obj)).setTextSize(18F);
            ((TextView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        }
        obj1 = new android.widget.FrameLayout.LayoutParams(-2, -2);
        obj1.gravity = 17;
        f.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        f.addView(h);
        if (obj != null)
        {
            f.addView(((View) (obj)));
        }
        g = new FrameLayout(k);
        obj = new android.widget.FrameLayout.LayoutParams(-1, -2);
        obj.leftMargin = 80;
        obj.rightMargin = 80;
        obj.topMargin = 40;
        obj.bottomMargin = 40;
        obj.gravity = 17;
        g.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        g.setBackgroundResource(0x1080000);
        g.addView(f);
    }

    static boolean c(e e1)
    {
        return e1.m;
    }

    static String d(e e1)
    {
        return e1.a;
    }

    private void d()
    {
        j.setVerticalScrollBarEnabled(false);
        j.setHorizontalScrollBarEnabled(false);
        j.setWebViewClient(new f(this));
        j.setWebChromeClient(new WebChromeClient());
        j.clearFormData();
        j.clearSslPreferences();
        j.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final e a;

            public boolean onLongClick(View view)
            {
                return true;
            }

            
            {
                a = e.this;
                super();
            }
        });
        j.setOnTouchListener(new android.view.View.OnTouchListener() {

            final e a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 1: default 28
            //                           0 30
            //                           1 30;
                   goto _L1 _L2 _L2
_L1:
                return false;
_L2:
                if (!view.hasFocus())
                {
                    view.requestFocus();
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                a = e.this;
                super();
            }
        });
        WebSettings websettings = j.getSettings();
        websettings.setSavePassword(false);
        websettings.setSaveFormData(false);
        websettings.setCacheMode(-1);
        websettings.setNeedInitialFocus(false);
        websettings.setBuiltInZoomControls(true);
        websettings.setSupportZoom(true);
        websettings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        websettings.setJavaScriptEnabled(true);
        websettings.setDatabaseEnabled(true);
        websettings.setDatabasePath(k.getDir("databases", 0).getPath());
        websettings.setDomStorageEnabled(true);
        com.tencent.open.a.k.b("openSDK_LOG.authDlg", (new StringBuilder()).append("-->mUrl : ").append(a).toString());
        o = a;
        j.loadUrl(a);
        j.setVisibility(4);
        j.getSettings().setSavePassword(false);
        l.a(new a(), "SecureJsInterface");
        a.a = false;
        super.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final e a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                try
                {
                    JniInterface.clearAllPWD();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    return;
                }
            }

            
            {
                a = e.this;
                super();
            }
        });
    }

    static b e(e e1)
    {
        return e1.j;
    }

    private boolean e()
    {
        Object obj = com.tencent.connect.b.j.a();
        String s1 = ((j) (obj)).c();
        Object obj1 = new com.tencent.connect.b.k();
        obj1.a = c;
        obj1.b = this;
        obj1.c = s1;
        obj = ((j) (obj)).a(((com.tencent.connect.b.k) (obj1)));
        obj1 = a.substring(0, a.indexOf("?"));
        Bundle bundle = com.tencent.open.utils.m.b(a);
        bundle.putString("token_key", s1);
        bundle.putString("serial", ((String) (obj)));
        bundle.putString("browser", "1");
        a = (new StringBuilder()).append(((String) (obj1))).append("?").append(com.tencent.open.utils.m.a(bundle)).toString();
        return com.tencent.open.utils.m.a(k, a);
    }

    static g f(e e1)
    {
        return e1.b;
    }

    static FrameLayout g(e e1)
    {
        return e1.g;
    }

    static com.tencent.open.web.security.c h(e e1)
    {
        return e1.l;
    }

    static String i(e e1)
    {
        return e1.o;
    }

    static long j(e e1)
    {
        return e1.q;
    }

    static int k(e e1)
    {
        return e1.n;
    }

    static long l(e e1)
    {
        return e1.r;
    }

    static int m(e e1)
    {
        int i1 = e1.n;
        e1.n = i1 + 1;
        return i1;
    }

    static Handler n(e e1)
    {
        return e1.d;
    }

    static String o(e e1)
    {
        return e1.a();
    }

    static HashMap p(e e1)
    {
        return e1.s;
    }

    public void a(String s1, String s2)
    {
        s1 = (new StringBuilder()).append("javascript:").append(s1).append("(").append(s2).append(");void(").append(System.currentTimeMillis()).append(");").toString();
        j.loadUrl(s1);
    }

    public void dismiss()
    {
        s.clear();
        d.removeCallbacksAndMessages(null);
        if (isShowing())
        {
            super.dismiss();
        }
        if (j != null)
        {
            j.destroy();
            j = null;
        }
    }

    public void onBackPressed()
    {
        if (!m)
        {
            b.a();
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        b();
        d();
        s = new HashMap();
    }

    protected void onStop()
    {
        super.onStop();
    }

    static 
    {
        Context context = com.tencent.open.utils.c.a();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        if ((new File((new StringBuilder()).append(context.getFilesDir().toString()).append("/").append("libwbsafeedit.so").toString())).exists())
        {
            System.load((new StringBuilder()).append(context.getFilesDir().toString()).append("/").append("libwbsafeedit.so").toString());
            com.tencent.open.a.k.b("openSDK_LOG.authDlg", "-->load wbsafeedit lib success.");
            break MISSING_BLOCK_LABEL_117;
        }
        try
        {
            com.tencent.open.a.k.b("openSDK_LOG.authDlg", "-->load wbsafeedit lib fail, because so is not exists.");
        }
        catch (Exception exception)
        {
            com.tencent.open.a.k.b("openSDK_LOG.authDlg", "-->load wbsafeedit lib error.", exception);
        }
        break MISSING_BLOCK_LABEL_117;
        com.tencent.open.a.k.b("openSDK_LOG.authDlg", "-->load wbsafeedit lib fail, because context is null.");
    }
}
