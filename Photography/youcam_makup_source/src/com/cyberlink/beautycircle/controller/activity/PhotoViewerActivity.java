// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.PostBase;
import com.cyberlink.beautycircle.view.widgetpool.common.NonSwipableViewPager;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.cyberlink.beautycircle.view.widgetpool.common.q;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class PhotoViewerActivity extends BaseActivity
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    public static final UUID e = UUID.randomUUID();
    public static ArrayList f = null;
    private android.view.View.OnTouchListener A;
    protected PagerAdapter g;
    boolean h;
    private ArrayList i;
    private int j;
    private int k[];
    private GestureDetector l;
    private ScaleGestureDetector m;
    private NonSwipableViewPager n;
    private TextView o;
    private View p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private android.view.GestureDetector.SimpleOnGestureListener w;
    private android.view.ScaleGestureDetector.SimpleOnScaleGestureListener x;
    private View y;
    private Runnable z;

    public PhotoViewerActivity()
    {
        i = new ArrayList();
        j = -1;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = 0.0F;
        r = 0.0F;
        s = 0.0F;
        t = 0.0F;
        u = 0.0F;
        v = 0.0F;
        g = new PagerAdapter() {

            final PhotoViewerActivity a;

            public void destroyItem(ViewGroup viewgroup, int i1, Object obj)
            {
                PhotoViewerActivity.a(a).removeView((View)obj);
            }

            public int getCount()
            {
                return PhotoViewerActivity.c(a).size();
            }

            public Object instantiateItem(ViewGroup viewgroup, int i1)
            {
                if (i1 >= PhotoViewerActivity.c(a).size())
                {
                    return null;
                }
                Object obj = (PostBase)PhotoViewerActivity.c(a).get(i1);
                RelativeLayout relativelayout = (RelativeLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(k.bc_view_item_photo_viewer_photo, viewgroup, false);
                relativelayout.setOnTouchListener(PhotoViewerActivity.d(a));
                UICImageView uicimageview = (UICImageView)relativelayout.findViewById(j.photo_view_photo);
                obj = ((PostBase) (obj)).attachments.c().b();
                if (((FileMetadata) (obj)).originalUrl != null)
                {
                    uicimageview.setImageURI(((FileMetadata) (obj)).originalUrl);
                    uicimageview.setVisibility(4);
                    uicimageview.setTag(Integer.valueOf(i1));
                    uicimageview.setOnBitmapSetListener(new q(this, uicimageview, relativelayout, i1) {

                        final UICImageView a;
                        final RelativeLayout b;
                        final int c;
                        final _cls2 d;

                        public void a(Bitmap bitmap)
                        {
                            a.setOnBitmapSetListener(null);
                            int i1 = b.getWidth();
                            int j1 = b.getHeight();
                            float f1 = Math.min((float)i1 / (float)bitmap.getWidth(), (float)j1 / (float)bitmap.getHeight());
                            i1 = (int)(((float)i1 - (float)bitmap.getWidth() * f1) / 2.0F);
                            j1 = (int)(((float)j1 - (float)bitmap.getHeight() * f1) / 2.0F);
                            int k1 = (int)((float)bitmap.getWidth() * f1);
                            int l1 = (int)((float)bitmap.getHeight() * f1);
                            bitmap = (android.widget.RelativeLayout.LayoutParams)a.getLayoutParams();
                            bitmap.width = k1;
                            bitmap.height = l1;
                            a.setLayoutParams(bitmap);
                            if (com.cyberlink.beautycircle.controller.activity.PhotoViewerActivity.e(d.a) == c)
                            {
                                a.setTranslationX(PhotoViewerActivity.f(d.a)[0] - i1);
                                a.setTranslationY(PhotoViewerActivity.f(d.a)[1] - j1);
                                a.setScaleX((float)PhotoViewerActivity.f(d.a)[2] / (float)k1);
                                a.setScaleY((float)PhotoViewerActivity.f(d.a)[3] / (float)l1);
                                PhotoViewerActivity.a(d.a, a, 0.0F, 0.0F, 1.0F, 1.0F);
                                PhotoViewerActivity.a(d.a, -1);
                            }
                            a.setVisibility(0);
                        }

            
            {
                d = _pcls2;
                a = uicimageview;
                b = relativelayout;
                c = i1;
                super();
            }
                    });
                }
                viewgroup.addView(relativelayout);
                return relativelayout;
            }

            public boolean isViewFromObject(View view, Object obj)
            {
                return view.equals(obj);
            }

            
            {
                a = PhotoViewerActivity.this;
                super();
            }
        };
        w = new android.view.GestureDetector.SimpleOnGestureListener() {

            final PhotoViewerActivity a;

            public boolean onDoubleTap(MotionEvent motionevent)
            {
                PhotoViewerActivity.a(a, (UICImageView)PhotoViewerActivity.h(a), motionevent.getX(), motionevent.getY());
                return true;
            }

            public boolean onDown(MotionEvent motionevent)
            {
                return true;
            }

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
            {
                float f5 = (f1 * 0.2F) / 2.0F;
                float f4 = (0.2F * f2) / 2.0F;
                float f3 = f5;
                if ((motionevent.getX() - motionevent1.getX()) * f1 < 0.0F)
                {
                    f3 = f5 * -1F;
                }
                f1 = f4;
                if ((motionevent.getY() - motionevent1.getY()) * f2 < 0.0F)
                {
                    f1 = f4 * -1F;
                }
                PhotoViewerActivity.a(a, f3, f1);
                return true;
            }

            public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
            {
                PhotoViewerActivity.b(a, (UICImageView)PhotoViewerActivity.h(a), f1, f2);
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionevent)
            {
                int i1 = PhotoViewerActivity.b(a).getVisibility();
                if (i1 == 0 || i1 == 8)
                {
                    PhotoViewerActivity.b(a).setVisibility(4);
                    PhotoViewerActivity.g(a).setVisibility(4);
                } else
                {
                    PhotoViewerActivity.b(a).setVisibility(0);
                    PhotoViewerActivity.g(a).setVisibility(0);
                }
                return true;
            }

            
            {
                a = PhotoViewerActivity.this;
                super();
            }
        };
        x = new android.view.ScaleGestureDetector.SimpleOnScaleGestureListener() {

            final PhotoViewerActivity a;

            public boolean onScale(ScaleGestureDetector scalegesturedetector)
            {
                UICImageView uicimageview = (UICImageView)PhotoViewerActivity.h(a);
                if (uicimageview == null) goto _L2; else goto _L1
_L1:
                float f1;
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                float f8;
                f2 = (6F * (float)uicimageview.getBitmapWidth()) / (float)uicimageview.getWidth();
                f1 = scalegesturedetector.getScaleFactor();
                f2 = Math.max(1.0F, Math.min(PhotoViewerActivity.h(a).getScaleX() * f1, f2));
                scalegesturedetector = new float[2];
                scalegesturedetector;
                scalegesturedetector[0] = 0.0F;
                scalegesturedetector[1] = 0.0F;
                f3 = uicimageview.getTop();
                f6 = PhotoViewerActivity.i(a) * f2;
                f8 = com.cyberlink.beautycircle.controller.activity.PhotoViewerActivity.j(a) * f2;
                Math.abs(PhotoViewerActivity.i(a) - f6);
                Math.abs(com.cyberlink.beautycircle.controller.activity.PhotoViewerActivity.j(a) - f8);
                f4 = uicimageview.getTranslationX();
                f5 = uicimageview.getTranslationY();
                if (com.cyberlink.beautycircle.controller.activity.PhotoViewerActivity.k(a) != 0.0F) goto _L4; else goto _L3
_L3:
                scalegesturedetector[0] = PhotoViewerActivity.i(a) - f6;
                scalegesturedetector[1] = com.cyberlink.beautycircle.controller.activity.PhotoViewerActivity.j(a) - f8;
_L6:
                if (scalegesturedetector[0] > 0.0F)
                {
                    scalegesturedetector[0] = 0.0F;
                }
                if (scalegesturedetector[1] > f3)
                {
                    scalegesturedetector[1] = f3;
                }
                PhotoViewerActivity.a(a, f2);
                uicimageview.setScaleX(f2);
                uicimageview.setScaleY(f2);
                uicimageview.setTranslationX(scalegesturedetector[0]);
                uicimageview.setTranslationY(scalegesturedetector[1]);
_L2:
                return true;
_L4:
                float f7 = PhotoViewerActivity.i(a) * Math.abs(PhotoViewerActivity.l(a) - f2);
                float f9 = com.cyberlink.beautycircle.controller.activity.PhotoViewerActivity.j(a) * Math.abs(PhotoViewerActivity.l(a) - f2);
                if (f1 > 1.0F)
                {
                    scalegesturedetector[0] = f4 - f7;
                    scalegesturedetector[1] = f5 - f9;
                } else
                {
                    scalegesturedetector[0] = f4 + f7;
                    scalegesturedetector[1] = f5 + f9;
                }
                if (f2 == 1.0F)
                {
                    scalegesturedetector[0] = 0.0F;
                    scalegesturedetector[1] = 0.0F;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
            {
                UICImageView uicimageview = (UICImageView)PhotoViewerActivity.h(a);
                float f1 = (6F * (float)uicimageview.getBitmapWidth()) / (float)uicimageview.getWidth();
                f1 = Math.max(1.0F, Math.min(scalegesturedetector.getScaleFactor() * PhotoViewerActivity.h(a).getScaleX(), f1));
                PhotoViewerActivity.a(a, f1);
                float f2 = uicimageview.getX();
                float f3 = uicimageview.getY();
                float f4 = uicimageview.getTranslationX();
                float f5 = scalegesturedetector.getFocusX();
                float f6 = scalegesturedetector.getFocusY();
                PhotoViewerActivity.b(a, f5 - f2);
                PhotoViewerActivity.c(a, f6 - f3);
                PhotoViewerActivity.d(a, f1);
                com.cyberlink.beautycircle.controller.activity.PhotoViewerActivity.e(a, f1);
                PhotoViewerActivity.f(a, f4);
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
            {
            }

            
            {
                a = PhotoViewerActivity.this;
                super();
            }
        };
        y = null;
        z = null;
        A = new android.view.View.OnTouchListener() {

            final PhotoViewerActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                PhotoViewerActivity.a(a, view.findViewById(j.photo_view_photo));
                if (motionevent.getAction() == 1 && a.h)
                {
                    PhotoViewerActivity.a(a, (UICImageView)PhotoViewerActivity.h(a));
                } else
                if (motionevent.getAction() == 0 && PhotoViewerActivity.m(a) != null)
                {
                    PhotoViewerActivity.a(a).removeCallbacks(PhotoViewerActivity.m(a));
                    PhotoViewerActivity.a(a, null);
                }
                if (motionevent.getAction() == 0)
                {
                    PhotoViewerActivity.a(a).requestDisallowInterceptTouchEvent(true);
                }
                if (motionevent.getPointerCount() > 1)
                {
                    return PhotoViewerActivity.n(a).onTouchEvent(motionevent);
                } else
                {
                    return PhotoViewerActivity.o(a).onTouchEvent(motionevent);
                }
            }

            
            {
                a = PhotoViewerActivity.this;
                super();
            }
        };
        h = false;
    }

    static float a(PhotoViewerActivity photovieweractivity, float f1)
    {
        photovieweractivity.v = f1;
        return f1;
    }

    static int a(PhotoViewerActivity photovieweractivity, int i1)
    {
        photovieweractivity.j = i1;
        return i1;
    }

    private int a(UICImageView uicimageview, float f1, float af[])
    {
        return 0;
    }

    static View a(PhotoViewerActivity photovieweractivity, View view)
    {
        photovieweractivity.y = view;
        return view;
    }

    static NonSwipableViewPager a(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.n;
    }

    static Runnable a(PhotoViewerActivity photovieweractivity, Runnable runnable)
    {
        photovieweractivity.z = runnable;
        return runnable;
    }

    private void a(float f1, float f2)
    {
        ValueAnimator valueanimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("translateX", new float[] {
                f1
            }), PropertyValuesHolder.ofFloat("translateY", new float[] {
                f2
            })
        });
        valueanimator.addUpdateListener(this);
        valueanimator.setInterpolator(new DecelerateInterpolator());
        q = 0.0F;
        r = 0.0F;
        valueanimator.setDuration(200L).start();
    }

    private void a(int i1, int j1)
    {
        Object obj = (PostBase)i.get(i1);
        if (obj != null && o != null && ((PostBase) (obj)).content != null)
        {
            obj = Html.fromHtml(((PostBase) (obj)).content).toString();
            o.setText(((CharSequence) (obj)));
            o.setVisibility(j1);
            p.setVisibility(j1);
        }
    }

    private void a(View view, float f1, float f2, float f3, float f4)
    {
        ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("translationX", new float[] {
                f1
            }), PropertyValuesHolder.ofFloat("translationY", new float[] {
                f2
            }), PropertyValuesHolder.ofFloat("scaleX", new float[] {
                f3
            }), PropertyValuesHolder.ofFloat("scaleY", new float[] {
                f4
            })
        }).setDuration(300L).start();
    }

    static void a(PhotoViewerActivity photovieweractivity, float f1, float f2)
    {
        photovieweractivity.a(f1, f2);
    }

    static void a(PhotoViewerActivity photovieweractivity, int i1, int j1)
    {
        photovieweractivity.a(i1, j1);
    }

    static void a(PhotoViewerActivity photovieweractivity, View view, float f1, float f2, float f3, float f4)
    {
        photovieweractivity.a(view, f1, f2, f3, f4);
    }

    static void a(PhotoViewerActivity photovieweractivity, UICImageView uicimageview)
    {
        photovieweractivity.a(uicimageview);
    }

    static void a(PhotoViewerActivity photovieweractivity, UICImageView uicimageview, float f1, float f2)
    {
        photovieweractivity.a(uicimageview, f1, f2);
    }

    private void a(UICImageView uicimageview)
    {
        h = true;
        if (uicimageview != null)
        {
            if ((uicimageview.getTranslationX() + (float)uicimageview.getWidth() * uicimageview.getScaleX()) - 10F < (float)uicimageview.getWidth())
            {
                n.setEnabled(true);
                return;
            }
            if (uicimageview.getX() + 10F > 0.0F)
            {
                n.setEnabled(true);
                return;
            }
        }
    }

    private void a(UICImageView uicimageview, float f1, float f2)
    {
        if (uicimageview == null)
        {
            return;
        }
        float af[] = new float[2];
        float[] _tmp = af;
        af[0] = 0.0F;
        af[1] = 0.0F;
        float f4 = uicimageview.getX();
        float f5 = uicimageview.getY();
        if (uicimageview.getScaleX() == 1.0F)
        {
            float f3 = (6F * (float)uicimageview.getBitmapWidth()) / (float)uicimageview.getWidth();
            af[0] = (f1 - f4) * (1.0F - f3);
            af[1] = (1.0F - f3) * (f2 - f5);
            a(uicimageview, f3, af);
            n.requestDisallowInterceptTouchEvent(true);
            f1 = f3;
        } else
        {
            n.requestDisallowInterceptTouchEvent(false);
            f1 = 1.0F;
        }
        a(((View) (uicimageview)), af[0], af[1], f1, f1);
    }

    static float b(PhotoViewerActivity photovieweractivity, float f1)
    {
        photovieweractivity.s = f1;
        return f1;
    }

    static TextView b(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.o;
    }

    static void b(PhotoViewerActivity photovieweractivity, UICImageView uicimageview, float f1, float f2)
    {
        photovieweractivity.b(uicimageview, f1, f2);
    }

    private void b(UICImageView uicimageview, float f1, float f2)
    {
        if (uicimageview != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        float f3;
        float f4;
        h = true;
        f4 = uicimageview.getX();
        f3 = uicimageview.getY();
        float f5 = uicimageview.getHeight();
        if (f1 > 0.0F)
        {
            f4 = (uicimageview.getX() + (float)uicimageview.getWidth() * uicimageview.getScaleX()) - (float)n.getWidth();
            if (f4 <= 0.0F)
            {
                n.requestDisallowInterceptTouchEvent(false);
                f1 = 0.0F;
            } else
            if (f4 < f1)
            {
                n.requestDisallowInterceptTouchEvent(true);
                f1 = f4;
            } else
            {
                n.requestDisallowInterceptTouchEvent(true);
            }
        } else
        if (f1 < 0.0F)
        {
            if (f4 >= 0.0F)
            {
                n.requestDisallowInterceptTouchEvent(false);
                f1 = 0.0F;
            } else
            if (f4 - f1 > 0.0F)
            {
                n.requestDisallowInterceptTouchEvent(true);
                f1 = f4;
            } else
            {
                n.requestDisallowInterceptTouchEvent(true);
            }
        } else
        {
            n.setEnabled(false);
        }
        uicimageview.setTranslationX(uicimageview.getTranslationX() - f1);
        f1 = uicimageview.getScaleY();
        f4 = (f5 * f1 + f3) - (float)n.getHeight();
        if (f1 == 1.0F) goto _L1; else goto _L3
_L3:
        if (f2 <= 0.0F) goto _L5; else goto _L4
_L4:
        if (f3 > 0.0F) goto _L7; else goto _L6
_L6:
        if (f4 >= 0.0F) goto _L9; else goto _L8
_L8:
        f1 = 0.0F;
_L11:
        uicimageview.setTranslationY(uicimageview.getTranslationY() - f1);
        return;
_L9:
        f1 = f2;
        if (f4 < f2)
        {
            f1 = f4;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        f1 = f2;
        if (f3 > 0.0F)
        {
            if (f4 > 0.0F)
            {
                if (Math.abs(f4) > Math.abs(f3))
                {
                    f3 = f4;
                }
                f1 = f2;
                if (f3 < f2)
                {
                    f1 = f3;
                }
            } else
            {
                f1 = f2;
                if (f3 < f2)
                {
                    f1 = f3;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        f1 = f2;
        if (f2 < 0.0F)
        {
            if (f3 <= 0.0F)
            {
                if (f4 < 0.0F)
                {
                    if (Math.abs(f4) > Math.abs(f3))
                    {
                        f3 = f4;
                    }
                    f1 = f2;
                    if (f3 > f2)
                    {
                        f1 = f3;
                    }
                } else
                {
                    f1 = f2;
                    if (f3 > f2)
                    {
                        f1 = f3;
                    }
                }
            } else
            {
                f1 = f2;
                if (f3 > 0.0F)
                {
                    if (f4 >= 0.0F)
                    {
                        f1 = 0.0F;
                    } else
                    {
                        f1 = f2;
                        if (Math.abs(f4) < Math.abs(f2))
                        {
                            f1 = f4;
                        }
                    }
                }
            }
        }
        if (true) goto _L11; else goto _L10
_L10:
    }

    static float c(PhotoViewerActivity photovieweractivity, float f1)
    {
        photovieweractivity.t = f1;
        return f1;
    }

    static ArrayList c(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.i;
    }

    static float d(PhotoViewerActivity photovieweractivity, float f1)
    {
        f1 = photovieweractivity.s / f1;
        photovieweractivity.s = f1;
        return f1;
    }

    static android.view.View.OnTouchListener d(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.A;
    }

    static float e(PhotoViewerActivity photovieweractivity, float f1)
    {
        f1 = photovieweractivity.t / f1;
        photovieweractivity.t = f1;
        return f1;
    }

    static int e(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.j;
    }

    static float f(PhotoViewerActivity photovieweractivity, float f1)
    {
        photovieweractivity.u = f1;
        return f1;
    }

    static int[] f(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.k;
    }

    static View g(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.p;
    }

    static View h(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.y;
    }

    static float i(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.s;
    }

    static float j(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.t;
    }

    static float k(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.u;
    }

    static float l(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.v;
    }

    static Runnable m(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.z;
    }

    static ScaleGestureDetector n(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.m;
    }

    static GestureDetector o(PhotoViewerActivity photovieweractivity)
    {
        return photovieweractivity.l;
    }

    private void o()
    {
        p = findViewById(j.photo_view_div);
        o = (TextView)findViewById(j.photo_view_text);
        a(j, 0);
        n = (NonSwipableViewPager)findViewById(j.photo_view_pager);
        if (n != null)
        {
            n.setPageMargin(20);
            n.setAdapter(g);
            if (j >= 0)
            {
                n.setCurrentItem(j, false);
            }
            n.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

                final PhotoViewerActivity a;

                private void a(View view)
                {
                    if (view == null)
                    {
                        return;
                    } else
                    {
                        view.setTranslationX(0.0F);
                        view.setTranslationY(0.0F);
                        view.setScaleX(1.0F);
                        view.setScaleY(1.0F);
                        return;
                    }
                }

                public void onPageScrollStateChanged(int i1)
                {
                    if (i1 == 0)
                    {
                        i1 = PhotoViewerActivity.a(a).getCurrentItem();
                        a(PhotoViewerActivity.a(a).findViewWithTag(Integer.valueOf(i1 - 1)));
                        a(PhotoViewerActivity.a(a).findViewWithTag(Integer.valueOf(i1 + 1)));
                    }
                }

                public void onPageScrolled(int i1, float f1, int j1)
                {
                }

                public void onPageSelected(int i1)
                {
                    int j1 = PhotoViewerActivity.b(a).getVisibility();
                    PhotoViewerActivity.a(a, i1, j1);
                }

            
            {
                a = PhotoViewerActivity.this;
                super();
            }
            });
        }
    }

    private void p()
    {
    }

    private void q()
    {
        l = new GestureDetector(this, w);
        l.setOnDoubleTapListener(w);
        m = new ScaleGestureDetector(this, x);
    }

    private void r()
    {
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f1 = Float.valueOf(valueanimator.getAnimatedValue("translateX").toString()).floatValue();
        float f2 = Float.valueOf(valueanimator.getAnimatedValue("translateY").toString()).floatValue();
        float f3 = f1 - q;
        float f4 = f2 - r;
        q = f1;
        r = f2;
        if (f3 != 0.0F || f4 != 0.0F)
        {
            b((UICImageView)y, f3, f4);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_photo_viewer);
        bundle = getIntent();
        long l1 = bundle.getLongExtra("SelectedSubPostId", -1L);
        k = bundle.getIntArrayExtra("TransitionRect");
        bundle = f.iterator();
        do
        {
            if (!bundle.hasNext())
            {
                break;
            }
            PostBase postbase = (PostBase)bundle.next();
            if (postbase.attachments != null && postbase.attachments.b())
            {
                if (postbase.b_().longValue() == l1)
                {
                    j = i.size();
                }
                i.add(postbase);
            }
        } while (true);
        o();
        q();
    }

    public void onDestroy()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        r();
        p();
        super.onDestroy();
    }

}
