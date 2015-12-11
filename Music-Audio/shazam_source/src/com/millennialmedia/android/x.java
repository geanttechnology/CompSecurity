// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// Referenced classes of package com.millennialmedia.android:
//            al, OverlaySettings, d, MMActivity, 
//            VideoAd

final class x
{
    static class a
    {

        String a;
        WeakReference b;
        Uri c;
        String d;
        long e;

        public boolean a()
        {
            return false;
        }

        public boolean a(Uri uri)
        {
            return false;
        }

        public OverlaySettings b()
        {
            return null;
        }

        public void b(Uri uri)
        {
            String.format("Starting activity for %s", new Object[] {
                uri
            });
            al.b();
        }

        public void c()
        {
        }

        public boolean d()
        {
            return true;
        }

        public a()
        {
        }
    }


    static final String a(String s)
    {
        if (s == null)
        {
            return null;
        }
        HttpURLConnection.setFollowRedirects(false);
_L9:
        String s1;
        String s2;
        String s3;
        String s4;
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        if (s.startsWith("https")) goto _L2; else goto _L1
_L1:
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        URL url = new URL(s);
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        Object obj = (HttpURLConnection)url.openConnection();
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        ((HttpURLConnection) (obj)).setConnectTimeout(10000);
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        ((HttpURLConnection) (obj)).setRequestMethod("GET");
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        ((HttpURLConnection) (obj)).connect();
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        int i = ((HttpURLConnection) (obj)).getResponseCode();
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        obj = ((HttpURLConnection) (obj)).getHeaderField("Location");
        if (i < 300 || i >= 400) goto _L2; else goto _L3
_L3:
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L2; else goto _L4
_L4:
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        URI uri = new URI(((String) (obj)));
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        if (uri.isAbsolute()) goto _L6; else goto _L5
_L5:
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        s = url.toURI().resolve(uri).toString();
_L7:
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        String.format("Redirecting to: %s", new Object[] {
            s
        });
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        try
        {
            al.a();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            al.a("HttpRedirection", "Bad url scheme", s);
            return s1;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            al.a("HttpRedirection", "Connection timeout.", s);
            return s2;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            al.a("HttpRedirection", "IOException following redirects: ", s);
            return s3;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            al.a("HttpRedirection", "URI Syntax incorrect.", s);
            return s4;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (obj != null)
        {
            s = ((String) (obj));
        }
        if (true) goto _L7; else goto _L2
_L2:
        return s;
        if (true) goto _L9; else goto _L8
_L8:
    }

    // Unreferenced inner class com/millennialmedia/android/x$1

/* anonymous class */
    static final class _cls1
        implements Runnable
    {

        final WeakReference a;

        public final void run()
        {
            Object obj1;
            a a1;
            obj1 = null;
            a1 = (a)a.get();
            if (a1 == null) goto _L2; else goto _L1
_L1:
            Object obj = x.a(a1.a);
            if (obj == null) goto _L2; else goto _L3
_L3:
            a1.c = Uri.parse(((String) (obj)));
            if (a1.c == null) goto _L5; else goto _L4
_L4:
            Context context = (Context)a1.b.get();
            if (context == null) goto _L2; else goto _L6
_L6:
            Object obj2;
            obj2 = a1.c.getScheme();
            obj = obj1;
            if (obj2 == null) goto _L8; else goto _L7
_L7:
            if (((String) (obj2)).equalsIgnoreCase("mmvideo")) goto _L10; else goto _L9
_L9:
            if (a1 != null) goto _L12; else goto _L11
_L11:
            obj = obj1;
_L8:
            if (obj == null) goto _L2; else goto _L13
_L13:
            obj1 = a1.b();
            if (obj != null && obj1 != null)
            {
                if (a1.d != null)
                {
                    obj1.g = a1.d;
                }
                ((Intent) (obj)).putExtra("settings", ((android.os.Parcelable) (obj1)));
            }
            obj1 = ((Intent) (obj)).getStringExtra("class");
            if (obj1 != null && ((String) (obj1)).equals(com/millennialmedia/android/d.getCanonicalName())) goto _L2; else goto _L14
_L14:
            if (a1.d())
            {
                au.b.b(context, ((Intent) (obj)));
                a1.b(a1.c);
            }
_L2:
            return;
_L12:
            Context context1;
            obj2 = a1.c;
            context1 = (Context)a1.b.get();
            if (context1 == null) goto _L16; else goto _L15
_L15:
            if (obj2 == null) goto _L18; else goto _L17
_L17:
            obj = ((Uri) (obj2)).getScheme();
            if (obj == null) goto _L18; else goto _L19
_L19:
            if (((String) (obj)).equalsIgnoreCase("market"))
            {
                al.a();
                obj = new Intent("android.intent.action.VIEW", ((Uri) (obj2)));
                an.a.a(context1, "market", a1.e);
            } else
            if (((String) (obj)).equalsIgnoreCase("rtsp"))
            {
                al.a();
                obj = new Intent(context1, com/millennialmedia/android/MMActivity);
                ((Intent) (obj)).setData(((Uri) (obj2)));
                ((Intent) (obj)).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
            } else
            if (((String) (obj)).equalsIgnoreCase("tel"))
            {
                al.a();
                obj = new Intent("android.intent.action.DIAL", ((Uri) (obj2)));
                an.a.a(context1, "tel", a1.e);
            } else
            if (((String) (obj)).equalsIgnoreCase("sms"))
            {
                al.a();
                String s = ((Uri) (obj2)).getSchemeSpecificPart();
                obj1 = "";
                int i = s.indexOf("?body=");
                obj = obj1;
                if (i != -1)
                {
                    obj = obj1;
                    if (s.length() > i)
                    {
                        obj = s.substring(0, i).replace(',', ';');
                    }
                }
                obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("sms:")).append(((String) (obj))).toString()));
                if (i == -1)
                {
                    ((Intent) (obj)).putExtra("sms_body", s.substring(i + 6));
                }
                an.a.a(context1, "sms", a1.e);
            } else
            if (((String) (obj)).equalsIgnoreCase("mailto"))
            {
                obj = new Intent("android.intent.action.VIEW", ((Uri) (obj2)));
                an.a.a(context1, "email", a1.e);
            } else
            if (((String) (obj)).equalsIgnoreCase("geo"))
            {
                al.a();
                obj = new Intent("android.intent.action.VIEW", ((Uri) (obj2)));
                an.a.a(context1, "geo", a1.e);
            } else
            if (((String) (obj)).equalsIgnoreCase("https"))
            {
                al.a();
                obj = new Intent("android.intent.action.VIEW", ((Uri) (obj2)));
                an.a.a(context1, "browser", a1.e);
            } else
            if (((String) (obj)).equalsIgnoreCase("mmbrowser"))
            {
                obj1 = ((Uri) (obj2)).toString().substring(12);
                obj = obj1;
                if (obj1 != null)
                {
                    obj = obj1;
                    if (!((String) (obj1)).contains("://"))
                    {
                        obj = ((String) (obj1)).replaceFirst("//", "://");
                    }
                }
                al.a();
                obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
                an.a.a(context1, "browser", a1.e);
            } else
            if (((String) (obj)).equalsIgnoreCase("http"))
            {
                if (((Uri) (obj2)).getLastPathSegment() != null && (((Uri) (obj2)).getLastPathSegment().endsWith(".mp4") || ((Uri) (obj2)).getLastPathSegment().endsWith(".3gp")))
                {
                    al.a();
                    obj = new Intent(context1, com/millennialmedia/android/MMActivity);
                    ((Intent) (obj)).setData(((Uri) (obj2)));
                    ((Intent) (obj)).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
                    an.a.a(context1, "streamingVideo", a1.e);
                } else
                {
                    al.a();
                    an.a.a(context1, "browser", a1.e);
                    obj = new Intent("android.intent.action.VIEW", ((Uri) (obj2)));
                }
            } else
            {
                String.format("Creating intent for unrecognized URI. %s", new Object[] {
                    obj2
                });
                al.a();
                obj = new Intent("android.intent.action.VIEW", ((Uri) (obj2)));
            }
_L20:
            if (obj != null)
            {
                String.format("%s resolved to Intent: %s", new Object[] {
                    obj2, obj
                });
                al.a();
            } else
            {
                String.format("%s", new Object[] {
                    obj2
                });
                al.a();
            }
            continue; /* Loop/switch isn't completed */
_L10:
            obj = obj1;
            if (!a1.a(a1.c))
            {
                VideoAd.a(context, a1.c.getHost(), a1);
                obj = obj1;
            }
            continue; /* Loop/switch isn't completed */
            obj;
            al.a("HttpRedirection", String.format("No activity found for %s", new Object[] {
                a1.c
            }), ((Throwable) (obj)));
            return;
_L5:
            al.a("HttpRedirection", String.format("Could not start activity for %s", new Object[] {
                obj
            }));
            return;
_L18:
            obj = null;
            if (true) goto _L20; else goto _L16
_L16:
            obj = null;
            if (true) goto _L8; else goto _L21
_L21:
        }

            
            {
                a = weakreference;
                super();
            }
    }

}
