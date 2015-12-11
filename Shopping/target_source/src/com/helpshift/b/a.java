// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.b;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.helpshift.HSMessagesFragment;
import com.helpshift.i.b;
import com.helpshift.i.w;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class com.helpshift.b.a extends ArrayAdapter
{
    private static class a
    {

        public TextView a;

        private a()
        {
        }

    }

    private static class b
    {

        public TextView a;
        public TextView b;
        public TextView c;
        public ImageButton d;
        public ProgressBar e;
        public ProgressBar f;
        public ImageButton g;

        private b()
        {
        }

    }

    private static class c
    {

        public ImageView a;
        public ProgressBar b;
        public ImageButton c;

        private c()
        {
        }

    }

    private static class d
    {

        public TextView a;
        public ProgressBar b;
        public LinearLayout c;
        public ImageButton d;
        public ImageButton e;

        private d()
        {
        }

    }

    private static class e
    {

        public TextView a;
        public TextView b;

        private e()
        {
        }

    }

    private static class f
    {

        public LinearLayout a;
        public ProgressBar b;
        public ImageView c;
        public ImageButton d;
        public ImageButton e;
        public View f;

        private f()
        {
        }

    }

    private static class g
    {

        public TextView a;
        public ProgressBar b;
        public ImageButton c;
        public View d;

        private g()
        {
        }

    }

    private static class h
    {

        public TextView a;
        public ImageButton b;
        public ProgressBar c;
        public LinearLayout d;
        public ImageView e;
        public ImageButton f;
        public ImageButton g;
        public View h;
        public LinearLayout i;
        public View j;

        private h()
        {
        }

    }

    private static class i
    {

        public TextView a;
        public ProgressBar b;
        public ImageView c;

        private i()
        {
        }

    }

    private static class j
    {

        public TextView a;
        public TextView b;

        private j()
        {
        }

    }

    private static class k
    {

        public TextView a;
        public TextView b;
        public ImageView c;

        private k()
        {
        }

    }


    private HSMessagesFragment a;
    private Context b;
    private List c;
    private final LayoutInflater d;
    private boolean e;

    public com.helpshift.b.a(Fragment fragment, int l, List list)
    {
        super(fragment.getActivity(), l, list);
        a = (HSMessagesFragment)fragment;
        b = fragment.getActivity();
        c = list;
        d = (LayoutInflater)b.getSystemService("layout_inflater");
    }

    private View a(View view, com.helpshift.k.a a1, int l, b b1)
    {
        b b2;
        JSONObject jsonobject;
        String s;
        String s1;
        int i1;
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.H, null);
            b1.a = (TextView)view.findViewById(0x1020014);
            b1.b = (TextView)view.findViewById(0x1020015);
            b1.c = (TextView)view.findViewById(0x1020010);
            b1.d = (ImageButton)view.findViewById(0x1020019);
            w.l(b, b1.d.getDrawable());
            b1.e = (ProgressBar)view.findViewById(0x102000f);
            b1.f = (ProgressBar)view.findViewById(0x102000d);
            b1.g = (ImageButton)view.findViewById(0x102001a);
            w.m(b, b1.g.getDrawable());
            view.setTag(b1);
            b2 = b1;
            b1 = view;
        } else
        {
            b2 = (b)view.getTag();
            b1 = view;
        }
        try
        {
            jsonobject = JSONObjectInstrumentation.init(a1.d);
            s = jsonobject.getString("file-name");
            view = jsonobject.getString("content-type");
            s1 = com.helpshift.i.b.a(a.getActivity(), view, s);
            i1 = jsonobject.getInt("size");
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return b1;
        }
        if (i1 >= 1024) goto _L2; else goto _L1
_L1:
        view = (new StringBuilder()).append(i1).append(" B").toString();
_L8:
        b2.a.setText(s);
        b2.b.setText(s1);
        b2.c.setText(view);
        a1.f;
        JVM INSTR tableswitch 0 3: default 609
    //                   0 433
    //                   1 483
    //                   2 525
    //                   3 567;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_567;
_L9:
        b2.d.setOnClickListener(new android.view.View.OnClickListener(jsonobject, l) {

            final JSONObject a;
            final int b;
            final com.helpshift.b.a c;

            public void onClick(View view1)
            {
                com.helpshift.b.a.a(c).a(a, b, 6);
            }

            
            {
                c = com.helpshift.b.a.this;
                a = jsonobject;
                b = l;
                super();
            }
        });
        b2.g.setOnClickListener(new android.view.View.OnClickListener(a1) {

            final com.helpshift.k.a a;
            final com.helpshift.b.a b;

            public void onClick(View view1)
            {
                com.helpshift.b.a.a(b).a(a);
            }

            
            {
                b = com.helpshift.b.a.this;
                a = a2;
                super();
            }
        });
        return b1;
_L2:
        if (i1 >= 0x100000)
        {
            break MISSING_BLOCK_LABEL_389;
        }
        view = (new StringBuilder()).append(i1 / 1024).append(" KB").toString();
          goto _L8
        view = (new StringBuilder()).append(String.format("%.1f", new Object[] {
            Float.valueOf((float)i1 / 1048576F)
        })).append(" MB").toString();
          goto _L8
_L4:
        b2.d.setVisibility(0);
        b2.e.setVisibility(8);
        b2.f.setVisibility(8);
        b2.g.setVisibility(8);
          goto _L9
_L5:
        b2.d.setVisibility(8);
        b2.e.setVisibility(0);
        b2.f.setVisibility(8);
        b2.g.setVisibility(8);
          goto _L9
_L6:
        b2.d.setVisibility(8);
        b2.e.setVisibility(8);
        b2.f.setVisibility(0);
        b2.g.setVisibility(8);
          goto _L9
        b2.d.setVisibility(8);
        b2.e.setVisibility(8);
        b2.f.setVisibility(8);
        b2.g.setVisibility(0);
          goto _L9
    }

    private View a(View view, com.helpshift.k.a a1, int l, c c1)
    {
        JSONObject jsonobject;
        Object obj;
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.I, null);
            c1.a = (ImageView)view.findViewById(0x1020010);
            c1.b = (ProgressBar)view.findViewById(0x102000d);
            c1.c = (ImageButton)view.findViewById(0x1020019);
            w.l(b, c1.c.getDrawable());
            view.setTag(c1);
        } else
        {
            c1 = (c)view.getTag();
        }
        jsonobject = JSONObjectInstrumentation.init(a1.d);
        obj = new File(a1.h);
        a1.f;
        JVM INSTR tableswitch 0 3: default 421
    //                   0 186
    //                   1 237
    //                   2 298
    //                   3 359;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_359;
_L6:
        c1.c.setOnClickListener(new android.view.View.OnClickListener(jsonobject, l) {

            final JSONObject a;
            final int b;
            final com.helpshift.b.a c;

            public void onClick(View view1)
            {
                com.helpshift.b.a.a(c).a(a, b, 7);
            }

            
            {
                c = com.helpshift.b.a.this;
                a = jsonobject;
                b = l;
                super();
            }
        });
        c1.a.setOnClickListener(new android.view.View.OnClickListener(a1) {

            final com.helpshift.k.a a;
            final com.helpshift.b.a b;

            public void onClick(View view1)
            {
                if (a.f == 3)
                {
                    com.helpshift.b.a.a(b).a(a);
                }
            }

            
            {
                b = com.helpshift.b.a.this;
                a = a2;
                super();
            }
        });
        return view;
_L2:
        try
        {
            c1.a.setVisibility(8);
            c1.c.setVisibility(8);
            c1.b.setVisibility(0);
            a.a(jsonobject, l, 8);
        }
        // Misplaced declaration of an exception variable
        catch (com.helpshift.k.a a1)
        {
            a1.printStackTrace();
            return view;
        }
          goto _L6
_L3:
        c1.b.setVisibility(8);
        if (((File) (obj)).exists())
        {
            obj = com.helpshift.i.b.a(a1.h, 250);
            c1.a.setImageBitmap(((android.graphics.Bitmap) (obj)));
            c1.a.setVisibility(0);
        }
        c1.c.setVisibility(0);
          goto _L6
_L4:
        c1.c.setVisibility(8);
        if (((File) (obj)).exists())
        {
            obj = com.helpshift.i.b.a(a1.h, 250);
            c1.a.setImageBitmap(((android.graphics.Bitmap) (obj)));
            c1.a.setVisibility(0);
        }
        c1.b.setVisibility(0);
          goto _L6
        c1.c.setVisibility(8);
        c1.b.setVisibility(8);
        if (((File) (obj)).exists())
        {
            android.graphics.Bitmap bitmap = com.helpshift.i.b.a(a1.h, 250);
            c1.a.setImageBitmap(bitmap);
            c1.a.setVisibility(0);
        }
          goto _L6
    }

    private View a(View view, com.helpshift.k.a a1, int l, d d1)
    {
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.q, null);
            w.j(b, view.findViewById(com.helpshift.b.c.Z).getBackground());
            d1.a = (TextView)view.findViewById(0x1020014);
            d1.b = (ProgressBar)view.findViewById(0x102000d);
            d1.c = (LinearLayout)view.findViewById(0x1020018);
            d1.d = (ImageButton)view.findViewById(0x1020019);
            d1.e = (ImageButton)view.findViewById(0x102001a);
            w.f(b, d1.d.getDrawable());
            w.g(b, d1.e.getDrawable());
            view.setTag(d1);
        } else
        {
            d1 = (d)view.getTag();
        }
        d1.a.setText(a(a1.d));
        if (a1.k.booleanValue())
        {
            d1.b.setVisibility(0);
            d1.c.setVisibility(8);
            return view;
        }
        if (!a1.j.booleanValue())
        {
            d1.c.setVisibility(0);
            d1.b.setVisibility(8);
            d1.d.setOnClickListener(new android.view.View.OnClickListener(a1, l) {

                final com.helpshift.k.a a;
                final int b;
                final com.helpshift.b.a c;

                public void onClick(View view1)
                {
                    if (a.i.booleanValue())
                    {
                        com.helpshift.b.a.a(c).a(a.g, Boolean.valueOf(true), b);
                    }
                }

            
            {
                c = com.helpshift.b.a.this;
                a = a2;
                b = l;
                super();
            }
            });
            d1.e.setOnClickListener(new android.view.View.OnClickListener(a1, l) {

                final com.helpshift.k.a a;
                final int b;
                final com.helpshift.b.a c;

                public void onClick(View view1)
                {
                    if (a.i.booleanValue())
                    {
                        com.helpshift.b.a.a(c).a(a.g, Boolean.valueOf(false), b);
                    }
                }

            
            {
                c = com.helpshift.b.a.this;
                a = a2;
                b = l;
                super();
            }
            });
            d1.d.setEnabled(e);
            d1.e.setEnabled(e);
            return view;
        } else
        {
            d1.b.setVisibility(8);
            d1.c.setVisibility(8);
            return view;
        }
    }

    private View a(View view, com.helpshift.k.a a1, int l, f f1)
    {
        android.graphics.Bitmap bitmap;
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.t, null);
            w.k(b, view.findViewById(com.helpshift.b.c.aa).getBackground());
            f1.a = (LinearLayout)view.findViewById(0x102000b);
            f1.b = (ProgressBar)view.findViewById(0x102000d);
            f1.c = (ImageView)view.findViewById(0x1020010);
            f1.d = (ImageButton)view.findViewById(0x102001a);
            f1.e = (ImageButton)view.findViewById(0x102001b);
            f1.f = view.findViewById(0x102002b);
            w.f(b, f1.e.getDrawable());
            w.g(b, f1.d.getDrawable());
            view.setTag(f1);
        } else
        {
            f1 = (f)view.getTag();
        }
        bitmap = com.helpshift.i.b.a(a1.h, 250);
        f1.c.setImageBitmap(bitmap);
        if (!a1.k.booleanValue()) goto _L2; else goto _L1
_L1:
        f1.a.setVisibility(0);
        f1.b.setVisibility(0);
        f1.f.setVisibility(8);
        f1.d.setVisibility(8);
        f1.e.setVisibility(8);
_L4:
        f1.d.setEnabled(e);
        f1.e.setEnabled(e);
        return view;
_L2:
        if (!TextUtils.isEmpty(a1.h))
        {
            f1.a.setVisibility(0);
            f1.b.setVisibility(8);
            f1.f.setVisibility(0);
            f1.d.setVisibility(0);
            f1.e.setVisibility(0);
            f1.d.setOnClickListener(new android.view.View.OnClickListener(a1, l) {

                final com.helpshift.k.a a;
                final int b;
                final com.helpshift.b.a c;

                public void onClick(View view1)
                {
                    if (a.i.booleanValue())
                    {
                        com.helpshift.b.a.a(c).a(b);
                    }
                }

            
            {
                c = com.helpshift.b.a.this;
                a = a2;
                b = l;
                super();
            }
            });
            f1.e.setOnClickListener(new android.view.View.OnClickListener(a1, l) {

                final com.helpshift.k.a a;
                final int b;
                final com.helpshift.b.a c;

                public void onClick(View view1)
                {
                    if (a.i.booleanValue())
                    {
                        com.helpshift.b.a.a(c).c(b);
                    }
                }

            
            {
                c = com.helpshift.b.a.this;
                a = a2;
                b = l;
                super();
            }
            });
        } else
        if (a1.j.booleanValue())
        {
            f1.a.setVisibility(8);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private View a(View view, com.helpshift.k.a a1, int l, g g1)
    {
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.v, null);
            w.j(b, view.findViewById(com.helpshift.b.c.Z).getBackground());
            g1.a = (TextView)view.findViewById(0x1020014);
            g1.b = (ProgressBar)view.findViewById(0x102000d);
            g1.c = (ImageButton)view.findViewById(0x1020019);
            w.i(b, g1.c.getDrawable());
            g1.d = view.findViewById(0x102002b);
            view.setTag(g1);
        } else
        {
            g1 = (g)view.getTag();
        }
        g1.a.setText(com.helpshift.b.g.u);
        if (a1.k.booleanValue())
        {
            g1.b.setVisibility(0);
            g1.c.setVisibility(8);
            g1.d.setVisibility(8);
            return view;
        }
        if (!a1.j.booleanValue())
        {
            g1.b.setVisibility(8);
            g1.c.setVisibility(0);
            g1.d.setVisibility(0);
            g1.c.setOnClickListener(new android.view.View.OnClickListener(a1, l) {

                final com.helpshift.k.a a;
                final int b;
                final com.helpshift.b.a c;

                public void onClick(View view1)
                {
                    if (a.i.booleanValue())
                    {
                        com.helpshift.b.a.a(c).a(a.g, b);
                    }
                }

            
            {
                c = com.helpshift.b.a.this;
                a = a2;
                b = l;
                super();
            }
            });
            return view;
        } else
        {
            g1.b.setVisibility(8);
            g1.c.setVisibility(8);
            g1.d.setVisibility(8);
            return view;
        }
    }

    private View a(View view, com.helpshift.k.a a1, int l, h h1)
    {
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.s, null);
            w.j(b, view.findViewById(com.helpshift.b.c.Z).getBackground());
            w.k(b, view.findViewById(com.helpshift.b.c.aa).getBackground());
            h1.a = (TextView)view.findViewById(0x1020014);
            h1.b = (ImageButton)view.findViewById(0x1020019);
            w.h(b, h1.b.getDrawable());
            h1.c = (ProgressBar)view.findViewById(0x102000d);
            h1.d = (LinearLayout)view.findViewById(0x1020003);
            h1.e = (ImageView)view.findViewById(0x1020010);
            h1.f = (ImageButton)view.findViewById(0x102001a);
            h1.g = (ImageButton)view.findViewById(0x102001b);
            w.f(b, h1.g.getDrawable());
            w.g(b, h1.f.getDrawable());
            h1.h = view.findViewById(0x102002b);
            h1.i = (LinearLayout)view.findViewById(com.helpshift.b.c.Z);
            h1.j = view.findViewById(com.helpshift.b.c.ab);
            view.setTag(h1);
        } else
        {
            h1 = (h)view.getTag();
        }
        h1.a.setText(a(a1.d));
        if (a1.k.booleanValue())
        {
            h1.i.setVisibility(0);
            h1.b.setVisibility(8);
            h1.h.setVisibility(8);
            h1.d.setVisibility(0);
            a1 = com.helpshift.i.b.a(a1.h, 250);
            h1.e.setImageBitmap(a1);
            h1.c.setVisibility(0);
            h1.j.setVisibility(8);
            h1.g.setVisibility(8);
            h1.f.setVisibility(8);
        } else
        if (a1.h != null && !TextUtils.isEmpty(a1.h))
        {
            h1.i.setVisibility(0);
            h1.b.setVisibility(8);
            h1.h.setVisibility(8);
            h1.d.setVisibility(0);
            android.graphics.Bitmap bitmap = com.helpshift.i.b.a(a1.h, 250);
            h1.e.setImageBitmap(bitmap);
            h1.c.setVisibility(8);
            h1.j.setVisibility(0);
            h1.g.setVisibility(0);
            h1.f.setVisibility(0);
            h1.f.setOnClickListener(new android.view.View.OnClickListener(a1, l) {

                final com.helpshift.k.a a;
                final int b;
                final com.helpshift.b.a c;

                public void onClick(View view1)
                {
                    if (a.i.booleanValue())
                    {
                        com.helpshift.b.a.a(c).a(b);
                    }
                }

            
            {
                c = com.helpshift.b.a.this;
                a = a2;
                b = l;
                super();
            }
            });
            h1.g.setOnClickListener(new android.view.View.OnClickListener(a1, l) {

                final com.helpshift.k.a a;
                final int b;
                final com.helpshift.b.a c;

                public void onClick(View view1)
                {
                    if (a.i.booleanValue())
                    {
                        com.helpshift.b.a.a(c).c(b);
                    }
                }

            
            {
                c = com.helpshift.b.a.this;
                a = a2;
                b = l;
                super();
            }
            });
        } else
        if (!a1.j.booleanValue())
        {
            h1.i.setVisibility(0);
            h1.b.setVisibility(0);
            h1.h.setVisibility(0);
            h1.b.setOnClickListener(new android.view.View.OnClickListener(a1, l) {

                final com.helpshift.k.a a;
                final int b;
                final com.helpshift.b.a c;

                public void onClick(View view1)
                {
                    if (a.i.booleanValue())
                    {
                        com.helpshift.b.a.a(c).b(b);
                    }
                }

            
            {
                c = com.helpshift.b.a.this;
                a = a2;
                b = l;
                super();
            }
            });
            h1.d.setVisibility(8);
            h1.e.setImageBitmap(null);
            h1.c.setVisibility(8);
        } else
        {
            h1.i.setVisibility(0);
            h1.b.setVisibility(8);
            h1.h.setVisibility(8);
            h1.d.setVisibility(8);
            h1.e.setImageBitmap(null);
            h1.c.setVisibility(8);
        }
        h1.f.setEnabled(e);
        h1.g.setEnabled(e);
        h1.b.setEnabled(e);
        return view;
    }

    private View a(View view, com.helpshift.k.a a1, a a2)
    {
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.w, null);
            a2.a = (TextView)view.findViewById(0x1020014);
            view.setTag(a2);
        } else
        {
            a2 = (a)view.getTag();
        }
        a2.a.setText(com.helpshift.b.g.r);
        return view;
    }

    private View a(View view, com.helpshift.k.a a1, i l)
    {
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.u, null);
            w.k(b, view.findViewById(com.helpshift.b.c.aa).getBackground());
            l.a = (TextView)view.findViewById(0x1020014);
            l.b = (ProgressBar)view.findViewById(0x102000d);
            l.c = (ImageView)view.findViewById(0x1020010);
            view.setTag(l);
        } else
        {
            l = (i)view.getTag();
        }
        l.a.setText(com.helpshift.b.g.v);
        if (TextUtils.isEmpty(a1.h))
        {
            l.b.setVisibility(0);
            l.c.setVisibility(8);
            l.c.setImageBitmap(null);
            return view;
        } else
        {
            l.b.setVisibility(8);
            l.c.setVisibility(0);
            a1 = com.helpshift.i.b.a(a1.h, -1);
            l.c.setImageBitmap(a1);
            return view;
        }
    }

    private View a(View view, com.helpshift.k.a a1, j j1)
    {
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.o, null);
            w.j(b, view.findViewById(com.helpshift.b.c.Z).getBackground());
            j1.a = (TextView)view.findViewById(0x1020014);
            j1.b = (TextView)view.findViewById(0x1020015);
            view.setTag(j1);
        } else
        {
            j1 = (j)view.getTag();
        }
        j1.a.setText(a(a1.d));
        j1.b.setText(a1.e);
        return view;
    }

    private View a(View view, com.helpshift.k.a a1, k k1)
    {
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.p, null);
            w.k(b, view.findViewById(com.helpshift.b.c.aa).getBackground());
            k1.a = (TextView)view.findViewById(0x1020014);
            k1.b = (TextView)view.findViewById(0x1020015);
            k1.c = (ImageView)view.findViewById(0x1020006);
            view.setTag(k1);
        } else
        {
            k1 = (k)view.getTag();
        }
        if (a1.b.equals("txt") && (a1.f == -1 || a1.f == 1))
        {
            k1.a.setText(a(a1.d));
            k1.b.setText(com.helpshift.b.g.w);
            k1.c.setVisibility(8);
            return view;
        }
        if (a1.b.equals("txt") && a1.f <= -2)
        {
            k1.a.setText(a(a1.d));
            k1.a.setOnClickListener(new android.view.View.OnClickListener(a1) {

                final com.helpshift.k.a a;
                final com.helpshift.b.a b;

                public void onClick(View view1)
                {
                    com.helpshift.b.a.a(b).a(a.g);
                }

            
            {
                b = com.helpshift.b.a.this;
                a = a2;
                super();
            }
            });
            k1.b.setText(com.helpshift.b.g.x);
            k1.c.setVisibility(8);
            return view;
        } else
        {
            k1.a.setText(a(a1.d));
            k1.b.setText(a1.e);
            k1.c.setVisibility(8);
            return view;
        }
    }

    private View a(View view, com.helpshift.k.a a1, boolean flag, e e1)
    {
        if (view == null)
        {
            view = d.inflate(com.helpshift.b.d.r, null);
            w.j(b, view.findViewById(com.helpshift.b.c.Z).getBackground());
            e1.a = (TextView)view.findViewById(0x1020014);
            e1.b = (TextView)view.findViewById(0x1020015);
            view.setTag(e1);
        } else
        {
            e1 = (e)view.getTag();
        }
        if (flag)
        {
            e1.a.setText(com.helpshift.b.g.s);
        } else
        {
            e1.a.setText(com.helpshift.b.g.t);
        }
        e1.b.setText(a1.e);
        return view;
    }

    static HSMessagesFragment a(com.helpshift.b.a a1)
    {
        return a1.a;
    }

    private String a(String s)
    {
        return Html.fromHtml(s.replace("\n", "<br/>")).toString();
    }

    public void a(boolean flag)
    {
        e = flag;
    }

    public int getItemViewType(int l)
    {
        com.helpshift.k.a a1 = (com.helpshift.k.a)c.get(l);
        if (a1.b.equals("txt") && (a1.f == -1 || a1.f == 1) || a1.b.equals("txt") && a1.f <= -2 || a1.b.equals("txt") && a1.c.equals("mobile"))
        {
            return 2;
        }
        if (a1.c.equals("admin") && (a1.b.equals("txt") || a1.b.equals("rfr")))
        {
            return 1;
        }
        if (a1.b.equals("cb") && a1.c.equals("admin"))
        {
            return 5;
        }
        if (a1.b.equals("rsc") && a1.c.equals("admin"))
        {
            return !a1.g.startsWith("localRscMessage_") ? 13 : 14;
        }
        if (a1.b.equals("ca") && a1.c.equals("mobile"))
        {
            return 6;
        }
        if (a1.b.equals("ncr") && a1.c.equals("mobile"))
        {
            return 7;
        }
        if (a1.b.equals("sc") && a1.c.equals("mobile"))
        {
            return 8;
        }
        if (a1.b.equals("rar") && a1.c.equals("admin"))
        {
            return 11;
        }
        if (a1.b.equals("ar") && a1.c.equals("mobile"))
        {
            return 12;
        }
        if (a1.b.equals("admin_attachment_image"))
        {
            return 15;
        }
        if (a1.b.equals("admin_attachment_generic"))
        {
            return 16;
        }
        return !a1.b.equals("admin_attachment_image") ? 0 : 15;
    }

    public View getView(int l, View view, ViewGroup viewgroup)
    {
        viewgroup = (com.helpshift.k.a)c.get(l);
        if (viewgroup == null) goto _L2; else goto _L1
_L1:
        getItemViewType(l);
        JVM INSTR tableswitch 1 16: default 100
    //                   1 102
    //                   2 117
    //                   3 100
    //                   4 100
    //                   5 132
    //                   6 148
    //                   7 164
    //                   8 212
    //                   9 100
    //                   10 100
    //                   11 227
    //                   12 243
    //                   13 180
    //                   14 196
    //                   15 274
    //                   16 258;
           goto _L2 _L3 _L4 _L2 _L2 _L5 _L6 _L7 _L8 _L2 _L2 _L9 _L10 _L11 _L12 _L13 _L14
_L2:
        return null;
_L3:
        return a(view, viewgroup, new j());
_L4:
        return a(view, viewgroup, new k());
_L5:
        return a(view, viewgroup, l, new d());
_L6:
        return a(view, viewgroup, true, new e());
_L7:
        return a(view, viewgroup, false, new e());
_L11:
        return a(view, viewgroup, l, new h());
_L12:
        return a(view, viewgroup, l, new f());
_L8:
        return a(view, viewgroup, new i());
_L9:
        return a(view, viewgroup, l, new g());
_L10:
        return a(view, viewgroup, new a());
_L14:
        return a(view, viewgroup, l, new b());
_L13:
        return a(view, viewgroup, l, new c());
    }

    public int getViewTypeCount()
    {
        return 20;
    }

    public boolean isEnabled(int l)
    {
        return false;
    }
}
