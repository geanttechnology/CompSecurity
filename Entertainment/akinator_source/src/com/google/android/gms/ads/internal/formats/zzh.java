// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzb

public class zzh
{

    private final Context mContext;
    private zziz zzoM;
    private final VersionInfoParcel zzpb;
    private final Object zzpd = new Object();
    private final zzn zzwF;
    private final JSONObject zzwI;
    private final zzbb zzwJ;
    private final zza zzwK;
    private final zzan zzwL;
    private boolean zzwM;
    private String zzwN;

    public zzh(Context context, zzn zzn1, zzbb zzbb1, zzan zzan1, JSONObject jsonobject, zza zza1, VersionInfoParcel versioninfoparcel)
    {
        mContext = context;
        zzwF = zzn1;
        zzwJ = zzbb1;
        zzwL = zzan1;
        zzwI = jsonobject;
        zzwK = zza1;
        zzpb = versioninfoparcel;
    }

    static String zza(zzh zzh1, String s)
    {
        zzh1.zzwN = s;
        return s;
    }

    static String zzc(zzh zzh1)
    {
        return zzh1.zzwN;
    }

    static zzbb zzd(zzh zzh1)
    {
        return zzh1.zzwJ;
    }

    static zziz zze(zzh zzh1)
    {
        return zzh1.zzoM;
    }

    public Context getContext()
    {
        return mContext;
    }

    public void recordImpression()
    {
        zzx.zzci("recordImpression must be called on the main UI thread.");
        zzl(true);
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("ad", zzwI);
            zzwJ.zza("google.afma.nativeAds.handleImpressionPing", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to create impression JSON.", jsonexception);
        }
    }

    public com.google.android.gms.ads.internal.formats.zzb zza(android.view.View.OnClickListener onclicklistener)
    {
    /* block-local class not found */
    class zza {}

        Object obj = zzwK.zzdz();
        if (obj == null)
        {
            return null;
        } else
        {
            obj = new com.google.android.gms.ads.internal.formats.zzb(mContext, ((zza) (obj)));
            ((com.google.android.gms.ads.internal.formats.zzb) (obj)).setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            ((com.google.android.gms.ads.internal.formats.zzb) (obj)).zzdu().setOnClickListener(onclicklistener);
            ((com.google.android.gms.ads.internal.formats.zzb) (obj)).zzdu().setContentDescription("Ad attribution icon");
            return ((com.google.android.gms.ads.internal.formats.zzb) (obj));
        }
    }

    public void zza(View view, Map map, JSONObject jsonobject, JSONObject jsonobject1)
    {
        zzx.zzci("performClick must be called on the main UI thread.");
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
            zza((String)entry.getKey(), jsonobject, jsonobject1);
            break;
        } while (true);
    }

    public void zza(String s, JSONObject jsonobject, JSONObject jsonobject1)
    {
        zzx.zzci("performClick must be called on the main UI thread.");
        JSONObject jsonobject2 = new JSONObject();
        jsonobject2.put("asset", s);
        jsonobject2.put("template", zzwK.zzdy());
        s = new JSONObject();
        s.put("ad", zzwI);
        s.put("click", jsonobject2);
        boolean flag;
        if (zzwF.zzr(zzwK.getCustomTemplateId()) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            s.put("has_custom_click_handler", flag);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to create click JSON.", s);
            return;
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        s.put("view_rectangles", jsonobject);
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        s.put("click_point", jsonobject1);
        zzwJ.zza("google.afma.nativeAds.handleClickGmsg", s);
        return;
    }

    public void zzb(MotionEvent motionevent)
    {
        zzwL.zza(motionevent);
    }

    public zziz zzdC()
    {
        zzoM = zzdD();
        zzoM.getView().setVisibility(8);
        zzwJ.zza("/loadHtml", new _cls1());
        zzwJ.zza("/showOverlay", new _cls2());
        zzwJ.zza("/hideOverlay", new _cls3());
        zzoM.zzhe().zza("/hideOverlay", new _cls4());
        zzoM.zzhe().zza("/sendMessageToSdk", new _cls5());
        return zzoM;
    }

    zziz zzdD()
    {
        return zzp.zzbw().zza(mContext, AdSizeParcel.zzs(mContext), false, false, zzwL, zzpb);
    }

    public void zzh(View view)
    {
    }

    public void zzi(View view)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (!zzwM)
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
        zzwM = flag;
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}

}
