// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

// Referenced classes of package com.amazon.device.ads:
//            cq, cf, bx, aw, 
//            da

final class <init> extends <init>
{

    final int a;
    final boolean b;
    final da c;
    final int d;
    final cq e;

    private transient Void a()
    {
        cq cq1;
        int i;
        cq1 = e;
        i = a;
        boolean flag = false;
        cq1;
        JVM INSTR monitorenter ;
        if (cq1.b != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        cq1.b = cf.a(cq1.d.getContext(), a, "nativeCloseButton");
        cq1.a = cq1.g.a(cq1.d.getContext(), "nativeCloseButtonImage");
        flag = true;
        cq1;
        JVM INSTR monitorexit ;
        if (flag)
        {
            Object obj = cq1.g.a(cq1.d.getContext().getResources(), aw.a().a("amazon_ads_close_normal.png"));
            android.graphics.drawable.BitmapDrawable bitmapdrawable = cq1.g.a(cq1.d.getContext().getResources(), aw.a().a("amazon_ads_close_pressed.png"));
            cq1.a.setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
            cq1.a.setScaleType(android.widget.View.ScaleType.FIT_CENTER);
            cq1.a.setBackgroundDrawable(null);
            rawable rawable = new <init>(cq1);
            cq1.a.setOnClickListener(rawable);
            cq1.b.setOnClickListener(rawable);
            obj = new <init>(cq1, ((android.graphics.drawable.BitmapDrawable) (obj)), bitmapdrawable);
            cq1.b.setOnTouchListener(((android.view.OnTouchListener) (obj)));
            cq1.a.setOnTouchListener(((android.view.OnTouchListener) (obj)));
            obj = new android.widget.iveLayout.LayoutParams(i, i);
            ((android.widget.iveLayout.LayoutParams) (obj)).addRule(11);
            ((android.widget.iveLayout.LayoutParams) (obj)).addRule(10);
            cq1.c = cf.a(cq1.d.getContext(), a, "nativeCloseButtonContainer");
            cq1.c.addView(cq1.b, ((android.view.roup.LayoutParams) (obj)));
        }
        return null;
        Exception exception;
        exception;
        cq1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        android.widget.iveLayout.LayoutParams layoutparams;
        cq cq1 = e;
        boolean flag = b;
        da da1 = c;
        int i = d;
        int j = a;
        if (flag && !cq1.b.equals(cq1.a.getParent()))
        {
            obj = new android.widget.iveLayout.LayoutParams(i, i);
            ((android.widget.iveLayout.LayoutParams) (obj)).addRule(13);
            cq1.b.addView(cq1.a, ((android.view.roup.LayoutParams) (obj)));
        } else
        if (!flag && cq1.b.equals(cq1.a.getParent()))
        {
            cq1.b.removeView(cq1.a);
        }
        if (!cq1.d.equals(cq1.c.getParent()))
        {
            cq1.d.addView(cq1.c, new android.widget.Layout.LayoutParams(-1, -1));
        }
        layoutparams = new android.widget.iveLayout.LayoutParams(j, j);
        obj = da1;
        if (da1 == null)
        {
            obj = da.b;
        }
        a[((da) (obj)).ordinal()];
        JVM INSTR tableswitch 1 7: default 192
    //                   1 259
    //                   2 276
    //                   3 293
    //                   4 310
    //                   5 320
    //                   6 337
    //                   7 354;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        layoutparams.addRule(10);
        layoutparams.addRule(11);
_L10:
        cq1.b.setLayoutParams(layoutparams);
        cq1.c.bringToFront();
        return;
_L2:
        layoutparams.addRule(12);
        layoutparams.addRule(14);
        continue; /* Loop/switch isn't completed */
_L3:
        layoutparams.addRule(12);
        layoutparams.addRule(9);
        continue; /* Loop/switch isn't completed */
_L4:
        layoutparams.addRule(12);
        layoutparams.addRule(11);
        continue; /* Loop/switch isn't completed */
_L5:
        layoutparams.addRule(13);
        continue; /* Loop/switch isn't completed */
_L6:
        layoutparams.addRule(10);
        layoutparams.addRule(14);
        continue; /* Loop/switch isn't completed */
_L7:
        layoutparams.addRule(10);
        layoutparams.addRule(9);
        continue; /* Loop/switch isn't completed */
_L8:
        layoutparams.addRule(10);
        layoutparams.addRule(11);
        if (true) goto _L10; else goto _L9
_L9:
    }

    LayoutParams(cq cq1, int i, boolean flag, da da1, int j)
    {
        e = cq1;
        a = i;
        b = flag;
        c = da1;
        d = j;
        super();
    }
}
