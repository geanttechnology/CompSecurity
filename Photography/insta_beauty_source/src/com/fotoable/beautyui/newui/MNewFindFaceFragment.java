// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fotoable.beautyui.ImageDetailView;
import com.instabeauty.application.InstaBeautyApplication;
import ts;
import tt;
import tu;
import tv;
import tw;
import tx;
import ty;
import xu;
import yp;

public class MNewFindFaceFragment extends Fragment
{

    public final int a = 0;
    private ImageView b;
    private ImageView c;
    private int d;
    private int e;
    private int f;
    private int g;
    private ty h;
    private ImageView i;
    private RectF j;
    private PointF k;
    private PointF l;
    private xu m;
    private FrameLayout n;
    private Button o;
    private ImageDetailView p;
    private Bitmap q;
    private boolean r;

    public MNewFindFaceFragment()
    {
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        j = new RectF();
        k = new PointF();
        l = new PointF();
        r = true;
    }

    public static int a(MNewFindFaceFragment mnewfindfacefragment, int i1)
    {
        mnewfindfacefragment.d = i1;
        return i1;
    }

    public static PointF a(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.k;
    }

    public static PointF a(MNewFindFaceFragment mnewfindfacefragment, PointF pointf)
    {
        mnewfindfacefragment.k = pointf;
        return pointf;
    }

    public static RectF a(MNewFindFaceFragment mnewfindfacefragment, RectF rectf)
    {
        mnewfindfacefragment.j = rectf;
        return rectf;
    }

    public static MNewFindFaceFragment a()
    {
        return new MNewFindFaceFragment();
    }

    private void a(RectF rectf, PointF pointf, PointF pointf1)
    {
        k = pointf;
        l = pointf1;
        float f1 = (float)i.getDrawable().getIntrinsicWidth() / j.width();
        a(((View) (b)), k, f1, rectf, 0.0F);
        a(((View) (c)), l, f1, rectf, 0.0F);
    }

    public static void a(MNewFindFaceFragment mnewfindfacefragment, RectF rectf, PointF pointf, PointF pointf1)
    {
        mnewfindfacefragment.a(rectf, pointf, pointf1);
    }

    public static int b(MNewFindFaceFragment mnewfindfacefragment, int i1)
    {
        mnewfindfacefragment.e = i1;
        return i1;
    }

    public static PointF b(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.l;
    }

    public static PointF b(MNewFindFaceFragment mnewfindfacefragment, PointF pointf)
    {
        mnewfindfacefragment.l = pointf;
        return pointf;
    }

    public static int c(MNewFindFaceFragment mnewfindfacefragment, int i1)
    {
        mnewfindfacefragment.f = i1;
        return i1;
    }

    public static ty c(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.h;
    }

    public static int d(MNewFindFaceFragment mnewfindfacefragment, int i1)
    {
        mnewfindfacefragment.g = i1;
        return i1;
    }

    public static ImageView d(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.b;
    }

    public static ImageView e(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.c;
    }

    public static Button f(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.o;
    }

    public static FrameLayout g(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.n;
    }

    public static RectF h(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.j;
    }

    public static Bitmap i(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.q;
    }

    public static ImageDetailView j(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.p;
    }

    public static int k(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.d;
    }

    public static int l(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.e;
    }

    public static int m(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.f;
    }

    public static int n(MNewFindFaceFragment mnewfindfacefragment)
    {
        return mnewfindfacefragment.g;
    }

    public PointF a(View view)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
        float f1 = layoutparams.leftMargin;
        float f2 = layoutparams.topMargin;
        float f3 = j.left;
        float f4 = (float)view.getWidth() / 2.0F;
        float f5 = j.top;
        float f6 = (float)view.getHeight() / 2.0F;
        Log.v("acturalRect", (new StringBuilder()).append(j).append("").toString());
        view = new PointF();
        view.x = (((f1 - f3) + f4) / j.width()) * (float)i.getDrawable().getIntrinsicWidth();
        view.y = (((f2 - f5) + f6) / j.height()) * (float)i.getDrawable().getIntrinsicHeight();
        if (((PointF) (view)).x < 0.0F)
        {
            view.x = 10F;
        }
        if (((PointF) (view)).y < 0.0F)
        {
            view.y = 10F;
        }
        if (((PointF) (view)).x >= (float)i.getDrawable().getBounds().width())
        {
            view.x = i.getDrawable().getBounds().width() - 10;
        }
        if (((PointF) (view)).y >= (float)i.getDrawable().getBounds().height())
        {
            view.y = i.getDrawable().getBounds().height() - 10;
        }
        return view;
    }

    protected void a(View view, PointF pointf, float f1, RectF rectf, float f2)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
        layoutparams.leftMargin = (int)((rectf.left + pointf.x / f1) - (float)view.getWidth() / 2.0F);
        layoutparams.topMargin = (int)(((rectf.top + pointf.y / f1) - (float)view.getHeight() / 2.0F) + (float)yp.a(InstaBeautyApplication.a, f2));
        layoutparams.gravity = 51;
        view.setLayoutParams(layoutparams);
    }

    public void a(ty ty1)
    {
        h = ty1;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
label0:
        {
            layoutinflater = layoutinflater.inflate(0x7f030049, viewgroup, false);
            layoutinflater.setClickable(true);
            b = (ImageView)layoutinflater.findViewById(0x7f0d01ba);
            c = (ImageView)layoutinflater.findViewById(0x7f0d01b9);
            i = (ImageView)layoutinflater.findViewById(0x7f0d01b8);
            p = (ImageDetailView)layoutinflater.findViewById(0x7f0d01c0);
            r = true;
            m = new xu(i);
            m.a(new ts(this));
            viewgroup = (ImageView)layoutinflater.findViewById(0x7f0d01be);
            viewgroup.getBackground().setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.SRC_IN);
            viewgroup.setOnClickListener(new tt(this));
            viewgroup = (ImageView)layoutinflater.findViewById(0x7f0d01bf);
            viewgroup.getBackground().setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.SRC_IN);
            viewgroup.setOnClickListener(new tu(this));
            n = (FrameLayout)layoutinflater.findViewById(0x7f0d01bb);
            o = (Button)layoutinflater.findViewById(0x7f0d01bd);
            o.setSelected(true);
            o.setOnClickListener(new tv(this));
            b.setOnTouchListener(new tw(this));
            c.setOnTouchListener(new tx(this));
            if (h != null)
            {
                q = h.b();
                if (q == null)
                {
                    break label0;
                }
                p.setImage(q);
                i.setImageBitmap(q);
                k.set(q.getWidth() / 4, q.getHeight() / 2);
                l.set((q.getWidth() * 3) / 4, q.getHeight() / 2);
            }
            return layoutinflater;
        }
        h.a();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }
}
