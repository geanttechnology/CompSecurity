// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.photo.adjust.TwoDirectionSeekbar;
import com.photo.effect.Effect;
import com.photo.effect.EffectParameter;
import com.photo.gpu.GPUImage;
import com.photo.gpu.GPUImageView;
import com.photo.gpu.d;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.view.FloatSeekBar;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import myobfuscated.aw.c;
import myobfuscated.f.m;
import myobfuscated.m.a;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i, c

public final class b extends i
    implements a
{

    private String c;
    private boolean d;
    private boolean e;
    private Effect f;
    private c i;
    private GPUImageView j;
    private TwoDirectionSeekbar k;
    private TextView l;
    private RadioGroup m;
    private ThreadPoolExecutor n;
    private int o;
    private Bitmap p;
    private int q;

    public b()
    {
        c = "";
        d = false;
        e = false;
        n = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
    }

    static Effect a(b b1)
    {
        return b1.f;
    }

    private void a(int i1)
    {
        int j1 = k();
        if (l != null && j1 != -1)
        {
            char c1 = 'd';
            if (f.b(j1).a.equals("Hue"))
            {
                c1 = '\264';
            }
            i1 = (int)((float)(c1 * (i1 - 50)) / 50F);
            String s = "";
            if (i1 > 0)
            {
                s = "+";
            }
            l.setText((new StringBuilder()).append(s).append(Integer.toString(i1)).toString());
        }
    }

    static void a(b b1, int i1)
    {
        b1.a(i1);
    }

    static boolean a(b b1, boolean flag)
    {
        b1.d = flag;
        return flag;
    }

    static String b(b b1)
    {
        return b1.c;
    }

    static String c(b b1)
    {
        int i1 = b1.m.getCheckedRadioButtonId();
        if (i1 == 0x7f10051a)
        {
            return "brightness";
        }
        if (i1 == 0x7f100545)
        {
            return "contrast";
        }
        if (i1 == 0x7f100546)
        {
            return "saturation";
        }
        if (i1 == 0x7f100547)
        {
            return "hue";
        }
        if (i1 == 0x7f100548)
        {
            return "shadows";
        }
        if (i1 == 0x7f100549)
        {
            return "highlights";
        }
        if (i1 == 0x7f10054a)
        {
            return "temp";
        } else
        {
            return "";
        }
    }

    static int d(b b1)
    {
        int i1 = b1.q + 1;
        b1.q = i1;
        return i1;
    }

    static int e(b b1)
    {
        return b1.k();
    }

    static c f(b b1)
    {
        return b1.i;
    }

    static GPUImageView g(b b1)
    {
        return b1.j;
    }

    static void h(b b1)
    {
        b1.j();
    }

    private Bitmap i()
    {
        Log.e("ex1", (new StringBuilder("textureMaxSize = ")).append(o).toString());
        if (o > 0)
        {
            if (p == null && h != null)
            {
                p = w.a(h, o);
            }
        } else
        {
            p = h;
        }
        return p;
    }

    static boolean i(b b1)
    {
        return b1.d;
    }

    private void j()
    {
        if (k != null)
        {
            int j1 = k();
            EffectParameter effectparameter = f.b(j1);
            float f1 = ((Float)effectparameter.c).floatValue();
            float f2 = ((Float)effectparameter.f).floatValue();
            float f3 = ((Float)effectparameter.e).floatValue();
            float f4 = ((Float)effectparameter.d).floatValue();
            int i1;
            if (f1 < f2)
            {
                i1 = (int)(((f1 - f4) / (f2 - f4)) * 50F);
            } else
            if (f1 > f2)
            {
                i1 = (int)(((f1 - f2) / (f3 - f2)) * 50F + 50F);
            } else
            {
                i1 = 50;
            }
            Log.e("ex1", (new StringBuilder("currentParameterIndex = ")).append(j1).toString());
            Log.e("ex1", (new StringBuilder("progress = ")).append(i1).toString());
            Log.e("ex1", (new StringBuilder("value = ")).append(f1).toString());
            Log.e("ex1", (new StringBuilder("maxValue = ")).append(f3).toString());
            Log.e("ex1", (new StringBuilder("minValue = ")).append(f4).toString());
            k.setValue(i1);
            a(i1);
        }
    }

    static boolean j(b b1)
    {
        return b1.e;
    }

    private int k()
    {
        int i1 = m.getCheckedRadioButtonId();
        if (i1 == 0x7f10051a)
        {
            return 0;
        }
        if (i1 == 0x7f100545)
        {
            return 1;
        }
        if (i1 == 0x7f100546)
        {
            return 2;
        }
        if (i1 == 0x7f100547)
        {
            return 3;
        }
        if (i1 == 0x7f100548)
        {
            return 4;
        }
        if (i1 == 0x7f100549)
        {
            return 5;
        }
        return i1 != 0x7f10054a ? -1 : 6;
    }

    static void k(b b1)
    {
        com.picsart.studio.editor.fragment.c c1 = b1. new com.picsart.studio.editor.fragment.c() {

            final b a;

            public final void a(Bitmap bitmap)
            {
                Object obj = a.getActivity();
                if (obj != null && !((Activity) (obj)).isFinishing())
                {
                    obj = new ImageView(((android.content.Context) (obj)));
                    ((ImageView) (obj)).setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                    ((ImageView) (obj)).setImageBitmap(bitmap);
                    ((ImageView) (obj)).setBackgroundColor(0xff000000);
                    bitmap = a.getView();
                    if (bitmap != null)
                    {
                        ((FrameLayout)bitmap.findViewById(0x7f10053f)).addView(((View) (obj)));
                    }
                    com.picsart.studio.editor.fragment.b.a(a, true);
                    (new ModernAsyncTask(this) {

                        private _cls10 a;

                        private transient d a()
                        {
                            Object obj = b.g(a.a).b;
                            com.photo.gpu.GPUImage.ReadPixelsResultType readpixelsresulttype = com.photo.gpu.GPUImage.ReadPixelsResultType.ReadPixelsResultTypeBitmap;
                            obj = ((GPUImage) (obj)).a(((GPUImage) (obj)).e, readpixelsresulttype);
                            try
                            {
                                Thread.sleep(300L);
                            }
                            catch (InterruptedException interruptedexception)
                            {
                                interruptedexception.printStackTrace();
                                return ((d) (obj));
                            }
                            return ((d) (obj));
                        }

                        protected final Object doInBackground(Object aobj[])
                        {
                            return a();
                        }

                        protected final void onPostExecute(Object obj)
                        {
                            obj = (d)obj;
                            com.picsart.studio.editor.fragment.b.a(a.a, false);
                            ((EditorActivity)a.a.getActivity()).e();
                            AnalyticUtils.getInstance(a.a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.EditToolsApplyEvent("tool_adjust"));
                            com.picsart.studio.editor.e.a().e.c("adjust");
                            a.a.g.a(a.a, ((d) (obj)).a, RasterAction.create(((d) (obj)).a, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
                        }

                        protected final void onPreExecute()
                        {
                            ((EditorActivity)a.a.getActivity()).d();
                        }

            
            {
                a = _pcls10;
                super();
            }
                    }).executeOnExecutor(b.o(a), new Void[] {
                        null
                    });
                }
            }

            
            {
                a = b.this;
                super();
            }
        };
        b1.e = true;
        (b1. new ModernAsyncTask(c1) {

            private com.picsart.studio.editor.fragment.c a;
            private b b;

            protected final Object doInBackground(Object aobj[])
            {
                return b.g(b).b.d();
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Bitmap)obj;
                if (a != null)
                {
                    a.a(((Bitmap) (obj)));
                }
                b.p(b);
            }

            
            {
                b = b.this;
                a = c1;
                super();
            }
        }).executeOnExecutor(b1.n, new Void[] {
            null
        });
    }

    static TwoDirectionSeekbar l(b b1)
    {
        return b1.k;
    }

    static Bitmap m(b b1)
    {
        return b1.p;
    }

    static Bitmap n(b b1)
    {
        b1.p = null;
        return null;
    }

    static ThreadPoolExecutor o(b b1)
    {
        return b1.n;
    }

    static boolean p(b b1)
    {
        b1.e = false;
        return false;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (j != null)
        {
            j.setImage(i());
        }
    }

    public final void d()
    {
        super.d();
        AnalyticUtils analyticutils = AnalyticUtils.getInstance(getActivity());
        String s = c;
        int i1 = q + 1;
        q = i1;
        analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.ToolAdjustCloseEvent(s, "back", i1, p.getHeight(), p.getWidth()));
    }

    public final Tool e()
    {
        return Tool.ADJUST;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Activity activity = getActivity();
        if ((activity instanceof EditorActivity) && com.picsart.studio.editor.e.a().e != null)
        {
            c = com.picsart.studio.editor.e.a().e.a;
        }
        f = myobfuscated.f.m.b(activity, (new StringBuilder("effects/")).append("adjust_effect.json").toString());
        if (bundle != null)
        {
            float af[] = bundle.getFloatArray("paramValues");
            q = bundle.getInt("actionCount");
            for (int i1 = 0; i1 < af.length; i1++)
            {
                f.b(i1).c = Float.valueOf(af[i1]);
            }

        }
        i = new c(f);
        Log.e("ex1", "START TEXTURE MAXSIZE");
        bundle = new com.socialin.android.util.a(getActivity());
        int k1 = bundle.a();
        int j1 = k1;
        if (k1 == 0)
        {
            Log.e("ex1", "textureMaxSize == 0");
            j1 = myobfuscated.f.m.a();
            if (j1 > 0)
            {
                bundle.a(j1);
            }
            Log.e("ex1", (new StringBuilder("textureMaxSize = ")).append(j1).toString());
        }
        o = j1;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030100, viewgroup, false);
    }

    public final void onDestroy()
    {
        super.onDestroy();
        (new ModernAsyncTask() {

            private b a;

            protected final Object doInBackground(Object aobj[])
            {
                return null;
            }

            protected final void onPostExecute(Object obj)
            {
                if (b.g(a) != null)
                {
                    obj = b.g(a);
                    if (((GPUImageView) (obj)).b != null)
                    {
                        ((GPUImageView) (obj)).b.b.b();
                    }
                }
                if (b.f(a) != null)
                {
                    obj = b.f(a);
                    if (((myobfuscated.aw.e) (obj)).d != null)
                    {
                        ImageOpCommon.freeNativeBuffer(((myobfuscated.aw.e) (obj)).d);
                        obj.d = null;
                    }
                    if (((myobfuscated.aw.e) (obj)).e != null)
                    {
                        ImageOpCommon.freeNativeBuffer(((myobfuscated.aw.e) (obj)).e);
                        obj.e = null;
                    }
                    if (((myobfuscated.aw.e) (obj)).f != null)
                    {
                        ImageOpCommon.freeNativeBuffer(((myobfuscated.aw.e) (obj)).f);
                        obj.f = null;
                    }
                }
                if (com.picsart.studio.editor.fragment.b.m(a) != a.h)
                {
                    com.socialin.android.util.c.a(com.picsart.studio.editor.fragment.b.m(a));
                    b.n(a);
                }
            }

            
            {
                a = b.this;
                super();
            }
        }).executeOnExecutor(n, new Object[] {
            null
        });
    }

    public final void onDetach()
    {
        super.onDetach();
        if (j != null && j.getParent() != null)
        {
            Log.e("ex1", "onDetach gpuImageView.getParent() != null");
            ((FrameLayout)j.getParent()).removeView(j);
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        float af[] = new float[f.c.size()];
        for (int i1 = 0; i1 < af.length; i1++)
        {
            af[i1] = ((Float)f.b(i1).c).floatValue();
        }

        bundle.putFloatArray("paramValues", af);
        bundle.putInt("actionCount", q);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        bundle = getActivity();
        if (j == null)
        {
            j = new GPUImageView(bundle);
            if (i == null)
            {
                i = new c(f);
            }
            j.setFilter(i);
            j.b.b.h = this;
        }
        if (j.getParent() != null)
        {
            ((FrameLayout)j.getParent()).removeView(j);
        }
        ((FrameLayout)view.findViewById(0x7f10053f)).addView(j);
        bundle = i();
        if (bundle != null)
        {
            Log.e("ex1", "bitmap != null");
            ((EditorActivity)getActivity()).d();
            j.setImage(bundle);
            j.b.a(new Runnable() {

                final b a;

                public final void run()
                {
                    Activity activity = a.getActivity();
                    if (activity != null && !activity.isFinishing())
                    {
                        activity.runOnUiThread(new Runnable(this) {

                            private _cls1 a;

                            public final void run()
                            {
                                if (a.a.getView() != null)
                                {
                                    Activity activity = a.a.getActivity();
                                    if (activity != null)
                                    {
                                        ((EditorActivity)activity).e();
                                    }
                                }
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }
                }

            
            {
                a = b.this;
                super();
            }
            });
        } else
        {
            Log.e("ex1", "bitmap == null");
        }
        view.findViewById(0x7f1001a8).setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view1)
            {
                if (com.picsart.studio.editor.fragment.b.a(a) != null)
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolAdjustTryEvent(b.b(a), (new StringBuilder()).append(com.picsart.studio.editor.fragment.b.c(a)).append("_reset").toString(), com.picsart.studio.editor.fragment.b.d(a), a.h.getHeight(), a.h.getWidth()));
                    int i1 = com.picsart.studio.editor.fragment.b.e(a);
                    if (i1 != -1)
                    {
                        ((EffectParameter)com.picsart.studio.editor.fragment.b.a(a).c.get(i1)).e();
                        b.f(a).a(i1);
                    }
                    if (b.g(a) != null)
                    {
                        b.g(a).a.requestRender();
                    }
                    b.h(a);
                }
            }

            
            {
                a = b.this;
                super();
            }
        });
        view.findViewById(0x7f10037f).setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view1)
            {
                if (!b.i(a) && !b.j(a))
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolAdjustCloseEvent(b.b(a), "cancel", com.picsart.studio.editor.fragment.b.d(a), a.h.getHeight(), a.h.getWidth()));
                    a.g.a(a);
                }
            }

            
            {
                a = b.this;
                super();
            }
        });
        view.findViewById(0x7f100540).setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view1)
            {
                if (!b.i(a) && !b.j(a))
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolAdjustCloseEvent(b.b(a), "done", com.picsart.studio.editor.fragment.b.d(a), a.h.getHeight(), a.h.getWidth()));
                    b.k(a);
                }
            }

            
            {
                a = b.this;
                super();
            }
        });
        l = (TextView)view.findViewById(0x7f100541);
        k = (TwoDirectionSeekbar)view.findViewById(0x7f100542);
        k.setValueInterval(0.0F, 100F);
        k.setOnValueChangedListener(new com.picsart.studio.view.c() {

            private b a;

            public final void a(FloatSeekBar floatseekbar)
            {
                super.a(floatseekbar);
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolAdjustTryEvent(b.b(a), com.picsart.studio.editor.fragment.b.c(a), com.picsart.studio.editor.fragment.b.d(a), a.h.getHeight(), a.h.getWidth()));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag)
            {
                int i1 = com.picsart.studio.editor.fragment.b.e(a);
                if (!flag || i1 == -1) goto _L2; else goto _L1
_L1:
                float f2;
                float f3;
                float f4;
                float f5;
                floatseekbar = com.picsart.studio.editor.fragment.b.a(a).b(i1);
                f2 = ((Float)((EffectParameter) (floatseekbar)).f).floatValue();
                f3 = ((Float)((EffectParameter) (floatseekbar)).f).floatValue();
                f4 = ((Float)((EffectParameter) (floatseekbar)).e).floatValue();
                f5 = ((Float)((EffectParameter) (floatseekbar)).d).floatValue();
                if (f1 >= 50F) goto _L4; else goto _L3
_L3:
                f2 = f5 + ((f3 - f5) * f1) / 50F;
_L6:
                floatseekbar.c = Float.valueOf(f2);
                Log.e("ex1", (new StringBuilder("value = ")).append(f2).toString());
                b.f(a).a(i1);
                b.g(a).a.requestRender();
                com.picsart.studio.editor.fragment.b.a(a, (int)f1);
_L2:
                return;
_L4:
                if (f1 > 50F)
                {
                    f2 = ((f1 - 50F) * (f4 - f3)) / 50F + f3;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                a = b.this;
                super();
            }
        });
        m = (RadioGroup)view.findViewById(0x7f100544);
        m.setOnCheckedChangeListener(new com.socialin.android.photo.draw.dialog.c() {

            private b a;

            public final void onCheckedChanged(RadioGroup radiogroup, int i1)
            {
                b.h(a);
            }

            
            {
                a = b.this;
                super();
            }
        });
        view = view.findViewById(0x7f10054d);
        if (view != null)
        {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(view) {

                private View a;
                private b b;

                public final void onGlobalLayout()
                {
                    int i1 = a.getWidth();
                    int j1 = a.getHeight();
                    if (i1 > 0 && j1 > 0)
                    {
                        Utils.a(a, this);
                        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)b.l(b).getLayoutParams();
                        layoutparams.width = j1;
                        b.l(b).setLayoutParams(layoutparams);
                        b.l(b).setTranslationX((float)(i1 - b.l(b).getHeight()) / 2.0F);
                        b.l(b).setPivotX(j1);
                        b.l(b).setPivotY(0.0F);
                        b.l(b).setRotation(270F);
                    }
                }

            
            {
                b = b.this;
                a = view;
                super();
            }
            });
        }
        j();
    }
}
