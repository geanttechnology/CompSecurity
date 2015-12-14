// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zziz, zziy, zzja, zzcg, 
//            zzaz, zzan, zzce, zzcf

class zzjc extends FrameLayout
    implements zziz
{

    private final zziz zzKk;
    private final zziy zzKl;

    public zzjc(zziz zziz1)
    {
        super(zziz1.zzha());
        zzKk = zziz1;
        zzKl = new zziy(zziz1.zzha(), this, this);
        zziz1 = zzKk.zzhe();
        if (zziz1 != null)
        {
            zziz1.zze(this);
        }
        addView(zzKk.getView());
    }

    public void clearCache(boolean flag)
    {
        zzKk.clearCache(flag);
    }

    public void destroy()
    {
        zzKk.destroy();
    }

    public String getRequestId()
    {
        return zzKk.getRequestId();
    }

    public int getRequestedOrientation()
    {
        return zzKk.getRequestedOrientation();
    }

    public View getView()
    {
        return this;
    }

    public WebView getWebView()
    {
        return zzKk.getWebView();
    }

    public boolean isDestroyed()
    {
        return zzKk.isDestroyed();
    }

    public void loadData(String s, String s1, String s2)
    {
        zzKk.loadData(s, s1, s2);
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4)
    {
        zzKk.loadDataWithBaseURL(s, s1, s2, s3, s4);
    }

    public void loadUrl(String s)
    {
        zzKk.loadUrl(s);
    }

    public void setBackgroundColor(int i)
    {
        zzKk.setBackgroundColor(i);
    }

    public void setContext(Context context)
    {
        zzKk.setContext(context);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        zzKk.setOnClickListener(onclicklistener);
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        zzKk.setOnTouchListener(ontouchlistener);
    }

    public void setRequestedOrientation(int i)
    {
        zzKk.setRequestedOrientation(i);
    }

    public void setWebChromeClient(WebChromeClient webchromeclient)
    {
        zzKk.setWebChromeClient(webchromeclient);
    }

    public void setWebViewClient(WebViewClient webviewclient)
    {
        zzKk.setWebViewClient(webviewclient);
    }

    public void stopLoading()
    {
        zzKk.stopLoading();
    }

    public void zzC(boolean flag)
    {
        zzKk.zzC(flag);
    }

    public void zzD(boolean flag)
    {
        zzKk.zzD(flag);
    }

    public void zzE(boolean flag)
    {
        zzKk.zzE(flag);
    }

    public void zza(Context context, AdSizeParcel adsizeparcel, zzcg zzcg)
    {
        zzKk.zza(context, adsizeparcel, zzcg);
    }

    public void zza(AdSizeParcel adsizeparcel)
    {
        zzKk.zza(adsizeparcel);
    }

    public void zza(zzaz zzaz, boolean flag)
    {
        zzKk.zza(zzaz, flag);
    }

    public void zza(String s, String s1)
    {
        zzKk.zza(s, s1);
    }

    public void zza(String s, JSONObject jsonobject)
    {
        zzKk.zza(s, jsonobject);
    }

    public void zzaI(String s)
    {
        zzKk.zzaI(s);
    }

    public void zzaJ(String s)
    {
        zzKk.zzaJ(s);
    }

    public AdSizeParcel zzaN()
    {
        return zzKk.zzaN();
    }

    public void zzb(zzd zzd)
    {
        zzKk.zzb(zzd);
    }

    public void zzb(String s, Map map)
    {
        zzKk.zzb(s, map);
    }

    public void zzb(String s, JSONObject jsonobject)
    {
        zzKk.zzb(s, jsonobject);
    }

    public void zzc(zzd zzd)
    {
        zzKk.zzc(zzd);
    }

    public void zzeJ()
    {
        zzKk.zzeJ();
    }

    public void zzgY()
    {
        zzKk.zzgY();
    }

    public Activity zzgZ()
    {
        return zzKk.zzgZ();
    }

    public Context zzha()
    {
        return zzKk.zzha();
    }

    public com.google.android.gms.ads.internal.zzd zzhb()
    {
        return zzKk.zzhb();
    }

    public zzd zzhc()
    {
        return zzKk.zzhc();
    }

    public zzd zzhd()
    {
        return zzKk.zzhd();
    }

    public zzja zzhe()
    {
        return zzKk.zzhe();
    }

    public boolean zzhf()
    {
        return zzKk.zzhf();
    }

    public zzan zzhg()
    {
        return zzKk.zzhg();
    }

    public VersionInfoParcel zzhh()
    {
        return zzKk.zzhh();
    }

    public boolean zzhi()
    {
        return zzKk.zzhi();
    }

    public void zzhj()
    {
        zzKl.onDestroy();
        zzKk.zzhj();
    }

    public boolean zzhk()
    {
        return zzKk.zzhk();
    }

    public zziy zzhl()
    {
        return zzKl;
    }

    public zzce zzhm()
    {
        return zzKk.zzhm();
    }

    public zzcf zzhn()
    {
        return zzKk.zzhn();
    }

    public void zzho()
    {
        zzKk.zzho();
    }

    public void zzhp()
    {
        zzKk.zzhp();
    }

    public void zzv(int i)
    {
        zzKk.zzv(i);
    }
}
