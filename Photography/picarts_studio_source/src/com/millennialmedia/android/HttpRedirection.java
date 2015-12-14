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
//            MMLog, OverlaySettings, AdViewOverlayActivity, VideoAd

final class HttpRedirection
{

    HttpRedirection()
    {
    }

    static final String a(String s)
    {
        if (s == null)
        {
            return null;
        }
        HttpURLConnection.setFollowRedirects(false);
_L3:
        String s1;
        String s2;
        String s3;
        String s4;
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        if (s.startsWith("https"))
        {
            break MISSING_BLOCK_LABEL_292;
        }
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
        if (i < 300 || i >= 400)
        {
            break MISSING_BLOCK_LABEL_292;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_292;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        URI uri = new URI(((String) (obj)));
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        if (uri.isAbsolute()) goto _L2; else goto _L1
_L1:
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        s = url.toURI().resolve(uri).toString();
_L4:
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        try
        {
            MMLog.a("HttpRedirection", String.format("Redirecting to: %s", new Object[] {
                s
            }));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.a("HttpRedirection", "Bad url scheme", s);
            return s1;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.a("HttpRedirection", "Connection timeout.", s);
            return s2;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.a("HttpRedirection", "IOException following redirects: ", s);
            return s3;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMLog.a("HttpRedirection", "URI Syntax incorrect.", s);
            return s4;
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (obj != null)
        {
            s = ((String) (obj));
        }
          goto _L4
        return s;
    }

    static void a(RedirectionListenerImpl redirectionlistenerimpl)
    {
        if (redirectionlistenerimpl == null || redirectionlistenerimpl.a == null || redirectionlistenerimpl.b == null)
        {
            return;
        } else
        {
            Utils.ThreadUtils.a(new Runnable(new WeakReference(redirectionlistenerimpl)) {

                private WeakReference a;

                public final void run()
                {
                    RedirectionListenerImpl redirectionlistenerimpl1 = (RedirectionListenerImpl)a.get();
                    if (redirectionlistenerimpl1 == null) goto _L2; else goto _L1
_L1:
                    Object obj = HttpRedirection.a(redirectionlistenerimpl1.a);
                    if (obj == null) goto _L2; else goto _L3
_L3:
                    Object obj1;
                    Context context;
                    redirectionlistenerimpl1.c = Uri.parse(((String) (obj)));
                    if (redirectionlistenerimpl1.c == null)
                    {
                        break MISSING_BLOCK_LABEL_236;
                    }
                    obj1 = null;
                    context = (Context)redirectionlistenerimpl1.b.get();
                    if (context == null) goto _L2; else goto _L4
_L4:
                    String s;
                    s = redirectionlistenerimpl1.c.getScheme();
                    obj = obj1;
                    if (s == null) goto _L6; else goto _L5
_L5:
                    if (s.equalsIgnoreCase("mmvideo")) goto _L8; else goto _L7
_L7:
                    obj = Utils.IntentUtils.a(redirectionlistenerimpl1);
_L6:
                    if (obj == null) goto _L2; else goto _L9
_L9:
                    obj1 = redirectionlistenerimpl1.getOverlaySettings();
                    if (obj != null && obj1 != null)
                    {
                        if (redirectionlistenerimpl1.d != null)
                        {
                            obj1.f = redirectionlistenerimpl1.d;
                        }
                        ((Intent) (obj)).putExtra("settings", ((android.os.Parcelable) (obj1)));
                    }
                    obj1 = ((Intent) (obj)).getStringExtra("class");
                    if (obj1 != null && ((String) (obj1)).equals(com/millennialmedia/android/AdViewOverlayActivity.getCanonicalName())) goto _L2; else goto _L10
_L10:
                    if (redirectionlistenerimpl1.isActivityStartable(redirectionlistenerimpl1.c))
                    {
                        Utils.IntentUtils.c(context, ((Intent) (obj)));
                        redirectionlistenerimpl1.startingActivity(redirectionlistenerimpl1.c);
                    }
_L2:
                    return;
_L8:
                    obj = obj1;
                    if (!redirectionlistenerimpl1.isHandlingMMVideo(redirectionlistenerimpl1.c))
                    {
                        VideoAd.playAd(context, redirectionlistenerimpl1.c.getHost(), redirectionlistenerimpl1);
                        obj = obj1;
                    }
                    if (true) goto _L6; else goto _L11
_L11:
                    obj;
                    MMLog.a("HttpRedirection", String.format("No activity found for %s", new Object[] {
                        redirectionlistenerimpl1.c
                    }), ((Throwable) (obj)));
                    return;
                    MMLog.e("HttpRedirection", String.format("Could not start activity for %s", new Object[] {
                        obj
                    }));
                    return;
                }

            
            {
                a = weakreference;
                super();
            }
            });
            return;
        }
    }

    private class RedirectionListenerImpl
        implements Listener
    {

        String a;
        WeakReference b;
        Uri c;
        String d;
        long e;

        public boolean canOpenOverlay()
        {
            return false;
        }

        public OverlaySettings getOverlaySettings()
        {
            return null;
        }

        public boolean isActivityStartable(Uri uri)
        {
            return true;
        }

        public boolean isExpandingToUrl()
        {
            return false;
        }

        public boolean isHandlingMMVideo(Uri uri)
        {
            return false;
        }

        public void startingActivity(Uri uri)
        {
            MMLog.b("HttpRedirection", String.format("Starting activity for %s", new Object[] {
                uri
            }));
        }

        public void startingVideo()
        {
        }

        public void updateLastVideoViewedTime()
        {
        }

        public RedirectionListenerImpl()
        {
        }
    }

}
