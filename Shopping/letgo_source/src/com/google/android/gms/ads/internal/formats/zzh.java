// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.mc;
import android.support.v7.mq;
import android.support.v7.ox;
import android.support.v7.ul;
import android.support.v7.um;
import android.support.v7.un;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzb, zza

public class zzh
{
    public static interface zza
    {

        public abstract String getCustomTemplateId();

        public abstract void zza(zzh zzh1);

        public abstract String zzdu();

        public abstract com.google.android.gms.ads.internal.formats.zza zzdv();
    }


    private final Context mContext;
    private ul zzoL;
    private final VersionInfoParcel zzpa;
    private final Object zzpc = new Object();
    private final zzn zzwb;
    private final JSONObject zzwe;
    private final mq zzwf;
    private final zza zzwg;
    private final mc zzwh;
    private boolean zzwi;
    private String zzwj;

    public zzh(Context context, zzn zzn1, mq mq1, mc mc1, JSONObject jsonobject, zza zza1, VersionInfoParcel versioninfoparcel)
    {
        mContext = context;
        zzwb = zzn1;
        zzwf = mq1;
        zzwh = mc1;
        zzwe = jsonobject;
        zzwg = zza1;
        zzpa = versioninfoparcel;
    }

    static String zza(zzh zzh1, String s)
    {
        zzh1.zzwj = s;
        return s;
    }

    static String zzc(zzh zzh1)
    {
        return zzh1.zzwj;
    }

    static mq zzd(zzh zzh1)
    {
        return zzh1.zzwf;
    }

    static ul zze(zzh zzh1)
    {
        return zzh1.zzoL;
    }

    public void performClick(String s)
    {
        x.b("performClick must be called on the main UI thread.");
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("asset", s);
        jsonobject.put("template", zzwg.zzdu());
        s = new JSONObject();
        s.put("ad", zzwe);
        s.put("click", jsonobject);
        boolean flag;
        if (zzwb.zzr(zzwg.getCustomTemplateId()) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            s.put("has_custom_click_handler", flag);
            zzwf.a("google.afma.nativeAds.handleClickGmsg", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to create click JSON.", s);
        }
        return;
    }

    public void recordImpression()
    {
        x.b("recordImpression must be called on the main UI thread.");
        zzl(true);
        zzwb.zzaP();
    }

    public com.google.android.gms.ads.internal.formats.zzb zza(android.view.View.OnClickListener onclicklistener)
    {
        Object obj = zzwg.zzdv();
        if (obj == null)
        {
            return null;
        } else
        {
            obj = new com.google.android.gms.ads.internal.formats.zzb(mContext, ((com.google.android.gms.ads.internal.formats.zza) (obj)));
            ((com.google.android.gms.ads.internal.formats.zzb) (obj)).setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            ((com.google.android.gms.ads.internal.formats.zzb) (obj)).zzdq().setOnClickListener(onclicklistener);
            ((com.google.android.gms.ads.internal.formats.zzb) (obj)).zzdq().setContentDescription("Ad attribution icon");
            return ((com.google.android.gms.ads.internal.formats.zzb) (obj));
        }
    }

    public void zzb(MotionEvent motionevent)
    {
        zzwh.a(motionevent);
    }

    public void zzb(View view, Map map)
    {
        x.b("performClick must be called on the main UI thread.");
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (!view.equals((View)((WeakReference)entry.getValue()).get()))
            {
                continue;
            }
            performClick((String)entry.getKey());
            break;
        } while (true);
    }

    public ul zzdy()
    {
        zzoL = zzdz();
        zzoL.getWebView().setVisibility(8);
        zzwf.a("/loadHtml", new ox() {

            final zzh zzwk;

            public void zza(ul ul1, Map map)
            {
                zzh.zze(zzwk).i().a(new android.support.v7.um.a(this, map) {

                    final Map zzwl;
                    final _cls1 zzwm;

                    public void zza(ul ul1, boolean flag)
                    {
                        zzh.zza(zzwm.zzwk, (String)zzwl.get("id"));
                        ul1 = new JSONObject();
                        try
                        {
                            ul1.put("messageType", "htmlLoaded");
                            ul1.put("id", zzh.zzc(zzwm.zzwk));
                            zzh.zzd(zzwm.zzwk).b("sendMessageToNativeJs", ul1);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (ul ul1)
                        {
                            com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to dispatch sendMessageToNativeJsevent", ul1);
                        }
                    }

            
            {
                zzwm = _pcls1;
                zzwl = map;
                super();
            }
                });
                ul1 = (String)map.get("overlayHtml");
                zzh.zze(zzwk).loadData(ul1, "text/html", "UTF-8");
            }

            
            {
                zzwk = zzh.this;
                super();
            }
        });
        zzwf.a("/showOverlay", new ox() {

            final zzh zzwk;

            public void zza(ul ul1, Map map)
            {
                zzh.zze(zzwk).getWebView().setVisibility(0);
            }

            
            {
                zzwk = zzh.this;
                super();
            }
        });
        zzwf.a("/hideOverlay", new ox() {

            final zzh zzwk;

            public void zza(ul ul1, Map map)
            {
                zzh.zze(zzwk).getWebView().setVisibility(8);
            }

            
            {
                zzwk = zzh.this;
                super();
            }
        });
        zzoL.i().a("/hideOverlay", new ox() {

            final zzh zzwk;

            public void zza(ul ul1, Map map)
            {
                zzh.zze(zzwk).getWebView().setVisibility(8);
            }

            
            {
                zzwk = zzh.this;
                super();
            }
        });
        zzoL.i().a("/sendMessageToSdk", new ox() {

            final zzh zzwk;

            public void zza(ul ul1, Map map)
            {
                ul1 = new JSONObject();
                try
                {
                    String s;
                    for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ul1.put(s, map.get(s)))
                    {
                        s = (String)iterator.next();
                    }

                }
                // Misplaced declaration of an exception variable
                catch (ul ul1)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to dispatch sendMessageToNativeJs event", ul1);
                    return;
                }
                ul1.put("id", zzh.zzc(zzwk));
                zzh.zzd(zzwk).b("sendMessageToNativeJs", ul1);
                return;
            }

            
            {
                zzwk = zzh.this;
                super();
            }
        });
        return zzoL;
    }

    ul zzdz()
    {
        return zzp.zzby().a(mContext, AdSizeParcel.zzs(mContext), false, false, zzwh, zzpa);
    }

    public void zzh(View view)
    {
    }

    public void zzi(View view)
    {
label0:
        {
            synchronized (zzpc)
            {
                if (!zzwi)
                {
                    break label0;
                }
            }
            return;
        }
        if (view.isShown())
        {
            break MISSING_BLOCK_LABEL_32;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        view;
        obj;
        JVM INSTR monitorexit ;
        throw view;
        if (view.getGlobalVisibleRect(new Rect(), null))
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        recordImpression();
        obj;
        JVM INSTR monitorexit ;
    }

    protected void zzl(boolean flag)
    {
        zzwi = flag;
    }
}
