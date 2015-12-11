// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            zzb, zzh, zzg

public class zzj extends com.google.android.gms.internal.zzco.zza
    implements android.view.View.OnClickListener, android.view.View.OnTouchListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener
{

    private final FrameLayout zznZ;
    private final Object zzpd = new Object();
    private final FrameLayout zzwU;
    private final Map zzwV = new HashMap();
    private com.google.android.gms.ads.internal.formats.zzb zzwW;
    boolean zzwX;
    int zzwY;
    int zzwZ;
    private zzh zzwx;

    public zzj(FrameLayout framelayout, FrameLayout framelayout1)
    {
        zzwX = false;
        zzwU = framelayout;
        zznZ = framelayout1;
        zziu.zza(zzwU, this);
        zziu.zza(zzwU, this);
        zzwU.setOnTouchListener(this);
    }

    static FrameLayout zza(zzj zzj1)
    {
        return zzj1.zznZ;
    }

    int getMeasuredHeight()
    {
        return zzwU.getMeasuredHeight();
    }

    int getMeasuredWidth()
    {
        return zzwU.getMeasuredWidth();
    }

    public void onClick(View view)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzwx != null)
                {
                    break label0;
                }
            }
            return;
        }
        JSONObject jsonobject;
        Object obj1;
        jsonobject = new JSONObject();
        obj1 = zzwV.entrySet().iterator();
_L1:
        java.util.Map.Entry entry;
        View view1;
        Point point;
        JSONObject jsonobject1;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_224;
        }
        entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
        view1 = (View)((WeakReference)entry.getValue()).get();
        point = zzj(view1);
        jsonobject1 = new JSONObject();
        jsonobject1.put("width", zzp(view1.getWidth()));
        jsonobject1.put("height", zzp(view1.getHeight()));
        jsonobject1.put("x", zzp(point.x));
        jsonobject1.put("y", zzp(point.y));
        jsonobject.put((String)entry.getKey(), jsonobject1);
          goto _L1
        JSONException jsonexception1;
        jsonexception1;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Unable to get view rectangle for view ")).append((String)entry.getKey()).toString());
          goto _L1
        view;
        obj;
        JVM INSTR monitorexit ;
        throw view;
        obj1 = new JSONObject();
        ((JSONObject) (obj1)).put("x", zzp(zzwY));
        ((JSONObject) (obj1)).put("y", zzp(zzwZ));
_L2:
        if (zzwW == null || !zzwW.zzdu().equals(view))
        {
            break MISSING_BLOCK_LABEL_311;
        }
        zzwx.zza("1007", jsonobject, ((JSONObject) (obj1)));
_L3:
        obj;
        JVM INSTR monitorexit ;
        return;
        JSONException jsonexception;
        jsonexception;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get click location");
          goto _L2
        zzwx.zza(view, zzwV, jsonobject, ((JSONObject) (obj1)));
          goto _L3
    }

    public void onGlobalLayout()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        int i;
        int j;
        if (!zzwX)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        i = getMeasuredWidth();
        j = getMeasuredHeight();
        if (i == 0 || j == 0)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        zznZ.setLayoutParams(new android.widget.FrameLayout.LayoutParams(i, j));
        zzwX = false;
        if (zzwx != null)
        {
            zzwx.zzi(zzwU);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onScrollChanged()
    {
        synchronized (zzpd)
        {
            if (zzwx != null)
            {
                zzwx.zzi(zzwU);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzwx != null)
                {
                    break label0;
                }
            }
            return false;
        }
        Point point = zzc(motionevent);
        zzwY = point.x;
        zzwZ = point.y;
        motionevent = MotionEvent.obtain(motionevent);
        motionevent.setLocation(point.x, point.y);
        zzwx.zzb(motionevent);
        motionevent.recycle();
        view;
        JVM INSTR monitorexit ;
        return false;
        motionevent;
        view;
        JVM INSTR monitorexit ;
        throw motionevent;
    }

    public zzd zzW(String s)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        s = (WeakReference)zzwV.get(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        s = zze.zzy(s);
        obj;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = (View)s.get();
        if (true) goto _L4; else goto _L3
_L3:
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void zza(String s, zzd zzd)
    {
        View view = (View)zze.zzp(zzd);
        zzd = ((zzd) (zzpd));
        zzd;
        JVM INSTR monitorenter ;
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        zzwV.remove(s);
_L2:
        zzd;
        JVM INSTR monitorexit ;
        return;
        zzwV.put(s, new WeakReference(view));
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        zzd;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void zzb(zzd zzd)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzwX = true;
        zzd = (zzh)zze.zzp(zzd);
        if (!(zzwx instanceof zzg) || !((zzg)zzwx).zzdB())
        {
            break MISSING_BLOCK_LABEL_141;
        }
        ((zzg)zzwx).zzb(zzd);
_L2:
        zznZ.removeAllViews();
        zzwW = zzf(zzd);
        if (zzwW != null)
        {
            zzwV.put("1007", new WeakReference(zzwW.zzdu()));
            zznZ.addView(zzwW);
        }
        zzid.zzIE.post(new _cls1(zzd));
        zzd.zzh(zzwU);
        return;
        zzwx = zzd;
        if (zzwx instanceof zzg)
        {
            ((zzg)zzwx).zzb(null);
        }
        if (true) goto _L2; else goto _L1
_L1:
        zzd;
        obj;
        JVM INSTR monitorexit ;
        throw zzd;
    }

    Point zzc(MotionEvent motionevent)
    {
        int ai[] = new int[2];
        zzwU.getLocationOnScreen(ai);
        float f = motionevent.getRawX();
        float f1 = ai[0];
        float f2 = motionevent.getRawY();
        float f3 = ai[1];
        return new Point((int)(f - f1), (int)(f2 - f3));
    }

    com.google.android.gms.ads.internal.formats.zzb zzf(zzh zzh1)
    {
        return zzh1.zza(this);
    }

    Point zzj(View view)
    {
        if (zzwW != null && zzwW.zzdu().equals(view))
        {
            Point point = new Point();
            zzwU.getGlobalVisibleRect(new Rect(), point);
            Point point2 = new Point();
            view.getGlobalVisibleRect(new Rect(), point2);
            return new Point(point2.x - point.x, point2.y - point.y);
        } else
        {
            Point point1 = new Point();
            view.getGlobalVisibleRect(new Rect(), point1);
            return point1;
        }
    }

    int zzp(int i)
    {
        return zzl.zzcF().zzc(zzwx.getContext(), i);
    }

    private class _cls1
        implements Runnable
    {

        final zzh zzxa;
        final zzj zzxb;

        public void run()
        {
            zziz zziz1 = zzxa.zzdC();
            if (zziz1 != null)
            {
                com.google.android.gms.ads.internal.formats.zzj.zza(zzxb).addView(zziz1.getView());
            }
        }

        _cls1(zzh zzh1)
        {
            zzxb = zzj.this;
            zzxa = zzh1;
            super();
        }
    }

}
