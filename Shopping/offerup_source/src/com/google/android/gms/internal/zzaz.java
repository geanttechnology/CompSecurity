// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzik, zzax, zzhs, zzdz, 
//            zzbe, zzba, zzmn, zzie, 
//            zzid, zzaw, zzdk

public class zzaz
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener
{

    private boolean zzpJ;
    private final Object zzpd = new Object();
    private zzik zzqM;
    private final Context zzqZ;
    private final WeakReference zzrb;
    private WeakReference zzrc;
    private final WeakReference zzrd;
    private final zzax zzre;
    private final zzdz zzrf;
    private final zzdz.zzd zzrg;
    private boolean zzrh;
    private final WindowManager zzri;
    private final PowerManager zzrj;
    private final KeyguardManager zzrk;
    private zzba zzrl;
    private boolean zzrm;
    private boolean zzrn;
    private boolean zzro;
    private boolean zzrp;
    private BroadcastReceiver zzrq;
    private final HashSet zzrr = new HashSet();
    private final zzdk zzrs = new _cls6();
    private final zzdk zzrt = new _cls7();
    private final zzdk zzru = new _cls8();

    public zzaz(AdSizeParcel adsizeparcel, zzhs zzhs1, VersionInfoParcel versioninfoparcel, View view, zzdz zzdz1)
    {
        zzpJ = false;
        zzrn = false;
        zzrf = zzdz1;
        zzrb = new WeakReference(zzhs1);
        zzrd = new WeakReference(view);
        zzrc = new WeakReference(null);
        zzro = true;
        zzqM = new zzik(200L);
        zzre = new zzax(UUID.randomUUID().toString(), versioninfoparcel, adsizeparcel.zzte, zzhs1.zzHw, zzhs1.zzbY());
        zzrg = zzrf.zzdO();
        zzri = (WindowManager)view.getContext().getSystemService("window");
        zzrj = (PowerManager)view.getContext().getApplicationContext().getSystemService("power");
        zzrk = (KeyguardManager)view.getContext().getSystemService("keyguard");
        zzqZ = view.getContext().getApplicationContext();
        try
        {
            adsizeparcel = zzd(view);
            zzrg.zza(new _cls1(adsizeparcel), new _cls2());
        }
        // Misplaced declaration of an exception variable
        catch (AdSizeParcel adsizeparcel) { }
        // Misplaced declaration of an exception variable
        catch (AdSizeParcel adsizeparcel)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failure while processing active view data.", adsizeparcel);
        }
        zzrg.zza(new _cls3(), new _cls4());
        com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder("Tracking ad unit: ")).append(zzre.zzbX()).toString());
    }

    static zzax zzb(zzaz zzaz1)
    {
        return zzaz1.zzre;
    }

    static boolean zzb(zzaz zzaz1, boolean flag)
    {
        zzaz1.zzrh = flag;
        return flag;
    }

    protected void destroy()
    {
        synchronized (zzpd)
        {
            zzcf();
            zzca();
            zzro = false;
            zzcc();
            zzrg.release();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean isScreenOn()
    {
        return zzrj.isScreenOn();
    }

    public void onGlobalLayout()
    {
        zzh(false);
    }

    public void onScrollChanged()
    {
        zzh(true);
    }

    public void pause()
    {
        synchronized (zzpd)
        {
            zzpJ = true;
            zzh(false);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void resume()
    {
        synchronized (zzpd)
        {
            zzpJ = false;
            zzh(false);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void stop()
    {
        synchronized (zzpd)
        {
            zzrn = true;
            zzh(false);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected int zza(int i, DisplayMetrics displaymetrics)
    {
        float f = displaymetrics.density;
        return (int)((float)i / f);
    }

    protected void zza(View view, Map map)
    {
        zzh(false);
    }

    public void zza(zzaw zzaw1)
    {
        zzrr.add(zzaw1);
    }

    public void zza(zzba zzba1)
    {
        synchronized (zzpd)
        {
            zzrl = zzba1;
        }
        return;
        zzba1;
        obj;
        JVM INSTR monitorexit ;
        throw zzba1;
    }

    protected void zza(zzbe zzbe1)
    {
        zzbe1.zza("/updateActiveView", zzrs);
        zzbe1.zza("/untrackActiveViewUnit", zzrt);
        zzbe1.zza("/visibilityChanged", zzru);
    }

    protected void zza(JSONObject jsonobject)
    {
        try
        {
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobject1 = new JSONObject();
            jsonarray.put(jsonobject);
            jsonobject1.put("units", jsonarray);
            zzrg.zza(new _cls9(jsonobject1), new zzis.zzb());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Skipping active view message.", jsonobject);
        }
    }

    protected boolean zzb(Map map)
    {
        if (map == null)
        {
            return false;
        }
        map = (String)map.get("hashCode");
        return !TextUtils.isEmpty(map) && map.equals(zzre.zzbX());
    }

    protected void zzbZ()
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzrq == null)
                {
                    break label0;
                }
            }
            return;
        }
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        zzrq = new _cls5();
        zzqZ.registerReceiver(zzrq, intentfilter);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void zzca()
    {
        synchronized (zzpd)
        {
            if (zzrq != null)
            {
                zzqZ.unregisterReceiver(zzrq);
                zzrq = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzcb()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (!zzro) goto _L2; else goto _L1
_L1:
        zzrp = true;
        zza(zzch());
_L3:
        com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder("Untracking ad unit: ")).append(zzre.zzbX()).toString());
_L2:
        return;
        Object obj1;
        obj1;
        com.google.android.gms.ads.internal.util.client.zzb.zzb("JSON failure while processing active view data.", ((Throwable) (obj1)));
          goto _L3
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        com.google.android.gms.ads.internal.util.client.zzb.zzb("Failure while processing active view data.", ((Throwable) (obj1)));
          goto _L3
    }

    protected void zzcc()
    {
        if (zzrl != null)
        {
            zzrl.zza(this);
        }
    }

    public boolean zzcd()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzro;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void zzce()
    {
        Object obj = (View)zzrd.get();
        if (obj != null)
        {
            ViewTreeObserver viewtreeobserver = (ViewTreeObserver)zzrc.get();
            obj = ((View) (obj)).getViewTreeObserver();
            if (obj != viewtreeobserver)
            {
                zzcf();
                if (!zzrm || viewtreeobserver != null && viewtreeobserver.isAlive())
                {
                    zzrm = true;
                    ((ViewTreeObserver) (obj)).addOnScrollChangedListener(this);
                    ((ViewTreeObserver) (obj)).addOnGlobalLayoutListener(this);
                }
                zzrc = new WeakReference(obj);
                return;
            }
        }
    }

    protected void zzcf()
    {
        ViewTreeObserver viewtreeobserver = (ViewTreeObserver)zzrc.get();
        if (viewtreeobserver == null || !viewtreeobserver.isAlive())
        {
            return;
        } else
        {
            viewtreeobserver.removeOnScrollChangedListener(this);
            viewtreeobserver.removeGlobalOnLayoutListener(this);
            return;
        }
    }

    protected JSONObject zzcg()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("afmaVersion", zzre.zzbV()).put("activeViewJSON", zzre.zzbW()).put("timestamp", zzp.zzbz().elapsedRealtime()).put("adFormat", zzre.zzbU()).put("hashCode", zzre.zzbX()).put("isMraid", zzre.zzbY());
        return jsonobject;
    }

    protected JSONObject zzch()
    {
        JSONObject jsonobject = zzcg();
        jsonobject.put("doneReasonCode", "u");
        return jsonobject;
    }

    protected JSONObject zzd(View view)
    {
        boolean flag = zzp.zzbx().isAttachedToWindow(view);
        int ai1[] = new int[2];
        int ai[] = new int[2];
        DisplayMetrics displaymetrics;
        Rect rect;
        Rect rect1;
        Rect rect2;
        Rect rect3;
        Rect rect4;
        JSONObject jsonobject;
        boolean flag1;
        boolean flag2;
        try
        {
            view.getLocationOnScreen(ai1);
            view.getLocationInWindow(ai);
        }
        catch (Exception exception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failure getting view location.", exception);
        }
        displaymetrics = view.getContext().getResources().getDisplayMetrics();
        rect = new Rect();
        rect.left = ai1[0];
        rect.top = ai1[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        rect1 = new Rect();
        rect1.right = zzri.getDefaultDisplay().getWidth();
        rect1.bottom = zzri.getDefaultDisplay().getHeight();
        rect2 = new Rect();
        flag1 = view.getGlobalVisibleRect(rect2, null);
        rect3 = new Rect();
        flag2 = view.getLocalVisibleRect(rect3);
        rect4 = new Rect();
        view.getHitRect(rect4);
        jsonobject = zzcg();
        jsonobject.put("windowVisibility", view.getWindowVisibility()).put("isStopped", zzrn).put("isPaused", zzpJ).put("isScreenOn", isScreenOn()).put("isAttachedToWindow", flag).put("viewBox", (new JSONObject()).put("top", zza(rect1.top, displaymetrics)).put("bottom", zza(rect1.bottom, displaymetrics)).put("left", zza(rect1.left, displaymetrics)).put("right", zza(rect1.right, displaymetrics))).put("adBox", (new JSONObject()).put("top", zza(rect.top, displaymetrics)).put("bottom", zza(rect.bottom, displaymetrics)).put("left", zza(rect.left, displaymetrics)).put("right", zza(rect.right, displaymetrics))).put("globalVisibleBox", (new JSONObject()).put("top", zza(rect2.top, displaymetrics)).put("bottom", zza(rect2.bottom, displaymetrics)).put("left", zza(rect2.left, displaymetrics)).put("right", zza(rect2.right, displaymetrics))).put("globalVisibleBoxVisible", flag1).put("localVisibleBox", (new JSONObject()).put("top", zza(rect3.top, displaymetrics)).put("bottom", zza(rect3.bottom, displaymetrics)).put("left", zza(rect3.left, displaymetrics)).put("right", zza(rect3.right, displaymetrics))).put("localVisibleBoxVisible", flag2).put("hitBox", (new JSONObject()).put("top", zza(rect4.top, displaymetrics)).put("bottom", zza(rect4.bottom, displaymetrics)).put("left", zza(rect4.left, displaymetrics)).put("right", zza(rect4.right, displaymetrics))).put("screenDensity", displaymetrics.density).put("isVisible", zze(view));
        return jsonobject;
    }

    protected boolean zze(View view)
    {
        return view.getVisibility() == 0 && view.isShown() && isScreenOn() && (!zzrk.inKeyguardRestrictedInputMode() || zzp.zzbv().zzgB());
    }

    protected void zzg(boolean flag)
    {
        for (Iterator iterator = zzrr.iterator(); iterator.hasNext(); ((zzaw)iterator.next()).zza(this, flag)) { }
    }

    protected void zzh(boolean flag)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzrh && zzro)
                {
                    break label0;
                }
            }
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        if (zzqM.tryAcquire())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        obj1;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        zzhs zzhs1;
        View view;
        zzhs1 = (zzhs)zzrb.get();
        view = (View)zzrd.get();
        Object obj;
        boolean flag1;
        if (view != null && zzhs1 != null)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        zzcb();
        obj1;
        JVM INSTR monitorexit ;
        return;
        zza(zzd(view));
_L2:
        zzce();
        zzcc();
        obj1;
        JVM INSTR monitorexit ;
        return;
_L3:
        com.google.android.gms.ads.internal.util.client.zzb.zza("Active view update failed.", ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
          goto _L3
        obj;
          goto _L3
    }

    private class _cls6
        implements zzdk
    {

        final zzaz zzrw;

        public void zza(zziz zziz1, Map map)
        {
            if (!zzrw.zzb(map))
            {
                return;
            } else
            {
                zzrw.zza(zziz1.getView(), map);
                return;
            }
        }

        _cls6()
        {
            zzrw = zzaz.this;
            super();
        }
    }


    private class _cls7
        implements zzdk
    {

        final zzaz zzrw;

        public void zza(zziz zziz, Map map)
        {
            if (!zzrw.zzb(map))
            {
                return;
            } else
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder("Received request to untrack: ")).append(com.google.android.gms.internal.zzaz.zzb(zzrw).zzbX()).toString());
                zzrw.destroy();
                return;
            }
        }

        _cls7()
        {
            zzrw = zzaz.this;
            super();
        }
    }


    private class _cls8
        implements zzdk
    {

        final zzaz zzrw;

        public void zza(zziz zziz, Map map)
        {
            while (!zzrw.zzb(map) || !map.containsKey("isVisible")) 
            {
                return;
            }
            boolean flag;
            if ("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzrw.zzg(Boolean.valueOf(flag).booleanValue());
        }

        _cls8()
        {
            zzrw = zzaz.this;
            super();
        }
    }


    private class _cls1
        implements zzis.zzc
    {

        final JSONObject zzrv;
        final zzaz zzrw;

        public void zzb(zzbe zzbe1)
        {
            zzrw.zza(zzrv);
        }

        public void zzc(Object obj)
        {
            zzb((zzbe)obj);
        }

        _cls1(JSONObject jsonobject)
        {
            zzrw = zzaz.this;
            zzrv = jsonobject;
            super();
        }
    }


    private class _cls2
        implements zzis.zza
    {

        final zzaz zzrw;

        public void run()
        {
        }

        _cls2()
        {
            zzrw = zzaz.this;
            super();
        }
    }


    private class _cls3
        implements zzis.zzc
    {

        final zzaz zzrw;

        public void zzb(zzbe zzbe1)
        {
            com.google.android.gms.internal.zzaz.zzb(zzrw, true);
            zzrw.zza(zzbe1);
            zzrw.zzbZ();
            zzrw.zzh(false);
        }

        public void zzc(Object obj)
        {
            zzb((zzbe)obj);
        }

        _cls3()
        {
            zzrw = zzaz.this;
            super();
        }
    }


    private class _cls4
        implements zzis.zza
    {

        final zzaz zzrw;

        public void run()
        {
            zzrw.destroy();
        }

        _cls4()
        {
            zzrw = zzaz.this;
            super();
        }
    }


    private class _cls9
        implements zzis.zzc
    {

        final zzaz zzrw;
        final JSONObject zzrx;

        public void zzb(zzbe zzbe1)
        {
            zzbe1.zza("AFMA_updateActiveView", zzrx);
        }

        public void zzc(Object obj)
        {
            zzb((zzbe)obj);
        }

        _cls9(JSONObject jsonobject)
        {
            zzrw = zzaz.this;
            zzrx = jsonobject;
            super();
        }
    }


    private class _cls5 extends BroadcastReceiver
    {

        final zzaz zzrw;

        public void onReceive(Context context, Intent intent)
        {
            zzrw.zzh(false);
        }

        _cls5()
        {
            zzrw = zzaz.this;
            super();
        }
    }

}
