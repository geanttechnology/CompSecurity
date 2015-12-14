// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cyberlink.beautycircle.controller.activity.ShareInActivity;
import com.cyberlink.beautycircle.model.YouTubeVideoInfo;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            x, y, aa, w, 
//            z, ad

public class ShareInXmlParser
{

    private static int h;
    private static final Executor i = Executors.newFixedThreadPool(5);
    private HashSet A;
    public final String a = "connection_error";
    public final String b = "xml_parse_error";
    public final String c = "complete_tasks_successful";
    public final String d = "user_break";
    private final int e = 100;
    private final int f = 50;
    private final int g = 10;
    private z j;
    private LinkedList k;
    private LinkedList l;
    private LinkedList m;
    private w n;
    private String o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private WebView t;
    private ShareInActivity u;
    private JSParserListener v;
    private aa w;
    private boolean x;
    private boolean y;
    private int z;

    public ShareInXmlParser(ShareInActivity shareinactivity, z z1, WebView webview)
    {
        j = null;
        k = new LinkedList();
        l = new LinkedList();
        m = new LinkedList();
        n = null;
        o = null;
        p = false;
        q = 0;
        r = 0;
        s = 0;
        t = null;
        u = null;
        v = new JSParserListener();
        w = null;
        x = false;
        y = true;
        z = 0;
        A = new HashSet();
        if (e.a)
        {
            h = 100;
        } else
        {
            h = 10;
        }
        u = shareinactivity;
        j = z1;
        t = webview;
    }

    static int a(ShareInXmlParser shareinxmlparser, int i1)
    {
        shareinxmlparser.s = i1;
        return i1;
    }

    static String a(ShareInXmlParser shareinxmlparser, String s1)
    {
        shareinxmlparser.o = s1;
        return s1;
    }

    static String a(ShareInXmlParser shareinxmlparser, HttpURLConnection httpurlconnection)
    {
        return shareinxmlparser.a(httpurlconnection);
    }

    private String a(InputStream inputstream, String s1)
    {
        StringBuilder stringbuilder;
        if (s1 != null)
        {
            s1 = new BufferedReader(new InputStreamReader(inputstream, s1));
        } else
        {
            s1 = new BufferedReader(new InputStreamReader(inputstream));
        }
        stringbuilder = new StringBuilder();
        do
        {
            String s2 = s1.readLine();
            if (s2 != null)
            {
                stringbuilder.append(s2);
            } else
            {
                inputstream.close();
                return stringbuilder.toString();
            }
        } while (true);
    }

    private String a(HttpURLConnection httpurlconnection)
    {
        ByteArrayOutputStream bytearrayoutputstream;
label0:
        {
            Object obj = j(httpurlconnection.getContentType());
            httpurlconnection = httpurlconnection.getInputStream();
            bytearrayoutputstream = new ByteArrayOutputStream();
            byte abyte0[] = new byte[1024];
            do
            {
                int i1 = httpurlconnection.read(abyte0);
                if (i1 <= -1)
                {
                    break;
                }
                bytearrayoutputstream.write(abyte0, 0, i1);
            } while (true);
            bytearrayoutputstream.flush();
            String s1 = a(((InputStream) (new ByteArrayInputStream(bytearrayoutputstream.toByteArray()))), ((String) (obj)));
            httpurlconnection = s1;
            if (obj != null)
            {
                break label0;
            }
            obj = Pattern.compile("<meta.*?>").matcher(s1);
            do
            {
                do
                {
                    do
                    {
                        httpurlconnection = s1;
                        if (!((Matcher) (obj)).find())
                        {
                            break label0;
                        }
                        httpurlconnection = ((Matcher) (obj)).group().toLowerCase(Locale.US);
                    } while (!httpurlconnection.matches(".*http-equiv=\"content-type\".*"));
                    httpurlconnection = Pattern.compile("content=.*").matcher(httpurlconnection);
                } while (!httpurlconnection.find());
                httpurlconnection = i(httpurlconnection.group());
            } while (httpurlconnection == null || httpurlconnection.length() <= 0);
            httpurlconnection = j(httpurlconnection);
            httpurlconnection = a(((InputStream) (new ByteArrayInputStream(bytearrayoutputstream.toByteArray()))), ((String) (httpurlconnection)));
        }
        bytearrayoutputstream.close();
        return httpurlconnection;
    }

    static LinkedList a(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.k;
    }

    private void a(String s1)
    {
        u.runOnUiThread(new Runnable() {

            final ShareInXmlParser a;

            public void run()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "Dynamic parsing begin; ", ShareInXmlParser.g(a).e()
                });
                WebSettings websettings = ShareInXmlParser.p(a).getSettings();
                websettings.setJavaScriptEnabled(true);
                websettings.setAllowFileAccess(true);
                websettings.setLoadsImagesAutomatically(false);
                websettings.setUserAgentString("Dalvik/1.6.0 (Linux; U; Android 4.2.2)");
                ShareInXmlParser.p(a).setWebViewClient(new WebViewClient(this) {

                    final _cls1 a;

                    public void onPageFinished(WebView webview, String s1)
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            s1
                        });
                        super.onPageFinished(webview, s1);
                        ShareInXmlParser.g(a.a).c();
                    }

                    public WebResourceResponse shouldInterceptRequest(WebView webview, String s1)
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            s1
                        });
                        webview = super.shouldInterceptRequest(webview, s1);
                        if (s1 == null || !s1.contains("LOCAL_JS_TOKEN"))
                        {
                            break MISSING_BLOCK_LABEL_69;
                        }
                        s1 = new WebResourceResponse("application/javascript", "UTF8", ShareInXmlParser.r(a.a).getAssets().open("BeautyCircle/shareInParser.js"));
                        return s1;
                        s1;
                        s1.printStackTrace();
                        return webview;
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
                ShareInXmlParser.p(a).setWebChromeClient(new WebChromeClient(this) {

                    final _cls1 a;

                    public boolean onConsoleMessage(ConsoleMessage consolemessage)
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "(", Integer.valueOf(consolemessage.lineNumber()), ")", consolemessage.message()
                        });
                        return true;
                    }

                    public void onReceivedTitle(WebView webview, String s1)
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            s1
                        });
                        webview.loadUrl("javascript:(function() {\tvar s = document.createElement('script');\ts.type = 'text/javascript';\ts.src = 'LOCAL_JS_TOKEN';\tdocument.head.appendChild(s);})();", null);
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
                ShareInXmlParser.p(a).addJavascriptInterface(ShareInXmlParser.q(a), "parseEventListener");
                ShareInXmlParser.p(a).loadUrl(ShareInXmlParser.h(a));
            }

            
            {
                a = ShareInXmlParser.this;
                super();
            }
        });
    }

    private void a(String s1, String s2, String s3)
    {
        s1 = Pattern.compile("content=.*").matcher(s1);
        if (s1.find())
        {
            String s4 = i(s1.group());
            if (s4.length() != 0)
            {
                s1 = new x(this);
                s1.a = s2;
                s1.b = s4;
                s1.d = s3;
                if (s2.equals("title"))
                {
                    k.addFirst(s1);
                    return;
                }
                if (s2.equals("description"))
                {
                    l.addFirst(s1);
                    return;
                }
                if (s2.equals("image"))
                {
                    for (s2 = m.iterator(); s2.hasNext();)
                    {
                        if (((x)s2.next()).b.equalsIgnoreCase(((x) (s1)).b))
                        {
                            return;
                        }
                    }

                    m.addLast(s1);
                    return;
                }
            }
        }
    }

    private boolean a(Bitmap bitmap)
    {
        Date date;
        int i1;
        int k1;
        int l1;
        boolean flag;
        date = new Date();
        if (!bitmap.hasAlpha())
        {
            break MISSING_BLOCK_LABEL_171;
        }
        k1 = bitmap.getWidth();
        l1 = bitmap.getHeight();
        i1 = 0;
        flag = false;
_L9:
        boolean flag1 = flag;
        if (i1 >= k1) goto _L2; else goto _L1
_L1:
        int j1 = 0;
_L8:
        flag1 = flag;
        if (j1 >= l1) goto _L4; else goto _L3
_L3:
        if (Color.alpha(bitmap.getPixel(i1, j1)) == 255) goto _L6; else goto _L5
_L5:
        flag1 = true;
_L4:
        if (!flag1) goto _L7; else goto _L2
_L2:
        long l2 = (new Date()).getTime();
        long l3 = date.getTime();
        com.perfectcorp.utility.e.b(new Object[] {
            (new StringBuilder()).append("isTransparent() spent ").append(Long.toString(l2 - l3)).append(" ms").toString()
        });
        return flag1;
_L6:
        j1 += l1 / 4;
          goto _L8
_L7:
        i1 = k1 / 4 + i1;
        flag = flag1;
          goto _L9
        flag1 = false;
          goto _L2
    }

    static boolean a(ShareInXmlParser shareinxmlparser, Bitmap bitmap)
    {
        return shareinxmlparser.a(bitmap);
    }

    static boolean a(ShareInXmlParser shareinxmlparser, String s1, String s2)
    {
        return shareinxmlparser.a(s1, s2);
    }

    static boolean a(ShareInXmlParser shareinxmlparser, boolean flag)
    {
        shareinxmlparser.x = flag;
        return flag;
    }

    private boolean a(String s1, String s2)
    {
        x x1;
        if (s1 == null)
        {
            return false;
        }
        x1 = new x(this);
        x1.a = s2;
        x1.b = s1;
        if (!s2.equals("title")) goto _L2; else goto _L1
_L1:
        k.addLast(x1);
_L4:
        return true;
_L2:
        if (s2.equals("description"))
        {
            l.addLast(x1);
            continue; /* Loop/switch isn't completed */
        }
        if (!s2.equals("image"))
        {
            continue; /* Loop/switch isn't completed */
        }
        for (s1 = m.iterator(); s1.hasNext();)
        {
            if (((x)s1.next()).b.equalsIgnoreCase(x1.b))
            {
                return false;
            }
        }

        m.addLast(x1);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static int b(ShareInXmlParser shareinxmlparser, int i1)
    {
        shareinxmlparser.z = i1;
        return i1;
    }

    static z b(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.j;
    }

    static HttpURLConnection b(ShareInXmlParser shareinxmlparser, String s1)
    {
        return shareinxmlparser.b(s1);
    }

    private HttpURLConnection b(String s1)
    {
label0:
        {
            HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s1)).openConnection();
            httpurlconnection.setReadTimeout(10000);
            httpurlconnection.setConnectTimeout(15000);
            httpurlconnection.setRequestMethod("GET");
            httpurlconnection.setDoInput(true);
            httpurlconnection.connect();
            int i1 = httpurlconnection.getResponseCode();
            if (i1 != 301)
            {
                s1 = httpurlconnection;
                if (i1 != 302)
                {
                    break label0;
                }
            }
            String s2 = httpurlconnection.getHeaderField("location");
            s1 = httpurlconnection;
            if (s2 != null)
            {
                s1 = b(s2);
            }
        }
        return s1;
    }

    private void b(String s1, String s2)
    {
        String s3;
label0:
        {
            s2 = Pattern.compile(s2).matcher(s1);
            if (s2.find())
            {
                s3 = i(s2.group());
                if (s3 != null)
                {
                    break label0;
                }
            }
            return;
        }
        s2 = s3;
        if (s3.matches("data:image/.*"))
        {
            Matcher matcher = Pattern.compile("data-img=.*").matcher(s1);
            s2 = s3;
            if (matcher.find())
            {
                s2 = i(matcher.group());
            }
        }
        if (!s2.contains("http"))
        {
            Object obj = Uri.parse(o);
            String s4 = ((Uri) (obj)).getScheme();
            obj = ((Uri) (obj)).getHost();
            if (Uri.parse(s2).getHost() == null)
            {
                s2 = (new StringBuilder()).append(s4).append("://").append(((String) (obj))).append("/").append(s2).toString();
            } else
            {
                s2 = (new StringBuilder()).append(s4).append(":").append(s2).toString();
            }
        }
        if (!e(s1))
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "less than minimum image tag width or height"
            });
            return;
        }
        for (s1 = m.iterator(); s1.hasNext();)
        {
            if (((x)s1.next()).b.equalsIgnoreCase(s2))
            {
                return;
            }
        }

        s1 = new x(this);
        s1.a = "image";
        s1.b = s2;
        s1.d = "ImgTag";
        m.addLast(s1);
    }

    static int c(ShareInXmlParser shareinxmlparser, int i1)
    {
        shareinxmlparser.q = i1;
        return i1;
    }

    static LinkedList c(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.l;
    }

    private void c(String s1)
    {
        for (Matcher matcher = Pattern.compile("<meta.*?>").matcher(s1); matcher.find(); d(matcher.group())) { }
        if (!p) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (k.size() == 0)
        {
            for (Matcher matcher1 = Pattern.compile("(<title.*?>)(.+?)(</title>)").matcher(s1); matcher1.find(); f(matcher1.group())) { }
        }
        if (k.size() == 0)
        {
            for (Matcher matcher2 = Pattern.compile("(<h1.*?>)(.+?)(</h1>)").matcher(s1); matcher2.find(); g(matcher2.group())) { }
        }
        String s2;
        for (Matcher matcher3 = Pattern.compile("<img.*?>").matcher(s1); matcher3.find(); b(s2, "data-src=.*"))
        {
            s2 = matcher3.group();
            b(s2, "src=.*");
            b(s2, "_src=.*");
            b(s2, "data-original=.*");
        }

        if (l.size() == 0)
        {
            s1 = Pattern.compile("(msg_desc = \")(.*?)(\";)").matcher(s1);
            while (s1.find()) 
            {
                h(s1.group());
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    static boolean c(ShareInXmlParser shareinxmlparser, String s1)
    {
        return shareinxmlparser.k(s1);
    }

    static int d(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.s;
    }

    static int d(ShareInXmlParser shareinxmlparser, int i1)
    {
        shareinxmlparser.r = i1;
        return i1;
    }

    static void d(ShareInXmlParser shareinxmlparser, String s1)
    {
        shareinxmlparser.c(s1);
    }

    private void d(String s1)
    {
        if (s1.matches(".*og:title.*"))
        {
            a(s1, "title", "OgTag");
        }
        if (s1.matches(".*og:description.*"))
        {
            a(s1, "description", "OgTag");
        }
        if (s1.matches(".*og:image.*"))
        {
            a(s1, "image", "OgTag");
        }
        if (l.size() == 0 && s1.matches(".*name=\"description\".*"))
        {
            a(s1, "description", "MetaTag");
        }
    }

    static j e(ShareInXmlParser shareinxmlparser, String s1)
    {
        return shareinxmlparser.l(s1);
    }

    static LinkedList e(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.m;
    }

    private boolean e(String s1)
    {
        return true;
    }

    static HashSet f(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.A;
    }

    static void f(ShareInXmlParser shareinxmlparser, String s1)
    {
        shareinxmlparser.a(s1);
    }

    private void f(String s1)
    {
        s1 = s1.replaceAll("(<title.*?>)(.+?)(</title>)", "$2");
        x x1 = new x(this);
        x1.a = "title";
        x1.b = s1;
        x1.d = "TitleTag";
        k.addLast(x1);
    }

    static aa g(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.w;
    }

    private void g(String s1)
    {
        s1 = s1.replaceAll("(<h1.*?>)(.+?)(</h1>)", "$2");
        x x1 = new x(this);
        x1.a = "title";
        x1.b = s1;
        x1.d = "H1Tag";
        k.addLast(x1);
    }

    static int h()
    {
        return h;
    }

    static String h(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.o;
    }

    private void h(String s1)
    {
        s1 = s1.replaceAll("(msg_desc = \")(.*?)(\";)", "$2");
        x x1 = new x(this);
        x1.a = "description";
        x1.b = s1;
        x1.d = "weixin";
        l.addLast(x1);
    }

    private String i(String s1)
    {
        int j1 = s1.indexOf('"');
        int i1 = j1;
        if (j1 == -1)
        {
            j1 = s1.indexOf('\'');
            i1 = j1;
            if (j1 == -1)
            {
                return null;
            }
        }
        int k1 = s1.indexOf('"', i1 + 1);
        j1 = k1;
        if (k1 == -1)
        {
            j1 = s1.indexOf('\'', i1 + 1);
        }
        if (j1 == -1)
        {
            return s1.substring(i1);
        } else
        {
            return s1.substring(i1 + 1, j1);
        }
    }

    static Executor i()
    {
        return i;
    }

    static boolean i(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.x;
    }

    private String j(String s1)
    {
        String s2;
        Object obj;
        s2 = null;
        obj = null;
        if (s1 != null) goto _L2; else goto _L1
_L1:
        s2 = obj;
_L4:
        return s2;
_L2:
        String as[] = s1.split(";");
        int j1 = as.length;
        int i1 = 0;
        s1 = s2;
        do
        {
            s2 = s1;
            if (i1 >= j1)
            {
                continue;
            }
            s2 = as[i1].trim();
            if (s2.toLowerCase(Locale.US).startsWith("charset="))
            {
                s1 = s2.substring("charset=".length());
            }
            i1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void j()
    {
        com.perfectcorp.utility.e.b(new Object[0]);
        HashSet hashset = A;
        hashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = A.iterator(); iterator.hasNext(); ((y)iterator.next()).cancel(true)) { }
        break MISSING_BLOCK_LABEL_54;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
        A.clear();
        return;
    }

    static boolean j(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.y;
    }

    static int k(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.q;
    }

    private boolean k(String s1)
    {
        if (s1 == null)
        {
            return false;
        } else
        {
            return s1.split("/")[0].equalsIgnoreCase("image");
        }
    }

    static int l(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.r;
    }

    private j l(String s1)
    {
        return (new j() {

            final ShareInXmlParser a;

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s2)
            {
                Object obj;
                String s3 = String.format(Locale.getDefault(), ad.c, new Object[] {
                    s2, "snippet"
                });
                com.perfectcorp.utility.e.b(new Object[] {
                    (new StringBuilder()).append("Youtube videoDataApi = ").append(s3).toString()
                });
                com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item.Snippet.Thumbnail thumbnail;
                Iterator iterator;
                int i1;
                try
                {
                    s2 = (HttpURLConnection)(new URL(s3)).openConnection();
                    s2.setRequestMethod("GET");
                    s2.setRequestProperty("Referer", "http://bc.perfectcorp.com/share_in");
                    s2.connect();
                    i1 = s2.getResponseCode();
                }
                // Misplaced declaration of an exception variable
                catch (String s2)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Youtube MalformedURLException: ", s3
                    });
                    s2.printStackTrace();
                    return null;
                }
                // Misplaced declaration of an exception variable
                catch (String s2)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Youtube IOException: cannot open connection: ", s3
                    });
                    s2.printStackTrace();
                    return null;
                }
                if (i1 >= 200 && i1 < 300)
                {
                    break MISSING_BLOCK_LABEL_126;
                }
                com.perfectcorp.utility.e.b(new Object[] {
                    "Youtube code < 200 || code >= 300"
                });
                return null;
                s2 = ShareInXmlParser.a(a, s2);
                com.perfectcorp.utility.e.b(new Object[] {
                    (new StringBuilder()).append("Youtube json = ").append(s2).toString()
                });
                obj = ((com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item)((YouTubeVideoInfo)Model.a(com/cyberlink/beautycircle/model/YouTubeVideoInfo, s2)).items.get(0)).snippet;
                com.perfectcorp.utility.e.b(new Object[] {
                    (new StringBuilder()).append("Youtube title = ").append(((com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item.Snippet) (obj)).title).toString()
                });
                s2 = new x(a);
                s2.a = "title";
                s2.b = ((com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item.Snippet) (obj)).title;
                s2.d = "YouTubeDataAPIv3";
                ShareInXmlParser.a(a).addFirst(s2);
                com.perfectcorp.utility.e.b(new Object[] {
                    (new StringBuilder()).append("Youtube description = ").append(((com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item.Snippet) (obj)).description).toString()
                });
                s2 = new x(a);
                s2.a = "description";
                s2.b = ((com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item.Snippet) (obj)).description;
                s2.d = "YouTubeDataAPIv3";
                ShareInXmlParser.c(a).addFirst(s2);
                s2 = (com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item.Snippet.Thumbnail)((com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item.Snippet) (obj)).thumbnails.get("maxres");
                if (s2 != null)
                {
                    break MISSING_BLOCK_LABEL_532;
                }
                iterator = ((com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item.Snippet) (obj)).thumbnails.values().iterator();
_L2:
                obj = s2;
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_421;
                }
                thumbnail = (com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item.Snippet.Thumbnail)iterator.next();
                if (thumbnail == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                obj = thumbnail;
                if (s2 == null)
                {
                    break MISSING_BLOCK_LABEL_527;
                }
                if (s2.b() < thumbnail.b())
                {
                    obj = thumbnail;
                } else
                {
                    obj = s2;
                }
                break MISSING_BLOCK_LABEL_527;
                for (; obj == null; obj = s2)
                {
                    break MISSING_BLOCK_LABEL_525;
                }

                s2 = new x(a);
                s2.a = "image";
                s2.b = ((com.cyberlink.beautycircle.model.YouTubeVideoInfo.Item.Snippet.Thumbnail) (obj)).url;
                s2.d = "YouTubeDataAPIv3";
                com.cyberlink.beautycircle.utility.ShareInXmlParser.e(a).addLast(s2);
                return null;
                return null;
                s2 = ((String) (obj));
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                a = ShareInXmlParser.this;
                super();
            }
        }).d(s1);
    }

    static int m(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.z;
    }

    static int n(ShareInXmlParser shareinxmlparser)
    {
        int i1 = shareinxmlparser.s + 1;
        shareinxmlparser.s = i1;
        return i1;
    }

    static void o(ShareInXmlParser shareinxmlparser)
    {
        shareinxmlparser.j();
    }

    static WebView p(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.t;
    }

    static JSParserListener q(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.v;
    }

    static ShareInActivity r(ShareInXmlParser shareinxmlparser)
    {
        return shareinxmlparser.u;
    }

    public int a()
    {
        return k.size();
    }

    public boolean a(String s1, boolean flag)
    {
        if (j != null)
        {
            com.perfectcorp.utility.e.b(new Object[0]);
            p = flag;
            w = new aa(this);
            n = new w(this);
            if (n != null)
            {
                n.execute(new String[] {
                    s1
                });
                return true;
            }
        }
        return false;
    }

    public int b()
    {
        return l.size();
    }

    public int c()
    {
        return m.size();
    }

    public int d()
    {
        return q;
    }

    public int e()
    {
        return r;
    }

    public void f()
    {
        j = null;
    }

    public void g()
    {
        m.clear();
        l.clear();
        k.clear();
        o = null;
        p = false;
        z = 0;
        j();
    }


    private class JSParserListener
    {

        protected boolean a;
        protected Handler b;
        final ShareInXmlParser c;
        private Runnable d;

        public void a()
        {
            a = false;
            b.removeCallbacks(d);
            b.postDelayed(d, 2000L);
        }

        public void onAddImage(String s1)
        {
            if (ShareInXmlParser.d(c) >= ShareInXmlParser.h())
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "Norma cleared; Do nothing."
                });
                return;
            }
            com.perfectcorp.utility.e.b(new Object[] {
                s1
            });
            if (ShareInXmlParser.a(c, s1, "image"))
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "[", Integer.valueOf(com.cyberlink.beautycircle.utility.ShareInXmlParser.e(c).size() - 1), "]", s1
                });
                (new y(c)).a(com.cyberlink.beautycircle.utility.ShareInXmlParser.e(c).size() - 1);
            }
            a();
        }

        public void onParseCompleted(String s1, String s2)
        {
            s1 = new JSONArray(s1);
            int i1 = 0;
_L2:
            if (i1 >= s1.length())
            {
                break; /* Loop/switch isn't completed */
            }
            ShareInXmlParser.a(c, s1.getString(i1), "title");
            i1++;
            if (true) goto _L2; else goto _L1
            s1;
            s1.printStackTrace();
_L1:
            s1 = new JSONArray(s2);
            i1 = 0;
_L4:
            if (i1 >= s1.length())
            {
                break; /* Loop/switch isn't completed */
            }
            ShareInXmlParser.a(c, s1.getString(i1), "description");
            i1++;
            if (true) goto _L4; else goto _L3
            s1;
            s1.printStackTrace();
_L3:
            a();
            while (!ShareInXmlParser.a(c).isEmpty() && ShareInXmlParser.b(c).a((x)ShareInXmlParser.a(c).getFirst()) || ShareInXmlParser.c(c).isEmpty() || !ShareInXmlParser.b(c).a((x)ShareInXmlParser.c(c).getFirst())) 
            {
                return;
            }
            return;
        }

        JSParserListener()
        {
            c = ShareInXmlParser.this;
            super();
            a = false;
            b = new Handler(Looper.getMainLooper());
            d = new Runnable() {

                final JSParserListener a;

                public void run()
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "OnNoMoreImage"
                    });
                    a.a = true;
                    if (ShareInXmlParser.d(a.c) > ShareInXmlParser.h())
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "Norma cleared; Do nothing."
                        });
                        return;
                    }
                    synchronized (ShareInXmlParser.f(a.c))
                    {
                        if (!ShareInXmlParser.f(a.c).isEmpty())
                        {
                            break MISSING_BLOCK_LABEL_149;
                        }
                        com.perfectcorp.utility.e.b(new Object[] {
                            "All tasks done.  onParseCompleted."
                        });
                        if (ShareInXmlParser.b(a.c) != null)
                        {
                            ShareInXmlParser.b(a.c).a(ShareInXmlParser.g(a.c));
                        }
                        a.c.g();
                    }
                    return;
                    exception;
                    hashset;
                    JVM INSTR monitorexit ;
                    throw exception;
                    hashset;
                    JVM INSTR monitorexit ;
                    com.perfectcorp.utility.e.b(new Object[] {
                        "There are remaining tasks."
                    });
                    return;
                }

                
                {
                    a = JSParserListener.this;
                    super();
                }
            };
        }
    }

}
