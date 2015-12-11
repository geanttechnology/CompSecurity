// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ai, al, bv

public class p
{
    public static interface a
    {

        public abstract void a(Dialog dialog);

        public abstract void b(Dialog dialog);

        public abstract void c(Dialog dialog);
    }


    public static Dialog a(Context context, a a1, bv bv1)
    {
        ai ai1 = ai.a(context);
        Bitmap abitmap[] = a(bv1);
        a1 = a(context, a1, bv1, ((Dialog) (ai1)));
        LinearLayout linearlayout = new LinearLayout(context);
        linearlayout.setOrientation(1);
        linearlayout.setPadding(10, 10, 10, 10);
        Object obj = new LinearLayout(context);
        ((LinearLayout) (obj)).setOrientation(0);
        TextView textview = new TextView(context);
        textview.setText("Tremor Video uses cookies or anonymous identifiers to send you ads that may be more relevant and useful to you. Select \"Opt Out\" if you no longer wish for Tremor Video to send you ads based on your inferred interests or demographics in this application on this device.");
        textview.setFocusable(false);
        ((LinearLayout) (obj)).addView(textview, new android.widget.LinearLayout.LayoutParams(-2, -2));
        linearlayout.addView(((View) (obj)), new android.widget.LinearLayout.LayoutParams(-2, -2));
        obj = new android.widget.LinearLayout.LayoutParams(0, 0);
        obj.weight = 1.0F;
        linearlayout.addView(new View(context), ((android.view.ViewGroup.LayoutParams) (obj)));
        context = new android.widget.LinearLayout.LayoutParams(-2, -2);
        context.gravity = 81;
        linearlayout.addView(a1, context);
        ai1.requestWindowFeature(1);
        ai1.getWindow().setBackgroundDrawable(new al(abitmap, bv1.a(bv.c.f)));
        ai1.addContentView(linearlayout, new android.view.ViewGroup.LayoutParams(-2, -2));
        return ai1;
    }

    private static ScrollView a(Context context, a a1, bv bv1, Dialog dialog)
    {
        bv1 = new int[3];
        bv1[0] = Color.rgb(156, 157, 158);
        bv1[1] = Color.rgb(39, 40, 41);
        bv1[2] = Color.rgb(59, 60, 63);
        int ai1[] = new int[2];
        ai1[0] = Color.rgb(68, 121, 254);
        ai1[1] = Color.rgb(4, 63, 212);
        ScrollView scrollview = new ScrollView(context);
        TableLayout tablelayout = new TableLayout(context);
        TableRow tablerow = new TableRow(context);
        tablerow.setLayoutParams(new android.widget.TableRow.LayoutParams(-1, -2));
        String as[] = new String[3];
        as[0] = "Opt Out";
        as[1] = "More Info";
        as[2] = "OK";
        for (int i = 0; i < as.length; i++)
        {
            Object obj1 = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, bv1);
            ((GradientDrawable) (obj1)).setCornerRadius(6F);
            ((GradientDrawable) (obj1)).setGradientType(0);
            Object obj = new Button(context);
            ((Button) (obj)).setText(as[i]);
            ((Button) (obj)).setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj1)));
            ((Button) (obj)).setTextColor(-1);
            ((Button) (obj)).setPadding(5, 5, 5, 5);
            ((Button) (obj)).setId(i + 35);
            ((Button) (obj)).setFocusable(true);
            ((Button) (obj)).setTag(Integer.valueOf(i));
            ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener(a1, dialog) {

                final a a;
                final Dialog b;

                public void onClick(View view)
                {
                    if (((Integer)view.getTag()).intValue() == 0)
                    {
                        a.a(b);
                    } else
                    {
                        if (((Integer)view.getTag()).intValue() == 1)
                        {
                            a.c(b);
                            return;
                        }
                        if (((Integer)view.getTag()).intValue() == 2)
                        {
                            a.b(b);
                            return;
                        }
                    }
                }

            
            {
                a = a1;
                b = dialog;
                super();
            }
            });
            ((Button) (obj)).setOnFocusChangeListener(new android.view.View.OnFocusChangeListener(ai1, bv1) {

                final int a[];
                final int b[];

                public void onFocusChange(View view, boolean flag)
                {
                    Object obj2;
                    if (flag)
                    {
                        obj2 = a;
                    } else
                    {
                        obj2 = b;
                    }
                    obj2 = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, ((int []) (obj2)));
                    ((GradientDrawable) (obj2)).setCornerRadius(5F);
                    ((GradientDrawable) (obj2)).setGradientType(0);
                    view.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj2)));
                }

            
            {
                a = ai1;
                b = ai2;
                super();
            }
            });
            ((Button) (obj)).setOnTouchListener(new android.view.View.OnTouchListener(ai1, bv1) {

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
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -2);
            obj1 = new FrameLayout(context);
            ((FrameLayout) (obj1)).addView(((View) (obj)), layoutparams);
            obj = new android.widget.TableRow.LayoutParams(0, -2);
            obj.weight = 1.0F;
            obj.rightMargin = 1;
            obj.leftMargin = 1;
            tablerow.addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj)));
            tablelayout.setColumnStretchable(i, true);
        }

        tablelayout.addView(tablerow, new android.widget.TableLayout.LayoutParams(-1, -2));
        scrollview.addView(tablelayout, new android.view.ViewGroup.LayoutParams(-1, -2));
        return scrollview;
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
}
