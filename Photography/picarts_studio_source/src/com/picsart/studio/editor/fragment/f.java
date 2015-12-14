// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.CropAction;
import com.picsart.studio.editor.view.CropEditorView;
import com.picsart.studio.editor.view.RulerView;
import com.picsart.studio.editor.view.b;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Geom;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ag;
import java.text.DecimalFormat;
import myobfuscated.bj.a;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class f extends i
{

    public int c;
    public int d;
    public float e;
    public boolean f;
    private CropEditorView i;
    private TextView j;
    private View k;
    private TextView l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private int s;
    private boolean t;
    private float u;
    private DecimalFormat v;
    private long w;
    private int x;

    public f()
    {
        v = new DecimalFormat("0.0");
        c = -1;
        d = -1;
        s = 0;
        u = 0.0F;
        t = false;
    }

    static float a(f f1, float f2)
    {
        f1.u = f2;
        return f2;
    }

    static int a(f f1, int i1)
    {
        f1.s = i1;
        return i1;
    }

    static TextView a(f f1)
    {
        return f1.j;
    }

    static String a(int i1)
    {
        return b(i1);
    }

    static void a(f f1, boolean flag)
    {
        f1.a(flag);
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            l.setText((new StringBuilder()).append(v.format(u)).append("\260").toString());
            k.setVisibility(0);
            k.setOnClickListener(new android.view.View.OnClickListener() {

                final f a;

                public final void onClick(View view)
                {
                    if (com.picsart.studio.editor.fragment.f.e(a).a(null))
                    {
                        AnalyticUtils analyticutils = AnalyticUtils.getInstance(a.getActivity());
                        String s1 = f.f(a);
                        CropEditorView cropeditorview = com.picsart.studio.editor.fragment.f.e(a);
                        int i1 = cropeditorview.s + 1;
                        cropeditorview.s = i1;
                        analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropTryEvent(s1, i1, com.picsart.studio.editor.fragment.f.e(a).getRotation(), com.picsart.studio.editor.fragment.f.a(f.g(a)), f.h(a), a.h.getHeight(), a.h.getWidth(), a.h.getHeight(), a.h.getWidth(), "reset_strengthen"));
                        view.animate().alpha(0.0F).setListener(new ag(this) {

                            private _cls2 a;

                            public final void onAnimationEnd(Animator animator)
                            {
                                super.onAnimationEnd(animator);
                                com.picsart.studio.editor.fragment.f.a(a.a, false);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                    }
                }

            
            {
                a = f.this;
                super();
            }
            });
            return;
        } else
        {
            k.setVisibility(4);
            k.setOnClickListener(null);
            return;
        }
    }

    static View b(f f1)
    {
        return f1.k;
    }

    private static String b(int i1)
    {
        switch (i1)
        {
        default:
            return "";

        case 0: // '\0'
            return "";

        case 1: // '\001'
            return "1:1";

        case 2: // '\002'
            return "4:3";

        case 3: // '\003'
            return "3:4";

        case 4: // '\004'
            return "3:2";

        case 5: // '\005'
            return "16:9";
        }
    }

    static boolean b(f f1, boolean flag)
    {
        f1.t = flag;
        return flag;
    }

    static DecimalFormat c(f f1)
    {
        return f1.v;
    }

    static TextView d(f f1)
    {
        return f1.l;
    }

    static CropEditorView e(f f1)
    {
        return f1.i;
    }

    static String f(f f1)
    {
        return f1.j();
    }

    static int g(f f1)
    {
        return f1.s;
    }

    static boolean h(f f1)
    {
        return f1.f;
    }

    private void i()
    {
        m.setImageResource(0x7f02008f);
        n.setImageResource(0x7f020189);
        o.setImageResource(0x7f02018f);
        p.setImageResource(0x7f02018d);
        q.setImageResource(0x7f02018b);
        r.setImageResource(0x7f020187);
    }

    static void i(f f1)
    {
        f1.i();
        f1.m.setImageResource(0x7f020090);
    }

    static long j(f f1)
    {
        return f1.w;
    }

    private String j()
    {
        if (com.picsart.studio.editor.e.a().b() && (getActivity() instanceof EditorActivity))
        {
            return com.picsart.studio.editor.e.a().e.a;
        } else
        {
            return "";
        }
    }

    static ImageView k(f f1)
    {
        return f1.m;
    }

    static void l(f f1)
    {
        f1.i();
    }

    static ImageView m(f f1)
    {
        return f1.n;
    }

    static ImageView n(f f1)
    {
        return f1.o;
    }

    static ImageView o(f f1)
    {
        return f1.p;
    }

    static ImageView p(f f1)
    {
        return f1.q;
    }

    static ImageView q(f f1)
    {
        return f1.r;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (i != null)
        {
            i.setImage(bitmap);
        }
    }

    public final void d()
    {
        long l1 = (System.nanoTime() - w) / 0x3b9aca00L;
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropCloseEvent(j(), 0, i.getRotation(), b(s), f, h.getHeight(), h.getWidth(), i.b(), i.c(), l1, "back"));
        super.d();
    }

    public final Tool e()
    {
        return Tool.CROP;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            c = bundle.getInt("outW");
            d = bundle.getInt("outH");
            s = bundle.getInt("aspectRatioSelection");
            u = bundle.getFloat("rotation");
            t = bundle.getBoolean("aspectRatioLocked");
            w = bundle.getLong("cropStartTime");
            x = bundle.getInt("actionCounter");
            f = bundle.getBoolean("aspectRatioFixed");
            return;
        } else
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropEvent(getArguments().getString("source")));
            w = System.nanoTime();
            x = 0;
            return;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030103, viewgroup, false);
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("outW", c);
        bundle.putInt("outH", d);
        bundle.putInt("aspectRatioSelection", s);
        bundle.putFloat("rotation", u);
        bundle.putBoolean("aspectRatioLocked", t);
        if (k != null)
        {
            boolean flag;
            if (k.getVisibility() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            bundle.putBoolean("savedAngleIndicatorVisible", flag);
        }
        bundle.putLong("cropStartTime", w);
        bundle.putInt("actionCounter", x);
        bundle.putBoolean("aspectRatioFixed", f);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        boolean flag;
        if (bundle != null && bundle.getBoolean("savedAngleIndicatorVisible"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle = (RulerView)view.findViewById(0x7f100568);
        i = (CropEditorView)view.findViewById(0x7f100567);
        i.setRulerView(bundle);
        i.setImage(h);
        i.setOutputSize(c, d);
        i.setAspectRatio(e);
        i.setAspectRatioFixed(f);
        i.setOnSelectionChangedListener(new b() {

            final f a;

            public final void a()
            {
                com.picsart.studio.editor.fragment.f.b(a).animate().alpha(0.0F).setListener(new ag(this) {

                    private _cls1 a;

                    public final void onAnimationEnd(Animator animator)
                    {
                        super.onAnimationEnd(animator);
                        com.picsart.studio.editor.fragment.f.a(a.a, false);
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            public final void a(float f1)
            {
                if (com.picsart.studio.editor.fragment.f.b(a).getVisibility() == 4 && Math.abs(f1) >= 0.1F)
                {
                    com.picsart.studio.editor.fragment.f.a(a, true);
                    com.picsart.studio.editor.fragment.f.b(a).setAlpha(0.0F);
                    com.picsart.studio.editor.fragment.f.b(a).animate().alpha(1.0F).setListener(null);
                }
                f.d(a).setText((new StringBuilder()).append(com.picsart.studio.editor.fragment.f.c(a).format(f1)).append("\260").toString());
                com.picsart.studio.editor.fragment.f.a(a, f1);
            }

            public final void a(int i1, int j1)
            {
                if (com.picsart.studio.editor.fragment.f.a(a) != null)
                {
                    com.picsart.studio.editor.fragment.f.a(a).post(new Runnable(this, i1, j1) {

                        private int a;
                        private int b;
                        private _cls1 c;

                        public final void run()
                        {
                            com.picsart.studio.editor.fragment.f.a(c.a).setText((new StringBuilder()).append(a).append("x").append(b).append(" ").toString());
                        }

            
            {
                c = _pcls1;
                a = i1;
                b = j1;
                super();
            }
                    });
                }
            }

            
            {
                a = f.this;
                super();
            }
        });
        bundle = view.findViewById(0x7f10054d);
        bundle.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(bundle) {

            private View a;
            private f b;

            public final void onGlobalLayout()
            {
                if (com.picsart.studio.editor.fragment.f.e(b) != null)
                {
                    Utils.a(a, this);
                    com.picsart.studio.editor.fragment.f.e(b).setScreenRectF(new RectF(a.getTop(), a.getLeft(), a.getRight(), a.getBottom()));
                }
            }

            
            {
                b = f.this;
                a = view;
                super();
            }
        });
        j = (TextView)view.findViewById(0x7f100572);
        j.setOnClickListener(new android.view.View.OnClickListener() {

            final f a;

            public final void onClick(View view1)
            {
                view1 = new a();
                int k1 = com.picsart.studio.editor.fragment.f.e(a).b();
                int l1 = com.picsart.studio.editor.fragment.f.e(a).c();
                CropEditorView cropeditorview = com.picsart.studio.editor.fragment.f.e(a);
                float f1;
                int i1;
                int j1;
                if (cropeditorview.g % 2 == 0)
                {
                    i1 = (int)cropeditorview.c;
                } else
                {
                    i1 = (int)cropeditorview.d;
                }
                cropeditorview = com.picsart.studio.editor.fragment.f.e(a);
                if (cropeditorview.g % 2 == 0)
                {
                    j1 = (int)cropeditorview.d;
                } else
                {
                    j1 = (int)cropeditorview.c;
                }
                CropEditorView.d();
                CropEditorView.e();
                view1.b = k1;
                view1.c = l1;
                view1.d = i1;
                view1.e = j1;
                view1.f = 30;
                view1.g = 30;
                if (com.picsart.studio.editor.fragment.f.e(a).j)
                {
                    f1 = com.picsart.studio.editor.fragment.f.e(a).k;
                } else
                {
                    f1 = -1F;
                }
                view1.h = f1;
                view1.a = new myobfuscated.bj.b(this) {

                    private _cls4 a;

                    public final void a(int i1, int j1)
                    {
                        Object obj = com.picsart.studio.editor.fragment.f.e(a.a);
                        float f1 = ((CropEditorView) (obj)).e.width() / ((CropEditorView) (obj)).c;
                        float f2 = i1;
                        float f3 = j1;
                        Geom.b(((CropEditorView) (obj)).i, f2 * f1, f1 * f3);
                        f1 = ((CropEditorView) (obj)).f() / 2.0F;
                        f2 = f1 / 2.0F;
                        i1 = 0;
                        do
                        {
                            if (i1 >= 20)
                            {
                                break;
                            }
                            ((CropEditorView) (obj)).a(((CropEditorView) (obj)).m, ((CropEditorView) (obj)).a(f1));
                            if (((CropEditorView) (obj)).m.width() <= ((CropEditorView) (obj)).e.width() && ((CropEditorView) (obj)).m.height() <= ((CropEditorView) (obj)).e.height())
                            {
                                break;
                            }
                            f1 -= f2;
                            f2 /= 2.0F;
                            i1++;
                        } while (true);
                        obj.h = ((CropEditorView) (obj)).a(f1);
                        ((CropEditorView) (obj)).q.setProgress(f1);
                        ((CropEditorView) (obj)).a(false, false);
                        ((CropEditorView) (obj)).a(null, false);
                        ((CropEditorView) (obj)).h();
                        ((CropEditorView) (obj)).g();
                        if (Math.abs(f1) <= 0.1F)
                        {
                            ((CropEditorView) (obj)).i();
                        }
                        ((CropEditorView) (obj)).invalidate();
                        obj = AnalyticUtils.getInstance(a.a.getActivity());
                        String s1 = f.f(a.a);
                        CropEditorView cropeditorview = com.picsart.studio.editor.fragment.f.e(a.a);
                        i1 = cropeditorview.s + 1;
                        cropeditorview.s = i1;
                        ((AnalyticUtils) (obj)).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropTryEvent(s1, i1, com.picsart.studio.editor.fragment.f.e(a.a).getRotation(), com.picsart.studio.editor.fragment.f.a(f.g(a.a)), f.h(a.a), a.a.h.getHeight(), a.a.h.getWidth(), a.a.h.getHeight(), a.a.h.getWidth(), "custom_size"));
                    }

            
            {
                a = _pcls4;
                super();
            }
                };
                view1.show(a.getFragmentManager(), null);
            }

            
            {
                a = f.this;
                super();
            }
        });
        l = (TextView)view.findViewById(0x7f100569);
        k = view.findViewById(0x7f100566);
        a(flag);
        view.findViewById(0x7f100573).setOnClickListener(new android.view.View.OnClickListener() {

            private f a;

            public final void onClick(View view1)
            {
                view1 = com.picsart.studio.editor.fragment.f.e(a);
                if (!((CropEditorView) (view1)).l) goto _L2; else goto _L1
_L1:
                int i1 = ((CropEditorView) (view1)).g + 1;
                view1.g = i1;
                float f1 = (float)i1 * 90F;
                if (((CropEditorView) (view1)).b == null && !((CropEditorView) (view1)).a)
                {
                    view1.r = true;
                    float f3 = view1.f();
                    long l1 = (long)((300F * Math.abs(f1 - ((CropEditorView) (view1)).h)) / 90F);
                    view1.b = ValueAnimator.ofFloat(new float[] {
                        ((CropEditorView) (view1)).h, f1
                    });
                    ((CropEditorView) (view1)).b.addUpdateListener(new com.picsart.studio.editor.view.CropEditorView._cls2(view1, f3));
                    ((CropEditorView) (view1)).b.addListener(new com.picsart.studio.editor.view.CropEditorView._cls3(view1, null));
                    ((CropEditorView) (view1)).b.setDuration(l1);
                    ((CropEditorView) (view1)).b.start();
                }
_L4:
                if (!f.h(a))
                {
                    f.i(a);
                }
                view1 = AnalyticUtils.getInstance(a.getActivity());
                String s1 = f.f(a);
                CropEditorView cropeditorview = com.picsart.studio.editor.fragment.f.e(a);
                int j1 = cropeditorview.s + 1;
                cropeditorview.s = j1;
                view1.track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropTryEvent(s1, j1, com.picsart.studio.editor.fragment.f.e(a).getRotation(), com.picsart.studio.editor.fragment.f.a(f.g(a)), f.h(a), a.h.getHeight(), a.h.getWidth(), a.h.getHeight(), a.h.getWidth(), "rotate"));
                return;
_L2:
                if (((CropEditorView) (view1)).b == null && !((CropEditorView) (view1)).a)
                {
                    view1.r = true;
                    float f2 = ((CropEditorView) (view1)).i.width() / 2.0F;
                    float f6 = ((CropEditorView) (view1)).i.height() / 2.0F;
                    float f4 = ((CropEditorView) (view1)).i.centerX();
                    float f5 = ((CropEditorView) (view1)).i.centerY();
                    RectF rectf = new RectF(((CropEditorView) (view1)).i);
                    RectF rectf1 = new RectF(f4 - f6, f5 - f2, f6 + f4, f2 + f5);
                    Geom.a(rectf1, ((CropEditorView) (view1)).n, com.socialin.android.util.Geom.Fit.CENTER);
                    f2 = rectf1.width() / ((CropEditorView) (view1)).i.height();
                    f6 = rectf1.width() / 2.0F;
                    float f7 = rectf1.height() / 2.0F;
                    RectF rectf2 = new RectF(f4 - f7, f5 - f6, f4 + f7, f5 + f6);
                    f4 = ((CropEditorView) (view1)).e.width();
                    f5 = ((CropEditorView) (view1)).f;
                    f6 = ((CropEditorView) (view1)).f;
                    if (((CropEditorView) (view1)).j)
                    {
                        view1.k = 1.0F / ((CropEditorView) (view1)).k;
                    }
                    f7 = view1.f();
                    float f8 = ((CropEditorView) (view1)).h;
                    int k1 = ((CropEditorView) (view1)).g + 1;
                    view1.g = k1;
                    view1.b = ValueAnimator.ofFloat(new float[] {
                        f8, (float)k1 * 90F
                    });
                    ((CropEditorView) (view1)).b.addUpdateListener(new com.picsart.studio.editor.view.CropEditorView._cls13(view1, rectf, rectf2, f4, f4 * f2, f5, f6 * f2, f7));
                    ((CropEditorView) (view1)).b.addListener(new com.picsart.studio.editor.view.CropEditorView._cls14(view1, rectf1));
                    ((CropEditorView) (view1)).b.setDuration(300L);
                    ((CropEditorView) (view1)).b.start();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = f.this;
                super();
            }
        });
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private f a;

            public final void onClick(View view1)
            {
                if (a.g != null)
                {
                    long l1 = (System.nanoTime() - f.j(a)) / 0x3b9aca00L;
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropCloseEvent(f.f(a), 0, com.picsart.studio.editor.fragment.f.e(a).getRotation(), com.picsart.studio.editor.fragment.f.a(f.g(a)), f.h(a), a.h.getHeight(), a.h.getWidth(), a.h.getHeight(), a.h.getWidth(), l1, "cancel"));
                    a.g.a(a);
                }
            }

            
            {
                a = f.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private f a;

            public final void onClick(View view1)
            {
                view1 = com.picsart.studio.editor.fragment.f.e(a);
                if (!((CropEditorView) (view1)).a)
                {
                    view1 = CropAction.create(((CropEditorView) (view1)).i, ((CropEditorView) (view1)).e, ((CropEditorView) (view1)).h, ((CropEditorView) (view1)).o, ((CropEditorView) (view1)).p);
                } else
                {
                    view1 = null;
                }
                if (view1 != null)
                {
                    Bitmap bitmap = view1.apply(a.h);
                    long l1 = (System.nanoTime() - f.j(a)) / 0x3b9aca00L;
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropCloseEvent(f.f(a), 0, com.picsart.studio.editor.fragment.f.e(a).getRotation(), com.picsart.studio.editor.fragment.f.a(f.g(a)), f.h(a), a.h.getHeight(), a.h.getWidth(), bitmap.getHeight(), bitmap.getWidth(), l1, "done"));
                    a.g.a(a, bitmap, view1);
                    if (a.getActivity() instanceof EditorActivity)
                    {
                        com.picsart.studio.editor.e.a().e.c("crop");
                    }
                }
            }

            
            {
                a = f.this;
                super();
            }
        });
        view.findViewById(0x7f100571).setOnClickListener(new android.view.View.OnClickListener() {

            private f a;

            public final void onClick(View view1)
            {
                if (!com.picsart.studio.editor.fragment.f.e(a).a())
                {
                    view1 = AnalyticUtils.getInstance(a.getActivity());
                    String s1 = f.f(a);
                    CropEditorView cropeditorview = com.picsart.studio.editor.fragment.f.e(a);
                    int i1 = cropeditorview.s + 1;
                    cropeditorview.s = i1;
                    view1.track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropTryEvent(s1, i1, com.picsart.studio.editor.fragment.f.e(a).getRotation(), com.picsart.studio.editor.fragment.f.a(f.g(a)), f.h(a), a.h.getHeight(), a.h.getWidth(), a.h.getHeight(), a.h.getWidth(), "reset_crop"));
                    if (!f.h(a))
                    {
                        f.k(a).setActivated(false);
                        f.i(a);
                    }
                    view1 = com.picsart.studio.editor.fragment.f.e(a);
                    if (((CropEditorView) (view1)).b == null && !((CropEditorView) (view1)).a)
                    {
                        view1.a(new com.picsart.studio.editor.view.CropEditorView._cls10(view1));
                    }
                    com.picsart.studio.editor.fragment.f.a(a, false);
                    com.picsart.studio.editor.fragment.f.a(a, 0);
                    com.picsart.studio.editor.fragment.f.b(a, false);
                }
            }

            
            {
                a = f.this;
                super();
            }
        });
        if (f)
        {
            view.findViewById(0x7f10056a).setVisibility(8);
            return;
        }
        bundle = new android.view.View.OnClickListener() {

            private f a;

            public final void onClick(View view1)
            {
                if (com.picsart.studio.editor.fragment.f.e(a).a()) goto _L2; else goto _L1
_L1:
                f.k(a).setActivated(true);
                f.l(a);
                view1.getId();
                JVM INSTR tableswitch 2131756396 2131756400: default 68
            //                           2131756396 202
            //                           2131756397 237
            //                           2131756398 273
            //                           2131756399 309
            //                           2131756400 345;
                   goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
                com.picsart.studio.editor.fragment.f.b(a, true);
                view1 = AnalyticUtils.getInstance(a.getActivity());
                String s1 = f.f(a);
                CropEditorView cropeditorview = com.picsart.studio.editor.fragment.f.e(a);
                int i1 = cropeditorview.s + 1;
                cropeditorview.s = i1;
                view1.track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropTryEvent(s1, i1, com.picsart.studio.editor.fragment.f.e(a).getRotation(), com.picsart.studio.editor.fragment.f.a(f.g(a)), f.h(a), a.h.getHeight(), a.h.getWidth(), a.h.getHeight(), a.h.getWidth(), "ratio"));
_L2:
                return;
_L4:
                com.picsart.studio.editor.fragment.f.e(a).setSelectionProportion(1.0F);
                f.m(a).setImageResource(0x7f02018a);
                com.picsart.studio.editor.fragment.f.a(a, 1);
                continue; /* Loop/switch isn't completed */
_L5:
                com.picsart.studio.editor.fragment.f.e(a).setSelectionProportion(0.75F);
                f.n(a).setImageResource(0x7f020190);
                com.picsart.studio.editor.fragment.f.a(a, 2);
                continue; /* Loop/switch isn't completed */
_L6:
                com.picsart.studio.editor.fragment.f.e(a).setSelectionProportion(1.333333F);
                f.o(a).setImageResource(0x7f02018e);
                com.picsart.studio.editor.fragment.f.a(a, 3);
                continue; /* Loop/switch isn't completed */
_L7:
                com.picsart.studio.editor.fragment.f.e(a).setSelectionProportion(0.6666667F);
                f.p(a).setImageResource(0x7f02018c);
                com.picsart.studio.editor.fragment.f.a(a, 4);
                continue; /* Loop/switch isn't completed */
_L8:
                com.picsart.studio.editor.fragment.f.e(a).setSelectionProportion(0.5625F);
                f.q(a).setImageResource(0x7f020188);
                com.picsart.studio.editor.fragment.f.a(a, 5);
                if (true) goto _L3; else goto _L9
_L9:
            }

            
            {
                a = f.this;
                super();
            }
        };
        m = (ImageView)view.findViewById(0x7f10056b);
        m.setOnClickListener(new android.view.View.OnClickListener() {

            private f a;

            public final void onClick(View view1)
            {
                if (!com.picsart.studio.editor.fragment.f.e(a).a())
                {
                    String s1;
                    CropEditorView cropeditorview;
                    int i1;
                    if (f.k(a).isActivated())
                    {
                        f.k(a).setActivated(false);
                        com.picsart.studio.editor.fragment.f.e(a).j = false;
                        com.picsart.studio.editor.fragment.f.b(a, false);
                    } else
                    {
                        view1.setActivated(true);
                        view1 = com.picsart.studio.editor.fragment.f.e(a);
                        view1.j = true;
                        view1.k = ((CropEditorView) (view1)).i.height() / ((CropEditorView) (view1)).i.width();
                        com.picsart.studio.editor.fragment.f.b(a, true);
                    }
                    f.i(a);
                    com.picsart.studio.editor.fragment.f.a(a, 0);
                    view1 = AnalyticUtils.getInstance(a.getActivity());
                    s1 = f.f(a);
                    cropeditorview = com.picsart.studio.editor.fragment.f.e(a);
                    i1 = cropeditorview.s + 1;
                    cropeditorview.s = i1;
                    view1.track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropTryEvent(s1, i1, com.picsart.studio.editor.fragment.f.e(a).getRotation(), com.picsart.studio.editor.fragment.f.a(f.g(a)), f.h(a), a.h.getHeight(), a.h.getWidth(), com.picsart.studio.editor.fragment.f.e(a).b(), com.picsart.studio.editor.fragment.f.e(a).c(), "lock"));
                }
            }

            
            {
                a = f.this;
                super();
            }
        });
        n = (ImageView)view.findViewById(0x7f10056c);
        n.setOnClickListener(bundle);
        o = (ImageView)view.findViewById(0x7f10056d);
        o.setOnClickListener(bundle);
        p = (ImageView)view.findViewById(0x7f10056e);
        p.setOnClickListener(bundle);
        q = (ImageView)view.findViewById(0x7f10056f);
        q.setOnClickListener(bundle);
        r = (ImageView)view.findViewById(0x7f100570);
        r.setOnClickListener(bundle);
        i();
        s;
        JVM INSTR tableswitch 0 5: default 492
    //                   0 504
    //                   1 516
    //                   2 529
    //                   3 542
    //                   4 555
    //                   5 568;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        m.setActivated(t);
        return;
_L2:
        m.setImageResource(0x7f020090);
        continue; /* Loop/switch isn't completed */
_L3:
        n.setImageResource(0x7f02018a);
        continue; /* Loop/switch isn't completed */
_L4:
        o.setImageResource(0x7f020190);
        continue; /* Loop/switch isn't completed */
_L5:
        p.setImageResource(0x7f02018e);
        continue; /* Loop/switch isn't completed */
_L6:
        q.setImageResource(0x7f02018c);
        continue; /* Loop/switch isn't completed */
_L7:
        r.setImageResource(0x7f020188);
        if (true) goto _L1; else goto _L8
_L8:
    }
}
