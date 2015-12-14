// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.MotionView;
import com.picsart.studio.editor.view.j;
import com.picsart.studio.editor.view.k;
import com.picsart.studio.editor.view.l;
import com.picsart.studio.utils.TimeCalculator;
import com.picsart.studio.view.FloatSeekBar;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.motion.MotionDrawer;
import com.socialin.android.photo.picsinphoto.f;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.a;
import com.socialin.android.util.d;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class MotionFragment extends i
    implements j, l
{

    private MotionView c;
    private Bitmap d;
    private ProgressBar e;
    private boolean f;
    private ModernAsyncTask i;
    private View j;
    private View k;
    private TimeCalculator l;
    private View m;
    private TextView n;
    private int o;
    private View p;
    private Spinner q;
    private Button r;
    private int s;
    private ArrayList t;
    private List u;
    private MotionMode v;
    private boolean w;
    private boolean x;

    public MotionFragment()
    {
        o = 15;
        q = null;
        s = 0;
        t = null;
        u = null;
        v = MotionMode.LINEAR;
        w = false;
        x = false;
    }

    static int a(MotionFragment motionfragment)
    {
        return motionfragment.o;
    }

    static int a(MotionFragment motionfragment, int i1)
    {
        motionfragment.o = i1;
        return i1;
    }

    private void a(int i1)
    {
        s = i1;
        r.setText((CharSequence)t.get(i1));
        c.setBlendModeXfermode(com.socialin.android.util.d.a(((Integer)u.get(i1)).intValue()));
    }

    private void a(FrameLayout framelayout)
    {
        if (j != null)
        {
            framelayout.removeView(j);
        }
        j = getActivity().getLayoutInflater().inflate(0x7f03016a, framelayout, false);
        j.setBackgroundColor(Color.argb(178, 0, 0, 0));
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)j.getLayoutParams();
        j.setLayoutParams(layoutparams);
        framelayout.addView(j);
        j.setOnClickListener(new android.view.View.OnClickListener(framelayout) {

            private FrameLayout a;
            private MotionFragment b;

            public final void onClick(View view)
            {
                a.removeView(com.picsart.studio.editor.fragment.MotionFragment.j(b));
                com.picsart.studio.editor.fragment.MotionFragment.k(b);
            }

            
            {
                b = MotionFragment.this;
                a = framelayout;
                super();
            }
        });
    }

    static void a(MotionFragment motionfragment, FrameLayout framelayout)
    {
        motionfragment.a(framelayout);
    }

    static TextView b(MotionFragment motionfragment)
    {
        return motionfragment.n;
    }

    static void b(MotionFragment motionfragment, int i1)
    {
        motionfragment.a(i1);
    }

    static MotionView c(MotionFragment motionfragment)
    {
        return motionfragment.c;
    }

    private void c(boolean flag)
    {
        if (flag)
        {
            p.setVisibility(0);
            m.setVisibility(0);
            m.setBackgroundResource(0x7f0205a9);
            return;
        } else
        {
            p.setVisibility(4);
            m.setVisibility(4);
            m.setBackgroundResource(0);
            return;
        }
    }

    static TimeCalculator d(MotionFragment motionfragment)
    {
        return motionfragment.l;
    }

    static boolean e(MotionFragment motionfragment)
    {
        return motionfragment.f;
    }

    static boolean f(MotionFragment motionfragment)
    {
        motionfragment.f = true;
        return true;
    }

    static ProgressBar g(MotionFragment motionfragment)
    {
        return motionfragment.e;
    }

    static void h(MotionFragment motionfragment)
    {
        motionfragment.j();
    }

    static Spinner i(MotionFragment motionfragment)
    {
        return motionfragment.q;
    }

    static View j(MotionFragment motionfragment)
    {
        return motionfragment.j;
    }

    private void j()
    {
        i = (new ModernAsyncTask() {

            private MotionFragment a;

            protected final Object doInBackground(Object aobj[])
            {
                if (com.picsart.studio.editor.fragment.MotionFragment.c(a) == null)
                {
                    return null;
                } else
                {
                    return com.picsart.studio.editor.fragment.MotionFragment.c(a).i();
                }
            }

            protected final volatile void onCancelled(Object obj)
            {
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Bitmap)obj;
                if (obj != null)
                {
                    com.picsart.studio.editor.fragment.MotionFragment.c(a).g();
                    com.picsart.studio.editor.fragment.MotionFragment.c(a).r.b();
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolMotionCloseEvent(com.picsart.studio.editor.e.a().e.a, "done", (int)com.picsart.studio.editor.fragment.MotionFragment.d(a).d()));
                    a.g.a(a, ((Bitmap) (obj)), RasterAction.create(((Bitmap) (obj)), com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
                }
            }

            
            {
                a = MotionFragment.this;
                super();
            }
        }).execute(new Void[0]);
    }

    static View k(MotionFragment motionfragment)
    {
        motionfragment.j = null;
        return null;
    }

    public final void a(Bitmap bitmap)
    {
        d = bitmap;
        if (c != null)
        {
            c.setImage(bitmap);
            c.invalidate();
        }
    }

    public final void a(boolean flag)
    {
        View view = k;
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
    }

    public final void b(boolean flag)
    {
        if (flag)
        {
            if (!w)
            {
                c(true);
            }
        } else
        {
            c(false);
        }
        w = flag;
    }

    public final void d()
    {
        super.d();
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolMotionCloseEvent(com.picsart.studio.editor.e.a().e.a, "back", (int)l.d()));
    }

    public final Tool e()
    {
        return Tool.MOTION;
    }

    public final void i()
    {
        if (f)
        {
            e.setVisibility(0);
            j();
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            l = new TimeCalculator();
        } else
        {
            l = (TimeCalculator)bundle.getParcelable("time_calculator");
        }
        if (bundle != null)
        {
            x = bundle.getBoolean("showHint");
            f = bundle.getBoolean("saveBusy");
            o = bundle.getInt("motionCount");
            v = MotionMode.valueOf(bundle.getString("motionMode"));
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03010f, viewgroup, false);
    }

    public final void onDetach()
    {
        super.onDetach();
        if (c != null)
        {
            c.g();
        }
        if (i != null)
        {
            i.cancel(true);
        }
    }

    public final void onPause()
    {
        super.onPause();
        l.b();
    }

    public final void onResume()
    {
        super.onResume();
        l.c();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        boolean flag;
        if (j != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.putBoolean("showHint", flag);
        bundle.putBoolean("saveBusy", f);
        bundle.putInt("motionCount", o);
        bundle.putString("motionMode", v.name());
        if (l != null)
        {
            bundle.putParcelable("time_calculator", l);
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        c = (MotionView)view.findViewById(0x7f1005cf);
        c.setImage(d);
        c.setTouchMode(1);
        c.setListener(this);
        c.setActionListener(new k(this));
        c.setLassoViewListener(this);
        e = (ProgressBar)view.findViewById(0x7f100188);
        if (bundle == null)
        {
            bundle = new a(getActivity());
            int i1 = ((a) (bundle)).a.getSharedPreferences(((a) (bundle)).b, 0).getInt("motionHintCount", 0);
            if (i1 <= 2)
            {
                a((FrameLayout)view);
                bundle = ((a) (bundle)).a.getSharedPreferences(((a) (bundle)).b, 0).edit();
                bundle.putInt("motionHintCount", i1 + 1);
                bundle.commit();
            }
        } else
        if (x)
        {
            a((FrameLayout)view);
        }
        k = view.findViewById(0x7f1005d7);
        k.setOnClickListener(new android.view.View.OnClickListener(view) {

            private View a;
            private MotionFragment b;

            public final void onClick(View view1)
            {
                AnalyticUtils.getInstance(b.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolMotionTryEvent(com.picsart.studio.editor.e.a().e.a, "info_click"));
                com.picsart.studio.editor.fragment.MotionFragment.a(b, (FrameLayout)a);
            }

            
            {
                b = MotionFragment.this;
                a = view;
                super();
            }
        });
        m = view.findViewById(0x7f1005d0);
        n = (TextView)view.findViewById(0x7f1005d1);
        n.setText(String.valueOf(o));
        bundle = (FloatSeekBar)view.findViewById(0x7f1005d2);
        bundle.setValueInterval(3F, 50F);
        bundle.setOnValueChangedListener(new com.picsart.studio.view.c() {

            private MotionFragment a;

            public final void a(FloatSeekBar floatseekbar)
            {
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag)
            {
                com.picsart.studio.editor.fragment.MotionFragment.a(a, (int)f1);
                MotionFragment.b(a).setText(String.valueOf(com.picsart.studio.editor.fragment.MotionFragment.a(a)));
                com.picsart.studio.editor.fragment.MotionFragment.c(a).setMotionShadowsCount(com.picsart.studio.editor.fragment.MotionFragment.a(a));
                com.picsart.studio.editor.fragment.MotionFragment.c(a).invalidate();
            }

            
            {
                a = MotionFragment.this;
                super();
            }
        });
        bundle.setValue(o);
        p = view.findViewById(0x7f1005d3);
        if (u == null)
        {
            t = new ArrayList();
            bundle = new ArrayList();
            bundle.add(Integer.valueOf(-1));
            bundle.add(Integer.valueOf(0));
            if (myobfuscated.f.m.j())
            {
                bundle.add(Integer.valueOf(5));
            }
            u = bundle;
            for (int j1 = 0; j1 < u.size(); j1++)
            {
                t.add(d.a.get(((Integer)u.get(j1)).intValue()));
            }

            r = (Button)view.findViewById(0x7f1003f8);
            bundle = new f(getActivity(), t);
            bundle.setDropDownViewResource(0x7f03024f);
            q = (Spinner)view.findViewById(0x7f1003f7);
            q.setAdapter(bundle);
            q.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

                private MotionFragment a;

                public final void onItemSelected(AdapterView adapterview, View view1, int k1, long l1)
                {
                    MotionFragment.b(a, k1);
                    com.picsart.studio.editor.fragment.MotionFragment.c(a).invalidate();
                }

                public final void onNothingSelected(AdapterView adapterview)
                {
                }

            
            {
                a = MotionFragment.this;
                super();
            }
            });
            r.setOnClickListener(new android.view.View.OnClickListener() {

                private MotionFragment a;

                public final void onClick(View view1)
                {
                    MotionFragment.i(a).performClick();
                }

            
            {
                a = MotionFragment.this;
                super();
            }
            });
        }
        a(0);
        q.setSelection(s);
        ((RadioGroup)view.findViewById(0x7f1005d4)).setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            private MotionFragment a;

            public final void onCheckedChanged(RadioGroup radiogroup, int k1)
            {
                if (k1 != 0x7f1005d5 || !((RadioButton)radiogroup.findViewById(0x7f1005d5)).isChecked()) goto _L2; else goto _L1
_L1:
                com.picsart.studio.editor.fragment.MotionFragment.c(a).setMotionDrawType(0);
_L4:
                com.picsart.studio.editor.fragment.MotionFragment.c(a).invalidate();
                return;
_L2:
                if (k1 == 0x7f1005d6)
                {
                    com.picsart.studio.editor.fragment.MotionFragment.c(a).setMotionDrawType(1);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = MotionFragment.this;
                super();
            }
        });
        if (v == MotionMode.FREE)
        {
            ((RadioButton)view.findViewById(0x7f1005d6)).setChecked(true);
        }
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private MotionFragment a;

            public final void onClick(View view1)
            {
                if (a.g != null)
                {
                    a.g.a(a);
                }
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolMotionCloseEvent(com.picsart.studio.editor.e.a().e.a, "cancel", (int)com.picsart.studio.editor.fragment.MotionFragment.d(a).d()));
            }

            
            {
                a = MotionFragment.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private MotionFragment a;

            public final void onClick(View view1)
            {
                if (!com.picsart.studio.editor.fragment.MotionFragment.e(a))
                {
                    com.picsart.studio.editor.fragment.MotionFragment.f(a);
                    MotionFragment.g(a).setVisibility(0);
                    MotionFragment.h(a);
                }
            }

            
            {
                a = MotionFragment.this;
                super();
            }
        });
    }

    private class MotionMode extends Enum
    {

        private static final MotionMode $VALUES[];
        public static final MotionMode FREE;
        public static final MotionMode LINEAR;

        public static MotionMode valueOf(String s1)
        {
            return (MotionMode)Enum.valueOf(com/picsart/studio/editor/fragment/MotionFragment$MotionMode, s1);
        }

        public static MotionMode[] values()
        {
            return (MotionMode[])$VALUES.clone();
        }

        static 
        {
            LINEAR = new MotionMode("LINEAR", 0);
            FREE = new MotionMode("FREE", 1);
            $VALUES = (new MotionMode[] {
                LINEAR, FREE
            });
        }

        private MotionMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
