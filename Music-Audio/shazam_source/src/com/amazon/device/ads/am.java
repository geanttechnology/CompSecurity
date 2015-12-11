// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.device.ads:
//            co, ar, at, dz, 
//            cn, ay, aa, ab, 
//            z, ds, ea, f, 
//            as, h, e

class am extends WebViewClient
{
    static interface a
    {

        public abstract void a(WebView webview, String s);
    }

    static final class b
        implements d
    {

        private final Context a;
        private final ar b;
        private final cn c = co.a(am.a());
        private final ea d;

        private void b(String s)
        {
            c.a("Special url clicked, but was not handled by SDK. Url: %s", new Object[] {
                s
            });
        }

        public final boolean a(String s)
        {
            Object obj;
            Uri uri;
            obj = null;
            c.b("Executing AmazonMobile Intent", null);
            uri = Uri.parse(s);
            List list = uri.getQueryParameters("intent");
            obj = list;
_L11:
            if (obj == null || ((List) (obj)).size() <= 0) goto _L2; else goto _L1
_L1:
            obj = ((List) (obj)).iterator();
_L6:
            if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
            if (!dz.a((String)((Iterator) (obj)).next(), a)) goto _L6; else goto _L5
_L5:
            return true;
_L4:
            b(s);
            return true;
_L2:
            boolean flag;
            if (a.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop") == null)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_301;
            }
            if (!uri.getHost().equals("shopping"))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = uri.getQueryParameter("app-action");
            if (obj == null || ((String) (obj)).length() == 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!((String) (obj)).equals("detail"))
            {
                break; /* Loop/switch isn't completed */
            }
            s = uri.getQueryParameter("asin");
            if (s != null && s.length() != 0)
            {
                obj = a;
                Intent intent = ((Context) (obj)).getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop");
                if (intent != null)
                {
                    intent.putExtra("com.amazon.windowshop.refinement.asin", s);
                    ((Context) (obj)).startActivity(intent);
                    return true;
                }
            }
            if (true) goto _L5; else goto _L7
_L7:
            if (!((String) (obj)).equals("search"))
            {
                continue; /* Loop/switch isn't completed */
            }
            s = uri.getQueryParameter("keyword");
            if (s == null || s.length() == 0) goto _L5; else goto _L8
_L8:
            obj = a;
            Intent intent1 = new Intent("android.intent.action.SEARCH");
            intent1.setComponent(new ComponentName("com.amazon.windowshop", "com.amazon.windowshop.search.SearchResultsGridActivity"));
            intent1.putExtra("query", s);
            try
            {
                ((Context) (obj)).startActivity(intent1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return true;
            }
            return true;
            if (!((String) (obj)).equals("webview")) goto _L5; else goto _L9
_L9:
            b(s);
            return true;
            b(s);
            return true;
            UnsupportedOperationException unsupportedoperationexception;
            unsupportedoperationexception;
            if (true) goto _L11; else goto _L10
_L10:
        }

        b(Context context, ar ar1, ea ea)
        {
            a = context;
            b = ar1;
            d = ea;
        }
    }

    static final class c
        implements d
    {

        private final Context a;

        public final boolean a(String s)
        {
            dz.a(s, a);
            return true;
        }

        public c(Context context)
        {
            a = context;
        }
    }

    static interface d
    {

        public abstract boolean a(String s);
    }


    protected static final HashSet a;
    protected static Set c;
    private static final String d = com/amazon/device/ads/am.getSimpleName();
    a b;
    private final ea e;
    private final co f;
    private final cn g;
    private final Context h;
    private final HashMap i = new HashMap();
    private final ab j;
    private final f k;
    private final as l;
    private CopyOnWriteArrayList m;

    public am(Context context, ab ab1, f f1, ea ea, co co1, as as)
    {
        m = new CopyOnWriteArrayList();
        h = context;
        j = ab1;
        k = f1;
        e = ea;
        f = co1;
        g = co.a(d);
        l = as;
        b();
    }

    static f a(am am1)
    {
        return am1.k;
    }

    static String a()
    {
        return d;
    }

    private void b()
    {
        i.put("amazonmobile", new b(h, new ar(), e));
        c c1 = new c(h);
        String s;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); i.put(s, c1))
        {
            s = (String)iterator.next();
        }

    }

    public final boolean a(String s)
    {
label0:
        {
            boolean flag2 = false;
            Object obj = Uri.parse(s);
            boolean flag;
            boolean flag1;
            if (c.contains(((Uri) (obj)).getHost()) && !at.a(l))
            {
                flag1 = false;
            } else
            {
                flag1 = true;
            }
            obj = dz.b(s);
            flag = flag2;
            if (obj == null)
            {
                break label0;
            }
            if (((String) (obj)).equals("about"))
            {
                flag = flag2;
                if (s.equalsIgnoreCase("about:blank"))
                {
                    break label0;
                }
            }
            if (i.containsKey(obj))
            {
                flag = ((d)i.get(obj)).a(s);
            } else
            {
                g.b("Scheme %s unrecognized. Launching as intent.", new Object[] {
                    obj
                });
                flag = dz.a(s, h);
            }
        }
        if (flag)
        {
            return true;
        } else
        {
            return flag1;
        }
    }

    public void onLoadResource(WebView webview, String s)
    {
        m.add(s);
        g.b("Loading resource: %s", new Object[] {
            s
        });
    }

    public void onPageFinished(WebView webview, String s)
    {
        g.b("Page Finished %s", new Object[] {
            s
        });
        Iterator iterator = m.iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            String s1 = (String)iterator.next();
            ay ay1 = ay.a();
            HashSet hashset = new HashSet();
            Iterator iterator2 = ay1.c.keySet().iterator();
            do
            {
                if (!iterator2.hasNext())
                {
                    break;
                }
                String s2 = (String)iterator2.next();
                if (ay1.a(s2).matcher(s1).find())
                {
                    hashset.addAll((Collection)ay1.c.get(s2));
                }
            } while (true);
            if (hashset.size() > 0)
            {
                Iterator iterator1 = hashset.iterator();
                while (iterator1.hasNext()) 
                {
                    z z1 = ((aa)iterator1.next()).a(k);
                    if (!j.a.containsKey(z1.b()))
                    {
                        j.a(z1);
                        flag = true;
                    }
                }
            }
        }
        if (flag)
        {
            ds.c(new Runnable() {

                final am a;

                public final void run()
                {
                    e e1 = am.a(a).a.a();
                    e1.a(e1.d, e1.e, e1.f, e1.g);
                }

            
            {
                a = am.this;
                super();
            }
            });
        }
        if (flag)
        {
            return;
        }
        if (b == null)
        {
            g.c("Call to onPageFinished() ignored because listener is null.", null);
            return;
        } else
        {
            b.a(webview, s);
            return;
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i1, String s, String s1)
    {
        g.d("Error: %s", new Object[] {
            s
        });
        super.onReceivedError(webview, i1, s, s1);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return a(s);
    }

    static 
    {
        HashSet hashset = new HashSet();
        a = hashset;
        hashset.add("tel");
        a.add("voicemail");
        a.add("sms");
        a.add("mailto");
        a.add("geo");
        a.add("google.streetview");
        hashset = new HashSet();
        c = hashset;
        hashset.add("aax-us-east.amazon-adsystem.com");
        c.add("aax-us-east.amazon-adsystem.com");
        c.add("aax-beta.integ.amazon.com");
        c.add("pda-bes.amazon.com");
        c.add("d16g-cornerstone-bes.integ.amazon.com");
    }
}
