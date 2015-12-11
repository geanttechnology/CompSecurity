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

    zzie(_cls1 _pcls1)
    {
        this();
    }

    public static zzie zzM(int i)
    {
    /* block-local class not found */
    class zzg {}

        if (i >= 19)
        {
            return new zzg();
        }
    /* block-local class not found */
    class zze {}

        if (i >= 18)
        {
            return new zze();
        }
    /* block-local class not found */
    class zzd {}

        if (i >= 17)
        {
            return new zzd();
        }
    /* block-local class not found */
    class zzf {}

        if (i >= 16)
        {
            return new zzf();
        }
    /* block-local class not found */
    class zzc {}

        if (i >= 14)
        {
            return new zzc();
        }
    /* block-local class not found */
    class zzb {}

        if (i >= 11)
        {
            return new zzb();
        }
    /* block-local class not found */
    class zza {}

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
}
