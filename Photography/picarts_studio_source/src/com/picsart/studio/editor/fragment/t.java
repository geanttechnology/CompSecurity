// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import android.widget.TextView;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.PerspectiveView;
import com.picsart.studio.editor.view.RulerView;
import com.picsart.studio.editor.view.n;
import com.picsart.studio.editor.view.r;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.ag;
import java.text.DecimalFormat;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class t extends i
{

    private PerspectiveView c;
    private View d;
    private TextView e;
    private ImageButton f;
    private ImageButton i;
    private RulerView j;
    private DecimalFormat k;
    private TimeCalculator l;
    private long m;
    private int n;

    public t()
    {
        k = new DecimalFormat("0.0");
    }

    public static void a(t t1)
    {
        float f1 = t1.j();
        if (Math.abs(f1) >= 0.1F)
        {
            if (t1.d.getVisibility() == 4)
            {
                t1.a(true);
                t1.d.setAlpha(0.0F);
                t1.d.animate().alpha(1.0F).setListener(null);
            }
        } else
        {
            t1.a(false);
        }
        t1.e.setText((new StringBuilder()).append(t1.k.format(f1)).append("\260").toString());
    }

    static void a(t t1, String s)
    {
        t1.n = t1.n + 1;
        String s1 = com.picsart.studio.editor.e.a().e.a;
        AnalyticUtils.getInstance(t1.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolPerspectiveTryEvent(s1, s, t1.n, t1.c.c, t1.c.d, t1.h.getWidth(), t1.h.getHeight()));
    }

    private void a(String s)
    {
        String s1 = com.picsart.studio.editor.e.a().e.a;
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolPerspectiveCloseEvent(s1, s, n, m, c.c, c.d, h.getWidth(), h.getHeight()));
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            float f1 = j();
            e.setText((new StringBuilder()).append(k.format(f1)).append("\260").toString());
            d.setVisibility(0);
            d.setOnClickListener(new android.view.View.OnClickListener() {

                final t a;

                public final void onClick(View view)
                {
                    PerspectiveView perspectiveview = t.b(a);
                    boolean flag1;
                    if (perspectiveview.i == null && !perspectiveview.h)
                    {
                        float f2;
                        ValueAnimator valueanimator;
                        if (perspectiveview.g == com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.HORIZONTAL)
                        {
                            f2 = perspectiveview.d;
                        } else
                        {
                            f2 = perspectiveview.c;
                        }
                        perspectiveview.i = ValueAnimator.ofFloat(new float[] {
                            f2, 0.0F
                        });
                        perspectiveview.i.addUpdateListener(new com.picsart.studio.editor.view.PerspectiveView._cls1(perspectiveview));
                        perspectiveview.i.addListener(new com.picsart.studio.editor.view.PerspectiveView._cls2(perspectiveview, null));
                        valueanimator = perspectiveview.i;
                        if (perspectiveview.g == com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.HORIZONTAL)
                        {
                            f2 = perspectiveview.d;
                        } else
                        {
                            f2 = perspectiveview.c;
                        }
                        valueanimator.setDuration((long)((Math.abs(f2) * 500F) / 45F));
                        perspectiveview.i.start();
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1)
                    {
                        t.a(a, "reset_angle");
                        t.d(a).setOnClickListener(null);
                        view.animate().alpha(0.0F).setListener(new ag(this) {

                            private _cls6 a;

                            public final void onAnimationEnd(Animator animator)
                            {
                                super.onAnimationEnd(animator);
                                com.picsart.studio.editor.fragment.t.e(a.a);
                            }

            
            {
                a = _pcls6;
                super();
            }
                        });
                    }
                }

            
            {
                a = t.this;
                super();
            }
            });
            return;
        } else
        {
            d.setVisibility(4);
            d.setOnClickListener(null);
            return;
        }
    }

    static PerspectiveView b(t t1)
    {
        return t1.c;
    }

    static void b(t t1, String s)
    {
        t1.a(s);
    }

    static void c(t t1)
    {
        t1.i();
    }

    static View d(t t1)
    {
        return t1.d;
    }

    static void e(t t1)
    {
        t1.a(false);
    }

    private void i()
    {
        boolean flag1 = true;
        com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode perspectivemode = c.g;
        ImageButton imagebutton = f;
        float f1;
        boolean flag;
        if (perspectivemode == com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.HORIZONTAL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        imagebutton.setActivated(flag);
        imagebutton = i;
        if (perspectivemode == com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.VERTICAL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        imagebutton.setActivated(flag);
        f1 = j();
        j.setProgress(f1);
        if (Math.abs(f1) >= 0.1F)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        a(flag);
    }

    private float j()
    {
        if (c.g == com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.HORIZONTAL)
        {
            return c.d;
        } else
        {
            return c.c;
        }
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (c != null)
        {
            c.setImage(bitmap);
        }
    }

    public final void d()
    {
        super.d();
        a("back");
    }

    public final Tool e()
    {
        return Tool.PERSPECTIVE;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        l = new TimeCalculator();
        if (bundle != null)
        {
            m = bundle.getLong("timeSpent", 0L);
            n = bundle.getInt("actionCount", 0);
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030115, viewgroup, false);
    }

    public final void onPause()
    {
        super.onPause();
        l.b();
        m = m + l.d();
    }

    public final void onResume()
    {
        super.onResume();
        l.a();
        i();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putLong("timeSpent", m);
        bundle.putInt("actionCount", n);
        if (d != null)
        {
            boolean flag;
            if (d.getVisibility() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            bundle.putBoolean("savedAngleIndicatorVisible", flag);
        }
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
        f = (ImageButton)view.findViewById(0x7f1005f5);
        i = (ImageButton)view.findViewById(0x7f1005f6);
        c = (PerspectiveView)view.findViewById(0x7f1005f3);
        c.setOnPerspectiveChangedListener(new n(this));
        if (h != null)
        {
            c.setImage(h);
        }
        j = (RulerView)view.findViewById(0x7f100568);
        j.setOnProgressChangedListener(new r() {

            private t a;

            public final void a()
            {
                t.b(a).setSliderTouched(false);
                if (t.b(a).g == com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.HORIZONTAL)
                {
                    t.a(a, "strengthen_horizontal");
                    return;
                } else
                {
                    t.a(a, "strengthen_vertical");
                    return;
                }
            }

            public final void a(float f1)
            {
                if (t.b(a).g == com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.HORIZONTAL)
                {
                    t.b(a).setHorizontalPerspective(f1);
                    return;
                } else
                {
                    t.b(a).setVerticalPerspective(f1);
                    return;
                }
            }

            
            {
                a = t.this;
                super();
            }
        });
        c.setRulerView(j);
        view.findViewById(0x7f1005f5).setOnClickListener(new android.view.View.OnClickListener() {

            private t a;

            public final void onClick(View view1)
            {
                t.b(a).setMode(com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.HORIZONTAL);
                com.picsart.studio.editor.fragment.t.c(a);
            }

            
            {
                a = t.this;
                super();
            }
        });
        view.findViewById(0x7f1005f6).setOnClickListener(new android.view.View.OnClickListener() {

            private t a;

            public final void onClick(View view1)
            {
                t.b(a).setMode(com.picsart.studio.editor.view.PerspectiveView.PerspectiveMode.VERTICAL);
                com.picsart.studio.editor.fragment.t.c(a);
            }

            
            {
                a = t.this;
                super();
            }
        });
        e = (TextView)view.findViewById(0x7f100569);
        d = view.findViewById(0x7f100566);
        a(flag);
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private t a;

            public final void onClick(View view1)
            {
                if (a.g != null)
                {
                    a.g.a(a);
                }
                t.b(a, "close");
            }

            
            {
                a = t.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private t a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.e.a().e.c("perspective");
                PerspectiveView perspectiveview = t.b(a);
                if (perspectiveview.a != null)
                {
                    view1 = Bitmap.createBitmap(perspectiveview.a.getWidth(), perspectiveview.a.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                    perspectiveview.a(new RectF(0.0F, 0.0F, perspectiveview.a.getWidth(), perspectiveview.a.getHeight()));
                    Canvas canvas = new Canvas(view1);
                    canvas.concat(perspectiveview.f);
                    canvas.scale(perspectiveview.e.width() / (float)perspectiveview.a.getWidth(), perspectiveview.e.height() / (float)perspectiveview.a.getHeight());
                    canvas.drawBitmap(perspectiveview.a, (float)(-perspectiveview.a.getWidth()) / 2.0F, (float)(-perspectiveview.a.getHeight()) / 2.0F, perspectiveview.b);
                } else
                {
                    view1 = null;
                }
                a.g.a(a, view1, RasterAction.create(view1, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
                t.b(a, "done");
            }

            
            {
                a = t.this;
                super();
            }
        });
        i();
    }
}
