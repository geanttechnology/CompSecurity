// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zziz, zzid, zzie, zzmx, 
//            zzje, zzim, zzcf, zzcg, 
//            zzcc, zzdv, zzhu, zzca, 
//            zzja, zzdu, zzan, zzfh, 
//            zzce, zzaz, zziy

class zzjd extends WebView
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zziz
{
    public static class zza extends MutableContextWrapper
    {

        private Activity zzJn;
        private Context zzKC;
        private Context zzqZ;

        public Object getSystemService(String s)
        {
            return zzKC.getSystemService(s);
        }

        public void setBaseContext(Context context)
        {
            zzqZ = context.getApplicationContext();
            Activity activity;
            if (context instanceof Activity)
            {
                activity = (Activity)context;
            } else
            {
                activity = null;
            }
            zzJn = activity;
            zzKC = context;
            super.setBaseContext(zzqZ);
        }

        public void startActivity(Intent intent)
        {
            if (zzJn != null && !zzmx.isAtLeastL())
            {
                zzJn.startActivity(intent);
                return;
            } else
            {
                intent.setFlags(0x10000000);
                zzqZ.startActivity(intent);
                return;
            }
        }

        public Activity zzgZ()
        {
            return zzJn;
        }

        public Context zzha()
        {
            return zzKC;
        }

        public zza(Context context)
        {
            super(context);
            setBaseContext(context);
        }
    }


    private int zzAD;
    private int zzAE;
    private int zzAG;
    private int zzAH;
    private String zzBY;
    private Boolean zzHZ;
    private Map zzKA;
    private final zza zzKm;
    private zzja zzKn;
    private zzd zzKo;
    private boolean zzKp;
    private boolean zzKq;
    private boolean zzKr;
    private boolean zzKs;
    private int zzKt;
    private boolean zzKu;
    private zzce zzKv;
    private zzce zzKw;
    private zzce zzKx;
    private zzcf zzKy;
    private zzd zzKz;
    private final com.google.android.gms.ads.internal.zzd zzow;
    private final VersionInfoParcel zzpb;
    private final Object zzpd = new Object();
    private zzim zzqR;
    private final WindowManager zzri = (WindowManager)getContext().getSystemService("window");
    private final zzan zzwL;
    private AdSizeParcel zzzm;

    protected zzjd(zza zza1, AdSizeParcel adsizeparcel, boolean flag, boolean flag1, zzan zzan1, VersionInfoParcel versioninfoparcel, zzcg zzcg1, 
            com.google.android.gms.ads.internal.zzd zzd1)
    {
        super(zza1);
        zzKu = true;
        zzBY = "";
        zzAE = -1;
        zzAD = -1;
        zzAG = -1;
        zzAH = -1;
        zzKm = zza1;
        zzzm = adsizeparcel;
        zzKr = flag;
        zzKt = -1;
        zzwL = zzan1;
        zzpb = versioninfoparcel;
        zzow = zzd1;
        setBackgroundColor(0);
        adsizeparcel = getSettings();
        adsizeparcel.setJavaScriptEnabled(true);
        adsizeparcel.setSavePassword(false);
        adsizeparcel.setSupportMultipleWindows(true);
        adsizeparcel.setJavaScriptCanOpenWindowsAutomatically(true);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            adsizeparcel.setMixedContentMode(0);
        }
        zzp.zzbv().zza(zza1, versioninfoparcel.zzJu, adsizeparcel);
        zzp.zzbx().zza(getContext(), adsizeparcel);
        setDownloadListener(this);
        zzhz();
        if (zzmx.zzqz())
        {
            addJavascriptInterface(new zzje(this), "googleAdsJsInterface");
        }
        zzqR = new zzim(zzKm.zzgZ(), this, null);
        zzd(zzcg1);
    }

    static void zza(zzjd zzjd1)
    {
        zzjd1.WebView.destroy();
    }

    static zzjd zzb(Context context, AdSizeParcel adsizeparcel, boolean flag, boolean flag1, zzan zzan1, VersionInfoParcel versioninfoparcel, zzcg zzcg1, com.google.android.gms.ads.internal.zzd zzd1)
    {
        return new zzjd(new zza(context), adsizeparcel, flag, flag1, zzan1, versioninfoparcel, zzcg1, zzd1);
    }

    private void zzd(zzcg zzcg1)
    {
        zzhD();
        zzKy = new zzcf(new zzcg(true, "make_wv", zzzm.zzte));
        zzKy.zzdm().zzc(zzcg1);
        zzKw = com.google.android.gms.internal.zzcc.zzb(zzKy.zzdm());
        zzKy.zza("native:view_create", zzKw);
        zzKx = null;
        zzKv = null;
    }

    private void zzhA()
    {
        synchronized (zzpd)
        {
            if (!zzKs)
            {
                zzp.zzbx().zzm(this);
            }
            zzKs = true;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void zzhB()
    {
        synchronized (zzpd)
        {
            if (zzKs)
            {
                zzp.zzbx().zzl(this);
            }
            zzKs = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void zzhC()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzKA != null)
        {
            for (Iterator iterator = zzKA.values().iterator(); iterator.hasNext(); ((zzdv)iterator.next()).release()) { }
        }
        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    private void zzhD()
    {
        zzcg zzcg1;
        if (zzKy != null)
        {
            if ((zzcg1 = zzKy.zzdm()) != null && zzp.zzby().zzgo() != null)
            {
                zzp.zzby().zzgo().zza(zzcg1);
                return;
            }
        }
    }

    private void zzhy()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Boolean boolean1;
        zzHZ = zzp.zzby().zzgs();
        boolean1 = zzHZ;
        if (boolean1 != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        evaluateJavascript("(function(){})()", null);
        zzb(Boolean.valueOf(true));
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        zzb(Boolean.valueOf(false));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    private void zzhz()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (!zzKr && !zzzm.zztf) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 14) goto _L4; else goto _L3
_L3:
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Disabling hardware acceleration on an overlay.");
        zzhA();
_L5:
        return;
_L4:
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Enabling hardware acceleration on an overlay.");
        zzhB();
          goto _L5
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                break label0;
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Disabling hardware acceleration on an AdView.");
            zzhA();
        }
          goto _L5
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Enabling hardware acceleration on an AdView.");
        zzhB();
          goto _L5
    }

    public void destroy()
    {
label0:
        {
            synchronized (zzpd)
            {
                zzhD();
                zzqR.zzgP();
                if (zzKo != null)
                {
                    zzKo.close();
                    zzKo.onDestroy();
                    zzKo = null;
                }
                zzKn.reset();
                if (!zzKq)
                {
                    break label0;
                }
            }
            return;
        }
        zzp.zzbI().zza(this);
        zzhC();
        zzKq = true;
        com.google.android.gms.ads.internal.util.client.zzb.v("Initiating WebView self destruct sequence in 3...");
        zzKn.zzhs();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void evaluateJavascript(String s, ValueCallback valuecallback)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (!isDestroyed())
        {
            break MISSING_BLOCK_LABEL_34;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("The webview is destroyed. Ignoring action.");
        if (valuecallback == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        valuecallback.onReceiveValue(null);
        obj;
        JVM INSTR monitorexit ;
        return;
        super.evaluateJavascript(s, valuecallback);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public String getRequestId()
    {
        String s;
        synchronized (zzpd)
        {
            s = zzBY;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getRequestedOrientation()
    {
        int i;
        synchronized (zzpd)
        {
            i = zzKt;
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public View getView()
    {
        return this;
    }

    public WebView getWebView()
    {
        return this;
    }

    public boolean isDestroyed()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzKq;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void loadData(String s, String s1, String s2)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (isDestroyed())
        {
            break MISSING_BLOCK_LABEL_27;
        }
        super.loadData(s, s1, s2);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("The webview is destroyed. Ignoring action.");
        if (true) goto _L2; else goto _L1
_L1:
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (isDestroyed())
        {
            break MISSING_BLOCK_LABEL_31;
        }
        super.loadDataWithBaseURL(s, s1, s2, s3, s4);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("The webview is destroyed. Ignoring action.");
        if (true) goto _L2; else goto _L1
_L1:
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void loadUrl(String s)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = isDestroyed();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        super.loadUrl(s);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Could not call loadUrl. ").append(s).toString());
          goto _L1
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("The webview is destroyed. Ignoring action.");
          goto _L1
    }

    protected void onAttachedToWindow()
    {
        synchronized (zzpd)
        {
            super.onAttachedToWindow();
            if (!isDestroyed())
            {
                zzqR.onAttachedToWindow();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onDetachedFromWindow()
    {
        synchronized (zzpd)
        {
            if (!isDestroyed())
            {
                zzqR.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onDownloadStart(String s, String s1, String s2, String s3, long l)
    {
        try
        {
            s1 = new Intent("android.intent.action.VIEW");
            s1.setDataAndType(Uri.parse(s), s3);
            zzp.zzbv().zzb(getContext(), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder()).append("Couldn't find an Activity to view url/mimetype: ").append(s).append(" / ").append(s3).toString());
        }
    }

    protected void onDraw(Canvas canvas)
    {
        while (isDestroyed() || android.os.Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) 
        {
            return;
        }
        super.onDraw(canvas);
    }

    public void onGlobalLayout()
    {
        boolean flag = zzhx();
        zzd zzd1 = zzhc();
        if (zzd1 != null && flag)
        {
            zzd1.zzeI();
        }
    }

    protected void onMeasure(int i, int j)
    {
        int l;
label0:
        {
            l = 0x7fffffff;
            synchronized (zzpd)
            {
                if (!isDestroyed())
                {
                    break label0;
                }
                setMeasuredDimension(0, 0);
            }
            return;
        }
        if (!isInEditMode() && !zzKr && !zzzm.zzth && !zzzm.zzti)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        super.onMeasure(i, j);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (!zzzm.zztf)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        zzri.getDefaultDisplay().getMetrics(displaymetrics);
        setMeasuredDimension(displaymetrics.widthPixels, displaymetrics.heightPixels);
        obj;
        JVM INSTR monitorexit ;
        return;
        int k;
        int i1;
        int j1;
        int k1;
        k1 = android.view.View.MeasureSpec.getMode(i);
        k = android.view.View.MeasureSpec.getSize(i);
        j1 = android.view.View.MeasureSpec.getMode(j);
        i1 = android.view.View.MeasureSpec.getSize(j);
        break MISSING_BLOCK_LABEL_158;
_L4:
        if (zzzm.widthPixels <= i && zzzm.heightPixels <= j)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        float f = zzKm.getResources().getDisplayMetrics().density;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Not enough space to show ad. Needs ").append((int)((float)zzzm.widthPixels / f)).append("x").append((int)((float)zzzm.heightPixels / f)).append(" dp, but only has ").append((int)((float)k / f)).append("x").append((int)((float)i1 / f)).append(" dp.").toString());
        if (getVisibility() != 8)
        {
            setVisibility(4);
        }
        setMeasuredDimension(0, 0);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        if (getVisibility() != 8)
        {
            setVisibility(0);
        }
        setMeasuredDimension(zzzm.widthPixels, zzzm.heightPixels);
        if (true) goto _L2; else goto _L1
_L1:
        if (k1 != 0x80000000 && k1 != 0x40000000)
        {
            i = 0x7fffffff;
        } else
        {
            i = k;
        }
        if (j1 != 0x80000000)
        {
            j = l;
            if (j1 != 0x40000000)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        j = i1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPause()
    {
        if (!isDestroyed()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!zzmx.zzqu()) goto _L1; else goto _L3
_L3:
        super.onPause();
        return;
        Exception exception;
        exception;
        com.google.android.gms.ads.internal.util.client.zzb.zzb("Could not pause webview.", exception);
        return;
    }

    public void onResume()
    {
        if (!isDestroyed()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!zzmx.zzqu()) goto _L1; else goto _L3
_L3:
        super.onResume();
        return;
        Exception exception;
        exception;
        com.google.android.gms.ads.internal.util.client.zzb.zzb("Could not resume webview.", exception);
        return;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (zzwL != null)
        {
            zzwL.zza(motionevent);
        }
        if (isDestroyed())
        {
            return false;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void setContext(Context context)
    {
        zzKm.setBaseContext(context);
        zzqR.zzk(zzKm.zzgZ());
    }

    public void setRequestedOrientation(int i)
    {
        synchronized (zzpd)
        {
            zzKt = i;
            if (zzKo != null)
            {
                zzKo.setRequestedOrientation(zzKt);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setWebViewClient(WebViewClient webviewclient)
    {
        super.setWebViewClient(webviewclient);
        if (webviewclient instanceof zzja)
        {
            zzKn = (zzja)webviewclient;
        }
    }

    public void stopLoading()
    {
        if (isDestroyed())
        {
            return;
        }
        try
        {
            super.stopLoading();
            return;
        }
        catch (Exception exception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Could not stop loading webview.", exception);
        }
    }

    public void zzC(boolean flag)
    {
        synchronized (zzpd)
        {
            zzKr = flag;
            zzhz();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzD(boolean flag)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzKo == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        zzKo.zza(zzKn.zzbY(), flag);
_L2:
        return;
        zzKp = flag;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzE(boolean flag)
    {
        synchronized (zzpd)
        {
            zzKu = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zza(Context context, AdSizeParcel adsizeparcel, zzcg zzcg1)
    {
        synchronized (zzpd)
        {
            zzqR.zzgP();
            setContext(context);
            zzKo = null;
            zzzm = adsizeparcel;
            zzKr = false;
            zzKp = false;
            zzBY = "";
            zzKt = -1;
            zzp.zzbx().zzb(this);
            loadUrl("about:blank");
            zzKn.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
            zzKu = true;
            zzd(zzcg1);
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void zza(AdSizeParcel adsizeparcel)
    {
        synchronized (zzpd)
        {
            zzzm = adsizeparcel;
            requestLayout();
        }
        return;
        adsizeparcel;
        obj;
        JVM INSTR monitorexit ;
        throw adsizeparcel;
    }

    public void zza(zzaz zzaz, boolean flag)
    {
        HashMap hashmap = new HashMap();
        if (flag)
        {
            zzaz = "1";
        } else
        {
            zzaz = "0";
        }
        hashmap.put("isVisible", zzaz);
        zzb("onAdVisibilityChanged", hashmap);
    }

    protected void zza(String s, ValueCallback valuecallback)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (isDestroyed()) goto _L2; else goto _L1
_L1:
        evaluateJavascript(s, valuecallback);
_L4:
        return;
_L2:
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("The webview is destroyed. Ignoring action.");
        if (valuecallback == null) goto _L4; else goto _L3
_L3:
        valuecallback.onReceiveValue(null);
          goto _L4
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void zza(String s, String s1)
    {
        zzaM((new StringBuilder()).append(s).append("(").append(s1).append(");").toString());
    }

    public void zza(String s, JSONObject jsonobject)
    {
        JSONObject jsonobject1 = jsonobject;
        if (jsonobject == null)
        {
            jsonobject1 = new JSONObject();
        }
        zza(s, jsonobject1.toString());
    }

    public void zzaI(String s)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        super.loadUrl(s);
_L1:
        return;
        s;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Could not call loadUrl. ").append(s).toString());
          goto _L1
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void zzaJ(String s)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        String s1;
        s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        zzBY = s1;
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected void zzaL(String s)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (isDestroyed())
        {
            break MISSING_BLOCK_LABEL_22;
        }
        loadUrl(s);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("The webview is destroyed. Ignoring action.");
        if (true) goto _L2; else goto _L1
_L1:
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected void zzaM(String s)
    {
        if (zzmx.zzqB())
        {
            if (zzgs() == null)
            {
                zzhy();
            }
            if (zzgs().booleanValue())
            {
                zza(s, ((ValueCallback) (null)));
                return;
            } else
            {
                zzaL((new StringBuilder()).append("javascript:").append(s).toString());
                return;
            }
        } else
        {
            zzaL((new StringBuilder()).append("javascript:").append(s).toString());
            return;
        }
    }

    public AdSizeParcel zzaN()
    {
        AdSizeParcel adsizeparcel;
        synchronized (zzpd)
        {
            adsizeparcel = zzzm;
        }
        return adsizeparcel;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzb(zzd zzd1)
    {
        synchronized (zzpd)
        {
            zzKo = zzd1;
        }
        return;
        zzd1;
        obj;
        JVM INSTR monitorexit ;
        throw zzd1;
    }

    void zzb(Boolean boolean1)
    {
        zzHZ = boolean1;
        zzp.zzby().zzb(boolean1);
    }

    public void zzb(String s, Map map)
    {
        try
        {
            map = zzp.zzbv().zzz(map);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not convert parameters to JSON.");
            return;
        }
        zzb(s, ((JSONObject) (map)));
    }

    public void zzb(String s, JSONObject jsonobject)
    {
        Object obj = jsonobject;
        if (jsonobject == null)
        {
            obj = new JSONObject();
        }
        jsonobject = ((JSONObject) (obj)).toString();
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append("AFMA_ReceiveMessage('");
        ((StringBuilder) (obj)).append(s);
        ((StringBuilder) (obj)).append("'");
        ((StringBuilder) (obj)).append(",");
        ((StringBuilder) (obj)).append(jsonobject);
        ((StringBuilder) (obj)).append(");");
        com.google.android.gms.ads.internal.util.client.zzb.v((new StringBuilder()).append("Dispatching AFMA event: ").append(((StringBuilder) (obj)).toString()).toString());
        zzaM(((StringBuilder) (obj)).toString());
    }

    public void zzc(zzd zzd1)
    {
        synchronized (zzpd)
        {
            zzKz = zzd1;
        }
        return;
        zzd1;
        obj;
        JVM INSTR monitorexit ;
        throw zzd1;
    }

    public void zzeJ()
    {
        if (zzKv != null)
        {
            com.google.android.gms.internal.zzcc.zza(zzKy.zzdm(), zzKx, new String[] {
                "aes"
            });
            zzKv = com.google.android.gms.internal.zzcc.zzb(zzKy.zzdm());
            zzKy.zza("native:view_show", zzKx);
        }
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", zzpb.zzJu);
        zzb("onshow", hashmap);
    }

    public void zzgY()
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", zzpb.zzJu);
        zzb("onhide", hashmap);
    }

    public Activity zzgZ()
    {
        return zzKm.zzgZ();
    }

    Boolean zzgs()
    {
        Boolean boolean1;
        synchronized (zzpd)
        {
            boolean1 = zzHZ;
        }
        return boolean1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Context zzha()
    {
        return zzKm.zzha();
    }

    public com.google.android.gms.ads.internal.zzd zzhb()
    {
        return zzow;
    }

    public zzd zzhc()
    {
        zzd zzd1;
        synchronized (zzpd)
        {
            zzd1 = zzKo;
        }
        return zzd1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public zzd zzhd()
    {
        zzd zzd1;
        synchronized (zzpd)
        {
            zzd1 = zzKz;
        }
        return zzd1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public zzja zzhe()
    {
        return zzKn;
    }

    public boolean zzhf()
    {
        return zzKp;
    }

    public zzan zzhg()
    {
        return zzwL;
    }

    public VersionInfoParcel zzhh()
    {
        return zzpb;
    }

    public boolean zzhi()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzKr;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzhj()
    {
        synchronized (zzpd)
        {
            com.google.android.gms.ads.internal.util.client.zzb.v("Destroying WebView!");
            zzid.zzIE.post(new _cls1());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean zzhk()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzKu;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public zziy zzhl()
    {
        return null;
    }

    public zzce zzhm()
    {
        return zzKx;
    }

    public zzcf zzhn()
    {
        return zzKy;
    }

    public void zzho()
    {
        zzqR.zzgO();
    }

    public void zzhp()
    {
        if (zzKx == null && !"about:blank".equals(getUrl()))
        {
            zzKx = com.google.android.gms.internal.zzcc.zzb(zzKy.zzdm());
            zzKy.zza("native:view_load", zzKx);
        }
    }

    public boolean zzhx()
    {
        if (zzhe().zzbY())
        {
            DisplayMetrics displaymetrics = zzp.zzbv().zza(zzri);
            int k = zzl.zzcF().zzb(displaymetrics, displaymetrics.widthPixels);
            int l = zzl.zzcF().zzb(displaymetrics, displaymetrics.heightPixels);
            Activity activity = zzgZ();
            int i;
            int j;
            if (activity == null || activity.getWindow() == null)
            {
                j = l;
                i = k;
            } else
            {
                int ai[] = zzp.zzbv().zzg(activity);
                i = zzl.zzcF().zzb(displaymetrics, ai[0]);
                j = zzl.zzcF().zzb(displaymetrics, ai[1]);
            }
            if (zzAD != k || zzAE != l || zzAG != i || zzAH != j)
            {
                boolean flag;
                if (zzAD != k || zzAE != l)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                zzAD = k;
                zzAE = l;
                zzAG = i;
                zzAH = j;
                (new zzfh(this)).zza(k, l, i, j, displaymetrics.density, zzri.getDefaultDisplay().getRotation());
                return flag;
            }
        }
        return false;
    }

    public void zzv(int i)
    {
        HashMap hashmap = new HashMap(2);
        hashmap.put("closetype", String.valueOf(i));
        hashmap.put("version", zzpb.zzJu);
        zzb("onhide", hashmap);
    }

    /* member class not found */
    class _cls1 {}

}
