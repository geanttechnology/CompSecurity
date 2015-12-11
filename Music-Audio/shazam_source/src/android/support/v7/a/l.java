// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

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
import android.support.v4.view.aa;
import android.support.v4.view.ak;
import android.support.v4.view.k;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v7.e.a;
import android.support.v7.internal.a.c;
import android.support.v7.internal.view.b;
import android.support.v7.internal.view.menu.e;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ContentFrameLayout;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.internal.widget.g;
import android.support.v7.internal.widget.i;
import android.support.v7.internal.widget.t;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.d;
import android.support.v7.widget.h;
import android.support.v7.widget.j;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
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

// Referenced classes of package android.support.v7.a:
//            i, a, g

class l extends android.support.v7.a.i
    implements k, android.support.v7.internal.view.menu.f.a
{
    private final class a
        implements android.support.v7.internal.view.menu.a
    {

        final l a;

        public final void a(f f1, boolean flag)
        {
            a.b(f1);
        }

        public final boolean a(f f1)
        {
            android.view.Window.Callback callback = ((android.support.v7.a.i) (a)).b.getCallback();
            if (callback != null)
            {
                callback.onMenuOpened(8, f1);
            }
            return true;
        }

        private a()
        {
            a = l.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    final class b
        implements android.support.v7.e.a.a
    {

        final l a;
        private android.support.v7.e.a.a b;

        public final void a(android.support.v7.e.a a1)
        {
            b.a(a1);
            if (a.q == null) goto _L2; else goto _L1
_L1:
            a.b.getDecorView().removeCallbacks(a.r);
            a.q.dismiss();
_L4:
            if (a.p != null)
            {
                a.p.removeAllViews();
            }
            if (a.e != null)
            {
                a.e.onSupportActionModeFinished(a.o);
            }
            a.o = null;
            return;
_L2:
            if (a.p != null)
            {
                a.p.setVisibility(8);
                if (a.p.getParent() != null)
                {
                    android.support.v4.view.w.q((View)a.p.getParent());
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final boolean a(android.support.v7.e.a a1, Menu menu)
        {
            return b.a(a1, menu);
        }

        public final boolean a(android.support.v7.e.a a1, MenuItem menuitem)
        {
            return b.a(a1, menuitem);
        }

        public final boolean b(android.support.v7.e.a a1, Menu menu)
        {
            return b.b(a1, menu);
        }

        public b(android.support.v7.e.a.a a1)
        {
            a = l.this;
            super();
            b = a1;
        }
    }

    private final class c extends FrameLayout
    {

        final l a;

        public final boolean dispatchKeyEvent(KeyEvent keyevent)
        {
            return a.a(keyevent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionevent)
        {
            if (motionevent.getAction() == 0)
            {
                int i1 = (int)motionevent.getX();
                int j1 = (int)motionevent.getY();
                boolean flag;
                if (i1 < -5 || j1 < -5 || i1 > getWidth() + 5 || j1 > getHeight() + 5)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    motionevent = a;
                    motionevent.a(motionevent.e(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionevent);
        }

        public final void setBackgroundResource(int i1)
        {
            setBackgroundDrawable(android.support.v7.internal.widget.q.a(getContext(), i1));
        }

        public c(Context context)
        {
            a = l.this;
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
        f j;
        android.support.v7.internal.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q;
        boolean r;
        Bundle s;

        final void a(f f1)
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

        d(int i1)
        {
            a = i1;
            q = false;
        }
    }

    private final class e
        implements android.support.v7.internal.view.menu.a
    {

        final l a;

        public final void a(f f1, boolean flag)
        {
label0:
            {
                f f2 = f1.k();
                l l1;
                boolean flag1;
                if (f2 != f1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                l1 = a;
                if (flag1)
                {
                    f1 = f2;
                }
                f1 = l1.a(f1);
                if (f1 != null)
                {
                    if (!flag1)
                    {
                        break label0;
                    }
                    a.a(((d) (f1)).a, f1, f2);
                    a.a(f1, true);
                }
                return;
            }
            a.a(f1, flag);
        }

        public final boolean a(f f1)
        {
            if (f1 == null && a.g)
            {
                android.view.Window.Callback callback = ((android.support.v7.a.i) (a)).b.getCallback();
                if (callback != null && !((android.support.v7.a.i) (a)).m)
                {
                    callback.onMenuOpened(8, f1);
                }
            }
            return true;
        }

        private e()
        {
            a = l.this;
            super();
        }

        e(byte byte0)
        {
            this();
        }
    }


    private View A;
    private boolean B;
    private boolean C;
    private boolean D;
    private d E[];
    private d F;
    private final Runnable G = new Runnable() {

        final l a;

        public final void run()
        {
            if ((a.t & 1) != 0)
            {
                android.support.v7.a.l.a(a, 0);
            }
            if ((a.t & 0x100) != 0)
            {
                android.support.v7.a.l.a(a, 8);
            }
            a.s = false;
            a.t = 0;
        }

            
            {
                a = l.this;
                super();
            }
    };
    private boolean H;
    private Rect I;
    private Rect J;
    private android.support.v7.internal.a.a K;
    private g n;
    android.support.v7.e.a o;
    ActionBarContextView p;
    PopupWindow q;
    Runnable r;
    boolean s;
    int t;
    private a u;
    private e v;
    private boolean w;
    private ViewGroup x;
    private ViewGroup y;
    private TextView z;

    l(Context context, Window window, android.support.v7.a.g g1)
    {
        super(context, window, g1);
    }

    private void a(d d1, KeyEvent keyevent)
    {
        byte byte0 = -1;
        if (!d1.o && !super.m) goto _L2; else goto _L1
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
        obj = super.b.getCallback();
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
        int i1;
        Object obj1 = k();
        TypedValue typedvalue = new TypedValue();
        keyevent = ((Context) (obj1)).getResources().newTheme();
        keyevent.setTo(((Context) (obj1)).getTheme());
        keyevent.resolveAttribute(android.support.v7.b.a.a.actionBarPopupTheme, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            keyevent.applyStyle(typedvalue.resourceId, true);
        }
        keyevent.resolveAttribute(android.support.v7.b.a.a.panelMenuListTheme, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            keyevent.applyStyle(typedvalue.resourceId, true);
        } else
        {
            keyevent.applyStyle(android.support.v7.b.a.j.Theme_AppCompat_CompactMenu, true);
        }
        obj1 = new android.support.v7.internal.view.b(((Context) (obj1)), 0);
        ((Context) (obj1)).getTheme().setTo(keyevent);
        d1.l = ((Context) (obj1));
        keyevent = ((Context) (obj1)).obtainStyledAttributes(android.support.v7.b.a.k.Theme);
        d1.b = keyevent.getResourceId(android.support.v7.b.a.k.Theme_panelBackground, 0);
        d1.f = keyevent.getResourceId(android.support.v7.b.a.k.Theme_android_windowAnimationStyle, 0);
        keyevent.recycle();
        d1.g = new c(d1.l);
        d1.c = 81;
        if (d1.g == null) goto _L1; else goto _L9
_L9:
        if (d1.i != null)
        {
            d1.h = d1.i;
            i1 = 1;
        } else
        {
label0:
            {
                if (d1.j == null)
                {
                    break label0;
                }
                if (v == null)
                {
                    v = new e((byte)0);
                }
                keyevent = v;
                if (d1.j == null)
                {
                    keyevent = null;
                } else
                {
                    if (d1.k == null)
                    {
                        d1.k = new android.support.v7.internal.view.menu.e(d1.l, android.support.v7.b.a.h.abc_list_menu_item_layout);
                        d1.k.g = keyevent;
                        d1.j.a(d1.k);
                    }
                    keyevent = d1.k.a(d1.g);
                }
                d1.h = (View)keyevent;
                if (d1.h == null)
                {
                    break label0;
                }
                i1 = 1;
            }
        }
_L16:
        if (i1 == 0) goto _L1; else goto _L10
_L10:
        if (d1.h == null) goto _L12; else goto _L11
_L11:
        if (d1.i == null) goto _L14; else goto _L13
_L13:
        i1 = 1;
_L18:
        if (i1 == 0) goto _L1; else goto _L15
_L15:
        keyevent = d1.h.getLayoutParams();
        if (keyevent == null)
        {
            keyevent = new android.view.ViewGroup.LayoutParams(-2, -2);
        }
        i1 = d1.b;
        d1.g.setBackgroundResource(i1);
        obj1 = d1.h.getParent();
        if (obj1 != null && (obj1 instanceof ViewGroup))
        {
            ((ViewGroup)obj1).removeView(d1.h);
        }
        d1.g.addView(d1.h, keyevent);
        if (!d1.h.hasFocus())
        {
            d1.h.requestFocus();
        }
        i1 = -2;
_L22:
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
        i1 = 0;
          goto _L16
_L14:
        if (d1.k.b().getCount() <= 0) goto _L12; else goto _L17
_L17:
        i1 = 1;
          goto _L18
_L12:
        i1 = 0;
          goto _L18
_L6:
        if (d1.i == null) goto _L20; else goto _L19
_L19:
        keyevent = d1.i.getLayoutParams();
        if (keyevent == null) goto _L20; else goto _L21
_L21:
        i1 = byte0;
        if (((android.view.ViewGroup.LayoutParams) (keyevent)).width == -1) goto _L22; else goto _L20
_L20:
        i1 = -2;
          goto _L22
    }

    static void a(l l1, int i1)
    {
        d d1 = l1.e(i1);
        if (d1.j != null)
        {
            Bundle bundle = new Bundle();
            d1.j.a(bundle);
            if (bundle.size() > 0)
            {
                d1.s = bundle;
            }
            d1.j.d();
            d1.j.clear();
        }
        d1.r = true;
        d1.q = true;
        if ((i1 == 8 || i1 == 0) && l1.n != null)
        {
            d d2 = l1.e(0);
            if (d2 != null)
            {
                d2.m = false;
                l1.b(d2, ((KeyEvent) (null)));
            }
        }
    }

    private boolean a(d d1, int i1, KeyEvent keyevent)
    {
        while (keyevent.isSystem() || !d1.m && !b(d1, keyevent) || d1.j == null) 
        {
            return false;
        }
        return d1.j.performShortcut(i1, keyevent, 1);
    }

    static int b(l l1, int i1)
    {
        int k1 = 1;
        boolean flag = true;
        boolean flag1 = false;
        int j1;
        if (l1.p != null && (l1.p.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams))
        {
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)l1.p.getLayoutParams();
            if (l1.p.isShown())
            {
                if (l1.I == null)
                {
                    l1.I = new Rect();
                    l1.J = new Rect();
                }
                Rect rect = l1.I;
                Rect rect1 = l1.J;
                rect.set(0, i1, 0, 0);
                android.support.v7.internal.widget.t.a(l1.y, rect, rect1);
                if (rect1.top == 0)
                {
                    j1 = i1;
                } else
                {
                    j1 = 0;
                }
                if (marginlayoutparams.topMargin != j1)
                {
                    marginlayoutparams.topMargin = i1;
                    if (l1.A == null)
                    {
                        l1.A = new View(l1.a);
                        l1.A.setBackgroundColor(l1.a.getResources().getColor(android.support.v7.b.a.c.abc_input_method_navigation_guard));
                        l1.y.addView(l1.A, -1, new android.view.ViewGroup.LayoutParams(-1, i1));
                        j1 = 1;
                    } else
                    {
                        android.view.ViewGroup.LayoutParams layoutparams = l1.A.getLayoutParams();
                        if (layoutparams.height != i1)
                        {
                            layoutparams.height = i1;
                            l1.A.setLayoutParams(layoutparams);
                        }
                        j1 = 1;
                    }
                } else
                {
                    j1 = 0;
                }
                if (l1.A == null)
                {
                    flag = false;
                }
                k1 = i1;
                if (!l1.i)
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
            if (marginlayoutparams.topMargin != 0)
            {
                marginlayoutparams.topMargin = 0;
                j1 = 0;
            } else
            {
                k1 = 0;
                j1 = 0;
            }
            if (k1 != 0)
            {
                l1.p.setLayoutParams(marginlayoutparams);
            }
        } else
        {
            j1 = 0;
        }
        if (l1.A != null)
        {
            l1 = l1.A;
            if (j1 != 0)
            {
                j1 = ((flag1) ? 1 : 0);
            } else
            {
                j1 = 8;
            }
            l1.setVisibility(j1);
        }
        return i1;
    }

    private boolean b(d d1, KeyEvent keyevent)
    {
        if (!super.m) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Object obj;
        Context context;
        android.view.Window.Callback callback;
        int i1;
        if (d1.m)
        {
            return true;
        }
        if (F != null && F != d1)
        {
            a(F, false);
        }
        callback = super.b.getCallback();
        if (callback != null)
        {
            d1.i = callback.onCreatePanelView(d1.a);
        }
        android.content.res.Resources.Theme theme;
        if (d1.a == 0 || d1.a == 8)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 && n != null)
        {
            n.f();
        }
        if (d1.i != null || i1 && (super.f instanceof android.support.v7.internal.a.c)) goto _L4; else goto _L3
_L3:
        if (d1.j != null && !d1.r) goto _L6; else goto _L5
_L5:
        if (d1.j != null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = a;
        if (d1.a != 0 && d1.a != 8 || n == null)
        {
            break MISSING_BLOCK_LABEL_649;
        }
        TypedValue typedvalue = new TypedValue();
        android.content.res.Resources.Theme theme1 = context.getTheme();
        theme1.resolveAttribute(android.support.v7.b.a.a.actionBarTheme, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            obj = context.getResources().newTheme();
            ((android.content.res.Resources.Theme) (obj)).setTo(theme1);
            ((android.content.res.Resources.Theme) (obj)).applyStyle(typedvalue.resourceId, true);
            ((android.content.res.Resources.Theme) (obj)).resolveAttribute(android.support.v7.b.a.a.actionBarWidgetTheme, typedvalue, true);
        } else
        {
            theme1.resolveAttribute(android.support.v7.b.a.a.actionBarWidgetTheme, typedvalue, true);
            obj = null;
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
        if (theme == null)
        {
            break MISSING_BLOCK_LABEL_649;
        }
        obj = new android.support.v7.internal.view.b(context, 0);
        ((Context) (obj)).getTheme().setTo(theme);
_L8:
        obj = new f(((Context) (obj)));
        ((f) (obj)).a(this);
        d1.a(((f) (obj)));
        if (d1.j == null) goto _L1; else goto _L7
_L7:
label0:
        {
            if (i1 && n != null)
            {
                if (u == null)
                {
                    u = new a((byte)0);
                }
                n.a(d1.j, u);
            }
            d1.j.d();
            if (callback.onCreatePanelMenu(d1.a, d1.j))
            {
                break label0;
            }
            d1.a(null);
            if (i1 && n != null)
            {
                n.a(null, u);
                return false;
            }
        }
          goto _L1
        d1.r = false;
_L6:
        d1.j.d();
        if (d1.s != null)
        {
            d1.j.b(d1.s);
            d1.s = null;
        }
        if (!callback.onPreparePanel(0, d1.i, d1.j))
        {
            if (i1 && n != null)
            {
                n.a(null, u);
            }
            d1.j.e();
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
        d1.j.e();
_L4:
        d1.m = true;
        d1.n = false;
        F = d1;
        return true;
        obj = context;
          goto _L8
    }

    private void f(int i1)
    {
        t = t | 1 << i1;
        if (!s && x != null)
        {
            android.support.v4.view.w.a(x, G);
            s = true;
        }
    }

    private void l()
    {
        Object obj;
        if (w)
        {
            break MISSING_BLOCK_LABEL_713;
        }
        obj = LayoutInflater.from(a);
        if (k) goto _L2; else goto _L1
_L1:
        if (!j) goto _L4; else goto _L3
_L3:
        y = (ViewGroup)((LayoutInflater) (obj)).inflate(android.support.v7.b.a.h.abc_dialog_title_material, null);
        h = false;
        g = false;
_L6:
        if (y == null)
        {
            throw new IllegalArgumentException("AppCompat does not support the current theme features");
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (g)
        {
            obj = new TypedValue();
            a.getTheme().resolveAttribute(android.support.v7.b.a.a.actionBarTheme, ((TypedValue) (obj)), true);
            if (((TypedValue) (obj)).resourceId != 0)
            {
                obj = new android.support.v7.internal.view.b(a, ((TypedValue) (obj)).resourceId);
            } else
            {
                obj = a;
            }
            y = (ViewGroup)LayoutInflater.from(((Context) (obj))).inflate(android.support.v7.b.a.h.abc_screen_toolbar, null);
            n = (g)y.findViewById(android.support.v7.b.a.f.decor_content_parent);
            n.setWindowCallback(super.b.getCallback());
            if (h)
            {
                n.a(9);
            }
            if (B)
            {
                n.a(2);
            }
            if (C)
            {
                n.a(5);
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i)
        {
            y = (ViewGroup)((LayoutInflater) (obj)).inflate(android.support.v7.b.a.h.abc_screen_simple_overlay_action_mode, null);
        } else
        {
            y = (ViewGroup)((LayoutInflater) (obj)).inflate(android.support.v7.b.a.h.abc_screen_simple, null);
        }
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            android.support.v4.view.w.a(y, new s() {

                final l a;

                public final ak a(View view1, ak ak1)
                {
                    int i2 = ak1.b();
                    int j2 = android.support.v7.a.l.b(a, i2);
                    ak ak2 = ak1;
                    if (i2 != j2)
                    {
                        ak2 = ak1.a(ak1.a(), j2, ak1.c(), ak1.d());
                    }
                    return android.support.v4.view.w.a(view1, ak2);
                }

            
            {
                a = l.this;
                super();
            }
            });
        } else
        {
            ((i)y).setOnFitSystemWindowsListener(new android.support.v7.internal.widget.i.a() {

                final l a;

                public final void a(Rect rect)
                {
                    rect.top = android.support.v7.a.l.b(a, rect.top);
                }

            
            {
                a = l.this;
                super();
            }
            });
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (n == null)
        {
            z = (TextView)y.findViewById(android.support.v7.b.a.f.title);
        }
        android.support.v7.internal.widget.t.b(y);
        Object obj1 = (ViewGroup)b.findViewById(0x1020002);
        ContentFrameLayout contentframelayout = (ContentFrameLayout)y.findViewById(android.support.v7.b.a.f.action_bar_activity_content);
        View view;
        for (; ((ViewGroup) (obj1)).getChildCount() > 0; contentframelayout.addView(view))
        {
            view = ((ViewGroup) (obj1)).getChildAt(0);
            ((ViewGroup) (obj1)).removeViewAt(0);
        }

        b.setContentView(y);
        ((ViewGroup) (obj1)).setId(-1);
        contentframelayout.setId(0x1020002);
        if (obj1 instanceof FrameLayout)
        {
            ((FrameLayout)obj1).setForeground(null);
        }
        int i1;
        int j1;
        int k1;
        int l1;
        if (super.c instanceof Activity)
        {
            obj1 = ((Activity)super.c).getTitle();
        } else
        {
            obj1 = super.l;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            b(((CharSequence) (obj1)));
        }
        i1 = x.getPaddingLeft();
        j1 = x.getPaddingTop();
        k1 = x.getPaddingRight();
        l1 = x.getPaddingBottom();
        contentframelayout.a.set(i1, j1, k1, l1);
        if (android.support.v4.view.w.u(contentframelayout))
        {
            contentframelayout.requestLayout();
        }
        obj1 = a.obtainStyledAttributes(android.support.v7.b.a.k.Theme);
        ((TypedArray) (obj1)).getValue(android.support.v7.b.a.k.Theme_windowMinWidthMajor, contentframelayout.getMinWidthMajor());
        ((TypedArray) (obj1)).getValue(android.support.v7.b.a.k.Theme_windowMinWidthMinor, contentframelayout.getMinWidthMinor());
        if (((TypedArray) (obj1)).hasValue(android.support.v7.b.a.k.Theme_windowFixedWidthMajor))
        {
            ((TypedArray) (obj1)).getValue(android.support.v7.b.a.k.Theme_windowFixedWidthMajor, contentframelayout.getFixedWidthMajor());
        }
        if (((TypedArray) (obj1)).hasValue(android.support.v7.b.a.k.Theme_windowFixedWidthMinor))
        {
            ((TypedArray) (obj1)).getValue(android.support.v7.b.a.k.Theme_windowFixedWidthMinor, contentframelayout.getFixedWidthMinor());
        }
        if (((TypedArray) (obj1)).hasValue(android.support.v7.b.a.k.Theme_windowFixedHeightMajor))
        {
            ((TypedArray) (obj1)).getValue(android.support.v7.b.a.k.Theme_windowFixedHeightMajor, contentframelayout.getFixedHeightMajor());
        }
        if (((TypedArray) (obj1)).hasValue(android.support.v7.b.a.k.Theme_windowFixedHeightMinor))
        {
            ((TypedArray) (obj1)).getValue(android.support.v7.b.a.k.Theme_windowFixedHeightMinor, contentframelayout.getFixedHeightMinor());
        }
        ((TypedArray) (obj1)).recycle();
        contentframelayout.requestLayout();
        w = true;
        obj1 = e(0);
        if (!super.m && (obj1 == null || ((d) (obj1)).j == null))
        {
            f(8);
        }
    }

    private void m()
    {
        if (w)
        {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        } else
        {
            return;
        }
    }

    final d a(Menu menu)
    {
        d ad[] = E;
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

    public final android.support.v7.e.a a(android.support.v7.e.a.a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (o != null)
        {
            o.c();
        }
        a1 = new b(a1);
        android.support.v7.a.a a2 = a();
        if (a2 != null)
        {
            o = a2.a(a1);
            if (o != null && e != null)
            {
                e.onSupportActionModeStarted(o);
            }
        }
        if (o == null)
        {
            o = b(a1);
        }
        return o;
    }

    public final View a(View view, String s1, Context context, AttributeSet attributeset)
    {
        boolean flag = false;
        Object obj = b(view, s1, context, attributeset);
        if (obj != null)
        {
            return ((View) (obj));
        }
        byte byte0;
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (K == null)
        {
            K = new android.support.v7.internal.a.a();
        }
        if (flag1 && w && view != null && view.getId() != 0x1020002 && !android.support.v4.view.w.v(view))
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        obj = K;
        if (byte0 != 0 && view != null)
        {
            view = view.getContext();
        } else
        {
            view = context;
        }
        view = android.support.v7.internal.a.a.a(view, attributeset, flag1);
        s1.hashCode();
        JVM INSTR lookupswitch 10: default 212
    //                   -1946472170: 413
    //                   -1455429095: 364
    //                   -1346021293: 396
    //                   -938935918: 447
    //                   -339785223: 316
    //                   776382189: 348
    //                   1413872058: 380
    //                   1601505219: 332
    //                   1666676343: 299
    //                   2001146706: 430;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        byte0 = -1;
_L13:
        switch (byte0)
        {
        default:
            if (context != view)
            {
                return ((android.support.v7.internal.a.a) (obj)).a(view, s1, attributeset);
            } else
            {
                return null;
            }

        case 0: // '\0'
            return new android.support.v7.widget.g(view, attributeset);

        case 1: // '\001'
            return new android.support.v7.widget.k(view, attributeset);

        case 2: // '\002'
            return new android.support.v7.widget.e(view, attributeset);

        case 3: // '\003'
            return new android.support.v7.widget.i(view, attributeset);

        case 4: // '\004'
            return new android.support.v7.widget.f(view, attributeset);

        case 5: // '\005'
            return new android.support.v7.widget.c(view, attributeset);

        case 6: // '\006'
            return new h(view, attributeset);

        case 7: // '\007'
            return new j(view, attributeset);

        case 8: // '\b'
            return new android.support.v7.widget.d(view, attributeset);

        case 9: // '\t'
            return new android.support.v7.widget.l(view, attributeset);
        }
_L10:
        if (!s1.equals("EditText")) goto _L1; else goto _L12
_L12:
        byte0 = flag;
          goto _L13
_L6:
        if (!s1.equals("Spinner")) goto _L1; else goto _L14
_L14:
        byte0 = 1;
          goto _L13
_L9:
        if (!s1.equals("CheckBox")) goto _L1; else goto _L15
_L15:
        byte0 = 2;
          goto _L13
_L7:
        if (!s1.equals("RadioButton")) goto _L1; else goto _L16
_L16:
        byte0 = 3;
          goto _L13
_L3:
        if (!s1.equals("CheckedTextView")) goto _L1; else goto _L17
_L17:
        byte0 = 4;
          goto _L13
_L8:
        if (!s1.equals("AutoCompleteTextView")) goto _L1; else goto _L18
_L18:
        byte0 = 5;
          goto _L13
_L4:
        if (!s1.equals("MultiAutoCompleteTextView")) goto _L1; else goto _L19
_L19:
        byte0 = 6;
          goto _L13
_L2:
        if (!s1.equals("RatingBar")) goto _L1; else goto _L20
_L20:
        byte0 = 7;
          goto _L13
_L11:
        if (!s1.equals("Button")) goto _L1; else goto _L21
_L21:
        byte0 = 8;
          goto _L13
_L5:
        if (!s1.equals("TextView")) goto _L1; else goto _L22
_L22:
        byte0 = 9;
          goto _L13
    }

    public final void a(int i1)
    {
        l();
        ViewGroup viewgroup = (ViewGroup)y.findViewById(0x1020002);
        viewgroup.removeAllViews();
        LayoutInflater.from(a).inflate(i1, viewgroup);
        c.onContentChanged();
    }

    final void a(int i1, d d1, Menu menu)
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
                    if (i1 < E.length)
                    {
                        d2 = E[i1];
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
            if ((d1 = super.b.getCallback()) != null)
            {
                d1.onPanelClosed(i1, ((Menu) (obj)));
                return;
            }
        }
    }

    public final void a(Configuration configuration)
    {
        if (g && w)
        {
            android.support.v7.a.a a1 = a();
            if (a1 != null)
            {
                a1.a(configuration);
            }
        }
    }

    public final void a(Bundle bundle)
    {
label0:
        {
            super.a(bundle);
            x = (ViewGroup)b.getDecorView();
            if ((c instanceof Activity) && android.support.v4.app.q.c((Activity)c) != null)
            {
                bundle = super.f;
                if (bundle != null)
                {
                    break label0;
                }
                H = true;
            }
            return;
        }
        bundle.c(true);
    }

    final void a(d d1, boolean flag)
    {
        if (flag && d1.a == 0 && n != null && n.b())
        {
            b(d1.j);
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
            if (F == d1)
            {
                F = null;
                return;
            }
        }
    }

    public final void a(f f1)
    {
        if (n == null || !n.a() || aa.b(ViewConfiguration.get(a)) && !n.c())
        {
            break MISSING_BLOCK_LABEL_208;
        }
        f1 = super.b.getCallback();
        if (n.b()) goto _L2; else goto _L1
_L1:
        if (f1 != null && !super.m)
        {
            if (s && (t & 1) != 0)
            {
                x.removeCallbacks(G);
                G.run();
            }
            d d1 = e(0);
            if (d1.j != null && !d1.r && f1.onPreparePanel(0, d1.i, d1.j))
            {
                f1.onMenuOpened(8, d1.j);
                n.d();
            }
        }
_L4:
        return;
_L2:
        n.e();
        if (super.m) goto _L4; else goto _L3
_L3:
        f1.onPanelClosed(8, e(0).j);
        return;
        f1 = e(0);
        f1.q = true;
        a(((d) (f1)), false);
        a(((d) (f1)), ((KeyEvent) (null)));
        return;
    }

    public final void a(Toolbar toolbar)
    {
        if (!(c instanceof Activity))
        {
            return;
        }
        if (a() instanceof android.support.v7.internal.a.d)
        {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        } else
        {
            toolbar = new android.support.v7.internal.a.c(toolbar, ((Activity)a).getTitle(), d);
            super.f = toolbar;
            b.setCallback(((android.support.v7.internal.a.c) (toolbar)).c);
            toolbar.g();
            return;
        }
    }

    public final void a(View view)
    {
        l();
        ViewGroup viewgroup = (ViewGroup)y.findViewById(0x1020002);
        viewgroup.removeAllViews();
        viewgroup.addView(view);
        c.onContentChanged();
    }

    public final void a(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        l();
        ViewGroup viewgroup = (ViewGroup)y.findViewById(0x1020002);
        viewgroup.removeAllViews();
        viewgroup.addView(view, layoutparams);
        c.onContentChanged();
    }

    final boolean a(int i1, KeyEvent keyevent)
    {
        android.support.v7.a.a a1 = a();
        if (a1 == null || !a1.a(i1, keyevent)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (F == null || !a(F, keyevent.getKeyCode(), keyevent))
        {
            break; /* Loop/switch isn't completed */
        }
        if (F != null)
        {
            F.n = true;
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag;
        if (F != null)
        {
            break; /* Loop/switch isn't completed */
        }
        d d1 = e(0);
        b(d1, keyevent);
        flag = a(d1, keyevent.getKeyCode(), keyevent);
        d1.m = false;
        if (flag) goto _L1; else goto _L4
_L4:
        return false;
    }

    public final boolean a(f f1, MenuItem menuitem)
    {
        android.view.Window.Callback callback = super.b.getCallback();
        if (callback != null && !super.m)
        {
            f1 = a(((Menu) (f1.k())));
            if (f1 != null)
            {
                return callback.onMenuItemSelected(((d) (f1)).a, menuitem);
            }
        }
        return false;
    }

    final boolean a(KeyEvent keyevent)
    {
        int i1;
        i1 = keyevent.getKeyCode();
        boolean flag;
        if (keyevent.getAction() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 82 82: default 40
    //                   82 61;
           goto _L3 _L4
_L3:
        d d1;
        boolean flag2;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            return a(i1, keyevent);
        } else
        {
            return false;
        }
_L4:
        if (keyevent.getRepeatCount() != 0) goto _L6; else goto _L5
_L5:
        d1 = e(0);
        if (d1.o) goto _L6; else goto _L7
_L7:
        flag2 = b(d1, keyevent);
_L8:
        if (flag2)
        {
            return true;
        }
          goto _L3
_L6:
        flag2 = false;
          goto _L8
_L2:
        i1;
        JVM INSTR lookupswitch 2: default 132
    //                   4: 346
    //                   82: 134;
           goto _L9 _L10 _L11
_L9:
        return false;
_L11:
        if (o == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = false;
_L13:
        if (flag2)
        {
            return true;
        }
        if (true) goto _L9; else goto _L12
_L12:
        d d2 = e(0);
        if (n != null && n.a() && !aa.b(ViewConfiguration.get(a)))
        {
            if (!n.b())
            {
                if (super.m || !b(d2, keyevent))
                {
                    break MISSING_BLOCK_LABEL_419;
                }
                flag2 = n.d();
            } else
            {
                flag2 = n.e();
            }
        } else
        if (d2.o || d2.n)
        {
            flag2 = d2.o;
            a(d2, true);
        } else
        {
            if (!d2.m)
            {
                break MISSING_BLOCK_LABEL_419;
            }
            boolean flag1;
            if (d2.r)
            {
                d2.m = false;
                flag2 = b(d2, keyevent);
            } else
            {
                flag2 = true;
            }
            if (!flag2)
            {
                break MISSING_BLOCK_LABEL_419;
            }
            a(d2, keyevent);
            flag2 = true;
        }
_L14:
        if (flag2)
        {
            keyevent = (AudioManager)a.getSystemService("audio");
            if (keyevent != null)
            {
                keyevent.playSoundEffect(0);
            }
        }
          goto _L13
_L10:
        keyevent = e(0);
        if (keyevent != null && ((d) (keyevent)).o)
        {
            a(((d) (keyevent)), true);
            return true;
        }
        if (o != null)
        {
            o.c();
            flag1 = true;
        } else
        {
            keyevent = a();
            if (keyevent != null && keyevent.h())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1)
        {
            return true;
        }
          goto _L9
        flag2 = false;
          goto _L14
    }

    final android.support.v7.e.a b(android.support.v7.e.a.a a1)
    {
        b b1;
        if (o != null)
        {
            o.c();
        }
        b1 = new b(a1);
        if (e == null || super.m)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        Object obj = e.onWindowStartingSupportActionMode(b1);
_L1:
        if (obj != null)
        {
            o = ((android.support.v7.e.a) (obj));
        } else
        {
            if (p == null)
            {
                if (j)
                {
                    Object obj2 = new TypedValue();
                    Object obj1 = a.getTheme();
                    ((android.content.res.Resources.Theme) (obj1)).resolveAttribute(android.support.v7.b.a.a.actionBarTheme, ((TypedValue) (obj2)), true);
                    int i1;
                    if (((TypedValue) (obj2)).resourceId != 0)
                    {
                        android.content.res.Resources.Theme theme = a.getResources().newTheme();
                        theme.setTo(((android.content.res.Resources.Theme) (obj1)));
                        theme.applyStyle(((TypedValue) (obj2)).resourceId, true);
                        obj1 = new android.support.v7.internal.view.b(a, 0);
                        ((Context) (obj1)).getTheme().setTo(theme);
                    } else
                    {
                        obj1 = a;
                    }
                    p = new ActionBarContextView(((Context) (obj1)));
                    q = new PopupWindow(((Context) (obj1)), null, android.support.v7.b.a.a.actionModePopupWindowStyle);
                    q.setContentView(p);
                    q.setWidth(-1);
                    ((Context) (obj1)).getTheme().resolveAttribute(android.support.v7.b.a.a.actionBarSize, ((TypedValue) (obj2)), true);
                    i1 = TypedValue.complexToDimensionPixelSize(((TypedValue) (obj2)).data, ((Context) (obj1)).getResources().getDisplayMetrics());
                    p.setContentHeight(i1);
                    q.setHeight(-2);
                    r = new Runnable() {

                        final l a;

                        public final void run()
                        {
                            a.q.showAtLocation(a.p, 55, 0, 0);
                        }

            
            {
                a = l.this;
                super();
            }
                    };
                } else
                {
                    ViewStubCompat viewstubcompat = (ViewStubCompat)y.findViewById(android.support.v7.b.a.f.action_mode_bar_stub);
                    if (viewstubcompat != null)
                    {
                        viewstubcompat.setLayoutInflater(LayoutInflater.from(k()));
                        p = (ActionBarContextView)viewstubcompat.a();
                    }
                }
            }
            if (p != null)
            {
                p.c();
                obj1 = p.getContext();
                obj2 = p;
                boolean flag;
                if (q == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj1 = new android.support.v7.internal.view.c(((Context) (obj1)), ((ActionBarContextView) (obj2)), b1, flag);
                if (a1.a(((android.support.v7.e.a) (obj1)), ((android.support.v7.e.a) (obj1)).b()))
                {
                    ((android.support.v7.e.a) (obj1)).d();
                    p.a(((android.support.v7.e.a) (obj1)));
                    p.setVisibility(0);
                    o = ((android.support.v7.e.a) (obj1));
                    if (q != null)
                    {
                        b.getDecorView().post(r);
                    }
                    p.sendAccessibilityEvent(32);
                    if (p.getParent() != null)
                    {
                        android.support.v4.view.w.q((View)p.getParent());
                    }
                } else
                {
                    o = null;
                }
            }
        }
        if (o != null && e != null)
        {
            e.onSupportActionModeStarted(o);
        }
        return o;
        obj;
        obj = null;
          goto _L1
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

    final void b(f f1)
    {
        if (D)
        {
            return;
        }
        D = true;
        n.g();
        android.view.Window.Callback callback = super.b.getCallback();
        if (callback != null && !super.m)
        {
            callback.onPanelClosed(8, f1);
        }
        D = false;
    }

    public final void b(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        l();
        ((ViewGroup)y.findViewById(0x1020002)).addView(view, layoutparams);
        c.onContentChanged();
    }

    final void b(CharSequence charsequence)
    {
        if (n != null)
        {
            n.setWindowTitle(charsequence);
        } else
        {
            if (super.f != null)
            {
                super.f.b(charsequence);
                return;
            }
            if (z != null)
            {
                z.setText(charsequence);
                return;
            }
        }
    }

    public final boolean b(int i1)
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
            m();
            g = true;
            return true;

        case 9: // '\t'
            m();
            h = true;
            return true;

        case 10: // '\n'
            m();
            i = true;
            return true;

        case 2: // '\002'
            m();
            B = true;
            return true;

        case 5: // '\005'
            m();
            C = true;
            return true;

        case 1: // '\001'
            m();
            k = true;
            return true;
        }
    }

    public final void c()
    {
        l();
    }

    final boolean c(int i1)
    {
        boolean flag1 = false;
        boolean flag;
        if (i1 == 8)
        {
            android.support.v7.a.a a1 = a();
            if (a1 != null)
            {
                a1.e(false);
            }
            flag = true;
        } else
        {
            flag = flag1;
            if (i1 == 0)
            {
                d d1 = e(i1);
                flag = flag1;
                if (d1.o)
                {
                    a(d1, false);
                    return false;
                }
            }
        }
        return flag;
    }

    public final void d()
    {
        android.support.v7.a.a a1 = a();
        if (a1 != null)
        {
            a1.d(false);
        }
    }

    final boolean d(int i1)
    {
        if (i1 == 8)
        {
            android.support.v7.a.a a1 = a();
            if (a1 != null)
            {
                a1.e(true);
            }
            return true;
        } else
        {
            return false;
        }
    }

    final d e(int i1)
    {
        d ad[];
label0:
        {
            d ad1[] = E;
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
            E = ad;
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

    public final void e()
    {
        android.support.v7.a.a a1 = a();
        if (a1 != null)
        {
            a1.d(true);
        }
    }

    public final void f()
    {
        android.support.v7.a.a a1 = a();
        if (a1 != null && a1.g())
        {
            return;
        } else
        {
            f(0);
            return;
        }
    }

    public final void i()
    {
        LayoutInflater layoutinflater = LayoutInflater.from(a);
        if (layoutinflater.getFactory() == null)
        {
            android.support.v4.view.h.a(layoutinflater, this);
        }
    }

    public final android.support.v7.a.a j()
    {
        android.support.v7.internal.a.d d1;
        l();
        d1 = null;
        if (!(c instanceof Activity)) goto _L2; else goto _L1
_L1:
        d1 = new android.support.v7.internal.a.d((Activity)c, h);
_L4:
        if (d1 != null)
        {
            d1.c(H);
        }
        return d1;
_L2:
        if (c instanceof Dialog)
        {
            d1 = new android.support.v7.internal.a.d((Dialog)c);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
