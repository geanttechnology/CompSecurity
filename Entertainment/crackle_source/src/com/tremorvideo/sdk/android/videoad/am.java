// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, ai, al, bv

public class am
{
    public static interface a
    {

        public abstract void a(Dialog dialog);

        public abstract void a(Dialog dialog, String s);
    }


    private static int a()
    {
        int j = a(300);
        int i = j;
        if (Math.max(ad.m(), ad.l()) > 320)
        {
            i = Math.min(Math.round((float)ad.l() * 0.6F), j);
        }
        return Math.round((float)i * 0.9F);
    }

    private static int a(int i)
    {
        return Math.round(((float)Math.max(ad.m(), ad.l()) / 320F) * (float)i);
    }

    public static Dialog a(Context context, a a1, String s, String s1, bv bv1, boolean flag, int i, int j, 
            String as[])
    {
        ai ai1 = ai.a(context);
        Bitmap abitmap[] = a(bv1);
        EditText edittext = new EditText(context);
        a1 = a(context, edittext, a1, bv1, ((Dialog) (ai1)), as);
        as = new LinearLayout(context);
        as.setOrientation(1);
        as.setPadding(10, 10, 10, 10);
        LinearLayout linearlayout = new LinearLayout(context);
        linearlayout.setOrientation(1);
        TextView textview = new TextView(context);
        textview.setText(s1);
        textview.setFocusable(false);
        linearlayout.addView(textview, new android.widget.LinearLayout.LayoutParams(-1, -2));
        edittext.setFocusable(true);
        int k;
        if (flag)
        {
            edittext.setText("");
        } else
        {
            edittext.setText(String.valueOf(s));
        }
        edittext.setInputType(i);
        edittext.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(j)
        });
        linearlayout.addView(edittext, new android.widget.LinearLayout.LayoutParams(-1, -2));
        as.addView(linearlayout, new android.widget.LinearLayout.LayoutParams(-2, -2));
        s = new android.widget.LinearLayout.LayoutParams(0, 0);
        s.weight = 1.0F;
        as.addView(new View(context), s);
        context = new android.widget.LinearLayout.LayoutParams(-2, -2);
        context.gravity = 81;
        as.addView(a1, context);
        k = a();
        j = a(100);
        i = j;
        if (Math.max(ad.m(), ad.l()) > 320)
        {
            i = Math.min(Math.round((float)ad.m() * 0.5F), j);
        }
        ai1.requestWindowFeature(1);
        ai1.getWindow().setBackgroundDrawable(new al(abitmap, bv1.a(bv.c.f)));
        ai1.addContentView(as, new android.view.ViewGroup.LayoutParams(k, i));
        return ai1;
    }

    private static ScrollView a(Context context, EditText edittext, a a1, bv bv1, Dialog dialog, String as[])
    {
        int ai1[];
        int ai2[];
        ScrollView scrollview;
        TableLayout tablelayout;
        TableRow tablerow;
label0:
        {
            ai1 = new int[3];
            ai1[0] = Color.rgb(156, 157, 158);
            ai1[1] = Color.rgb(39, 40, 41);
            ai1[2] = Color.rgb(59, 60, 63);
            ai2 = new int[2];
            ai2[0] = Color.rgb(68, 121, 254);
            ai2[1] = Color.rgb(4, 63, 212);
            scrollview = new ScrollView(context);
            tablelayout = new TableLayout(context);
            tablerow = new TableRow(context);
            tablerow.setLayoutParams(new android.widget.TableRow.LayoutParams(-1, -2));
            if (as != null)
            {
                bv1 = as;
                if (as.length >= 1)
                {
                    break label0;
                }
            }
            bv1 = new String[2];
            bv1[0] = "   OK   ";
            bv1[1] = "Cancel";
        }
        for (int i = 0; i < bv1.length; i++)
        {
            Object obj = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, ai1);
            ((GradientDrawable) (obj)).setCornerRadius(6F);
            ((GradientDrawable) (obj)).setGradientType(0);
            as = new Button(context);
            as.setText(bv1[i]);
            as.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
            as.setTextColor(-1);
            as.setPadding(5, 5, 5, 5);
            as.setId(i + 35);
            as.setFocusable(true);
            as.setTag(Integer.valueOf(i));
            as.setOnClickListener(new android.view.View.OnClickListener(edittext, a1, dialog) {

                final EditText a;
                final a b;
                final Dialog c;

                public void onClick(View view)
                {
                    if (((Integer)view.getTag()).intValue() != 0) goto _L2; else goto _L1
_L1:
                    view = null;
                    String s = a.getText().toString();
                    view = s;
_L8:
                    if (view != null) goto _L4; else goto _L3
_L3:
                    b.a(c);
_L6:
                    return;
_L4:
                    b.a(c, view);
                    return;
_L2:
                    if (((Integer)view.getTag()).intValue() != 1) goto _L6; else goto _L5
_L5:
                    b.a(c);
                    return;
                    Exception exception;
                    exception;
                    if (true) goto _L8; else goto _L7
_L7:
                }

            
            {
                a = edittext;
                b = a1;
                c = dialog;
                super();
            }
            });
            as.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener(ai2, ai1) {

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
            as.setOnTouchListener(new android.view.View.OnTouchListener(ai2, ai1) {

                final int a[];
                final int b[];

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    int ai3[] = null;
                    if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
                    ai3 = a;
_L4:
                    if (ai3 != null)
                    {
                        motionevent = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, ai3);
                        motionevent.setCornerRadius(5F);
                        motionevent.setGradientType(0);
                        view.setBackgroundDrawable(motionevent);
                    }
                    return false;
_L2:
                    if (motionevent.getAction() == 3)
                    {
                        ai3 = b;
                    } else
                    if (motionevent.getAction() == 1)
                    {
                        ai3 = b;
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
            obj = new android.widget.TableRow.LayoutParams(-1, -2);
            obj.gravity = 1;
            tablerow.addView(as, ((android.view.ViewGroup.LayoutParams) (obj)));
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
