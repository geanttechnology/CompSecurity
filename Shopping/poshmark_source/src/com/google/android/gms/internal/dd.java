// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            db, cv, cx, dg, 
//            dh, cw, de, df, 
//            ab, da, l, bo

public final class dd extends WebView
    implements DownloadListener
{
    private static class a extends MutableContextWrapper
    {

        private Activity qd;
        private Context qe;

        public void setBaseContext(Context context)
        {
            qe = context.getApplicationContext();
            if (context instanceof Activity)
            {
                context = (Activity)context;
            } else
            {
                context = null;
            }
            qd = context;
            super.setBaseContext(qe);
        }

        public void startActivity(Intent intent)
        {
            if (qd != null)
            {
                qd.startActivity(intent);
                return;
            } else
            {
                intent.setFlags(0x10000000);
                qe.startActivity(intent);
                return;
            }
        }

        public a(Context context)
        {
            super(context);
            setBaseContext(context);
        }
    }


    private ab mF;
    private final db mG;
    private final Object mg = new Object();
    private final l nP;
    private final de pY;
    private final a pZ;
    private bo qa;
    private boolean qb;
    private boolean qc;

    private dd(a a1, ab ab1, boolean flag, boolean flag1, l l1, db db1)
    {
        super(a1);
        pZ = a1;
        mF = ab1;
        qb = flag;
        nP = l1;
        mG = db1;
        setBackgroundColor(0);
        ab1 = getSettings();
        ab1.setJavaScriptEnabled(true);
        ab1.setSavePassword(false);
        ab1.setSupportMultipleWindows(true);
        ab1.setJavaScriptCanOpenWindowsAutomatically(true);
        cv.a(a1, db1.pU, ab1);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            cx.a(getContext(), ab1);
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            cw.a(getContext(), ab1);
        }
        setDownloadListener(this);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            pY = new dg(this, flag1);
        } else
        {
            pY = new de(this, flag1);
        }
        setWebViewClient(pY);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            setWebChromeClient(new dh(this));
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setWebChromeClient(new df(this));
        }
        bf();
    }

    public static dd a(Context context, ab ab1, boolean flag, boolean flag1, l l1, db db1)
    {
        return new dd(new a(context), ab1, flag, flag1, l1, db1);
    }

    private void bf()
    {
        Object obj = mg;
        obj;
        JVM INSTR monitorenter ;
        if (!qb && !mF.lo) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 14) goto _L4; else goto _L3
_L3:
        da.s("Disabling hardware acceleration on an overlay.");
        bg();
_L5:
        return;
_L4:
        da.s("Enabling hardware acceleration on an overlay.");
        bh();
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
            da.s("Disabling hardware acceleration on an AdView.");
            bg();
        }
          goto _L5
        da.s("Enabling hardware acceleration on an AdView.");
        bh();
          goto _L5
    }

    private void bg()
    {
        synchronized (mg)
        {
            if (!qc && android.os.Build.VERSION.SDK_INT >= 11)
            {
                cw.c(this);
            }
            qc = true;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void bh()
    {
        synchronized (mg)
        {
            if (qc && android.os.Build.VERSION.SDK_INT >= 11)
            {
                cw.d(this);
            }
            qc = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ab Q()
    {
        ab ab1;
        synchronized (mg)
        {
            ab1 = mF;
        }
        return ab1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Context context, ab ab1)
    {
        synchronized (mg)
        {
            pZ.setBaseContext(context);
            qa = null;
            mF = ab1;
            qb = false;
            cv.b(this);
            loadUrl("about:blank");
            pY.reset();
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void a(ab ab1)
    {
        synchronized (mg)
        {
            mF = ab1;
            requestLayout();
        }
        return;
        ab1;
        obj;
        JVM INSTR monitorexit ;
        throw ab1;
    }

    public void a(bo bo)
    {
        synchronized (mg)
        {
            qa = bo;
        }
        return;
        bo;
        obj;
        JVM INSTR monitorexit ;
        throw bo;
    }

    public void a(String s, Map map)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        stringbuilder.append("javascript:AFMA_ReceiveMessage('");
        stringbuilder.append(s);
        stringbuilder.append("'");
        if (map == null) goto _L2; else goto _L1
_L1:
        s = cv.m(map);
        if (s instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        s = s.toString();
_L3:
        stringbuilder.append(",");
        stringbuilder.append(s);
_L2:
        stringbuilder.append(");");
        da.v((new StringBuilder()).append("Dispatching AFMA event: ").append(stringbuilder).toString());
        loadUrl(stringbuilder.toString());
        return;
        try
        {
            s = JSONObjectInstrumentation.toString((JSONObject)s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            da.w("Could not convert AFMA event parameters to JSON.");
            return;
        }
          goto _L3
    }

    public void aY()
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", mG.pU);
        a("onhide", hashmap);
    }

    public void aZ()
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", mG.pU);
        a("onshow", hashmap);
    }

    public bo ba()
    {
        bo bo;
        synchronized (mg)
        {
            bo = qa;
        }
        return bo;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public de bb()
    {
        return pY;
    }

    public l bc()
    {
        return nP;
    }

    public db bd()
    {
        return mG;
    }

    public boolean be()
    {
        boolean flag;
        synchronized (mg)
        {
            flag = qb;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void n(boolean flag)
    {
        synchronized (mg)
        {
            qb = flag;
            bf();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onDownloadStart(String s, String s1, String s2, String s3, long l1)
    {
        try
        {
            s1 = new Intent("android.intent.action.VIEW");
            s1.setDataAndType(Uri.parse(s), s3);
            getContext().startActivity(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            da.s((new StringBuilder()).append("Couldn't find an Activity to view url/mimetype: ").append(s).append(" / ").append(s3).toString());
        }
    }

    protected void onMeasure(int i, int j)
    {
        int i1;
label0:
        {
            i1 = 0x7fffffff;
            synchronized (mg)
            {
                if (!isInEditMode() && !qb)
                {
                    break label0;
                }
                super.onMeasure(i, j);
            }
            return;
        }
        int k;
        int j1;
        int k1;
        int l1;
        l1 = android.view.View.MeasureSpec.getMode(i);
        k = android.view.View.MeasureSpec.getSize(i);
        k1 = android.view.View.MeasureSpec.getMode(j);
        j1 = android.view.View.MeasureSpec.getSize(j);
        break MISSING_BLOCK_LABEL_59;
_L3:
        if (mF.widthPixels <= i && mF.heightPixels <= j)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        da.w((new StringBuilder()).append("Not enough space to show ad. Needs ").append(mF.widthPixels).append("x").append(mF.heightPixels).append(" pixels, but only has ").append(k).append("x").append(j1).append(" pixels.").toString());
        if (getVisibility() != 8)
        {
            setVisibility(4);
        }
        setMeasuredDimension(0, 0);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (getVisibility() != 8)
        {
            setVisibility(0);
        }
        setMeasuredDimension(mF.widthPixels, mF.heightPixels);
          goto _L1
        if (l1 != 0x80000000 && l1 != 0x40000000)
        {
            i = 0x7fffffff;
        } else
        {
            i = k;
        }
        if (k1 != 0x80000000)
        {
            j = i1;
            if (k1 != 0x40000000)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        j = j1;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (nP != null)
        {
            nP.a(motionevent);
        }
        return super.onTouchEvent(motionevent);
    }

    public void setContext(Context context)
    {
        pZ.setBaseContext(context);
    }
}
