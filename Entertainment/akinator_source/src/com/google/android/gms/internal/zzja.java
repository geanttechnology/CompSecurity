// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            zzfg, zziz, zzbq, zzby, 
//            zzbu, zzid, zzie, zzfc, 
//            zzao, zzan, zzdf, zzdj, 
//            zzdq, zzdr, zzdn, zzdk, 
//            zzfi, zzdo, zzdm, zzdg

public class zzja extends WebViewClient
{

    private static final String zzJU[] = {
        "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", 
        "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"
    };
    private static final String zzJV[] = {
        "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"
    };
    private zzfi zzAl;
    private zza zzDn;
    private final HashMap zzJW;
    private zzg zzJX;
    private zzb zzJY;
    private boolean zzJZ;
    private boolean zzKa;
    private zzn zzKb;
    private final zzfg zzKc;
    private boolean zzKd;
    private boolean zzKe;
    private boolean zzKf;
    private boolean zzKg;
    private int zzKh;
    protected zziz zzoM;
    private final Object zzpd;
    private boolean zzqW;
    private zza zzsy;
    private zzdo zzxO;
    private zze zzxQ;
    private zzfc zzxR;
    private zzdm zzxT;
    private zzdg zzxn;

    public zzja(zziz zziz1, boolean flag)
    {
        this(zziz1, flag, new zzfg(zziz1, zziz1.zzha(), new zzbq(zziz1.getContext())), null);
    }

    zzja(zziz zziz1, boolean flag, zzfg zzfg1, zzfc zzfc1)
    {
        zzJW = new HashMap();
        zzpd = new Object();
        zzJZ = false;
        zzoM = zziz1;
        zzqW = flag;
        zzKc = zzfg1;
        zzxR = zzfc1;
    }

    static zzb zza(zzja zzja1, zzb zzb1)
    {
        zzja1.zzJY = zzb1;
        return zzb1;
    }

    private void zza(Context context, String s, String s1, String s2)
    {
        if (!((Boolean)zzby.zzvp.get()).booleanValue())
        {
            return;
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putString("err", s);
            bundle.putString("code", s1);
            bundle.putString("host", zzaK(s2));
            zzp.zzbv().zza(context, zzoM.zzhh().zzJu, "gmob-apps", bundle, true);
            return;
        }
    }

    static void zza(zzja zzja1)
    {
        zzja1.zzht();
    }

    private String zzaK(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return "";
        }
        s = Uri.parse(s);
        if (s.getHost() != null)
        {
            return s.getHost();
        } else
        {
            return "";
        }
    }

    static void zzb(zzja zzja1)
    {
        zzja1.zzhu();
    }

    static void zzc(zzja zzja1)
    {
        zzja1.zzhv();
    }

    static zzb zzd(zzja zzja1)
    {
        return zzja1.zzJY;
    }

    private static boolean zzg(Uri uri)
    {
        uri = uri.getScheme();
        return "http".equalsIgnoreCase(uri) || "https".equalsIgnoreCase(uri);
    }

    private void zzht()
    {
        synchronized (zzpd)
        {
            zzKa = true;
        }
        zzKh = zzKh + 1;
        zzhw();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void zzhu()
    {
        zzKh = zzKh - 1;
        zzhw();
    }

    private void zzhv()
    {
        zzKg = true;
        zzhw();
    }

    public final void onLoadResource(WebView webview, String s)
    {
        com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder()).append("Loading resource: ").append(s).toString());
        webview = Uri.parse(s);
        if ("gmsg".equalsIgnoreCase(webview.getScheme()) && "mobileads.google.com".equalsIgnoreCase(webview.getHost()))
        {
            zzh(webview);
        }
    }

    public final void onPageFinished(WebView webview, String s)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (!zzKe || !"about:blank".equals(s))
                {
                    break label0;
                }
                com.google.android.gms.ads.internal.util.client.zzb.v("Blank page loaded, 1...");
                zzoM.zzhj();
            }
            return;
        }
        webview;
        JVM INSTR monitorexit ;
        zzKf = true;
        zzhw();
        return;
        s;
        webview;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        String s2;
        if (i < 0 && -i - 1 < zzJU.length)
        {
            s2 = zzJU[-i - 1];
        } else
        {
            s2 = String.valueOf(i);
        }
        zza(zzoM.getContext(), "http_err", s2, s1);
        super.onReceivedError(webview, i, s, s1);
    }

    public final void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        if (sslerror != null)
        {
            int i = sslerror.getPrimaryError();
            String s;
            if (i >= 0 && i < zzJV.length)
            {
                s = zzJV[i];
            } else
            {
                s = String.valueOf(i);
            }
            zza(zzoM.getContext(), "ssl_err", s, zzp.zzbx().zza(sslerror));
        }
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
    }

    public final void reset()
    {
        synchronized (zzpd)
        {
            zzJW.clear();
            zzsy = null;
            zzJX = null;
            zzDn = null;
            zzxn = null;
            zzJZ = false;
            zzqW = false;
            zzKa = false;
            zzxT = null;
            zzKb = null;
            zzJY = null;
            if (zzxR != null)
            {
                zzxR.zzn(true);
                zzxR = null;
            }
            zzKd = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean shouldOverrideKeyEvent(WebView webview, KeyEvent keyevent)
    {
        switch (keyevent.getKeyCode())
        {
        default:
            return false;

        case 79: // 'O'
        case 85: // 'U'
        case 86: // 'V'
        case 87: // 'W'
        case 88: // 'X'
        case 89: // 'Y'
        case 90: // 'Z'
        case 91: // '['
        case 126: // '~'
        case 127: // '\177'
        case 128: 
        case 129: 
        case 130: 
        case 222: 
            return true;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Uri uri;
        com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder()).append("AdWebView shouldOverrideUrlLoading: ").append(s).toString());
        uri = Uri.parse(s);
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) goto _L2; else goto _L1
_L1:
        zzh(uri);
_L4:
        return true;
_L2:
        if (zzJZ && webview == zzoM.getWebView() && zzg(uri))
        {
            if (!zzKd)
            {
                zzKd = true;
                if (zzsy != null && ((Boolean)zzby.zzvd.get()).booleanValue())
                {
                    zzsy.onAdClicked();
                }
            }
            return super.shouldOverrideUrlLoading(webview, s);
        }
        if (zzoM.getWebView().willNotDraw())
        {
            break MISSING_BLOCK_LABEL_281;
        }
        zzan zzan1 = zzoM.zzhg();
        webview = uri;
        if (zzan1 != null)
        {
            webview = uri;
            try
            {
                if (zzan1.zzb(uri))
                {
                    webview = zzan1.zza(uri, zzoM.getContext());
                }
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
                webview = uri;
            }
        }
        if (zzxQ == null || zzxQ.zzbe())
        {
            zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", webview.toString(), null, null, null, null, null));
        } else
        {
            zzxQ.zzp(s);
        }
        continue; /* Loop/switch isn't completed */
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("AdWebView unable to handle URL: ").append(s).toString());
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void zzF(boolean flag)
    {
        zzJZ = flag;
    }

    public void zza(int i, int j, boolean flag)
    {
        zzKc.zze(i, j);
        if (zzxR != null)
        {
            zzxR.zza(i, j, flag);
        }
    }

    public final void zza(AdLauncherIntentInfoParcel adlauncherintentinfoparcel)
    {
        zzg zzg1 = null;
        boolean flag = zzoM.zzhi();
        zza zza1;
        if (flag && !zzoM.zzaN().zztf)
        {
            zza1 = null;
        } else
        {
            zza1 = zzsy;
        }
        if (!flag)
        {
            zzg1 = zzJX;
        }
        zza(new AdOverlayInfoParcel(adlauncherintentinfoparcel, zza1, zzg1, zzKb, zzoM.zzhh()));
    }

    public void zza(AdOverlayInfoParcel adoverlayinfoparcel)
    {
        boolean flag1 = false;
        com.google.android.gms.ads.internal.overlay.zze zze1;
        Context context;
        boolean flag;
        if (zzxR != null)
        {
            flag = zzxR.zzef();
        } else
        {
            flag = false;
        }
        zze1 = zzp.zzbt();
        context = zzoM.getContext();
        if (!flag)
        {
            flag1 = true;
        }
        zze1.zza(context, adoverlayinfoparcel, flag1);
    }

    public void zza(zza zza1)
    {
        zzDn = zza1;
    }

    public void zza(zzb zzb1)
    {
        zzJY = zzb1;
    }

    public final void zza(String s, zzdk zzdk1)
    {
        Object obj1 = zzpd;
        obj1;
        JVM INSTR monitorenter ;
        List list = (List)zzJW.get(s);
        Object obj;
        obj = list;
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        obj = new CopyOnWriteArrayList();
        zzJW.put(s, obj);
        ((List) (obj)).add(zzdk1);
        obj1;
        JVM INSTR monitorexit ;
        return;
        s;
        obj1;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void zza(boolean flag, int i)
    {
        zza zza1;
        if (zzoM.zzhi() && !zzoM.zzaN().zztf)
        {
            zza1 = null;
        } else
        {
            zza1 = zzsy;
        }
        zza(new AdOverlayInfoParcel(zza1, zzJX, zzKb, zzoM, flag, i, zzoM.zzhh()));
    }

    public final void zza(boolean flag, int i, String s)
    {
        Object obj = null;
        boolean flag1 = zzoM.zzhi();
        zza zza1;
        if (flag1 && !zzoM.zzaN().zztf)
        {
            zza1 = null;
        } else
        {
            zza1 = zzsy;
        }
    /* block-local class not found */
    class zzc {}

        if (!flag1)
        {
            obj = new zzc(zzoM, zzJX);
        }
        zza(new AdOverlayInfoParcel(zza1, ((zzg) (obj)), zzxn, zzKb, zzoM, flag, i, s, zzoM.zzhh(), zzxT));
    }

    public final void zza(boolean flag, int i, String s, String s1)
    {
        boolean flag1 = zzoM.zzhi();
        zza zza1;
        Object obj;
        if (flag1 && !zzoM.zzaN().zztf)
        {
            zza1 = null;
        } else
        {
            zza1 = zzsy;
        }
        if (flag1)
        {
            obj = null;
        } else
        {
            obj = new zzc(zzoM, zzJX);
        }
        zza(new AdOverlayInfoParcel(zza1, ((zzg) (obj)), zzxn, zzKb, zzoM, flag, i, s, s1, zzoM.zzhh(), zzxT));
    }

    public void zzb(zza zza1, zzg zzg1, zzdg zzdg, zzn zzn, boolean flag, zzdm zzdm, zzdo zzdo, 
            zze zze1, zzfi zzfi)
    {
        zze zze2 = zze1;
        if (zze1 == null)
        {
            zze2 = new zze(false);
        }
        zzxR = new zzfc(zzoM, zzfi);
        zza("/appEvent", new zzdf(zzdg));
        zza("/backButton", zzdj.zzxx);
        zza("/canOpenURLs", zzdj.zzxp);
        zza("/canOpenIntents", zzdj.zzxq);
        zza("/click", zzdj.zzxr);
        zza("/close", zzdj.zzxs);
        zza("/customClose", zzdj.zzxt);
        zza("/instrument", zzdj.zzxA);
    /* block-local class not found */
    class zzd {}

        zza("/delayPageLoaded", new zzd(null));
        zza("/httpTrack", zzdj.zzxu);
        zza("/log", zzdj.zzxv);
        zza("/mraid", new zzdq(zze2, zzxR));
        zza("/mraidLoaded", zzKc);
        zza("/open", new zzdr(zzdm, zze2, zzxR));
        zza("/precache", zzdj.zzxz);
        zza("/touch", zzdj.zzxw);
        zza("/video", zzdj.zzxy);
        if (zzdo != null)
        {
            zza("/setInterstitialProperties", new zzdn(zzdo));
        }
        zzsy = zza1;
        zzJX = zzg1;
        zzxn = zzdg;
        zzxT = zzdm;
        zzKb = zzn;
        zzxQ = zze2;
        zzAl = zzfi;
        zzxO = zzdo;
        zzF(flag);
        zzKd = false;
    }

    public final void zzb(String s, zzdk zzdk1)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        s = (List)zzJW.get(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        s.remove(zzdk1);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean zzbY()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzqW;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzd(int i, int j)
    {
        if (zzxR != null)
        {
            zzxR.zzd(i, j);
        }
    }

    public void zze(zziz zziz1)
    {
        zzoM = zziz1;
    }

    public final void zzeG()
    {
        synchronized (zzpd)
        {
            zzJZ = false;
            zzqW = true;
            zzid.runOnUiThread(new _cls1());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzh(Uri uri)
    {
        String s = uri.getPath();
        Object obj = (List)zzJW.get(s);
        if (obj != null)
        {
            uri = zzp.zzbv().zze(uri);
            if (com.google.android.gms.ads.internal.util.client.zzb.zzN(2))
            {
                com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder()).append("Received GMSG: ").append(s).toString());
                String s1;
                for (Iterator iterator = uri.keySet().iterator(); iterator.hasNext(); com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder()).append("  ").append(s1).append(": ").append((String)uri.get(s1)).toString()))
                {
                    s1 = (String)iterator.next();
                }

            }
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((zzdk)((Iterator) (obj)).next()).zza(zzoM, uri)) { }
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder()).append("No GMSG handler found for GMSG: ").append(uri).toString());
        }
    }

    public zze zzhq()
    {
        return zzxQ;
    }

    public boolean zzhr()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzKa;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzhs()
    {
        synchronized (zzpd)
        {
            com.google.android.gms.ads.internal.util.client.zzb.v("Loading blank page in WebView, 2...");
            zzKe = true;
            zzoM.zzaI("about:blank");
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void zzhw()
    {
        if (zzDn != null && (zzKf && zzKh <= 0 || zzKg))
        {
            zza zza1 = zzDn;
            zziz zziz1 = zzoM;
    /* block-local class not found */
    class zza {}

            boolean flag;
            if (!zzKg)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zza1.zza(zziz1, flag);
            zzDn = null;
        }
        zzoM.zzhp();
    }


    // Unreferenced inner class com/google/android/gms/internal/zzja$zzb
    /* block-local class not found */
    class zzb {}


    /* member class not found */
    class _cls1 {}

}
