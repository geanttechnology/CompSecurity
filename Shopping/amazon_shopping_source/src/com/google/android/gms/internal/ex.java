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
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebView;

// Referenced classes of package com.google.android.gms.internal:
//            eu, al, k

public class ex extends WebView
    implements DownloadListener
{
    private static class a extends MutableContextWrapper
    {

        private Context lz;
        private Activity sG;

        public void setBaseContext(Context context)
        {
            lz = context.getApplicationContext();
            if (context instanceof Activity)
            {
                context = (Activity)context;
            } else
            {
                context = null;
            }
            sG = context;
            super.setBaseContext(lz);
        }

        public void startActivity(Intent intent)
        {
            if (sG != null)
            {
                sG.startActivity(intent);
                return;
            } else
            {
                intent.setFlags(0x10000000);
                lz.startActivity(intent);
                return;
            }
        }
    }


    private final Object ls;
    private al nF;
    private final k pA;
    private final a sB;
    private boolean sD;
    private boolean sF;

    public void destroy()
    {
        synchronized (ls)
        {
            super.destroy();
            sF = true;
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
            getContext().startActivity(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            eu.z((new StringBuilder()).append("Couldn't find an Activity to view url/mimetype: ").append(s).append(" / ").append(s3).toString());
        }
    }

    protected void onMeasure(int i, int j)
    {
        int i1;
label0:
        {
            i1 = 0x7fffffff;
            synchronized (ls)
            {
                if (!isInEditMode() && !sD)
                {
                    break label0;
                }
                super.onMeasure(i, j);
            }
            return;
        }
        int l;
        int j1;
        int k1;
        int l1;
        l1 = android.view.View.MeasureSpec.getMode(i);
        l = android.view.View.MeasureSpec.getSize(i);
        k1 = android.view.View.MeasureSpec.getMode(j);
        j1 = android.view.View.MeasureSpec.getSize(j);
        break MISSING_BLOCK_LABEL_61;
_L3:
        if (nF.widthPixels <= i && nF.heightPixels <= j)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        float f = sB.getResources().getDisplayMetrics().density;
        eu.D((new StringBuilder()).append("Not enough space to show ad. Needs ").append((int)((float)nF.widthPixels / f)).append("x").append((int)((float)nF.heightPixels / f)).append(" dp, but only has ").append((int)((float)l / f)).append("x").append((int)((float)j1 / f)).append(" dp.").toString());
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
        setMeasuredDimension(nF.widthPixels, nF.heightPixels);
          goto _L1
        if (l1 != 0x80000000 && l1 != 0x40000000)
        {
            i = 0x7fffffff;
        } else
        {
            i = l;
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
        if (pA != null)
        {
            pA.a(motionevent);
        }
        return super.onTouchEvent(motionevent);
    }

    public void setContext(Context context)
    {
        sB.setBaseContext(context);
    }
}
