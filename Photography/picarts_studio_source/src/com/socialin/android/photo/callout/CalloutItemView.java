// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.photo.callout:
//            Callout

public class CalloutItemView extends View
{

    private Callout a;

    public CalloutItemView(Context context)
    {
        super(context);
        a = null;
        a();
    }

    public CalloutItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        a();
    }

    private void a()
    {
        if (Integer.valueOf(android.os.Build.VERSION.SDK_INT).intValue() >= 14)
        {
            setLayerType(1, null);
        }
    }

    public final void a(HashMap hashmap, String as[], String s, int i, int j, int k, int l, 
            int i1)
    {
        a = new Callout(getContext(), as, hashmap, s, i, j, k, l, false, 1);
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        boolean flag = false;
        super.onDraw(canvas);
        if (a != null)
        {
            Callout callout = a;
            if (callout.D == 2)
            {
                if (callout.isActive)
                {
                    callout.a();
                    canvas.save();
                    canvas.scale(callout.m, callout.n);
                    canvas.translate(callout.k / callout.m, callout.l / callout.n);
                    canvas.restore();
                    canvas.save();
                    canvas.rotate(callout.t, callout.u, callout.v);
                    canvas.scale(callout.r, callout.s);
                    canvas.translate(callout.p / callout.r, callout.q / callout.s);
                    canvas.restore();
                    if (callout.isDrawHandle)
                    {
                        if (callout.A == null || callout.z == null)
                        {
                            callout.b();
                        }
                        canvas.save();
                        canvas.rotate(callout.t, callout.u, callout.v);
                        canvas.drawBitmap(callout.z, callout.w - (float)(callout.z.getWidth() / 2), callout.x - (float)(callout.z.getHeight() / 2), callout.j);
                        canvas.restore();
                        canvas.drawBitmap(callout.A, callout.e.right - callout.A.getWidth() / 2, callout.e.bottom - callout.A.getHeight() / 2, callout.j);
                    }
                }
            } else
            if (callout.isActive)
            {
                callout.a();
                if (callout.a != -256)
                {
                    LinearGradient lineargradient = new LinearGradient(0.0F, callout.f.top, 0.0F, callout.f.bottom, callout.a, callout.b, android.graphics.Shader.TileMode.CLAMP);
                    callout.g.setShader(lineargradient);
                }
                if (callout.c != -256)
                {
                    LinearGradient lineargradient1 = new LinearGradient(0.0F, callout.f.top, 0.0F, callout.f.bottom, callout.c, callout.d, android.graphics.Shader.TileMode.CLAMP);
                    callout.h.setShader(lineargradient1);
                }
                if (callout.opacity == 255 && callout.C == -1)
                {
                    canvas.drawPath(callout.y, callout.h);
                }
                canvas.drawPath(callout.y, callout.g);
                Rect rect = new Rect();
                callout.i.getTextBounds(callout.B, 0, callout.B.length(), rect);
                int k1 = rect.bottom - rect.top;
                float af[] = new float[callout.B.length()];
                callout.i.getTextWidths(callout.B, af);
                ArrayList arraylist = new ArrayList();
                int i = 0;
                int k = 0;
                float f = 0.0F;
                while (i < af.length) 
                {
                    int l;
                    int j1;
                    if (f < (float)(Math.abs(callout.o) - 30))
                    {
                        float f1 = f + af[i];
                        l = i;
                        j1 = k;
                        f = f1;
                        if (i == af.length - 1)
                        {
                            arraylist.add(callout.B.substring(k, i + 1));
                            f = f1;
                            j1 = k;
                            l = i;
                        }
                    } else
                    {
                        l = callout.B.lastIndexOf(" ", i);
                        String s;
                        if (l != -1 && k < l)
                        {
                            s = callout.B.substring(k, l);
                            i = l + 1;
                            k = l;
                        } else
                        {
                            s = callout.B.substring(k, i);
                            int i1 = i;
                            k = i;
                            i = i1;
                        }
                        arraylist.add(s);
                        f = 0.0F;
                        l = k;
                        j1 = i;
                    }
                    i = l + 1;
                    k = j1;
                }
                f = callout.f.centerY() - ((arraylist.size() - 1) * k1) / 2;
                for (int j = ((flag) ? 1 : 0); j < arraylist.size(); j++)
                {
                    canvas.save();
                    canvas.clipPath(callout.y);
                    float f2 = callout.f.centerX();
                    float f3 = k1 * j;
                    float f4 = j * 2;
                    canvas.drawText((String)arraylist.get(j), f2, f4 + (f3 + f) + (float)(k1 / 2), callout.i);
                    canvas.restore();
                }

                if (callout.isDrawHandle)
                {
                    if (callout.A == null || callout.z == null)
                    {
                        callout.b();
                    }
                    canvas.save();
                    canvas.rotate(callout.t, callout.u, callout.v);
                    canvas.drawBitmap(callout.z, callout.w - (float)(callout.z.getWidth() / 2), callout.x - (float)(callout.z.getHeight() / 2), callout.j);
                    canvas.restore();
                    canvas.drawBitmap(callout.A, callout.e.right - callout.A.getWidth() / 2, callout.e.bottom - callout.A.getHeight() / 2, callout.j);
                    return;
                }
            }
        }
    }

    public void setCallout(Callout callout)
    {
        a = callout;
    }
}
