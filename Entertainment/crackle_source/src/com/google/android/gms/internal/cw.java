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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            cu, co, cq, cz, 
//            da, cp, cx, cy, 
//            x, ct, h, bk

public final class cw extends WebView
    implements DownloadListener
{
    private static class a extends MutableContextWrapper
    {

        private Activity iS;
        private Context iT;

        public void setBaseContext(Context context)
        {
            iT = context.getApplicationContext();
            if (context instanceof Activity)
            {
                context = (Activity)context;
            } else
            {
                context = null;
            }
            iS = context;
            super.setBaseContext(iT);
        }

        public void startActivity(Intent intent)
        {
            if (iS != null)
            {
                iS.startActivity(intent);
                return;
            } else
            {
                intent.setFlags(0x10000000);
                iT.startActivity(intent);
                return;
            }
        }

        public a(Context context)
        {
            super(context);
            setBaseContext(context);
        }
    }


    private x fU;
    private final cu fV;
    private final Object fx = new Object();
    private final h he;
    private final cx iN;
    private final a iO;
    private bk iP;
    private boolean iQ;
    private boolean iR;

    private cw(a a1, x x1, boolean flag, boolean flag1, h h1, cu cu1)
    {
        super(a1);
        iO = a1;
        fU = x1;
        iQ = flag;
        he = h1;
        fV = cu1;
        setBackgroundColor(0);
        x1 = getSettings();
        x1.setJavaScriptEnabled(true);
        x1.setSavePassword(false);
        x1.setSupportMultipleWindows(true);
        x1.setJavaScriptCanOpenWindowsAutomatically(true);
        co.a(a1, cu1.iJ, x1);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            cq.a(getContext(), x1);
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            cp.a(getContext(), x1);
        }
        setDownloadListener(this);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            iN = new cz(this, flag1);
        } else
        {
            iN = new cx(this, flag1);
        }
        setWebViewClient(iN);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            setWebChromeClient(new da(this));
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setWebChromeClient(new cy(this));
        }
        aG();
    }

    public static cw a(Context context, x x1, boolean flag, boolean flag1, h h1, cu cu1)
    {
        return new cw(new a(context), x1, flag, flag1, h1, cu1);
    }

    private void aG()
    {
        Object obj = fx;
        obj;
        JVM INSTR monitorenter ;
        if (!iQ && !fU.eG) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 14) goto _L4; else goto _L3
_L3:
        ct.r("Disabling hardware acceleration on an overlay.");
        aH();
_L5:
        return;
_L4:
        ct.r("Enabling hardware acceleration on an overlay.");
        aI();
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
            ct.r("Disabling hardware acceleration on an AdView.");
            aH();
        }
          goto _L5
        ct.r("Enabling hardware acceleration on an AdView.");
        aI();
          goto _L5
    }

    private void aH()
    {
        synchronized (fx)
        {
            if (!iR && android.os.Build.VERSION.SDK_INT >= 11)
            {
                cp.c(this);
            }
            iR = true;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void aI()
    {
        synchronized (fx)
        {
            if (iR && android.os.Build.VERSION.SDK_INT >= 11)
            {
                cp.d(this);
            }
            iR = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Context context, x x1)
    {
        synchronized (fx)
        {
            iO.setBaseContext(context);
            iP = null;
            fU = x1;
            iQ = false;
            co.b(this);
            loadUrl("about:blank");
            iN.reset();
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void a(bk bk)
    {
        synchronized (fx)
        {
            iP = bk;
        }
        return;
        bk;
        obj;
        JVM INSTR monitorexit ;
        throw bk;
    }

    public void a(x x1)
    {
        synchronized (fx)
        {
            fU = x1;
            requestLayout();
        }
        return;
        x1;
        obj;
        JVM INSTR monitorexit ;
        throw x1;
    }

    public void a(String s, Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("javascript:AFMA_ReceiveMessage('");
        stringbuilder.append(s);
        stringbuilder.append("'");
        if (map != null)
        {
            try
            {
                s = co.m(map).toString();
                stringbuilder.append(",");
                stringbuilder.append(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ct.v("Could not convert AFMA event parameters to JSON.");
                return;
            }
        }
        stringbuilder.append(");");
        ct.u((new StringBuilder()).append("Dispatching AFMA event: ").append(stringbuilder).toString());
        loadUrl(stringbuilder.toString());
    }

    public void aA()
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", fV.iJ);
        a("onshow", hashmap);
    }

    public bk aB()
    {
        bk bk;
        synchronized (fx)
        {
            bk = iP;
        }
        return bk;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public cx aC()
    {
        return iN;
    }

    public h aD()
    {
        return he;
    }

    public cu aE()
    {
        return fV;
    }

    public boolean aF()
    {
        boolean flag;
        synchronized (fx)
        {
            flag = iQ;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void az()
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", fV.iJ);
        a("onhide", hashmap);
    }

    public void l(boolean flag)
    {
        synchronized (fx)
        {
            iQ = flag;
            aG();
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
            ct.r((new StringBuilder()).append("Couldn't find an Activity to view url/mimetype: ").append(s).append(" / ").append(s3).toString());
        }
    }

    protected void onMeasure(int i, int j)
    {
        int i1;
label0:
        {
            i1 = 0x7fffffff;
            synchronized (fx)
            {
                if (!isInEditMode() && !iQ)
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
        if (fU.widthPixels <= i && fU.heightPixels <= j)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        ct.v((new StringBuilder()).append("Not enough space to show ad. Needs ").append(fU.widthPixels).append("x").append(fU.heightPixels).append(" pixels, but only has ").append(k).append("x").append(j1).append(" pixels.").toString());
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
        setMeasuredDimension(fU.widthPixels, fU.heightPixels);
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
        if (he != null)
        {
            he.a(motionevent);
        }
        return super.onTouchEvent(motionevent);
    }

    public void setContext(Context context)
    {
        iO.setBaseContext(context);
    }

    public x y()
    {
        x x1;
        synchronized (fx)
        {
            x1 = fU;
        }
        return x1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
