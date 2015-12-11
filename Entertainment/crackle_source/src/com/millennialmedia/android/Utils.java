// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.millennialmedia.android:
//            MMActivity, AdViewOverlayActivity

class Utils
{
    static class HttpUtils
    {

        static void executeUrl(String s)
        {
            ThreadUtils.execute(new Runnable(s) {

                final String val$url;

                public void run()
                {
                    try
                    {
                        (new DefaultHttpClient()).execute(new HttpGet(url));
                        MMSDK.Log.d((new StringBuilder()).append("Executed Url :\"").append(url).append("\"").toString());
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        MMSDK.Log.e(ioexception);
                    }
                }

            
            {
                url = s;
                super();
            }
            });
        }

        HttpUtils()
        {
        }
    }

    static class IntentUtils
    {

        private static void fixDataAndTypeForVideo(Context context, Intent intent)
        {
            context = intent.getData();
            if (context != null)
            {
                context = context.getLastPathSegment();
                if (TextUtils.isEmpty(intent.getStringExtra("class")) && !TextUtils.isEmpty(context) && (context.endsWith(".mp4") || context.endsWith(".3gp") || context.endsWith(".mkv") || context.endsWith("content.once")))
                {
                    intent.setDataAndType(intent.getData(), "video/*");
                }
            }
        }

        static Intent getIntentForUri(HttpRedirection.RedirectionListenerImpl redirectionlistenerimpl)
        {
            if (redirectionlistenerimpl != null)
            {
                Object obj1 = null;
                Uri uri = redirectionlistenerimpl.destinationUri;
                Context context = (Context)redirectionlistenerimpl.weakContext.get();
                if (context != null)
                {
                    Object obj = obj1;
                    if (uri != null)
                    {
                        String s1 = uri.getScheme();
                        obj = obj1;
                        if (s1 != null)
                        {
                            if (s1.equalsIgnoreCase("market"))
                            {
                                MMSDK.Log.v("Creating Android Market intent.");
                                obj = new Intent("android.intent.action.VIEW", uri);
                                MMSDK.Event.intentStarted(context, "market", redirectionlistenerimpl.creatorAdImplInternalId);
                            } else
                            if (s1.equalsIgnoreCase("rtsp"))
                            {
                                MMSDK.Log.v("Creating streaming video player intent.");
                                obj = new Intent(context, com/millennialmedia/android/MMActivity);
                                ((Intent) (obj)).setData(uri);
                                ((Intent) (obj)).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
                            } else
                            if (s1.equalsIgnoreCase("tel"))
                            {
                                MMSDK.Log.v("Creating telephone intent.");
                                obj = new Intent("android.intent.action.DIAL", uri);
                                MMSDK.Event.intentStarted(context, "tel", redirectionlistenerimpl.creatorAdImplInternalId);
                            } else
                            if (s1.equalsIgnoreCase("sms"))
                            {
                                MMSDK.Log.v("Creating txt message intent.");
                                Intent intent = new Intent("android.intent.action.VIEW");
                                s1 = uri.getSchemeSpecificPart();
                                int i = s1.indexOf("?body=");
                                obj = s1;
                                if (i != -1)
                                {
                                    obj = s1.substring(0, i);
                                }
                                intent.putExtra("address", ((String) (obj)).replace(',', ';'));
                                if (i != -1)
                                {
                                    intent.putExtra("sms_body", uri.getSchemeSpecificPart().substring(i + 6));
                                }
                                intent.setType("vnd.android-dir/mms-sms");
                                MMSDK.Event.intentStarted(context, "sms", redirectionlistenerimpl.creatorAdImplInternalId);
                                obj = intent;
                            } else
                            if (s1.equalsIgnoreCase("mailto"))
                            {
                                obj = new Intent("android.intent.action.VIEW", uri);
                                MMSDK.Event.intentStarted(context, "email", redirectionlistenerimpl.creatorAdImplInternalId);
                            } else
                            if (s1.equalsIgnoreCase("geo"))
                            {
                                MMSDK.Log.v("Creating Google Maps intent.");
                                obj = new Intent("android.intent.action.VIEW", uri);
                                MMSDK.Event.intentStarted(context, "geo", redirectionlistenerimpl.creatorAdImplInternalId);
                            } else
                            if (s1.equalsIgnoreCase("https"))
                            {
                                MMSDK.Log.v("Creating launch browser intent.");
                                obj = new Intent("android.intent.action.VIEW", uri);
                                MMSDK.Event.intentStarted(context, "browser", redirectionlistenerimpl.creatorAdImplInternalId);
                            } else
                            if (s1.equalsIgnoreCase("mmbrowser"))
                            {
                                String s = uri.toString().substring(12);
                                obj = s;
                                if (s != null)
                                {
                                    obj = s;
                                    if (!s.contains("://"))
                                    {
                                        obj = s.replaceFirst("//", "://");
                                    }
                                }
                                MMSDK.Log.v("MMBrowser - Creating launch browser intent.");
                                obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
                                MMSDK.Event.intentStarted(context, "browser", redirectionlistenerimpl.creatorAdImplInternalId);
                            } else
                            if (s1.equalsIgnoreCase("http"))
                            {
                                if (uri.getLastPathSegment() != null && (uri.getLastPathSegment().endsWith(".mp4") || uri.getLastPathSegment().endsWith(".3gp")))
                                {
                                    MMSDK.Log.v("Creating video player intent.");
                                    obj = new Intent(context, com/millennialmedia/android/MMActivity);
                                    ((Intent) (obj)).setData(uri);
                                    ((Intent) (obj)).putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
                                    MMSDK.Event.intentStarted(context, "streamingVideo", redirectionlistenerimpl.creatorAdImplInternalId);
                                } else
                                {
                                    if (redirectionlistenerimpl.canOpenOverlay())
                                    {
                                        MMSDK.Log.v("Creating launch overlay intent.");
                                        redirectionlistenerimpl = new Intent(context, com/millennialmedia/android/MMActivity);
                                        redirectionlistenerimpl.putExtra("class", com/millennialmedia/android/AdViewOverlayActivity.getCanonicalName());
                                        redirectionlistenerimpl.setData(uri);
                                        return redirectionlistenerimpl;
                                    }
                                    MMSDK.Log.v("Creating launch browser intent.");
                                    MMSDK.Event.intentStarted(context, "browser", redirectionlistenerimpl.creatorAdImplInternalId);
                                    obj = new Intent("android.intent.action.VIEW", uri);
                                }
                            } else
                            {
                                MMSDK.Log.v("Creating intent for unrecognized URI. %s", new Object[] {
                                    uri
                                });
                                obj = new Intent("android.intent.action.VIEW", uri);
                            }
                        }
                    }
                    if (obj != null)
                    {
                        MMSDK.Log.v("%s resolved to Intent: %s", new Object[] {
                            uri, obj
                        });
                        return ((Intent) (obj));
                    } else
                    {
                        MMSDK.Log.v("%s", new Object[] {
                            uri
                        });
                        return ((Intent) (obj));
                    }
                }
            }
            return null;
        }

        static void startActionView(Context context, String s)
        {
            startActivity(context, new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }

        static void startActivity(Context context, Intent intent)
        {
            if (!(context instanceof Activity))
            {
                intent.addFlags(0x10000000);
            }
            fixDataAndTypeForVideo(context, intent);
            context.startActivity(intent);
        }

        static void startAdViewOverlayActivity(Context context)
        {
            Intent intent = new Intent(context, com/millennialmedia/android/MMActivity);
            intent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
            startActivity(context, intent);
        }

        static void startAdViewOverlayActivity(Context context, Intent intent)
        {
            intent.setClass(context, com/millennialmedia/android/MMActivity);
            intent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
            startActivity(context, intent);
        }

        static void startAdViewOverlayActivityWithData(Context context, String s)
        {
            Intent intent = new Intent(context, com/millennialmedia/android/MMActivity);
            intent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
            intent.setData(Uri.parse(s));
            startActivity(context, intent);
        }

        static void startCachedVideoPlayerActivity(Context context, Intent intent)
        {
            intent.setClass(context, com/millennialmedia/android/MMActivity);
            intent.putExtra("class", "com.millennialmedia.android.CachedVideoPlayerActivity");
            startActivity(context, intent);
        }

        static void startPickerActivity(Context context, File file, String s)
        {
            Intent intent = new Intent(context, com/millennialmedia/android/MMActivity);
            intent.setData(Uri.fromFile(file));
            intent.putExtra("type", s);
            intent.putExtra("class", "com.millennialmedia.android.BridgeMMMedia$PickerActivity");
            startActivity(context, intent);
        }

        static void startVideoPlayerActivityWithData(Context context, Uri uri)
        {
            Intent intent = new Intent(context, com/millennialmedia/android/MMActivity);
            intent.setData(uri);
            intent.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
            startActivity(context, intent);
        }

        static void startVideoPlayerActivityWithData(Context context, File file)
        {
            startVideoPlayerActivityWithData(context, Uri.fromFile(file));
        }

        static void startVideoPlayerActivityWithData(Context context, String s)
        {
            startVideoPlayerActivityWithData(context, Uri.parse(s));
        }

        IntentUtils()
        {
        }
    }

    static class ThreadUtils
    {

        private static final ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();

        static void execute(Runnable runnable)
        {
            cachedThreadExecutor.execute(runnable);
        }


        ThreadUtils()
        {
        }
    }


    Utils()
    {
    }
}
