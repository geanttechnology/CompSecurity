// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aw, ai, al, bv, 
//            ad

public class be
{

    static boolean e = false;
    List a;
    String b;
    long c;
    boolean d;

    public be(JSONObject jsonobject)
        throws Exception
    {
        int j;
        if (jsonobject.has("survey-skip-seconds"))
        {
            c = 1000L * jsonobject.getLong("survey-skip-seconds");
        } else
        {
            c = 0L;
        }
        if (jsonobject.has("survey-skip"))
        {
            d = jsonobject.getBoolean("survey-skip");
        } else
        {
            d = false;
        }
        b = jsonobject.getString("survey-question");
        jsonobject = jsonobject.getJSONArray("events");
        j = Math.min(10, jsonobject.length());
        a = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            a.add(new aw(jsonobject.getJSONObject(i)));
        }

        e = false;
    }

    public static Dialog a(Context context, bv bv1, be be1, a.a a1)
    {
        ai ai1;
        try
        {
            ai1 = ai.a(context);
            Bitmap abitmap[] = a(bv1);
            ScrollView scrollview = a(context, bv1, a1, ((Dialog) (ai1)), be1);
            LinearLayout linearlayout = new LinearLayout(context);
            linearlayout.setOrientation(1);
            linearlayout.setPadding(10, 10, 10, 10);
            LinearLayout linearlayout1 = new LinearLayout(context);
            linearlayout1.setOrientation(0);
            Object obj = a(context, bv1, "Survey");
            ((TextView) (obj)).setFocusable(false);
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutparams.weight = 1.0F;
            linearlayout1.addView(((View) (obj)), layoutparams);
            a1 = a(context, bv1, a1, be1, ((Dialog) (ai1)));
            a1.setFocusable(false);
            obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
            obj.gravity = 5;
            linearlayout1.addView(a1, ((android.view.ViewGroup.LayoutParams) (obj)));
            linearlayout.addView(linearlayout1, new android.widget.LinearLayout.LayoutParams(-1, -2));
            linearlayout.addView(b(context, bv1, be1.b));
            linearlayout.addView(scrollview);
            ai1.requestWindowFeature(1);
            ai1.getWindow().setBackgroundDrawable(new al(abitmap, bv1.a(bv.c.f)));
            ai1.getWindow().setFlags(1024, 1024);
            ai1.addContentView(linearlayout, new android.view.ViewGroup.LayoutParams(-1, -1));
            ai1.setCanceledOnTouchOutside(false);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ad.a(context);
            return null;
        }
        return ai1;
    }

    private static ImageButton a(Context context, bv bv1, a.a a1, be be1, Dialog dialog)
    {
        bv1 = bv1.a(bv.d.V);
        context = new ImageButton(context);
        context.setBackgroundDrawable(null);
        context.setImageBitmap(bv1);
        if (be1.d && be1.c > 0L)
        {
            context.postDelayed(new Runnable(dialog, a1, be1) {

                final Dialog a;
                final a.a b;
                final be c;

                public void run()
                {
                    be.a(a, b, c);
                }

            
            {
                a = dialog;
                b = a1;
                c = be1;
                super();
            }
            }, be1.c);
        }
        context.setOnClickListener(new android.view.View.OnClickListener(dialog, a1, be1) {

            final Dialog a;
            final a.a b;
            final be c;

            public void onClick(View view)
            {
                be.a(a, b, c);
            }

            
            {
                a = dialog;
                b = a1;
                c = be1;
                super();
            }
        });
        return context;
    }

    private static ScrollView a(Context context, bv bv1, a.a a1, Dialog dialog, be be1)
    {
        bv1 = new int[3];
        bv1[0] = Color.rgb(156, 157, 158);
        bv1[1] = Color.rgb(39, 40, 41);
        bv1[2] = Color.rgb(59, 60, 63);
        int ai1[] = new int[2];
        ai1[0] = Color.rgb(68, 121, 254);
        ai1[1] = Color.rgb(4, 63, 212);
        ScrollView scrollview = new ScrollView(context);
        LinearLayout linearlayout = new LinearLayout(context);
        linearlayout.setOrientation(1);
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < be1.a.size(); i++)
        {
            if (((aw)be1.a.get(i)).a() == aw.b.R)
            {
                arraylist.add(be1.a.get(i));
            }
        }

        Collections.sort(arraylist, new Comparator() {

            public int a(aw aw1, aw aw2)
            {
                if (aw1.i() < aw2.i())
                {
                    return -1;
                }
                return aw1.i() <= aw2.i() ? 0 : 1;
            }

            public int compare(Object obj1, Object obj2)
            {
                return a((aw)obj1, (aw)obj2);
            }

        });
        for (int j = 0; j < arraylist.size(); j++)
        {
            Object obj = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, bv1);
            ((GradientDrawable) (obj)).setCornerRadius(6F);
            ((GradientDrawable) (obj)).setGradientType(0);
            be1 = new Button(context);
            be1.setText(((aw)arraylist.get(j)).h());
            be1.setTag(arraylist.get(j));
            be1.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
            be1.setTextColor(-1);
            be1.setPadding(5, 5, 5, 5);
            be1.setId(j + 35);
            be1.setFocusable(true);
            obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
            obj.bottomMargin = 5;
            be1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            be1.setOnClickListener(new android.view.View.OnClickListener(a1, dialog) {

                final a.a a;
                final Dialog b;

                public void onClick(View view)
                {
                    be.e = true;
                    a.a((aw)view.getTag());
                    b.dismiss();
                }

            
            {
                a = a1;
                b = dialog;
                super();
            }
            });
            be1.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener(ai1, bv1) {

                final int a[];
                final int b[];

                public void onFocusChange(View view, boolean flag)
                {
                    Object obj1;
                    if (flag)
                    {
                        obj1 = a;
                    } else
                    {
                        obj1 = b;
                    }
                    obj1 = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, ((int []) (obj1)));
                    ((GradientDrawable) (obj1)).setCornerRadius(5F);
                    ((GradientDrawable) (obj1)).setGradientType(0);
                    view.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj1)));
                }

            
            {
                a = ai1;
                b = ai2;
                super();
            }
            });
            be1.setOnTouchListener(new android.view.View.OnTouchListener(ai1, bv1) {

                final int a[];
                final int b[];

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    int ai2[] = null;
                    if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
                    ai2 = a;
_L4:
                    if (ai2 != null)
                    {
                        motionevent = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, ai2);
                        motionevent.setCornerRadius(5F);
                        motionevent.setGradientType(0);
                        view.setBackgroundDrawable(motionevent);
                    }
                    return false;
_L2:
                    if (motionevent.getAction() == 3)
                    {
                        ai2 = b;
                    } else
                    if (motionevent.getAction() == 1)
                    {
                        ai2 = b;
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                a = ai1;
                b = ai2;
                super();
            }
            });
            linearlayout.addView(be1);
            linearlayout.setPadding(5, 5, 5, 5);
        }

        scrollview.addView(linearlayout);
        return scrollview;
    }

    private static TextView a(Context context, bv bv1, String s)
    {
        context = new TextView(context);
        context.setText(s);
        context.setTextSize(2, ad.F());
        context.setTextColor(bv1.a(bv.c.g));
        context.setTypeface(Typeface.create("helvetica", 1));
        context.setShadowLayer(5F, 0.0F, 0.0F, bv1.a(bv.c.h));
        context.setPadding(10, 5, 10, 0);
        return context;
    }

    private static aw a(aw.b b1, List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            aw aw1 = (aw)list.next();
            if (aw1.a() == b1)
            {
                return aw1;
            }
        }

        return null;
    }

    static void a(Dialog dialog, a.a a1, be be1)
    {
        b(dialog, a1, be1);
    }

    private static Bitmap[] a(bv bv1)
    {
        Bitmap abitmap[] = new Bitmap[al.a.values().length];
        abitmap[al.a.a.ordinal()] = bv1.a(bv.d.y);
        abitmap[al.a.b.ordinal()] = bv1.a(bv.d.z);
        abitmap[al.a.c.ordinal()] = bv1.a(bv.d.A);
        abitmap[al.a.d.ordinal()] = bv1.a(bv.d.B);
        abitmap[al.a.e.ordinal()] = bv1.a(bv.d.C);
        abitmap[al.a.f.ordinal()] = bv1.a(bv.d.D);
        abitmap[al.a.g.ordinal()] = bv1.a(bv.d.E);
        abitmap[al.a.h.ordinal()] = bv1.a(bv.d.F);
        return abitmap;
    }

    private static TextView b(Context context, bv bv1, String s)
    {
        context = new TextView(context);
        context.setText(s);
        context.setPadding(10, 5, 10, 5);
        context.setTextColor(bv1.a(bv.c.i));
        context.setTextSize(ad.G());
        return context;
    }

    private static void b(Dialog dialog, a.a a1, be be1)
    {
        com/tremorvideo/sdk/android/videoad/be;
        JVM INSTR monitorenter ;
        boolean flag = e;
        if (!flag) goto _L2; else goto _L1
_L1:
        com/tremorvideo/sdk/android/videoad/be;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (dialog.isShowing())
        {
            dialog.dismiss();
        }
        dialog = a(aw.b.Q, be1.a);
        if (dialog == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        be1.a.remove(dialog);
        a1.a(dialog);
        if (true) goto _L1; else goto _L3
_L3:
        dialog;
        throw dialog;
    }

    public aw a(aw.b b1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            aw aw1 = (aw)iterator.next();
            if (aw1.a() == b1)
            {
                return aw1;
            }
        }

        return null;
    }

}
