// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.clipart.e;
import com.socialin.android.photo.effects.activity.EffectsActivityNew;
import com.socialin.android.photo.freecrop.d;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.select.SelectionActivity;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.photo.select.SelectionHistoryStack;
import com.socialin.android.photo.select.SelectionShapeDrawController;
import com.socialin.android.photo.select.SelectionView;
import com.socialin.android.photo.select.a;
import com.socialin.android.photo.select.b;
import com.socialin.android.photo.select.c;
import com.socialin.android.photo.select.g;
import com.socialin.android.photo.select.h;
import com.socialin.android.photo.select.i;
import com.socialin.android.photo.select.j;
import com.socialin.android.photo.select.n;
import com.socialin.android.photo.select.o;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            a

public class SelectionFragment extends com.picsart.studio.editor.fragment.a
    implements b, h, i
{

    private static final String h = com/picsart/studio/editor/fragment/SelectionFragment.getSimpleName();
    private static int i = 0;
    private com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE A;
    private Animation B;
    private Animation C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    private String H;
    private boolean I;
    private android.content.DialogInterface.OnCancelListener J;
    private int K;
    private com.socialin.android.dialog.g L;
    private boolean M;
    private int N;
    private int O;
    private Point P;
    private Point Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private Intent V;
    private int W;
    private int X;
    private HashMap Y;
    private boolean Z;
    private Bitmap aa;
    private HashMap ab;
    private TimeCalculator ac;
    private boolean ad;
    private android.view.View.OnClickListener ae;
    private a af;
    public boolean c;
    public EditingData d;
    public Bitmap e;
    public TimeCalculator f;
    PopupWindow g;
    private ImageButton j;
    private SelectionHistoryStack k;
    private int l[] = {
        0x7f100066, 0x7f100064, 0x7f10006b, 0x7f100063, 0x7f100065, 0x7f100069, 0x7f100068, 0x7f10006d, 0x7f100067, 0x7f10006c
    };
    private int m[] = {
        0x7f020335, 0x7f0204d7, 0x7f0204e3, 0x7f02031e, 0x7f020091, 0x7f0204df, 0x7f020351, 0x7f0204d3, 0x7f0204da, 0x7f0203d8
    };
    private int n[] = {
        0x7f0802af, 0x7f0802ab, 0x7f08031e, 0x7f08029f, 0x7f0802ae, 0x7f0802e6, 0x7f0802be, 0x7f080340, 0x7f0802b4, 0x7f08033c
    };
    private int o[] = {
        0x7f10006a, 0x7f100065, 0x7f100068, 0x7f10006d, 0x7f10006c
    };
    private int p[] = {
        0x7f0204db, 0x7f020091, 0x7f020351, 0x7f0204d3, 0x7f0203d8
    };
    private int q[] = {
        0x7f100066, 0x7f100064, 0x7f10006b, 0x7f100063, 0x7f100067, 0x7f100069
    };
    private int r[] = {
        0x7f020335, 0x7f0204d7, 0x7f0204e3, 0x7f02031e, 0x7f0204da, 0x7f0204df
    };
    private int s[] = {
        0x7f0802af, 0x7f0802ab, 0x7f08031e, 0x7f08029f, 0x7f0802b4, 0x7f0802e6
    };
    private int t[] = {
        0x7f100560, 0x7f10083f, 0x7f100840, 0x7f100841, 0x7f100842, 0x7f100843, 0x7f100844, 0x7f100845, 0x7f100846, 0x7f100847, 
        0x7f100848
    };
    private ThreadPoolExecutor u;
    private int v;
    private SelectionDrawController w;
    private Bitmap x;
    private RectF y;
    private FragmentUIMode z;

    public SelectionFragment()
    {
        k = new SelectionHistoryStack();
        v = PicsartContext.a();
        x = null;
        y = null;
        z = FragmentUIMode.SELECTION;
        A = com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.FREE_CROP;
        B = null;
        C = null;
        D = null;
        E = null;
        F = null;
        G = null;
        H = null;
        I = false;
        M = false;
        N = 0;
        O = 0;
        P = new Point();
        Q = new Point();
        R = false;
        S = false;
        T = false;
        U = true;
        V = null;
        W = -1;
        X = -1;
        Z = false;
        aa = null;
        c = false;
        ab = null;
        e = null;
        ad = true;
        ae = new android.view.View.OnClickListener() {

            private SelectionFragment a;

            public final void onClick(View view)
            {
                if (!com.picsart.studio.editor.fragment.SelectionFragment.a(a))
                {
                    if (view.getId() == 0x7f100066)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "cut"));
                        com.picsart.studio.editor.fragment.SelectionFragment.c(a);
                        return;
                    }
                    if (view.getId() == 0x7f100064)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "copy"));
                        com.picsart.studio.editor.fragment.SelectionFragment.d(a);
                        return;
                    }
                    if (view.getId() == 0x7f10006b)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "paste"));
                        com.picsart.studio.editor.fragment.SelectionFragment.e(a);
                        return;
                    }
                    if (view.getId() == 0x7f100063)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "clear"));
                        SelectionFragment.f(a);
                        return;
                    }
                    if (view.getId() == 0x7f100065)
                    {
                        com.picsart.studio.editor.fragment.SelectionFragment.g(a);
                        return;
                    }
                    if (view.getId() == 0x7f100069)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "inverse"));
                        com.picsart.studio.editor.fragment.SelectionFragment.h(a);
                        return;
                    }
                    if (view.getId() == 0x7f100068)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "effect_click"));
                        com.picsart.studio.editor.fragment.SelectionFragment.i(a);
                        return;
                    }
                    if (view.getId() == 0x7f10006d)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "save_to_clipart"));
                        com.picsart.studio.editor.fragment.SelectionFragment.j(a);
                        return;
                    }
                    if (view.getId() == 0x7f100067)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "deselect"));
                        SelectionFragment.k(a);
                        return;
                    }
                    if (view.getId() == 0x7f10006c)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "original"));
                        SelectionFragment.l(a);
                        return;
                    }
                    if (view.getId() == 0x7f10006a)
                    {
                        com.picsart.studio.editor.fragment.SelectionFragment.m(a);
                        return;
                    }
                }
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        };
    }

    static void A(SelectionFragment selectionfragment)
    {
        selectionfragment.g(((View) (null)));
    }

    static void B(SelectionFragment selectionfragment)
    {
        selectionfragment.p();
    }

    static boolean C(SelectionFragment selectionfragment)
    {
        return selectionfragment.o();
    }

    static ThreadPoolExecutor D(SelectionFragment selectionfragment)
    {
        return selectionfragment.u;
    }

    static boolean E(SelectionFragment selectionfragment)
    {
        return selectionfragment.b(false);
    }

    static void F(SelectionFragment selectionfragment)
    {
        selectionfragment.a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    static com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE G(SelectionFragment selectionfragment)
    {
        return selectionfragment.A;
    }

    static void H(SelectionFragment selectionfragment)
    {
        selectionfragment.a(false, ((View) (null)));
    }

    static TimeCalculator I(SelectionFragment selectionfragment)
    {
        return selectionfragment.f;
    }

    static void J(SelectionFragment selectionfragment)
    {
        selectionfragment.m();
    }

    static void K(SelectionFragment selectionfragment)
    {
        selectionfragment.j();
    }

    static boolean L(SelectionFragment selectionfragment)
    {
        selectionfragment.Z = false;
        return false;
    }

    static ImageButton M(SelectionFragment selectionfragment)
    {
        return selectionfragment.j;
    }

    static Animation N(SelectionFragment selectionfragment)
    {
        return selectionfragment.D;
    }

    static Animation O(SelectionFragment selectionfragment)
    {
        return selectionfragment.B;
    }

    static Bitmap P(SelectionFragment selectionfragment)
    {
        return selectionfragment.q();
    }

    static boolean Q(SelectionFragment selectionfragment)
    {
        selectionfragment.I = false;
        return false;
    }

    public static ByteBuffer a(int i1)
    {
        h();
        return ImageOpCommon.allocNativeBuffer(i1);
    }

    static ByteBuffer a(SelectionFragment selectionfragment, com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem selectionhistoryitem)
    {
        Object obj = null;
        ByteBuffer bytebuffer;
        if (selectionhistoryitem != null)
        {
            selectionhistoryitem = selectionhistoryitem.a;
        } else
        {
            selectionhistoryitem = null;
        }
        bytebuffer = obj;
        if (selectionhistoryitem != null)
        {
            bytebuffer = obj;
            if (selectionhistoryitem.getAbsolutePath() != null)
            {
                bytebuffer = com.socialin.android.util.w.a(selectionhistoryitem, selectionfragment.w.a.getWidth() * selectionfragment.w.a.getHeight() * 4);
                h();
            }
        }
        return bytebuffer;
    }

    static HashMap a(SelectionFragment selectionfragment, HashMap hashmap)
    {
        selectionfragment.ab = hashmap;
        return hashmap;
    }

    private void a(int i1, int j1, Intent intent, boolean flag)
    {
        if (j1 != -1 || w == null)
        {
            return;
        }
        Object obj = intent.getExtras();
        switch (i1)
        {
        default:
            return;

        case 0: // '\0'
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(d.a, "effect_apply"));
            break;
        }
        if (intent.hasExtra("bufferData"))
        {
            intent = (String)((HashMap)((Bundle) (obj)).getSerializable("bufferData")).get("path");
            obj = null;
        } else
        {
            obj = ((Bundle) (obj)).getString("path");
            intent = null;
        }
        intent = new Runnable(flag, Y, intent, ((String) (obj))) {

            final SelectionFragment a;
            private boolean b;
            private HashMap c;
            private String d;
            private String e;

            public final void run()
            {
                Object obj1 = SelectionFragment.p(a).b;
                if (!b || c == null) goto _L2; else goto _L1
_L1:
                Object obj2;
                int k1;
                int l1;
                k1 = ((Integer)c.get("width")).intValue();
                l1 = ((Integer)c.get("height")).intValue();
                obj2 = com.socialin.android.util.c.a(k1, l1, android.graphics.Bitmap.Config.ARGB_8888);
                if (obj2 == null) goto _L2; else goto _L3
_L3:
                obj1 = new File((String)c.get("path"));
                ByteBuffer bytebuffer = com.socialin.android.util.w.a(((File) (obj1)), k1 * l1 * 4);
                com.picsart.studio.editor.fragment.SelectionFragment.h();
                bytebuffer.position(0);
                ((Bitmap) (obj2)).copyPixelsFromBuffer(bytebuffer);
                com.picsart.studio.editor.fragment.SelectionFragment.a(bytebuffer);
                ((File) (obj1)).delete();
_L11:
                obj1 = SelectionFragment.p(a).a;
                k1 = ((Bitmap) (obj1)).getWidth();
                l1 = ((Bitmap) (obj1)).getHeight();
                if (d == null) goto _L5; else goto _L4
_L4:
                File file = new File(d);
                ByteBuffer bytebuffer1 = com.socialin.android.util.w.a(file, k1 * l1 * 4);
                com.picsart.studio.editor.fragment.SelectionFragment.h();
                bytebuffer1.position(0);
                obj1 = com.socialin.android.util.c.a(k1, l1, android.graphics.Bitmap.Config.ARGB_8888);
                ((Bitmap) (obj1)).copyPixelsFromBuffer(bytebuffer1);
                com.picsart.studio.editor.fragment.SelectionFragment.a(bytebuffer1);
                file.delete();
_L9:
                Exception exception;
                if (obj1 != null)
                {
                    Bitmap bitmap = com.socialin.android.util.c.a(k1, l1, android.graphics.Bitmap.Config.ARGB_8888);
                    if (bitmap != null)
                    {
                        bitmap.eraseColor(0);
                        Canvas canvas = new Canvas(bitmap);
                        Paint paint = new Paint();
                        paint.setFilterBitmap(true);
                        canvas.drawBitmap(((Bitmap) (obj2)), 0.0F, 0.0F, paint);
                        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
                        paint.setColor(0xff000000);
                        canvas.drawPaint(paint);
                        canvas.drawBitmap(((Bitmap) (obj1)), 0.0F, 0.0F, paint);
                    }
                    com.socialin.android.util.c.a(((Bitmap) (obj1)));
                    obj1 = bitmap;
                } else
                {
                    obj1 = null;
                }
                obj2 = a.getActivity();
                if (obj2 != null && !((Activity) (obj2)).isFinishing())
                {
                    ((Activity) (obj2)).runOnUiThread(new Runnable(this, ((Bitmap) (obj1))) {

                        private Bitmap a;
                        private _cls32 b;

                        public final void run()
                        {
                            if (com.picsart.studio.editor.fragment.SelectionFragment.x(b.a))
                            {
                                if (a != null && !a.isRecycled())
                                {
                                    com.socialin.android.util.c.a(a);
                                }
                                return;
                            }
                            com.picsart.studio.editor.fragment.SelectionFragment.a(b.a, false);
                            b.a.d();
                            Object obj1 = SelectionFragment.p(b.a);
                            Object obj = a;
                            if (obj != null && !((Bitmap) (obj)).isRecycled())
                            {
                                obj1 = new Canvas(((SelectionDrawController) (obj1)).a);
                                Paint paint = new Paint();
                                paint.setFilterBitmap(true);
                                ((Canvas) (obj1)).drawBitmap(((Bitmap) (obj)), 0.0F, 0.0F, paint);
                            }
                            if (a != null && !a.isRecycled())
                            {
                                com.socialin.android.util.c.a(a);
                            }
                            obj = SelectionFragment.p(b.a).q();
                            if (((ArrayList) (obj)).size() > 0)
                            {
                                SelectionFragment.y(b.a).b(((ArrayList) (obj)));
                            }
                            if (SelectionFragment.p(b.a).n == com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.CLEAR)
                            {
                                SelectionFragment.p(b.a).a(com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.ADD);
                                SelectionFragment.z(b.a);
                            }
                            SelectionFragment.p(b.a).t.invalidate();
                            SelectionFragment.A(b.a);
                            SelectionFragment.B(b.a);
                        }

            
            {
                b = _pcls32;
                a = bitmap;
                super();
            }
                    });
                } else
                if (obj1 != null && !((Bitmap) (obj1)).isRecycled())
                {
                    com.socialin.android.util.c.a(((Bitmap) (obj1)));
                    return;
                }
                return;
_L5:
                if (e == null) goto _L7; else goto _L6
_L6:
                obj1 = com.socialin.android.util.w.b(e, com.picsart.studio.editor.fragment.SelectionFragment.w(a), 0);
                (new File(e)).delete();
                continue; /* Loop/switch isn't completed */
                exception;
_L8:
                com.socialin.android.d.b(com.picsart.studio.editor.fragment.SelectionFragment.i(), new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
                continue; /* Loop/switch isn't completed */
                exception;
                obj1 = null;
                if (true) goto _L8; else goto _L7
_L7:
                obj1 = null;
                if (true) goto _L9; else goto _L2
_L2:
                obj2 = obj1;
                if (true) goto _L11; else goto _L10
_L10:
            }

            
            {
                a = SelectionFragment.this;
                b = flag;
                c = hashmap;
                d = s1;
                e = s2;
                super();
            }
        };
        a(true);
        com.socialin.android.photo.select.g.a(intent, true, u);
        a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    private void a(int i1, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        if (L != null && L.isShowing())
        {
            return;
        }
        Activity activity = getActivity();
        L = new com.socialin.android.dialog.g(activity);
        L.setMessage(getString(i1));
        android.content.DialogInterface.OnCancelListener oncancellistener1 = oncancellistener;
        if (oncancellistener == null)
        {
            oncancellistener1 = new android.content.DialogInterface.OnCancelListener() {

                private SelectionFragment a;

                public final void onCancel(DialogInterface dialoginterface)
                {
                    SelectionFragment.Q(a);
                }

            
            {
                a = SelectionFragment.this;
                super();
            }
            };
        }
        L.setOnCancelListener(oncancellistener1);
        J = oncancellistener1;
        K = i1;
        myobfuscated.f.m.a(activity, L);
        I = true;
    }

    private void a(Bitmap bitmap, View view)
    {
        Activity activity = getActivity();
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (activity != null && !activity.isFinishing())
        {
            Log.e("ex1", "activity != null && !activity.isFinishing()");
            Log.e("ex1", (new StringBuilder("bitmap w = ")).append(bitmap.getWidth()).toString());
            Log.e("ex1", (new StringBuilder("bitmap h = ")).append(bitmap.getHeight()).toString());
            w = new SelectionDrawController(getActivity(), bitmap);
            w.o = this;
            if (view1 != null)
            {
                a(view1);
                a(view1, activity.getLayoutInflater());
            }
            if (V != null)
            {
                a(W, X, V, Z);
                V = null;
                X = -1;
                W = -1;
                Y = null;
            }
        }
    }

    private void a(LayoutInflater layoutinflater, int i1, ViewGroup viewgroup, android.view.View.OnClickListener onclicklistener, int j1, int ai[], int ai1[], 
            int ai2[])
    {
        Activity activity = getActivity();
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -1, 1.0F);
        FrameLayout framelayout = new FrameLayout(activity);
        framelayout.setLayoutParams(layoutparams);
        viewgroup.addView(framelayout);
        if (i1 == 0x7f03003d)
        {
            layoutinflater = (Button)layoutinflater.inflate(i1, framelayout, false);
            ((android.widget.FrameLayout.LayoutParams)layoutinflater.getLayoutParams()).gravity = 17;
            framelayout.addView(layoutinflater);
            layoutinflater.setCompoundDrawablesWithIntrinsicBounds(0, ai1[j1], 0, 0);
            if (ai2 != null)
            {
                layoutinflater.setText(ai2[j1]);
            }
            layoutinflater.setId(ai[j1]);
            layoutinflater.setOnClickListener(onclicklistener);
            return;
        }
        int k1 = ai[j1];
        ai = null;
        if (k1 == 0x7f10006a)
        {
            ai = new FrameLayout(activity);
            viewgroup = null;
        } else
        {
            viewgroup = (ImageButton)layoutinflater.inflate(i1, framelayout, false);
            ((android.widget.FrameLayout.LayoutParams)viewgroup.getLayoutParams()).gravity = 17;
        }
        if (k1 == 0x7f10006a)
        {
            viewgroup = new android.widget.FrameLayout.LayoutParams(-2, -2);
            viewgroup.gravity = 17;
            framelayout.addView(ai, viewgroup);
            viewgroup = (ImageButton)layoutinflater.inflate(i1, ai, false);
            layoutinflater = (android.widget.FrameLayout.LayoutParams)viewgroup.getLayoutParams();
            layoutinflater.gravity = 17;
            ai.addView(viewgroup, layoutinflater);
            ai2 = getActivity();
            layoutinflater = new ImageView(ai2);
            layoutinflater.setBackgroundColor(0);
            layoutinflater.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            i1 = (int)Utils.a(10F, ai2);
            int l1 = (int)Utils.a(5F, ai2);
            int i2 = (int)Utils.a(12F, ai2);
            ai2 = new android.widget.FrameLayout.LayoutParams(i1, i1);
            ai2.gravity = 85;
            ai2.setMargins(0, 0, l1, i2);
            ai.addView(layoutinflater, 1, ai2);
            layoutinflater.setImageResource(0x7f0206d5);
        } else
        {
            framelayout.addView(viewgroup);
        }
        viewgroup.setImageResource(ai1[j1]);
        viewgroup.setId(k1);
        viewgroup.setOnClickListener(onclicklistener);
    }

    private void a(LayoutInflater layoutinflater, View view)
    {
        view = (LinearLayout)view.findViewById(0x7f100606);
        for (int i1 = 0; i1 < q.length; i1++)
        {
            android.view.View.OnClickListener onclicklistener = ae;
            int ai[] = q;
            int ai1[] = r;
            int ai2[] = s;
            int j1 = ai[i1];
            Button button = (Button)layoutinflater.inflate(0x7f0301c3, view, false);
            button.setId(j1);
            button.setCompoundDrawablesWithIntrinsicBounds(0, ai1[i1], 0, 0);
            button.setText(ai2[i1]);
            button.setId(ai[i1]);
            button.setOnClickListener(onclicklistener);
            view.addView(button);
        }

    }

    private void a(View view)
    {
        if (w != null)
        {
            view = c(view);
            if (view != null)
            {
                view.setDrawController(w);
                SelectionDrawController selectiondrawcontroller = w;
                com.socialin.android.photo.select.m m1 = selectiondrawcontroller.p;
                m1.q = view;
                if (m1.p != null)
                {
                    m1.p.a(view);
                }
                selectiondrawcontroller.t = view;
            }
        }
    }

    private void a(View view, LayoutInflater layoutinflater)
    {
        a(view, z, false);
        Object obj = getActivity();
        Object obj1 = new ArrayList();
        ((ArrayList) (obj1)).add(Integer.valueOf(0x7f02025a));
        ((ArrayList) (obj1)).add(Integer.valueOf(0x7f020259));
        ((ArrayList) (obj1)).add(Integer.valueOf(0x7f020258));
        ((ArrayList) (obj1)).add(Integer.valueOf(0x7f020257));
        ((ArrayList) (obj1)).add(Integer.valueOf(0x7f020256));
        ((ArrayList) (obj1)).add(Integer.valueOf(0x7f020255));
        obj = new n(((android.content.Context) (obj)), new String[] {
            "", "", "", "", ""
        }, ((ArrayList) (obj1)));
        obj1 = (Spinner)view.findViewById(0x7f10059e);
        ((Spinner) (obj1)).setAdapter(((android.widget.SpinnerAdapter) (obj)));
        ((Spinner) (obj1)).setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            private SelectionFragment a;

            public final void onItemSelected(AdapterView adapterview, View view1, int i1, long l1)
            {
                byte byte0 = 10;
                i1;
                JVM INSTR tableswitch 0 5: default 44
            //                           0 166
            //                           1 148
            //                           2 130
            //                           3 112
            //                           4 94
            //                           5 77;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                i1 = byte0;
_L9:
                adapterview = SelectionFragment.p(a).q;
                view1 = a.getActivity();
                adapterview.a(Utils.a(i1, view1));
                return;
_L7:
                SelectionFragment.M(a).setImageResource(0x7f020255);
                i1 = 5;
                continue; /* Loop/switch isn't completed */
_L6:
                SelectionFragment.M(a).setImageResource(0x7f020255);
                i1 = 8;
                continue; /* Loop/switch isn't completed */
_L5:
                SelectionFragment.M(a).setImageResource(0x7f020256);
                i1 = 15;
                continue; /* Loop/switch isn't completed */
_L4:
                SelectionFragment.M(a).setImageResource(0x7f02025b);
                i1 = 20;
                continue; /* Loop/switch isn't completed */
_L3:
                SelectionFragment.M(a).setImageResource(0x7f020257);
                i1 = 25;
                continue; /* Loop/switch isn't completed */
_L2:
                SelectionFragment.M(a).setImageResource(0x7f020258);
                i1 = 30;
                if (true) goto _L9; else goto _L8
_L8:
            }

            public final void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        });
        j = (ImageButton)view.findViewById(0x7f10059f);
        j.setOnClickListener(new android.view.View.OnClickListener(((Spinner) (obj1))) {

            private Spinner a;

            public final void onClick(View view1)
            {
                a.performClick();
            }

            
            {
                a = spinner;
                super();
            }
        });
        view.findViewById(0x7f1005a1).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectionFragment a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "undo"));
                if (com.picsart.studio.editor.fragment.SelectionFragment.a(a))
                {
                    return;
                }
                if (SelectionFragment.C(a))
                {
                    com.picsart.studio.editor.fragment.SelectionFragment.a(a, true);
                    view1 = new g() {

                    };
                    view1.i = SelectionFragment.p(a);
                    view1.a = 2;
                    view1.b = a;
                    view1.executeOnExecutor(SelectionFragment.D(a), new Void[] {
                        null
                    });
                    Log.e("ex1", "maskHasHistory()");
                } else
                {
                    SelectionFragment.E(a);
                }
                SelectionFragment.F(a);
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        });
        view.findViewById(0x7f100602).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectionFragment a;

            public final void onClick(View view1)
            {
                if (SelectionFragment.p(a) != null)
                {
                    SelectionFragment.p(a).a(SelectionFragment.G(a));
                    com.picsart.studio.editor.fragment.SelectionFragment.a(a, FragmentUIMode.SELECTION);
                }
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        });
        view.findViewById(0x7f100603).setOnClickListener(new android.view.View.OnClickListener() {

            final SelectionFragment a;

            public final void onClick(View view1)
            {
                if (SelectionFragment.p(a) != null)
                {
                    view1 = new Runnable(this) {

                        private _cls3 a;

                        public final void run()
                        {
                            float f2 = -1F;
                            if (com.picsart.studio.editor.fragment.SelectionFragment.x(a.a))
                            {
                                return;
                            }
                            Object obj1 = SelectionFragment.p(a.a);
                            if (((SelectionDrawController) (obj1)).u != null)
                            {
                                Object obj = new Canvas(((SelectionDrawController) (obj1)).a);
                                (new Paint()).setFilterBitmap(true);
                                c c1 = ((SelectionDrawController) (obj1)).u;
                                int i1 = ((SelectionDrawController) (obj1)).a.getWidth();
                                ((SelectionDrawController) (obj1)).a.getHeight();
                                obj1 = ((SelectionDrawController) (obj1)).f;
                                float f3 = c1.l.centerX();
                                float f4 = c1.l.centerY();
                                float f7 = ((RectF) (obj1)).left;
                                float f5 = ((RectF) (obj1)).top;
                                float f1 = (float)i1 / ((RectF) (obj1)).width();
                                f3 = (f3 - f7) * f1;
                                f4 = (f4 - f5) * f1;
                                f5 = c1.l.width() * f1;
                                f1 *= c1.l.height();
                                obj1 = new RectF(f3 - f5 / 2.0F, f4 - f1 / 2.0F, f5 / 2.0F + f3, f1 / 2.0F + f4);
                                ((Canvas) (obj)).save();
                                if (c1.n != 0.0F)
                                {
                                    f1 = c1.o.x;
                                    float f6 = ((RectF) (obj1)).width();
                                    float f8 = ((RectF) (obj1)).left;
                                    float f9 = c1.o.y;
                                    float f10 = ((RectF) (obj1)).height();
                                    float f11 = ((RectF) (obj1)).top;
                                    ((Canvas) (obj)).rotate(c1.n, f1 * f6 + f8, f9 * f10 + f11);
                                }
                                if (c1.x)
                                {
                                    f1 = -1F;
                                } else
                                {
                                    f1 = 1.0F;
                                }
                                if (!c1.y)
                                {
                                    f2 = 1.0F;
                                }
                                ((Canvas) (obj)).scale(f1, f2, f3, f4);
                                ((Canvas) (obj)).drawBitmap(c1.F, c1.m, ((RectF) (obj1)), c1.p);
                                ((Canvas) (obj)).restore();
                            }
                            obj = SelectionFragment.p(a.a).q();
                            if (((ArrayList) (obj)).size() > 0)
                            {
                                SelectionFragment.y(a.a).b(((ArrayList) (obj)));
                            }
                            SelectionFragment.p(a.a).a(SelectionFragment.G(a.a));
                            if (SelectionFragment.p(a.a).n == com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.CLEAR)
                            {
                                SelectionFragment.p(a.a).a(com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.ADD);
                            }
                            com.picsart.studio.editor.fragment.SelectionFragment.a(a.a, FragmentUIMode.SELECTION);
                            SelectionFragment.p(a.a).t.invalidate();
                            com.picsart.studio.editor.fragment.SelectionFragment.a(a.a, false);
                            SelectionFragment.z(a.a);
                            SelectionFragment.A(a.a);
                            SelectionFragment.B(a.a);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    };
                    com.picsart.studio.editor.fragment.SelectionFragment.a(a, true);
                    com.socialin.android.photo.select.g.a(view1, false, SelectionFragment.D(a));
                    SelectionFragment.H(a);
                }
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        });
        view.findViewById(0x7f100350).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectionFragment a;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionCloseEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "cancel", (int)SelectionFragment.I(a).d()));
                SelectionFragment.J(a);
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        });
        view.findViewById(0x7f100245).setOnClickListener(new android.view.View.OnClickListener() {

            final SelectionFragment a;

            public final void onClick(View view1)
            {
                if (com.picsart.studio.editor.fragment.SelectionFragment.a(a))
                {
                    return;
                } else
                {
                    com.socialin.android.photo.select.g.a(new Runnable(this) {

                        final _cls5 a;

                        public final void run()
                        {
                            Activity activity = a.a.getActivity();
                            if (com.picsart.studio.editor.fragment.SelectionFragment.x(a.a))
                            {
                                return;
                            } else
                            {
                                activity.runOnUiThread(new Runnable(this, SelectionFragment.p(a.a).a) {

                                    private Bitmap a;
                                    private _cls1 b;

                                    public final void run()
                                    {
                                        if (com.picsart.studio.editor.fragment.SelectionFragment.x(b.a.a))
                                        {
                                            return;
                                        }
                                        if (com.picsart.studio.editor.fragment.SelectionFragment.b(b.a.a) != null)
                                        {
                                            com.picsart.studio.editor.fragment.SelectionFragment.b(b.a.a).c("selection");
                                        }
                                        b.a.a.d();
                                        AnalyticUtils.getInstance(b.a.a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionCloseEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(b.a.a).a, "done", (int)SelectionFragment.I(b.a.a).d()));
                                        com.picsart.studio.editor.fragment.SelectionFragment.a(b.a.a, a);
                                    }

            
            {
                b = _pcls1;
                a = bitmap;
                super();
            }
                                });
                                return;
                            }
                        }

            
            {
                a = _pcls5;
                super();
            }
                    }, true, SelectionFragment.D(a));
                    com.picsart.studio.editor.fragment.SelectionFragment.a(a, true);
                    view1.setEnabled(false);
                    SelectionFragment.F(a);
                    return;
                }
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        });
        a(layoutinflater, view);
        g(view);
        af = new a(getActivity(), this, view);
        af.a = this;
        ((ImageButton)view.findViewById(0x7f10059c)).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectionFragment a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.SelectionFragment.b(a, view1);
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        });
        b(view);
        f(view);
    }

    static void a(View view, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(ongloballayoutlistener);
            return;
        } else
        {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(ongloballayoutlistener);
            return;
        }
    }

    private void a(View view, FragmentUIMode fragmentuimode, boolean flag)
    {
        RelativeLayout relativelayout;
        View view2;
        View view3;
label0:
        {
label1:
            {
                View view1 = view;
                if (view == null)
                {
                    view1 = getView();
                }
                if (view1 != null)
                {
                    z = fragmentuimode;
                    view = d(view1);
                    relativelayout = e(view1);
                    view2 = view1.findViewById(0x7f1005fc);
                    view3 = view1.findViewById(0x7f1005fb);
                    c(view1);
                    if (fragmentuimode != FragmentUIMode.ADD_DRAWABLE)
                    {
                        break label0;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                    E.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                        private SelectionFragment a;

                        public final void onAnimationEnd(Animation animation)
                        {
                            animation = a.getView();
                            if (animation != null)
                            {
                                Object obj = com.picsart.studio.editor.fragment.SelectionFragment.c(a, animation);
                                View view4 = animation.findViewById(0x7f10059a);
                                ((View) (obj)).clearAnimation();
                                view4.clearAnimation();
                                ((View) (obj)).setVisibility(8);
                                view4.setVisibility(8);
                                obj = animation.findViewById(0x7f1005fc);
                                ((View) (obj)).setVisibility(0);
                                ((View) (obj)).startAnimation(SelectionFragment.N(a));
                                animation.findViewById(0x7f1005fb).setVisibility(0);
                            }
                        }

                        public final void onAnimationRepeat(Animation animation)
                        {
                        }

                        public final void onAnimationStart(Animation animation)
                        {
                        }

            
            {
                a = SelectionFragment.this;
                super();
            }
                    });
                    view.startAnimation(C);
                    relativelayout.startAnimation(E);
                }
                return;
            }
            view.setVisibility(8);
            relativelayout.setVisibility(8);
            view2.setVisibility(0);
            view3.setVisibility(0);
            return;
        }
        if (flag)
        {
            view3.setVisibility(8);
            E.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                private SelectionFragment a;

                public final void onAnimationEnd(Animation animation)
                {
                    animation = a.getView();
                    if (animation != null)
                    {
                        Object obj = animation.findViewById(0x7f1005fc);
                        ((View) (obj)).clearAnimation();
                        ((View) (obj)).setVisibility(8);
                        obj = com.picsart.studio.editor.fragment.SelectionFragment.c(a, animation);
                        animation = animation.findViewById(0x7f10059a);
                        ((View) (obj)).setVisibility(0);
                        animation.setVisibility(0);
                        ((View) (obj)).startAnimation(SelectionFragment.O(a));
                        animation.startAnimation(SelectionFragment.N(a));
                    }
                }

                public final void onAnimationRepeat(Animation animation)
                {
                }

                public final void onAnimationStart(Animation animation)
                {
                }

            
            {
                a = SelectionFragment.this;
                super();
            }
            });
            view2.startAnimation(E);
            return;
        } else
        {
            view.setVisibility(0);
            relativelayout.setVisibility(0);
            view2.setVisibility(8);
            view3.setVisibility(8);
            return;
        }
    }

    static void a(SelectionFragment selectionfragment, Bitmap bitmap)
    {
        Activity activity = selectionfragment.getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        boolean flag;
        if (bitmap != selectionfragment.w.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        selectionfragment.ad = flag;
        AnalyticUtils.getInstance(activity).track(new com.socialin.android.apiv3.events.EventsFactory.EditToolsApplyEvent("tool_selection"));
        SelectionActivity.a = bitmap;
        bitmap = new Intent();
        if (selectionfragment.d != null)
        {
            bitmap.putExtra("editing_data", selectionfragment.d);
        }
        activity.setResult(-1, bitmap);
        activity.finish();
    }

    static void a(SelectionFragment selectionfragment, View view)
    {
        selectionfragment.h(view);
    }

    static void a(SelectionFragment selectionfragment, FragmentUIMode fragmentuimode)
    {
        selectionfragment.a(((View) (null)), fragmentuimode, true);
    }

    static void a(SelectionFragment selectionfragment, HashMap hashmap, HashMap hashmap1)
    {
        selectionfragment.startActivityForResult(EffectsActivityNew.a(selectionfragment.getActivity(), "selection", null, hashmap, null, 0, PicsartContext.a(), hashmap1, true, true, false, false), 0);
    }

    static void a(SelectionFragment selectionfragment, boolean flag)
    {
        selectionfragment.a(flag);
    }

    public static void a(ByteBuffer bytebuffer)
    {
        i--;
        Log.e("ex1", (new StringBuilder("ALLOCATE_BUFFERS_COUNT = ")).append(i).toString());
        ImageOpCommon.freeNativeBuffer(bytebuffer);
    }

    private void a(boolean flag)
    {
        M = flag;
        SelectionDrawController selectiondrawcontroller = w;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            selectiondrawcontroller.a(null, false);
        }
        selectiondrawcontroller.v = flag;
    }

    private void a(boolean flag, View view)
    {
        Object obj = null;
        view = getView();
        View view1;
        if (view != null)
        {
            view = view.findViewById(0x7f100602);
        } else
        {
            view = null;
        }
        if (view != null)
        {
            view.setEnabled(flag);
        }
        view1 = getView();
        view = obj;
        if (view1 != null)
        {
            view = view1.findViewById(0x7f100603);
        }
        if (view != null)
        {
            view.setEnabled(flag);
        }
    }

    static boolean a(SelectionFragment selectionfragment)
    {
        return selectionfragment.M;
    }

    static EditingData b(SelectionFragment selectionfragment)
    {
        return selectionfragment.d;
    }

    static HashMap b(SelectionFragment selectionfragment, HashMap hashmap)
    {
        selectionfragment.Y = hashmap;
        return hashmap;
    }

    static void b(SelectionFragment selectionfragment, View view)
    {
        int j1;
        int k1;
        int l1;
        Object obj = selectionfragment.getActivity();
        j1 = selectionfragment.getResources().getConfiguration().orientation;
        k1 = (int)selectionfragment.getResources().getDimension(0x7f0b0107);
        l1 = (int)Utils.a(58F, ((android.content.Context) (obj)));
        int i2 = (int)selectionfragment.getResources().getDimension(0x7f0b010a);
        int j2 = (int)selectionfragment.getResources().getDimension(0x7f0b0108);
        int k2 = (int)selectionfragment.getResources().getDimension(0x7f0b0109);
        obj = ((Activity) (obj)).getLayoutInflater().inflate(0x7f0301c1, null);
        android.view.View.OnClickListener onclicklistener = selectionfragment. new android.view.View.OnClickListener() {

            private SelectionFragment a;

            public final void onClick(View view2)
            {
                int i3;
                a.g.dismiss();
                i3 = view2.getId();
                i3;
                JVM INSTR lookupswitch 11: default 116
            //                           2131756384: 224
            //                           2131757119: 272
            //                           2131757120: 320
            //                           2131757121: 368
            //                           2131757122: 416
            //                           2131757123: 464
            //                           2131757124: 464
            //                           2131757125: 464
            //                           2131757126: 640
            //                           2131757127: 640
            //                           2131757128: 640;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7 _L7 _L8 _L8 _L8
_L1:
                break; /* Loop/switch isn't completed */
_L16:
                i3;
                JVM INSTR lookupswitch 11: default 216
            //                           2131756384: 832
            //                           2131757119: 816
            //                           2131757120: 848
            //                           2131757121: 832
            //                           2131757122: 816
            //                           2131757123: 848
            //                           2131757124: 832
            //                           2131757125: 816
            //                           2131757126: 848
            //                           2131757127: 832
            //                           2131757128: 816;
                   goto _L9 _L10 _L11 _L12 _L10 _L11 _L12 _L10 _L11 _L12 _L10 _L11
_L9:
                SelectionFragment.z(a);
                return;
_L2:
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "brush"));
                SelectionFragment.p(a).a(com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.FREE_CROP);
                break; /* Loop/switch isn't completed */
_L3:
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "eraser"));
                SelectionFragment.p(a).a(com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.FREE_CROP);
                break; /* Loop/switch isn't completed */
_L4:
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "lasso"));
                SelectionFragment.p(a).a(com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.LASSO);
                break; /* Loop/switch isn't completed */
_L5:
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "lasso_multi"));
                SelectionFragment.p(a).a(com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.LASSO);
                break; /* Loop/switch isn't completed */
_L6:
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "lasso_erase"));
                SelectionFragment.p(a).a(com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.LASSO);
                break; /* Loop/switch isn't completed */
_L7:
                SelectionFragment.p(a).a(com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.SHAPE);
                view2 = SelectionFragment.p(a).r;
                if (((SelectionShapeDrawController) (view2)).s != com.socialin.android.photo.select.SelectionShapeDrawController.SelectionShapeType.RECTANGLE)
                {
                    view2.a(com.socialin.android.photo.select.SelectionShapeDrawController.SelectionShapeType.RECTANGLE);
                }
                switch (i3)
                {
                case 2131757123: 
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "rectangle"));
                    break;

                case 2131757124: 
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "rectangle_multi"));
                    break;

                case 2131757125: 
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "rectangle_erase"));
                    break;
                }
                if (false)
                {
                }
                  goto _L13
_L8:
                SelectionFragment.p(a).a(com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.SHAPE);
                view2 = SelectionFragment.p(a).r;
                if (((SelectionShapeDrawController) (view2)).s != com.socialin.android.photo.select.SelectionShapeDrawController.SelectionShapeType.CIRCLE)
                {
                    view2.a(com.socialin.android.photo.select.SelectionShapeDrawController.SelectionShapeType.CIRCLE);
                }
                switch (i3)
                {
                case 2131757126: 
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "circle"));
                    break;

                case 2131757127: 
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "circle_multi"));
                    break;

                case 2131757128: 
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(com.picsart.studio.editor.fragment.SelectionFragment.b(a).a, "circle_erase"));
                    break;
                }
                  goto _L13
_L11:
                SelectionFragment.p(a).a(com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.CLEAR);
                  goto _L14
_L10:
                SelectionFragment.p(a).a(com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.ADD);
                  goto _L14
_L12:
                SelectionFragment.p(a).a(com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.DEFAULT);
_L14:
                if (true) goto _L9; else goto _L13
_L13:
                if (true) goto _L16; else goto _L15
_L15:
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        };
        boolean flag = selectionfragment.o();
        for (int i1 = 0; i1 < selectionfragment.t.length; i1++)
        {
            int l2 = selectionfragment.t[i1];
            View view1 = ((View) (obj)).findViewById(l2);
            view1.setOnClickListener(onclicklistener);
            if (!flag && (l2 == 0x7f10083f || l2 == 0x7f100842 || l2 == 0x7f100845 || l2 == 0x7f100848))
            {
                view1.setEnabled(false);
            }
        }

        selectionfragment.g = new PopupWindow(((View) (obj)), i2 + k2 * 4, j2 + k2 * 8);
        selectionfragment.g.setBackgroundDrawable(new ColorDrawable(0xff363636));
        selectionfragment.g.setTouchable(true);
        selectionfragment.g.setFocusable(true);
        if (j1 != 1) goto _L2; else goto _L1
_L1:
        selectionfragment.g.setAnimationStyle(0x7f0c00b3);
_L8:
        if (j1 != 1) goto _L4; else goto _L3
_L3:
        selectionfragment.g.showAsDropDown(view);
_L6:
        return;
_L2:
        if (j1 == 2)
        {
            selectionfragment.g.setAnimationStyle(0x7f0c00b4);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j1 != 2) goto _L6; else goto _L5
_L5:
        selectionfragment.g.showAtLocation(view, 85, k1, l1);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private boolean b(View view)
    {
        int j1 = 0x7f03003d;
        int k1 = 0;
        boolean flag1 = false;
        boolean flag;
        if (R)
        {
            flag = true;
        } else
        {
            View view1 = view;
            if (view == null)
            {
                view1 = getView();
            }
            flag = flag1;
            if (view1 != null)
            {
                LinearLayout linearlayout = (LinearLayout)view1.findViewById(0x7f100604);
                if (N == 0)
                {
                    N = linearlayout.getWidth();
                }
                if (O == 0)
                {
                    O = linearlayout.getHeight();
                }
                flag = flag1;
                if (N > 0)
                {
                    flag = flag1;
                    if (O > 0)
                    {
                        if (w != null)
                        {
                            LayoutInflater layoutinflater = getActivity().getLayoutInflater();
                            int i1 = getResources().getConfiguration().orientation;
                            int ai[] = o;
                            int ai1[] = p;
                            if (i1 == 1)
                            {
                                float f1 = N;
                                if (getResources().getDimension(0x7f0b010b) * (float)l.length <= f1)
                                {
                                    ai = l;
                                    ai1 = m;
                                    view = n;
                                    i1 = 0;
                                } else
                                {
                                    S = true;
                                    j1 = 0x7f0301c2;
                                    view = null;
                                    i1 = 0;
                                }
                            } else
                            {
                                float f2 = O;
                                if (getResources().getDimension(0x7f0b010b) * (float)l.length <= f2)
                                {
                                    ai = l;
                                    ai1 = m;
                                    view = n;
                                    i1 = 1;
                                } else
                                {
                                    S = true;
                                    j1 = 0x7f0301c2;
                                    view = null;
                                    i1 = 0;
                                }
                            }
                            if (i1 != 0)
                            {
                                for (i1 = ai.length - 1; i1 >= 0; i1--)
                                {
                                    a(layoutinflater, j1, linearlayout, ae, i1, ai, ai1, view);
                                }

                            } else
                            {
                                for (; k1 < ai.length; k1++)
                                {
                                    a(layoutinflater, j1, linearlayout, ae, k1, ai, ai1, view);
                                }

                            }
                            R = true;
                            h(view1);
                            g(((View) (null)));
                        }
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    private boolean b(boolean flag)
    {
        if (k.a.size() == 0)
        {
            g(((View) (null)));
            return false;
        }
        if (flag)
        {
            SelectionHistoryStack selectionhistorystack = k;
            if (selectionhistorystack.a != null)
            {
                for (int i1 = 0; i1 < selectionhistorystack.a.size(); i1++)
                {
                    Object obj = (com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem)selectionhistorystack.a.get(i1);
                    if (((com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem) (obj)).c != com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem.SelectionHistoryType.File)
                    {
                        continue;
                    }
                    obj = ((com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem) (obj)).a;
                    if (obj != null)
                    {
                        flag = ((File) (obj)).delete();
                        Log.e("ex1", (new StringBuilder()).append(((File) (obj)).getAbsolutePath()).append(" deleted = ").append(flag).toString());
                    }
                }

                selectionhistorystack.a.clear();
            }
        }
        a(true);
        com.socialin.android.photo.select.g.a(new Runnable(getActivity()) {

            final Activity a;
            final SelectionFragment b;

            public final void run()
            {
                com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem selectionhistoryitem = SelectionFragment.y(b).a(1);
                if (selectionhistoryitem == null || selectionhistoryitem.c == com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem.SelectionHistoryType.File)
                {
                    ByteBuffer bytebuffer = com.picsart.studio.editor.fragment.SelectionFragment.a(b, selectionhistoryitem);
                    Object obj1;
                    d d1;
                    Bitmap bitmap;
                    if (bytebuffer == null)
                    {
                        obj1 = SelectionFragment.P(b);
                    } else
                    {
                        obj1 = null;
                    }
                    if (obj1 != null && !((Bitmap) (obj1)).isRecycled() || bytebuffer != null)
                    {
                        if (obj1 != null)
                        {
                            Log.e("ex1", (new StringBuilder("undo bitmap w = ")).append(((Bitmap) (obj1)).getWidth()).append(" h = ").append(((Bitmap) (obj1)).getHeight()).toString());
                        }
                        SelectionFragment.y(b).a();
                        d1 = null;
                    } else
                    {
                        d1 = null;
                    }
                } else
                {
                    obj1 = selectionhistoryitem.b;
                    SelectionFragment.p(b).l.a = ((ArrayList) (obj1));
                    d1 = SelectionFragment.p(b).p();
                    obj1 = SelectionFragment.y(b).a(2);
                    bytebuffer = com.picsart.studio.editor.fragment.SelectionFragment.a(b, ((com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem) (obj1)));
                    if (bytebuffer == null)
                    {
                        bitmap = SelectionFragment.P(b);
                        obj1 = bitmap;
                        if (bitmap != null)
                        {
                            Log.e("ex1", (new StringBuilder("undo bitmap w = ")).append(bitmap.getWidth()).append(" h = ").append(bitmap.getHeight()).toString());
                            obj1 = bitmap;
                        }
                    } else
                    {
                        obj1 = null;
                    }
                    if (d1 != null && (obj1 != null && !((Bitmap) (obj1)).isRecycled() || bytebuffer != null))
                    {
                        SelectionFragment.y(b).a();
                        SelectionFragment.y(b).a();
                    } else
                    {
                        if (obj1 != null && !((Bitmap) (obj1)).isRecycled())
                        {
                            com.socialin.android.util.c.a(((Bitmap) (obj1)));
                        }
                        if (bytebuffer != null)
                        {
                            com.picsart.studio.editor.fragment.SelectionFragment.a(bytebuffer);
                        }
                        if (d1 != null)
                        {
                            obj1 = d1.b;
                            if (obj1 != null && !((Bitmap) (obj1)).isRecycled())
                            {
                                com.socialin.android.util.c.a(((Bitmap) (obj1)));
                            }
                            d1 = null;
                            bytebuffer = null;
                            obj1 = null;
                        } else
                        {
                            bytebuffer = null;
                            obj1 = null;
                        }
                    }
                }
                a.runOnUiThread(new Runnable(this, ((Bitmap) (obj1)), bytebuffer, d1, selectionhistoryitem) {

                    private Bitmap a;
                    private ByteBuffer b;
                    private d c;
                    private com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem d;
                    private _cls21 e;

                    public final void run()
                    {
                        if (!com.picsart.studio.editor.fragment.SelectionFragment.x(e.b)) goto _L2; else goto _L1
_L1:
                        if (a != null && !a.isRecycled())
                        {
                            com.socialin.android.util.c.a(a);
                        }
                        if (b != null)
                        {
                            com.picsart.studio.editor.fragment.SelectionFragment.a(b);
                        }
                        if (c != null)
                        {
                            Bitmap bitmap = c.b;
                            if (bitmap != null && !bitmap.isRecycled())
                            {
                                com.socialin.android.util.c.a(bitmap);
                            }
                        }
_L4:
                        return;
_L2:
                        e.b.d();
                        com.picsart.studio.editor.fragment.SelectionFragment.a(e.b, false);
                        if (a != null && !a.isRecycled() || b != null)
                        {
                            break; /* Loop/switch isn't completed */
                        }
                        Utils.a(e.a, 0x7f0805ca);
                        if (c != null)
                        {
                            Bitmap bitmap1 = c.b;
                            if (bitmap1 != null && !bitmap1.isRecycled())
                            {
                                com.socialin.android.util.c.a(bitmap1);
                                return;
                            }
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                        if (d == null || d.c != com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem.SelectionHistoryType.Mask || c != null)
                        {
                            break; /* Loop/switch isn't completed */
                        }
                        Utils.a(e.a, 0x7f0805ca);
                        if (a != null && !a.isRecycled())
                        {
                            com.socialin.android.util.c.a(a);
                        }
                        if (b != null)
                        {
                            com.picsart.studio.editor.fragment.SelectionFragment.a(b);
                            return;
                        }
                        if (true) goto _L4; else goto _L5
_L5:
                        if (a != null && !a.isRecycled())
                        {
                            SelectionDrawController selectiondrawcontroller = SelectionFragment.p(e.b);
                            Bitmap bitmap2 = a;
                            if (selectiondrawcontroller.a != null && !selectiondrawcontroller.a.isRecycled())
                            {
                                com.socialin.android.util.c.a(selectiondrawcontroller.a);
                            }
                            selectiondrawcontroller.a = bitmap2;
                        } else
                        {
                            SelectionDrawController selectiondrawcontroller1 = SelectionFragment.p(e.b);
                            ByteBuffer bytebuffer = b;
                            if (bytebuffer != null)
                            {
                                bytebuffer.position(0);
                                selectiondrawcontroller1.a.copyPixelsFromBuffer(bytebuffer);
                            }
                        }
                        if (b != null)
                        {
                            com.picsart.studio.editor.fragment.SelectionFragment.a(b);
                        }
                        if (d == null || d.c == com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem.SelectionHistoryType.File)
                        {
                            SelectionFragment.p(e.b).q();
                            SelectionFragment.p(e.b).a();
                            SelectionFragment.A(e.b);
                            return;
                        } else
                        {
                            e.b.a(c);
                            return;
                        }
                    }

            
            {
                e = _pcls21;
                a = bitmap;
                b = bytebuffer;
                c = d1;
                d = selectionhistoryitem;
                super();
            }
                });
            }

            
            {
                b = SelectionFragment.this;
                a = activity;
                super();
            }
        }, false, u);
        return true;
    }

    static LinearLayout c(SelectionFragment selectionfragment, View view)
    {
        return selectionfragment.d(view);
    }

    private SelectionView c(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 != null)
        {
            return (SelectionView)view1.findViewById(0x7f1005fa);
        } else
        {
            return null;
        }
    }

    static void c(SelectionFragment selectionfragment)
    {
        selectionfragment.a(true);
        g g1 = new g() {

        };
        SelectionDrawController selectiondrawcontroller = selectionfragment.w;
        Bitmap bitmap = selectionfragment.w.a;
        boolean flag;
        if (!selectionfragment.w.n())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g1.i = selectiondrawcontroller;
        g1.h = bitmap;
        g1.j = new Point(bitmap.getWidth(), bitmap.getHeight());
        g1.k = flag;
        g1.a = 4;
        g1.b = selectionfragment;
        g1.executeOnExecutor(selectionfragment.u, new Void[] {
            null
        });
        selectionfragment.a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    private void c(boolean flag)
    {
        View view = getView();
        if (view == null)
        {
            return;
        }
        RelativeLayout relativelayout = (RelativeLayout)view.findViewById(0x7f100605);
        i(view);
        if (relativelayout.getVisibility() == 8)
        {
            relativelayout.setVisibility(0);
            if (flag)
            {
                F.setAnimationListener(new android.view.animation.Animation.AnimationListener(relativelayout) {

                    private RelativeLayout a;

                    public final void onAnimationEnd(Animation animation)
                    {
                        a.clearAnimation();
                    }

                    public final void onAnimationRepeat(Animation animation)
                    {
                    }

                    public final void onAnimationStart(Animation animation)
                    {
                    }

            
            {
                a = relativelayout;
                super();
            }
                });
                relativelayout.startAnimation(F);
            }
            U = true;
            return;
        }
        G.setAnimationListener(new android.view.animation.Animation.AnimationListener(relativelayout) {

            private RelativeLayout a;

            public final void onAnimationEnd(Animation animation)
            {
                a.clearAnimation();
            }

            public final void onAnimationRepeat(Animation animation)
            {
            }

            public final void onAnimationStart(Animation animation)
            {
            }

            
            {
                a = relativelayout;
                super();
            }
        });
        relativelayout.setVisibility(8);
        if (flag)
        {
            relativelayout.startAnimation(G);
        }
        U = false;
    }

    private LinearLayout d(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 != null)
        {
            return (LinearLayout)view1.findViewById(0x7f100604);
        } else
        {
            return null;
        }
    }

    static void d(SelectionFragment selectionfragment)
    {
        selectionfragment.a(true);
        g g1 = new g() {

        };
        SelectionDrawController selectiondrawcontroller = selectionfragment.w;
        Bitmap bitmap = selectionfragment.w.a;
        g1.i = selectiondrawcontroller;
        g1.h = bitmap;
        g1.a = 1;
        g1.b = selectionfragment;
        g1.executeOnExecutor(selectionfragment.u, new Void[] {
            null
        });
        selectionfragment.a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    private RelativeLayout e(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 != null)
        {
            return (RelativeLayout)view1.findViewById(0x7f10059a);
        } else
        {
            return null;
        }
    }

    static void e(SelectionFragment selectionfragment)
    {
        RelativeLayout relativelayout = null;
        if (selectionfragment.x != null && !selectionfragment.x.isRecycled())
        {
            if (selectionfragment.w != null)
            {
                selectionfragment.A = selectionfragment.w.m;
                Object obj = selectionfragment.w;
                Bitmap bitmap = selectionfragment.x;
                RectF rectf = selectionfragment.y;
                if (((SelectionDrawController) (obj)).u != null)
                {
                    ((SelectionDrawController) (obj)).u.a();
                }
                android.content.Context context = ((SelectionDrawController) (obj)).i;
                RectF rectf1 = ((SelectionDrawController) (obj)).f;
                RectF rectf2 = new RectF();
                rectf2.left = rectf.left * rectf1.width() + rectf1.left;
                rectf2.right = rectf.right * rectf1.width() + rectf1.left;
                rectf2.top = rectf.top * rectf1.height() + rectf1.top;
                rectf2.bottom = rectf.bottom * rectf1.height() + rectf1.top;
                obj.u = new c(context, rectf2, ((SelectionDrawController) (obj)).f, bitmap);
                ((SelectionDrawController) (obj)).u.I = ((com.socialin.android.photo.select.d) (obj));
                selectionfragment.w.a(com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.ADD_DRAWABLE);
                selectionfragment.a(true, ((View) (null)));
                selectionfragment.a(((View) (null)), FragmentUIMode.ADD_DRAWABLE, true);
                if (selectionfragment.af != null)
                {
                    selectionfragment.af.a();
                }
                obj = selectionfragment.getView();
                if (obj != null)
                {
                    relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f100605);
                }
                if (relativelayout != null && relativelayout.getVisibility() == 0)
                {
                    selectionfragment.c(false);
                }
            }
            return;
        } else
        {
            Utils.a(selectionfragment.getActivity(), 0x7f0805ca);
            return;
        }
    }

    private void f(View view)
    {
        View view1;
        com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE fill_type;
        ImageButton imagebutton;
        int j1;
        j1 = 0x7f0204e4;
        view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 == null)
        {
            return;
        }
        view = w.m;
        fill_type = w.n;
        if (view == com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.ADD_DRAWABLE)
        {
            view = A;
        }
        imagebutton = (ImageButton)view1.findViewById(0x7f10059c);
        final class _cls27
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.values().length];
                try
                {
                    b[com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.FREE_CROP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.LASSO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    b[com.socialin.android.photo.select.SelectionDrawController.DRAW_MODE.SHAPE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                a = new int[com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.values().length];
                try
                {
                    a[com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.ADD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.CLEAR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.DEFAULT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.picsart.studio.editor.fragment._cls27.b[view.ordinal()];
        JVM INSTR tableswitch 1 3: default 96
    //                   1 108
    //                   2 142
    //                   3 220;
           goto _L1 _L2 _L3 _L4
_L1:
        int i1 = j1;
_L5:
        imagebutton.setImageResource(i1);
        return;
_L2:
        if (fill_type == com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.ADD)
        {
            i1 = 0x7f020310;
        } else
        {
            i1 = 0x7f020356;
        }
        view1.findViewById(0x7f10059d).setVisibility(0);
          goto _L5
_L3:
        com.picsart.studio.editor.fragment._cls27.a[fill_type.ordinal()];
        JVM INSTR tableswitch 1 3: default 176
    //                   1 196
    //                   2 204
    //                   3 212;
           goto _L6 _L7 _L8 _L9
_L9:
        break MISSING_BLOCK_LABEL_212;
_L6:
        i1 = 0x7f0204e4;
_L10:
        view1.findViewById(0x7f10059d).setVisibility(8);
          goto _L5
_L7:
        i1 = 0x7f0204cf;
          goto _L10
_L8:
        i1 = 0x7f0204eb;
          goto _L10
        i1 = 0x7f0204e0;
          goto _L10
_L4:
        if (w.r.s != com.socialin.android.photo.select.SelectionShapeDrawController.SelectionShapeType.RECTANGLE) goto _L12; else goto _L11
_L11:
        i1 = j1;
        com.picsart.studio.editor.fragment._cls27.a[fill_type.ordinal()];
        JVM INSTR tableswitch 1 3: default 276
    //                   1 295
    //                   2 303
    //                   3 280;
           goto _L13 _L14 _L15 _L16
_L16:
        break; /* Loop/switch isn't completed */
_L13:
        i1 = j1;
_L17:
        view1.findViewById(0x7f10059d).setVisibility(8);
          goto _L5
_L14:
        i1 = 0x7f0204d0;
          goto _L17
_L15:
        i1 = 0x7f0204ed;
          goto _L17
_L12:
        switch (com.picsart.studio.editor.fragment._cls27.a[fill_type.ordinal()])
        {
        default:
            i1 = j1;
            break;

        case 1: // '\001'
            i1 = 0x7f0204ce;
            break;

        case 2: // '\002'
            i1 = 0x7f0204e9;
            break;

        case 3: // '\003'
            i1 = 0x7f0204d1;
            break;
        }
        if (true) goto _L17; else goto _L18
_L18:
    }

    static void f(SelectionFragment selectionfragment)
    {
        selectionfragment.a(true);
        g g1 = new g() {

        };
        com.socialin.android.photo.freecrop.b b1 = selectionfragment.w.l;
        Point point = new Point(selectionfragment.w.a.getWidth(), selectionfragment.w.a.getHeight());
        boolean flag;
        if (!selectionfragment.w.n())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g1.g = b1;
        g1.j = point;
        g1.k = flag;
        g1.a = 3;
        g1.b = selectionfragment;
        g1.executeOnExecutor(selectionfragment.u, new Void[] {
            null
        });
        selectionfragment.a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    private void g(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 != null)
        {
            view = view1.findViewById(0x7f100066);
            if (view != null)
            {
                view.setEnabled(o());
            }
            view = view1.findViewById(0x7f100064);
            if (view != null)
            {
                view.setEnabled(o());
            }
            view = view1.findViewById(0x7f10006b);
            if (view != null)
            {
                boolean flag;
                if (x != null && !x.isRecycled())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setEnabled(flag);
            }
            view = view1.findViewById(0x7f100063);
            if (view != null)
            {
                view.setEnabled(o());
            }
            view = view1.findViewById(0x7f1005a1);
            if (view != null)
            {
                view.setEnabled(n());
            }
            view = view1.findViewById(0x7f100067);
            if (view != null)
            {
                view.setEnabled(o());
            }
            view = view1.findViewById(0x7f100069);
            if (view != null)
            {
                view.setEnabled(o());
            }
            view = view1.findViewById(0x7f10006c);
            if (view != null)
            {
                view.setEnabled(n());
            }
            view = view1.findViewById(0x7f100068);
            if (view != null)
            {
                view.setEnabled(o());
            }
            view = view1.findViewById(0x7f10006d);
            if (view != null)
            {
                view.setEnabled(o());
            }
            view = view1.findViewById(0x7f100065);
            if (view != null)
            {
                view.setEnabled(o());
            }
        }
    }

    static void g(SelectionFragment selectionfragment)
    {
        com.socialin.android.photo.select.g.a(selectionfragment. new Runnable() {

            final SelectionFragment a;

            public final void run()
            {
                Object obj = SelectionFragment.p(a).l;
                Bitmap bitmap;
                boolean flag;
                boolean flag1;
                if (SelectionFragment.p(a).n())
                {
                    bitmap = ((com.socialin.android.photo.freecrop.b) (obj)).a(SelectionFragment.p(a).a, SelectionFragment.p(a).b);
                } else
                {
                    bitmap = ((com.socialin.android.photo.freecrop.b) (obj)).a(SelectionFragment.p(a).a);
                }
                flag1 = ((com.socialin.android.photo.freecrop.b) (obj)).c;
                if (bitmap != null && !bitmap.isRecycled())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj = a.getActivity();
                if (com.picsart.studio.editor.fragment.SelectionFragment.x(a))
                {
                    if (bitmap != null && !bitmap.isRecycled())
                    {
                        com.socialin.android.util.c.a(bitmap);
                    }
                    return;
                } else
                {
                    ((Activity) (obj)).runOnUiThread(new Runnable(this, flag, bitmap, flag1, ((Activity) (obj))) {

                        private boolean a;
                        private Bitmap b;
                        private boolean c;
                        private Activity d;
                        private _cls11 e;

                        public final void run()
                        {
                            e.a.d();
                            if (a)
                            {
                                com.picsart.studio.editor.fragment.SelectionFragment.a(e.a, b);
                                return;
                            }
                            com.picsart.studio.editor.fragment.SelectionFragment.a(e.a, false);
                            if (c)
                            {
                                Utils.a(d, 0x7f0805ca);
                                return;
                            } else
                            {
                                SelectionFragment.K(e.a);
                                return;
                            }
                        }

            
            {
                e = _pcls11;
                a = flag;
                b = bitmap;
                c = flag1;
                d = activity;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        }, true, selectionfragment.u);
        selectionfragment.a(true);
        selectionfragment.a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    public static void h()
    {
        i++;
        Log.e("ex1", (new StringBuilder("ALLOCATE_BUFFERS_COUNT = ")).append(i).toString());
    }

    private void h(View view)
    {
        if (S && N > 0 && O > 0 && Q.x > 0 && Q.y > 0 && P.x > 0 && P.y > 0)
        {
            i(view);
            view = view.findViewById(0x7f100605);
            if (view != null)
            {
                if (U)
                {
                    view.setVisibility(0);
                    return;
                } else
                {
                    view.setVisibility(8);
                    return;
                }
            }
        }
    }

    static void h(SelectionFragment selectionfragment)
    {
        Object obj = selectionfragment.w.b;
        int i1 = ((Bitmap) (obj)).getWidth();
        int j1 = ((Bitmap) (obj)).getHeight();
        ByteBuffer bytebuffer = a(i1 * j1 * 4);
        bytebuffer.position(0);
        ((Bitmap) (obj)).copyPixelsToBuffer(bytebuffer);
        obj = selectionfragment. new Runnable(bytebuffer, i1, j1) {

            final ByteBuffer a;
            final SelectionFragment b;
            private int c;
            private int d;

            public final void run()
            {
                ImageOpCommon.invertRedMask(a, c, d);
                Activity activity = b.getActivity();
                if (activity == null || activity.isFinishing())
                {
                    com.picsart.studio.editor.fragment.SelectionFragment.a(a);
                    return;
                } else
                {
                    activity.runOnUiThread(new Runnable(this) {

                        private _cls10 a;

                        public final void run()
                        {
                            boolean flag = false;
                            a.a.position(0);
                            SelectionFragment.p(a.b).b.copyPixelsFromBuffer(a.a);
                            com.picsart.studio.editor.fragment.SelectionFragment.a(a.a);
                            com.picsart.studio.editor.fragment.SelectionFragment.a(a.b, false);
                            SelectionFragment.p(a.b).a();
                            com.socialin.android.photo.freecrop.b b1 = SelectionFragment.p(a.b).l;
                            com.socialin.android.photo.freecrop.c c1 = new com.socialin.android.photo.freecrop.c(b1);
                            c1.d = 3;
                            b1.a.add(c1);
                            if (!b1.b)
                            {
                                flag = true;
                            }
                            b1.b = flag;
                            SelectionFragment.A(a.b);
                        }

            
            {
                a = _pcls10;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                b = SelectionFragment.this;
                a = bytebuffer;
                c = i1;
                d = j1;
                super();
            }
        };
        selectionfragment.a(true);
        com.socialin.android.photo.select.g.a(((Runnable) (obj)), true, selectionfragment.u);
    }

    static String i()
    {
        return h;
    }

    private void i(View view)
    {
        if (!T)
        {
            View view1 = view;
            if (view == null)
            {
                view1 = getView();
            }
            if (view1 != null)
            {
                Object obj = getActivity();
                int k1 = getResources().getConfiguration().orientation;
                view = (RelativeLayout)view1.findViewById(0x7f100605);
                LinearLayout linearlayout = d(view1);
                RelativeLayout relativelayout = e(view1);
                ImageView imageview = (ImageView)view.findViewById(0x7f100607);
                float f4 = getResources().getDimension(0x7f0b010e);
                float f5 = getResources().getDimension(0x7f0b0106);
                float f1 = getResources().getDimension(0x7f0b010d);
                float f7 = getResources().getDimension(0x7f0b010c);
                float f2 = f1 * (float)q.length;
                float f6 = Utils.a(6F, ((android.content.Context) (obj)));
                int i1;
                int j1;
                int l1;
                if (k1 == 1)
                {
                    i1 = view1.getWidth();
                } else
                {
                    i1 = view1.getWidth() - linearlayout.getWidth() - relativelayout.getWidth();
                }
                j1 = -1;
                f1 = (float)i1 - 2.0F * f4;
                if (f2 < (float)i1 - 2.0F * f4)
                {
                    j1 = (int)f2;
                    f1 = f2;
                }
                obj = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
                obj.width = j1;
                obj.height = -2;
                j1 = (int)f4;
                l1 = (int)f4;
                if (k1 == 1)
                {
                    float f3 = (float)view1.getWidth() / (float)o.length / 2.0F;
                    f7 = f5 / 2.0F;
                    ((android.widget.RelativeLayout.LayoutParams)imageview.getLayoutParams()).setMargins((int)((f3 - f5 - f4) + f6), 0, 0, 0);
                    f1 = ((f3 - f7 - f4) + f6) / f1;
                    F = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, f1, 1, 0.0F);
                    F.setInterpolator(new LinearInterpolator());
                    F.setDuration(300L);
                    G = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, f1, 1, 0.0F);
                    G.setInterpolator(new LinearInterpolator());
                    G.setDuration(300L);
                    i1 = 0;
                } else
                {
                    i1 = (int)((float)view1.getHeight() / (float)o.length / 2.0F - f7 / 2.0F);
                    F = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.0F, 1, 0.5F);
                    F.setInterpolator(new LinearInterpolator());
                    F.setDuration(300L);
                    G = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.0F, 1, 0.5F);
                    G.setInterpolator(new LinearInterpolator());
                    G.setDuration(300L);
                }
                ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(j1, i1, l1, 0);
                view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                T = true;
                return;
            }
        }
    }

    static void i(SelectionFragment selectionfragment)
    {
        com.socialin.android.photo.select.g.a(selectionfragment. new Runnable() {

            final SelectionFragment a;

            public final void run()
            {
                Object obj1 = null;
                boolean flag1 = true;
                Activity activity = a.getActivity();
                if (activity != null && !activity.isFinishing())
                {
                    Object obj2 = SelectionFragment.p(a).l;
                    Object obj;
                    boolean flag;
                    boolean flag2;
                    if (SelectionFragment.p(a).n())
                    {
                        obj = ((com.socialin.android.photo.freecrop.b) (obj2)).a(SelectionFragment.p(a).a, SelectionFragment.p(a).b);
                    } else
                    {
                        obj = ((com.socialin.android.photo.freecrop.b) (obj2)).a(SelectionFragment.p(a).a);
                    }
                    flag2 = ((com.socialin.android.photo.freecrop.b) (obj2)).c;
                    if (obj != null && !((Bitmap) (obj)).isRecycled())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (obj != null && !((Bitmap) (obj)).isRecycled())
                    {
                        com.socialin.android.util.c.a(((Bitmap) (obj)));
                    }
                    if (!com.picsart.studio.editor.fragment.SelectionFragment.x(a))
                    {
                        if (!flag)
                        {
                            activity.runOnUiThread(new Runnable(this, flag2, activity) {

                                private boolean a;
                                private Activity b;
                                private _cls14 c;

                                public final void run()
                                {
                                    c.a.d();
                                    com.picsart.studio.editor.fragment.SelectionFragment.a(c.a, false);
                                    if (a)
                                    {
                                        Utils.a(b, 0x7f0805ca);
                                        return;
                                    } else
                                    {
                                        SelectionFragment.K(c.a);
                                        return;
                                    }
                                }

            
            {
                c = _pcls14;
                a = flag;
                b = activity;
                super();
            }
                            });
                            return;
                        }
                        Bitmap bitmap = SelectionFragment.p(a).a;
                        obj2 = SelectionFragment.p(a).b;
                        int i1 = bitmap.getWidth();
                        int j1 = bitmap.getHeight();
                        obj = com.socialin.android.photo.view.a.b(i1, j1);
                        Bitmap bitmap1 = com.socialin.android.util.c.a(((Point) (obj)).x, ((Point) (obj)).y, android.graphics.Bitmap.Config.ARGB_8888);
                        if (bitmap1 != null)
                        {
                            bitmap1.eraseColor(0);
                            obj = new Canvas(bitmap1);
                            obj1 = new Paint();
                            ((Paint) (obj1)).setFilterBitmap(true);
                            ((Canvas) (obj)).drawBitmap(((Bitmap) (obj2)), new Rect(0, 0, i1, j1), new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight()), ((Paint) (obj1)));
                            ((Paint) (obj1)).setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
                            ((Paint) (obj1)).setColor(0xff000000);
                            ((Canvas) (obj)).drawPaint(((Paint) (obj1)));
                            obj = com.socialin.android.util.w.a(com.socialin.android.photo.freecrop.b.a(SelectionFragment.r(a)), bitmap1);
                            obj1 = com.socialin.android.util.w.a(com.socialin.android.photo.freecrop.b.a(SelectionFragment.r(a)), bitmap);
                            com.socialin.android.util.c.a(bitmap1);
                            com.picsart.studio.editor.fragment.SelectionFragment.b(a, com.socialin.android.util.w.a(com.socialin.android.photo.freecrop.b.a(SelectionFragment.r(a)), ((Bitmap) (obj2))));
                            SelectionFragment.L(a);
                        } else
                        {
                            obj = null;
                            flag1 = false;
                        }
                        if (activity != null && !activity.isFinishing())
                        {
                            activity.runOnUiThread(new Runnable(this, flag1, ((HashMap) (obj1)), ((HashMap) (obj))) {

                                private boolean a;
                                private HashMap b;
                                private HashMap c;
                                private _cls14 d;

                                public final void run()
                                {
                                    if (com.picsart.studio.editor.fragment.SelectionFragment.x(d.a))
                                    {
                                        return;
                                    }
                                    Activity activity = d.a.getActivity();
                                    d.a.d();
                                    com.picsart.studio.editor.fragment.SelectionFragment.a(d.a, false);
                                    if (a)
                                    {
                                        com.picsart.studio.editor.fragment.SelectionFragment.a(d.a, b, c);
                                        return;
                                    } else
                                    {
                                        Utils.a(activity, 0x7f0805ca);
                                        return;
                                    }
                                }

            
            {
                d = _pcls14;
                a = flag;
                b = hashmap;
                c = hashmap1;
                super();
            }
                            });
                            return;
                        }
                    }
                }
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        }, true, selectionfragment.u);
        selectionfragment.a(true);
        selectionfragment.a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    private void j()
    {
        Utils.a(getActivity(), 0x7f08041f);
        w.q();
        w.a();
        if (w.n == com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.CLEAR)
        {
            w.a(com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.ADD);
            f(((View) (null)));
        }
        g(((View) (null)));
    }

    static void j(SelectionFragment selectionfragment)
    {
        com.socialin.android.photo.select.g.a(selectionfragment. new Runnable() {

            final SelectionFragment a;

            public final void run()
            {
                Bitmap bitmap;
                Activity activity;
                boolean flag;
                flag = false;
                activity = a.getActivity();
                SelectionDrawController selectiondrawcontroller = SelectionFragment.p(a);
                selectiondrawcontroller.z = false;
                boolean flag1;
                if (selectiondrawcontroller.n())
                {
                    bitmap = selectiondrawcontroller.l.a(selectiondrawcontroller.a, selectiondrawcontroller.b);
                } else
                {
                    bitmap = selectiondrawcontroller.l.a(selectiondrawcontroller.a);
                }
                if (bitmap != null) goto _L2; else goto _L1
_L1:
                selectiondrawcontroller.z = selectiondrawcontroller.l.c;
_L4:
                flag1 = SelectionFragment.p(a).z;
                if (activity != null && !activity.isFinishing())
                {
                    activity.runOnUiThread(new Runnable(this, flag, flag1) {

                        private boolean a;
                        private boolean b;
                        private _cls15 c;

                        public final void run()
                        {
                            if (!com.picsart.studio.editor.fragment.SelectionFragment.x(c.a))
                            {
                                Activity activity = c.a.getActivity();
                                c.a.d();
                                com.picsart.studio.editor.fragment.SelectionFragment.a(c.a, false);
                                if (!a)
                                {
                                    if (b)
                                    {
                                        Utils.a(activity, 0x7f0805ca);
                                        return;
                                    } else
                                    {
                                        SelectionFragment.K(c.a);
                                        return;
                                    }
                                }
                            }
                        }

            
            {
                c = _pcls15;
                a = flag;
                b = flag1;
                super();
            }
                    });
                }
                return;
_L2:
                if (com.socialin.android.photo.clipart.e.a(activity, bitmap, "selectionMainFragment") != null)
                {
                    flag = true;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = SelectionFragment.this;
                super();
            }
        }, true, selectionfragment.u);
        selectionfragment.a(true);
        selectionfragment.a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    private void k()
    {
        if (M)
        {
            return;
        } else
        {
            com.socialin.android.photo.select.g.a(new Runnable() {

                final SelectionFragment a;

                public final void run()
                {
                    Activity activity = a.getActivity();
                    if (activity == null || activity.isFinishing())
                    {
                        return;
                    } else
                    {
                        activity.runOnUiThread(new Runnable(this) {

                            private _cls13 a;

                            public final void run()
                            {
                                com.picsart.studio.editor.fragment.SelectionFragment.a(a.a, false);
                                SelectionFragment.p(a.a).q();
                                SelectionFragment.p(a.a).t.invalidate();
                                SelectionFragment.A(a.a);
                                if (SelectionFragment.p(a.a).n == com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.CLEAR)
                                {
                                    SelectionFragment.p(a.a).a(com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.ADD);
                                    SelectionFragment.z(a.a);
                                }
                            }

            
            {
                a = _pcls13;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                a = SelectionFragment.this;
                super();
            }
            }, false, u);
            a(true);
            return;
        }
    }

    static void k(SelectionFragment selectionfragment)
    {
        selectionfragment.k();
    }

    static void l(SelectionFragment selectionfragment)
    {
        if (selectionfragment.k.a.isEmpty())
        {
            selectionfragment.k();
        } else
        if (selectionfragment.b(true))
        {
            selectionfragment.a(0x7f080679, ((android.content.DialogInterface.OnCancelListener) (null)));
            return;
        }
    }

    private boolean l()
    {
        Activity activity = getActivity();
        return activity == null || activity.isFinishing();
    }

    private void m()
    {
        Activity activity = getActivity();
        if (activity != null)
        {
            activity.setResult(0);
            activity.finish();
        }
    }

    static void m(SelectionFragment selectionfragment)
    {
        selectionfragment.c(true);
    }

    static Bitmap n(SelectionFragment selectionfragment)
    {
        return selectionfragment.e;
    }

    private boolean n()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (w == null)
            {
                break label0;
            }
            if (k.a.isEmpty())
            {
                flag = flag1;
                if (!w.o())
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    static Bitmap o(SelectionFragment selectionfragment)
    {
        return selectionfragment.x;
    }

    private boolean o()
    {
        if (w != null)
        {
            return w.o();
        } else
        {
            return false;
        }
    }

    static SelectionDrawController p(SelectionFragment selectionfragment)
    {
        return selectionfragment.w;
    }

    private void p()
    {
        Bitmap bitmap = w.a;
        com.socialin.android.photo.select.g.a(new Runnable(getActivity(), bitmap) {

            final SelectionFragment a;
            private Activity b;
            private Bitmap c;

            public final void run()
            {
                String s1 = com.socialin.android.photo.freecrop.b.a(SelectionFragment.r(a));
                if (s1 != null)
                {
                    File file = new File(s1);
                    boolean flag1 = false;
                    boolean flag = flag1;
                    if (c != null)
                    {
                        flag = flag1;
                        if (!c.isRecycled())
                        {
                            com.socialin.android.util.w.a(s1, c);
                            flag = true;
                        }
                    }
                    if (flag)
                    {
                        Object obj = SelectionFragment.y(a).a(new com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem(file));
                        if (obj != null && ((com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem) (obj)).c == com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem.SelectionHistoryType.File)
                        {
                            obj = ((com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem) (obj)).a;
                            if (obj != null)
                            {
                                ((File) (obj)).delete();
                            }
                        }
                        b.runOnUiThread(new Runnable(this) {

                            private _cls20 a;

                            public final void run()
                            {
                                SelectionFragment.A(a.a);
                            }

            
            {
                a = _pcls20;
                super();
            }
                        });
                    }
                }
            }

            
            {
                a = SelectionFragment.this;
                b = activity;
                c = bitmap;
                super();
            }
        }, true, u);
    }

    private Bitmap q()
    {
        if (aa != null)
        {
            return com.socialin.android.util.c.b(aa, android.graphics.Bitmap.Config.ARGB_8888);
        } else
        {
            return null;
        }
    }

    static boolean q(SelectionFragment selectionfragment)
    {
        return selectionfragment.ad;
    }

    static String r(SelectionFragment selectionfragment)
    {
        return selectionfragment.H;
    }

    static HashMap s(SelectionFragment selectionfragment)
    {
        return selectionfragment.ab;
    }

    static boolean t(SelectionFragment selectionfragment)
    {
        return selectionfragment.b(((View) (null)));
    }

    static Point u(SelectionFragment selectionfragment)
    {
        return selectionfragment.Q;
    }

    static Point v(SelectionFragment selectionfragment)
    {
        return selectionfragment.P;
    }

    static int w(SelectionFragment selectionfragment)
    {
        return selectionfragment.v;
    }

    static boolean x(SelectionFragment selectionfragment)
    {
        return selectionfragment.l();
    }

    static SelectionHistoryStack y(SelectionFragment selectionfragment)
    {
        return selectionfragment.k;
    }

    static void z(SelectionFragment selectionfragment)
    {
        selectionfragment.f(((View) (null)));
    }

    public final void a(Bitmap bitmap)
    {
        if (l())
        {
            if (bitmap != null && !bitmap.isRecycled())
            {
                com.socialin.android.util.c.a(bitmap);
            }
            return;
        }
        Activity activity = getActivity();
        d();
        if (bitmap == null || bitmap.isRecycled())
        {
            if (activity != null)
            {
                Utils.a(activity, 0x7f0805ca);
            }
            m();
            return;
        } else
        {
            a(bitmap, ((View) (null)));
            return;
        }
    }

    public final void a(Bitmap bitmap, boolean flag, Bitmap bitmap1, boolean flag1, RectF rectf)
    {
        if (l())
        {
            if (bitmap != null && !bitmap.isRecycled())
            {
                com.socialin.android.util.c.a(bitmap);
            }
            if (bitmap1 != null && !bitmap1.isRecycled())
            {
                com.socialin.android.util.c.a(bitmap1);
            }
        } else
        {
            d();
            a(false);
            if (bitmap1 == null && !w.n() || bitmap == null)
            {
                rectf = getActivity();
                if (flag || flag1)
                {
                    Utils.a(rectf, 0x7f0805ca);
                } else
                {
                    j();
                }
                if (bitmap1 != null && !bitmap1.isRecycled())
                {
                    com.socialin.android.util.c.a(bitmap1);
                }
                if (bitmap != null && !bitmap.isRecycled())
                {
                    com.socialin.android.util.c.a(bitmap);
                    return;
                }
            } else
            {
                a(bitmap, flag, rectf);
                a(bitmap1, flag1);
                return;
            }
        }
    }

    public final void a(d d1)
    {
        if (!l()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        d();
        if (w == null) goto _L1; else goto _L3
_L3:
        Activity activity;
        activity = getActivity();
        a(false);
        if (d1 != null) goto _L5; else goto _L4
_L4:
        Utils.a(activity, 0x7f0805ca);
_L7:
        g(((View) (null)));
        w.a();
        return;
_L5:
        SelectionDrawController selectiondrawcontroller = w;
        Canvas canvas = d1.a;
        d1 = d1.b;
        if (canvas != null && d1 != null)
        {
            if (selectiondrawcontroller.b != null && !selectiondrawcontroller.b.isRecycled())
            {
                com.socialin.android.util.c.a(selectiondrawcontroller.b);
            }
            selectiondrawcontroller.c = canvas;
            selectiondrawcontroller.b = d1;
        }
        if (!o() && w.n == com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.CLEAR)
        {
            w.a(com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.ADD);
            f(((View) (null)));
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final boolean a(Bitmap bitmap, boolean flag)
    {
        if (l())
        {
            if (bitmap != null && !bitmap.isRecycled())
            {
                com.socialin.android.util.c.a(bitmap);
            }
            return false;
        }
        a(false);
        d();
        Activity activity = getActivity();
        if (bitmap != null || w.n())
        {
            if (w != null)
            {
                int i1;
                if (bitmap == null)
                {
                    i1 = w.a(w.b);
                } else
                {
                    i1 = w.a(bitmap);
                    com.socialin.android.util.c.a(bitmap);
                }
                g(((View) (null)));
                if (i1 > 0)
                {
                    if (w.n == com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.CLEAR)
                    {
                        w.a(com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.ADD);
                        f(((View) (null)));
                    }
                    bitmap = w.q();
                    if (bitmap.size() > 0)
                    {
                        k.b(bitmap);
                    }
                    p();
                } else
                {
                    j();
                }
                w.a();
            }
            return true;
        }
        if (flag)
        {
            Utils.a(activity, 0x7f0805ca);
            return false;
        } else
        {
            j();
            return false;
        }
    }

    public final boolean a(Bitmap bitmap, boolean flag, RectF rectf)
    {
        if (l())
        {
            if (bitmap != null && !bitmap.isRecycled())
            {
                com.socialin.android.util.c.a(bitmap);
            }
            return false;
        }
        d();
        a(false);
        if (bitmap == null)
        {
            bitmap = getActivity();
            if (flag)
            {
                Utils.a(bitmap, 0x7f0805ca);
                return false;
            } else
            {
                j();
                return false;
            }
        } else
        {
            x = bitmap;
            y = rectf;
            g(((View) (null)));
            return true;
        }
    }

    protected final ViewGroup b()
    {
        if (getView() != null)
        {
            return (ViewGroup)getView().findViewById(0x7f1003fb);
        } else
        {
            return null;
        }
    }

    public final void b(Bitmap bitmap)
    {
_L2:
        return;
        if (bitmap == null || aa != null) goto _L2; else goto _L1
_L1:
        boolean flag;
        aa = bitmap;
        bitmap = k;
        if (((SelectionHistoryStack) (bitmap)).a == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        bitmap = ((SelectionHistoryStack) (bitmap)).a.iterator();
        do
        {
            if (!bitmap.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
        } while (((com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem)bitmap.next()).c != com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem.SelectionHistoryType.File);
        flag = true;
_L4:
        if (!flag)
        {
            a(q(), ((View) (null)));
            return;
        }
        if (true) goto _L2; else goto _L3
_L3:
        flag = false;
          goto _L4
        flag = false;
          goto _L4
    }

    public final void d()
    {
        if (L != null && L.isShowing())
        {
            myobfuscated.f.m.b(getActivity(), L);
            I = false;
        }
        L = null;
    }

    public final void e()
    {
        if (l())
        {
            return;
        } else
        {
            g(((View) (null)));
            return;
        }
    }

    public final c f()
    {
        if (w != null)
        {
            return w.u;
        } else
        {
            return null;
        }
    }

    public final View g()
    {
        return c(((View) (null)));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (w != null)
        {
            if (I)
            {
                L = null;
                a(K, J);
            }
            return;
        } else
        {
            d();
            a(0x7f080548, ((android.content.DialogInterface.OnCancelListener) (null)));
            return;
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        if (w != null)
        {
            a(i1, j1, intent, Z);
            return;
        } else
        {
            V = intent;
            W = i1;
            X = j1;
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        i = 0;
        Activity activity = getActivity();
        u = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
        long l1 = System.currentTimeMillis();
        String s2 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(activity.getString(0x7f0808fb)).append("/").toString();
        String s1 = (new StringBuilder()).append(s2).append(activity.getString(0x7f08096e)).append("/").append(l1).append("/").toString();
        File file = new File(s2);
        File file1 = new File(s1);
        int i1 = 0;
        do
        {
label0:
            {
                Object obj = s1;
                if (i1 < 2)
                {
                    obj = (new File[] {
                        file, file1
                    })[i1];
                    if (((File) (obj)).exists() || ((File) (obj)).mkdirs())
                    {
                        break label0;
                    }
                    Utils.b(activity, (new StringBuilder()).append(activity.getString(0x7f080407)).append("  ").append(s2).toString());
                    obj = null;
                }
                H = ((String) (obj));
                v = PicsartContext.a(activity);
                ac = new TimeCalculator();
                if (bundle == null)
                {
                    f = new TimeCalculator();
                } else
                {
                    f = (TimeCalculator)bundle.getParcelable("time_calculator");
                }
                if (bundle != null)
                {
                    if (bundle.containsKey("selectionMaskBufferData"))
                    {
                        Y = (HashMap)bundle.getSerializable("selectionMaskBufferData");
                        Z = true;
                    }
                    if (bundle.containsKey("selectionCurrentDirPath"))
                    {
                        H = bundle.getString("selectionCurrentDirPath");
                    }
                }
                if (bundle != null)
                {
                    if (bundle.containsKey("origBufferData"))
                    {
                        ab = (HashMap)bundle.getSerializable("origBufferData");
                    }
                    if (bundle.containsKey("editing_data"))
                    {
                        d = (EditingData)bundle.getParcelable("editing_data");
                    }
                    e = com.socialin.android.util.w.a(ab, v, 0);
                    if (bundle.containsKey("SelectionHistoryStack"))
                    {
                        Object obj1 = bundle.getStringArrayList("SelectionHistoryStack");
                        if (obj1 != null)
                        {
                            k = SelectionHistoryStack.a(((ArrayList) (obj1)));
                            i1 = bundle.getInt("origSizeWidth");
                            int j1 = bundle.getInt("origSizeHeight");
                            if (((ArrayList) (obj1)).size() > 0 && i1 > 0 && j1 > 0)
                            {
                                obj1 = (String)((ArrayList) (obj1)).get(((ArrayList) (obj1)).size() - 1);
                                bundle = new HashMap();
                                bundle.put("width", Integer.valueOf(i1));
                                bundle.put("height", Integer.valueOf(j1));
                                bundle.put("path", obj1);
                                obj1 = new g() {

                                };
                                i1 = v;
                                obj1.c = null;
                                obj1.d = 0;
                                obj1.e = bundle;
                                obj1.f = i1;
                                obj1.a = 0;
                                obj1.b = this;
                                ((g) (obj1)).executeOnExecutor(u, new Void[] {
                                    null
                                });
                            }
                            b(e);
                        } else
                        {
                            b(e);
                        }
                    }
                } else
                {
                    if (e != null)
                    {
                        (new ModernAsyncTask(new File(com.socialin.android.util.x.a(getActivity()), String.valueOf(System.currentTimeMillis()))) {

                            private File a;
                            private SelectionFragment b;

                            protected final Object doInBackground(Object aobj[])
                            {
                                aobj = a.getPath();
                                Bitmap bitmap = com.picsart.studio.editor.fragment.SelectionFragment.n(b);
                                b.getActivity();
                                return com.socialin.android.util.w.a(((String) (aobj)), bitmap);
                            }

                            protected final void onPostExecute(Object obj2)
                            {
                                obj2 = (HashMap)obj2;
                                com.picsart.studio.editor.fragment.SelectionFragment.a(b, ((HashMap) (obj2)));
                            }

            
            {
                b = SelectionFragment.this;
                a = file;
                super();
            }
                        }).executeOnExecutor(u, new Void[] {
                            null
                        });
                    }
                    b(e);
                }
                c = true;
                return;
            }
            i1++;
        } while (true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = getActivity();
        B = AnimationUtils.loadAnimation(bundle, 0x7f040033);
        C = AnimationUtils.loadAnimation(bundle, 0x7f040034);
        D = AnimationUtils.loadAnimation(bundle, 0x7f04002f);
        E = AnimationUtils.loadAnimation(bundle, 0x7f040030);
        viewgroup = layoutinflater.inflate(0x7f030117, viewgroup, false);
        R = false;
        T = false;
        N = 0;
        O = 0;
        P.set(0, 0);
        Q.set(0, 0);
        S = false;
        if (w == null) goto _L2; else goto _L1
_L1:
        a(viewgroup);
        a(viewgroup, layoutinflater);
_L4:
        layoutinflater = d(viewgroup);
        layoutinflater.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(layoutinflater) {

            private LinearLayout a;
            private SelectionFragment b;

            public final void onGlobalLayout()
            {
                if (SelectionFragment.t(b))
                {
                    com.picsart.studio.editor.fragment.SelectionFragment.a(a, this);
                }
            }

            
            {
                b = SelectionFragment.this;
                a = linearlayout;
                super();
            }
        });
        viewgroup.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(viewgroup) {

            private View a;
            private SelectionFragment b;

            public final void onGlobalLayout()
            {
                if (SelectionFragment.u(b).x == 0)
                {
                    SelectionFragment.u(b).x = a.getWidth();
                }
                if (SelectionFragment.u(b).y == 0)
                {
                    SelectionFragment.u(b).y = a.getHeight();
                }
                if (SelectionFragment.u(b).x > 0 && SelectionFragment.u(b).y > 0)
                {
                    com.picsart.studio.editor.fragment.SelectionFragment.a(a, this);
                }
                com.picsart.studio.editor.fragment.SelectionFragment.a(b, a);
            }

            
            {
                b = SelectionFragment.this;
                a = view;
                super();
            }
        });
        layoutinflater = e(viewgroup);
        layoutinflater.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(layoutinflater, viewgroup) {

            private View a;
            private View b;
            private SelectionFragment c;

            public final void onGlobalLayout()
            {
                if (SelectionFragment.v(c).x == 0)
                {
                    SelectionFragment.v(c).x = a.getWidth();
                }
                if (SelectionFragment.v(c).y == 0)
                {
                    SelectionFragment.v(c).y = a.getHeight();
                }
                if (SelectionFragment.v(c).x > 0 && SelectionFragment.v(c).y > 0)
                {
                    com.picsart.studio.editor.fragment.SelectionFragment.a(a, this);
                }
                com.picsart.studio.editor.fragment.SelectionFragment.a(c, b);
            }

            
            {
                c = SelectionFragment.this;
                a = view;
                b = view1;
                super();
            }
        });
        return viewgroup;
_L2:
        layoutinflater = q();
        if (layoutinflater != null && !layoutinflater.isRecycled())
        {
            a(layoutinflater, viewgroup);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onPause()
    {
        super.onPause();
        ac.b();
        f.b();
        if (d != null)
        {
            EditingData editingdata = d;
            editingdata.c = (int)((long)editingdata.c + ac.d());
        }
    }

    public void onResume()
    {
        super.onResume();
        f.c();
        ac.a();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        SelectionHistoryStack selectionhistorystack = k;
        ArrayList arraylist = new ArrayList(selectionhistorystack.b);
        for (int i1 = 0; i1 < selectionhistorystack.a.size(); i1++)
        {
            com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem selectionhistoryitem = (com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem)selectionhistorystack.a.get(i1);
            if (selectionhistoryitem.c == com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem.SelectionHistoryType.File)
            {
                arraylist.add(selectionhistoryitem.a.getAbsolutePath());
            }
        }

        bundle.putStringArrayList("SelectionHistoryStack", arraylist);
        if (w != null)
        {
            Bitmap bitmap = w.a;
            if (bitmap != null && !bitmap.isRecycled())
            {
                bundle.putInt("origSizeWidth", bitmap.getWidth());
                bundle.putInt("origSizeHeight", bitmap.getHeight());
            }
        }
        bundle.putString("selectionCurrentDirPath", H);
        if (Y != null)
        {
            bundle.putSerializable("selectionMaskBufferData", Y);
        }
        if (ab == null)
        {
            String s1 = (new File(com.socialin.android.util.x.a(getActivity()), String.valueOf(System.currentTimeMillis()))).getPath();
            Bitmap bitmap1 = e;
            getActivity();
            ab = com.socialin.android.util.w.a(s1, bitmap1);
        }
        bundle.putSerializable("origBufferData", ab);
        if (d != null)
        {
            bundle.putParcelable("editing_data", d);
        }
        if (f != null)
        {
            bundle.putParcelable("time_calculator", f);
        }
    }

    public void onStop()
    {
        super.onStop();
        Activity activity = getActivity();
        if (activity != null && activity.isFinishing())
        {
            com.socialin.android.photo.select.g.a(new Runnable() {

                private SelectionFragment a;

                public final void run()
                {
                    if (com.picsart.studio.editor.fragment.SelectionFragment.o(a) != null && !com.picsart.studio.editor.fragment.SelectionFragment.o(a).isRecycled())
                    {
                        com.socialin.android.util.c.a(com.picsart.studio.editor.fragment.SelectionFragment.o(a));
                    }
                    if (SelectionFragment.p(a) != null)
                    {
                        SelectionDrawController selectiondrawcontroller = SelectionFragment.p(a);
                        if (selectiondrawcontroller.b != null && !selectiondrawcontroller.b.isRecycled())
                        {
                            selectiondrawcontroller.b.recycle();
                        }
                        if (selectiondrawcontroller.p != null)
                        {
                            com.socialin.android.photo.select.m m1 = selectiondrawcontroller.p;
                            m1.d();
                            if (m1.c != null)
                            {
                                m1.c.a();
                            }
                            if (m1.d != null)
                            {
                                m1.d.a();
                            }
                        }
                        if (selectiondrawcontroller.u != null)
                        {
                            selectiondrawcontroller.u.a();
                        }
                    }
                    if (SelectionFragment.q(a) && SelectionFragment.p(a) != null)
                    {
                        Bitmap bitmap = SelectionFragment.p(a).a;
                        if (bitmap != null && !bitmap.isRecycled())
                        {
                            com.socialin.android.util.c.a(bitmap);
                        }
                    }
                    if (SelectionFragment.r(a) != null)
                    {
                        Utils.a(new File(SelectionFragment.r(a)));
                    }
                    if (SelectionFragment.s(a) != null && (new File((String)SelectionFragment.s(a).get("path"))).delete())
                    {
                        Log.e("ex1", "Selection file deleted");
                    }
                }

            
            {
                a = SelectionFragment.this;
                super();
            }
            }, false, u);
        }
    }


    private class FragmentUIMode extends Enum
    {

        private static final FragmentUIMode $VALUES[];
        public static final FragmentUIMode ADD_DRAWABLE;
        public static final FragmentUIMode SELECTION;

        public static FragmentUIMode valueOf(String s1)
        {
            return (FragmentUIMode)Enum.valueOf(com/picsart/studio/editor/fragment/SelectionFragment$FragmentUIMode, s1);
        }

        public static FragmentUIMode[] values()
        {
            return (FragmentUIMode[])$VALUES.clone();
        }

        static 
        {
            SELECTION = new FragmentUIMode("SELECTION", 0);
            ADD_DRAWABLE = new FragmentUIMode("ADD_DRAWABLE", 1);
            $VALUES = (new FragmentUIMode[] {
                SELECTION, ADD_DRAWABLE
            });
        }

        private FragmentUIMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
