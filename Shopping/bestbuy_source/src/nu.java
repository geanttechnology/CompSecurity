// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.bbyobjects.BBYWebView;

public class nu
{

    public static boolean a = false;
    Handler b;
    private String c;
    private BBYWebView d;
    private Context e;
    private boolean f;

    public nu(Context context, BBYWebView bbywebview, boolean flag)
    {
        c = nu.getSimpleName();
        f = false;
        b = new Handler() {

            final nu a;

            public void handleMessage(Message message)
            {
                int i = message.what;
                if (!(nu.b(a) instanceof HomeActivity)) goto _L2; else goto _L1
_L1:
                message = ((HomeActivity)nu.b(a)).getSupportFragmentManager().findFragmentById(0x7f0c0033);
                if (!(message instanceof HomeTabFragment)) goto _L2; else goto _L3
_L3:
                message = (HomeTabFragment)message;
_L10:
                i;
                JVM INSTR tableswitch 1 2: default 72
            //                           1 73
            //                           2 82;
                   goto _L4 _L5 _L6
_L4:
                return;
_L5:
                if (message == null) goto _L4; else goto _L7
_L7:
                message.d();
                return;
_L6:
                if (message == null) goto _L4; else goto _L8
_L8:
                message.c();
                return;
_L2:
                message = null;
                if (true) goto _L10; else goto _L9
_L9:
            }

            
            {
                a = nu.this;
                super();
            }
        };
        d = bbywebview;
        e = context;
        f = flag;
    }

    static BBYWebView a(nu nu1)
    {
        return nu1.d;
    }

    static Context b(nu nu1)
    {
        return nu1.e;
    }

    public String a(String s, String s1)
    {
        String s2;
        String s3;
        s2 = "";
        CookieSyncManager.getInstance().sync();
        s3 = CookieManager.getInstance().getCookie(s);
        s = s2;
        if (s3 == null) goto _L2; else goto _L1
_L1:
        String as[];
        as = s3.split(";");
        s = s2;
        if (as == null) goto _L2; else goto _L3
_L3:
        int i;
        int j;
        j = as.length;
        i = 0;
_L8:
        s = s2;
        if (i >= j) goto _L2; else goto _L4
_L4:
        s = as[i].split("=");
        if (s.length < 2 || !s[0].trim().equals(s1)) goto _L6; else goto _L5
_L5:
        s = s[1];
_L2:
        return s;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void eventBusCallback(String s)
    {
label0:
        {
label1:
            {
                int i = Integer.parseInt(s);
                if (!nb.a().G())
                {
                    nb.a().b().edit().putInt(e.getResources().getString(0x7f080031), i).commit();
                    if (i != 0)
                    {
                        break label0;
                    }
                    if (!a)
                    {
                        break label1;
                    }
                    b.sendEmptyMessage(1);
                }
                return;
            }
            b.sendEmptyMessage(2);
            return;
        }
        b.sendEmptyMessage(1);
    }

    public void eventBusRegister()
    {
        d.loadUrl(nl.a(0x7f080195, e));
        d.loadUrl(nl.a(0x7f0800ed, e));
    }

    public void executeErrorContent()
    {
        d.post(new Runnable() {

            final nu a;

            public void run()
            {
                nu.a(a).loadUrl("javascript:window.BBYWebViewJavaScriptInterface.processHTMLError(document.getElementsByClassName('error-msg')[0].innerHTML.toString());");
                if (nu.a(a).a() != null)
                {
                    nu.a(a).a().setVisibility(8);
                }
                nu.a(a).setVisibility(0);
            }

            
            {
                a = nu.this;
                super();
            }
        });
    }

    public void executeHtmlContent()
    {
        d.post(new Runnable() {

            final nu a;

            public void run()
            {
                nu.a(a).loadUrl("javascript:window.BBYWebViewJavaScriptInterface.processHTML(document.body.innerHTML.toString());");
                if (nu.a(a).a() != null)
                {
                    nu.a(a).a().setVisibility(8);
                }
                nu.a(a).setVisibility(0);
            }

            
            {
                a = nu.this;
                super();
            }
        });
    }

    public void executeMainCSS()
    {
        d.loadUrl(nl.a(0x7f08021e, e));
    }

    public void goBack()
    {
        d.loadUrl(nl.a(0x7f0801cd, e));
    }

    public void orderEventBusCallback(String s)
    {
        if (s.contains("thank"))
        {
            a = true;
        }
    }

    public void orderEventBusRegister()
    {
        d.loadUrl(nl.a(0x7f080360, e));
    }

    public void orderStatusCSS()
    {
        d.loadUrl(nl.a(0x7f080294, e));
    }

    public void processHTML(String s)
    {
        if (s != null && s.trim().length() != 0)
        {
            d.post(new Runnable(s) {

                final String a;
                final nu b;

                public void run()
                {
                    nu.a(b).setHtmlContent(a);
                }

            
            {
                b = nu.this;
                a = s;
                super();
            }
            });
        }
    }

    public void processHTMLError(String s)
    {
        kf.c("BBYWebViewJavaScriptInterface", (new StringBuilder()).append("The error content is ").append(s).toString());
        if (s != null && s.trim().length() != 0)
        {
            d.post(new Runnable(s) {

                final String a;
                final nu b;

                public void run()
                {
                    nu.a(b).setHtmlError(a);
                }

            
            {
                b = nu.this;
                a = s;
                super();
            }
            });
        }
    }

    public void thankYouPage()
    {
        d.loadUrl("javascript:(function() { document.getElementsByClassName('addressBlock')[0].getElementsByTagName('a')[0].removeAttribute('href');document.getElementsByClassName('addressBlock')[0].getElementsByTagName('a')[0].setAttribute('style', 'color:#000000!important');document.getElementsByClassName('addressBlock')[2].getElementsByTagName('a')[0].removeAttribute('href');document.getElementsByClassName('addressBlock')[2].getElementsByTagName('a')[0].setAttribute('style', 'color:#000000!important');document.getElementsByClassName('addressBlock')[2].getElementsByTagName('a')[1].removeAttribute('href');document.getElementsByClassName('addressBlock')[2].getElementsByTagName('a')[1].setAttribute('style', 'color:#000000!important');})()");
    }

    public void updateCartBadge()
    {
        b.sendEmptyMessage(1);
    }

    public void updateCartBadgeAndShowCart()
    {
        b.sendEmptyMessage(2);
    }

    public void updateCartCount(String s)
    {
        int i;
        boolean flag = false;
        s = a(s, "CartItemCount");
        i = ((flag) ? 1 : 0);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        i = ((flag) ? 1 : 0);
        if (!s.isEmpty())
        {
            i = Integer.parseInt(s);
        }
        nb.a().b().edit().putInt(e.getResources().getString(0x7f080031), i).commit();
        if (i == 0)
        {
            try
            {
                b.sendEmptyMessage(2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_94;
        }
        b.sendEmptyMessage(1);
        return;
    }

    public void weeklyAdCSS()
    {
        d.loadUrl(nl.a(0x7f080385, e));
    }

}
