// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.q;
import android.support.v4.view.ac;
import android.support.v4.view.ah;
import android.support.v4.view.ar;
import android.support.v4.view.bf;
import android.support.v4.view.o;
import android.support.v7.bv;
import android.support.v7.bw;
import android.support.v7.bx;
import android.support.v7.cb;
import android.support.v7.cc;
import android.support.v7.cj;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ContentFrameLayout;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.internal.widget.f;
import android.support.v7.internal.widget.i;
import android.support.v7.internal.widget.p;
import android.support.v7.internal.widget.s;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

// Referenced classes of package android.support.v7.app:
//            h, f, ActionBar

class k extends h
    implements o, android.support.v7.internal.view.menu.f.a
{
    private final class a
        implements android.support.v7.internal.view.menu.l.a
    {

        final k a;

        public void onCloseMenu(android.support.v7.internal.view.menu.f f1, boolean flag)
        {
            k.a(a, f1);
        }

        public boolean onOpenSubMenu(android.support.v7.internal.view.menu.f f1)
        {
            android.view.Window.Callback callback = a.m();
            if (callback != null)
            {
                callback.onMenuOpened(8, f1);
            }
            return true;
        }

        private a()
        {
            a = k.this;
            super();
        }

    }

    class b
        implements android.support.v7.cj.a
    {

        final k a;
        private android.support.v7.cj.a b;

        public void a(cj cj1)
        {
            b.a(cj1);
            if (a.l == null) goto _L2; else goto _L1
_L1:
            a.b.getDecorView().removeCallbacks(a.m);
            a.l.dismiss();
_L4:
            if (a.k != null)
            {
                a.k.removeAllViews();
            }
            if (a.d != null)
            {
                a.d.b(a.j);
            }
            a.j = null;
            return;
_L2:
            if (a.k != null)
            {
                a.k.setVisibility(8);
                if (a.k.getParent() != null)
                {
                    ah.u((View)a.k.getParent());
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public boolean a(cj cj1, Menu menu)
        {
            return b.a(cj1, menu);
        }

        public boolean a(cj cj1, MenuItem menuitem)
        {
            return b.a(cj1, menuitem);
        }

        public boolean b(cj cj1, Menu menu)
        {
            return b.b(cj1, menu);
        }

        public b(android.support.v7.cj.a a1)
        {
            a = k.this;
            super();
            b = a1;
        }
    }

    private class c extends FrameLayout
    {

        final k a;

        private boolean a(int i1, int j1)
        {
            return i1 < -5 || j1 < -5 || i1 > getWidth() + 5 || j1 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyevent)
        {
            return a.a(keyevent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionevent)
        {
            if (motionevent.getAction() == 0 && a((int)motionevent.getX(), (int)motionevent.getY()))
            {
                k.d(a, 0);
                return true;
            } else
            {
                return super.onInterceptTouchEvent(motionevent);
            }
        }

        public void setBackgroundResource(int i1)
        {
            setBackgroundDrawable(android.support.v7.internal.widget.p.a(getContext(), i1));
        }

        public c(Context context)
        {
            a = k.this;
            super(context);
        }
    }

    private static final class d
    {

        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        android.support.v7.internal.view.menu.f j;
        android.support.v7.internal.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q;
        boolean r;
        Bundle s;

        m a(android.support.v7.internal.view.menu.l.a a1)
        {
            if (j == null)
            {
                return null;
            }
            if (k == null)
            {
                k = new android.support.v7.internal.view.menu.e(l, android.support.v7.br.h.abc_list_menu_item_layout);
                k.a(a1);
                j.a(k);
            }
            return k.a(g);
        }

        void a(Context context)
        {
            TypedValue typedvalue = new TypedValue();
            android.content.res.Resources.Theme theme = context.getResources().newTheme();
            theme.setTo(context.getTheme());
            theme.resolveAttribute(android.support.v7.br.a.actionBarPopupTheme, typedvalue, true);
            if (typedvalue.resourceId != 0)
            {
                theme.applyStyle(typedvalue.resourceId, true);
            }
            theme.resolveAttribute(android.support.v7.br.a.panelMenuListTheme, typedvalue, true);
            if (typedvalue.resourceId != 0)
            {
                theme.applyStyle(typedvalue.resourceId, true);
            } else
            {
                theme.applyStyle(android.support.v7.br.j.Theme_AppCompat_CompactMenu, true);
            }
            context = new cb(context, 0);
            context.getTheme().setTo(theme);
            l = context;
            context = context.obtainStyledAttributes(android.support.v7.br.k.Theme);
            b = context.getResourceId(android.support.v7.br.k.Theme_panelBackground, 0);
            f = context.getResourceId(android.support.v7.br.k.Theme_android_windowAnimationStyle, 0);
            context.recycle();
        }

        void a(android.support.v7.internal.view.menu.f f1)
        {
            if (f1 != j)
            {
                if (j != null)
                {
                    j.b(k);
                }
                j = f1;
                if (f1 != null && k != null)
                {
                    f1.a(k);
                    return;
                }
            }
        }

        public boolean a()
        {
            boolean flag1 = true;
            boolean flag;
            if (h == null)
            {
                flag = false;
            } else
            {
                flag = flag1;
                if (i == null)
                {
                    flag = flag1;
                    if (k.a().getCount() <= 0)
                    {
                        return false;
                    }
                }
            }
            return flag;
        }

        d(int i1)
        {
            a = i1;
            q = false;
        }
    }

    private final class e
        implements android.support.v7.internal.view.menu.l.a
    {

        final k a;

        public void onCloseMenu(android.support.v7.internal.view.menu.f f1, boolean flag)
        {
label0:
            {
                android.support.v7.internal.view.menu.f f2 = f1.p();
                k k1;
                boolean flag1;
                if (f2 != f1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                k1 = a;
                if (flag1)
                {
                    f1 = f2;
                }
                f1 = k.a(k1, f1);
                if (f1 != null)
                {
                    if (!flag1)
                    {
                        break label0;
                    }
                    k.a(a, ((d) (f1)).a, f1, f2);
                    k.a(a, f1, true);
                }
                return;
            }
            k.a(a, f1, flag);
        }

        public boolean onOpenSubMenu(android.support.v7.internal.view.menu.f f1)
        {
            if (f1 == null && a.e)
            {
                android.view.Window.Callback callback = a.m();
                if (callback != null && !a.l())
                {
                    callback.onMenuOpened(8, f1);
                }
            }
            return true;
        }

        private e()
        {
            a = k.this;
            super();
        }

    }


    private boolean A;
    private int B;
    private final Runnable C = new Runnable() {

        final k a;

        public void run()
        {
            if ((k.a(a) & 1) != 0)
            {
                k.a(a, 0);
            }
            if ((k.a(a) & 0x100) != 0)
            {
                k.a(a, 8);
            }
            k.a(a, false);
            k.b(a, 0);
        }

            
            {
                a = k.this;
                super();
            }
    };
    private boolean D;
    private Rect E;
    private Rect F;
    private bv G;
    cj j;
    ActionBarContextView k;
    PopupWindow l;
    Runnable m;
    private f n;
    private a o;
    private e p;
    private boolean q;
    private ViewGroup r;
    private ViewGroup s;
    private TextView t;
    private View u;
    private boolean v;
    private boolean w;
    private boolean x;
    private d y[];
    private d z;

    k(Context context, Window window, android.support.v7.app.f f1)
    {
        super(context, window, f1);
    }

    static int a(k k1)
    {
        return k1.B;
    }

    private d a(int i1, boolean flag)
    {
        d ad[];
label0:
        {
            d ad1[] = y;
            if (ad1 != null)
            {
                ad = ad1;
                if (ad1.length > i1)
                {
                    break label0;
                }
            }
            ad = new d[i1 + 1];
            if (ad1 != null)
            {
                System.arraycopy(ad1, 0, ad, 0, ad1.length);
            }
            y = ad;
        }
        d d1 = ad[i1];
        if (d1 == null)
        {
            d1 = new d(i1);
            ad[i1] = d1;
            return d1;
        } else
        {
            return d1;
        }
    }

    static d a(k k1, Menu menu)
    {
        return k1.a(menu);
    }

    private d a(Menu menu)
    {
        d ad[] = y;
        int i1;
        int j1;
        if (ad != null)
        {
            i1 = ad.length;
        } else
        {
            i1 = 0;
        }
        for (j1 = 0; j1 < i1; j1++)
        {
            d d1 = ad[j1];
            if (d1 != null && d1.j == menu)
            {
                return d1;
            }
        }

        return null;
    }

    private void a(int i1, d d1, Menu menu)
    {
        d d3 = d1;
        Object obj = menu;
        if (menu == null)
        {
            d d2 = d1;
            if (d1 == null)
            {
                d2 = d1;
                if (i1 >= 0)
                {
                    d2 = d1;
                    if (i1 < y.length)
                    {
                        d2 = y[i1];
                    }
                }
            }
            d3 = d2;
            obj = menu;
            if (d2 != null)
            {
                obj = d2.j;
                d3 = d2;
            }
        }
        if (d3 == null || d3.o)
        {
            if ((d1 = m()) != null)
            {
                d1.onPanelClosed(i1, ((Menu) (obj)));
                return;
            }
        }
    }

    private void a(d d1, KeyEvent keyevent)
    {
        byte byte0 = -1;
        if (!d1.o && !l()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (d1.a != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = a;
        boolean flag;
        boolean flag1;
        if ((((Context) (obj)).getResources().getConfiguration().screenLayout & 0xf) == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((Context) (obj)).getApplicationInfo().targetSdkVersion >= 11)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && flag1) goto _L1; else goto _L3
_L3:
        WindowManager windowmanager;
        obj = m();
        if (obj != null && !((android.view.Window.Callback) (obj)).onMenuOpened(d1.a, d1.j))
        {
            a(d1, true);
            return;
        }
        windowmanager = (WindowManager)a.getSystemService("window");
        if (windowmanager == null || !b(d1, keyevent)) goto _L1; else goto _L4
_L4:
        if (d1.g != null && !d1.q) goto _L6; else goto _L5
_L5:
        if (d1.g != null) goto _L8; else goto _L7
_L7:
        if (!a(d1) || d1.g == null) goto _L1; else goto _L9
_L9:
        if (!c(d1) || !d1.a()) goto _L1; else goto _L10
_L10:
        int i1;
        keyevent = d1.h.getLayoutParams();
        if (keyevent == null)
        {
            keyevent = new android.view.ViewGroup.LayoutParams(-2, -2);
        }
        i1 = d1.b;
        d1.g.setBackgroundResource(i1);
        android.view.ViewParent viewparent = d1.h.getParent();
        if (viewparent != null && (viewparent instanceof ViewGroup))
        {
            ((ViewGroup)viewparent).removeView(d1.h);
        }
        d1.g.addView(d1.h, keyevent);
        if (!d1.h.hasFocus())
        {
            d1.h.requestFocus();
        }
        i1 = -2;
_L14:
        d1.n = false;
        keyevent = new android.view.WindowManager.LayoutParams(i1, -2, d1.d, d1.e, 1002, 0x820000, -3);
        keyevent.gravity = d1.c;
        keyevent.windowAnimations = d1.f;
        windowmanager.addView(d1.g, keyevent);
        d1.o = true;
        return;
_L8:
        if (d1.q && d1.g.getChildCount() > 0)
        {
            d1.g.removeAllViews();
        }
          goto _L9
_L6:
        if (d1.i == null) goto _L12; else goto _L11
_L11:
        keyevent = d1.i.getLayoutParams();
        if (keyevent == null) goto _L12; else goto _L13
_L13:
        i1 = byte0;
        if (((android.view.ViewGroup.LayoutParams) (keyevent)).width == -1) goto _L14; else goto _L12
_L12:
        i1 = -2;
          goto _L14
    }

    private void a(d d1, boolean flag)
    {
        if (flag && d1.a == 0 && n != null && n.e())
        {
            a(d1.j);
        } else
        {
            boolean flag1 = d1.o;
            WindowManager windowmanager = (WindowManager)a.getSystemService("window");
            if (windowmanager != null && flag1 && d1.g != null)
            {
                windowmanager.removeView(d1.g);
            }
            d1.m = false;
            d1.n = false;
            d1.o = false;
            if (flag1 && flag)
            {
                a(d1.a, d1, ((Menu) (null)));
            }
            d1.h = null;
            d1.q = true;
            if (z == d1)
            {
                z = null;
                return;
            }
        }
    }

    static void a(k k1, int i1)
    {
        k1.e(i1);
    }

    static void a(k k1, int i1, d d1, Menu menu)
    {
        k1.a(i1, d1, menu);
    }

    static void a(k k1, d d1, boolean flag)
    {
        k1.a(d1, flag);
    }

    static void a(k k1, android.support.v7.internal.view.menu.f f1)
    {
        k1.a(f1);
    }

    private void a(android.support.v7.internal.view.menu.f f1)
    {
        if (x)
        {
            return;
        }
        x = true;
        n.j();
        android.view.Window.Callback callback = m();
        if (callback != null && !l())
        {
            callback.onPanelClosed(8, f1);
        }
        x = false;
    }

    private void a(android.support.v7.internal.view.menu.f f1, boolean flag)
    {
        if (n == null || !n.d() || ar.b(ViewConfiguration.get(a)) && !n.f())
        {
            break MISSING_BLOCK_LABEL_211;
        }
        f1 = m();
        if (n.e() && flag) goto _L2; else goto _L1
_L1:
        if (f1 != null && !l())
        {
            if (A && (B & 1) != 0)
            {
                r.removeCallbacks(C);
                C.run();
            }
            d d1 = a(0, true);
            if (d1.j != null && !d1.r && f1.onPreparePanel(0, d1.i, d1.j))
            {
                f1.onMenuOpened(8, d1.j);
                n.g();
            }
        }
_L4:
        return;
_L2:
        n.h();
        if (l()) goto _L4; else goto _L3
_L3:
        f1.onPanelClosed(8, a(0, true).j);
        return;
        f1 = a(0, true);
        f1.q = true;
        a(((d) (f1)), false);
        a(((d) (f1)), ((KeyEvent) (null)));
        return;
    }

    private void a(ContentFrameLayout contentframelayout)
    {
        contentframelayout.a(r.getPaddingLeft(), r.getPaddingTop(), r.getPaddingRight(), r.getPaddingBottom());
        TypedArray typedarray = a.obtainStyledAttributes(android.support.v7.br.k.Theme);
        typedarray.getValue(android.support.v7.br.k.Theme_windowMinWidthMajor, contentframelayout.getMinWidthMajor());
        typedarray.getValue(android.support.v7.br.k.Theme_windowMinWidthMinor, contentframelayout.getMinWidthMinor());
        if (typedarray.hasValue(android.support.v7.br.k.Theme_windowFixedWidthMajor))
        {
            typedarray.getValue(android.support.v7.br.k.Theme_windowFixedWidthMajor, contentframelayout.getFixedWidthMajor());
        }
        if (typedarray.hasValue(android.support.v7.br.k.Theme_windowFixedWidthMinor))
        {
            typedarray.getValue(android.support.v7.br.k.Theme_windowFixedWidthMinor, contentframelayout.getFixedWidthMinor());
        }
        if (typedarray.hasValue(android.support.v7.br.k.Theme_windowFixedHeightMajor))
        {
            typedarray.getValue(android.support.v7.br.k.Theme_windowFixedHeightMajor, contentframelayout.getFixedHeightMajor());
        }
        if (typedarray.hasValue(android.support.v7.br.k.Theme_windowFixedHeightMinor))
        {
            typedarray.getValue(android.support.v7.br.k.Theme_windowFixedHeightMinor, contentframelayout.getFixedHeightMinor());
        }
        typedarray.recycle();
        contentframelayout.requestLayout();
    }

    private boolean a(d d1)
    {
        d1.a(k());
        d1.g = new c(d1.l);
        d1.c = 81;
        return true;
    }

    private boolean a(d d1, int i1, KeyEvent keyevent, int j1)
    {
        boolean flag;
        boolean flag2;
        flag2 = false;
        flag = false;
        if (!keyevent.isSystem()) goto _L2; else goto _L1
_L1:
        flag2 = flag;
_L4:
        return flag2;
_L2:
        boolean flag1;
label0:
        {
            if (!d1.m)
            {
                flag1 = flag2;
                if (!b(d1, keyevent))
                {
                    break label0;
                }
            }
            flag1 = flag2;
            if (d1.j != null)
            {
                flag1 = d1.j.performShortcut(i1, keyevent, j1);
            }
        }
        flag2 = flag1;
        if (flag1)
        {
            flag2 = flag1;
            if ((j1 & 1) == 0)
            {
                flag2 = flag1;
                if (n == null)
                {
                    a(d1, true);
                    return flag1;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean a(k k1, boolean flag)
    {
        k1.A = flag;
        return flag;
    }

    static int b(k k1, int i1)
    {
        k1.B = i1;
        return i1;
    }

    private boolean b(d d1)
    {
        Context context = a;
        if (d1.a != 0 && d1.a != 8 || n == null) goto _L2; else goto _L1
_L1:
        Object obj;
        TypedValue typedvalue = new TypedValue();
        android.content.res.Resources.Theme theme1 = context.getTheme();
        theme1.resolveAttribute(android.support.v7.br.a.actionBarTheme, typedvalue, true);
        obj = null;
        android.content.res.Resources.Theme theme;
        if (typedvalue.resourceId != 0)
        {
            obj = context.getResources().newTheme();
            ((android.content.res.Resources.Theme) (obj)).setTo(theme1);
            ((android.content.res.Resources.Theme) (obj)).applyStyle(typedvalue.resourceId, true);
            ((android.content.res.Resources.Theme) (obj)).resolveAttribute(android.support.v7.br.a.actionBarWidgetTheme, typedvalue, true);
        } else
        {
            theme1.resolveAttribute(android.support.v7.br.a.actionBarWidgetTheme, typedvalue, true);
        }
        theme = ((android.content.res.Resources.Theme) (obj));
        if (typedvalue.resourceId != 0)
        {
            theme = ((android.content.res.Resources.Theme) (obj));
            if (obj == null)
            {
                theme = context.getResources().newTheme();
                theme.setTo(theme1);
            }
            theme.applyStyle(typedvalue.resourceId, true);
        }
        if (theme == null) goto _L2; else goto _L3
_L3:
        obj = new cb(context, 0);
        ((Context) (obj)).getTheme().setTo(theme);
_L5:
        obj = new android.support.v7.internal.view.menu.f(((Context) (obj)));
        ((android.support.v7.internal.view.menu.f) (obj)).a(this);
        d1.a(((android.support.v7.internal.view.menu.f) (obj)));
        return true;
_L2:
        obj = context;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private boolean b(d d1, KeyEvent keyevent)
    {
        if (!l()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        android.view.Window.Callback callback;
        int i1;
        if (d1.m)
        {
            return true;
        }
        if (z != null && z != d1)
        {
            a(z, false);
        }
        callback = m();
        if (callback != null)
        {
            d1.i = callback.onCreatePanelView(d1.a);
        }
        if (d1.a == 0 || d1.a == 8)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 && n != null)
        {
            n.i();
        }
        if (d1.i != null)
        {
            break MISSING_BLOCK_LABEL_397;
        }
        if (d1.j != null && !d1.r)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        if (d1.j == null && (!b(d1) || d1.j == null))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i1 && n != null)
        {
            if (o == null)
            {
                o = new a();
            }
            n.a(d1.j, o);
        }
        d1.j.g();
        if (callback.onCreatePanelMenu(d1.a, d1.j))
        {
            break; /* Loop/switch isn't completed */
        }
        d1.a(null);
        if (i1 && n != null)
        {
            n.a(null, o);
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        d1.r = false;
        d1.j.g();
        if (d1.s != null)
        {
            d1.j.b(d1.s);
            d1.s = null;
        }
        if (!callback.onPreparePanel(0, d1.i, d1.j))
        {
            if (i1 && n != null)
            {
                n.a(null, o);
            }
            d1.j.h();
            return false;
        }
        boolean flag;
        if (keyevent != null)
        {
            i1 = keyevent.getDeviceId();
        } else
        {
            i1 = -1;
        }
        if (KeyCharacterMap.load(i1).getKeyboardType() != 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d1.p = flag;
        d1.j.setQwertyMode(d1.p);
        d1.j.h();
        d1.m = true;
        d1.n = false;
        z = d1;
        return true;
    }

    static int c(k k1, int i1)
    {
        return k1.f(i1);
    }

    private void c(int i1)
    {
        a(a(i1, true), true);
    }

    private boolean c(d d1)
    {
        if (d1.i != null)
        {
            d1.h = d1.i;
            return true;
        }
        if (d1.j == null)
        {
            return false;
        }
        if (p == null)
        {
            p = new e();
        }
        d1.h = (View)d1.a(p);
        boolean flag;
        if (d1.h != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    private void d(int i1)
    {
        B = B | 1 << i1;
        if (!A && r != null)
        {
            ah.a(r, C);
            A = true;
        }
    }

    static void d(k k1, int i1)
    {
        k1.c(i1);
    }

    private boolean d(int i1, KeyEvent keyevent)
    {
        if (keyevent.getRepeatCount() == 0)
        {
            d d1 = a(i1, true);
            if (!d1.o)
            {
                return b(d1, keyevent);
            }
        }
        return false;
    }

    private void e(int i1)
    {
        d d1 = a(i1, true);
        if (d1.j != null)
        {
            Bundle bundle = new Bundle();
            d1.j.a(bundle);
            if (bundle.size() > 0)
            {
                d1.s = bundle;
            }
            d1.j.g();
            d1.j.clear();
        }
        d1.r = true;
        d1.q = true;
        if ((i1 == 8 || i1 == 0) && n != null)
        {
            d d2 = a(0, false);
            if (d2 != null)
            {
                d2.m = false;
                b(d2, ((KeyEvent) (null)));
            }
        }
    }

    private void e(int i1, KeyEvent keyevent)
    {
        boolean flag1 = true;
        if (j == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        d d1 = a(i1, true);
        if (i1 != 0 || n == null || !n.d() || ar.b(ViewConfiguration.get(a))) goto _L4; else goto _L3
_L3:
        boolean flag;
        if (!n.e())
        {
            if (l() || !b(d1, keyevent))
            {
                break MISSING_BLOCK_LABEL_221;
            }
            flag = n.g();
        } else
        {
            flag = n.h();
        }
_L5:
        if (flag)
        {
            keyevent = (AudioManager)a.getSystemService("audio");
            if (keyevent != null)
            {
                keyevent.playSoundEffect(0);
                return;
            } else
            {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (d1.o || d1.n)
        {
            flag = d1.o;
            a(d1, true);
        } else
        {
            if (!d1.m)
            {
                break MISSING_BLOCK_LABEL_221;
            }
            if (d1.r)
            {
                d1.m = false;
                flag = b(d1, keyevent);
            } else
            {
                flag = true;
            }
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_221;
            }
            a(d1, keyevent);
            flag = flag1;
        }
          goto _L5
        flag = false;
          goto _L5
    }

    private int f(int i1)
    {
        int k1 = 1;
        boolean flag = true;
        boolean flag1 = false;
        int j1;
        if (k != null && (k.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams))
        {
            Object obj = (android.view.ViewGroup.MarginLayoutParams)k.getLayoutParams();
            if (k.isShown())
            {
                if (E == null)
                {
                    E = new Rect();
                    F = new Rect();
                }
                Rect rect = E;
                Rect rect1 = F;
                rect.set(0, i1, 0, 0);
                android.support.v7.internal.widget.s.a(s, rect, rect1);
                if (rect1.top == 0)
                {
                    j1 = i1;
                } else
                {
                    j1 = 0;
                }
                if (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin != j1)
                {
                    obj.topMargin = i1;
                    if (u == null)
                    {
                        u = new View(a);
                        u.setBackgroundColor(a.getResources().getColor(android.support.v7.br.c.abc_input_method_navigation_guard));
                        s.addView(u, -1, new android.view.ViewGroup.LayoutParams(-1, i1));
                        j1 = 1;
                    } else
                    {
                        android.view.ViewGroup.LayoutParams layoutparams = u.getLayoutParams();
                        if (layoutparams.height != i1)
                        {
                            layoutparams.height = i1;
                            u.setLayoutParams(layoutparams);
                        }
                        j1 = 1;
                    }
                } else
                {
                    j1 = 0;
                }
                if (u == null)
                {
                    flag = false;
                }
                k1 = i1;
                if (!g)
                {
                    k1 = i1;
                    if (flag)
                    {
                        k1 = 0;
                    }
                }
                i1 = k1;
                k1 = j1;
                j1 = ((flag) ? 1 : 0);
            } else
            if (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin != 0)
            {
                obj.topMargin = 0;
                j1 = 0;
            } else
            {
                k1 = 0;
                j1 = 0;
            }
            if (k1 != 0)
            {
                k.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            }
        } else
        {
            j1 = 0;
        }
        if (u != null)
        {
            obj = u;
            if (j1 != 0)
            {
                j1 = ((flag1) ? 1 : 0);
            } else
            {
                j1 = 8;
            }
            ((View) (obj)).setVisibility(j1);
        }
        return i1;
    }

    private void p()
    {
        Object obj;
        if (q)
        {
            break MISSING_BLOCK_LABEL_515;
        }
        obj = LayoutInflater.from(a);
        if (i) goto _L2; else goto _L1
_L1:
        if (!h) goto _L4; else goto _L3
_L3:
        s = (ViewGroup)((LayoutInflater) (obj)).inflate(android.support.v7.br.h.abc_dialog_title_material, null);
        f = false;
        e = false;
_L6:
        if (s == null)
        {
            throw new IllegalArgumentException("AppCompat does not support the current theme features");
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (e)
        {
            obj = new TypedValue();
            a.getTheme().resolveAttribute(android.support.v7.br.a.actionBarTheme, ((TypedValue) (obj)), true);
            if (((TypedValue) (obj)).resourceId != 0)
            {
                obj = new cb(a, ((TypedValue) (obj)).resourceId);
            } else
            {
                obj = a;
            }
            s = (ViewGroup)LayoutInflater.from(((Context) (obj))).inflate(android.support.v7.br.h.abc_screen_toolbar, null);
            n = (f)s.findViewById(android.support.v7.br.f.decor_content_parent);
            n.setWindowCallback(m());
            if (f)
            {
                n.a(9);
            }
            if (v)
            {
                n.a(2);
            }
            if (w)
            {
                n.a(5);
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (g)
        {
            s = (ViewGroup)((LayoutInflater) (obj)).inflate(android.support.v7.br.h.abc_screen_simple_overlay_action_mode, null);
        } else
        {
            s = (ViewGroup)((LayoutInflater) (obj)).inflate(android.support.v7.br.h.abc_screen_simple, null);
        }
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            ah.a(s, new ac() {

                final k a;

                public bf a(View view1, bf bf1)
                {
                    int i1 = bf1.b();
                    int j1 = k.c(a, i1);
                    bf bf2 = bf1;
                    if (i1 != j1)
                    {
                        bf2 = bf1.a(bf1.a(), j1, bf1.c(), bf1.d());
                    }
                    return ah.a(view1, bf2);
                }

            
            {
                a = k.this;
                super();
            }
            });
        } else
        {
            ((i)s).setOnFitSystemWindowsListener(new android.support.v7.internal.widget.i.a() {

                final k a;

                public void a(Rect rect)
                {
                    rect.top = k.c(a, rect.top);
                }

            
            {
                a = k.this;
                super();
            }
            });
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (n == null)
        {
            t = (TextView)s.findViewById(android.support.v7.br.f.title);
        }
        android.support.v7.internal.widget.s.b(s);
        Object obj2 = (ViewGroup)b.findViewById(0x1020002);
        Object obj1 = (ContentFrameLayout)s.findViewById(android.support.v7.br.f.action_bar_activity_content);
        View view;
        for (; ((ViewGroup) (obj2)).getChildCount() > 0; ((ContentFrameLayout) (obj1)).addView(view))
        {
            view = ((ViewGroup) (obj2)).getChildAt(0);
            ((ViewGroup) (obj2)).removeViewAt(0);
        }

        b.setContentView(s);
        ((ViewGroup) (obj2)).setId(-1);
        ((ContentFrameLayout) (obj1)).setId(0x1020002);
        if (obj2 instanceof FrameLayout)
        {
            ((FrameLayout)obj2).setForeground(null);
        }
        obj2 = n();
        if (!TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            b(((CharSequence) (obj2)));
        }
        a(((ContentFrameLayout) (obj1)));
        a(s);
        q = true;
        obj1 = a(0, false);
        if (!l() && (obj1 == null || ((d) (obj1)).j == null))
        {
            d(8);
        }
    }

    private void q()
    {
        if (q)
        {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        } else
        {
            return;
        }
    }

    cj a(android.support.v7.cj.a a1)
    {
        if (j != null)
        {
            j.c();
        }
        b b1 = new b(a1);
        Object obj;
        Object obj1;
        android.content.res.Resources.Theme theme;
        int i1;
        boolean flag;
        if (d != null && !l())
        {
            try
            {
                obj = d.a(b1);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = null;
            }
        } else
        {
            obj = null;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        j = ((cj) (obj));
_L4:
        if (j != null && d != null)
        {
            d.a(j);
        }
        return j;
_L2:
        if (k == null)
        {
            if (h)
            {
                obj1 = new TypedValue();
                obj = a.getTheme();
                ((android.content.res.Resources.Theme) (obj)).resolveAttribute(android.support.v7.br.a.actionBarTheme, ((TypedValue) (obj1)), true);
                if (((TypedValue) (obj1)).resourceId != 0)
                {
                    theme = a.getResources().newTheme();
                    theme.setTo(((android.content.res.Resources.Theme) (obj)));
                    theme.applyStyle(((TypedValue) (obj1)).resourceId, true);
                    obj = new cb(a, 0);
                    ((Context) (obj)).getTheme().setTo(theme);
                } else
                {
                    obj = a;
                }
                k = new ActionBarContextView(((Context) (obj)));
                l = new PopupWindow(((Context) (obj)), null, android.support.v7.br.a.actionModePopupWindowStyle);
                l.setContentView(k);
                l.setWidth(-1);
                ((Context) (obj)).getTheme().resolveAttribute(android.support.v7.br.a.actionBarSize, ((TypedValue) (obj1)), true);
                i1 = TypedValue.complexToDimensionPixelSize(((TypedValue) (obj1)).data, ((Context) (obj)).getResources().getDisplayMetrics());
                k.setContentHeight(i1);
                l.setHeight(-2);
                m = new Runnable() {

                    final k a;

                    public void run()
                    {
                        a.l.showAtLocation(a.k, 55, 0, 0);
                    }

            
            {
                a = k.this;
                super();
            }
                };
            } else
            {
                obj = (ViewStubCompat)s.findViewById(android.support.v7.br.f.action_mode_bar_stub);
                if (obj != null)
                {
                    ((ViewStubCompat) (obj)).setLayoutInflater(LayoutInflater.from(k()));
                    k = (ActionBarContextView)((ViewStubCompat) (obj)).a();
                }
            }
        }
        if (k != null)
        {
            k.c();
            obj = k.getContext();
            obj1 = k;
            if (l == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = new cc(((Context) (obj)), ((ActionBarContextView) (obj1)), b1, flag);
            if (a1.a(((cj) (obj)), ((cj) (obj)).b()))
            {
                ((cj) (obj)).d();
                k.a(((cj) (obj)));
                k.setVisibility(0);
                j = ((cj) (obj));
                if (l != null)
                {
                    b.getDecorView().post(m);
                }
                k.sendAccessibilityEvent(32);
                if (k.getParent() != null)
                {
                    ah.u((View)k.getParent());
                }
            } else
            {
                j = null;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final View a(View view, String s1, Context context, AttributeSet attributeset)
    {
        View view1 = b(view, s1, context, attributeset);
        if (view1 != null)
        {
            return view1;
        } else
        {
            return c(view, s1, context, attributeset);
        }
    }

    public void a(int i1)
    {
        p();
        ViewGroup viewgroup = (ViewGroup)s.findViewById(0x1020002);
        viewgroup.removeAllViews();
        LayoutInflater.from(a).inflate(i1, viewgroup);
        c.onContentChanged();
    }

    public void a(Configuration configuration)
    {
        if (e && q)
        {
            ActionBar actionbar = a();
            if (actionbar != null)
            {
                actionbar.a(configuration);
            }
        }
    }

    public void a(Bundle bundle)
    {
label0:
        {
            super.a(bundle);
            r = (ViewGroup)b.getDecorView();
            if ((c instanceof Activity) && android.support.v4.app.q.b((Activity)c) != null)
            {
                bundle = j();
                if (bundle != null)
                {
                    break label0;
                }
                D = true;
            }
            return;
        }
        bundle.f(true);
    }

    public void a(Toolbar toolbar)
    {
        if (!(c instanceof Activity))
        {
            return;
        }
        if (a() instanceof bx)
        {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        } else
        {
            toolbar = new bw(toolbar, ((Activity)a).getTitle(), b);
            a(((ActionBar) (toolbar)));
            b.setCallback(toolbar.f());
            toolbar.d();
            return;
        }
    }

    public void a(View view)
    {
        p();
        ViewGroup viewgroup = (ViewGroup)s.findViewById(0x1020002);
        viewgroup.removeAllViews();
        viewgroup.addView(view);
        c.onContentChanged();
    }

    public void a(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        p();
        ViewGroup viewgroup = (ViewGroup)s.findViewById(0x1020002);
        viewgroup.removeAllViews();
        viewgroup.addView(view, layoutparams);
        c.onContentChanged();
    }

    void a(ViewGroup viewgroup)
    {
    }

    boolean a(int i1, KeyEvent keyevent)
    {
        ActionBar actionbar = a();
        if (actionbar == null || !actionbar.a(i1, keyevent)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (z == null || !a(z, keyevent.getKeyCode(), keyevent, 1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (z != null)
        {
            z.n = true;
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag;
        if (z != null)
        {
            break; /* Loop/switch isn't completed */
        }
        d d1 = a(0, true);
        b(d1, keyevent);
        flag = a(d1, keyevent.getKeyCode(), keyevent, 1);
        d1.m = false;
        if (flag) goto _L1; else goto _L4
_L4:
        return false;
    }

    boolean a(int i1, Menu menu)
    {
        if (i1 == 8)
        {
            menu = a();
            if (menu != null)
            {
                menu.h(false);
            }
            return true;
        }
        if (i1 == 0)
        {
            menu = a(i1, true);
            if (((d) (menu)).o)
            {
                a(((d) (menu)), false);
            }
        }
        return false;
    }

    boolean a(KeyEvent keyevent)
    {
        int i1 = keyevent.getKeyCode();
        boolean flag;
        if (keyevent.getAction() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return c(i1, keyevent);
        } else
        {
            return b(i1, keyevent);
        }
    }

    public cj b(android.support.v7.cj.a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (j != null)
        {
            j.c();
        }
        a1 = new b(a1);
        ActionBar actionbar = a();
        if (actionbar != null)
        {
            j = actionbar.a(a1);
            if (j != null && d != null)
            {
                d.a(j);
            }
        }
        if (j == null)
        {
            j = a(a1);
        }
        return j;
    }

    View b(View view, String s1, Context context, AttributeSet attributeset)
    {
        if (c instanceof android.view.LayoutInflater.Factory)
        {
            view = ((android.view.LayoutInflater.Factory)c).onCreateView(s1, context, attributeset);
            if (view != null)
            {
                return view;
            }
        }
        return null;
    }

    public void b(Bundle bundle)
    {
        p();
    }

    public void b(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        p();
        ((ViewGroup)s.findViewById(0x1020002)).addView(view, layoutparams);
        c.onContentChanged();
    }

    void b(CharSequence charsequence)
    {
        if (n != null)
        {
            n.setWindowTitle(charsequence);
        } else
        {
            if (j() != null)
            {
                j().b(charsequence);
                return;
            }
            if (t != null)
            {
                t.setText(charsequence);
                return;
            }
        }
    }

    public boolean b(int i1)
    {
        switch (i1)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return b.requestFeature(i1);

        case 8: // '\b'
            q();
            e = true;
            return true;

        case 9: // '\t'
            q();
            f = true;
            return true;

        case 10: // '\n'
            q();
            g = true;
            return true;

        case 2: // '\002'
            q();
            v = true;
            return true;

        case 5: // '\005'
            q();
            w = true;
            return true;

        case 1: // '\001'
            q();
            i = true;
            return true;
        }
    }

    boolean b(int i1, KeyEvent keyevent)
    {
        i1;
        JVM INSTR lookupswitch 2: default 28
    //                   4: 38
    //                   82: 30;
           goto _L1 _L2 _L3
_L1:
        return false;
_L3:
        e(0, keyevent);
        return true;
_L2:
        keyevent = a(0, false);
        if (keyevent != null && ((d) (keyevent)).o)
        {
            a(keyevent, true);
            return true;
        }
        if (o())
        {
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    boolean b(int i1, Menu menu)
    {
        if (i1 == 8)
        {
            menu = a();
            if (menu != null)
            {
                menu.h(true);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public View c(View view, String s1, Context context, AttributeSet attributeset)
    {
        boolean flag;
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (G == null)
        {
            G = new bv();
        }
        if (flag && q && view != null && view.getId() != 0x1020002 && !ah.B(view))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return G.a(view, s1, context, attributeset, flag1, flag, true);
    }

    public void c()
    {
        ActionBar actionbar = a();
        if (actionbar != null)
        {
            actionbar.g(false);
        }
    }

    boolean c(int i1, KeyEvent keyevent)
    {
        boolean flag = false;
        switch (i1)
        {
        default:
            if (android.os.Build.VERSION.SDK_INT < 11)
            {
                flag = a(i1, keyevent);
            }
            return flag;

        case 82: // 'R'
            d(0, keyevent);
            return true;
        }
    }

    public void d()
    {
        ActionBar actionbar = a();
        if (actionbar != null)
        {
            actionbar.g(true);
        }
    }

    public void e()
    {
        ActionBar actionbar = a();
        if (actionbar != null && actionbar.d())
        {
            return;
        } else
        {
            d(0);
            return;
        }
    }

    public void h()
    {
        LayoutInflater layoutinflater = LayoutInflater.from(a);
        if (layoutinflater.getFactory() == null)
        {
            android.support.v4.view.k.a(layoutinflater, this);
            return;
        } else
        {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
            return;
        }
    }

    public ActionBar i()
    {
        bx bx1;
        p();
        bx1 = null;
        if (!(c instanceof Activity)) goto _L2; else goto _L1
_L1:
        bx1 = new bx((Activity)c, f);
_L4:
        if (bx1 != null)
        {
            bx1.f(D);
        }
        return bx1;
_L2:
        if (c instanceof Dialog)
        {
            bx1 = new bx((Dialog)c);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean o()
    {
        if (j != null)
        {
            j.c();
        } else
        {
            ActionBar actionbar = a();
            if (actionbar == null || !actionbar.e())
            {
                return false;
            }
        }
        return true;
    }

    public boolean onMenuItemSelected(android.support.v7.internal.view.menu.f f1, MenuItem menuitem)
    {
        android.view.Window.Callback callback = m();
        if (callback != null && !l())
        {
            f1 = a(f1.p());
            if (f1 != null)
            {
                return callback.onMenuItemSelected(((d) (f1)).a, menuitem);
            }
        }
        return false;
    }

    public void onMenuModeChange(android.support.v7.internal.view.menu.f f1)
    {
        a(f1, true);
    }
}
