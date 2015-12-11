// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.Html;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.tremorvideo.sdk.android.richmedia.ae;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            u, ad, bv, bd, 
//            bb

public class bx
{
    class a extends BitmapDrawable
    {

        Bitmap a;
        final bx b;

        public void draw(Canvas canvas)
        {
            super.draw(canvas);
        }

        public int getIntrinsicHeight()
        {
            return a.getHeight();
        }

        public int getIntrinsicWidth()
        {
            return a.getWidth();
        }

        public a(Bitmap bitmap)
        {
            b = bx.this;
            super(bitmap);
            a = bitmap;
        }
    }

    class b extends TableLayout
        implements bd
    {

        View a;
        bv b;
        int c;
        final bx d;

        private int c()
        {
            int i = c;
            if (c == 0)
            {
                i = bx.a(d, getContext());
            }
            return i - b.a(bv.d.H).getWidth() - b.a(bv.d.J).getWidth() - 10;
        }

        public void a()
        {
            b();
        }

        public void a(View view)
        {
            a = view;
        }

        public void b()
        {
            int i = c();
            int j = b.a(bv.d.J).getHeight();
            a.setLayoutParams(new android.widget.TableRow.LayoutParams(i, j));
        }

        b(Context context, bv bv1, int i)
        {
            d = bx.this;
            super(context);
            c = i;
            b = bv1;
        }
    }

    public static interface c
    {

        public abstract void a(bx bx1, boolean flag);
    }


    final int a = 5;
    final int b = 5;
    final int c = 5;
    boolean d;
    List e;
    c f;
    int g;
    u h;

    public bx(u u1)
    {
        d = false;
        e = new ArrayList();
        g = 0;
        h = u1;
    }

    private int a(Context context)
    {
        int j = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getWidth();
        int i = j;
        if (h.S() != null)
        {
            i = j - h.S().a();
        }
        return i;
    }

    static int a(bx bx1, Context context)
    {
        return bx1.a(context);
    }

    private TextView a(Context context, bv bv1)
    {
        context = new TextView(context);
        context.setTextSize(ad.H());
        context.setTypeface(Typeface.create("helvetica", 1));
        context.setEllipsize(android.text.TextUtils.TruncateAt.END);
        context.setTextColor(bv1.a(bv.c.g));
        context.setShadowLayer(1.2F, 1.0F, 1.0F, bv1.a(bv.c.h));
        context.setPadding(0, 0, 5, 0);
        context.setGravity(19);
        context.setVerticalFadingEdgeEnabled(true);
        context.setFadingEdgeLength(10);
        context.setLinksClickable(true);
        return context;
    }

    public View a(Context context, int i, bv bv1)
    {
        Object obj = new ImageView(context);
        ((ImageView) (obj)).setImageDrawable(new a(bv1.a(bv.d.G)));
        ((ImageView) (obj)).setPadding(0, 5, 0, 0);
        ImageView imageview = new ImageView(context);
        imageview.setImageDrawable(new a(bv1.a(bv.d.H)));
        ImageView imageview1 = new ImageView(context);
        imageview1.setImageDrawable(new a(bv1.a(bv.d.J)));
        ViewFlipper viewflipper = new ViewFlipper(context);
        int j = 0;
        while (j < Math.min(10, e.size())) 
        {
            try
            {
                TextView textview = a(context, bv1);
                textview.setText((CharSequence)e.get(j));
                viewflipper.addView(textview);
            }
            catch (Exception exception)
            {
                ad.a(exception);
            }
            j++;
        }
        viewflipper.setFlipInterval(5000);
        viewflipper.startFlipping();
        viewflipper.setBackgroundDrawable(new BitmapDrawable(bv1.a(bv.d.I)));
        Object obj1 = new AlphaAnimation(0.0F, 1.0F);
        ((Animation) (obj1)).setDuration(300L);
        ((Animation) (obj1)).setStartOffset(300L);
        viewflipper.setInAnimation(((Animation) (obj1)));
        obj1 = new AlphaAnimation(1.0F, 0.0F);
        ((Animation) (obj1)).setDuration(300L);
        viewflipper.setOutAnimation(((Animation) (obj1)));
        obj1 = new TableRow(context);
        android.widget.TableRow.LayoutParams layoutparams = new android.widget.TableRow.LayoutParams();
        layoutparams.gravity = 51;
        ((TableRow) (obj1)).addView(((View) (obj)), layoutparams);
        obj = new TableRow(context);
        ((TableRow) (obj)).addView(imageview);
        ((TableRow) (obj)).addView(viewflipper);
        ((TableRow) (obj)).addView(imageview1);
        context = new b(context, bv1, i);
        context.setPadding(5, 0, 5, 0);
        context.addView(((View) (obj1)));
        context.addView(((View) (obj)));
        context.a(viewflipper);
        context.b();
        context.setFocusable(false);
        return context;
    }

    public void a(String s, c c1)
    {
        if (!d)
        {
            f = c1;
            (new Thread(new Runnable(s) {

                final String a;
                final bx b;

                public void run()
                {
                    boolean flag1 = false;
                    Object obj;
                    obj = ae.c(a);
                    obj = bb.a(a, ((String) (obj)));
                    ((bb) (obj)).a();
                    boolean flag = flag1;
                    if (((bb) (obj)).b() == null) goto _L2; else goto _L1
_L1:
                    obj = (new JSONObject(((bb) (obj)).b())).getJSONArray("results");
                    int i = 0;
_L5:
                    if (i >= ((JSONArray) (obj)).length()) goto _L4; else goto _L3
_L3:
                    Object obj1 = ((JSONArray) (obj)).getJSONObject(i);
                    String s1 = ((JSONObject) (obj1)).getString("text");
                    obj1 = (new StringBuilder()).append("@").append(((JSONObject) (obj1)).getString("from_user")).append(": ").toString();
                    s1 = (new StringBuilder()).append(((String) (obj1))).append(Html.fromHtml(s1).toString()).toString();
                    b.e.add(s1);
_L6:
                    i++;
                      goto _L5
                    Exception exception1;
                    exception1;
                    ad.a(exception1);
                      goto _L6
                    Exception exception;
                    exception;
                    ad.d(exception.getMessage());
                    flag = flag1;
_L2:
                    b.d = true;
                    b.f.a(b, flag);
                    return;
_L4:
                    flag = true;
                    if (true) goto _L2; else goto _L7
_L7:
                }

            
            {
                b = bx.this;
                a = s;
                super();
            }
            })).run();
        }
    }
}
