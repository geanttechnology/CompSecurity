// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.RelativeLayout;
import java.lang.reflect.Method;

// Referenced classes of package com.jirbo.adcolony:
//            m, ak, AdColonyBrowser

class x extends View
{

    Paint a;
    m b;
    m c;
    final AdColonyBrowser d;

    public x(AdColonyBrowser adcolonybrowser, Activity activity)
    {
        d = adcolonybrowser;
        super(activity);
        a = new Paint();
        b = new m(ak.g("close_image_normal"));
        c = new m(ak.g("close_image_down"));
        try
        {
            getClass().getMethod("setLayerType", new Class[] {
                Integer.TYPE, android/graphics/Paint
            }).invoke(this, new Object[] {
                Integer.valueOf(1), null
            });
        }
        // Misplaced declaration of an exception variable
        catch (AdColonyBrowser adcolonybrowser) { }
        a.setColor(0xffcccccc);
        a.setStrokeWidth(10F);
        a.setStyle(android.graphics.Paint.Style.STROKE);
        a.setShadowLayer(3F, 0.0F, 1.0F, 0xff000000);
    }

    public void onDraw(Canvas canvas)
    {
        canvas.drawRect(0.0F, 0.0F, d.m.getWidth(), 10F, a);
    }
}
