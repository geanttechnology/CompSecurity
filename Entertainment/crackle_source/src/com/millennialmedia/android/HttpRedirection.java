// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            OverlaySettings, AdViewOverlayActivity, VideoAd

final class HttpRedirection
{
    private static interface Listener
    {

        public abstract boolean canOpenOverlay();

        public abstract OverlaySettings getOverlaySettings();

        public abstract boolean isActivityStartable(Uri uri);

        public abstract boolean isExpandingToUrl();

        public abstract boolean isHandlingMMVideo(Uri uri);

        public abstract void startingActivity(Uri uri);

        public abstract void startingVideo();

        public abstract void updateLastVideoViewedTime();
    }

    static class RedirectionListenerImpl
        implements Listener
    {

        long creatorAdImplInternalId;
        Uri destinationUri;
        String orientation;
        String url;
        WeakReference weakContext;

        public boolean canOpenOverlay()
        {
            return false;
        }

        public JSONObject getAdProperties()
        {
            return null;
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
            MMSDK.Log.d("Starting activity for %s", new Object[] {
                uri
            });
        }

        public void startingVideo()
        {
        }

        public void updateLastVideoViewedTime()
        {
        }

        RedirectionListenerImpl()
        {
        }
    }


    private static final String HEADER_LOCATION = "Location";
    private static final String HTTPS = "https";
    private static final String LOG_URL_FORMAT = "Redirecting to: %s";
    private static final String METHOD_GET = "GET";

    HttpRedirection()
    {
    }

    static final String navigateRedirects(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        String s5 = null;
_L4:
        return s5;
_L2:
        HttpURLConnection.setFollowRedirects(false);
_L7:
        String s1;
        String s2;
        String s3;
        String s4;
        s5 = s;
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        if (s.startsWith("https")) goto _L4; else goto _L3
_L3:
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
        ((HttpURLConnection) (obj)).setConnectTimeout(3000);
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
        s5 = s;
        if (i < 300) goto _L4; else goto _L5
_L5:
        s5 = s;
        if (i >= 400) goto _L4; else goto _L6
_L6:
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        s5 = ((HttpURLConnection) (obj)).getHeaderField("Location");
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        obj = new URI(s5);
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        if (((URI) (obj)).isAbsolute())
        {
            break MISSING_BLOCK_LABEL_264;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        s = url.toURI().resolve(((URI) (obj))).toString();
_L8:
        s1 = s;
        s2 = s;
        s3 = s;
        s4 = s;
        try
        {
            MMSDK.Log.v("Redirecting to: %s", new Object[] {
                s
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return s1;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMSDK.Log.d("Connection timeout.");
            return s2;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return s4;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MMSDK.Log.d("URI Syntax incorrect.");
            return s3;
        }
          goto _L7
        if (s5 != null)
        {
            s = s5;
        }
          goto _L8
    }

    static void startActivityFromUri(RedirectionListenerImpl redirectionlistenerimpl)
    {
        if (redirectionlistenerimpl == null || redirectionlistenerimpl.url == null || redirectionlistenerimpl.weakContext == null)
        {
            return;
        } else
        {
            Utils.ThreadUtils.execute(new Runnable(new WeakReference(redirectionlistenerimpl)) {

                final WeakReference val$listenerReference;

                private void handleDestinationUri(RedirectionListenerImpl redirectionlistenerimpl1)
                {
                    Object obj1;
                    Context context;
                    obj1 = null;
                    context = (Context)redirectionlistenerimpl1.weakContext.get();
                    if (context == null) goto _L2; else goto _L1
_L1:
                    Object obj;
                    String s;
                    s = redirectionlistenerimpl1.destinationUri.getScheme();
                    obj = obj1;
                    if (s == null) goto _L4; else goto _L3
_L3:
                    if (s.equalsIgnoreCase("mmvideo")) goto _L6; else goto _L5
_L5:
                    obj = Utils.IntentUtils.getIntentForUri(redirectionlistenerimpl1);
_L4:
                    if (obj == null) goto _L2; else goto _L7
_L7:
                    obj1 = redirectionlistenerimpl1.getOverlaySettings();
                    if (obj != null && obj1 != null)
                    {
                        if (redirectionlistenerimpl1.orientation != null)
                        {
                            obj1.orientation = redirectionlistenerimpl1.orientation;
                        }
                        ((Intent) (obj)).putExtra("settings", ((android.os.Parcelable) (obj1)));
                    }
                    obj1 = ((Intent) (obj)).getStringExtra("class");
                    if (obj1 != null && ((String) (obj1)).equals(com/millennialmedia/android/AdViewOverlayActivity.getCanonicalName())) goto _L2; else goto _L8
_L8:
                    if (redirectionlistenerimpl1.isActivityStartable(redirectionlistenerimpl1.destinationUri))
                    {
                        Utils.IntentUtils.startActivity(context, ((Intent) (obj)));
                        redirectionlistenerimpl1.startingActivity(redirectionlistenerimpl1.destinationUri);
                    }
_L2:
                    return;
_L6:
                    obj = obj1;
                    if (!redirectionlistenerimpl1.isHandlingMMVideo(redirectionlistenerimpl1.destinationUri))
                    {
                        VideoAd.playAd(context, redirectionlistenerimpl1.destinationUri.getHost(), redirectionlistenerimpl1);
                        obj = obj1;
                    }
                    if (true) goto _L4; else goto _L9
_L9:
                    ActivityNotFoundException activitynotfoundexception;
                    activitynotfoundexception;
                    MMSDK.Log.e("No activity found for %s", new Object[] {
                        redirectionlistenerimpl1.destinationUri
                    });
                    return;
                }

                public void run()
                {
                    String s;
label0:
                    {
                        RedirectionListenerImpl redirectionlistenerimpl1 = (RedirectionListenerImpl)listenerReference.get();
                        if (redirectionlistenerimpl1 != null)
                        {
                            s = HttpRedirection.navigateRedirects(redirectionlistenerimpl1.url);
                            if (s != null)
                            {
                                redirectionlistenerimpl1.destinationUri = Uri.parse(s);
                                if (redirectionlistenerimpl1.destinationUri == null)
                                {
                                    break label0;
                                }
                                handleDestinationUri(redirectionlistenerimpl1);
                            }
                        }
                        return;
                    }
                    MMSDK.Log.v("Could not start activity for %s", new Object[] {
                        s
                    });
                }

            
            {
                listenerReference = weakreference;
                super();
            }
            });
            return;
        }
    }
}
