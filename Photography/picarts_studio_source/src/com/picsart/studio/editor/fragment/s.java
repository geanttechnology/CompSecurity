// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.load.engine.GlideException;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.EffectsDrawHistoryController;
import com.picsart.effectnew.MaskBrushNew;
import com.picsart.effectnew.a;
import com.picsart.effectnew.d;
import com.picsart.effectnew.e;
import com.picsart.effectnew.f;
import com.picsart.effectnew.o;
import com.picsart.effectnew.q;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.custommasks.Mask;
import com.picsart.studio.editor.custommasks.MaskStateHolder;
import com.picsart.studio.editor.custommasks.MaskView;
import com.picsart.studio.editor.custommasks.g;
import com.picsart.studio.editor.custommasks.i;
import com.picsart.studio.editor.custommasks.l;
import com.picsart.studio.editor.custommasks.m;
import com.picsart.studio.editor.custommasks.n;
import com.picsart.studio.editor.custommasks.p;
import com.socialin.android.dialog.b;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.af;
import com.socialin.android.util.ag;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class s extends com.picsart.studio.editor.fragment.i
    implements android.widget.SeekBar.OnSeekBarChangeListener, d, o, q
{

    private final ThreadPoolExecutor c = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
    private final Object d = new Object();
    private volatile boolean e;
    private volatile boolean f;
    private volatile boolean i;
    private Context j;
    private Bitmap k;
    private Bitmap l;
    private Bitmap m;
    private e n;
    private com.picsart.studio.editor.custommasks.d o;
    private final p p = new p(this);
    private i q;
    private a r;
    private MaskView s;
    private RelativeLayout t;
    private RelativeLayout u;
    private RelativeLayout v;
    private final android.view.View.OnClickListener w = new android.view.View.OnClickListener() {

        private s a;

        private void a(boolean flag)
        {
            CompoundButton compoundbutton = (CompoundButton)com.picsart.studio.editor.fragment.s.a(a).findViewById(0x7f10018d);
            CompoundButton compoundbutton1 = (CompoundButton)com.picsart.studio.editor.fragment.s.a(a).findViewById(0x7f10018e);
            if (compoundbutton != null && compoundbutton1 != null)
            {
                boolean flag1;
                if (!flag)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                compoundbutton.setChecked(flag1);
                compoundbutton1.setChecked(flag);
            }
        }

        public final void onClick(View view)
        {
            int i1 = view.getId();
            if (i1 == 0x7f10018b)
            {
                com.picsart.studio.editor.fragment.s.b(a);
            } else
            {
                if (i1 == 0x7f100136)
                {
                    com.picsart.studio.editor.fragment.s.c(a);
                    return;
                }
                if (i1 == 0x7f10018c)
                {
                    com.picsart.studio.editor.fragment.s.d(a);
                    return;
                }
                if (i1 == 0x7f10018e)
                {
                    a(true);
                    com.picsart.studio.editor.fragment.s.a(a, com.picsart.effectnew.MaskBrushNew.BrushDrawMode.ERASE);
                    return;
                }
                if (i1 == 0x7f10018d)
                {
                    a(false);
                    com.picsart.studio.editor.fragment.s.a(a, com.picsart.effectnew.MaskBrushNew.BrushDrawMode.DRAW);
                    return;
                }
            }
        }

            
            {
                a = s.this;
                super();
            }
    };
    private MaskStateHolder x;
    private final android.view.View.OnClickListener y = new android.view.View.OnClickListener() {

        private s a;

        public final void onClick(View view)
        {
            Mask mask;
            int i1;
            mask = com.picsart.studio.editor.fragment.s.e(a).c;
            if (!mask.a())
            {
                return;
            }
            i1 = view.getId();
            if (i1 != 0x7f1006fd) goto _L2; else goto _L1
_L1:
            mask.a(true, false);
            com.picsart.studio.editor.fragment.s.f(a).h = true;
            com.picsart.studio.editor.fragment.s.f(a).i = false;
_L4:
            ((EditorActivity)a.getActivity()).d();
            com.picsart.studio.editor.fragment.s.a(a, a.getActivity(), mask);
            ((EditorActivity)a.getActivity()).e();
            return;
_L2:
            if (i1 == 0x7f1006fe)
            {
                mask.a(false, true);
                com.picsart.studio.editor.fragment.s.f(a).h = false;
                com.picsart.studio.editor.fragment.s.f(a).i = true;
            } else
            if (i1 == 0x7f100700)
            {
                mask.a(90F);
                view = com.picsart.studio.editor.fragment.s.f(a);
                view.g = ((MaskStateHolder) (view)).g + 90F;
                if (com.picsart.studio.editor.fragment.s.f(a).g > 360F)
                {
                    view = com.picsart.studio.editor.fragment.s.f(a);
                    view.g = ((MaskStateHolder) (view)).g - 360F;
                }
            } else
            {
                mask.a(-90F);
                view = com.picsart.studio.editor.fragment.s.f(a);
                view.g = ((MaskStateHolder) (view)).g - 90F;
                if (com.picsart.studio.editor.fragment.s.f(a).g < -360F)
                {
                    view = com.picsart.studio.editor.fragment.s.f(a);
                    view.g = ((MaskStateHolder) (view)).g + 360F;
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                a = s.this;
                super();
            }
    };

    public s()
    {
        m = null;
        f = false;
        i = false;
    }

    public static Bitmap a(s s1, View view, boolean flag, int i1)
    {
        int j1 = (int)TypedValue.applyDimension(1, 170F, s1.getResources().getDisplayMetrics());
        if (!flag)
        {
            int k1 = ((RecyclerView)view.getParent()).getChildAdapterPosition(view);
            view = s1.o.a(k1);
        } else
        {
            view = s1.o.c;
        }
        if (view == null)
        {
            return null;
        }
        Bitmap bitmap = view.a(s1.getActivity());
        s1 = com.socialin.android.util.w.b(s1.k, j1, j1);
        Bitmap bitmap1 = com.socialin.android.util.w.b(bitmap, j1, j1);
        com.socialin.android.util.c.a(bitmap);
        bitmap = com.socialin.android.util.c.a(j1, j1, s1.getConfig());
        if (!flag)
        {
            Mask.a(s1, bitmap1, view.a(true), new Canvas(bitmap));
        } else
        {
            Mask.a(s1, bitmap1, (com.picsart.studio.editor.custommasks.Mask.BlendMode)Arrays.asList(com.picsart.studio.editor.custommasks.Mask.BlendMode.values()).get(i1), new Canvas(bitmap));
        }
        return bitmap;
    }

    static RelativeLayout a(s s1)
    {
        return s1.v;
    }

    private void a(Activity activity, Mask mask)
    {
        if (mask != null && l != null && !l.isRecycled() && isVisible())
        {
            i = true;
            l.eraseColor(0);
            mask.a(getActivity(), k, new Canvas(l));
            s.invalidate();
            if (isVisible())
            {
                if (e)
                {
                    n.c.a(c, false, false);
                    e = false;
                } else
                {
                    n.c.b(activity, c);
                }
                i = false;
                return;
            }
        }
    }

    static void a(s s1, Activity activity, Mask mask)
    {
        s1.a(activity, mask);
    }

    static void a(s s1, GlideException glideexception)
    {
        EditorActivity editoractivity;
        for (editoractivity = (EditorActivity)s1.getActivity(); !s1.isVisible() || s1.isRemoving() || editoractivity == null;)
        {
            return;
        }

        editoractivity.e();
        if (glideexception != null && glideexception.getCause() != null)
        {
            (new StringBuilder("failReason: ")).append(glideexception.getCause().toString());
        }
        com.socialin.android.picsart.profile.util.y.b(editoractivity);
    }

    static void a(s s1, com.picsart.effectnew.MaskBrushNew.BrushDrawMode brushdrawmode)
    {
        s1.n.b().a(brushdrawmode);
    }

    static void a(s s1, Mask mask)
    {
        ((SeekBar)s1.t.findViewById(0x7f100703)).setProgress(mask.i);
        ((SeekBar)s1.t.findViewById(0x7f100706)).setProgress(mask.j);
        ((TextView)s1.t.findViewById(0x7f100702)).setText((new StringBuilder(": ")).append(mask.i).toString());
        ((TextView)s1.t.findViewById(0x7f100705)).setText((new StringBuilder(": ")).append(mask.j).toString());
    }

    static void b(s s1)
    {
        s1.n.c.a(s1.getActivity(), s1.c);
    }

    static void c(s s1)
    {
        Object obj = s1.n.b();
        com.picsart.effectnew.b b1;
        if (obj == null)
        {
            b1 = null;
        } else
        {
            b1 = new com.picsart.effectnew.b();
            b1.a = ((MaskBrushNew) (obj)).a;
            b1.b = ((MaskBrushNew) (obj)).a();
            b1.c = 100F - ((MaskBrushNew) (obj)).c;
        }
        if (b1 != null)
        {
            obj = new com.picsart.effectnew.c();
            obj.a = s1.getString(0x7f0805fb);
            obj.f = 0x7f030047;
            obj.h = false;
            ((com.picsart.effectnew.c) (obj)).a(s1. new android.view.View.OnClickListener() {

                private s a;

                public final void onClick(View view)
                {
                    if (s.s(a) != null)
                    {
                        a.a(s.s(a).b);
                    }
                }

            
            {
                a = s.this;
                super();
            }
            });
            s1.r = ((com.picsart.effectnew.c) (obj)).a(b1, s1);
            s1.r.setRetainInstance(true);
            s1.r.show(s1.getFragmentManager(), "BRUSH_SETTINGS_DIALOG");
        }
    }

    static void d(s s1)
    {
        EffectsDrawController effectsdrawcontroller = s1.n.c;
        s1.getActivity();
        effectsdrawcontroller.a(s1.c, false, false);
    }

    public static com.picsart.studio.editor.custommasks.d e(s s1)
    {
        return s1.o;
    }

    public static MaskStateHolder f(s s1)
    {
        return s1.x;
    }

    static boolean g(s s1)
    {
        s1.e = true;
        return true;
    }

    static RelativeLayout h(s s1)
    {
        return s1.t;
    }

    static RelativeLayout i(s s1)
    {
        return s1.u;
    }

    private void i()
    {
        if (f && n != null)
        {
            return;
        }
        boolean flag;
        if (k == null || k.isRecycled())
        {
            int i1 = h.getWidth();
            int k1 = h.getHeight();
            int i2 = Math.max(i1, k1);
            Object obj = new Point();
            getActivity().getWindowManager().getDefaultDisplay().getSize(((Point) (obj)));
            i2 = Math.min(Math.max(((Point) (obj)).x, ((Point) (obj)).y), i2);
            if (i1 > i2 || k1 > i2)
            {
                obj = myobfuscated.ay.e.a(h.getWidth(), h.getHeight(), i2);
                int j1 = ((Point) (obj)).x;
                int l1 = ((Point) (obj)).y;
                if (m != null)
                {
                    m.recycle();
                }
                m = h;
                k = com.socialin.android.util.c.a(h, j1, l1, false);
            } else
            {
                k = h;
            }
            if (l != null)
            {
                l.recycle();
            }
            l = k.copy(k.getConfig(), true);
        }
        n = new e(j, k, l);
        obj = n;
        if (((e) (obj)).c != null && ((e) (obj)).c.j())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            n.k = new f();
            n.c.n.b = this;
            n.c.q = this;
            if (s != null)
            {
                s.setDrawController(n);
                s.setOrigBitmap(l);
            }
        } else
        {
            n = null;
            Toast.makeText(getActivity(), "Something went wrong", 0).show();
        }
        f = true;
        synchronized (d)
        {
            d.notifyAll();
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private int j()
    {
        return getResources().getConfiguration().orientation != 2 ? 0 : 1;
    }

    static Bitmap j(s s1)
    {
        return s1.k;
    }

    public static i k(s s1)
    {
        return s1.q;
    }

    static boolean l(s s1)
    {
        return s1.f;
    }

    static Object m(s s1)
    {
        return s1.d;
    }

    static void n(s s1)
    {
        Mask mask;
        if (s1.isAdded() && s1.getActivity() != null)
        {
            if ((mask = s1.o.a(s1.x.a)) != null)
            {
                mask.i = s1.x.d;
                mask.j = s1.x.e;
                if (s1.x.f != null)
                {
                    mask.a(s1.x.f, false);
                }
                mask.a(s1.getActivity(), s1.k.getWidth(), s1.k.getHeight(), s1. new com.picsart.studio.editor.custommasks.c(mask) {

                    private Mask a;
                    private s b;

                    public final void a(GlideException glideexception)
                    {
                        com.picsart.studio.editor.fragment.s.a(b, glideexception);
                    }

                    public final void a(Mask mask1)
                    {
                        int i1 = 0;
                        a.a(com.picsart.studio.editor.fragment.s.f(b).g);
                        a.a(com.picsart.studio.editor.fragment.s.f(b).h, com.picsart.studio.editor.fragment.s.f(b).i);
                        Spinner spinner = (Spinner)com.picsart.studio.editor.fragment.s.i(b).findViewById(0x7f100709);
                        SpinnerAdapter spinneradapter = spinner.getAdapter();
                        mask1 = mask1.a(false);
                        for (int j1 = spinneradapter.getCount(); i1 < j1 && spinneradapter.getItem(i1) != mask1; i1++) { }
                        spinner.setSelection(i1);
                        com.picsart.studio.editor.fragment.s.a(b, a);
                        com.picsart.studio.editor.fragment.s.e(b).a(a);
                    }

            
            {
                b = s.this;
                a = mask;
                super();
            }
                });
                return;
            }
        }
    }

    static Bitmap o(s s1)
    {
        return s1.m;
    }

    static Bitmap p(s s1)
    {
        return s1.l;
    }

    static e q(s s1)
    {
        return s1.n;
    }

    static e r(s s1)
    {
        s1.n = null;
        return null;
    }

    static a s(s s1)
    {
        return s1.r;
    }

    static boolean t(s s1)
    {
        return s1.i;
    }

    static Bitmap u(s s1)
    {
        if (s1.m == null)
        {
            return s1.k;
        } else
        {
            return s1.m;
        }
    }

    static ThreadPoolExecutor v(s s1)
    {
        return s1.c;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (isAdded())
        {
            i();
        }
    }

    public final void a(EffectsDrawHistoryController effectsdrawhistorycontroller, boolean flag)
    {
        ImageButton imagebutton = (ImageButton)v.findViewById(0x7f10018b);
        if (!effectsdrawhistorycontroller.e())
        {
            imagebutton.setEnabled(true);
            return;
        } else
        {
            imagebutton.setEnabled(false);
            return;
        }
    }

    public final void a(com.picsart.effectnew.b b1)
    {
        MaskBrushNew maskbrushnew = n.b();
        maskbrushnew.b(b1.b);
        maskbrushnew.a(b1.c);
        maskbrushnew.a(b1.a);
    }

    public final void a(boolean flag)
    {
        if (!isVisible())
        {
            return;
        }
        if (flag)
        {
            ((EditorActivity)getActivity()).d();
            return;
        } else
        {
            ((EditorActivity)getActivity()).e();
            return;
        }
    }

    public final Tool e()
    {
        return Tool.MASK;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        RecyclerView recyclerview;
        RecyclerView recyclerview1;
        super.onActivityCreated(bundle);
        setRetainInstance(true);
        recyclerview = (RecyclerView)getView().findViewById(0x7f1005c7);
        recyclerview1 = (RecyclerView)getView().findViewById(0x7f1005ca);
        if (o != null || q != null) goto _L2; else goto _L1
_L1:
        bundle = null;
        java.io.InputStream inputstream = getActivity().getAssets().open("mask.json");
        bundle = inputstream;
_L4:
        bundle = FileUtils.a(bundle);
        q = new i(myobfuscated.b.a.getMaskCategories(getActivity(), bundle));
        o = new com.picsart.studio.editor.custommasks.d(getActivity(), getActivity(), p);
        o.d = new g() {

            final s a;

            public final void a(Mask mask)
            {
                com.picsart.studio.editor.fragment.s.g(a);
                if (s.h(a).getVisibility() != 0)
                {
                    s.h(a).setVisibility(0);
                    ((SlidingDrawer)s.h(a).findViewById(0x7f10057c)).open();
                }
                Spinner spinner = (Spinner)com.picsart.studio.editor.fragment.s.i(a).findViewById(0x7f100709);
                spinner.setEnabled(true);
                SpinnerAdapter spinneradapter = spinner.getAdapter();
                com.picsart.studio.editor.custommasks.Mask.BlendMode blendmode = mask.a(false);
                int j1 = spinneradapter.getCount();
                int i1;
                for (i1 = 0; i1 < j1 && spinneradapter.getItem(i1) != blendmode; i1++) { }
                spinner.setSelection(i1);
                a.getView().findViewById(0x7f1006f9).setEnabled(true);
                com.picsart.studio.editor.fragment.s.a(a, mask);
                com.picsart.studio.editor.fragment.s.f(a).a = com.picsart.studio.editor.fragment.s.e(a).b.indexOf(mask);
                com.picsart.studio.editor.fragment.s.f(a).g = 0.0F;
                com.picsart.studio.editor.fragment.s.f(a).h = false;
                com.picsart.studio.editor.fragment.s.f(a).i = false;
                ((EditorActivity)a.getActivity()).d();
                (new AsyncTask(this, mask) {

                    final _cls12 a;
                    private Mask b;

                    protected final Object doInBackground(Object aobj[])
                    {
                        b.a(a.a.getActivity(), s.j(a.a).getWidth(), s.j(a.a).getHeight(), new com.picsart.studio.editor.custommasks.c(this) {

                            final _cls1 a;

                            public final void a(GlideException glideexception)
                            {
                                com.picsart.studio.editor.fragment.s.a(a.a.a, glideexception);
                            }

                            public final void a(Mask mask)
                            {
                                if (!a.a.a.isAdded() || a.a.a.getActivity() == null)
                                {
                                    return;
                                } else
                                {
                                    a.a.a.getActivity().runOnUiThread(new Runnable(this, mask) {

                                        private Mask a;
                                        private _cls1 b;

                                        public final void run()
                                        {
                                            com.picsart.studio.editor.fragment.s.a(b.a.a.a, b.a.a.a.getActivity(), a);
                                            ((EditorActivity)b.a.a.a.getActivity()).e();
                                        }

            
            {
                b = _pcls1;
                a = mask;
                super();
            }
                                    });
                                    return;
                                }
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        return null;
                    }

            
            {
                a = _pcls12;
                b = mask;
                super();
            }
                }).execute(new Void[0]);
            }

            
            {
                a = s.this;
                super();
            }
        };
        q.b = new l(this, recyclerview);
_L2:
        if (x.b >= 0)
        {
            q.a(x.b);
        }
        o.a(q.a);
        bundle = o;
        View view = getView();
        ((com.picsart.studio.editor.custommasks.d) (bundle)).a.a(view);
        recyclerview1.setAdapter(q);
        recyclerview.setAdapter(o);
        o.e = true;
        return;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        j = activity.getApplicationContext();
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (h != null)
        {
            i();
        }
        if (bundle != null)
        {
            x = (MaskStateHolder)bundle.getParcelable("mask_state");
            return;
        } else
        {
            x = new MaskStateHolder();
            return;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03010e, viewgroup, false);
    }

    public final void onDestroy()
    {
        super.onDestroy();
        (new AsyncTask() {

            private s a;

            protected final volatile Object doInBackground(Object aobj[])
            {
                return null;
            }

            protected final void onPostExecute(Object obj)
            {
                super.onPostExecute((Void)obj);
                if (com.picsart.studio.editor.fragment.s.o(a) != null)
                {
                    com.socialin.android.util.c.a(s.j(a));
                }
                com.socialin.android.util.c.a(com.picsart.studio.editor.fragment.s.p(a));
                obj = com.picsart.studio.editor.fragment.s.q(a);
                if (((e) (obj)).c != null)
                {
                    ((e) (obj)).c.k();
                }
                s.r(a);
            }

            
            {
                a = s.this;
                super();
            }
        }).executeOnExecutor(c, new Void[0]);
    }

    public final void onPause()
    {
        super.onPause();
        ((EditorActivity)getActivity()).e();
    }

    public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
    {
        Mask mask = o.c;
        if (mask == null || !mask.a())
        {
            return;
        }
        TextView textview;
        if (seekbar.getId() == 0x7f100706)
        {
            textview = (TextView)t.findViewById(0x7f100705);
            mask.j = seekbar.getProgress();
        } else
        {
            textview = (TextView)t.findViewById(0x7f100702);
            mask.i = seekbar.getProgress();
        }
        textview.setText((new StringBuilder(": ")).append(seekbar.getProgress()).toString());
        s.invalidate();
    }

    public final void onResume()
    {
        super.onResume();
        (new AsyncTask() {

            private s a;

            private transient Void a()
            {
_L4:
                if (com.picsart.studio.editor.fragment.s.l(a))
                {
                    break MISSING_BLOCK_LABEL_68;
                }
                (new StringBuilder("initFlag: ")).append(com.picsart.studio.editor.fragment.s.l(a));
                Object obj = com.picsart.studio.editor.fragment.s.m(a);
                obj;
                JVM INSTR monitorenter ;
                com.picsart.studio.editor.fragment.s.m(a).wait();
_L2:
                continue; /* Loop/switch isn't completed */
                Object obj1;
                obj1;
                obj;
                JVM INSTR monitorexit ;
                throw obj1;
                obj1;
                ((InterruptedException) (obj1)).printStackTrace();
                if (true) goto _L2; else goto _L1
_L1:
                return null;
                if (true) goto _L4; else goto _L3
_L3:
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final void onPostExecute(Object obj)
            {
                super.onPostExecute((Void)obj);
                com.picsart.studio.editor.fragment.s.n(a);
                if (a.isAdded())
                {
                    ((EditorActivity)a.getActivity()).e();
                }
            }

            protected final void onPreExecute()
            {
                super.onPreExecute();
                ((EditorActivity)a.getActivity()).d();
            }

            
            {
                a = s.this;
                super();
            }
        }).execute(new Void[0]);
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        Mask mask = o.c;
        if (mask != null)
        {
            if (x.b != q.a(mask.h))
            {
                x.b = q.a(mask.h);
            }
            x.d = mask.i;
            x.e = mask.j;
            x.f = mask.a(false).toString().toLowerCase();
        }
        (new StringBuilder("maskStateHolder: ")).append(x);
        bundle.putParcelable("mask_state", x);
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        seekbar = o.c;
        if (!seekbar.a())
        {
            return;
        } else
        {
            a(getActivity(), seekbar);
            return;
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        (new StringBuilder("maskStateHolder: ")).append(x);
        s = (MaskView)view.findViewById(0x7f1000ef);
        bundle = (RadioButton)view.findViewById(0x7f1006f9);
        Object obj = (RecyclerView)view.findViewById(0x7f1005c7);
        Object obj1 = (RecyclerView)view.findViewById(0x7f1005ca);
        v = (RelativeLayout)view.findViewById(0x7f1005cb);
        u = (RelativeLayout)view.findViewById(0x7f1005c5);
        t = (RelativeLayout)view.findViewById(0x7f1005c9);
        s.setupSpenTouch();
        if (n != null)
        {
            s.setDrawController(n);
            s.setOrigBitmap(l);
        }
        Object obj2 = t;
        Object obj3;
        Object obj4;
        ImageButton imagebutton;
        int i1;
        boolean flag;
        if (x.a >= 0)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        ((RelativeLayout) (obj2)).setVisibility(i1);
        view = (ImageButton)view.findViewById(0x7f1005c8);
        view.setOnClickListener(new android.view.View.OnClickListener(((RecyclerView) (obj1))) {

            final RecyclerView a;
            private s b;

            public final void onClick(View view1)
            {
                af af = new af(this) {

                    private _cls11 a;

                    public final void onAnimationEnd(Animation animation)
                    {
                        if (a.a.isShown())
                        {
                            a.a.setVisibility(8);
                            return;
                        } else
                        {
                            a.a.setVisibility(0);
                            return;
                        }
                    }

            
            {
                a = _pcls11;
                super();
            }
                };
                Animation animation;
                Animation animation1;
                if (a.isShown())
                {
                    animation1 = AnimationUtils.loadAnimation(b.getActivity(), 0x7f04002d);
                    animation = AnimationUtils.loadAnimation(b.getActivity(), 0x7f04003e);
                } else
                {
                    animation1 = AnimationUtils.loadAnimation(b.getActivity(), 0x7f04002e);
                    animation = AnimationUtils.loadAnimation(b.getActivity(), 0x7f04003f);
                }
                animation1.setAnimationListener(af);
                a.startAnimation(animation1);
                view1.startAnimation(animation);
            }

            
            {
                b = s.this;
                a = recyclerview;
                super();
            }
        });
        obj2 = new ag() {

            private s a;

            public final void onAnimationEnd(Animator animator)
            {
                com.picsart.studio.editor.fragment.s.a(a).setVisibility(8);
            }

            
            {
                a = s.this;
                super();
            }
        };
        ((ImageButton)u.findViewById(0x7f100707)).setOnClickListener(new android.view.View.OnClickListener() {

            private s a;

            public final void onClick(View view1)
            {
                if (s.t(a))
                {
                    return;
                } else
                {
                    a.g.a(a);
                    return;
                }
            }

            
            {
                a = s.this;
                super();
            }
        });
        ((ImageButton)u.findViewById(0x7f10070b)).setOnClickListener(new android.view.View.OnClickListener() {

            public final s a;

            public final void onClick(View view1)
            {
                if (s.t(a) || !a.isVisible())
                {
                    return;
                }
                ((EditorActivity)a.getActivity()).d();
                view1 = com.socialin.android.util.c.a(s.u(a), s.u(a).getConfig());
                Object obj5 = new Canvas(view1);
                Mask mask = com.picsart.studio.editor.fragment.s.e(a).c;
                if (mask != null)
                {
                    mask.a(a.getActivity(), s.u(a), ((Canvas) (obj5)));
                }
                obj5 = com.picsart.studio.editor.fragment.s.q(a).c.n.d();
                view1 = new m(s.u(a), s.j(a), view1, ((ArrayList) (obj5)));
                view1.a = new n(this);
                view1.executeOnExecutor(s.v(a), new Void[0]);
            }

            
            {
                a = s.this;
                super();
            }
        });
        ((RadioGroup)u.findViewById(0x7f10070a)).setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener(((android.animation.Animator.AnimatorListener) (obj2))) {

            private android.animation.Animator.AnimatorListener a;
            private s b;

            public final void onCheckedChanged(RadioGroup radiogroup, int j1)
            {
                if (j1 == 0x7f1006f9)
                {
                    com.picsart.studio.editor.fragment.s.q(b).h = false;
                    com.picsart.studio.editor.fragment.s.f(b).c = false;
                } else
                {
                    com.picsart.studio.editor.fragment.s.q(b).h = true;
                    com.picsart.studio.editor.fragment.s.f(b).c = true;
                    if (com.picsart.studio.editor.fragment.s.a(b).getVisibility() == 0)
                    {
                        com.picsart.studio.editor.fragment.s.a(b).setScaleX(1.0F);
                        com.picsart.studio.editor.fragment.s.a(b).setScaleY(1.0F);
                        com.picsart.studio.editor.fragment.s.a(b).setPivotX(((float)com.picsart.studio.editor.fragment.s.a(b).getWidth() * 3F) / 4F);
                        com.picsart.studio.editor.fragment.s.a(b).setPivotY(0.0F);
                        com.picsart.studio.editor.fragment.s.a(b).animate().setListener(a).setDuration(200L).scaleX(0.0F).scaleY(0.0F).start();
                        return;
                    }
                }
            }

            
            {
                b = s.this;
                a = animatorlistener;
                super();
            }
        });
        bundle.setOnClickListener(new android.view.View.OnClickListener(((android.animation.Animator.AnimatorListener) (obj2))) {

            private android.animation.Animator.AnimatorListener a;
            private s b;

            public final void onClick(View view1)
            {
                int j1 = com.picsart.studio.editor.fragment.s.a(b).getVisibility();
                if (j1 == 8 || j1 == 4)
                {
                    com.picsart.studio.editor.fragment.s.a(b).setScaleX(0.0F);
                    com.picsart.studio.editor.fragment.s.a(b).setScaleY(0.0F);
                    com.picsart.studio.editor.fragment.s.a(b).setVisibility(0);
                    com.picsart.studio.editor.fragment.s.a(b).setPivotX(((float)com.picsart.studio.editor.fragment.s.a(b).getWidth() * 3F) / 4F);
                    com.picsart.studio.editor.fragment.s.a(b).setPivotY(0.0F);
                    com.picsart.studio.editor.fragment.s.a(b).animate().setListener(null).setDuration(200L).scaleX(1.0F).scaleY(1.0F).start();
                    return;
                } else
                {
                    com.picsart.studio.editor.fragment.s.a(b).setScaleX(1.0F);
                    com.picsart.studio.editor.fragment.s.a(b).setScaleY(1.0F);
                    com.picsart.studio.editor.fragment.s.a(b).setPivotX(((float)com.picsart.studio.editor.fragment.s.a(b).getWidth() * 3F) / 4F);
                    com.picsart.studio.editor.fragment.s.a(b).setPivotY(0.0F);
                    com.picsart.studio.editor.fragment.s.a(b).animate().setListener(a).setDuration(200L).scaleX(0.0F).scaleY(0.0F).start();
                    return;
                }
            }

            
            {
                b = s.this;
                a = animatorlistener;
                super();
            }
        });
        obj3 = new ArrayList(Arrays.asList(com.picsart.studio.editor.custommasks.Mask.BlendMode.values()));
        obj2 = (Spinner)u.findViewById(0x7f100709);
        ((Spinner) (obj2)).setOnHoverListener(new android.view.View.OnHoverListener() {

            public final boolean onHover(View view1, MotionEvent motionevent)
            {
                return false;
            }

        });
        obj3 = new com.picsart.studio.editor.custommasks.a(getActivity(), getActivity(), ((List) (obj3)), p);
        obj4 = getView();
        ((com.picsart.studio.editor.custommasks.a) (obj3)).a.a(((View) (obj4)));
        ((Spinner) (obj2)).setAdapter(((SpinnerAdapter) (obj3)));
        if (x.a >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Spinner) (obj2)).setEnabled(flag);
        ((Spinner) (obj2)).setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            private s a;

            public final void onItemSelected(AdapterView adapterview, View view1, int j1, long l1)
            {
                view1 = com.picsart.studio.editor.fragment.s.e(a).c;
                adapterview = (com.picsart.studio.editor.custommasks.Mask.BlendMode)adapterview.getItemAtPosition(j1);
                if (view1 != null && view1.a(false) != adapterview)
                {
                    view1.g = adapterview;
                    com.picsart.studio.editor.fragment.s.a(a, a.getActivity(), view1);
                }
            }

            public final void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                a = s.this;
                super();
            }
        });
        if (x.a >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.setEnabled(flag);
        obj2 = new com.picsart.studio.editor.custommasks.b(getActivity(), j());
        ((com.picsart.studio.editor.custommasks.b) (obj2)).setOrientation(j());
        ((RecyclerView) (obj)).setHasFixedSize(true);
        ((RecyclerView) (obj)).setLayoutManager(((android.support.v7.widget.RecyclerView.LayoutManager) (obj2)));
        ((RecyclerView) (obj1)).setHasFixedSize(true);
        ((RecyclerView) (obj1)).setLayoutManager(new com.picsart.studio.editor.custommasks.b(getActivity(), 1));
        ((RecyclerView) (obj1)).setVisibility(8);
        obj = (SeekBar)t.findViewById(0x7f100703);
        obj1 = (SeekBar)t.findViewById(0x7f100706);
        obj2 = (ImageButton)t.findViewById(0x7f1006fd);
        obj3 = (ImageButton)t.findViewById(0x7f1006fe);
        obj4 = (ImageButton)t.findViewById(0x7f1006ff);
        imagebutton = (ImageButton)t.findViewById(0x7f100700);
        ((ImageButton) (obj2)).setOnClickListener(y);
        ((ImageButton) (obj3)).setOnClickListener(y);
        ((ImageButton) (obj4)).setOnClickListener(y);
        imagebutton.setOnClickListener(y);
        ((SeekBar) (obj)).setOnSeekBarChangeListener(this);
        ((SeekBar) (obj1)).setOnSeekBarChangeListener(this);
        obj = (ImageButton)v.findViewById(0x7f10018b);
        obj1 = (ImageButton)v.findViewById(0x7f100136);
        obj2 = (ImageButton)v.findViewById(0x7f10018c);
        obj3 = (CompoundButton)v.findViewById(0x7f10018e);
        obj4 = (CompoundButton)v.findViewById(0x7f10018d);
        ((ImageButton) (obj)).setOnClickListener(w);
        ((ImageButton) (obj1)).setOnClickListener(w);
        ((ImageButton) (obj2)).setOnClickListener(w);
        ((CompoundButton) (obj3)).setOnClickListener(w);
        ((CompoundButton) (obj3)).setChecked(true);
        ((CompoundButton) (obj4)).setOnClickListener(w);
        if (n == null || n.c.n.e())
        {
            ((ImageButton) (obj)).setEnabled(false);
        } else
        {
            ((ImageButton) (obj)).setEnabled(true);
        }
        view.performClick();
        if (!x.c)
        {
            bundle.performClick();
        }
    }
}
