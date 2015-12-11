// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.d.a:
//            ah, w, ak, a, 
//            ai, u, aj

final class al extends RelativeLayout
{

    ah a;
    private aj b;
    private int c;

    public al(Context context, aj aj1, ah ah1, w w1, int i)
    {
        super(context);
        b = aj1;
        a = ah1;
        aj1 = ah1.c;
        c = i;
        c;
        JVM INSTR tableswitch 1 2: default 52
    //                   1 66
    //                   2 58;
           goto _L1 _L2 _L3
_L1:
        setFocusable(true);
        return;
_L3:
        a(context, w1, aj1);
_L2:
        a(context, w1, aj1);
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(Context context, w w1, ak ak1)
    {
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        u u1 = w1.d;
        ImageView imageview = new ImageView(context);
        imageview.setId(1);
        w1 = ak1.h;
        if (w1 != null)
        {
            w1 = ((a) (w1)).e;
            Bitmap bitmap = BitmapFactory.decodeByteArray(w1, 0, w1.length);
            if (bitmap == null)
            {
                (new StringBuilder("Ad with bad image: ")).append(ak1.d).append(", data: ").append(w1);
            }
            if (bitmap != null)
            {
                w1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(w1);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                RectF rectf = new RectF(rect);
                float f = ai.a(context, 8);
                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(0xff000000);
                canvas.drawRoundRect(rectf, f, f, paint);
                paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, rect, rect, paint);
                if (Integer.parseInt(android.os.Build.VERSION.SDK) > 4)
                {
                    BlurMaskFilter blurmaskfilter = new BlurMaskFilter(3F, android.graphics.BlurMaskFilter.Blur.OUTER);
                    Object obj = new Paint();
                    ((Paint) (obj)).setMaskFilter(blurmaskfilter);
                    int ai1[] = new int[2];
                    obj = w1.extractAlpha(((Paint) (obj)), ai1).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
                    (new Canvas(((Bitmap) (obj)))).drawBitmap(w1, -ai1[0], -ai1[1], null);
                    w1 = ((w) (obj));
                }
                imageview.setImageBitmap(w1);
                int i = ai.a(context, u1.y);
                int k = ai.a(context, u1.z);
                imageview.setAdjustViewBounds(true);
                imageview.setMinimumWidth(ai.a(context, i));
                imageview.setMinimumHeight(ai.a(context, k));
                imageview.setMaxWidth(ai.a(context, i));
                imageview.setMaxHeight(ai.a(context, k));
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            }
        }
        w1 = b.a(u1.c);
        if (w1 != null)
        {
            w1 = ((a) (w1)).e;
            w1 = BitmapFactory.decodeByteArray(w1, 0, w1.length);
            TextView textview;
            int j;
            int l;
            int i1;
            if (NinePatch.isNinePatchChunk(w1.getNinePatchChunk()))
            {
                w1 = new NinePatchDrawable(w1, w1.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
            } else
            {
                w1 = new BitmapDrawable(w1);
            }
            setBackgroundDrawable(w1);
        }
        w1 = new TextView(context);
        w1.setId(5);
        w1.setPadding(0, 0, 0, 0);
        textview = new TextView(context);
        textview.setId(3);
        textview.setPadding(0, 0, 0, 0);
        w1.setTextColor(u1.g);
        w1.setTextSize(u1.f);
        w1.setText(new String((new StringBuilder("\u2022 ")).append(u1.b).toString()));
        w1.setTypeface(Typeface.create(u1.e, 0));
        textview.setTextColor(u1.j);
        textview.setTextSize(u1.i);
        textview.setTypeface(Typeface.create(u1.h, 0));
        textview.setText(ak1.d);
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        ak1 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        addView(new ImageView(context), ak1);
        j = u1.K;
        l = u1.A;
        i1 = u1.y;
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(9);
        context.setMargins(u1.A, u1.B, j - (l << 1) - i1, 0);
        addView(imageview, context);
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(6, imageview.getId());
        context.addRule(1, imageview.getId());
        context.setMargins(0, 0, 0, 0);
        addView(w1, context);
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(1, imageview.getId());
        context.addRule(3, w1.getId());
        context.setMargins(0, -2, 0, 0);
        addView(textview, context);
    }
}
