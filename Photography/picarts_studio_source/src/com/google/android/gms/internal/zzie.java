// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzja, zziz

public class zzie
{

    private zzie()
    {
    }


    public static zzie zzM(int i)
    {
        if (i >= 19)
        {
            return new zzg();
        }
        if (i >= 18)
        {
            return new zze();
        }
        if (i >= 17)
        {
            return new zzd();
        }
        if (i >= 16)
        {
            return new zzf();
        }
        if (i >= 14)
        {
            return new zzc();
        }
        if (i >= 11)
        {
            return new zzb();
        }
        if (i >= 9)
        {
            return new zza();
        } else
        {
            return new zzie();
        }
    }

    public String getDefaultUserAgent(Context context)
    {
        return "";
    }

    public boolean isAttachedToWindow(View view)
    {
        return view.getWindowToken() != null || view.getWindowVisibility() != 8;
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean flag, float f)
    {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public String zza(SslError sslerror)
    {
        return "";
    }

    public void zza(View view, Drawable drawable)
    {
        view.setBackgroundDrawable(drawable);
    }

    public void zza(ViewTreeObserver viewtreeobserver, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        viewtreeobserver.removeGlobalOnLayoutListener(ongloballayoutlistener);
    }

    public boolean zza(android.app.DownloadManager.Request request)
    {
        return false;
    }

    public boolean zza(Context context, WebSettings websettings)
    {
        return false;
    }

    public boolean zza(Window window)
    {
        return false;
    }

    public boolean zza(WebView webview)
    {
        if (webview == null)
        {
            return false;
        } else
        {
            webview.onPause();
            return true;
        }
    }

    public zzja zzb(zziz zziz, boolean flag)
    {
        return new zzja(zziz, flag);
    }

    public void zzb(Activity activity, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        activity = activity.getWindow();
        if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
        {
            zza(activity.getDecorView().getViewTreeObserver(), ongloballayoutlistener);
        }
    }

    public boolean zzb(WebView webview)
    {
        if (webview == null)
        {
            return false;
        } else
        {
            webview.onResume();
            return true;
        }
    }

    public WebChromeClient zzf(zziz zziz)
    {
        return null;
    }

    public Set zzf(Uri uri)
    {
        if (uri.isOpaque())
        {
            return Collections.emptySet();
        }
        uri = uri.getEncodedQuery();
        if (uri == null)
        {
            return Collections.emptySet();
        }
        LinkedHashSet linkedhashset = new LinkedHashSet();
        int j = 0;
        do
        {
            int i;
            int k;
label0:
            {
                k = uri.indexOf('&', j);
                i = k;
                if (k == -1)
                {
                    i = uri.length();
                }
                int l = uri.indexOf('=', j);
                if (l <= i)
                {
                    k = l;
                    if (l != -1)
                    {
                        break label0;
                    }
                }
                k = i;
            }
            linkedhashset.add(Uri.decode(uri.substring(j, k)));
            i++;
            j = i;
            if (i >= uri.length())
            {
                return Collections.unmodifiableSet(linkedhashset);
            }
        } while (true);
    }

    public int zzgG()
    {
        return 0;
    }

    public int zzgH()
    {
        return 1;
    }

    public int zzgI()
    {
        return 5;
    }

    public android.view.ViewGroup.LayoutParams zzgJ()
    {
        return new android.view.ViewGroup.LayoutParams(-2, -2);
    }

    public boolean zzl(View view)
    {
        return false;
    }

    public boolean zzm(View view)
    {
        return false;
    }

    private class zzg extends zze
    {
        private class zze extends zzd
        {
            private class zzd extends zzf
            {
                private class zzf extends zzc
                {
                    private class zzc extends zzb
                    {
                        private class zzb extends zza
                        {
                            private class zza extends zzie
                            {

                                public boolean zza(android.app.DownloadManager.Request request)
                                {
                                    request.setShowRunningNotification(true);
                                    return true;
                                }

                                public int zzgG()
                                {
                                    return 6;
                                }

                                public int zzgH()
                                {
                                    return 7;
                                }

                                public zza()
                                {
                                }
                            }


                            public boolean zza(android.app.DownloadManager.Request request)
                            {
                                request.allowScanningByMediaScanner();
                                request.setNotificationVisibility(1);
                                return true;
                            }

                            public boolean zza(Context context, WebSettings websettings)
                            {
                                if (context.getCacheDir() != null)
                                {
                                    websettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                                    websettings.setAppCacheMaxSize(0L);
                                    websettings.setAppCacheEnabled(true);
                                }
                                websettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                                websettings.setDatabaseEnabled(true);
                                websettings.setDomStorageEnabled(true);
                                websettings.setDisplayZoomControls(false);
                                websettings.setBuiltInZoomControls(true);
                                websettings.setSupportZoom(true);
                                return true;
                            }

                            public boolean zza(Window window)
                            {
                                window.setFlags(0x1000000, 0x1000000);
                                return true;
                            }

                            public zzja zzb(zziz zziz, boolean flag)
                            {
                                return new zzjg(zziz, flag);
                            }

                            public WebChromeClient zzf(zziz zziz)
                            {
                                return new zzjf(zziz);
                            }

                            public Set zzf(Uri uri)
                            {
                                return uri.getQueryParameterNames();
                            }

                            public boolean zzl(View view)
                            {
                                view.setLayerType(0, null);
                                return true;
                            }

                            public boolean zzm(View view)
                            {
                                view.setLayerType(1, null);
                                return true;
                            }

                            public zzb()
                            {
                            }
                        }


                        public String zza(SslError sslerror)
                        {
                            return sslerror.getUrl();
                        }

                        public WebChromeClient zzf(zziz zziz)
                        {
                            return new zzjh(zziz);
                        }

                        public zzc()
                        {
                        }
                    }


                    public void zza(View view, Drawable drawable)
                    {
                        view.setBackground(drawable);
                    }

                    public void zza(ViewTreeObserver viewtreeobserver, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
                    {
                        viewtreeobserver.removeOnGlobalLayoutListener(ongloballayoutlistener);
                    }

                    public void zzb(Activity activity, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
                    {
                        activity = activity.getWindow();
                        if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
                        {
                            zza(activity.getDecorView().getViewTreeObserver(), ongloballayoutlistener);
                        }
                    }

                    public zzf()
                    {
                    }
                }


                public String getDefaultUserAgent(Context context)
                {
                    return WebSettings.getDefaultUserAgent(context);
                }

                public Drawable zza(Context context, Bitmap bitmap, boolean flag, float f)
                {
                    if (!flag || f <= 0.0F || f > 25F)
                    {
                        return new BitmapDrawable(context.getResources(), bitmap);
                    }
                    Object obj;
                    try
                    {
                        Object obj2 = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                        obj = Bitmap.createBitmap(((Bitmap) (obj2)));
                        Object obj1 = RenderScript.create(context);
                        ScriptIntrinsicBlur scriptintrinsicblur = ScriptIntrinsicBlur.create(((RenderScript) (obj1)), Element.U8_4(((RenderScript) (obj1))));
                        obj2 = Allocation.createFromBitmap(((RenderScript) (obj1)), ((Bitmap) (obj2)));
                        obj1 = Allocation.createFromBitmap(((RenderScript) (obj1)), ((Bitmap) (obj)));
                        scriptintrinsicblur.setRadius(f);
                        scriptintrinsicblur.setInput(((Allocation) (obj2)));
                        scriptintrinsicblur.forEach(((Allocation) (obj1)));
                        ((Allocation) (obj1)).copyTo(((Bitmap) (obj)));
                        obj = new BitmapDrawable(context.getResources(), ((Bitmap) (obj)));
                    }
                    catch (RuntimeException runtimeexception)
                    {
                        return new BitmapDrawable(context.getResources(), bitmap);
                    }
                    return ((Drawable) (obj));
                }

                public boolean zza(Context context, WebSettings websettings)
                {
                    super.zza(context, websettings);
                    websettings.setMediaPlaybackRequiresUserGesture(false);
                    return true;
                }

                public zzd()
                {
                }
            }


            public boolean isAttachedToWindow(View view)
            {
                return super.isAttachedToWindow(view) || view.getWindowId() != null;
            }

            public int zzgI()
            {
                return 14;
            }

            public zze()
            {
            }
        }


        public boolean isAttachedToWindow(View view)
        {
            return view.isAttachedToWindow();
        }

        public android.view.ViewGroup.LayoutParams zzgJ()
        {
            return new android.view.ViewGroup.LayoutParams(-1, -1);
        }

        public zzg()
        {
        }
    }

}
