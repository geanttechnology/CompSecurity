// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.freecrop.FreeCropActivity;
import com.socialin.android.photo.freecrop.FreeCropDrawController;
import com.socialin.android.photo.freecrop.FreeCropView;
import com.socialin.android.photo.freecrop.a;
import com.socialin.android.photo.freecrop.b;
import com.socialin.android.photo.freecrop.e;
import com.socialin.android.photo.select.n;
import com.socialin.android.photo.select.o;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public final class m extends Fragment
    implements a
{

    public TimeCalculator a;
    public Bitmap b;
    public EditingData c;
    private ThreadPoolExecutor d;
    private FreeCropDrawController e;
    private n f;
    private boolean g;
    private g h;
    private int i;
    private boolean j;
    private Spinner k;
    private HashMap l;
    private int m;
    private TimeCalculator n;

    public m()
    {
        f = null;
        g = false;
        j = false;
        b = null;
        l = null;
        m = 0;
    }

    static Bitmap a(m m1)
    {
        return m1.b;
    }

    static HashMap a(m m1, HashMap hashmap)
    {
        m1.l = hashmap;
        return hashmap;
    }

    private void a(int i1)
    {
        if (h != null && h.isShowing())
        {
            return;
        } else
        {
            Activity activity = getActivity();
            h = new g(activity);
            h.setMessage(getString(i1));
            android.content.DialogInterface.OnCancelListener oncancellistener = new android.content.DialogInterface.OnCancelListener() {

                private m a;

                public final void onCancel(DialogInterface dialoginterface)
                {
                    m.r(a);
                }

            
            {
                a = m.this;
                super();
            }
            };
            h.setOnCancelListener(oncancellistener);
            i = i1;
            myobfuscated.f.m.a(activity, h);
            j = true;
            return;
        }
    }

    private void a(View view)
    {
        if (view == null)
        {
            view = getView();
        }
        if (view != null)
        {
            if (e != null)
            {
                Object obj;
                Object obj1;
                int i1;
                if (view == null)
                {
                    obj = getView();
                } else
                {
                    obj = view;
                }
                if (obj != null)
                {
                    obj = (FreeCropView)((View) (obj)).findViewById(0x7f100599);
                } else
                {
                    obj = null;
                }
                ((FreeCropView) (obj)).setDrawController(e);
                obj1 = e;
                obj1.F = ((View) (obj));
                obj1 = ((FreeCropDrawController) (obj1)).E;
                obj1.q = ((View) (obj));
                if (((e) (obj1)).p != null)
                {
                    ((e) (obj1)).p.a(((View) (obj)));
                }
                e.u = getActivity();
            }
            obj = getActivity();
            obj1 = new ArrayList();
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
            if (e != null)
            {
                ((Spinner) (obj1)).setSelection(e.m, false);
            }
            ((Spinner) (obj1)).setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

                private m a;

                public final void onItemSelected(AdapterView adapterview, View view1, int j1, long l1)
                {
                    byte byte0;
                    byte0 = 10;
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFreeCropTryEvent(m.d(a).a, "brush_size_change"));
                    j1;
                    JVM INSTR tableswitch 0 5: default 76
                //                               0 133
                //                               1 127
                //                               2 121
                //                               3 115
                //                               4 109
                //                               5 104;
                       goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                    j1 = byte0;
_L9:
                    adapterview = a.getActivity();
                    com.picsart.studio.editor.fragment.m.b(a).c(Utils.a(j1, adapterview));
                    return;
_L7:
                    j1 = 5;
                    continue; /* Loop/switch isn't completed */
_L6:
                    j1 = 8;
                    continue; /* Loop/switch isn't completed */
_L5:
                    j1 = 15;
                    continue; /* Loop/switch isn't completed */
_L4:
                    j1 = 20;
                    continue; /* Loop/switch isn't completed */
_L3:
                    j1 = 25;
                    continue; /* Loop/switch isn't completed */
_L2:
                    j1 = 30;
                    if (true) goto _L9; else goto _L8
_L8:
                }

                public final void onNothingSelected(AdapterView adapterview)
                {
                }

            
            {
                a = m.this;
                super();
            }
            });
            view.findViewById(0x7f10059f).setOnClickListener(new android.view.View.OnClickListener(((Spinner) (obj1))) {

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
            k = (Spinner)view.findViewById(0x7f10059b);
            obj = getActivity();
            obj1 = new ArrayList();
            ((ArrayList) (obj1)).add(Integer.valueOf(0x7f020310));
            ((ArrayList) (obj1)).add(Integer.valueOf(0x7f020356));
            ((ArrayList) (obj1)).add(Integer.valueOf(0x7f0204e0));
            f = new n(((android.content.Context) (obj)), new String[] {
                "", "", ""
            }, ((ArrayList) (obj1)));
            k.setAdapter(f);
            if (e.C == com.socialin.android.photo.freecrop.FreeCropDrawController.DrawMode.FreeCrop)
            {
                if (e.w)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
            } else
            {
                i1 = 2;
            }
            k.setSelection(i1, false);
            k.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

                private m a;

                public final void onItemSelected(AdapterView adapterview, View view1, int j1, long l1)
                {
                    adapterview = m.q(a);
                    if (((n) (adapterview)).a != null && j1 >= 0 && j1 < ((n) (adapterview)).a.size())
                    {
                        adapterview = (Integer)((n) (adapterview)).a.get(j1);
                    } else
                    {
                        adapterview = null;
                    }
                    j1 = adapterview.intValue();
                    if (j1 == 0x7f020310)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFreeCropTryEvent(m.d(a).a, "brush_crop"));
                        com.picsart.studio.editor.fragment.m.b(a).a(com.socialin.android.photo.freecrop.FreeCropDrawController.DrawMode.FreeCrop);
                        com.picsart.studio.editor.fragment.m.b(a).w = false;
                    } else
                    if (j1 == 0x7f020356)
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFreeCropTryEvent(m.d(a).a, "eraser_crop"));
                        com.picsart.studio.editor.fragment.m.b(a).a(com.socialin.android.photo.freecrop.FreeCropDrawController.DrawMode.FreeCrop);
                        com.picsart.studio.editor.fragment.m.b(a).w = true;
                    } else
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFreeCropTryEvent(m.d(a).a, "lasso_crop"));
                        com.picsart.studio.editor.fragment.m.b(a).a(com.socialin.android.photo.freecrop.FreeCropDrawController.DrawMode.Lasso);
                        com.picsart.studio.editor.fragment.m.b(a).w = false;
                    }
                    com.picsart.studio.editor.fragment.m.o(a);
                }

                public final void onNothingSelected(AdapterView adapterview)
                {
                }

            
            {
                a = m.this;
                super();
            }
            });
            view.findViewById(0x7f10059c).setOnClickListener(new android.view.View.OnClickListener() {

                private m a;

                public final void onClick(View view1)
                {
                    com.picsart.studio.editor.fragment.m.n(a).performClick();
                }

            
            {
                a = m.this;
                super();
            }
            });
            c(view);
            b(view);
            if (view == null)
            {
                obj = getView();
            } else
            {
                obj = view;
            }
            if (obj != null)
            {
                obj = (ImageButton)((View) (obj)).findViewById(0x7f100350);
            } else
            {
                obj = null;
            }
            ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                private m a;

                public final void onClick(View view1)
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFreeCropCloseEvent(m.d(a).a, "cancel", (int)com.picsart.studio.editor.fragment.m.e(a).d()));
                    m.f(a);
                }

            
            {
                a = m.this;
                super();
            }
            });
            obj1 = new android.view.View.OnClickListener() {

                private m a;

                public final void onClick(View view1)
                {
                    if (!com.picsart.studio.editor.fragment.m.g(a))
                    {
                        if (view1.getId() == 0x7f1005a1)
                        {
                            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFreeCropTryEvent(m.d(a).a, "undo"));
                            m.h(a);
                            return;
                        }
                        if (view1.getId() == 0x7f1005a0)
                        {
                            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFreeCropTryEvent(m.d(a).a, "delete"));
                            m.i(a);
                            return;
                        }
                        if (view1.getId() == 0x7f100245)
                        {
                            m.j(a);
                            return;
                        }
                        if (view1.getId() == 0x7f1005a2)
                        {
                            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFreeCropTryEvent(m.d(a).a, "add_to_clipart"));
                            m.k(a);
                            return;
                        }
                    }
                }

            
            {
                a = m.this;
                super();
            }
            };
            if (view == null)
            {
                obj = getView();
            } else
            {
                obj = view;
            }
            if (obj != null)
            {
                obj = (ImageButton)((View) (obj)).findViewById(0x7f100245);
            } else
            {
                obj = null;
            }
            ((ImageButton) (obj)).setOnClickListener(((android.view.View.OnClickListener) (obj1)));
            d(view).setOnClickListener(((android.view.View.OnClickListener) (obj1)));
            e(view).setOnClickListener(((android.view.View.OnClickListener) (obj1)));
            f(view).setOnClickListener(((android.view.View.OnClickListener) (obj1)));
        }
    }

    static void a(m m1, Bitmap bitmap)
    {
        Activity activity = m1.getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        AnalyticUtils.getInstance(activity).track(new com.socialin.android.apiv3.events.EventsFactory.EditToolsApplyEvent("tool_free_crop"));
        FreeCropActivity.a = bitmap;
        bitmap = new Intent();
        if (m1.c != null)
        {
            bitmap.putExtra("editing_data", m1.c);
        }
        activity.setResult(-1, bitmap);
        activity.finish();
    }

    private void a(boolean flag)
    {
        g = flag;
        FreeCropDrawController freecropdrawcontroller = e;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        freecropdrawcontroller.G = flag;
    }

    static FreeCropDrawController b(m m1)
    {
        return m1.e;
    }

    private void b(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 != null)
        {
            boolean flag = c();
            d(view1).setEnabled(flag);
            e(view1).setEnabled(flag);
            f(view1).setEnabled(flag);
        }
    }

    static HashMap c(m m1)
    {
        return m1.l;
    }

    private void c(View view)
    {
        if (view == null)
        {
            view = getView();
        }
        if (view != null)
        {
            Object obj;
            com.socialin.android.photo.freecrop.FreeCropDrawController.DrawMode drawmode;
            int i1;
            if (view == null)
            {
                obj = getView();
            } else
            {
                obj = view;
            }
            if (obj != null)
            {
                obj = (ImageButton)((View) (obj)).findViewById(0x7f10059c);
            } else
            {
                obj = null;
            }
            drawmode = e.C;
            view = view.findViewById(0x7f10059d);
            if (drawmode == com.socialin.android.photo.freecrop.FreeCropDrawController.DrawMode.FreeCrop)
            {
                if (e.w)
                {
                    i1 = 0x7f020356;
                } else
                {
                    i1 = 0x7f020310;
                }
                view.setVisibility(0);
            } else
            {
                i1 = 0x7f0204e0;
                view.setVisibility(8);
            }
            ((ImageButton) (obj)).setImageResource(i1);
        }
    }

    private boolean c()
    {
        return e != null && e.B.a();
    }

    private ImageButton d(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 != null)
        {
            return (ImageButton)view1.findViewById(0x7f1005a1);
        } else
        {
            return null;
        }
    }

    static EditingData d(m m1)
    {
        return m1.c;
    }

    private void d()
    {
        Activity activity = getActivity();
        if (activity != null)
        {
            activity.setResult(0);
            activity.finish();
        }
    }

    private ImageButton e(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 != null)
        {
            return (ImageButton)view1.findViewById(0x7f1005a0);
        } else
        {
            return null;
        }
    }

    static TimeCalculator e(m m1)
    {
        return m1.a;
    }

    private Button f(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 != null)
        {
            return (Button)view1.findViewById(0x7f1005a2);
        } else
        {
            return null;
        }
    }

    static void f(m m1)
    {
        m1.d();
    }

    static boolean g(m m1)
    {
        return m1.g;
    }

    static void h(m m1)
    {
        ModernAsyncTask modernasynctask = m1. new ModernAsyncTask() {

            private m a;

            protected final Object doInBackground(Object aobj[])
            {
                aobj = com.picsart.studio.editor.fragment.m.b(a);
                Object obj = ((FreeCropDrawController) (aobj)).B.a;
                if (((ArrayList) (obj)).size() > 0)
                {
                    Bitmap bitmap = com.socialin.android.util.c.a(((FreeCropDrawController) (aobj)).p, ((FreeCropDrawController) (aobj)).q, android.graphics.Bitmap.Config.ARGB_8888);
                    if (bitmap != null)
                    {
                        ((ArrayList) (obj)).remove(((ArrayList) (obj)).size() - 1);
                        obj = new Canvas(bitmap);
                        ((Canvas) (obj)).drawBitmap(((FreeCropDrawController) (aobj)).n, 0.0F, 0.0F, ((FreeCropDrawController) (aobj)).A);
                        ((FreeCropDrawController) (aobj)).B.a(((Canvas) (obj)), ((FreeCropDrawController) (aobj)).n);
                        if (((FreeCropDrawController) (aobj)).D != null)
                        {
                            ((FreeCropDrawController) (aobj)).D.a(bitmap);
                        }
                    }
                }
                return null;
            }

            
            {
                a = m.this;
                super();
            }
        };
        m1.a(true);
        m1.a(0x7f080679);
        modernasynctask.executeOnExecutor(m1.d, new Void[] {
            null
        });
    }

    static void i(m m1)
    {
        (m1. new ModernAsyncTask() {

            private m a;

            protected final volatile Object doInBackground(Object aobj[])
            {
                return null;
            }

            protected final void onPostExecute(Object obj)
            {
                a.a();
                com.picsart.studio.editor.fragment.m.b(a).b();
                com.picsart.studio.editor.fragment.m.b(a).a();
                m.l(a);
                m.m(a);
                if (com.picsart.studio.editor.fragment.m.b(a).C == com.socialin.android.photo.freecrop.FreeCropDrawController.DrawMode.FreeCrop && com.picsart.studio.editor.fragment.m.b(a).w)
                {
                    com.picsart.studio.editor.fragment.m.b(a).w = false;
                    com.picsart.studio.editor.fragment.m.n(a).setSelection(0);
                    com.picsart.studio.editor.fragment.m.o(a);
                }
            }

            
            {
                a = m.this;
                super();
            }
        }).executeOnExecutor(m1.d, new Void[] {
            null
        });
        m1.a(true);
        m1.a(0x7f080679);
    }

    static void j(m m1)
    {
        (m1. new ModernAsyncTask() {

            private m a;

            protected final Object doInBackground(Object aobj[])
            {
                aobj = com.picsart.studio.editor.fragment.m.b(a);
                return ((Object) (new Object[] {
                    ((FreeCropDrawController) (aobj)).B.a(((FreeCropDrawController) (aobj)).n), Boolean.valueOf(com.picsart.studio.editor.fragment.m.b(a).B.c)
                }));
            }

            protected final void onPostExecute(Object obj)
            {
                Object aobj[] = (Object[])obj;
                if (!m.p(a))
                {
                    Activity activity;
                    boolean flag;
                    boolean flag1;
                    if (aobj[0] != null)
                    {
                        obj = (Bitmap)aobj[0];
                    } else
                    {
                        obj = null;
                    }
                    flag1 = ((Boolean)aobj[1]).booleanValue();
                    if (obj != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    Log.e("ex1", (new StringBuilder("createResultBitmap() succes = ")).append(flag).toString());
                    activity = a.getActivity();
                    a.a();
                    m.l(a);
                    if (flag)
                    {
                        if (m.d(a) != null)
                        {
                            m.d(a).c("free_crop");
                        }
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFreeCropCloseEvent(m.d(a).a, "done", (int)com.picsart.studio.editor.fragment.m.e(a).d()));
                        com.picsart.studio.editor.fragment.m.a(a, ((Bitmap) (obj)));
                    } else
                    {
                        if (flag1)
                        {
                            Utils.a(activity, 0x7f0805ca);
                            return;
                        }
                        Utils.a(activity, 0x7f08041f);
                        com.picsart.studio.editor.fragment.m.b(a).b();
                        com.picsart.studio.editor.fragment.m.b(a).a();
                        m.m(a);
                        if (com.picsart.studio.editor.fragment.m.b(a).C == com.socialin.android.photo.freecrop.FreeCropDrawController.DrawMode.FreeCrop && com.picsart.studio.editor.fragment.m.b(a).w)
                        {
                            com.picsart.studio.editor.fragment.m.b(a).w = false;
                            com.picsart.studio.editor.fragment.m.o(a);
                            return;
                        }
                    }
                }
            }

            
            {
                a = m.this;
                super();
            }
        }).executeOnExecutor(m1.d, new Void[] {
            null
        });
        m1.a(true);
        m1.a(0x7f080679);
    }

    static void k(m m1)
    {
        (m1. new ModernAsyncTask() {

            private m a;

            protected final Object doInBackground(Object aobj[])
            {
                aobj = com.picsart.studio.editor.fragment.m.b(a);
                Bitmap bitmap = ((FreeCropDrawController) (aobj)).B.a(((FreeCropDrawController) (aobj)).n);
                return ((Object) (new Object[] {
                    com.socialin.android.photo.clipart.e.a(((FreeCropDrawController) (aobj)).u, bitmap, "freeCrop"), Boolean.valueOf(com.picsart.studio.editor.fragment.m.b(a).B.c)
                }));
            }

            protected final void onPostExecute(Object obj)
            {
                Object aobj[] = (Object[])obj;
                if (!m.p(a))
                {
                    boolean flag;
                    boolean flag1;
                    if (aobj[0] != null)
                    {
                        obj = (String)aobj[0];
                    } else
                    {
                        obj = null;
                    }
                    flag1 = ((Boolean)aobj[1]).booleanValue();
                    if (obj != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    obj = a.getActivity();
                    a.a();
                    m.l(a);
                    if (!flag)
                    {
                        if (flag1)
                        {
                            Utils.a(((Activity) (obj)), 0x7f0805ca);
                        } else
                        {
                            Utils.a(((Activity) (obj)), 0x7f08041f);
                            com.picsart.studio.editor.fragment.m.b(a).b();
                            com.picsart.studio.editor.fragment.m.b(a).a();
                            m.m(a);
                            if (com.picsart.studio.editor.fragment.m.b(a).C == com.socialin.android.photo.freecrop.FreeCropDrawController.DrawMode.FreeCrop && com.picsart.studio.editor.fragment.m.b(a).w)
                            {
                                com.picsart.studio.editor.fragment.m.b(a).w = false;
                                com.picsart.studio.editor.fragment.m.o(a);
                                return;
                            }
                        }
                    }
                }
            }

            
            {
                a = m.this;
                super();
            }
        }).executeOnExecutor(m1.d, new Void[] {
            null
        });
        m1.a(true);
        m1.a(0x7f080679);
    }

    static void l(m m1)
    {
        m1.a(false);
    }

    static void m(m m1)
    {
        m1.b(((View) (null)));
    }

    static Spinner n(m m1)
    {
        return m1.k;
    }

    static void o(m m1)
    {
        m1.c(((View) (null)));
    }

    static boolean p(m m1)
    {
        m1 = m1.getActivity();
        return m1 == null || m1.isFinishing();
    }

    static n q(m m1)
    {
        return m1.f;
    }

    static boolean r(m m1)
    {
        m1.j = false;
        return false;
    }

    static boolean s(m m1)
    {
        return m1.c();
    }

    public final void a()
    {
        if (h != null && h.isShowing())
        {
            myobfuscated.f.m.b(getActivity(), h);
            j = false;
        }
        h = null;
    }

    public final void a(Bitmap bitmap)
    {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing())
        {
            if (bitmap != null && !bitmap.isRecycled())
            {
                com.socialin.android.util.c.a(bitmap);
            }
            return;
        } else
        {
            activity.runOnUiThread(new Runnable(bitmap) {

                private Bitmap a;
                private m b;

                public final void run()
                {
                    if (m.p(b))
                    {
                        if (a != null && !a.isRecycled())
                        {
                            com.socialin.android.util.c.a(a);
                        }
                    } else
                    {
                        b.a();
                        m.l(b);
                        if (a != null)
                        {
                            com.picsart.studio.editor.fragment.m.b(b).a(a, true);
                        } else
                        {
                            Utils.a(b.getActivity(), 0x7f0805ca);
                        }
                        com.picsart.studio.editor.fragment.m.b(b).a();
                        m.m(b);
                        if (!m.s(b) && com.picsart.studio.editor.fragment.m.b(b).C == com.socialin.android.photo.freecrop.FreeCropDrawController.DrawMode.FreeCrop && com.picsart.studio.editor.fragment.m.b(b).w)
                        {
                            com.picsart.studio.editor.fragment.m.b(b).w = false;
                            com.picsart.studio.editor.fragment.m.o(b);
                            return;
                        }
                    }
                }

            
            {
                b = m.this;
                a = bitmap;
                super();
            }
            });
            return;
        }
    }

    public final void a(Bitmap bitmap, View view)
    {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        a();
        if (bitmap == null || bitmap.isRecycled())
        {
            Utils.a(getActivity(), 0x7f0805ca);
            d();
            return;
        } else
        {
            Log.e("ex1", (new StringBuilder("freeCrop bitmap w = ")).append(bitmap.getWidth()).append(" h = ").append(bitmap.getHeight()).toString());
            e = new FreeCropDrawController(activity, bitmap);
            e.D = this;
            a(view);
            return;
        }
    }

    public final void b()
    {
        b(((View) (null)));
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        if (e != null)
        {
            e.u = bundle;
            if (j)
            {
                h = null;
                a(i);
            }
            return;
        } else
        {
            a();
            a(0x7f080548);
            return;
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            a = new TimeCalculator();
        } else
        {
            a = (TimeCalculator)bundle.getParcelable("time_calculator");
        }
        d = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
        m = PicsartContext.a(getActivity());
        n = new TimeCalculator();
        if (bundle != null)
        {
            if (bundle.containsKey("origBufferData"))
            {
                l = (HashMap)bundle.getSerializable("origBufferData");
            }
            if (bundle.containsKey("editing_data"))
            {
                c = (EditingData)bundle.getParcelable("editing_data");
            }
        }
        if (l == null)
        {
            if (b != null)
            {
                (new ModernAsyncTask(new File(x.a(getActivity()), String.valueOf(System.currentTimeMillis()))) {

                    private File a;
                    private m b;

                    protected final Object doInBackground(Object aobj[])
                    {
                        aobj = a.getPath();
                        Bitmap bitmap = com.picsart.studio.editor.fragment.m.a(b);
                        b.getActivity();
                        return w.a(((String) (aobj)), bitmap);
                    }

                    protected final void onPostExecute(Object obj)
                    {
                        obj = (HashMap)obj;
                        com.picsart.studio.editor.fragment.m.a(b, ((HashMap) (obj)));
                    }

            
            {
                b = m.this;
                a = file;
                super();
            }
                }).executeOnExecutor(d, new Void[] {
                    null
                });
            }
            return;
        } else
        {
            b = w.a(l, m, 0);
            return;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03010b, viewgroup, false);
        if (e != null)
        {
            a(layoutinflater);
        } else
        {
            viewgroup = b;
            if (viewgroup != null && !viewgroup.isRecycled())
            {
                a(viewgroup, layoutinflater);
                return layoutinflater;
            }
        }
        return layoutinflater;
    }

    public final void onPause()
    {
        super.onPause();
        a.b();
        n.b();
        if (c != null)
        {
            EditingData editingdata = c;
            editingdata.c = (int)((long)editingdata.c + n.d());
        }
    }

    public final void onResume()
    {
        super.onResume();
        a.c();
        n.a();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (l == null)
        {
            String s1 = (new File(x.a(getActivity()), String.valueOf(System.currentTimeMillis()))).getPath();
            Bitmap bitmap = b;
            getActivity();
            l = w.a(s1, bitmap);
        }
        bundle.putSerializable("origBufferData", l);
        if (c != null)
        {
            bundle.putParcelable("editing_data", c);
        }
        if (a != null)
        {
            bundle.putParcelable("time_calculator", a);
        }
    }

    public final void onStop()
    {
        super.onStop();
        Activity activity = getActivity();
        if (activity != null && activity.isFinishing())
        {
            (new ModernAsyncTask() {

                private m a;

                protected final volatile Object doInBackground(Object aobj[])
                {
                    return null;
                }

                protected final void onPostExecute(Object obj)
                {
                    if (com.picsart.studio.editor.fragment.m.b(a) != null)
                    {
                        obj = com.picsart.studio.editor.fragment.m.b(a);
                        if (((FreeCropDrawController) (obj)).o != null && !((FreeCropDrawController) (obj)).o.isRecycled())
                        {
                            com.socialin.android.util.c.a(((FreeCropDrawController) (obj)).o);
                            obj.o = null;
                        }
                        if (((FreeCropDrawController) (obj)).E != null)
                        {
                            obj = ((FreeCropDrawController) (obj)).E;
                            ((e) (obj)).e();
                            if (((e) (obj)).c != null)
                            {
                                ((e) (obj)).c.a();
                            }
                            if (((e) (obj)).d != null)
                            {
                                ((e) (obj)).d.a();
                            }
                        }
                    }
                    if (com.picsart.studio.editor.fragment.m.a(a) != null && !com.picsart.studio.editor.fragment.m.a(a).isRecycled())
                    {
                        com.socialin.android.util.c.a(com.picsart.studio.editor.fragment.m.a(a));
                    }
                    if (com.picsart.studio.editor.fragment.m.c(a) != null && (new File((String)com.picsart.studio.editor.fragment.m.c(a).get("path"))).delete())
                    {
                        Log.e("ex1", "file deleted");
                    }
                }

            
            {
                a = m.this;
                super();
            }
            }).executeOnExecutor(d, new Void[] {
                null
            });
        }
    }
}
