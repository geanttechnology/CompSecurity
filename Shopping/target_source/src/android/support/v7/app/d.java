// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.internal.widget.s;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7.app:
//            l

class d
{
    public static class a
    {

        public int A;
        public boolean B;
        public boolean C[];
        public boolean D;
        public boolean E;
        public int F;
        public android.content.DialogInterface.OnMultiChoiceClickListener G;
        public Cursor H;
        public String I;
        public String J;
        public android.widget.AdapterView.OnItemSelectedListener K;
        public a L;
        public boolean M;
        public final Context a;
        public final LayoutInflater b;
        public int c;
        public Drawable d;
        public int e;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public android.content.DialogInterface.OnClickListener j;
        public CharSequence k;
        public android.content.DialogInterface.OnClickListener l;
        public CharSequence m;
        public android.content.DialogInterface.OnClickListener n;
        public boolean o;
        public android.content.DialogInterface.OnCancelListener p;
        public android.content.DialogInterface.OnDismissListener q;
        public android.content.DialogInterface.OnKeyListener r;
        public CharSequence s[];
        public ListAdapter t;
        public android.content.DialogInterface.OnClickListener u;
        public int v;
        public View w;
        public int x;
        public int y;
        public int z;

        private void b(d d1)
        {
            ListView listview = (ListView)b.inflate(d.i(d1), null);
            Object obj;
            if (D)
            {
                if (H == null)
                {
                    obj = new ArrayAdapter(this, a, d.j(d1), 0x1020014, s, listview) {

                        final ListView a;
                        final a b;

                        public View getView(int i1, View view, ViewGroup viewgroup)
                        {
                            view = super.getView(i1, view, viewgroup);
                            if (b.C != null && b.C[i1])
                            {
                                a.setItemChecked(i1, true);
                            }
                            return view;
                        }

            
            {
                b = a1;
                a = listview;
                super(context, i1, j1, acharsequence);
            }
                    };
                } else
                {
                    obj = new CursorAdapter(this, a, H, false, listview, d1) {

                        final ListView a;
                        final d b;
                        final a c;
                        private final int d;
                        private final int e;

                        public void bindView(View view, Context context, Cursor cursor)
                        {
                            ((CheckedTextView)view.findViewById(0x1020014)).setText(cursor.getString(d));
                            view = a;
                            int i1 = cursor.getPosition();
                            boolean flag;
                            if (cursor.getInt(e) == 1)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            view.setItemChecked(i1, flag);
                        }

                        public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
                        {
                            return c.b.inflate(d.j(b), viewgroup, false);
                        }

            
            {
                c = a1;
                a = listview;
                b = d1;
                super(context, cursor, flag);
                a1 = getCursor();
                d = a1.getColumnIndexOrThrow(c.I);
                e = a1.getColumnIndexOrThrow(c.J);
            }
                    };
                }
            } else
            {
                int i1;
                if (E)
                {
                    i1 = d.k(d1);
                } else
                {
                    i1 = d.l(d1);
                }
                if (H == null)
                {
                    if (t != null)
                    {
                        obj = t;
                    } else
                    {
                        obj = new c(a, i1, 0x1020014, s);
                    }
                } else
                {
                    obj = new SimpleCursorAdapter(a, i1, H, new String[] {
                        I
                    }, new int[] {
                        0x1020014
                    });
                }
            }
            if (L != null)
            {
                L.a(listview);
            }
            d.a(d1, ((ListAdapter) (obj)));
            d.a(d1, F);
            if (u != null)
            {
                listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(this, d1) {

                    final d a;
                    final a b;

                    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                    {
                        b.u.onClick(d.g(a), i1);
                        if (!b.E)
                        {
                            d.g(a).dismiss();
                        }
                    }

            
            {
                b = a1;
                a = d1;
                super();
            }
                });
            } else
            if (G != null)
            {
                listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(this, listview, d1) {

                    final ListView a;
                    final d b;
                    final a c;

                    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                    {
                        if (c.C != null)
                        {
                            c.C[i1] = a.isItemChecked(i1);
                        }
                        c.G.onClick(d.g(b), i1, a.isItemChecked(i1));
                    }

            
            {
                c = a1;
                a = listview;
                b = d1;
                super();
            }
                });
            }
            if (K != null)
            {
                listview.setOnItemSelectedListener(K);
            }
            if (E)
            {
                listview.setChoiceMode(1);
            } else
            if (D)
            {
                listview.setChoiceMode(2);
            }
            d.a(d1, listview);
        }

        public void a(d d1)
        {
            if (g == null) goto _L2; else goto _L1
_L1:
            d1.b(g);
_L10:
            if (h != null)
            {
                d1.b(h);
            }
            if (i != null)
            {
                d1.a(-1, i, j, null);
            }
            if (k != null)
            {
                d1.a(-2, k, l, null);
            }
            if (m != null)
            {
                d1.a(-3, m, n, null);
            }
            if (s != null || H != null || t != null)
            {
                b(d1);
            }
            if (w == null) goto _L4; else goto _L3
_L3:
            if (!B) goto _L6; else goto _L5
_L5:
            d1.a(w, x, y, z, A);
_L8:
            return;
_L2:
            if (f != null)
            {
                d1.a(f);
            }
            if (d != null)
            {
                d1.a(d);
            }
            if (c != 0)
            {
                d1.b(c);
            }
            if (e != 0)
            {
                d1.b(d1.c(e));
            }
            continue; /* Loop/switch isn't completed */
_L6:
            d1.c(w);
            return;
_L4:
            if (v == 0) goto _L8; else goto _L7
_L7:
            d1.a(v);
            return;
            if (true) goto _L10; else goto _L9
_L9:
        }

        public a(Context context)
        {
            c = 0;
            e = 0;
            B = false;
            F = -1;
            M = true;
            a = context;
            o = true;
            b = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }

    public static interface a.a
    {

        public abstract void a(ListView listview);
    }

    private static final class b extends Handler
    {

        private WeakReference a;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            case 0: // '\0'
            default:
                return;

            case -3: 
            case -2: 
            case -1: 
                ((android.content.DialogInterface.OnClickListener)message.obj).onClick((DialogInterface)a.get(), message.what);
                return;

            case 1: // '\001'
                ((DialogInterface)message.obj).dismiss();
                break;
            }
        }

        public b(DialogInterface dialoginterface)
        {
            a = new WeakReference(dialoginterface);
        }
    }

    private static class c extends ArrayAdapter
    {

        public long getItemId(int i1)
        {
            return (long)i1;
        }

        public boolean hasStableIds()
        {
            return true;
        }

        public c(Context context, int i1, int j1, CharSequence acharsequence[])
        {
            super(context, i1, j1, acharsequence);
        }
    }


    private TextView A;
    private TextView B;
    private View C;
    private ListAdapter D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private Handler M;
    private final android.view.View.OnClickListener N = new android.view.View.OnClickListener() {

        final d a;

        public void onClick(View view)
        {
            if (view == d.a(a) && d.b(a) != null)
            {
                view = Message.obtain(d.b(a));
            } else
            if (view == d.c(a) && d.d(a) != null)
            {
                view = Message.obtain(d.d(a));
            } else
            if (view == d.e(a) && d.f(a) != null)
            {
                view = Message.obtain(d.f(a));
            } else
            {
                view = null;
            }
            if (view != null)
            {
                view.sendToTarget();
            }
            d.h(a).obtainMessage(1, d.g(a)).sendToTarget();
        }

            
            {
                a = d.this;
                super();
            }
    };
    private final Context a;
    private final l b;
    private final Window c;
    private CharSequence d;
    private CharSequence e;
    private ListView f;
    private View g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private Button n;
    private CharSequence o;
    private Message p;
    private Button q;
    private CharSequence r;
    private Message s;
    private Button t;
    private CharSequence u;
    private Message v;
    private ScrollView w;
    private int x;
    private Drawable y;
    private ImageView z;

    public d(Context context, l l1, Window window)
    {
        m = false;
        x = 0;
        E = -1;
        L = 0;
        a = context;
        b = l1;
        c = window;
        M = new b(l1);
        context = context.obtainStyledAttributes(null, android.support.v7.a.a.k.AlertDialog, android.support.v7.a.a.a.alertDialogStyle, 0);
        F = context.getResourceId(android.support.v7.a.a.k.AlertDialog_android_layout, 0);
        G = context.getResourceId(android.support.v7.a.a.k.AlertDialog_buttonPanelSideLayout, 0);
        H = context.getResourceId(android.support.v7.a.a.k.AlertDialog_listLayout, 0);
        I = context.getResourceId(android.support.v7.a.a.k.AlertDialog_multiChoiceItemLayout, 0);
        J = context.getResourceId(android.support.v7.a.a.k.AlertDialog_singleChoiceItemLayout, 0);
        K = context.getResourceId(android.support.v7.a.a.k.AlertDialog_listItemLayout, 0);
        context.recycle();
    }

    static int a(d d1, int i1)
    {
        d1.E = i1;
        return i1;
    }

    static Button a(d d1)
    {
        return d1.n;
    }

    static ListAdapter a(d d1, ListAdapter listadapter)
    {
        d1.D = listadapter;
        return listadapter;
    }

    static ListView a(d d1, ListView listview)
    {
        d1.f = listview;
        return listview;
    }

    private void a(Button button)
    {
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)button.getLayoutParams();
        layoutparams.gravity = 1;
        layoutparams.weight = 0.5F;
        button.setLayoutParams(layoutparams);
    }

    private static boolean a(Context context)
    {
        TypedValue typedvalue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogCenterButtons, typedvalue, true);
        return typedvalue.data != 0;
    }

    static boolean a(View view)
    {
        if (view.onCheckIsTextEditor())
        {
            return true;
        }
        if (!(view instanceof ViewGroup))
        {
            return false;
        }
        view = (ViewGroup)view;
        for (int i1 = view.getChildCount(); i1 > 0;)
        {
            int j1 = i1 - 1;
            i1 = j1;
            if (a(view.getChildAt(j1)))
            {
                return true;
            }
        }

        return false;
    }

    private boolean a(ViewGroup viewgroup)
    {
        if (C != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -2);
            viewgroup.addView(C, 0, layoutparams);
            c.findViewById(android.support.v7.a.a.f.title_template).setVisibility(8);
            return true;
        }
        z = (ImageView)c.findViewById(0x1020006);
        boolean flag;
        if (!TextUtils.isEmpty(d))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            A = (TextView)c.findViewById(android.support.v7.a.a.f.alertTitle);
            A.setText(d);
            if (x != 0)
            {
                z.setImageResource(x);
                return true;
            }
            if (y != null)
            {
                z.setImageDrawable(y);
                return true;
            } else
            {
                A.setPadding(z.getPaddingLeft(), z.getPaddingTop(), z.getPaddingRight(), z.getPaddingBottom());
                z.setVisibility(8);
                return true;
            }
        } else
        {
            c.findViewById(android.support.v7.a.a.f.title_template).setVisibility(8);
            z.setVisibility(8);
            viewgroup.setVisibility(8);
            return false;
        }
    }

    private int b()
    {
        if (G == 0)
        {
            return F;
        }
        if (L == 1)
        {
            return G;
        } else
        {
            return F;
        }
    }

    static Message b(d d1)
    {
        return d1.p;
    }

    private void b(ViewGroup viewgroup)
    {
        w = (ScrollView)c.findViewById(android.support.v7.a.a.f.scrollView);
        w.setFocusable(false);
        B = (TextView)c.findViewById(0x102000b);
        if (B == null)
        {
            return;
        }
        if (e != null)
        {
            B.setText(e);
            return;
        }
        B.setVisibility(8);
        w.removeView(B);
        if (f != null)
        {
            viewgroup = (ViewGroup)w.getParent();
            int i1 = viewgroup.indexOfChild(w);
            viewgroup.removeViewAt(i1);
            viewgroup.addView(f, i1, new android.view.ViewGroup.LayoutParams(-1, -1));
            return;
        } else
        {
            viewgroup.setVisibility(8);
            return;
        }
    }

    static Button c(d d1)
    {
        return d1.q;
    }

    private void c()
    {
        boolean flag = false;
        b((ViewGroup)c.findViewById(android.support.v7.a.a.f.contentPanel));
        boolean flag1 = d();
        Object obj = (ViewGroup)c.findViewById(android.support.v7.a.a.f.topPanel);
        s s1 = android.support.v7.internal.widget.s.a(a, null, android.support.v7.a.a.k.AlertDialog, android.support.v7.a.a.a.alertDialogStyle, 0);
        a(((ViewGroup) (obj)));
        obj = c.findViewById(android.support.v7.a.a.f.buttonPanel);
        if (!flag1)
        {
            ((View) (obj)).setVisibility(8);
            obj = c.findViewById(android.support.v7.a.a.f.textSpacerNoButtons);
            if (obj != null)
            {
                ((View) (obj)).setVisibility(0);
            }
        }
        FrameLayout framelayout = (FrameLayout)c.findViewById(android.support.v7.a.a.f.customPanel);
        if (g != null)
        {
            obj = g;
        } else
        if (h != 0)
        {
            obj = LayoutInflater.from(a).inflate(h, framelayout, false);
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            flag = true;
        }
        if (!flag || !a(((View) (obj))))
        {
            c.setFlags(0x20000, 0x20000);
        }
        if (flag)
        {
            FrameLayout framelayout1 = (FrameLayout)c.findViewById(android.support.v7.a.a.f.custom);
            framelayout1.addView(((View) (obj)), new android.view.ViewGroup.LayoutParams(-1, -1));
            if (m)
            {
                framelayout1.setPadding(i, j, k, l);
            }
            if (f != null)
            {
                ((android.widget.LinearLayout.LayoutParams)framelayout.getLayoutParams()).weight = 0.0F;
            }
        } else
        {
            framelayout.setVisibility(8);
        }
        obj = f;
        if (obj != null && D != null)
        {
            ((ListView) (obj)).setAdapter(D);
            int i1 = E;
            if (i1 > -1)
            {
                ((ListView) (obj)).setItemChecked(i1, true);
                ((ListView) (obj)).setSelection(i1);
            }
        }
        s1.b();
    }

    static Message d(d d1)
    {
        return d1.s;
    }

    private boolean d()
    {
        n = (Button)c.findViewById(0x1020019);
        n.setOnClickListener(N);
        int i1;
        if (TextUtils.isEmpty(o))
        {
            n.setVisibility(8);
            i1 = 0;
        } else
        {
            n.setText(o);
            n.setVisibility(0);
            i1 = 1;
        }
        q = (Button)c.findViewById(0x102001a);
        q.setOnClickListener(N);
        if (TextUtils.isEmpty(r))
        {
            q.setVisibility(8);
        } else
        {
            q.setText(r);
            q.setVisibility(0);
            i1 |= 2;
        }
        t = (Button)c.findViewById(0x102001b);
        t.setOnClickListener(N);
        if (TextUtils.isEmpty(u))
        {
            t.setVisibility(8);
        } else
        {
            t.setText(u);
            t.setVisibility(0);
            i1 |= 4;
        }
        if (a(a))
        {
            if (i1 == 1)
            {
                a(n);
            } else
            if (i1 == 2)
            {
                a(q);
            } else
            if (i1 == 4)
            {
                a(t);
            }
        }
        return i1 != 0;
    }

    static Button e(d d1)
    {
        return d1.t;
    }

    static Message f(d d1)
    {
        return d1.v;
    }

    static l g(d d1)
    {
        return d1.b;
    }

    static Handler h(d d1)
    {
        return d1.M;
    }

    static int i(d d1)
    {
        return d1.H;
    }

    static int j(d d1)
    {
        return d1.I;
    }

    static int k(d d1)
    {
        return d1.J;
    }

    static int l(d d1)
    {
        return d1.K;
    }

    public void a()
    {
        b.a(1);
        int i1 = b();
        b.setContentView(i1);
        c();
    }

    public void a(int i1)
    {
        g = null;
        h = i1;
        m = false;
    }

    public void a(int i1, CharSequence charsequence, android.content.DialogInterface.OnClickListener onclicklistener, Message message)
    {
        Message message1 = message;
        if (message == null)
        {
            message1 = message;
            if (onclicklistener != null)
            {
                message1 = M.obtainMessage(i1, onclicklistener);
            }
        }
        switch (i1)
        {
        default:
            throw new IllegalArgumentException("Button does not exist");

        case -1: 
            o = charsequence;
            p = message1;
            return;

        case -2: 
            r = charsequence;
            s = message1;
            return;

        case -3: 
            u = charsequence;
            v = message1;
            return;
        }
    }

    public void a(Drawable drawable)
    {
label0:
        {
            y = drawable;
            x = 0;
            if (z != null)
            {
                if (drawable == null)
                {
                    break label0;
                }
                z.setImageDrawable(drawable);
            }
            return;
        }
        z.setVisibility(8);
    }

    public void a(View view, int i1, int j1, int k1, int l1)
    {
        g = view;
        h = 0;
        m = true;
        i = i1;
        j = j1;
        k = k1;
        l = l1;
    }

    public void a(CharSequence charsequence)
    {
        d = charsequence;
        if (A != null)
        {
            A.setText(charsequence);
        }
    }

    public boolean a(int i1, KeyEvent keyevent)
    {
        return w != null && w.executeKeyEvent(keyevent);
    }

    public void b(int i1)
    {
label0:
        {
            y = null;
            x = i1;
            if (z != null)
            {
                if (i1 == 0)
                {
                    break label0;
                }
                z.setImageResource(x);
            }
            return;
        }
        z.setVisibility(8);
    }

    public void b(View view)
    {
        C = view;
    }

    public void b(CharSequence charsequence)
    {
        e = charsequence;
        if (B != null)
        {
            B.setText(charsequence);
        }
    }

    public boolean b(int i1, KeyEvent keyevent)
    {
        return w != null && w.executeKeyEvent(keyevent);
    }

    public int c(int i1)
    {
        TypedValue typedvalue = new TypedValue();
        a.getTheme().resolveAttribute(i1, typedvalue, true);
        return typedvalue.resourceId;
    }

    public void c(View view)
    {
        g = view;
        h = 0;
        m = false;
    }
}
