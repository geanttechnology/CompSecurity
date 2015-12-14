// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.renderscript.RSInvalidStateException;
import android.renderscript.RenderScript;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.photo.effect.Effect;
import com.photo.effects.utils.RenderScriptUnsupportDevice;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.TiltShiftEditorView;
import com.picsart.studio.view.FloatSeekBar;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.effects.factory.EffectsFactory;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import myobfuscated.cj.a;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i, w

public final class TiltShiftFragment extends i
{

    public static String c = "";
    private boolean A;
    private boolean B;
    private com.picsart.studio.editor.fragment.w C;
    private TiltShiftEditorView d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap i;
    private Bitmap j;
    private TiltShiftMode k;
    private ImageButton l;
    private ImageButton m;
    private TextView n;
    private FloatSeekBar o;
    private int p;
    private ProgressBar q;
    private boolean r;
    private ModernAsyncTask s;
    private Object t;
    private Effect u;
    private ThreadPoolExecutor v;
    private List w;
    private ModernAsyncTask x;
    private View y;
    private boolean z;

    public TiltShiftFragment()
    {
        k = TiltShiftMode.LINEAR;
        p = 15;
        w = new LinkedList();
        z = false;
        A = false;
        B = false;
        C = new com.picsart.studio.editor.fragment.w() {

            private TiltShiftFragment a;

            public final void a(Bitmap bitmap)
            {
                if (com.picsart.studio.editor.fragment.TiltShiftFragment.a(a) != 0 || bitmap == TiltShiftFragment.b(a) || bitmap == com.picsart.studio.editor.fragment.TiltShiftFragment.c(a))
                {
                    TiltShiftFragment.d(a).setBlurredImage(bitmap);
                    TiltShiftFragment.d(a).invalidate();
                }
                if (com.picsart.studio.editor.fragment.TiltShiftFragment.e(a))
                {
                    TiltShiftFragment.f(a);
                }
            }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
        };
    }

    static int a(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.p;
    }

    private void a(int i1, Bitmap bitmap, Bitmap bitmap1, com.picsart.studio.editor.fragment.w w1)
    {
        if (i1 > 0 && bitmap != null && !bitmap.isRecycled() && bitmap1 != null && !bitmap1.isRecycled())
        {
            Activity activity = getActivity();
            i1 = (i1 * 3) / 4;
            if (u != null)
            {
                x = new ModernAsyncTask(i1, activity, w1) {

                    private int a;
                    private Context b;
                    private com.picsart.studio.editor.fragment.w c;
                    private TiltShiftFragment d;

                    private transient Bitmap a(Bitmap abitmap[])
                    {
                        Bitmap bitmap2;
                        Bitmap bitmap3;
                        bitmap2 = abitmap[0];
                        bitmap3 = abitmap[1];
                        TiltShiftFragment.q(d).a("Blur", a);
                        if (TiltShiftFragment.r(d) == null || !TiltShiftFragment.q(d).d()) goto _L2; else goto _L1
_L1:
                        boolean flag = TiltShiftFragment.q(d).a(b, TiltShiftFragment.r(d), bitmap2, bitmap3);
_L3:
                        if (!isCancelled() && !flag && TiltShiftFragment.q(d).e())
                        {
                            int j1 = bitmap2.getWidth();
                            int k1 = bitmap2.getHeight();
                            abitmap = myobfuscated.cj.a.a().a(j1 * k1 * 4);
                            ByteBuffer bytebuffer = myobfuscated.cj.a.a().a(j1 * k1 * 4);
                            abitmap.rewind();
                            bitmap2.copyPixelsToBuffer(abitmap);
                            flag = TiltShiftFragment.q(d).a(b, abitmap, bytebuffer, j1, k1, false, -1);
                            if (!isCancelled() && flag)
                            {
                                bytebuffer.rewind();
                                bitmap3.copyPixelsFromBuffer(bytebuffer);
                            }
                            myobfuscated.cj.a.a().a(abitmap);
                            myobfuscated.cj.a.a().a(bytebuffer);
                        }
                        return bitmap3;
                        abitmap;
_L4:
                        abitmap.printStackTrace();
_L2:
                        flag = false;
                          goto _L3
                        abitmap;
                          goto _L4
                    }

                    protected final Object doInBackground(Object aobj[])
                    {
                        return a((Bitmap[])aobj);
                    }

                    protected final void onCancelled(Object obj)
                    {
                        TiltShiftFragment.t(d).remove(this);
                        if (com.picsart.studio.editor.fragment.TiltShiftFragment.e(d) && TiltShiftFragment.t(d).size() == 0)
                        {
                            TiltShiftFragment.o(d);
                        }
                    }

                    protected final void onPostExecute(Object obj)
                    {
                        obj = (Bitmap)obj;
                        TiltShiftFragment.s(d);
                        TiltShiftFragment.t(d).remove(this);
                        if (!com.picsart.studio.editor.fragment.TiltShiftFragment.e(d))
                        {
                            TiltShiftFragment.u(d).setVisibility(8);
                        }
                        c.a(((Bitmap) (obj)));
                    }

            
            {
                d = TiltShiftFragment.this;
                a = i1;
                b = context;
                c = w1;
                super();
            }
                };
                for (i1 = 1; i1 < w.size(); i1++)
                {
                    ((ModernAsyncTask)w.get(i1)).cancel(false);
                }

                if (w1.equals(C))
                {
                    w.add(x);
                }
                x.executeOnExecutor(v, new Bitmap[] {
                    bitmap, bitmap1
                });
            }
            return;
        }
        for (i1 = 0; i1 < w.size(); i1++)
        {
            ((ModernAsyncTask)w.get(i1)).cancel(false);
        }

        B = true;
        if (!r)
        {
            q.setVisibility(8);
        }
        w1.a(bitmap);
    }

    static void a(TiltShiftFragment tiltshiftfragment, int i1)
    {
        tiltshiftfragment.p = i1;
        tiltshiftfragment.n.setText(String.valueOf(i1));
        tiltshiftfragment.a(tiltshiftfragment.p, tiltshiftfragment.f, tiltshiftfragment.k(), tiltshiftfragment.C);
    }

    static void a(TiltShiftFragment tiltshiftfragment, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        int i1 = tiltshiftfragment.y.getWidth();
        int j1 = tiltshiftfragment.y.getHeight();
        if (i1 > 0 && j1 > 0)
        {
            Utils.a(tiltshiftfragment.y, ongloballayoutlistener);
            ongloballayoutlistener = (android.widget.LinearLayout.LayoutParams)tiltshiftfragment.o.getLayoutParams();
            ongloballayoutlistener.width = tiltshiftfragment.o.getHeight() + j1;
            tiltshiftfragment.o.setLayoutParams(ongloballayoutlistener);
            tiltshiftfragment.o.setTranslationY(j1 / 2);
            tiltshiftfragment.o.setPivotX((j1 + tiltshiftfragment.o.getHeight()) / 2);
            tiltshiftfragment.o.setPivotY(tiltshiftfragment.o.getHeight() / 2);
            tiltshiftfragment.o.setRotation(-90F);
        }
    }

    static void a(TiltShiftFragment tiltshiftfragment, TiltShiftMode tiltshiftmode)
    {
        tiltshiftfragment.k = tiltshiftmode;
        tiltshiftfragment.d.setMode(tiltshiftfragment.k);
        tiltshiftfragment.d.setShowHandlers(true);
    }

    static Bitmap b(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.e;
    }

    static void b(Bitmap bitmap)
    {
        c(bitmap);
    }

    static Bitmap c(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.f;
    }

    private static void c(Bitmap bitmap)
    {
        if (bitmap != null && !bitmap.isRecycled())
        {
            bitmap.recycle();
        }
    }

    static TiltShiftEditorView d(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.d;
    }

    static boolean e(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.r;
    }

    static void f(TiltShiftFragment tiltshiftfragment)
    {
        tiltshiftfragment.r = true;
        tiltshiftfragment.q.setVisibility(0);
        tiltshiftfragment.a(tiltshiftfragment.p, tiltshiftfragment.e, tiltshiftfragment.l(), tiltshiftfragment. new com.picsart.studio.editor.fragment.w() {

            private TiltShiftFragment a;

            public final void a(Bitmap bitmap)
            {
                TiltShiftFragment.d(a).setBlurredImage(bitmap);
                if (a.getActivity() == null || a.getActivity().isFinishing())
                {
                    TiltShiftFragment.o(a);
                    return;
                } else
                {
                    TiltShiftFragment.v(a);
                    return;
                }
            }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
        });
    }

    static boolean g(TiltShiftFragment tiltshiftfragment)
    {
        tiltshiftfragment.z = true;
        return true;
    }

    static boolean h(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.A;
    }

    private void i()
    {
        if (f != e)
        {
            c(f);
        }
        c(i);
        c(j);
        if (d != null)
        {
            TiltShiftEditorView tiltshifteditorview = d;
            if (tiltshifteditorview.i != null && !tiltshifteditorview.i.isRecycled())
            {
                tiltshifteditorview.i.recycle();
            }
        }
    }

    static boolean i(TiltShiftFragment tiltshiftfragment)
    {
        tiltshiftfragment.A = true;
        return true;
    }

    private Bitmap j()
    {
        if (e != null && !e.isRecycled() && (f == null || f.isRecycled()))
        {
            f = com.socialin.android.util.w.f(e, 1024);
        }
        return f;
    }

    static boolean j(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.z;
    }

    private Bitmap k()
    {
        if (f != null && !f.isRecycled())
        {
            if (i == null || i.isRecycled())
            {
                i = Bitmap.createBitmap(f.getWidth(), f.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            }
            return i;
        } else
        {
            return l();
        }
    }

    static FloatSeekBar k(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.o;
    }

    private Bitmap l()
    {
        if (e != null && !e.isRecycled() && (j == null || j.isRecycled()))
        {
            j = Bitmap.createBitmap(e.getWidth(), e.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        }
        return j;
    }

    static ImageButton l(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.l;
    }

    static ImageButton m(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.m;
    }

    static TiltShiftMode n(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.k;
    }

    static void o(TiltShiftFragment tiltshiftfragment)
    {
        tiltshiftfragment.i();
    }

    static boolean p(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.B;
    }

    static Effect q(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.u;
    }

    static Object r(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.t;
    }

    static boolean s(TiltShiftFragment tiltshiftfragment)
    {
        tiltshiftfragment.B = true;
        return true;
    }

    static List t(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.w;
    }

    static ProgressBar u(TiltShiftFragment tiltshiftfragment)
    {
        return tiltshiftfragment.q;
    }

    static void v(TiltShiftFragment tiltshiftfragment)
    {
        tiltshiftfragment.s = (tiltshiftfragment. new ModernAsyncTask() {

            private TiltShiftFragment a;

            protected final Object doInBackground(Object aobj[])
            {
                if (TiltShiftFragment.d(a) == null)
                {
                    return null;
                } else
                {
                    return TiltShiftFragment.d(a).a(TiltShiftFragment.b(a));
                }
            }

            protected final void onCancelled(Object obj)
            {
                obj = (Bitmap)obj;
                TiltShiftFragment.o(a);
                if (obj != null && !((Bitmap) (obj)).isRecycled())
                {
                    TiltShiftFragment.b(((Bitmap) (obj)));
                }
            }

            protected final void onPostExecute(Object obj)
            {
label0:
                {
                    obj = (Bitmap)obj;
                    if (obj != null)
                    {
                        TiltShiftFragment.o(a);
                        if (a.getActivity() == null || a.getActivity().isFinishing() || !a.isAdded())
                        {
                            break label0;
                        }
                        com.picsart.studio.editor.e.a().e.d(Tool.TILT_SHIFT.toString().toLowerCase());
                        if (TiltShiftFragment.b(a) != null)
                        {
                            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.TiltShiftCloseEvent(com.picsart.studio.editor.fragment.TiltShiftFragment.c, "done", TiltShiftFragment.n(a).name().toLowerCase(), String.valueOf(TiltShiftFragment.k(a).a()), TiltShiftFragment.d(a).l, TiltShiftFragment.b(a).getHeight(), TiltShiftFragment.b(a).getWidth(), TiltShiftFragment.d(a).j));
                        }
                        a.g.a(a, ((Bitmap) (obj)), RasterAction.create(((Bitmap) (obj)), com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
                    }
                    return;
                }
                TiltShiftFragment.b(((Bitmap) (obj)));
            }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
        }).execute(new Void[0]);
    }

    public final void a(Bitmap bitmap)
    {
        e = bitmap;
        f = j();
        if (d != null)
        {
            d.setImage(f);
            a(p, f, k(), C);
        }
    }

    public final void d()
    {
        super.d();
        if (e != null)
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.TiltShiftCloseEvent(c, "back", k.name().toLowerCase(), String.valueOf(o.a()), d.l, e.getHeight(), e.getWidth(), d.j));
        }
    }

    public final Tool e()
    {
        return Tool.TILT_SHIFT;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof EditorActivity)
        {
            c = com.picsart.studio.editor.e.a().e.a;
        }
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (RenderScriptUnsupportDevice.setupAndGetRenderScriptSupport(activity) && t == null)
        {
            t = RenderScript.create(activity);
        }
        u = EffectsFactory.getEffectFromAssets(activity, "effects/effects_infos/effect_blur.json");
        v = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            k = TiltShiftMode.valueOf(bundle.getString("savedMode"));
            p = bundle.getInt("blurValue");
            r = bundle.getBoolean("saveBusy");
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03011f, viewgroup, false);
    }

    public final void onDetach()
    {
        super.onDetach();
        if (t != null)
        {
            ((RenderScript)t).destroy();
            t = null;
        }
        if (x != null)
        {
            x.cancel(true);
        }
        if (s != null)
        {
            s.cancel(true);
        }
        if (!r && w.size() == 0)
        {
            i();
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("savedMode", k.name());
        bundle.putInt("blurValue", p);
        bundle.putBoolean("saveBusy", r);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        boolean flag1 = true;
        super.onViewCreated(view, bundle);
        d = (TiltShiftEditorView)view.findViewById(0x7f10062a);
        d.setLayerType(1, null);
        d.setImage(j());
        q = (ProgressBar)view.findViewById(0x7f100188);
        if (r || !B)
        {
            q.setVisibility(0);
        }
        n = (TextView)view.findViewById(0x7f100613);
        n.setText(String.valueOf(p));
        o = (FloatSeekBar)view.findViewById(0x7f100439);
        o.setValueInterval(0.0F, 100F);
        o.setValue(p);
        o.setOnValueChangedListener(new com.picsart.studio.view.c() {

            private TiltShiftFragment a;

            public final void a(FloatSeekBar floatseekbar)
            {
                AnalyticUtils analyticutils = AnalyticUtils.getInstance(a.getActivity());
                String s1 = com.picsart.studio.editor.fragment.TiltShiftFragment.c;
                TiltShiftEditorView tiltshifteditorview = TiltShiftFragment.d(a);
                int i1 = tiltshifteditorview.l + 1;
                tiltshifteditorview.l = i1;
                analyticutils.track((new com.socialin.android.apiv3.events.EventsFactory.TiltShiftTryEvent(s1, "blur_slider_change", i1, TiltShiftFragment.b(a).getHeight(), TiltShiftFragment.b(a).getWidth(), TiltShiftFragment.d(a).k)).setBlurSliderValue((int)floatseekbar.a()));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag2)
            {
                if (flag2)
                {
                    com.picsart.studio.editor.fragment.TiltShiftFragment.a(a, (int)f1);
                }
            }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
        });
        y = view.findViewById(0x7f10054d);
        if (y != null)
        {
            y.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                private TiltShiftFragment a;

                public final void onGlobalLayout()
                {
                    TiltShiftFragment.g(a);
                    if (TiltShiftFragment.h(a))
                    {
                        com.picsart.studio.editor.fragment.TiltShiftFragment.a(a, this);
                    }
                }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
            });
            o.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                private TiltShiftFragment a;

                public final void onGlobalLayout()
                {
                    TiltShiftFragment.i(a);
                    if (TiltShiftFragment.j(a))
                    {
                        com.picsart.studio.editor.fragment.TiltShiftFragment.a(a, this);
                    }
                }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
            });
        }
        a(p, f, k(), C);
        view.findViewById(0x7f10062b).setOnClickListener(new android.view.View.OnClickListener() {

            private TiltShiftFragment a;

            public final void onClick(View view1)
            {
                view1 = AnalyticUtils.getInstance(a.getActivity());
                String s1 = com.picsart.studio.editor.fragment.TiltShiftFragment.c;
                TiltShiftEditorView tiltshifteditorview = TiltShiftFragment.d(a);
                int i1 = tiltshifteditorview.l + 1;
                tiltshifteditorview.l = i1;
                view1.track((new com.socialin.android.apiv3.events.EventsFactory.TiltShiftTryEvent(s1, "inverse_click", i1, TiltShiftFragment.b(a).getHeight(), TiltShiftFragment.b(a).getWidth(), TiltShiftFragment.d(a).k)).setBlurSliderValue((int)TiltShiftFragment.k(a).a()));
                view1 = TiltShiftFragment.d(a);
                boolean flag2;
                if (!TiltShiftFragment.d(a).j)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                view1.setInverted(flag2);
            }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
        });
        l = (ImageButton)view.findViewById(0x7f10062c);
        l.setOnClickListener(new android.view.View.OnClickListener() {

            private TiltShiftFragment a;

            public final void onClick(View view1)
            {
                view1 = AnalyticUtils.getInstance(a.getActivity());
                String s1 = com.picsart.studio.editor.fragment.TiltShiftFragment.c;
                TiltShiftEditorView tiltshifteditorview = TiltShiftFragment.d(a);
                int i1 = tiltshifteditorview.l + 1;
                tiltshifteditorview.l = i1;
                view1.track((new com.socialin.android.apiv3.events.EventsFactory.TiltShiftTryEvent(s1, "linear_tab_click", i1, TiltShiftFragment.b(a).getHeight(), TiltShiftFragment.b(a).getWidth(), TiltShiftFragment.d(a).k)).setBlurSliderValue((int)TiltShiftFragment.k(a).a()));
                TiltShiftFragment.l(a).setSelected(true);
                TiltShiftFragment.m(a).setSelected(false);
                com.picsart.studio.editor.fragment.TiltShiftFragment.a(a, TiltShiftMode.LINEAR);
            }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
        });
        m = (ImageButton)view.findViewById(0x7f10062d);
        m.setOnClickListener(new android.view.View.OnClickListener() {

            private TiltShiftFragment a;

            public final void onClick(View view1)
            {
                view1 = AnalyticUtils.getInstance(a.getActivity());
                String s1 = com.picsart.studio.editor.fragment.TiltShiftFragment.c;
                TiltShiftEditorView tiltshifteditorview = TiltShiftFragment.d(a);
                int i1 = tiltshifteditorview.l + 1;
                tiltshifteditorview.l = i1;
                view1.track((new com.socialin.android.apiv3.events.EventsFactory.TiltShiftTryEvent(s1, "radial_tab_click", i1, TiltShiftFragment.b(a).getHeight(), TiltShiftFragment.b(a).getWidth(), TiltShiftFragment.d(a).k)).setBlurSliderValue((int)TiltShiftFragment.k(a).a()));
                TiltShiftFragment.l(a).setSelected(false);
                TiltShiftFragment.m(a).setSelected(true);
                com.picsart.studio.editor.fragment.TiltShiftFragment.a(a, TiltShiftMode.RADIAL);
            }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
        });
        bundle = l;
        boolean flag;
        if (k == TiltShiftMode.LINEAR)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.setSelected(flag);
        bundle = m;
        if (k == TiltShiftMode.RADIAL)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        bundle.setSelected(flag);
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private TiltShiftFragment a;

            public final void onClick(View view1)
            {
                if (TiltShiftFragment.b(a) != null)
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.TiltShiftCloseEvent(com.picsart.studio.editor.fragment.TiltShiftFragment.c, "cancel", TiltShiftFragment.n(a).name().toLowerCase(), String.valueOf(TiltShiftFragment.k(a).a()), TiltShiftFragment.d(a).l, TiltShiftFragment.b(a).getHeight(), TiltShiftFragment.b(a).getWidth(), TiltShiftFragment.d(a).j));
                }
                TiltShiftFragment.o(a);
                if (a.g != null)
                {
                    a.g.a(a);
                }
            }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private TiltShiftFragment a;

            public final void onClick(View view1)
            {
                if (!com.picsart.studio.editor.fragment.TiltShiftFragment.e(a) && TiltShiftFragment.p(a))
                {
                    TiltShiftFragment.f(a);
                }
            }

            
            {
                a = TiltShiftFragment.this;
                super();
            }
        });
    }


    private class TiltShiftMode extends Enum
    {

        private static final TiltShiftMode $VALUES[];
        public static final TiltShiftMode LINEAR;
        public static final TiltShiftMode RADIAL;

        public static TiltShiftMode valueOf(String s1)
        {
            return (TiltShiftMode)Enum.valueOf(com/picsart/studio/editor/fragment/TiltShiftFragment$TiltShiftMode, s1);
        }

        public static TiltShiftMode[] values()
        {
            return (TiltShiftMode[])$VALUES.clone();
        }

        static 
        {
            LINEAR = new TiltShiftMode("LINEAR", 0);
            RADIAL = new TiltShiftMode("RADIAL", 1);
            $VALUES = (new TiltShiftMode[] {
                LINEAR, RADIAL
            });
        }

        private TiltShiftMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
