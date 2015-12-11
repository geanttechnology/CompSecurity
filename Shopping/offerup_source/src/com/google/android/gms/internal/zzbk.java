// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzby, zzbu, zzbj, zzgq, 
//            zzbh, zziz, zzbi, zzmx

public class zzbk extends Thread
{

    private boolean mStarted;
    private boolean zzam;
    private final Object zzpd = new Object();
    private final int zzrN;
    private final int zzrP;
    private boolean zzrZ;
    private final zzbj zzsa;
    private final zzbi zzsb;
    private final zzgq zzsc;
    private final int zzsd;
    private final int zzse;
    private final int zzsf;

    public zzbk(zzbj zzbj1, zzbi zzbi1, zzgq zzgq1)
    {
        mStarted = false;
        zzrZ = false;
        zzam = false;
        zzsa = zzbj1;
        zzsb = zzbi1;
        zzsc = zzgq1;
        zzrN = ((Integer)zzby.zzuU.get()).intValue();
        zzse = ((Integer)zzby.zzuV.get()).intValue();
        zzrP = ((Integer)zzby.zzuW.get()).intValue();
        zzsf = ((Integer)zzby.zzuX.get()).intValue();
        zzsd = ((Integer)zzby.zzuY.get()).intValue();
        setName("ContentFetchTask");
    }

    public void run()
    {
_L11:
        if (zzam)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!zzcu()) goto _L2; else goto _L1
_L1:
        Object obj = zzsa.getActivity();
        if (obj != null) goto _L4; else goto _L3
_L3:
        try
        {
            zzb.zzaF("ContentFetchThread: no activity");
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzb.zzb("Error in ContentFetchTask", ((Throwable) (obj)));
            zzsc.zza(((Throwable) (obj)), true);
        }
_L8:
        obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
_L7:
        boolean flag = zzrZ;
        if (!flag) goto _L6; else goto _L5
_L5:
        Exception exception;
        try
        {
            zzb.zzaF("ContentFetchTask: waiting");
            zzpd.wait();
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        if (true) goto _L7; else goto _L6
_L4:
        zza(((Activity) (obj)));
_L9:
        Thread.sleep(zzsd * 1000);
          goto _L8
_L2:
        zzb.zzaF("ContentFetchTask: sleeping");
        zzcw();
          goto _L9
_L6:
        obj;
        JVM INSTR monitorexit ;
        if (true) goto _L11; else goto _L10
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L10:
    }

    public void wakeup()
    {
        synchronized (zzpd)
        {
            zzrZ = false;
            zzpd.notifyAll();
            zzb.zzaF("ContentFetchThread: wakeup");
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    zza zza(View view, zzbh zzbh1)
    {
        int i = 0;
        if (view == null)
        {
            return new zza(0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText))
        {
            view = ((TextView)view).getText();
            if (!TextUtils.isEmpty(view))
            {
                zzbh1.zzw(view.toString());
                return new zza(1, 0);
            } else
            {
                return new zza(0, 0);
            }
        }
        if ((view instanceof WebView) && !(view instanceof zziz))
        {
            zzbh1.zzcp();
            if (zza((WebView)view, zzbh1))
            {
                return new zza(0, 1);
            } else
            {
                return new zza(0, 0);
            }
        }
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int j = 0;
            int k = 0;
            for (; i < view.getChildCount(); i++)
            {
                zza zza1 = zza(view.getChildAt(i), zzbh1);
                k += zza1.zzsm;
                j += zza1.zzsn;
            }

            return new zza(k, j);
        } else
        {
            return new zza(0, 0);
        }
    }

    void zza(Activity activity)
    {
        if (activity != null)
        {
            Object obj = null;
            View view = obj;
            if (activity.getWindow() != null)
            {
                view = obj;
                if (activity.getWindow().getDecorView() != null)
                {
                    view = activity.getWindow().getDecorView().findViewById(0x1020002);
                }
            }
            if (view != null)
            {
                zzf(view);
                return;
            }
        }
    }

    void zza(zzbh zzbh1, WebView webview, String s)
    {
        zzbh1.zzco();
        if (!TextUtils.isEmpty(s))
        {
            s = (new JSONObject(s)).optString("text");
            if (TextUtils.isEmpty(webview.getTitle()))
            {
                break MISSING_BLOCK_LABEL_83;
            }
            zzbh1.zzv((new StringBuilder()).append(webview.getTitle()).append("\n").append(s).toString());
        }
_L2:
        if (zzbh1.zzcl())
        {
            zzsb.zzb(zzbh1);
            return;
        }
        break MISSING_BLOCK_LABEL_116;
        zzbh1.zzv(s);
        if (true) goto _L2; else goto _L1
_L1:
        zzbh1;
        zzb.zzaF("Json string may be malformed.");
        return;
        zzbh1;
        zzb.zza("Failed to get webview content.", zzbh1);
        zzsc.zza(zzbh1, true);
    }

    boolean zza(android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo)
    {
        return runningappprocessinfo.importance == 100;
    }

    boolean zza(WebView webview, zzbh zzbh1)
    {
        if (!zzmx.zzqB())
        {
            return false;
        } else
        {
            zzbh1.zzcp();
            webview.post(new _cls2(zzbh1, webview));
            return true;
        }
    }

    public void zzct()
    {
label0:
        {
            synchronized (zzpd)
            {
                if (!mStarted)
                {
                    break label0;
                }
                zzb.zzaF("Content hash thread already started, quiting...");
            }
            return;
        }
        mStarted = true;
        obj;
        JVM INSTR monitorexit ;
        start();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean zzcu()
    {
        Context context;
        KeyguardManager keyguardmanager;
        Object obj;
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        boolean flag;
        try
        {
            context = zzsa.getContext();
        }
        catch (Throwable throwable)
        {
            return false;
        }
        if (context == null)
        {
            return false;
        }
        obj = (ActivityManager)context.getSystemService("activity");
        keyguardmanager = (KeyguardManager)context.getSystemService("keyguard");
        if (obj == null || keyguardmanager == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        obj = ((ActivityManager) (obj)).getRunningAppProcesses();
        if (obj == null)
        {
            return false;
        }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_126;
            }
            runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
        } while (Process.myPid() != runningappprocessinfo.pid);
        if (!zza(runningappprocessinfo) || keyguardmanager.inKeyguardRestrictedInputMode())
        {
            break MISSING_BLOCK_LABEL_126;
        }
        flag = zzr(context);
        if (flag)
        {
            return true;
        }
        return false;
        return false;
    }

    public zzbh zzcv()
    {
        return zzsb.zzcs();
    }

    public void zzcw()
    {
        synchronized (zzpd)
        {
            zzrZ = true;
            zzb.zzaF((new StringBuilder("ContentFetchThread: paused, mPause = ")).append(zzrZ).toString());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean zzcx()
    {
        return zzrZ;
    }

    boolean zzf(View view)
    {
        if (view == null)
        {
            return false;
        } else
        {
            view.post(new _cls1(view));
            return true;
        }
    }

    void zzg(View view)
    {
        zzbh zzbh1;
        zzbh1 = new zzbh(zzrN, zzse, zzrP, zzsf);
        view = zza(view, zzbh1);
        zzbh1.zzcq();
        if (((zza) (view)).zzsm == 0 && ((zza) (view)).zzsn == 0)
        {
            return;
        }
        try
        {
            if ((((zza) (view)).zzsn != 0 || zzbh1.zzcr() != 0) && (((zza) (view)).zzsn != 0 || !zzsb.zza(zzbh1)))
            {
                zzsb.zzc(zzbh1);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            zzb.zzb("Exception in fetchContentOnUIThread", view);
            zzsc.zza(view, true);
        }
        return;
    }

    boolean zzr(Context context)
    {
        context = (PowerManager)context.getSystemService("power");
        if (context == null)
        {
            return false;
        } else
        {
            return context.isScreenOn();
        }
    }

    private class zza
    {

        final zzbk zzsh;
        final int zzsm;
        final int zzsn;

        zza(int i, int j)
        {
            zzsh = zzbk.this;
            super();
            zzsm = i;
            zzsn = j;
        }
    }


    private class _cls2
        implements Runnable
    {

        final zzbk zzsh;
        ValueCallback zzsi;
        final zzbh zzsj;
        final WebView zzsk;

        public void run()
        {
            if (!zzsk.getSettings().getJavaScriptEnabled())
            {
                break MISSING_BLOCK_LABEL_26;
            }
            zzsk.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", zzsi);
            return;
            Throwable throwable;
            throwable;
            zzsi.onReceiveValue("");
            return;
        }

        _cls2(zzbh zzbh1, WebView webview)
        {
            zzsh = zzbk.this;
            zzsj = zzbh1;
            zzsk = webview;
            super();
            class _cls1
                implements ValueCallback
            {

                final _cls2 zzsl;

                public void onReceiveValue(Object obj)
                {
                    zzy((String)obj);
                }

                public void zzy(String s)
                {
                    zzsl.zzsh.zza(zzsl.zzsj, zzsl.zzsk, s);
                }

                _cls1()
                {
                    zzsl = _cls2.this;
                    super();
                }
            }

            zzsi = new _cls1();
        }
    }


    private class _cls1
        implements Runnable
    {

        final View zzsg;
        final zzbk zzsh;

        public void run()
        {
            zzsh.zzg(zzsg);
        }

        _cls1(View view)
        {
            zzsh = zzbk.this;
            zzsg = view;
            super();
        }
    }

}
